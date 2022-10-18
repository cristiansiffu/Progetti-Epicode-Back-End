package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role {

	public Role() {

	}

	public Role(Roles role) {
		this.roleName = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Enumerated(EnumType.STRING)
	@Column(name = "name")
	private Roles roleName;

}
