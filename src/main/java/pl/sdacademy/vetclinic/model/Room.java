package pl.sdacademy.vetclinic.model;

import java.io.Serializable;

public class Room implements Serializable {

	private static final long serialVersionUID = -2099830064660405417L;

	private Integer id;
	private String number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
