package com.mycom.gk.board.service;

import java.util.List;

import com.mycom.gk.board.dto.BoardDTO;


public interface BoardService {

	public int addBoard(BoardDTO dto);
	
	public List<BoardDTO> findAllBoard();
	
	public BoardDTO findOneBoard(int id);
}
