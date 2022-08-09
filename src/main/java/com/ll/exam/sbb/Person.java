package com.ll.exam.sbb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    static Integer lastId = 0;

    private int id;
    private int age;
    private String name;
}
