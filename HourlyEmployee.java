package felixgenPayroll;

public class HourlyEmployee extends Employee{

	private double workedHour;
	private double hourlyRate;
	private double due=0;
    private double paidAmount;
    
    public HourlyEmployee() {
    	
    }
    
    public HourlyEmployee(double workedHour, double hourlyRate, double due, double paidAmount) {
    	
    	this.workedHour = workedHour;
    	this.hourlyRate = hourlyRate;
    	this.due = due;
    	this.paidAmount = paidAmount;
    	
    	try {
    		if (workedHour >= 0) {
    			this.workedHour = workedHour;
    		} else {
    			System.out.println("Worked hours cannot be less than zero.");
    		}
    	} catch (NumberFormatException ne1) {
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
	
	public double getWorkedHour() {
		return workedHour;
	}

	public void setWorkedHour(double workedHour) {
		this.workedHour = workedHour;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getDue() {
		return due;
	}

	public void setDue(double due) {
		this.due = due;
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
		
		return (workedHour * hourlyRate ) + due;
	}
	
	public void printDetails() {
		System.out.println("Employee Name: " + this.getFirstName() + " " + this.getLastName());
		System.out.println("NID number: " + this.getnID());
		System.out.println("Address: " + this.getAddress());
		System.out.println("Contact: " + this.getContact());
		System.out.println("Hours worked: " + this.workedHour);
		System.out.println("Hourly salary: " + this.hourlyRate);
		System.out.println("Due Amount: " + this.due);
		System.out.println("Payable amount: " + this.totalPayable());
	}

}
