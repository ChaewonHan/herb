package com.kh.herb.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.herb.member.model.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemberDAO() {
	}
	
	public List<MemberVO> selectMemberAll() throws Exception{
		List<MemberVO> memberList = sqlSession.selectList("Member.selectListAll");
		return memberList;
	}
	
	public MemberVO selectMember(String userId) throws Exception{
		MemberVO member = sqlSession.selectOne("Member.selectMember", userId);
		return member;
	}
	
	public int insertMember(MemberVO memberVO) throws Exception{
		int result = sqlSession.insert("Member.insertMember", memberVO);
		return result;
	}
	
	public int updateMember(MemberVO memberVO) throws Exception{
		int result = sqlSession.update("Member.updateMember",memberVO);
		return result;
	}
	
	public int deleteMember(MemberVO memberVO) throws Exception{
		int result = sqlSession.update("Member.deleteMember",memberVO);
		return result;
	}
	
	
}
