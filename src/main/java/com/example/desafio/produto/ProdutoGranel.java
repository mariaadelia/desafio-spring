package com.example.desafio.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produto_granel")
public class ProdutoGranel extends Produto{
	
	@Column(name = "peso", nullable = false)
    private Double peso;
	
	@Column(name = "preco_por_quilograma", nullable = false)
    private Double precoPorQuilograma;


	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPrecoPorQuilograma() {
		return precoPorQuilograma;
	}

	public void setPrecoPorQuilograma(Double precoPorQuilograma) {
		this.precoPorQuilograma = precoPorQuilograma;
	}

}
