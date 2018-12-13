package com.propremote.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    @Setter
	private Long id;

    @Getter
    @Setter
	private String key;

    @Getter
    @Setter
	private String value;

    @ManyToOne
    @JoinColumn(name="group_id")
    @Getter
    @Setter
	private GroupProperty groupProperty;
}