package com.example.demo.models;

public enum TipoEmpresa {
	
	PUBLICA(1L), PRIVADA(2L), CONCESSIONARIA(3L);
	
	private final Long valor;

	TipoEmpresa(Long valor) {
		this.valor = valor;
	}
	
	public Long getValor() {
		return valor;
	}
}
