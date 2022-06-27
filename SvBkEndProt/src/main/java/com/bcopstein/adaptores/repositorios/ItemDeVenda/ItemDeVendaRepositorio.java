package com.bcopstein.adaptores.repositorios.ItemDeVenda;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.ItemDeVenda;
import com.bcopstein.negocio.repositorios.InterfaceItemDeVendaRepo;

@Component
public class ItemDeVendaRepositorio implements InterfaceItemDeVendaRepo{
    private ItemDeVendaCrud itemDeVendaCrud;

    public ItemDeVendaRepositorio(ItemDeVendaCrud itemDeVendaCrud) {
        this.itemDeVendaCrud = itemDeVendaCrud;
    }

    @Override
    public List<ItemDeVenda> todos() {
        return itemDeVendaCrud.findAll();
    }

    @Override
    public boolean cadastra(ItemDeVenda itemDeVenda) {
        itemDeVendaCrud.save(itemDeVenda);
        return true;
    }

    @Override
    public ItemDeVenda procuraPorCodigo(int codigo) {
        return itemDeVendaCrud.findByCodigo(codigo);
    }
    
}
