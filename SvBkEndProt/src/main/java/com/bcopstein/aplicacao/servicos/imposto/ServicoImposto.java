package com.bcopstein.aplicacao.servicos.imposto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoImposto {
    private ICalculaImposto iCalculaImposto;

    @Autowired
    public ServicoImposto(ICalculaImposto iCalculaImposto) {
        this.iCalculaImposto = iCalculaImposto;
    }

    public double calculaImposto(double valor) {
        return iCalculaImposto.calculaImposto(valor);
    }
}
