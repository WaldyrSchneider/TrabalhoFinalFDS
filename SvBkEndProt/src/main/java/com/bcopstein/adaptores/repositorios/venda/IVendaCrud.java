package com.bcopstein.adaptores.repositorios.venda;

import com.bcopstein.negocio.entidades.Venda;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IVendaCrud extends CrudRepository<Venda, Long> {
    List<Venda> findAll();

    Venda findByNumeroVenda(long numeroVenda);
}
