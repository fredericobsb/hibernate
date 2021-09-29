package com.example.demo.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Empresa {

	@Id
    @GeneratedValue
    private int id;

    private String nomeEmpresa;
    
    private String razaoSocial;
    
    private String cnpj;
    
    private TipoEmpresa tipoEmpresa;
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Collection<EmpresaPessoa> empresaPessoaList;
}