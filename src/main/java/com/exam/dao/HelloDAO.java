/**
 * 
 */
package com.exam.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.exam.dao.model.Employee;

/**
 * @author Siddharth
 *
 */

@Service
public class HelloDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;  
	  
		public List<Employee> getEmployeeDetails() {
			List<Employee> employees = new ArrayList<Employee>();
			
				try {
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema1", "root", "");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");*/
					
					List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from emp");
					for (Map<String, Object> row : rows) {
						Employee employee = new Employee();
						employee.setId((int)row.get("id"));
						employee.setName((String)row.get("name"));
						employee.setAge((Integer)row.get("AGE"));
						employees.add(employee);
					}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return employees;
	}
}
