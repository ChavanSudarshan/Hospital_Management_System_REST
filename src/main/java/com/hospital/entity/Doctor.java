package com.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "doctor_tbl")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "specialization")
	String specialization;
	
	@Column(name = "phone")
	String phone;
	
	@Column(name = "email")
	String email;
}
