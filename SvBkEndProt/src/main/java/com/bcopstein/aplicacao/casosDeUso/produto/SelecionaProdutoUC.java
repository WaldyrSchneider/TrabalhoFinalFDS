package com.bcopstein.aplicacao.casosDeUso.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.servicos.ServicoItemDeEstoque;

@Component
public class SelecionaProdutoUC {
    private ServicoItemDeEstoque servicoItemDeEstoque;

    @Autowired
    public SelecionaProdutoUC(ServicoItemDeEstoque servicoItemDeEstoque) {
        this.servicoItemDeEstoque = servicoItemDeEstoque;
    }

    public boolean run(int codigo, int qtdade) {
        return servicoItemDeEstoque.procuraPorProduto(codigo).getQtdade() >= qtdade;
    }
}
