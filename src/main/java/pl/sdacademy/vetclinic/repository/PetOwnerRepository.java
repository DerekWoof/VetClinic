package pl.sdacademy.vetclinic.repository;

import java.util.List;

import pl.sdacademy.vetclinic.model.PetOwner;

public interface PetOwnerRepository {

	void add(PetOwner owner);
	PetOwner getById(Integer ownerId);
	List<PetOwner> getAll();
	Long count();
	
}
