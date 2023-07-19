package in.adit.model;

public class Employee {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int number;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getNumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Employee [username = " + username + ", password = " + password + ", firstname = " + firstname + ", lastname = " + lastname +  ", email = " + email +  ", mobile number = " + number +"]";
	}
}
