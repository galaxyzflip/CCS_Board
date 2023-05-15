package com.mycom.gk.board.mapper;

import java.util.List;

import com.mycom.gk.board.dto.BoardDTO;

public interface BoardMapper {

	public int insertBoard(BoardDTO dto);
	
	public List<BoardDTO> selectBoardLists();
	
	public BoardDTO selectBoardDetail(int id);
}
