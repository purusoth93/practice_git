package com.example.practice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookDTO {
	
	private Integer id;
	
	@NotBlank(message="{book.name.empty}")
	private String name;
	
	@NotBlank(message="{book.description.empty}")
	@Size(min=10,max=50,message="{book.description.length}")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
