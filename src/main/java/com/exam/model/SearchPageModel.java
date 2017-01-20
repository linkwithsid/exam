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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String from;
	private String to;
	private String date;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
