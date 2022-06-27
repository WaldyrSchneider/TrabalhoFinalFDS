package com.bcopstein.negocio.repositorios;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemDeEstoque;

public interface InterfaceItemDeEstoqueRepo {
    List<ItemDeEstoque> todos();

    boolean cadastra(ItemDeEstoque itemDeEstoque);

    ItemDeEstoque procuraPorCodigo(int codigo);

    boolean remove(ItemDeEstoque itemDeEstoque, int qtdade);

    boolean insere(int codigo, int qtdade);
}
