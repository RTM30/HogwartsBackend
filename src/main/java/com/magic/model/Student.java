package com.magic.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

/**
 * Creates a new student pojo and saves it to the database
 * @author RTM30
 *
 */
@Entity
@SequenceGenerator(name="seq", initialValue=95700, allocationSize=1)
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int id;
	
	private String firstName;
	private String lastName;
	private String studentId = setId();
	private String password;
	private String house;
	
	
	@CreationTimestamp
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	private String regDate = setDate(timestamp);
	private String regTime = setTime(timestamp);
	
	// Creates a student ID
	String setId() {
		String baseId = "010";
		String randomId =  Double.toString((int)(Math.random()*((99999-11111)+1)+11111));
		String pairedId = baseId + randomId;
		String results = pairedId.substring(0, pairedId.length() - 2);
		return results;
	}
	
	// Creates a formatted registration date
	String setDate(Timestamp timestamp){
	// Get date
	 Date date = new Date(timestamp.getTime());
	 // Format date
	 SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
	 String formattedRegDate = formatter.format(date);
	 return formattedRegDate;
	}
	
	// Creates a formatted registration time
	String setTime(Timestamp timestamp) {
		// Get time
		Time time = new Time(timestamp.getTime());
		// Format time
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a zzz");
		String formattedTime = formatter.format(time);
		return formattedTime;
	}
	
	// A default constructor is required for the findAll method
	Student(){
		super();
	}

	public Student(int id, String firstName, String lastName, String studentId, String password, String house, String regDate, String regTime) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.setStudentId(studentId);
		this.password = password;
		this.house = house;
		this.regDate = regDate;
		this.regTime = regTime;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", studentId=" + studentId
				+ ", password=" + password + ", house=" + house + ", timestamp=" + timestamp + ", regDate=" + regDate
				+ ", regTime=" + regTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
