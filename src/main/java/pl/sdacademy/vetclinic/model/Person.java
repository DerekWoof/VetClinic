package pl.sdacademy.vetclinic.model;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 5733663368009712773L;

	private Integer id;
	private String name;
	private String surname;
	private String mobile;

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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
