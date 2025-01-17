package com.example.loja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_estoque")
public class ItemEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item_estoque;
    private String lote_item_estoque;
    private String quantidade_item_estoque;
    private String data_entrada_item_estoque;
    private String validade_item_estoque;

    @ManyToMany
    @JoinTable(name = "item_fornecedor",
              joinColumns = @JoinColumn(name = "item_estoque_fk"),
               inverseJoinColumns = @JoinColumn(name = "fornecedor_fk"))
    List <Fornecedor> fornecedores;


    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = true)
    private Account account;

    public ItemEstoque(String lote_item_estoque, String quantidade_item_estoque, String data_entrada_item_estoque, String validade_item_estoque) {
        this.lote_item_estoque = lote_item_estoque;
        this.quantidade_item_estoque = quantidade_item_estoque;
        this.data_entrada_item_estoque = data_entrada_item_estoque;
        this.validade_item_estoque = validade_item_estoque;
    }
}