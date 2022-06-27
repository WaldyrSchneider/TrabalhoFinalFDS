package com.bcopstein.aplicacao.servicos.imposto;

import org.springframework.beans.factory.annotation.Autowired;

public class ImpostoBrasil implements ICalculaImposto {

    @Autowired
    public ImpostoBrasil() {

    }

    public double calculaImposto(double valor) {
        return valor * 0.10;
    }
}
