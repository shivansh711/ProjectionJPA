package com.sharmashivansh2907.gmail.com.ProjectionJPA.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    private String blood_group;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_insurance", unique =true)
    @ToString.Exclude
    private InsuranceEntity insurance; // owning side

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @ToString.Exclude
    private Set<AppointmentEntity> appointments = new HashSet<>();//inverse side
}
