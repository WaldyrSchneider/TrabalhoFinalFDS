package com.bcopstein.adaptores.repositorios.ItemDeVenda;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bcopstein.negocio.entidades.ItemDeVenda;

public interface ItemDeVendaCrud extends CrudRepository<ItemDeVenda, Integer>{
    List<ItemDeVenda> findAll();
    
    ItemDeVenda findByCodigo(int codigo);
}
