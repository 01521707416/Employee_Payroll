package felixgenPayroll;

public abstract class Employee {

	private String firstName;
	private String lastName;
	private String nID;
	private String address;
	private String contact;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String nID, String address, String contact) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.nID = nID;
		this.address = address;
		this.contact = contact;
	}
	
	public abstract double totalPayable();
	
	public void setFirstname(String firstName) {
		
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getnID() {
		return nID;
	}

	public void setnID(String nID) {
		this.nID = nID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
