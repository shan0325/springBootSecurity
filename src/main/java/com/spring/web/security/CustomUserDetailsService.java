package com.spring.web.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.web.repository.MemberRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return Optional.ofNullable(memberRepository.findByUemail(email))
						.filter(m -> m != null)
						.map(m -> new SecurityMember(m)).get();
	}

}
