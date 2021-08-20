package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Person;
import com.example.demo.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer>{

}
