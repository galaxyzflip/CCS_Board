package com.mycom.gk.board.service;

import java.util.List;

import com.mycom.gk.board.dto.BoardDTO;

public interface RelatedService {

	public void saveWord(BoardDTO board);
	
	public List<BoardDTO> relatedId(int id);
	
	
}
