package com.sai.model;

import com.sai.bo.EmployeeBO;

public interface IEmployeeDAO {
	public int insert(EmployeeBO bo);
	public EmployeeBO search(int id);
}
