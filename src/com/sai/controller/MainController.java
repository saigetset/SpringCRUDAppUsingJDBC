package com.sai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sai.dto.EmployeeDTO;
import com.sai.service.IEmployeeService;
import com.sai.vo.EmployeeVO;

@Component(value = "controller")
public class MainController {
	
	static {
		System.out.println("MainController.class file loaded");
	}
	public MainController() {
		System.out.println("MainController.MainController()");
	}

	@Autowired
	private IEmployeeService service;

	public String insert(EmployeeVO vo) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(Integer.parseInt(vo.getId()));
		dto.setName(vo.getName());
		dto.setAge(Integer.parseInt(vo.getAge()));
		dto.setCity(vo.getCity());
		int val = service.insert(dto);
		if (val == 1)
			return "success";
		else
			return "failed";
	}

	public String search(int id) {
		EmployeeDTO dto = service.search(id);
		EmployeeVO vo;
		if (dto == null)
			return "Record not found";
		else
			vo = new EmployeeVO();
			vo.setId(String.valueOf(dto.getId()));
			vo.setName(dto.getName());
			vo.setAge(String.valueOf(dto.getAge()));
			vo.setCity(dto.getCity());
			return vo.toString();
	}
	
}
