package com.weather.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "forecast")
public class Forecast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer forecastId;
@Column
	private LocalDate date;
@Column
	private Double tempreture;
@Column
	private Double speed;
@Column(length=20)
	private String wCondition;
@Column(length=20)
	private String location;

	public Forecast() {
		super();
		
	}

	@Override
	public String toString() {
		return "Forecast [forecastId=" + forecastId + ", date=" + date + ", tempreture=" + tempreture + ", speed="
				+ speed + ", wCondition=" + wCondition + ", location=" + location + "]";
	}

	public Forecast(Integer forecastId, LocalDate date, Double tempreture, Double speed, String wCondition,
			String location) {
		super();
		this.forecastId = forecastId;
		this.date = date;
		this.tempreture = tempreture;
		this.speed = speed;
		this.wCondition = wCondition;
		this.location = location;
	}

	public Integer getForecastId() {
		return forecastId;
	}

	public void setForecastId(Integer forecastId) {
		this.forecastId = forecastId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTempreture() {
		return tempreture;
	}

	public void setTempreture(Double tempreture) {
		this.tempreture = tempreture;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public String getwCondition() {
		return wCondition;
	}

	public void setwCondition(String wCondition) {
		this.wCondition = wCondition;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}