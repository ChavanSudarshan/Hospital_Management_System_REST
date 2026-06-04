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
public class DoctorServiceImpl implements DoctorService{

	private final DoctorRepository repository;
	
	private final DoctorMapper doctorMapper;
	
	@Override
	public DoctorResponseDTO saveDoctor(DoctorRequestDTO dto) {

	    Doctor doctor = doctorMapper.toEntity(dto);

	    Doctor savedDoctor = repository.save(doctor);

	    return doctorMapper.toResponse(savedDoctor);
	}
	
}

