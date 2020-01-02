package com.shonny.backend.model;

import java.util.List;

public class PaginationDTO {
	private List<Object> elements;
	private Long count;
	
	public List<Object> getElements() {
		return elements;
	}
	public void setElements(List<Object> elements) {
		this.elements = elements;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
}
