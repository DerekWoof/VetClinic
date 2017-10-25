package pl.sdacademy.vetclinic.model;

public class AppointmentComposite extends Appointment {

	private static final long serialVersionUID = -6347833507191244574L;

	private transient Doctor doctor;
	private transient Room room;
	private transient PetOwner petOwner;
	private transient Pet pet;
	
	public AppointmentComposite() {
	}

	public AppointmentComposite(Appointment baseAppointment) {
		setId(baseAppointment.getId());
		setFrom(baseAppointment.getFrom());
		setTo(baseAppointment.getTo());
		setPetId(baseAppointment.getPetId());
		setRoomId(baseAppointment.getRoomId());
		setDoctorId(baseAppointment.getDoctorId());
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public PetOwner getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(PetOwner petOwner) {
		this.petOwner = petOwner;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

}
