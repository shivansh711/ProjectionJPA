package com.sharmashivansh2907.gmail.com.ProjectionJPA.repo;

import com.sharmashivansh2907.gmail.com.ProjectionJPA.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
}