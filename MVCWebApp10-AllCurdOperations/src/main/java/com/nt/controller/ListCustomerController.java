package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.customerInfoDTO;
import com.nt.service.CustomerInfoService;

public class ListCustomerController extends AbstractController {

	
	private CustomerInfoService service;
	
	public ListCustomerController(CustomerInfoService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<customerInfoDTO> listDTO=null;
		//use Servic
		listDTO=service.findAllCustomers();
		//return MAV
		return new ModelAndView("report_cust","reportData",listDTO);
	}

}
