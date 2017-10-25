package pl.sdacademy.vetclinic.repository;

import java.util.List;

import pl.sdacademy.vetclinic.model.Staff;

public interface StaffRepository {

	void add(Staff staff);
	Staff getById(Integer staffId);
	List<Staff> getAll();
	Long count();
	
}
