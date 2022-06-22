package com.bcopstein.negocio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.ItemDeEstoque;
import com.bcopstein.negocio.repositorios.InterfaceItemDeEstoqueRepo;


@Component
public class ServicoItemDeEstoque {
    public InterfaceItemDeEstoqueRepo interfaceItemDeEstoqueRepo;

    @Autowired
    public ServicoItemDeEstoque(InterfaceItemDeEstoqueRepo interfaceItemDeEstoqueRepo) {
        this.interfaceItemDeEstoqueRepo = interfaceItemDeEstoqueRepo;
    }

    public ServicoItemDeEstoque() {}

    public List<ItemDeEstoque> todos(){
        return interfaceItemDeEstoqueRepo.todos();
    }

    public boolean cadastra(ItemDeEstoque itemDeEstoque) {
        return interfaceItemDeEstoqueRepo.cadastra(itemDeEstoque);
    }

    public ItemDeEstoque procuraPorProduto(int codigo) {
        return interfaceItemDeEstoqueRepo.procuraPorCodigo(codigo);
    }
}
