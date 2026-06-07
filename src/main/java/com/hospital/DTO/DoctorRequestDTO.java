package com.hospital.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequestDTO {

	private String name;
	
	private String specialization;
	
	private String phone;
	
	private String email;
}
