package com.bcopstein.negocio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepositorio;

@Component
public class ServicoVenda {
    private IVendaRepositorio iVendaRepositorio;

    @Autowired
    public ServicoVenda(IVendaRepositorio iVendaRepositorio) {
        this.iVendaRepositorio = iVendaRepositorio;
    }

    public ServicoVenda() {
    }

    public List<Venda> todos() {
        return iVendaRepositorio.todos();
    }

    public Venda procuraVenda(int numeroVenda) {
        return iVendaRepositorio.procuraVenda(numeroVenda);
    }

    public boolean cadastraVenda(Venda venda) {
        return iVendaRepositorio.cadastra(venda);
    }
}
