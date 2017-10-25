package pl.sdacademy.vetclinic.repository;

import java.util.List;

import pl.sdacademy.vetclinic.model.Room;

public interface RoomRepository {

	void add(Room room);
	Room getById(Integer roomId);
	List<Room> getAll();
	Long count();
	
}
