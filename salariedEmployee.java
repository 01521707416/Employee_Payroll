package felixgenPayroll;

import Polymorphism.SalariedEmployee;

public class salariedEmployee extends Employee {

	private double monthlySalary;
	private double due = 0;
	private double paidAmount;

	public salariedEmployee() {

	}

	public salariedEmployee(Double monthlySalary, double due, String firstName, String lastName, String nID,
			String address, String contact) {
		super(firstName, lastName, nID, address, contact);
		try {
			if (monthlySalary >= 0) {
				this.monthlySalary = monthlySalary;
			} else {
				System.out.println("Salary cannot be less than zero.");
			}
		} catch (NumberFormatException ne) {
			System.out.println("Please input a valid number");
		}

		try {
			if (due >= 0) {
				this.due = due;
			} else {
				System.out.println("Due cannot be less than zero.");
			}
		} catch (NumberFormatException ne) {
			System.out.println("Please input a valid number");
		}
	}

	public void setMonthlySalary(double monthlySalary) {

		try {
			if (monthlySalary < 0) {
				throw new IllegalArgumentException("Monthly salary must be greater than or equals to zero.");
			}
			this.monthlySalary = monthlySalary;
			this.due = monthlySalary;
		} catch (NumberFormatException ne) {
			System.out.println("Please input a valid number");
		}
	}

	public double getMonthlySalary() {

		return this.monthlySalary;
	}

	public double getDue() {
		return due;
	}

	public void setDue(double due) {
		try {
			if (monthlySalary < 0) {
				throw new IllegalArgumentException("Due must be greater than or equals to zero.");
			}
			this.due = due;
		} catch (NumberFormatException ne) {
			System.out.println("Please input a valid number");
		}
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		
		this.paidAmount = paidAmount;
		if (this.due > 0) {
			if (paidAmount > this.due) {
				this.due = 0;
			} else {
				this.due = this.due - paidAmount;
			}
		}
		if (totalPayable() > paidAmount) {
			this.due = (totalPayable() - paidAmount);
		}
	}

	@Override
	public double totalPayable() {

		return this.monthlySalary + this.due;
	}

	public void printDetails() {

		System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
		System.out.println("NID number: " + this.getnID());
		System.out.println("Address: " + this.getAddress());
		System.out.println("Contact number: " + this.getContact());
		System.out.println("Monthly salary: " + this.getMonthlySalary());
		System.out.println("Paid amount: " + this.getPaidAmount());
		System.out.println("Due amount: " + this.getDue());
	}

}
