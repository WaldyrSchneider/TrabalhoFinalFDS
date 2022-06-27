package com.bcopstein.aplicacao.casosDeUso.estoque;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.ItemDeEstoque;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.servicos.ServicoItemDeEstoque;
import com.bcopstein.negocio.servicos.ServicoProduto;
import com.bcopstein.negocio.servicos.ServicoVenda;

@Component
public class GerenciaEstoqueUC {
    private ServicoItemDeEstoque servicoItemDeEstoque;
    private ServicoVenda servicoVenda;
    private ServicoProduto servicoProduto;

    public GerenciaEstoqueUC(ServicoItemDeEstoque servicoItemDeEstoque, ServicoVenda servicoVenda, ServicoProduto servicoProduto) {
        this.servicoItemDeEstoque = servicoItemDeEstoque;
        this.servicoVenda = servicoVenda;
        this.servicoProduto = servicoProduto;
    }

    public String run() {
        List<ItemDeEstoque> itemDeEstoques = servicoItemDeEstoque.todos();
        List<Venda> vendas = servicoVenda.todos();

        double valorEstoque = 0;
        for(ItemDeEstoque item: itemDeEstoques) {
            valorEstoque += servicoProduto.procuraPorCodProduto(item.getCodigo()).getPreco() * item.getQtdade();
        }

        double valorVendas = 0;
        for(Venda venda: vendas) {
            valorVendas += venda.getTotalVenda();
        }

        return "Valor total estoque [ " + valorEstoque + " ] \nValor total vendas [ " + valorVendas + " ]";
    }
}

