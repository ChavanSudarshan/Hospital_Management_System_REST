package com.hospital.service;

import org.springframework.stereotype.Repository;

import com.hospital.DTO.DoctorRequestDTO;
import com.hospital.DTO.DoctorResponseDTO;

@Repository
public interface DoctorService {

	DoctorResponseDTO saveDoctor(DoctorRequestDTO dto);

	//DoctorResponseDTO saveDoctor(DoctorRequestDTO dto); 
}
