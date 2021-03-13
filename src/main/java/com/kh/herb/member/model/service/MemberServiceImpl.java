package com.kh.herb.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.herb.member.model.dao.MemberDAO;
import com.kh.herb.member.model.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public List<MemberVO> selectMemberAll() throws Exception {
		List<MemberVO> memberList = memberDao.selectMemberAll();
		return memberList;
	}

	@Override
	public MemberVO selectMember(String userId) throws Exception {
		MemberVO member = memberDao.selectMember(userId);
		return member;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws Exception {
		return memberDao.insertMember(memberVO);
	}

	@Override
	public int updateMember(MemberVO memberVO) throws Exception {
		return memberDao.updateMember(memberVO);
	}

	@Override
	public int deleteMember(MemberVO memberVO) throws Exception {
		return memberDao.deleteMember(memberVO);
	}
	
}
