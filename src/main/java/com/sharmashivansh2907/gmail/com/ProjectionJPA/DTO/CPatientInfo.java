package com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CPatientInfo {
    private final Long ID;
    private final String name;
    private final String email;
}
