package com.bcopstein.adaptores.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.ItemDeEstoque;
import com.bcopstein.negocio.repositorios.InterfaceItemDeEstoqueRepo;

@Component
public class ItemDeEstoqueRepositorio implements InterfaceItemDeEstoqueRepo{
    private ItemDeEstoqueCrud itemDeEstoqueCrud;

    @Autowired
    public ItemDeEstoqueRepositorio(ItemDeEstoqueCrud itemDeEstoqueCrud) {
        this.itemDeEstoqueCrud = itemDeEstoqueCrud;
        itemDeEstoqueCrud.save(new ItemDeEstoque(10,10));
        itemDeEstoqueCrud.save(new ItemDeEstoque(20,10));
        itemDeEstoqueCrud.save(new ItemDeEstoque(30,10));
        itemDeEstoqueCrud.save(new ItemDeEstoque(40,10));
        itemDeEstoqueCrud.save(new ItemDeEstoque(50,10));
    }

    @Override
    public List<ItemDeEstoque> todos() {
        return itemDeEstoqueCrud.findAll();
    }

    @Override
    public boolean cadastra(ItemDeEstoque itemDeEstoque) {
        return true;
    }

    @Override
    public ItemDeEstoque procuraPorCodigo(int codigo) {
        return itemDeEstoqueCrud.findByCodigo(codigo);
    }
    
}
