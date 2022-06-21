package com.bcopstein.adaptores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bcopstein.negocio.entidades.Produto;

public interface IProdutoCrud extends CrudRepository<Produto, Integer>{
    List<Produto> findAll();
    Produto findByCodigo(int codigo);
}
