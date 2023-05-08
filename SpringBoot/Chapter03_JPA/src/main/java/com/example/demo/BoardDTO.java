package com.example.demo;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // 단순 DTO가 아닌 table과 연관된 클래스임을 명시
@Table(name="board") // sql문 작성해 table 생성할 필요 없어짐
@Data // lombok
@SequenceGenerator(name = "BOARD_SEQ_GENERATOR",
				   sequenceName = "BOARD_SEQ",
				   initialValue = 1,
				   allocationSize = 1)
public class BoardDTO {
	
	@Id // primary key
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
	private int seq;
	
	// @Id
	@Column(name="id", nullable=false, unique=true, length=30)
	private String id;
	
	@Column(nullable=false, length=30)
	private String name;
	
	@Column
	private String subject;
	
	@Column
	private String content;
	
	@CreationTimestamp
	private Timestamp logtime;
}
