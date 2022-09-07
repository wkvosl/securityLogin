package com.s.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.s.security.entity.Member;
import com.s.security.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/logout")
	public String logout() {
		return "logout";
	}

	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	@PostMapping("/join")
	public String join_createMember(Member member) {
		memberService.save(member);
		return "login";
	}
	
	
	@GetMapping("/all")
	@ResponseBody
	public List<Member> all() {
		return memberService.getMemberAll();
	}
	
	@GetMapping("/delall")
	public void del(Member member) {
		memberService.del(member);
	}
}
