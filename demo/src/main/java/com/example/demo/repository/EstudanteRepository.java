package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Integer>{

}
