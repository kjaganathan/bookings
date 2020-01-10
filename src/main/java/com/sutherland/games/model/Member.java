package com.sutherland.games.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1811958971984894628L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "name must not empty")
	private String name;

	@Column(length = 200)
	private String email;

	@NotEmpty(message = "phone must not empty")
	@Column(length = 20)
	private String phone;

	@Column(length = 20)
	private String flatNo;

	@Column(length = 200)
	private String password;

}
