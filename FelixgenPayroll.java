package felixgenPayroll;

import java.util.*;

import Polymorphism.ComissionedEmployee;

public class FelixgenPayroll {

	public static ArrayList<salariedEmployee> salariedEmployees = new ArrayList<salariedEmployee>();
	public static ArrayList<CommissionedEmployee> commissionedEmployees = new ArrayList<CommissionedEmployee>();
	public static ArrayList<HourlyEmployee> HourlyEmployees = new ArrayList<HourlyEmployee>();
	public static ArrayList<SalaryAndCommissioned> SalaryPlusCommissionedEmployees = new ArrayList<SalaryAndCommissioned>();
	public static ArrayList<Payment> paymentList = new ArrayList<Payment>();
	
	public static void main(String[] args) {

		menu();
	}

	public static void menu() {

		System.out.println("====== Welcome to Felixgen LSS Payroll System =====");
		System.out.println("1. Create an Employee \n2. Make Payments \n3. Payment Invoice \n4. Display \n5. Update salary info \n6. Exit");
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your choice: ");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			createEmployee();
			break;
		case 2:
			makePayment();
			break;
		case 3:
			report();
			break;
		case 4:
			display(0);
			break;
		case 5:
			updateInfo();
		case 6:
			System.out.println("Thank you for using Felixgen LSS Payroll system.");
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choice input! Please try again");
			menu();
		}
	}

	private static void updateInfo() {
		
		System.out.println("1.Salaried Employee \n2.Commissioned Employee");
        System.out.println("3.Hourly Paid Employee \n4.Salary & Commissioned Employee \n5.Return to Menu");
        Scanner scan = new Scanner(System.in);
        int option;
        System.out.println("Select type of employee you want to update: ");
        option = scan.nextInt();
        switch(option) {
        case 1:
            updateSalariedEmployeeInfo();
            break;
        case 2:
        	updateCommissionedEmployeeInfo();
            break;
        case 3:
            updateHourlyEmployee();
            break;
        case 4:
            updateSalaryandCommissioned();
            break;
        case 5:
        	menu();
        default:
            System.out.println("Wrong choice/try again");
        }
        updateInfo();
	}
	
	private static void updateSalaryandCommissioned() {
		
		System.out.println("=== Salary & Commissioned Employee List ===");
        System.out.println("Serial \t Full Name \t\t Payable amount");
        for(int i = 0; i<SalaryPlusCommissionedEmployees.size(); i++){
        	SalaryAndCommissioned SCemp =  SalaryPlusCommissionedEmployees.get(i);
            System.out.println((i+1)+".\t"+SCemp.getFirstName()+" "+SCemp.getLastName()+" \t"+SCemp.totalPayable());
        }
        
        System.out.println("Select one salary & commissioned employee to update info: ");
        Scanner input = new Scanner(System.in);
        int empNo = input.nextInt();
        SalaryAndCommissioned sce = SalaryPlusCommissionedEmployees.get(empNo-1);
        System.out.println("Please enter new sold amount: ");
        double newSoldAmount = input.nextDouble();
        System.out.println("Please enter new percentage on sale: ");
        double newPercent = input.nextDouble();
        System.out.println("Please enter new monthly salary: ");
        double newSalary = input.nextDouble();
        
        if(newSoldAmount>0){
           sce.setSoldAmount(newSoldAmount);
           System.out.println("Sold amount Updated! New sold amount is: "+newSoldAmount);
        }else{
            System.out.println("Please enter a positive value for amount sold!");
        }
        
        if(newPercent>0){
            sce.setPercent(newPercent);
            System.out.println("Percentage on sale Updated! New percentage is: "+newPercent);
         }else{
             System.out.println("Percentage cannot be negative!");
         }
        
        if(newSalary>0){
            sce.setMonthlySalary(newSalary); 
            System.out.println("Salary Updated! New Salary is: "+newSalary );
         }else{
             System.out.println("Please enter a positive value for salary!");
         }
        menu();
	}

	private static void updateHourlyEmployee() {
		
		System.out.println("=== Horly Employee List ===");
        System.out.println("Serial \t Full Name \t\t Payable amount");
        for(int i = 0; i<HourlyEmployees.size(); i++){
            HourlyEmployee Hemp =  HourlyEmployees.get(i);
            System.out.println((i+1)+".\t"+Hemp.getFirstName()+" "+Hemp.getLastName()+" \t"+Hemp.totalPayable());
        }
        
        System.out.println("Select one hourly employee to update info: ");
        Scanner input = new Scanner(System.in);
        int empNo = input.nextInt();
        HourlyEmployee he = HourlyEmployees.get(empNo-1);
        System.out.println("Please enter newly worked hours: ");
        double newWoredHours = input.nextDouble();
        System.out.println("Please enter new hourly rate: ");
        double newRate = input.nextDouble();
        
        if(newWoredHours>0){
           he.setWorkedHour(newWoredHours);
           System.out.println("Worked hours Updated! New worked hours: "+newWoredHours);
        }else{
            System.out.println("Worked hours must be positive!");
        }
        
        if(newRate>0){
            he.setHourlyRate(newRate);
            System.out.println("Hourly rate Updated! New hourly rate is: "+newRate);
         }else{
             System.out.println("Salary cannot be negative!");
         }
        menu();
	}

	private static void updateCommissionedEmployeeInfo() {
		
		System.out.println("=== Commissioned Employee List ===");
        System.out.println("Serial \t Full Name \t\t Payable amount");
        for(int i = 0; i<commissionedEmployees.size(); i++){
            CommissionedEmployee Cemp =  commissionedEmployees.get(i);
            System.out.println((i+1)+".\t"+Cemp.getFirstName()+" "+Cemp.getLastName()+" \t"+Cemp.totalPayable());
        }
        
        System.out.println("Select one commissioned employee to update info: ");
        Scanner input = new Scanner(System.in);
        int empNo = input.nextInt();
        CommissionedEmployee ce = commissionedEmployees.get(empNo-1);
        System.out.println("Please enter new sold amount: ");
        double newSoldAmount = input.nextDouble();
        System.out.println("Please enter new percentage on sale: ");
        double newPercent = input.nextDouble();
        
        if(newSoldAmount>0){
           ce.setSoldAmount(newSoldAmount);
           System.out.println("Sold amount Updated! New sold amount is: "+newSoldAmount);
        }else{
            System.out.println("Please enter a positive value for salary!");
        }
        
        if(newPercent>0){
            ce.setPercent(newPercent);
            System.out.println("Percentage on sale Updated! New percentage is: "+newPercent);
         }else{
             System.out.println("Percentage cannot be negative!");
         }
        menu();
	}

	private static void updateSalariedEmployeeInfo() {
		
		System.out.println("=== Salaried Employee List ===");
        System.out.println("Serial \t Full Name \t\t Payable amount");
        for(int i = 0; i<salariedEmployees.size(); i++){
            salariedEmployee Semp =  salariedEmployees.get(i);
            System.out.println((i+1)+".\t"+Semp.getFirstName()+" "+Semp.getLastName()+" \t"+Semp.totalPayable());
        }
        
        System.out.println("Select one salaried employee to update info: ");
        Scanner input = new Scanner(System.in);
        int empNo = input.nextInt();
        salariedEmployee se = salariedEmployees.get(empNo-1);
        System.out.println("Please enter new salary: ");
        double newSalary = input.nextDouble();
        
        if(newSalary>0){
           se.setMonthlySalary(newSalary); 
           System.out.println("Salary Updated! New Salary is: "+newSalary );
        }else{
            System.out.println("Please enter a positive value for salary!");
        }
        menu();
	}

	public static void createEmployee() {

		Scanner input = new Scanner(System.in);
		System.out.println("=== Employe Creation Menu ===");
		System.out.println(
				"1. Salaried Employee \n2. Commissioned Employee. \n3. Hourly Paid Employee \n4. Salary and Commissioned Employee \n5. Return to Menu");
		System.out.println("Please select employee type: ");
		int option = input.nextInt();
		switch (option) {
		case 1:
			createSE();
			break;
		case 2:
			createCE();
			break;
		case 3:
			createHourlyPaidEmployee();
			break;
		case 4:
			SalaryAndCommissioned();
			break;
		case 5:
			menu();
		default:
			System.out.println("Invalid input! Please try again.");
			createEmployee();
		}
	}

	public static void createSE() {

		salariedEmployee se = new salariedEmployee();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first name: ");
		se.setFirstname(input.nextLine());
		System.out.println("Enter last name: ");
		se.setLastName(input.nextLine());
		System.out.println("Enter NID number: ");
		se.setnID(input.nextLine());
		System.out.println("Enter address: ");
		se.setAddress(input.nextLine());
		System.out.println("Enter contact number: ");
		se.setContact(input.nextLine());
		System.out.println("Enter monthly salary: ");
		se.setMonthlySalary(input.nextDouble());
		System.out.println("Enter due amount(zero if no due): ");
		se.setDue(input.nextDouble());
		salariedEmployees.add(se);
		System.out.println("Salaried employee creation completed!");
		menu();
	}
	
	private static void createCE() {
		
		CommissionedEmployee ce = new CommissionedEmployee();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first name: ");
		ce.setFirstname(input.nextLine());
		System.out.println("Enter last name: ");
		ce.setLastName(input.nextLine());
		System.out.println("Enter NID number: ");
		ce.setnID(input.nextLine());
		System.out.println("Enter address: ");
		ce.setAddress(input.nextLine());
		System.out.println("Enter contact number: ");
		ce.setContact(input.nextLine());
		System.out.println("Enter amount sold: ");
		ce.setSoldAmount(input.nextDouble());
		System.out.println("Enter percentage on sale: ");
		ce.setPercent(input.nextDouble());
		System.out.println("Enter due amount(zero if no due): ");
		ce.setDue(input.nextDouble());
		commissionedEmployees.add(ce);
		System.out.println("Commissioned employee creation completed!");
		menu();	
	}
	
	public static void createHourlyPaidEmployee() {
		
		HourlyEmployee he = new HourlyEmployee();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first name: ");
		he.setFirstname(input.nextLine());
		System.out.println("Enter last name: ");
		he.setLastName(input.nextLine());
		System.out.println("Enter NID number: ");
		he.setnID(input.nextLine());
		System.out.println("Enter address: ");
		he.setAddress(input.nextLine());
		System.out.println("Enter contact number: ");
		he.setContact(input.nextLine());
		System.out.println("Enter worked hours: ");
		he.setWorkedHour(input.nextDouble());
		System.out.println("Enter hourly salary: ");
		he.setHourlyRate(input.nextDouble());
		System.out.println("Enter due amount(zero if no due): ");
		he.setDue(input.nextDouble());
		HourlyEmployees.add(he);
		System.out.println("Hourly employee creation completed!");
		menu();	
	}
	
	private static void SalaryAndCommissioned() {
		
		SalaryAndCommissioned sce = new SalaryAndCommissioned();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first name: ");
		sce.setFirstname(input.nextLine());
		System.out.println("Enter last name: ");
		sce.setLastName(input.nextLine());
		System.out.println("Enter NID number: ");
		sce.setnID(input.nextLine());
		System.out.println("Enter address: ");
		sce.setAddress(input.nextLine());
		System.out.println("Enter contact number: ");
		sce.setContact(input.nextLine());
		System.out.println("Enter monthly salary: ");
		sce.setMonthlySalary(input.nextDouble());
		System.out.println("Enter amount sold: ");
		sce.setSoldAmount(input.nextDouble());
		System.out.println("Enter percentage on sale: ");
		sce.setPercent(input.nextDouble());
		System.out.println("Enter due amount(zero if no due): ");
		sce.setDue(input.nextDouble());
		SalaryPlusCommissionedEmployees.add(sce);
		System.out.println("Salary and Commissioned employee creation completed!");
		menu();
	}

	public static void display(int index) {

		Scanner scan = new Scanner(System.in);
		System.out.println("1.Display Salaried Employee \n2.Display Commissioned Employee");
		System.out.println("3.Display Hourly paid Employee \n4.Display Commissioned and Salaried Employee \n5.Return to Menu");
		System.out.println("Please select employee category to display: ");
		int select = scan.nextInt();
		switch(select) {
		case 1:
				displaySE(index);
				break;
		case 2:
				displayCE(index);
				break;
		case 3:
				displayHourly(index);
				break;
		case 4:
				displaySalaryAndCommissioned(index);
				break;
		case 5:
				menu();
		default:
				System.out.println("Wrong selection! Please try again.");
				display(index);
			
		}
	}

	public static void displaySE(int index) {

		for(int i = 0; i<salariedEmployees.size(); i++) {
			
		salariedEmployee se = salariedEmployees.get(i);
		System.out.println("Employee name: " + se.getFirstName() + " " + se.getLastName());
		System.out.println("Address: " + se.getAddress());
		System.out.println("NID: " + se.getnID());
		System.out.println("Contact: " + se.getContact());
		System.out.println("Monthly Salary: " + se.getMonthlySalary());
		System.out.println("Due: " + se.getDue());	
		}
		menu();
	}
	
	public static void displayCE(int index) {
		
		for(int i = 0; i<commissionedEmployees.size(); i++) {
		
		CommissionedEmployee ce = commissionedEmployees.get(i);
		System.out.println("Employee name: " + ce.getFirstName() + " " + ce.getLastName());
		System.out.println("Address: " + ce.getAddress());
		System.out.println("NID: " + ce.getnID());
		System.out.println("Contact: " + ce.getContact());
		System.out.println("Amount sold: " + ce.getSoldAmount());
		System.out.println("Percentage on sale: " + ce.getPercent());
		System.out.println("Due: " + ce.getDue());
		System.out.println("Total payable amount: " + ce.totalPayable());
		}
		menu();
	}
	
	public static void displayHourly(int index) {
		
		for(int i = 0; i<HourlyEmployees.size(); i++) {
			
		HourlyEmployee he = HourlyEmployees.get(i);
		System.out.println("Employee name: " + he.getFirstName() + " " + he.getLastName());
		System.out.println("Address: " + he.getAddress());
		System.out.println("NID: " + he.getnID());
		System.out.println("Contact: " + he.getContact());
		System.out.println("Hours worked: " + he.getWorkedHour());
		System.out.println("Hourly salary: " + he.getHourlyRate());
		System.out.println("Due amount: " + he.getDue());
		System.out.println("Total payable amount: " + he.totalPayable());
		}
		menu();
	}
	
	public static void displaySalaryAndCommissioned(int index) {
		
		for(int i = 0; i<SalaryPlusCommissionedEmployees.size(); i++) {
		SalaryAndCommissioned sce = SalaryPlusCommissionedEmployees.get(i);
		System.out.println("Employee name: " + sce.getFirstName() + " " + sce.getLastName());
		System.out.println("Address: " + sce.getAddress());
		System.out.println("NID: " + sce.getnID());
		System.out.println("Contact: " + sce.getContact());
		System.out.println("Monthly Salary: " + sce.getMonthlySalary());
		System.out.println("Due amount: " + sce.getDue());
		System.out.println("Amount sold: " + sce.getSoldAmount());
		System.out.println("Percentage on sale: " + sce.getPercent());
		System.out.println("Total payable amount: " + sce.totalPayable());
		}
		menu();
	}
	
	public static void makePayment() {
		
		Scanner input = new Scanner(System.in);
		System.out.println(
				"1. Salaried Employee \n2. Commissioned Employee. \n3. Hourly Paid Employee \n4. Salary and Commissioned Employee \n5. Return to Menu");
		System.out.println("Please select employee type: ");
		int option = input.nextInt();
		switch (option) {
		case 1:
			paySE();
			break;
		case 2:
			payCE();
			break;
		case 3:
			payHourlyPaidEmployee();
			break;
		case 4:
			paySalaryAndCommissioned();
			break;
		case 5:
			menu();
		default:
			System.out.println("Invalid input! Please try again.");
			createEmployee();
		}
	}

	private static void paySE() {
		
		System.out.println("=== Salaried Employee List ===");
		System.out.println("Serial No. \tEmployee's Name \tTotal Payable");
		
		for(int i=0; i<salariedEmployees.size(); i++) {
			salariedEmployee sEmp = salariedEmployees.get(i);
			System.out.println((i+1)+". \t"+sEmp.getFirstName()+" "+sEmp.getLastName()+"     \t"+sEmp.totalPayable());
		}
		
		System.out.println("Select one of the salaried employee to make payment: ");
		Scanner scan = new Scanner(System.in);
		int sEmpNo = scan.nextInt();
		
		System.out.println("Enter the amount you are paying: ");
		double payingAmount = scan.nextDouble();
		if (payingAmount > 0) {
			salariedEmployee sEmp = salariedEmployees.get(sEmpNo - 1);
			sEmp.setPaidAmount(payingAmount);
			Payment pay = new Payment();
			pay.date = new Date().toString();
			pay.employeeName = sEmp.getFirstName()+ " "+sEmp.getLastName();
			pay.employeeType = "Salaried Employee";
			pay.paidAmount = payingAmount;
			paymentList.add(pay);
			System.out.println("Payment successful.");
			menu();
		} else {
			System.out.println("Invalid salary input. Please try again.");
		}
		paySE();
	}
	
	private static void payCE() {
		
		System.out.println("=== Commissioned Employee List ===");
		System.out.println("Serial No. \tEmployee's Name \tTotal Payable");
		
		for(int i=0; i<commissionedEmployees.size(); i++) {
			CommissionedEmployee cEmp = commissionedEmployees.get(i);
			System.out.println((i+1)+". \t"+cEmp.getFirstName()+" "+cEmp.getLastName()+"     \t"+cEmp.totalPayable());
		}
		
		System.out.println("Select one of the commissioned employee to make payment: ");
		Scanner scan = new Scanner(System.in);
		int cEmpNo = scan.nextInt();
		
		System.out.println("Enter the amount you are paying: ");
		double payingAmount = scan.nextDouble();
		if (payingAmount > 0) {
			CommissionedEmployee cEmp = commissionedEmployees.get(cEmpNo - 1);
			cEmp.setPaidAmount(payingAmount);
			Payment pay = new Payment();
			pay.date = new Date().toString();
			pay.employeeName = cEmp.getFirstName()+ " "+cEmp.getLastName();
			pay.employeeType = "Commissioned Employee";
			pay.paidAmount = payingAmount;
			paymentList.add(pay);
			System.out.println("Payment successful.");
			menu();
		} else {
			System.out.println("Invalid salary input. Please try again.");
		}
		payCE();
	}
	
	private static void payHourlyPaidEmployee() {
		
		System.out.println("=== Hourly Employee List ===");
		System.out.println("Serial No. \tEmployee's Name \tTotal Payable");
		
		for(int i=0; i<HourlyEmployees.size(); i++) {
			HourlyEmployee hEmp = HourlyEmployees.get(i);
			System.out.println((i+1)+". \t"+hEmp.getFirstName()+" "+hEmp.getLastName()+"     \t"+hEmp.totalPayable());
		}
		
		System.out.println("Select one of the hourly employee to make payment: ");
		Scanner scan = new Scanner(System.in);
		int hEmpNo = scan.nextInt();
		
		System.out.println("Enter the amount you are paying: ");
		double payingAmount = scan.nextDouble();
		if (payingAmount > 0) {
			HourlyEmployee hEmp = HourlyEmployees.get(hEmpNo - 1);
			hEmp.setPaidAmount(payingAmount);
			Payment pay = new Payment();
			pay.date = new Date().toString();
			pay.employeeName = hEmp.getFirstName()+ " "+hEmp.getLastName();
			pay.employeeType = "Hourly paid Employee";
			pay.paidAmount = payingAmount;
			paymentList.add(pay);
			System.out.println("Payment successful.");
			menu();
		} else {
			System.out.println("Invalid salary input. Please try again.");
		}
		payHourlyPaidEmployee();
	}
	
	private static void paySalaryAndCommissioned() {
		
		System.out.println("=== Salary & Commissioned Employee List ===");
		System.out.println("Serial \tEmployee's Name \t\tTotal Payable");
		
		for(int i=0; i<SalaryPlusCommissionedEmployees.size(); i++) {
			SalaryAndCommissioned scEmp = SalaryPlusCommissionedEmployees.get(i);
			System.out.println((i+1)+". \t"+scEmp.getFirstName()+" "+scEmp.getLastName()+"     \t"+scEmp.totalPayable());
		}
		
		System.out.println("Select one of the salary & commissioned employee to make payment: ");
		Scanner scan = new Scanner(System.in);
		int scEmpNo = scan.nextInt();
		
		System.out.println("Enter the amount you are paying: ");
		double payingAmount = scan.nextDouble();
		if (payingAmount > 0) {
			SalaryAndCommissioned scEmp = SalaryPlusCommissionedEmployees.get(scEmpNo - 1);
			scEmp.setPaidAmount(payingAmount);
			Payment pay = new Payment();
			pay.date = new Date().toString();
			pay.employeeName = scEmp.getFirstName()+ " "+scEmp.getLastName();
			pay.employeeType = "Salary & Commissioned Employee";
			pay.paidAmount = payingAmount;
			paymentList.add(pay);
			System.out.println("Payment successful.");
			menu();
		} else {
			System.out.println("Invalid salary input. Please try again.");
		}
		paySalaryAndCommissioned();
	}
	
	private static void report() {
		
		System.out.println("=== Payment Invoice ===");
		System.out.println("Serial \t Full Name \t Date \t\t Paid Amount");
		for(int i = 0; i<paymentList.size(); i++) {
			Payment pay = paymentList.get(i);
			System.out.println((i+1)+" \t "+pay.employeeName+" \t "+pay.date+" \t "+pay.paidAmount);
		}
		menu();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
