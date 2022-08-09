package com.ll.exam.sbb;

import lombok.Getter;

public class Article {
    static Integer lastId = 0;
    @Getter
    private Integer id;
    private String title;
    private String body;

    public Article(String title, String body) {
        this.id = ++lastId;
        this.title = title;
        this.body = body;
    }

}
