package com.propremote.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Property implements Serializable{

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="group_id")
    @Getter
    @Setter
	private GroupProperty groupProperty;
}