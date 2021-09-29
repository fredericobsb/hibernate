package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/* MANY TO MANY ONIDIRECIONAL */
@Getter
@Setter
@Entity
@Table(name = "Pessoa")
@SecondaryTable(name = "health_care", pkJoinColumns ={ @PrimaryKeyJoinColumn(name = "id") })
public class Pessoa {

    @Id
    private int id;

    @Column
    private String name;

    @Column(table = "health_care", name = "company_name")
    private String companyName;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="pessoa_has_notebooks", joinColumns=
    {@JoinColumn(name="pessoa_id")}, inverseJoinColumns=
      {@JoinColumn(name="notebook_id")})
    private List<Notebook> notebooks;
}