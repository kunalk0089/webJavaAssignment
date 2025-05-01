package com.weather.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.weather.entity.Forecast;
import com.weather.repo.ForecastRepo;

@Service
public class ForecastService {
	@Autowired
	ForecastRepo fr;
	public List<Forecast> showAll()
	{
		List<Forecast> f=fr.findAll();
	if(CollectionUtils.isEmpty(f))
			{
		throw new ResourceNotFoundException("No Record To Show!!!");
			}
	else
		return
				f;
	}
	public boolean saveForecast(Forecast forecast)
	{
		
		Forecast f=fr.save(forecast);
		if(ObjectUtils.isEmpty(f))
		{
			return false;
		}
		else 
			return true;
	}
	public Forecast getOne(Integer id)
	{
	  Optional<Forecast>forcast=fr.findById(id);
	  if(forcast.isEmpty())
	  {
		  throw new ResourceNotFoundException("Forecast With Given Id Not Found!!");
	  }
	  Forecast f=forcast.get();
	  return f;
	   
	}
	
	
	public List<Forecast> getByDate(LocalDate date)
	{
		List<Forecast> f=fr.getByDate(date);
		if(CollectionUtils.isEmpty(f))
		{
			throw new ResourceNotFoundException("Forecast With Given date Not Found!!");
		}
		return f;
	}
}
