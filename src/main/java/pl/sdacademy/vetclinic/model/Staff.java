package pl.sdacademy.vetclinic.model;

public class Staff extends Person {

	private static final long serialVersionUID = 7950252727638958378L;

	private Integer salary;
	private String role;

	public Staff() {
	}
	
	public Staff(Person basePerson) {
		setId(basePerson.getId());
		setName(basePerson.getName());
		setSurname(basePerson.getSurname());
		setMobile(basePerson.getMobile());
	}
	
	public Staff(Staff baseStaff) {
		this((Person) baseStaff);
		setSalary(baseStaff.getSalary());
		setRole(baseStaff.getRole());
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
