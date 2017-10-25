package pl.sdacademy.vetclinic.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import pl.sdacademy.vetclinic.model.PetOwner;
import pl.sdacademy.vetclinic.repository.PetOwnerRepository;

@Repository
public class DefaultPetOwnerRepository extends AbstractDefaultRepository implements PetOwnerRepository {

	private List<PetOwner> petOwners;
	
	public DefaultPetOwnerRepository() {
		petOwners = (List<PetOwner>) loadPersistedState().orElseGet(ArrayList::new);
	}
	
	@Override
	public void add(PetOwner owner) {
		petOwners.add(owner);
	}

	@Override
	public PetOwner getById(Integer petOwnerId) {
		return petOwners.stream().filter(d -> d.getId().equals(petOwnerId)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No owner found"));
	}

	@Override
	public List<PetOwner> getAll() {
		return petOwners;
	}

	@Override
	public void persistData() {
		persistState(petOwners);
	}

	@Override
	public Long count() {
		return (long) petOwners.size();
	}
}
