package com.sharmashivansh2907.gmail.com.ProjectionJPA.service;

import com.sharmashivansh2907.gmail.com.ProjectionJPA.repo.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepo patientRepo;

    @Transactional
    @Modifying
    public void deletePatient(Long patientID){
        patientRepo.findById(patientID).orElseThrow();
        patientRepo.deleteById(patientID);
    }


}
