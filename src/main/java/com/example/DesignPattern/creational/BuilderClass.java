package com.example.DesignPattern.creational;

//Builder pattern is creating obj using setters method
//we use setters when its not compulsory to give prop value initially
// or we change it frequently

public class BuilderClass {
	public static void main(String[] args) {

		Employee emp = new Employee(157199, "KP", 97000);

		System.out.println(emp);

		// Creating obj using builder pattern
		Employee emp2 = new EmployeeBuilder().setId(157199).setName("KP Patel").setSalary(97000).getEmployee();
		System.out.println(emp2);
	}
}

class EmployeeBuilder {
	int id;
	String name;
	int salary;

	public EmployeeBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public EmployeeBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public EmployeeBuilder setSalary(int salary) {
		this.salary = salary;
		return this;
	}

	public Employee getEmployee() {
		return new Employee(id, name, salary);
	}
}

class Employee {
	int id;
	String name;
	int salary;

	Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
