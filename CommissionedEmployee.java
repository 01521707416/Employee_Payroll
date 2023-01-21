package felixgenPayroll;

public class CommissionedEmployee extends Employee{
	private double soldAmount;
    private double percent;
    private double due=0;
    private double paidAmount;
    
    public CommissionedEmployee() {
    	
    }
    
    public CommissionedEmployee(double soldAmount, double percent, double due, double paidAmount) {
    	
    	this.soldAmount = soldAmount;
    	this.percent = percent;
    	this.due = due;
    	this.paidAmount = paidAmount;
    	
    	try {
    		if (soldAmount >= 0) {
    			this.soldAmount = soldAmount;
    		} else {
    			System.out.println("Sold amount cannot be less than zero.");
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
		
		return (soldAmount * (percent/100)) + due;
	}
	
	public void printDetails() {
		System.out.println("Employee Name: " + this.getFirstName() + " " + this.getLastName());
		System.out.println("NID number: " + this.getnID());
		System.out.println("Address: " + this.getAddress());
		System.out.println("Contact: " + this.getContact());
		System.out.println("Sold Amount: " + this.soldAmount);
		System.out.println("Percentage: " + this.percent);
		System.out.println("Due Amount: " + this.due);
		System.out.println("Payable amount: " + this.totalPayable());
	}
	
}
