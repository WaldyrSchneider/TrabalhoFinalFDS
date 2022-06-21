package com.bcopstein.aplicacao.casosDeUso.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoProduto;

@Component
public class SelecionaProdutoUC {
    private ServicoProduto servicoProduto;

    @Autowired
    public SelecionaProdutoUC(ServicoProduto servicoProduto) {
        this.servicoProduto = servicoProduto;
    }

    public boolean run(int codigo, int qtdade) {
        Produto produto = servicoProduto.procuraPorCodProduto(codigo);
        return produto.getQtdade() >= qtdade;
    }
}
