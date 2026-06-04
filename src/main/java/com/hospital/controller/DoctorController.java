package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.DTO.DoctorRequestDTO;
import com.hospital.DTO.DoctorResponseDTO;
import com.hospital.service.impl.DoctorServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = "/doctor")
public class DoctorController {

	@Autowired
	private DoctorServiceImpl doctorServiceImpl;
	
	@PostMapping("/save")
	public ResponseEntity<DoctorResponseDTO> saveDoctor(DoctorRequestDTO requestDTO){
		DoctorResponseDTO responseDTO = doctorServiceImpl.saveDoctor(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}
	
}
