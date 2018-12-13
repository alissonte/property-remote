package com.propremote.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    @Setter
	private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name="group_id")
    @Getter
    @Setter
	private GroupProperty group;
}