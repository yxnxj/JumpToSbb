package com.ll.exam.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    static Integer lastId = 0;

    private int id;
    private int age;
    private String name;


    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
