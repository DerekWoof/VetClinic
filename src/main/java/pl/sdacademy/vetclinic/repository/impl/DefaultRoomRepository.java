package pl.sdacademy.vetclinic.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import pl.sdacademy.vetclinic.model.Room;
import pl.sdacademy.vetclinic.repository.RoomRepository;

@Repository
public class DefaultRoomRepository extends AbstractDefaultRepository implements RoomRepository {
	
	private List<Room> rooms;

	public DefaultRoomRepository() {
		rooms = (List<Room>) loadPersistedState().orElseGet(ArrayList::new);
	}
	
	@Override
	public void add(Room owner) {
		rooms.add(owner);
	}

	@Override
	public Room getById(Integer roomId) {
		return rooms.stream().filter(d -> d.getId().equals(roomId)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No room found"));
	}

	@Override
	public List<Room> getAll() {
		return rooms;
	}

	@Override
	public void persistData() {
		persistState(rooms);
	}

	@Override
	public Long count() {
		return (long) rooms.size();
	}

}
