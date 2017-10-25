package pl.sdacademy.vetclinic.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import pl.sdacademy.vetclinic.model.Pet;
import pl.sdacademy.vetclinic.repository.PetRepository;

@Repository
public class DefaultPetRepository extends AbstractDefaultRepository implements PetRepository {

	private Map<Integer, List<Pet>> petsByOwner;

	public DefaultPetRepository() {
		petsByOwner = (Map<Integer, List<Pet>>) loadPersistedState().orElseGet(HashMap::new);
	}

	@Override
	public Pet getById(Integer petId) {
		return petsByOwner.values().stream().flatMap(List::stream).filter(p -> p.getId().equals(petId)).findAny()
				.orElseThrow(() -> new IllegalArgumentException("No pet found"));
	}

	@Override
	public void add(Pet pet, Integer ownerId) {
		List<Pet> pets = petsByOwner.getOrDefault(ownerId, new ArrayList<>());
		pets.add(pet);
		petsByOwner.put(ownerId, pets);

	}

	@Override
	public List<Pet> getByOwner(Integer ownerId) {
		return petsByOwner.getOrDefault(ownerId, new ArrayList<>());
	}

	public void persistData() {
		persistState(petsByOwner);
	}

	@Override
	public Long count() {
		return petsByOwner.values().stream().mapToInt(List::size).count();
	}
	
}
