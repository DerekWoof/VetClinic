package pl.sdacademy.vetclinic;

import java.time.LocalDateTime;

import pl.sdacademy.vetclinic.model.Appointment;
import pl.sdacademy.vetclinic.model.Doctor;
import pl.sdacademy.vetclinic.model.Person;
import pl.sdacademy.vetclinic.model.Pet;
import pl.sdacademy.vetclinic.model.PetOwner;
import pl.sdacademy.vetclinic.model.Room;
import pl.sdacademy.vetclinic.model.Staff;
import pl.sdacademy.vetclinic.repository.impl.DefaultAppointmentRepository;
import pl.sdacademy.vetclinic.repository.impl.DefaultDoctorRepository;
import pl.sdacademy.vetclinic.repository.impl.DefaultPetOwnerRepository;
import pl.sdacademy.vetclinic.repository.impl.DefaultPetRepository;
import pl.sdacademy.vetclinic.repository.impl.DefaultRoomRepository;
import pl.sdacademy.vetclinic.repository.impl.DefaultStaffRepository;

public class InputDataGenerator {
	private Integer petIdSequence;
	private Integer personSequence;
	private Integer roomSequence;
	private Integer appointmentSequence;
	
	private DefaultAppointmentRepository appointmentRepository;
	private DefaultDoctorRepository doctorRepository;
	private DefaultPetOwnerRepository ownerRepository;
	private DefaultPetRepository petRepository;
	private DefaultRoomRepository roomRepository;
	private DefaultStaffRepository staffRepository;
	
	public InputDataGenerator() {
		petIdSequence = 0;
		personSequence = 0;
		roomSequence = 0;
		appointmentSequence = 0;
		
		appointmentRepository = new DefaultAppointmentRepository();
		doctorRepository = new DefaultDoctorRepository();
		ownerRepository = new DefaultPetOwnerRepository();
		petRepository = new DefaultPetRepository();
		roomRepository = new DefaultRoomRepository();
		staffRepository = new DefaultStaffRepository();
	}
	
	public void generateSampleData() {
		PetOwner owner1 = generatePetOwner("John", "Doe", "555-123-524", "17th Avenue");
		ownerRepository.add(owner1);
		Pet pet1 = generatePet("William", "cat");
		petRepository.add(pet1, owner1.getId());
		Pet pet2 = generatePet("Milo", "dog");
		petRepository.add(pet2, owner1.getId());
		
		PetOwner owner2 = generatePetOwner("Monica", "Geller", "555-351-512", "Central Park Avenue 52, Apartment 20");
		ownerRepository.add(owner2);
		Pet pet3 = generatePet("Chi-Chi", "dog");
		petRepository.add(pet3, owner2.getId());

		Room room1a = generateRoom("1a");
		roomRepository.add(room1a);
		Room room1b = generateRoom("1b");
		roomRepository.add(room1b);
		Room room2 = generateRoom("2");
		roomRepository.add(room2);
		Room room3 = generateRoom("3");
		roomRepository.add(room3);
		
		Staff staff1 = generateStaff("Bernadette Maryann", "Rostenkowski-Wolowitz", "555-623-132", 55000, "assistant");
		staffRepository.add(staff1);

		Doctor dogDoctor = generateDoctor("Richard", "Burke", "555-724-835", 90000, "veterinary", "dog");
		doctorRepository.add(dogDoctor);

		Doctor catDoctor = generateDoctor("V. M.", "Koothrappali", "555-173-425", 80000, "veterinary", "cat");
		doctorRepository.add(catDoctor);
		
		LocalDateTime firstDateStart = LocalDateTime.of(2017, 6, 15, 17, 30, 00);
		LocalDateTime firstDateStop = LocalDateTime.of(2017, 6, 15, 18, 30, 00);
		LocalDateTime secondDateStart = LocalDateTime.of(2017, 6, 16, 9, 0, 00);
		LocalDateTime secondDateStop = LocalDateTime.of(2017, 6, 16, 9, 45, 00);
		
		Appointment appointment1 = generateAppointment(firstDateStart, firstDateStop, pet3.getId(), dogDoctor.getId(), room2.getId());
		appointmentRepository.addAppointment(appointment1);
		
		Appointment appointment2 = generateAppointment(secondDateStart, secondDateStop, pet1.getId(), catDoctor.getId(), room3.getId());
		appointmentRepository.addAppointment(appointment2);
		
		appointmentRepository.persistData();
		doctorRepository.persistData();
		ownerRepository.persistData();
		petRepository.persistData();
		roomRepository.persistData();
		staffRepository.persistData();
	}
	
	public Pet generatePet(String name, String genus) {
		petIdSequence++;
		Pet pet = new Pet();
		pet.setId(petIdSequence);
		pet.setName(name);
		pet.setGenus(genus);
		return pet;
	}
	
	public Person generatePerson(String name, String surname, String mobile) {
		personSequence++;
		Person person = new Person();
		person.setId(personSequence);
		person.setName(name);
		person.setSurname(surname);
		person.setMobile(mobile);
		return person;
	}
	
	public PetOwner generatePetOwner(String name, String surname, String mobile, String address) {
		Person basePerson = generatePerson(name, surname, mobile);
		PetOwner petOwner = new PetOwner(basePerson);
		petOwner.setAddress(address);
		return petOwner;
	}
	
	public Staff generateStaff(String name, String surname, String mobile, Integer salary, String role) {
		Person basePerson = generatePerson(name, surname, mobile);
		Staff staff = new Staff(basePerson);
		staff.setSalary(salary);
		staff.setRole(role);
		return staff;
	}
	
	public Room generateRoom(String number) {
		roomSequence++;
		Room room = new Room();
		room.setId(roomSequence);
		room.setNumber(number);
		return room;
	}
	
	public Doctor generateDoctor(String name, String surname, String mobile, Integer salary, String role, String specialization) {
		Staff staff = generateStaff(name, surname, mobile, salary, role);
		Doctor doctor = new Doctor(staff);
		doctor.setSpecialization(specialization);
		return doctor;
	}
	
	public Appointment generateAppointment(LocalDateTime from, LocalDateTime to, Integer petId, Integer doctorId, Integer roomId) {
		appointmentSequence++;
		Appointment appointment = new Appointment();
		appointment.setId(appointmentSequence);
		appointment.setFrom(from);
		appointment.setTo(to);
		appointment.setPetId(petId);
		appointment.setDoctorId(doctorId);
		appointment.setRoomId(roomId);
		return appointment;
	}
}
