package com.sharmashivansh2907.gmail.com.ProjectionJPA;

import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.InsuranceEntity;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.PatientEntity;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testAssignInsuranceToPatient(){
        InsuranceEntity insurance = InsuranceEntity.builder()
                .provider("HDFC ERGO")
                .policyNumber("HDFC_239")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

       var updatedInsurance =  insuranceService.assignInsuranceToPatient(insurance,5L);
        System.out.println(updatedInsurance);

    }

    @Test
    public void testremoveInsuranceToPatient(){
        var removedInsurance = insuranceService.removeInsuranceToPatient(3L);
        System.out.println(removedInsurance);
    }

}
