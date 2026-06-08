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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.DTO.DoctorRequestDTO;
import com.hospital.DTO.DoctorResponseDTO;
import com.hospital.service.impl.DoctorServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class DoctorController {

	private final DoctorServiceImpl doctorService;

	// Create Doctor
	// POST http://localhost:8080/doctor
	@PostMapping
	public ResponseEntity<DoctorResponseDTO> saveDoctor(@RequestBody DoctorRequestDTO requestDTO) {

		log.info("Creating doctor with email: {}", requestDTO.getEmail());

		DoctorResponseDTO responseDTO = doctorService.saveDoctor(requestDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}

	// Get Doctor By Id
	// GET http://localhost:8080/doctor/1
	@GetMapping("/{id}")
	public ResponseEntity<DoctorResponseDTO> findDoctor(@PathVariable int id) {

		log.info("Fetching doctor with id: {}", id);

		DoctorResponseDTO dto = doctorService.findDoctor(id);

		return ResponseEntity.ok(dto);
	}

	// Update Complete Doctor
	// PUT http://localhost:8080/doctor/1
	@PutMapping("/{id}")
	public ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable int id, @RequestBody DoctorRequestDTO dto) {

		log.info("Updating doctor with id: {}", id);

		DoctorResponseDTO response = doctorService.updateDoctor(id, dto);

		return ResponseEntity.ok(response);
	}

	// Update Only Email
	// PATCH http://localhost:8080/doctor/1/email?email=test@gmail.com
	@PatchMapping("/{id}/email")
	public ResponseEntity<DoctorResponseDTO> updateEmail(@PathVariable int id, @RequestParam String email) {

		log.info("Updating email for doctor id: {}", id);

		DoctorResponseDTO updatedDoctor = doctorService.updateEmail(id, email);

		return ResponseEntity.ok(updatedDoctor);
	}

	// Delete Doctor
	// DELETE http://localhost:8080/doctor/1
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id) {

		log.info("Deleting doctor with id: {}", id);

		String msg = doctorService.deleteDoctor(id);

		return ResponseEntity.ok(msg);
	}
}