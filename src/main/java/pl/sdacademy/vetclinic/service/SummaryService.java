package pl.sdacademy.vetclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.vetclinic.repository.AppointmentRepository;
import pl.sdacademy.vetclinic.repository.DoctorRepository;
import pl.sdacademy.vetclinic.repository.PetOwnerRepository;
import pl.sdacademy.vetclinic.repository.PetRepository;
import pl.sdacademy.vetclinic.repository.RoomRepository;
import pl.sdacademy.vetclinic.repository.StaffRepository;

@Service
public class SummaryService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PetOwnerRepository petOwnerRepository;
	@Autowired
	private PetRepository petRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private StaffRepository staffRepository;

	public String getOverallSummary() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder = stringBuilder.append("There are:\r\n")
		.append("\t").append(doctorRepository.count()).append(" doctors\r\n")
		.append("\t").append(staffRepository.count()).append(" other staff members\r\n")
		.append("\t").append(roomRepository.count()).append(" rooms\r\n")
		.append("\t").append(petOwnerRepository.count()).append(" pet owners\r\n")
		.append("\t").append(petRepository.count()).append(" pets\r\n")
		.append("\t").append(appointmentRepository.count()).append(" appointments\r\n");
		return stringBuilder.toString();
	}
	
	public void setAppointmentRepository(AppointmentRepository appointmentRepo) {
		this.appointmentRepository = appointmentRepo;
	}

	public void setDoctorRepository(DoctorRepository doctorRepo) {
		this.doctorRepository = doctorRepo;
	}

	public void setPetOwnerRepository(PetOwnerRepository petOwnerRepo) {
		this.petOwnerRepository = petOwnerRepo;
	}

	public void setPetRepository(PetRepository petRepo) {
		this.petRepository = petRepo;
	}

	public void setRoomRepository(RoomRepository roomRepo) {
		this.roomRepository = roomRepo;
	}

	public void setStaffRepository(StaffRepository staffRepo) {
		this.staffRepository = staffRepo;
	}

}
