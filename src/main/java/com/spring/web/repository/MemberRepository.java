package com.spring.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.web.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {

}
