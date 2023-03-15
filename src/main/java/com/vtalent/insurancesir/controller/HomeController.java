package com.vtalent.insurancesir.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtalent.insurancesir.dao.ZipRepository;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ZipRepository zipRepo;

	@GetMapping
	public String init(HttpServletRequest request, HttpServletResponse response) {
		return "home";
	}

	


}
