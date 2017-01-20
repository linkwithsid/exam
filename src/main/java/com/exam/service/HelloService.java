package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.HelloDAO;
import com.exam.dao.model.Employee;

@Service
public class HelloService {
	
	@Autowired
	HelloDAO helloDAO;
	
	public List<Employee> getHelloResponse(){
		
		return helloDAO.getEmployeeDetails();
		
		}

}
