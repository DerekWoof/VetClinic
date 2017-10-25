package pl.sdacademy.vetclinic.model;

public class Doctor extends Staff {

	private static final long serialVersionUID = -8055918582761020404L;
	
	private String specialization;

	public Doctor(Staff staff) {
		super(staff);
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}
