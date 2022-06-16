package com.bcopstein.negocio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutoRepositorio;

@Component
public class ServicoProduto {
    public IProdutoRepositorio iProdutoRepositorio;

    @Autowired
    public ServicoProduto(IProdutoRepositorio iProdutoRepositorio) {
        this.iProdutoRepositorio = iProdutoRepositorio;
    }

    public ServicoProduto(){
        
    }

    public List<Produto> todos() {
        return iProdutoRepositorio.todos();
    }

    public void cadastra(Produto produto) {
        iProdutoRepositorio.cadastra(produto);
    }
    
}
