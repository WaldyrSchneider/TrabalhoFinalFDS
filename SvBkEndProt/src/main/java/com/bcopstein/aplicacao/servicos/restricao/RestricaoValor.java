package com.bcopstein.aplicacao.servicos.restricao;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcopstein.negocio.entidades.ItemCarrinho;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoProduto;

public class RestricaoValor implements IRestricao{
    private ServicoProduto ServicoProduto;

    @Autowired
    public RestricaoValor(ServicoProduto ServicoProduto) {
        this.ServicoProduto = ServicoProduto;
    }
    
    public boolean restricao(ItemCarrinho[] itens) {
        double valorTotal = 0;
        for(ItemCarrinho item: itens) {
            Produto produto = ServicoProduto.procuraPorCodProduto(item.getCodigo());
            valorTotal += produto.getPreco() * item.getQuantidade();
        }
        if(valorTotal > 4000) {
            return true;
        }
        return false;
    }
}
