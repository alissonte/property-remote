package com.propremote.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Property {

	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Long id;
}