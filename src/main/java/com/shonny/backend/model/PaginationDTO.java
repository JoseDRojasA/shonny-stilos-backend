package com.shonny.backend.model;

import java.util.List;

public class PaginationDTO {
	private List<Object> elements;
	private Integer count;
	
	public List<Object> getElements() {
		return elements;
	}
	public void setElements(List<Object> elements) {
		this.elements = elements;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
