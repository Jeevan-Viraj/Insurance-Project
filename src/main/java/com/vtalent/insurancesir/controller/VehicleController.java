package com.vtalent.insurancesir.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;
import com.vtalent.insurancesir.dao.JdbcDao;
import com.vtalent.insurancesir.model.CarCompany;
import com.vtalent.insurancesir.model.CarStyle;
import com.vtalent.insurancesir.model.Year;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private JdbcDao jdbcdao;

	@GetMapping("/action")
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// try (PrintWriter out = response.getWriter()) {

		String op = request.getParameter("operation");

		if (op.equals("country")) {
			List<Year> clist = jdbcdao.getAllYear();
			Gson json = new Gson();
			// return json.toJson(clist);
			String countryList = json.toJson(clist);
			response.setContentType("text/html");
			response.getWriter().write(countryList);
			return countryList;
		}

		if (op.equals("state")) {
			int id = Integer.parseInt(request.getParameter("id"));
			List<CarCompany> slist = jdbcdao.getCarCompanyByYearId(id);
			Gson json = new Gson();
			// return json.toJson(slist);
			String stateList = json.toJson(slist);
			response.setContentType("text/html");
			response.getWriter().write(stateList);
			return stateList;
		}

		if (op.equals("city")) {
			int id = Integer.parseInt(request.getParameter("id"));
			List<CarStyle> citylist = jdbcdao.getCarStyleByCarCompanyId(id);
			Gson json = new Gson();
			// return json.toJson(citylist);
			String cityList = json.toJson(citylist);
			response.setContentType("text/html");
			response.getWriter().write(cityList);
			return cityList;
		}
		return null;
	}

	@PostMapping("/success")
	public String success(HttpServletRequest req, HttpServletResponse res) {
		return "driver";
	}

}
