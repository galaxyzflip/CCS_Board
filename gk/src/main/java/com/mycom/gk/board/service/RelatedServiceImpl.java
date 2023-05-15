package com.mycom.gk.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.gk.board.dto.BoardDTO;
import com.mycom.gk.board.mapper.RelatedMapper;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class RelatedServiceImpl implements RelatedService{
	
	//연관검색어 단어사용 비율
	private final int relatedPercent = 40;
	//연관검색어 동일단어 조건 개수
	private final int relatedCnt = 2;
	
	@Autowired
	private RelatedMapper relatedMapper;

	@Override
	public void saveWord(BoardDTO board) {
		
		
		// 이거 한글만됨... 한글영어 분리해서 작업하던지 다른걸 찾아보던지 해야함...
//		  String replace_text = board.getContent().replace("[^가-힣a-zA-Z0-9", " ");
//		  String trim_text = replace_text.trim();
//		  
//		  
//		  Komoran nlp = new Komoran(DEFAULT_MODEL.LIGHT); 
//		  KomoranResult analyzeResultList = nlp.analyze(trim_text);
//		  
//		  List<String> rList = analyzeResultList.getNouns();
//		  
//		  log.info("명사만 뽑혔나요?" + rList.toString());
		 

		String[] strAry = board.getContent().replace("[^가-힣a-zA-Z0-9", " ").split(" ");
		
		//List<Map<String, Integer>> wordList = new ArrayList<Map<String, Integer>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> tempList = new ArrayList<String>();
		
		for(int i=0;i<strAry.length;i++) {
			
			String key = strAry[i].toUpperCase();
			
			/*
			 * 
			 * StringBuffer sb = new StringBuffer(strAry[i].toUpperCase()); String[] temp =
			 * {"은", "는", "이", "가","으로","에서"}; String key = sb.toString();
			 */
			
			//이미 tempList에 값이 있을 경우 기존 map에 값 ++
			//없을 경우 map 에 추가
			if(tempList.contains(key)) {
				map.put(key, map.get(key)+1);
			}else {
				map.put(key.toUpperCase(), 1);
			}
			
			//중복여부 확인용 list에 단어를 넣는다.
			tempList.add(key);
			
		}
		
		Iterator<String> keys = map.keySet().iterator(); 
		
		while(keys.hasNext()) {
			String key = keys.next();
			relatedMapper.saveWord(board.getId(), key, map.get(key));
		}
		
	}

	@Override
	public List<BoardDTO> relatedId(int id) {

		return relatedMapper.relatedId(id, relatedCnt, relatedPercent);
	}

	
}
