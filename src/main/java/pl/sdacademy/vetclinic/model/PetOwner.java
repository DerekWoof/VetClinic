package pl.sdacademy.vetclinic.model;

public class PetOwner extends Person {

	private static final long serialVersionUID = 6619498889550581781L;
	
	private String address;
	
	public PetOwner() {
	}
	
	public PetOwner(Person basePerson) {
		setId(basePerson.getId());
		setName(basePerson.getName());
		setSurname(basePerson.getSurname());
		setMobile(basePerson.getMobile());
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
