package com.example.desafio.produto.presente;

import com.example.desafio.produto.Produto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "presente_item")
@IdClass(ItemPresente.ItemPresenteId.class)
public class ItemPresente {

    static class ItemPresenteId implements Serializable {
        Presente presente;
        Produto produto;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ItemPresenteId that = (ItemPresenteId) o;
            return Objects.equals(presente, that.presente) &&
                    Objects.equals(produto, that.produto);
        }

        @Override
        public int hashCode() {
            return Objects.hash(presente, produto);
        }
    }

    @Id
    @ManyToOne
    private Presente presente;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "presente_item_produto_fk"))
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
