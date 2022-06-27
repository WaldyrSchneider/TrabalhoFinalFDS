package com.bcopstein.adaptores.configuradores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcopstein.aplicacao.servicos.imposto.ICalculaImposto;
import com.bcopstein.aplicacao.servicos.imposto.ImpostoBrasil;
import com.bcopstein.aplicacao.servicos.imposto.ImpostoEUA;

@Configuration
public class ConfiguradorImposto {

    @Autowired
    public ConfiguradorImposto() {
    }

    @Bean
    @ConditionalOnProperty(name = "imposto.brasil", havingValue = "brasil", matchIfMissing = true)
    public ICalculaImposto impostoBrasil() {
        return new ImpostoBrasil();
    }
    
    @Bean
    @ConditionalOnProperty(name = "imposto.eua", havingValue = "eua")
    public ICalculaImposto impostoEUA() {
        return new ImpostoEUA();
    }
}
