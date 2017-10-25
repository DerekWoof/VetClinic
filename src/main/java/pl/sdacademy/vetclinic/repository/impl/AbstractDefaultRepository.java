package pl.sdacademy.vetclinic.repository.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

public abstract class AbstractDefaultRepository {

	protected Optional<Object> loadPersistedState() {
		try (FileInputStream dataInputStream = new FileInputStream("src/main/resources/" + this.getClass().getSimpleName())) {
			ObjectInputStream serializedObjectData = new ObjectInputStream(dataInputStream);
			return Optional.of(serializedObjectData.readObject());
		} catch (IOException | ClassNotFoundException e) {
			return Optional.empty();
		}
	}
	
	protected void persistState(Object stateObject) {
		try (FileOutputStream dataOutputStream = new FileOutputStream("src/main/resources/" + this.getClass().getSimpleName())) {
			ObjectOutputStream serializedObjectData = new ObjectOutputStream(dataOutputStream);
			serializedObjectData.writeObject(stateObject);
		} catch (IOException e) {
			System.out.println("Could not serialize " + this.getClass().getSimpleName() + " data");
		}
	
	}
	
	public abstract void persistData();
}
