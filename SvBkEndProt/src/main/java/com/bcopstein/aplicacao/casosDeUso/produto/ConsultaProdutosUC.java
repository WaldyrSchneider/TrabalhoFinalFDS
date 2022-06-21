package com.bcopstein.aplicacao.casosDeUso.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoProduto;

@Component
public class ConsultaProdutosUC {
    private ServicoProduto servicoProduto;

    @Autowired
    public ConsultaProdutosUC(ServicoProduto servicoProduto) {
        this.servicoProduto = servicoProduto;
    }

    public List<Produto> run() {
        return servicoProduto.todos();
    }
}
