package com.vtalent.insurancesir.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "car_company")
public class CarCompany implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private int yearId;
	private String carCompany;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public String getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
