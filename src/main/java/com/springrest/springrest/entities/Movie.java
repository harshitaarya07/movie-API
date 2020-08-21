package com.springrest.springrest.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Movie Model")
public class Movie {
	
	@ApiModelProperty(notes="Movie ID",name="id",required=true,value="230")
	private long id;
	
	@ApiModelProperty(notes="Movie Title",name="title",required=true,value="Something")
	private String title;
	
	@ApiModelProperty(notes="Movie description",name="description",required=true,value="Anything")
	private String description;
	public Movie(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
}
