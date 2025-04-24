package com.airline.services;

import java.time.LocalDate;
import java.util.List;

import com.airline.entiry.Flight;

import example.airline.dao.FlightDao;

public class FlightService
{
	private FlightDao flightDao;
	public FlightService()
	{
		flightDao=new FlightDao();
	}
	public List<Flight> searchFlight(String source,String destination,LocalDate date)
	{
		return flightDao.searchFlight(source, destination, date);
	}
}
