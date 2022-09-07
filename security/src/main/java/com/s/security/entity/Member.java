package com.s.security.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 1, name="member_seq")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="member_seq" )
	private long id;
	
	@Column(nullable = false, unique = true )
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(nullable=false, updatable = false, columnDefinition = "Date default sysdate")
	private Date createDate;


}
