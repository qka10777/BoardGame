package com.korea.basic1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoardGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(length = 1024)
    private String title; // 게임 이름
    private String players; // 게임 인원
    private String ageRating; // 게임 연령
    private String difficulty; // 난이도
    private String publisher; // 출판사
    private String img; // 썸네일
}
