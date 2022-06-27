package com.bcopstein.aplicacao.casosDeUso.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.ItemDeEstoque;
import com.bcopstein.negocio.servicos.ServicoItemDeEstoque;

@Component
public class InsereEstoqueUC {
    private ServicoItemDeEstoque servicoItemDeEstoque;

    @Autowired
    public InsereEstoqueUC(ServicoItemDeEstoque servicoItemDeEstoque) {
        this.servicoItemDeEstoque = servicoItemDeEstoque;
    }

    public boolean run(int codigo, int qtdade) {
        ItemDeEstoque itemDeEstoque = servicoItemDeEstoque.procuraPorProduto(codigo);
        if (itemDeEstoque == null) {
            return false;
        }
        return servicoItemDeEstoque.insere(codigo, qtdade);
    }
}
