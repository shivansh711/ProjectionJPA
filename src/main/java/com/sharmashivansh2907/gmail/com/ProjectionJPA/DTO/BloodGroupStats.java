package com.sharmashivansh2907.gmail.com.ProjectionJPA.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class BloodGroupStats {

    private final String blood_group;
    private final Long Count;
}
