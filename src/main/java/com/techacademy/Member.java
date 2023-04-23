package com.techacademy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
    private int id;
    private String name;
    private String gender;
    private int age;
}
