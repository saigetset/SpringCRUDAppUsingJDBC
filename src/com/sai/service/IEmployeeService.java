package com.sai.service;

import com.sai.dto.EmployeeDTO;

public interface IEmployeeService {
	public int insert(EmployeeDTO dto);
	public EmployeeDTO search(int id);
}
