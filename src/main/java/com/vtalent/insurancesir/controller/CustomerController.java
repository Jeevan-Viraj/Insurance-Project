package com.vtalent.insurancesir.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vtalent.insurancesir.dao.CustomerRepository;
import com.vtalent.insurancesir.dao.ZipRepository;
import com.vtalent.insurancesir.model.Customer;
import com.vtalent.insurancesir.model.UsaZipInfo;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ZipRepository zipRepo;
	
	@Autowired
	private CustomerRepository cusRepo;
	
	@GetMapping("/")
	public ModelAndView init(HttpServletRequest req, HttpServletResponse res) {
	    ModelAndView model = new ModelAndView("customer");
	    Customer customer = new Customer();
	    model.addObject("customer", customer);
	    return model;
	}
	
	@GetMapping("/get")
	public ModelAndView get(HttpServletRequest req, HttpServletResponse res) {
	    String zp = req.getParameter("zip");
	    UsaZipInfo zipcode = zipRepo.findByZipCode(zp);
	    
	    ModelAndView model = new ModelAndView("customer");
	    Customer customer = new Customer();
	    if(zipcode != null) {
	    	customer.setZip(zipcode.getZipCode());
		    customer.setCity(zipcode.getCity());
		    customer.setState(zipcode.getState());
	    }
	    
	    model.addObject("customer", customer);
	    return model;
	}
	
	@PostMapping("/success")
	public String success(@ModelAttribute("customer") Customer customer) {
		cusRepo.save(customer);
		return "vehicle";
	}
	
	@PostMapping("/onchange")
	public @ResponseBody UsaZipInfo onchange(@RequestBody Customer customer) {
		String zip = customer.getZip();
		return Objects.requireNonNull(zipRepo.findByZipCode(zip));
	}
	

}
