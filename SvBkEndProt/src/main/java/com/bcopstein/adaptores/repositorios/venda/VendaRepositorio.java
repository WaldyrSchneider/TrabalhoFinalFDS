package com.bcopstein.adaptores.repositorios.venda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepositorio;

@Component
public class VendaRepositorio implements IVendaRepositorio {
    private IVendaCrud iVendaCrud;

    @Autowired
    public VendaRepositorio(IVendaCrud iVendaCrud) {
        this.iVendaCrud = iVendaCrud;
    }

    @Override
    public List<Venda> todos() {
        return iVendaCrud.findAll();
    }

    @Override
    public Venda procuraVenda(int numeroVenda) {
        Venda venda = iVendaCrud.findByNumeroVenda(numeroVenda);
        return venda;
    }

    @Override
    public boolean cadastra(Venda venda) {
        iVendaCrud.save(venda);
        return true;
    }

}
