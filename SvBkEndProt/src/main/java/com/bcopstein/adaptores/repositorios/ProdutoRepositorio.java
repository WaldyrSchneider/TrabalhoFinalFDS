package com.bcopstein.adaptores.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutoRepositorio;

@Component
public class ProdutoRepositorio implements IProdutoRepositorio{
    private IProdutoCrud produtoCrud;

    @Autowired
    public ProdutoRepositorio(IProdutoCrud produtoCrud) {
        this.produtoCrud = produtoCrud;
        produtoCrud.save(new Produto(10, "Geladeira", 2500.0, 10));
        produtoCrud.save(new Produto(20, "Fogao", 1200.0, 0));
        produtoCrud.save(new Produto(30, "Lava louça", 4300.0, 7));
        produtoCrud.save(new Produto(40, "Lava roupa", 3350.0, 11));
        produtoCrud.save(new Produto(50, "Aspirador de pó", 780.0, 22));
    }

    @Override
    public List<Produto> todos() {
        List<Produto> aux = produtoCrud.findAll();
        return aux;
    }

    @Override
    public boolean cadastra(Produto produto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Produto procuraPorCodProduto(int codigo) {
        Produto produto = produtoCrud.findByCodigo(codigo);
        return produto;
    }
    
}
