package com.s.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s.security.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	public Member findByUsername(String username) ;

}
