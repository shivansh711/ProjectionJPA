package com.sharmashivansh2907.gmail.com.ProjectionJPA.repo;

import com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO.BloodGroupStats;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO.CPatientInfo;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO.IPatientInfo;
import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<PatientEntity,Long> {

    @Query("""
       select p.id as id,
              p.name as name,
              p.email as email
       from PatientEntity p
       """)
    List<IPatientInfo> getAllPatientInfo();

    @Query("select new com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO.CPatientInfo(p.id,p.name,p.email) from PatientEntity p where p.id = :ID")
    CPatientInfo getPatientInfoById(@Param("ID") Long ID);

    @Query("select new com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO.CPatientInfo(p.id, p.name,p.email) from PatientEntity p")
    List<CPatientInfo> getAllPatientConcrete();

    @Query("select new com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO.BloodGroupStats(p.blood_group, COUNT(p)) from PatientEntity p group by p.blood_group order by COUNt(p)")
    List<BloodGroupStats> getBloodGroupStat();

    @Transactional
    @Modifying
    @Query("UPDATE PatientEntity p set p.name= :name where p.id = :ID")
    int updatePatientNameWithId(@Param("name") String name, @Param("ID") Long ID);

    @Transactional
    @Modifying
    @Query("DELETE PatientEntity p where p.id = :ID")
    int deletePatientWithId(@Param("ID") Long ID);



}
