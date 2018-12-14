package com.example.data;

public class Data {
	Integer id;

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

	String name;

	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + "]";
	}
}
