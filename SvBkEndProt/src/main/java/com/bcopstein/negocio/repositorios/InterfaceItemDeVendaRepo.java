package com.bcopstein.negocio.repositorios;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemDeVenda;

public interface InterfaceItemDeVendaRepo {
    List<ItemDeVenda> todos();

    boolean cadastra(ItemDeVenda itemDeVenda);

    ItemDeVenda procuraPorCodigo(int codigo);
}
