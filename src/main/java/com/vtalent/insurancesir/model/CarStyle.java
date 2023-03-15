package com.vtalent.insurancesir.model;

import javax.persistence.*;

@Entity
@Table(name = "car_style")
public class CarStyle implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private int carCompanyId;
	private int yearId;
	private String carStyle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarCompanyId() {
		return carCompanyId;
	}

	public void setCarCompanyId(int carCompanyId) {
		this.carCompanyId = carCompanyId;
	}

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public String getCarStyle() {
		return carStyle;
	}

	public void setCarStyle(String carStyle) {
		this.carStyle = carStyle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
