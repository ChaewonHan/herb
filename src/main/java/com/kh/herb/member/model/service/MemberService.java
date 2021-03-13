package com.kh.herb.member.model.service;

import java.util.List;

import com.kh.herb.member.model.vo.MemberVO;


public interface MemberService {
public List<MemberVO> selectMemberAll() throws Exception;
	
	public MemberVO selectMember(String userId) throws Exception;
	
	public int insertMember(MemberVO memberVO) throws Exception;
	
	public int updateMember(MemberVO memberVO) throws Exception;
	
	public int deleteMember(MemberVO memberVO) throws Exception;
}
