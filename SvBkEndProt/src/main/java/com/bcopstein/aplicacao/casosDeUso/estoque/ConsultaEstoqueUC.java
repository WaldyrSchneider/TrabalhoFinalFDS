package com.bcopstein.aplicacao.casosDeUso.estoque;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.ItemDeEstoque;
import com.bcopstein.negocio.servicos.ServicoItemDeEstoque;

@Component
public class ConsultaEstoqueUC {
    private ServicoItemDeEstoque servicoItemDeEstoque;

    public ConsultaEstoqueUC(ServicoItemDeEstoque servicoItemDeEstoque) {
        this.servicoItemDeEstoque = servicoItemDeEstoque;
    }

    public List<ItemDeEstoque> run() {
        return servicoItemDeEstoque.todos();
    }
}
