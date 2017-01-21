/**
 * 
 */
package com.exam.model;

import java.io.Serializable;

/**
 * @author Siddharth
 *
 */
public class SearchPageModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6746698304134114339L;
	
	private String name;
	private String startPoint;
	private String centerAddress;
	private String examDate;
	private String contactNumber;
	private String password;
	
	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
