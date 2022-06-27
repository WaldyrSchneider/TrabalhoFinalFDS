package com.bcopstein.aplicacao.servicos.restricao;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcopstein.negocio.entidades.ItemCarrinho;

public class RestricaoQnt implements IRestricao{

    @Autowired
    public RestricaoQnt() {

    }

    public boolean restricao(ItemCarrinho[] itens) {
        for(ItemCarrinho item: itens) {
            if(item.getQuantidade() > 4) {
                return true;
            }
        }
        return false;
    }
}
