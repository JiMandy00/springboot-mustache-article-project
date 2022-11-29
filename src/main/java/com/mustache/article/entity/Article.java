package com.mustache.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private Long id;

    private String title;
    private String content;
}
