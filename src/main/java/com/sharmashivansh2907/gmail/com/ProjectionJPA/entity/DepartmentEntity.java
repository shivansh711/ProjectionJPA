package com.sharmashivansh2907.gmail.com.ProjectionJPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false,unique = true,length = 100)
    private String name;

    @CreationTimestamp
    private LocalDate createdAt;

    @OneToOne // one department will have one head doctor
    @JoinColumn(nullable = false)
    private DoctorEntity headDoctor; // owning side

    @ManyToMany // one department will also have other doctor also
    private Set<DoctorEntity> doctors = new HashSet<>();
}
