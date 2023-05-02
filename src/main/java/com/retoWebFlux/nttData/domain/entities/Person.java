package com.retoWebFlux.nttData.domain.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.data.relational.core.mapping.RelationalMappingContext;


@Getter
@Setter
@NoArgsConstructor
public class Person {
    private String name;
    private String gender;
    private Integer age;
    //private String identification;
    private String address;
    //private String phone;
}
