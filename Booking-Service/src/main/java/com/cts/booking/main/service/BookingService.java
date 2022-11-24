package com.cts.booking.main.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.booking.main.dao.BookingDao;
import com.cts.booking.main.dto.BookingDTO;
import com.cts.booking.main.entity.Bookings;
import com.cts.booking.main.exception.BookingException;

@Service
public class BookingService {

	
	@Autowired
	private BookingDao bookingDao;
	
	public Bookings addBooking(BookingDTO booking,int count) throws BookingException {
		
		LocalDate todayDate = LocalDate.now();
		LocalDate bookingDate = booking.getBookingDate().toLocalDateTime().toLocalDate();
		if(todayDate.isAfter(bookingDate)) {
			throw new BookingException("Please select a future date");
		}
		Bookings bookings = new Bookings();
		bookings.setPlayerId(booking.getPlayerId());
		bookings.setPlayerName(booking.getPlayerName());
		bookings.setSportsId(booking.getSportsId());
		bookings.setSportsName(booking.getSportsName());
		bookings.setTime(booking.getTime());
		bookings.setBookingDate(bookingDate);
		long existingBookings = bookingDao.
				findByBookingDateAndSportsId(bookings.getBookingDate(), bookings.getSportsId()).stream().count();
		if(count<=(int)existingBookings) {
			throw new BookingException("no more slots available");
		}
		Bookings bookings1 = bookingDao.findByBookingDateAndSportsIdAndPlayerId
		(bookings.getBookingDate(), bookings.getSportsId(), bookings.getPlayerId());
		if(bookings1!=null) {
			throw new BookingException("You already have a booking for this time slot");
		}
		
		return bookingDao.saveAndFlush(bookings);
	}
	
	public List<Bookings> findByPlayerId(long id){
		return bookingDao.findByPlayerId(id);
	}
	
	
}
