package com.containersolutions.mysqldemo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;
}
