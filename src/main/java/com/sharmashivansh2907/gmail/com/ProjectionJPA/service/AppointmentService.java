package com.sharmashivansh2907.gmail.com.ProjectionJPA.service;

import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.AppointmentEntity;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.DoctorEntity;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.PatientEntity;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.repo.AppointmentRepository;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.repo.DoctorRepository;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.repo.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepo patientRepo;

    @Transactional
    public AppointmentEntity createANewAppointment(AppointmentEntity appointment , Long patientID, Long doctorID){
        PatientEntity patient = patientRepo.findById(patientID).orElseThrow();
        DoctorEntity doctor = doctorRepository.findById(doctorID).orElseThrow();
        // patient and doctor is in the persistence state because they were loaded through Hibernate
        //PatientEntity patient = patientRepo.findById(patientID).orElseThrow();
        //DoctorEntity doctor = doctorRepository.findById(doctorID).orElseThrow();




        //appointment is in the transient state because it was most likely created using: appointmentEntity appointment = new AppointmentEntity();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment); // so here we are taking this appointment from transient to persistence

        return appointment;
    }
}
