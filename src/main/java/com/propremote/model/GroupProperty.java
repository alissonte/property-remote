package com.propremote.model;

import lombok.Getter;
import lombok.Setter;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroupProperty extends AbstractEntity {

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
