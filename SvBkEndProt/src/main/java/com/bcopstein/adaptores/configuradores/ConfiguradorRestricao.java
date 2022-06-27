package com.bcopstein.adaptores.configuradores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcopstein.aplicacao.servicos.restricao.IRestricao;
import com.bcopstein.aplicacao.servicos.restricao.RestricaoQnt;
import com.bcopstein.aplicacao.servicos.restricao.RestricaoValor;
import com.bcopstein.negocio.servicos.ServicoProduto;

@Configuration
public class ConfiguradorRestricao {
    private ServicoProduto servicoProduto;

    @Autowired
    public ConfiguradorRestricao(ServicoProduto servicoProduto) {
        this.servicoProduto = servicoProduto;
    }

    @Bean
    @ConditionalOnProperty(name = "restricao.qnt", havingValue = "qnt", matchIfMissing = true)
    public IRestricao restricaoQnt() {
        return new RestricaoQnt();
    }

    @Bean
    @ConditionalOnProperty(name = "restricao.valor", havingValue = "valor")
    public IRestricao restricaoValor() {
        return new RestricaoValor(servicoProduto);
    }
}
