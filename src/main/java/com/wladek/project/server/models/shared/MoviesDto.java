package com.wladek.project.server.models.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MoviesDto implements Serializable, IsSerializable {

	private String name;
	private String description;
	private Long id;

	public MoviesDto() {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
