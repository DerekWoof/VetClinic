package pl.sdacademy.vetclinic.repository;

import java.util.List;

import pl.sdacademy.vetclinic.model.Pet;

public interface PetRepository {
	
	Pet getById(Integer petId);
	void add(Pet pet, Integer ownerId);
	List<Pet> getByOwner(Integer ownerId);
	Long count();
	
}
