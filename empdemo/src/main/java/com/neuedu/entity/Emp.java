package com.neuedu.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {


    private Integer id;
    private String name;
    private Integer salary;
    private String job;
}
