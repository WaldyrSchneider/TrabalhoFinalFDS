package com.bcopstein.negocio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.ItemDeVenda;
import com.bcopstein.negocio.repositorios.InterfaceItemDeVendaRepo;

@Component
public class ServicoItemDeVenda {
    private InterfaceItemDeVendaRepo interfaceItemDeVendaRepo;

    @Autowired
    public ServicoItemDeVenda(InterfaceItemDeVendaRepo interfaceItemDeVendaRepo) {
        this.interfaceItemDeVendaRepo = interfaceItemDeVendaRepo;
    }

    public ServicoItemDeVenda() {

    }

    public List<ItemDeVenda> todos() {
        return interfaceItemDeVendaRepo.todos();
    }

    public boolean cadastra(ItemDeVenda itemDeVenda) {
        return interfaceItemDeVendaRepo.cadastra(itemDeVenda);
    }

    public ItemDeVenda procuraPorCodigo(int codigo) {
        return interfaceItemDeVendaRepo.procuraPorCodigo(codigo);
    }

}
