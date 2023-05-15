package com.mycom.gk.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycom.gk.board.dto.BoardDTO;
import com.mycom.gk.board.service.BoardService;
import com.mycom.gk.board.service.RelatedService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private RelatedService reloatedService;

	@GetMapping("/list")
	public String boardList(Model model) {
		
		List<BoardDTO> boardLists =boardService.findAllBoard();
		model.addAttribute("boardLists", boardLists);
		
		return "board/boardLists"; 
		
	}
	
	@GetMapping("/detail/{id}")
	public String boardDetail(@PathVariable("id") int id, Model model) {
		
		BoardDTO detail = boardService.findOneBoard(id);
		List<BoardDTO> relatedBoardLists = reloatedService.relatedId(id);
		model.addAttribute("detail", detail);
		model.addAttribute("relatedBoardLists", relatedBoardLists);
		
		log.info("연관자료 데이터들" + relatedBoardLists.toString());
		
		return "board/boardDetail";
	}
	
	@GetMapping("/boardInsertForm")
	public String boardInsertForm() {
		
		
		return "board/boardInsertForm";
	}
	
	@PostMapping("/boardInsertPro")
	public String boardInsertPro(BoardDTO board) {
		
		log.info(board.toString());
		
		boardService.addBoard(board);
		
		return "redirect:/list";
	}
}
