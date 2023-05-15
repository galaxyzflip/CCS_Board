package com.mycom.gk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.gk.board.dto.BoardDTO;
import com.mycom.gk.board.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private RelatedService relatedService;
	

	@Override
	public int addBoard(BoardDTO dto) {

		int check = boardMapper.insertBoard(dto); 
		relatedService.saveWord(dto);

		return check;
	}

	@Override
	public List<BoardDTO> findAllBoard() {

		return boardMapper.selectBoardLists();
	}

	@Override
	public BoardDTO findOneBoard(int id) {

		return boardMapper.selectBoardDetail(id);
	}

}
