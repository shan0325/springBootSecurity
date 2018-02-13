package com.spring.web.Controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.domain.Member;
import com.spring.web.domain.MemberRole;
import com.spring.web.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/signUp")
	public String signUp() {
		return "signUp";
	}
	
	@PostMapping("")
	public String create(Member member) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setUpw(passwordEncoder.encode(member.getUpw()));
		
		MemberRole role = new MemberRole();
		role.setRoleName("BASIC");
		member.setRoles(Arrays.asList(role));
		
		memberRepository.save(member);
		return "redirect:/";
	}
}
