package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.customerInfoDTO;
import com.nt.service.CustomerInfoService;

public class DeleteCustomerController extends AbstractController {

	private CustomerInfoService service;
	
	
	public DeleteCustomerController(CustomerInfoService service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		    String resultMsg=null;
			ModelAndView mav=null;
			List<customerInfoDTO> listDTO=null;
			//use Service
			resultMsg=service.removeCustomerByCno(Integer.parseInt(req.getParameter("cno")));
			listDTO=service.findAllCustomers();
			//return MAV
			mav=new ModelAndView();
			mav.addObject("msg",resultMsg);
			mav.addObject("reportData",listDTO);
			mav.setViewName("report_cust");
			return mav;
		}
	
}


