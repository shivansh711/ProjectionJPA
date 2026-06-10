package com.sharmashivansh2907.gmail.com.ProjectionJPA;

import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.InsuranceEntity;
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
                .policyNumber("HDFC_237")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

       var updatedInsurance =  insuranceService.assignInsuranceToPatient(insurance,2L);
        System.out.println(updatedInsurance);

    }

}
