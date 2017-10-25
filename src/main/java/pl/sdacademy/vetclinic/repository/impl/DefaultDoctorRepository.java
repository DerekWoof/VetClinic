package pl.sdacademy.vetclinic.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import pl.sdacademy.vetclinic.model.Doctor;
import pl.sdacademy.vetclinic.repository.DoctorRepository;

@Repository
public class DefaultDoctorRepository extends AbstractDefaultRepository implements DoctorRepository {

	private List<Doctor> doctors;

	public DefaultDoctorRepository() {
		doctors = (List<Doctor>) loadPersistedState().orElseGet(ArrayList::new);
	}

	@Override
	public void add(Doctor doctor) {
		doctors.add(doctor);
	}

	@Override
	public Doctor getById(Integer doctorId) {
		return doctors.stream().filter(d -> d.getId().equals(doctorId)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No doctor found"));
	}

	@Override
	public List<Doctor> getAll() {
		return doctors;
	}

	@Override
	public void persistData() {
		persistState(doctors);
	}

	@Override
	public Long count() {
		return (long) doctors.size();
	}

}
