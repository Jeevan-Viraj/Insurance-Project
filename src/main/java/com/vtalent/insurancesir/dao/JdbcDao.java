package com.vtalent.insurancesir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vtalent.insurancesir.model.CarCompany;
import com.vtalent.insurancesir.model.CarStyle;
import com.vtalent.insurancesir.model.Year;

@Repository
public class JdbcDao {

	@Autowired
	JdbcTemplate jdbc;
	Connection con;
	PreparedStatement pst;
	String query;
	ResultSet rs;

	public Connection getConnection(JdbcTemplate jdbctemplate) throws SQLException {
		return jdbctemplate.getDataSource().getConnection();
	}

	public List<Year> getAllYear() {
		List<Year> list = new ArrayList<>();
		try {
			con = getConnection(jdbc);
			query = "select * from year";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Year year = new Year();
				year.setId(rs.getInt("id"));
				year.setYear(rs.getString("year"));
				list.add(year);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.print(list);
		return list;
	}

	public List<CarCompany> getCarCompanyByYearId(int yearId) {
		List<CarCompany> list = new ArrayList<>();
		try {
			con = getConnection(jdbc);
			query = "select * from car_company where year_id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, yearId);
			rs = pst.executeQuery();
			while (rs.next()) {
				CarCompany carcompany = new CarCompany();
				carcompany.setId(rs.getInt("id"));
				carcompany.setYearId(rs.getInt("year_id"));
				carcompany.setCarCompany(rs.getString("car_company"));
				list.add(carcompany);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<CarStyle> getCarStyleByCarCompanyId(int carCompanyId) {
		List<CarStyle> list = new ArrayList<>();
		try {
			con = getConnection(jdbc);
			query = "select * from car_style where car_company_id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, carCompanyId);
			rs = pst.executeQuery();
			while (rs.next()) {
				CarStyle city = new CarStyle();
				city.setId(rs.getInt("id"));
				city.setYearId(rs.getInt("year_id"));
				city.setCarCompanyId(rs.getInt("car_company_id"));
				city.setCarStyle(rs.getString("car_style"));
				list.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
