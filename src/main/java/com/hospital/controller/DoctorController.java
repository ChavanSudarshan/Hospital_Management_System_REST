package com.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.DTO.DoctorRequestDTO;
import com.hospital.DTO.DoctorResponseDTO;
import com.hospital.service.impl.DoctorServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/doctor")
public class DoctorController {

	private final DoctorServiceImpl doctorServiceImpl;

	// Save the Doctor
	@PostMapping("/save")
	public ResponseEntity<DoctorResponseDTO> saveDoctor(@RequestBody DoctorRequestDTO requestDTO) {
		log.info(requestDTO.getEmail() + " " + requestDTO.getName() + " " + requestDTO.getPhone() + " "
				+ requestDTO.getSpecialization());
		DoctorResponseDTO responseDTO = doctorServiceImpl.saveDoctor(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}

	// Fetch the doctor from DB
	@GetMapping("/id/{id}")
	public ResponseEntity<DoctorResponseDTO> findDoctor(@PathVariable int id) {
		DoctorResponseDTO dto = doctorServiceImpl.findDoctor(id);
		//return ResponseEntity.status(HttpStatus.OK).body(dto);
		return ResponseEntity.ok(dto);
	}

	// Update the doctor fully.
	@PutMapping("/id/{id}")
	public ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable int id, @RequestBody DoctorRequestDTO dto) {
		log.info("Id From Request " + id);
		DoctorResponseDTO response = doctorServiceImpl.updateDoctor(id, dto);
		return ResponseEntity.ok(response);
	}

	//Patch the Doctor Record
	@PatchMapping("/id/{id}/email/{email}")
	public ResponseEntity<DoctorResponseDTO> updateEmail(@PathVariable int id, @PathVariable String email) {
		log.info("Id From Request: " + id + " " + "Mail From Request: " + email);
		DoctorResponseDTO updatedDoctor = doctorServiceImpl.updateEmail(id, email);
		return ResponseEntity.ok(updatedDoctor);
	}
	
	
	//Delete the Doctor
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id){
		log.info("Id From Request: " + id);
		String msg = doctorServiceImpl.deleteDoctor(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(msg);
	}
}