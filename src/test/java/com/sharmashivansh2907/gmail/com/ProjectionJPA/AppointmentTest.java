package com.sharmashivansh2907.gmail.com.ProjectionJPA;

import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.AppointmentEntity;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateANewAppointment(){
        AppointmentEntity appointment = AppointmentEntity.builder()
                .reason("")
                .appointmentTime(LocalDate.of(2025,1,1))
                .build();

        var createnewAppointment = appointmentService.createANewAppointment(appointment,2L,2L);
        System.out.println(createnewAppointment);
    }

}
