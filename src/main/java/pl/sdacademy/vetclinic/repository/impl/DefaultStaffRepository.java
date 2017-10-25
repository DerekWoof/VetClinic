package pl.sdacademy.vetclinic.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import pl.sdacademy.vetclinic.model.Staff;
import pl.sdacademy.vetclinic.repository.StaffRepository;

@Repository
public class DefaultStaffRepository extends AbstractDefaultRepository implements StaffRepository {
	
	private List<Staff> staffMembers;

	public DefaultStaffRepository() {
		staffMembers = (List<Staff>) loadPersistedState().orElseGet(ArrayList::new);
	}
	
	@Override
	public void add(Staff staff) {
		staffMembers.add(staff);
	}

	@Override
	public Staff getById(Integer staffId) {
		return staffMembers.stream().filter(d -> d.getId().equals(staffId)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No room found"));
	}

	@Override
	public List<Staff> getAll() {
		return staffMembers;
	}

	@Override
	public void persistData() {
		persistState(staffMembers);
	}

	@Override
	public Long count() {
		return (long) staffMembers.size();
	}

}
