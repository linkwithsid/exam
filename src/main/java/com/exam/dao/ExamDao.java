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

import com.exam.model.SearchPageModel;

/**
 * @author Siddharth
 *
 */
@Service
public class ExamDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate; 

	public List<SearchPageModel> search(SearchPageModel searchQuery) {
		List<SearchPageModel> searchResultList = new ArrayList<SearchPageModel>();
		String sql = "SELECT start_point , exam_center  , exam_date , user_name , contact_info FROM event WHERE exam_center = ? AND exam_date = ?";
		Object[] parameters = {searchQuery.getCenterAddress(), searchQuery.getExamDate()};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, parameters);
		for (Map<String, Object> row : rows) {
			SearchPageModel searchResult = new SearchPageModel();
			searchResult.setStartPoint((String) row.get("start_point"));
			searchResult.setCenterAddress((String) row.get("exam_center"));
			searchResult.setExamDate((String) row.get("exam_date"));
			searchResult.setName((String) row.get("user_name"));
			searchResult.setContactNumber((String) row.get("contact_info"));
			searchResultList.add(searchResult);
		}

		return searchResultList;
	}

	public boolean addUser(SearchPageModel addQuery) {
		String sql = "INSERT INTO event VALUES(?,?,?,?,?,?)";
		Object[] parameters = { addQuery.getStartPoint(), addQuery.getCenterAddress(), 
				addQuery.getExamDate(),	addQuery.getName(), 
				addQuery.getContactNumber(), addQuery.getPassword()};
		int flag = jdbcTemplate.update(sql , parameters);
		if(flag>0){
			return true;
		}
		else{
			return false;
		}
	}

}
