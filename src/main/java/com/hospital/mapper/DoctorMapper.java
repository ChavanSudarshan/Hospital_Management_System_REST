package com.hospital.mapper;

import org.springframework.stereotype.Component;

import com.hospital.DTO.DoctorRequestDTO;
import com.hospital.DTO.DoctorResponseDTO;
import com.hospital.entity.Doctor;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorRequestDTO dto) {

        Doctor doctor = new Doctor();

        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setPhone(dto.getPhone());
        doctor.setEmail(dto.getEmail());

        return doctor;
    }

    public DoctorResponseDTO toResponse(Doctor doctor) {

        DoctorResponseDTO dto = new DoctorResponseDTO();

        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setPhone(doctor.getPhone());
        dto.setEmail(doctor.getEmail());

        return dto;
    }
}
