package com.jameslab.springboot.domain.posts;

import com.jameslab.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id // (2)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // (3)
    private Long id;

    @Column(length = 500, nullable = false) // (4)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    private String author;

    @Builder // (7)
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

}
