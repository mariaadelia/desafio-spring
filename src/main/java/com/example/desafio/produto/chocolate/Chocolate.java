package com.example.desafio.produto.chocolate;

import com.example.desafio.produto.Produto;

import javax.persistence.*;

@Entity
@Table(name = "chocolate")
public class Chocolate extends Produto {

    @Column(name = "preco", nullable = false)
    private Double preco;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
