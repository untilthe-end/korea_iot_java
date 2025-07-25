package org.example.z_project.phr_solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getter/setter/ requiredArgsConstructor / HashCode
@AllArgsConstructor
public class Patient {
    private Long id;
    private String name;
    private int age;
    private String gender;


}
