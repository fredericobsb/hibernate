package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="notebook")
public class Notebook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String serialNumber;
    private int ramMemoryTotal;
    private int hdSpaceTotal;
       
}