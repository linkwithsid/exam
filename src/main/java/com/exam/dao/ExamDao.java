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
		String sql = "select * from event where ending = '"
				+ searchQuery.getTo() + "' and doj ='" + searchQuery.getDate() + "'";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			SearchPageModel searchResult = new SearchPageModel();
			searchResult.setName((String) row.get("user_name"));
			searchResult.setFrom((String) row.get("start_point"));
			searchResult.setTo((String) row.get("ending"));
			searchResult.setDate((String) row.get("doj"));
			searchResultList.add(searchResult);
		}

		return searchResultList;
	}

	public boolean addUser(SearchPageModel addQuery) {
		/*Object[] parameters = {addQuery.getFrom(), addQuery.getTo(),
			addQuery.getDate()};*/
		String sql = "INSERT INTO event VALUES('"+addQuery.getName()+ "','"+addQuery.getFrom()+ "','"+addQuery.getTo()+"','"+addQuery.getDate()+"')";
		
		int flag = jdbcTemplate.update(sql);
		if(flag>0){
			return true;
		}
		else{
			return false;
		}
	}

}
