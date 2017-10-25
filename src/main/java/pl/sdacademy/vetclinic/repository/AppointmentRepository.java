package pl.sdacademy.vetclinic.repository;

import java.util.List;

import pl.sdacademy.vetclinic.model.Appointment;

public interface AppointmentRepository {

	void addAppointment(Appointment appointment);
	Appointment getById(Integer id);
	List<Appointment> getDoctorsAppointments(Integer doctorId);
	Long count();
	
}
