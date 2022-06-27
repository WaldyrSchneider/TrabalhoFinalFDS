package com.bcopstein.aplicacao.servicos.restricao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.ItemCarrinho;

@Component
public class ServicoRestricao {
    private IRestricao iRestricao;

    @Autowired
    public ServicoRestricao(IRestricao iRestricao) {
        this.iRestricao = iRestricao;
    }

    public boolean restricao(ItemCarrinho[] itens) {
        return iRestricao.restricao(itens);
    }
}
