package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "booklisttable")
public class Book {

	   @Id
	   @Column(name = "bookID")
	   private Long bookID;

	   @Column(name = "bookname")
	   private String bookName;


}
