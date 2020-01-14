package com.lhj.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lhj.model.BoardVO;
import com.lhj.model.Criteria;

@Repository
public class BoardMapperImpl implements BoardMapper {

	@Autowired
	private SqlSession session;
	private static final String namespace ="com.lhj.mapper.BoardMapper";
	
	@Override
	public List<BoardVO> boardList() throws Exception {
		List<BoardVO> list = session.selectList(namespace+".boardList");
		return list;
	}

	@Override
	public void boardWrite(BoardVO board) throws Exception {
		session.insert(namespace+".boardWrite",board);
		
	}

	@Override
	public void boardUpdate(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> boardListPage(Criteria cri) throws Exception {
		List list = session.selectList(namespace+".boardListPage",cri);
		return list;
	}

	@Override
	public int boardCount(Criteria cri) throws Exception {
		return session.selectOne(namespace+".boardCount",cri);
	}
	
}
