package com.bcopstein.aplicacao.casosDeUso.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.dtos.ParamSubtotal_DTO;
import com.bcopstein.negocio.entidades.ItemCarrinho;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoProduto;

@Component
public class SubTotalUC {
    private ServicoProduto servicoProduto;

    @Autowired
    public SubTotalUC(ServicoProduto servicoProduto) {
        this.servicoProduto = servicoProduto;
    }

    public Integer[] run(ParamSubtotal_DTO param) {
        ItemCarrinho[] itens = param.getItens();
        Integer[] resp = new Integer[4];

        int subtotal = 0;
        int imposto = 0;

        for (ItemCarrinho item : itens) {
            Produto produto = servicoProduto.procuraPorCodProduto(item.getCodigo());
            subtotal += produto.getPreco() * item.getQuantidade();
        }

        resp[0] = subtotal;
        resp[1] = imposto;
        resp[2] = subtotal + imposto;
        resp[3] = 20;
        return resp;
    }
}
