package com.bcopstein.negocio.repositorios;

import java.util.List;

import com.bcopstein.negocio.entidades.Venda;

public interface IVendaRepositorio {

    List<Venda> todos();

    Venda procuraVenda(int numeroVenda);

    boolean cadastra(Venda venda);
}
