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
public class ExamController {

	@Autowired
	ExamService examService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView getSearchPage() {
		return new ModelAndView("searchpage", "command", new SearchPageModel());
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@ModelAttribute("SpringWeb") SearchPageModel searchQuery, ModelMap model) {
		if (StringUtils.isEmpty(searchQuery.getCenterAddress()) || StringUtils.isEmpty(searchQuery.getExamDate())) {
			model.addAttribute("command", searchQuery);
			model.addAttribute("error", "Please fill all values");
			return "searchpage";
		}
		List<SearchPageModel> searchResultList = examService.search(searchQuery);
		model.addAttribute("numOfResult", searchResultList.size());
		model.addAttribute("command", searchQuery);
		model.addAttribute("searchResultList", searchResultList);
		return "searchresultpage";
	}

	@RequestMapping(value = "/addevent", method = RequestMethod.GET)
	public ModelAndView getAddPage(@ModelAttribute("SpringWeb") SearchPageModel searchQuery, ModelMap model) {
		return new ModelAndView("addpage", "command", new SearchPageModel());
	}

	@RequestMapping(value = "/addevent", method = RequestMethod.POST)
	public String add(@ModelAttribute("SpringWeb") SearchPageModel addQuery, ModelMap model) {
		if (StringUtils.isEmpty(addQuery.getCenterAddress()) || StringUtils.isEmpty(addQuery.getContactNumber())
				|| StringUtils.isEmpty(addQuery.getExamDate()) || StringUtils.isEmpty(addQuery.getName())
				|| StringUtils.isEmpty(addQuery.getPassword()) || StringUtils.isEmpty(addQuery.getStartPoint())) {
			model.addAttribute("command", addQuery);
			model.addAttribute("error", "Please fill all values");
			return "addpage";
		}
		List<SearchPageModel> searchResultList = examService.addUser(addQuery);
		model.addAttribute("numOfResult", searchResultList.size());
		model.addAttribute("command", addQuery);
		model.addAttribute("searchResultList", searchResultList);
		return "searchresultpage";
	}
}
