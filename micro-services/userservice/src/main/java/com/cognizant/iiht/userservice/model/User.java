package com.cognizant.iiht.userservice.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;




@Entity
@Table(name = "user")
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "us_id")
     private long id;
     
     @NotNull
     @Column(name = "us_username")
     private String username;
     
     @NotNull
     @Size(min=8)
     @Column(name = "us_password")
     private String password;
     
     
     @NotNull
     @Column(name = "us_first_name")
     private String firstname;
     
     @NotNull
     @Column(name = "us_last_name")
     private String lastname;
     
     @NotNull
     @Positive(message="Contact Number should be positive value")
     @Column(name = "us_contact_number")
     private long contactnumber;
     
     
     @Column(name = "us_reg_code")
     private String regCode="";
     
     @NotNull
     @Column(name = "us_role")
     private String role;
     
     @Column(name = "us_active")
     private Boolean active=false;
     
     @Column(name = "us_confirmed_signup")
     private Boolean confirmedSignup=false;
     
     @Column(name = "us_reset_password")
     private Boolean resetPassword=false;
     
     @Column(name = "us_reset_password_date")
     private Date resetPasswordDate;
     
     @OneToOne(mappedBy="user",cascade=CascadeType.ALL)
     private Mentor mentor;
     
	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public long getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(long contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getConfirmedSignup() {
		return confirmedSignup;
	}

	public void setConfirmedSignup(Boolean confirmedSignup) {
		this.confirmedSignup = confirmedSignup;
	}

	public Boolean getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(Boolean resetPassword) {
		this.resetPassword = resetPassword;
	}

	public Date getResetPasswordDate() {
		return resetPasswordDate;
	}

	public void setResetPasswordDate(Date resetPasswordDate) {
		this.resetPasswordDate = resetPasswordDate;
	}


}
