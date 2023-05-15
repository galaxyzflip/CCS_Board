package com.mycom.gk.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycom.gk.board.dto.BoardDTO;

public interface RelatedMapper {

	public void saveWord(@Param("id") int id, @Param("key")String key, @Param("value") int value);
	
	public List<BoardDTO> relatedId(@Param("id") int id, @Param("cnt") int cnt, @Param("percent") int percent);
}
