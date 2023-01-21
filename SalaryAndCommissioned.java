package felixgenPayroll;

public class SalaryAndCommissioned extends Employee{

	private double monthlySalary;
	private double due = 0;
	private double paidAmount;
	private double soldAmount;
    private double percent;
    
    public SalaryAndCommissioned(){
			
	}
    
    public SalaryAndCommissioned(Double monthlySalary, double due, String firstName, String lastName, String nID,
			String address, String contact, double soldAmount, double percent, double paidAmount){
    	super(firstName, lastName, nID, address, contact);
    	
    	this.percent = percent;
    	this.soldAmount = soldAmount;
    	this.paidAmount = paidAmount;
    	this.due = due;
    	
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
		
		try {
    		if (soldAmount >= 0) {
    			this.soldAmount = soldAmount;
    		} else {
    			System.out.println("Sold amount cannot be less than zero.");
    		}
    	} catch (NumberFormatException ne1) {
    		System.out.println("Please input a valid number");
    	}
	}
    
	public double getMonthlySalary() {
		return monthlySalary;
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

	public double getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(double soldAmount) {
		this.soldAmount = soldAmount;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	@Override
	public double totalPayable() {
		
		return (soldAmount * (percent/100)) + this.due + this.monthlySalary;
	}
	
	public void printDetails() {

		System.out.println("Employee Name: " + this.getFirstName() + " " + this.getLastName());
		System.out.println("NID number: " + this.getnID());
		System.out.println("Address: " + this.getAddress());
		System.out.println("Contact number: " + this.getContact());
		System.out.println("Monthly salary: " + this.getMonthlySalary());
		System.out.println("Sold Amount: " + this.soldAmount);
		System.out.println("Percentage: " + this.percent);
		System.out.println("Paid amount: " + this.getPaidAmount());
		System.out.println("Due amount: " + this.getDue());
		System.out.println("Total payable amount: " + this.totalPayable());
	}
}
