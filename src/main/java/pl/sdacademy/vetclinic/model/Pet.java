package pl.sdacademy.vetclinic.model;

import java.io.Serializable;

public class Pet implements Serializable {
	
	private static final long serialVersionUID = 1622903672820341728L;
	
	private Integer id;
	private String name;
	private String genus;

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

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

}
