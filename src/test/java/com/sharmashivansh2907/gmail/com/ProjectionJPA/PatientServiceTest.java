package com.sharmashivansh2907.gmail.com.ProjectionJPA;

import com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO.BloodGroupStats;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO.CPatientInfo;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO.IPatientInfo;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.PatientEntity;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.repo.PatientRepo;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatient(){
        List<IPatientInfo> patientEntityList = patientRepo.getAllPatientInfo();
        for(IPatientInfo p: patientEntityList){
            System.out.println("{" + " id: " +
                    p.getId() + ", name: "
                            + p.getName() + "," +
                    " email: "
                            + p.getEmail() + "}"
            );
        }
    }


    @Test
    public void testCPatient(){
        List<CPatientInfo> patientEntityList = patientRepo.getAllPatientConcrete();
        for(CPatientInfo p: patientEntityList){
            System.out.println(p);
        }
    }

    @Test
    public void testgetCPatientById(){
        CPatientInfo patientEntityList = patientRepo.getPatientInfoById(1L);
        System.out.println(patientEntityList);
    }

    @Test
    public void testBloodGroupPatient(){
        List<BloodGroupStats> patientEntityList = patientRepo.getBloodGroupStat();
        for(BloodGroupStats p: patientEntityList){
            System.out.println(p);
        }
    }

    @Test
    public void testupdatePatient(){
        int rowEffectedAfterTheUpdate = patientRepo.updatePatientNameWithId("Anuj Sharma",1L);
        System.out.println(rowEffectedAfterTheUpdate);
    }

    @Test
    public void testgetAllPatient(){
        List<PatientEntity> patientList = patientRepo.findAll();
        for(PatientEntity p : patientList){
            System.out.println(p);
        }
    }

//    @Test
//    public void testDeletePatient(){
//        int rowEffectedAfterTheDelete = patientRepo.deletePatientWithId(13L);
//        System.out.println(rowEffectedAfterTheDelete);
//    }


    @Test
    public void testDeletePatient(){
          patientService.deletePatient(2L);
    }
}
