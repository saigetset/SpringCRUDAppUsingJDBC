package com.sai.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.bo.EmployeeBO;
import com.sai.dto.EmployeeDTO;
import com.sai.model.IEmployeeDAO;

@Service(value="service")
public class EmployeeServiceImpl implements IEmployeeService {
	
	static {
		System.out.println("EmployeeServiceImpl.class file loaded");
	}
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl.EmployeeServiceImpl()");
	}
	
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public int insert(EmployeeDTO dto) {
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		int val = dao.insert(bo);
		return val;
	}

	@Override
	public EmployeeDTO search(int id) {
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeBO bo = dao.search(id);
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
}
