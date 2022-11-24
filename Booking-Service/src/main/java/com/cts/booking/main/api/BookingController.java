package com.cts.booking.main.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.booking.main.dto.BookingDTO;
import com.cts.booking.main.dto.Response;
import com.cts.booking.main.dto.SportsDTO;
import com.cts.booking.main.entity.Bookings;
import com.cts.booking.main.exception.BookingException;
import com.cts.booking.main.service.BookingService;
import com.cts.booking.main.service.SportsRestService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	 Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private SportsRestService sportsService;
	
	@PostMapping("/addBooking")
	public Response addBooking(@RequestBody BookingDTO booking) {
		Response response = new Response();
		try {
			SportsDTO sports = sportsService.getSportsDetails(booking.getSportsId());
			booking.setSportsName(sports.getSportsName());
			booking.setTime(sports.getTime());
			Bookings bookings = bookingService.addBooking(booking,Integer.parseInt(sports.getTotalAvailableSlots()));
			response.setObj(bookings);
			response.setStatus("OK");
			response.setMsg("Booking successful");
			return response;
		} catch (BookingException e) {
			logger.error(e.getMessage());
			response.setObj(null);
			response.setStatus("ERROR");
			response.setMsg(e.getMessage());
			return response;
		}
	}
	
	@GetMapping("/get/{id}")
	public List<Bookings> getBooking(@PathVariable Long id){
		return bookingService.findByPlayerId(id);
	}
}
