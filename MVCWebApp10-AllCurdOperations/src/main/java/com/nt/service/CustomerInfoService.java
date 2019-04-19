package com.nt.service;

import java.util.List;

import com.nt.dto.customerInfoDTO;

public interface CustomerInfoService {
	public List<customerInfoDTO> findAllCustomers();
	public customerInfoDTO  findCustomerByCno(int cno);
	public  String  modifyCustomerByCno(customerInfoDTO dto);
	public String removeCustomerByCno(int cno);
	public String register(customerInfoDTO dto);

	
}
