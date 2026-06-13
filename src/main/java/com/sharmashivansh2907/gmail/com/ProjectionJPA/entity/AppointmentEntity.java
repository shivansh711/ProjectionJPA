package com.sharmashivansh2907.gmail.com.ProjectionJPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false)
    private LocalDate appointmentTime;

    @Column(length = 50)
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY) // with Lazy fetch hibernate will not load patient entity
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "patient_appointment", nullable = false)
    private PatientEntity patient; // owning side

    @ManyToOne(fetch = FetchType.LAZY)// with Lazy fetch hibernate will not load doctor entity
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private DoctorEntity doctor; // owning side
}
