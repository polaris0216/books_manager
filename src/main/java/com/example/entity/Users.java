package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	 @Id
	    @SequenceGenerator(name = "USERS_ID_GENERATOR", sequenceName = "USERS_ID_SEQ", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_ID_GENERATOR")
	    @Column(name = "ID")
	    private Integer id;

	    @Column(name = "NAME")
	    private String name;

	    @Column(name = "EMAIL")
	    private String email;

	    @Column(name = "PASSWORD")
	    private String password;

	    public Integer getId() {
	        return this.id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getName() {
	        return this.name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return this.email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return this.password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Column(name = "ROLE")
	    private String role;


	    public String getRole() {
	        return this.role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }
}
