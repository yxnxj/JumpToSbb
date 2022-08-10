package com.ll.exam.sbb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    public static Integer lastId = 0;

    private int id;
    private int age;
    private String name;


    public Person(int age, String name) {
        this.id = ++lastId;
        this.age = age;
        this.name = name;
    }
}
