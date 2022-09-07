package com.s.security.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.s.security.entity.Member;
import com.s.security.entity.Role;
import com.s.security.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Member save(Member member) {
		
		Date date = new Date();
		
		String encodedPassword = passwordEncoder.encode(member.getPassword()) ;
		member.setPassword(encodedPassword);
		member.setPassword(member.getPassword());
		member.setRole(Role.ROLE_USER);
		member.setCreateDate(date);
		return memberRepository.save(member);
		
	}
	
	public List<Member> getMemberAll(){
		return memberRepository.findAll();
	}
	
	
	public void del(Member member) {
		memberRepository.deleteAll();
	}
}
