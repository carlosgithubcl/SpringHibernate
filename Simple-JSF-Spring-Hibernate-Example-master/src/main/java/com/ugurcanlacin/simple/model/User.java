package com.ugurcanlacin.simple.model;

// default package
// Generated 14.�ub.2015 03:57:06 by Hibernate Tools 4.3.1

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "users", schema = "userdb")
public class User implements java.io.Serializable {

	private Integer id;
	private String name;
	private String surname;

	public User() {
	}

	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Id
	//@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)

    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_users")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_users")
    @SequenceGenerator(name = "id_users", sequenceName = "id_users")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", length = 20)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
