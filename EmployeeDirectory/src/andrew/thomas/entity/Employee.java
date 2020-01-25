package andrew.thomas.entity;

public class Employee {

	// fields
	private Integer id;
	private String name;
	private String dob;
	private String department;

	// constructors
	public Employee() {

	}

	public Employee(String name, String dob, String department) {
		this.name = name;
		this.dob = dob;
		this.department = department;
	}

	public Employee(Integer id, String name, String dob, String department) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.department = department;
	}

	// getters
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	public String getDepartment() {
		return department;
	}

	// setters

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// tostring
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", department=" + department + "]";
	}

}
