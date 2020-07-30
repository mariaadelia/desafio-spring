package com.example.desafio.ingrediente;

import javax.persistence.*;

@Entity
@Table(name = "ingrediente", uniqueConstraints = {
        @UniqueConstraint(name = "ingrediente_nome_uk", columnNames = { "nome" })
})
public class Ingrediente {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
