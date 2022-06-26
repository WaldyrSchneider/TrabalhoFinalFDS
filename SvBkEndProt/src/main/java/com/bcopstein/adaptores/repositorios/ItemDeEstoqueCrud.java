package com.bcopstein.adaptores.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.bcopstein.negocio.entidades.ItemDeEstoque;

import java.util.List;

public interface ItemDeEstoqueCrud extends CrudRepository<ItemDeEstoque, Integer> {
    List<ItemDeEstoque> findAll();

    ItemDeEstoque findByCodigo(int codigo);
}
