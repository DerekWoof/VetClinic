package pl.sdacademy.vetclinic.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Appointment implements Serializable {

	private static final long serialVersionUID = 7615837035247225964L;
	
	private Integer id;
	private LocalDateTime from;
	private LocalDateTime to;
	private Integer roomId;
	private Integer doctorId;
	private Integer petId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFrom() {
		return from;
	}

	public void setFrom(LocalDateTime from) {
		this.from = from;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		this.to = to;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

}
