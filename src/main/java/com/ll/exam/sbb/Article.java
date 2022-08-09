package com.ll.exam.sbb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {
    static Integer lastId = 0;
    private Integer id;
    private String title;
    private String body;

    public Article(String title, String body) {
        this.id = ++lastId;
        this.title = title;
        this.body = body;
    }

}
