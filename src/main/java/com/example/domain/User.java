package com.example.domain;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"pps"})})
public class User {

	@Id
	@NotEmpty
	@Column(unique=true)
	private String pps;
	
	@Version
	private Integer version;

	@NotEmpty
	@Size(max = 25)
	@Column(name = "name")
	private String name;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	//@Pattern(regexp = "^(08).*$")
	@Column(name = "mobile_phone_number")
	private String mobilePhoneNumber;
	
	
	
	public String getPps() {
		return pps;
	}
	
	public void setPps(String pps) {
		this.pps = pps;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	
	
}
