package pl.sdacademy.vetclinic.repository;

import java.util.List;

import pl.sdacademy.vetclinic.model.Doctor;

public interface DoctorRepository {
	
	void add(Doctor doctor);
	Doctor getById(Integer doctorId);
	List<Doctor> getAll();
	Long count();

}
