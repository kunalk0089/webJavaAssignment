package com.airline.services;
import example.airline.dao.BookingDao;
import java.util.List;


import com.airline.entiry.Booking;

public class BookingService {
	private BookingDao bdao;

	public BookingService() {
		bdao = new BookingDao();
	}

	public boolean bookingFlights(int cid, int fid) {

		return bdao.saveBooking(cid, fid);
	}

	public List<Booking> ShowBooking(int cid) {

		return bdao.findById(cid);
	}

	public boolean delete(int fid) {
		return bdao.removeBooking(fid);
	}
}
