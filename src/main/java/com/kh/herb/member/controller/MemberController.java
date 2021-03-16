package com.kh.herb.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.herb.member.model.service.MemberService;
import com.kh.herb.member.model.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberSe;
	
	@RequestMapping("memberLoginForm.do")
	public ModelAndView loginMemberForm(ModelAndView modelAndView) {
		modelAndView.setViewName("member/memberLoginPage");
		
		return modelAndView;
	}
	
	@RequestMapping(value="loginMember.do", method=RequestMethod.POST)
	public ModelAndView loginMember(ModelAndView modelAndView, @ModelAttribute MemberVO member, HttpSession session) throws Exception{
		boolean result = memberSe.loginMember(member, session);
		if(result == true) {
			modelAndView.setViewName("redirect:/memberLoginForm.do");
			
		}else {
			modelAndView.setViewName("member/memberLoginPage");
			modelAndView.addObject("msg", "실패");
		}
		return modelAndView;
	}
	@RequestMapping(value="logoutMember.do", method=RequestMethod.GET)
	public ModelAndView logoutForm(ModelAndView modelAndView, HttpSession session) throws Exception{
		memberSe.logoutMember(session);
		modelAndView.setViewName("member/memberLoginPage");
		modelAndView.addObject("msg","성공");
		return modelAndView;
	}
	
	@RequestMapping("memberInsertForm.do")
	public ModelAndView insertMemberForm(ModelAndView modelAndView) {
		modelAndView.setViewName("member/memberInsertForm");
		
		return modelAndView;
	}
	@RequestMapping(value="memberInsert.do", method=RequestMethod.POST)
	public ModelAndView insertMember(MemberVO member, ModelAndView modelAndView) throws Exception{
		
		memberSe.insertMember(member);
		
		modelAndView.setViewName("member/memberJoinComplete");
		
		return modelAndView;
	}
	@RequestMapping(value="myInfo.do", method=RequestMethod.GET)
	public String memberSelectOne(Model model, @RequestParam("id") String id) throws Exception{
		MemberVO member = memberSe.selectMember(id);
		model.addAttribute("member",member);
		return "member/myInfo";
	}
	
	@ResponseBody
	@RequestMapping("memberJoinIdCheck.do")
	public int JoinIdCheck(MemberVO member) throws Exception{
		System.out.println(member.getUserId());
		int cnt = memberSe.joinIdCheck(member);
		System.out.println(cnt);
		return cnt;
		
	}
	
	@RequestMapping("memberUpdate.do")
	public ModelAndView updateMemberForm(RedirectAttributes Redirect, ModelAndView modelAndView, 
			MemberVO member, HttpSession session) throws Exception{
			
			int cnt = memberSe.updateMember(member);
			if(cnt > 0) {
				modelAndView.setViewName("redirect:/memberLoginForm.do");
				Redirect.addFlashAttribute("msg", "수정성공");
			}
			else {
				modelAndView.setViewName("redirect:/memberLoginForm.do");
				modelAndView.addObject("msg","수정실패");
			}
		
		return modelAndView;
	}
	
	@RequestMapping("memberDeleteForm.do")
	public ModelAndView memberDeleteForm(ModelAndView modelAndView) {
		modelAndView.setViewName("member/memberDeleteForm");
		return modelAndView;
	}
	
	@RequestMapping("memberDelete.do")
	public ModelAndView memberDelete(RedirectAttributes redirect, ModelAndView modelAndView, 
			MemberVO member, HttpSession session) throws Exception {
		
		if(session.getAttribute("userId").equals(member.getUserId())) {
			int result = memberSe.deleteMember(member);
			if(result != 0) {
				modelAndView.setViewName("redirect:/memberLoginForm.do");
				redirect.addFlashAttribute("msg","탈퇴성공");
				session.invalidate();
			}else {
				modelAndView.setViewName("redirect:/memberDeleteForm.do");
				redirect.addFlashAttribute("msg","탈퇴실패");
			}
		}else {
			modelAndView.setViewName("redirect:/memberDeleteForm.do");
			redirect.addFlashAttribute("msg","탈퇴실패");
		}
			return modelAndView;
	}
	
}
