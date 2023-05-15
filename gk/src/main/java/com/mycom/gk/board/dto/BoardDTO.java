package com.mycom.gk.board.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {

	private int id;
	private String title;
	private String content;
	private Date regDate;
}
