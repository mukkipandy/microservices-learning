package com.learning.mukesh.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Post {

	@Id
	@GeneratedValue
	private Integer id;

	private String description;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private User user;

}
