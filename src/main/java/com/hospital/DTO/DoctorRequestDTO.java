package com.hospital.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DoctorRequestDTO {

	private String name;
	
	private String specialization;
	
	private String phone;
	
	private String email;
}
