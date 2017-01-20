/**
 * 
 */
package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.exam.dao.ExamDao;
import com.exam.model.SearchPageModel;

/**
 * @author Siddharth
 *
 */
@Service
public class ExamService {
	
	@Autowired
	ExamDao examdao;

	public List<SearchPageModel> search(SearchPageModel searchQuery) {
		List<SearchPageModel> result = examdao.search(searchQuery);
		if(CollectionUtils.isEmpty(result)){
			result = addUser(searchQuery);
		}
		return result;
	}

	public List<SearchPageModel> addUser(SearchPageModel addQuery) {
		boolean successFlag = examdao.addUser(addQuery);
		if(successFlag){
			return search(addQuery);
		}
		return null;
	}

}
