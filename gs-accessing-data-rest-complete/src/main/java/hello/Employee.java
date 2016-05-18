package hello;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Employee {

	@EmbeddedId
	private EmployeeId id;

	private String firstName;
	private String lastName;
	private int salary;

	public EmployeeId getId() {
		return id;
	}

	public void setId(EmployeeId id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}