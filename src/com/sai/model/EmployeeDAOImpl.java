package com.sai.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.bo.EmployeeBO;
import com.zaxxer.hikari.HikariDataSource;

@Repository(value = "dao")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private String SQL_INSERT_QUERY = "Insert into Employee(id,name,age,city) values(?,?,?,?)";
	private String SQL_SELECT_QUERY = "Select * from Employee where id=?";

	static {
		System.out.println("EmployeeDAOImpl.class file loaded");
	}

	public EmployeeDAOImpl() {
		System.out.println("EmployeeDAOImpl.EmployeeDAOImpl()");
	}

	@Autowired
	private HikariDataSource dataSource;

	@Override
	public int insert(EmployeeBO bo) {
		int val = 0;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			pstmt.setInt(1, bo.getId());
			pstmt.setString(2, bo.getName());
			pstmt.setInt(3, bo.getAge());
			pstmt.setString(4, bo.getCity());
			val = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	@Override
	public EmployeeBO search(int id) {
		EmployeeBO bo = new EmployeeBO();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setAge(rs.getInt(3));
				bo.setCity(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

}
