package com.weather.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.entity.Forecast;
import com.weather.service.ForecastService;

@RestController
@RequestMapping("/weather")
public class ForecastController {
	@Autowired
	ForecastService fs;
	@GetMapping("/getall")
	public ResponseEntity<?>getAll()
	{
		try 
	{
	List<Forecast> forecasts=fs.showAll();
	return new ResponseEntity<>(forecasts, HttpStatus.OK);
		
	}catch(Exception e)
	{
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
		
	}
	@PostMapping("/save")
	public ResponseEntity<?>save(@RequestBody Forecast forcast)
	{
		System.out.println(forcast);
		if(fs.saveForecast(forcast))
		{
			return new ResponseEntity<>("Forcast Recorded Successfully!!!",HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<>("Forcast Insertion Failed!!!",HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<?>getOne(@PathVariable Integer id)
	{
		try {
			Forecast f=fs.getOne(id);
			if(ObjectUtils.isEmpty(f))
			{
				return new ResponseEntity<>("Not Found!!!",HttpStatus.NO_CONTENT);
			}
			else
				return new ResponseEntity<>(f,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/date/{date}")
	public ResponseEntity<?>getByDate(@PathVariable LocalDate date)
	{
		try {
			List<Forecast> f=fs.getByDate(date);
			return new ResponseEntity<>(f,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
