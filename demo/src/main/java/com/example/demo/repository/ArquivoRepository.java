package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{

}
