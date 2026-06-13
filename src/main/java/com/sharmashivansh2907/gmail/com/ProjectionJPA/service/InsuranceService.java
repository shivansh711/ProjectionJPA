package com.sharmashivansh2907.gmail.com.ProjectionJPA.service;

import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.InsuranceEntity;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.PatientEntity;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.repo.InsuranceRepository;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.repo.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepo patientRepo;

    // first operation is to assign insurance to the patient
    @Transactional
    public InsuranceEntity assignInsuranceToPatient(InsuranceEntity insurance, Long patientID){
        PatientEntity patient = patientRepo.findById(patientID).orElseThrow();

        // since patientEntity own the mapping
        // patient owning the insurance
        // here patient is in the persistent state and want to access the transient state which is not alowed
        // so we will do the cascading
        patient.setInsurance(insurance); // here the patient has been dirtied and when the transactional commit
        // there will be the dirty checking and will see the patient has been dirtied
        // so now syncronization of the patient to the DB will happen

        insurance.setPatient(patient); // option just to maintain the consistency
        return insurance;
    }

    @Transactional
    public PatientEntity removeInsuranceToPatient(Long patientID){

        PatientEntity patient = patientRepo.findById(patientID).orElseThrow();
        // patient and doctor is in the persistence state because they were loaded through Hibernate

        patient.setInsurance(null);

        return patient;
    }

}
