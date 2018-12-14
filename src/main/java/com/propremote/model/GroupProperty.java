package com.propremote.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class GroupProperty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String name;

    @OneToMany(mappedBy = "groupProperty", fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<Property> properties;


}
