package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class BookRequest implements Serializable {

    /**
     * 名前
     */
    private long bookID;

    /**
     * 住所
     */
    private String bookName;

}