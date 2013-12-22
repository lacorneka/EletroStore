package EletroStore.beanform;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Length.List;
import org.hibernate.validator.constraints.NotEmpty;

public class Customer {
	private String firstname;
	private String lastname;
	@NotEmpty
	@Email
	private String email;
	@List({
	    @Length(min = 5, message = "The field must be at least 5 characters"),
	    @Length(max = 50, message = "The field must be less than 50 characters")
	})
	private String password;

	@List({
	    @Length(min = 5, message = "The field must be at least 5 characters"),
	    @Length(max = 50, message = "The field must be less than 50 characters")
	})
	private String retypepassword;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	@NotEmpty
	private String phonenumber;
	@NotEmpty
	private String address;
	private String zipcode;	

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRetypepassword() {
		return retypepassword;
	}
	public void setRetypepassword(String retypepassword) {
		this.retypepassword = retypepassword;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
		

}