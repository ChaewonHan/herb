package com.kh.herb.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.herb.member.model.service.MemberService;
import com.kh.herb.member.model.vo.MemberVO;

public class MemberController {
	
	@Autowired
	MemberService memberSe;
	
	@RequestMapping(value="memberList.do")
	public ModelAndView memberList(ModelAndView modelAndView) throws Exception{
		List<MemberVO> memberList = memberSe.selectMemberAll();
		modelAndView.addObject("memberList", memberList);
		modelAndView.setViewName("member/memberList");
		
		return modelAndView;
	}
}
