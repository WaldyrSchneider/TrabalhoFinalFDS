package com.bcopstein.aplicacao.servicos.restricao;

import com.bcopstein.negocio.entidades.ItemCarrinho;

public interface IRestricao {
    boolean restricao(ItemCarrinho[] itens);
}
