package com.bcopstein.adaptores.configuradores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcopstein.aplicacao.servicos.frete.CalculaFrete;
import com.bcopstein.aplicacao.servicos.frete.ICalculaFrete;

@Configuration
public class ConfiguadorFrete {

    @Autowired
    public ConfiguadorFrete() {

    }

    @Bean
    @ConditionalOnProperty(name = "frete.normal", havingValue = "normal", matchIfMissing = true)
    public ICalculaFrete freteNormal() {
        return new CalculaFrete();
    }
}
