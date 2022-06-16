package com.bcopstein.negocio.repositorios;

import com.bcopstein.negocio.entidades.Produto;

import java.util.List;

public interface IProdutoRepositorio {
    List<Produto> todos();
    boolean cadastra(Produto produto);
}
