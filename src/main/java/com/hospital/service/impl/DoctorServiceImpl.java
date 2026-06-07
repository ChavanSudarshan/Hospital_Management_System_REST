package com.hospital.service.impl;

import org.springframework.stereotype.Service;

import com.hospital.DTO.DoctorRequestDTO;
import com.hospital.DTO.DoctorResponseDTO;
import com.hospital.entity.Doctor;
import com.hospital.mapper.DoctorMapper;
import com.hospital.repository.DoctorRepository;
import com.hospital.service.DoctorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {

	private final DoctorRepository repository;

	private final DoctorMapper doctorMapper;

	@Override
	public DoctorResponseDTO saveDoctor(DoctorRequestDTO dto) {
		Doctor doctor = doctorMapper.toEntity(dto);
		Doctor savedDoctor = repository.save(doctor);
		return doctorMapper.toResponse(savedDoctor);
	}

	@Override
	public DoctorResponseDTO findDoctor(int id) {
		Doctor doctor = repository.findById(id);
		return doctorMapper.toResponse(doctor);
	}

	@Override
	public DoctorResponseDTO updateDoctor(int id, DoctorRequestDTO dto) {

		Doctor doctor = repository.findById(id);

		if (dto.getName() != null) {
			doctor.setName(dto.getName());
		}

		if (dto.getSpecialization() != null) {
			doctor.setSpecialization(dto.getSpecialization());
		}

		if (dto.getPhone() != null) {
			doctor.setPhone(dto.getPhone());
		}

		if (dto.getEmail() != null) {
			doctor.setEmail(dto.getEmail());
		}

		Doctor updatedDoctor = repository.save(doctor);

		return doctorMapper.toResponse(updatedDoctor);
	}

	public DoctorResponseDTO updateEmail(int id, String email) {

		Doctor doctor = repository.findById(id);

		if (email != null && !email.isBlank()) {
			doctor.setEmail(email);
		}

		Doctor updatedDoctor = repository.save(doctor);

		return doctorMapper.toResponse(updatedDoctor);
	}

	public String deleteDoctor(int id) {
		repository.deleteById(id);
		return "Deleted Successfully";
	}
}