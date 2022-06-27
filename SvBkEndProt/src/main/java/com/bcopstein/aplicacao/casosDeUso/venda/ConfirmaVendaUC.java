package com.bcopstein.aplicacao.casosDeUso.venda;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.servicos.imposto.ServicoImposto;
import com.bcopstein.aplicacao.servicos.restricao.ServicoRestricao;
import com.bcopstein.negocio.entidades.ItemCarrinho;
import com.bcopstein.negocio.entidades.ItemDeEstoque;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.servicos.ServicoItemDeEstoque;
import com.bcopstein.negocio.servicos.ServicoProduto;
import com.bcopstein.negocio.servicos.ServicoVenda;

@Component
public class ConfirmaVendaUC {
    private ServicoItemDeEstoque servicoItemDeEstoque;
    private ServicoProduto servicoProduto;
    private ServicoVenda servicoVenda;
    private ServicoImposto servicoImposto;
    private ServicoRestricao servicoRestricao;

    @Autowired
    public ConfirmaVendaUC(ServicoItemDeEstoque servicoItemDeEstoque, ServicoProduto servicoProduto,
            ServicoVenda servicoVenda, ServicoImposto servicoImposto, ServicoRestricao servicoRestricao) {
        this.servicoItemDeEstoque = servicoItemDeEstoque;
        this.servicoProduto = servicoProduto;
        this.servicoVenda = servicoVenda;
        this.servicoImposto = servicoImposto;
        this.servicoRestricao = servicoRestricao;
    }

    public boolean run(ItemCarrinho[] itens) {
        ArrayList<Produto> itensDeVenda = new ArrayList<>();

        double totalVenda = 0;
        double imposto = 0;
        if (LocalTime.now().getHour() > 20) {
            if (servicoRestricao.restricao(itens)) {
                return false;
            }
        }

        for (ItemCarrinho item : itens) {
            Produto produto = servicoProduto.procuraPorCodProduto(item.getCodigo());
            totalVenda += produto.getPreco() * item.getQuantidade();
            imposto += servicoImposto.calculaImposto(produto.getPreco());
            ItemDeEstoque itemDeEstoque = servicoItemDeEstoque.procuraPorProduto(item.getCodigo());
            servicoItemDeEstoque.remove(itemDeEstoque, item.getQuantidade());
            itensDeVenda.add(produto);
        }

        Date date = new Date();
        Venda venda = new Venda(itensDeVenda, totalVenda, imposto, date);
        return servicoVenda.cadastraVenda(venda);
    }
}
