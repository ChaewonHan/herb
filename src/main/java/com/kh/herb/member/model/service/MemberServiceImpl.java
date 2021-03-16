package com.kh.herb.member.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.herb.member.model.dao.MemberDAO;
import com.kh.herb.member.model.vo.MemberVO;

@Service
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

	@Override
	public int joinIdCheck(MemberVO member) throws Exception {
		int cnt = memberDao.joinIdCheck(member);
		return cnt;
	}

	@Override
	public boolean loginMember(MemberVO member, HttpSession session) {
		
		boolean result = memberDao.loginMember(member);
		if (result == true) {
			session.setAttribute("userId",member.getUserId());
		}
		return result;
	}

	@Override
	public void logoutMember(HttpSession session) {
		memberDao.logoutMember(session);
	}
	
}
