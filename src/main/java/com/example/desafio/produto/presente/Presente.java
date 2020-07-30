package com.example.desafio.produto.presente;

import com.example.desafio.produto.Produto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "presente")
public class Presente extends Produto {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "presente_id", insertable = false, updatable = false, nullable = false,
            foreignKey = @ForeignKey(name = "presente_item_presente_fk"))
    private final List<ItemPresente> itensPresente = new ArrayList<>();

    public List<ItemPresente> getItensPresente() {
        return itensPresente;
    }
}
