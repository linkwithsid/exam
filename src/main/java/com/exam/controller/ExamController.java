/**
 * 
 */
package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.SearchPageModel;
import com.exam.service.ExamService;

/**
 * @author Siddharth
 *
 */
@Controller
@RequestMapping("/exam")
public class ExamController {
	

	@Autowired
	ExamService examService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView getSearchPage() {
		return new ModelAndView("searchpage", "command", new SearchPageModel());
	}
	
	@RequestMapping(value = "/searchresult", method = RequestMethod.POST)
	public String search(@ModelAttribute("SpringWeb")SearchPageModel searchQuery, 
			   ModelMap model) {
		if (StringUtils.isEmpty(searchQuery.getName()) || StringUtils.isEmpty(searchQuery.getFrom())
				|| StringUtils.isEmpty(searchQuery.getTo()) || StringUtils.isEmpty(searchQuery.getDate())){
			model.addAttribute("command", searchQuery);
			return "searchpage";
		}
		List<SearchPageModel> searchResultList = examService.search(searchQuery);
		model.addAttribute("searchResultList",searchResultList);
		return "searchresultpage";
	}
	
	@RequestMapping(value = "/addevent", method = RequestMethod.GET)
	public ModelAndView getAddPage() {
		return new ModelAndView("addpage", "command", new SearchPageModel());
	}
	
	@RequestMapping(value = "/addevent", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("SpringWeb")SearchPageModel addQuery, 
			   ModelMap model) {
		List<SearchPageModel> searchResultList = examService.addUser(addQuery);
		return new ModelAndView("searchresultpage", "searchResultList", searchResultList);
	}
}
