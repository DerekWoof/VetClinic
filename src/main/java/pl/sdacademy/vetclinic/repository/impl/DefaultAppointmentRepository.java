package pl.sdacademy.vetclinic.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import pl.sdacademy.vetclinic.model.Appointment;
import pl.sdacademy.vetclinic.repository.AppointmentRepository;

@Repository
public class DefaultAppointmentRepository extends AbstractDefaultRepository implements AppointmentRepository {

	private List<Appointment> appointments;
	
	public DefaultAppointmentRepository() {
		appointments = (List<Appointment>) loadPersistedState().orElseGet(ArrayList::new);
	}
	
	@Override
	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

	@Override
	public Appointment getById(Integer id) {
		return appointments.stream().filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
		
	}

	@Override
	public List<Appointment> getDoctorsAppointments(Integer doctorId) {
		return appointments.stream().filter(a -> a.getDoctorId().equals(doctorId)).collect(Collectors.toList());
	}

	@Override
	public void persistData() {
		persistState(appointments);
	}

	@Override
	public Long count() {
		return (long) appointments.size();
	}

}
