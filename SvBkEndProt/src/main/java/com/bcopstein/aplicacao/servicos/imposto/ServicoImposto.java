package com.bcopstein.aplicacao.servicos.imposto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.adaptores.repositorios.ProdutoRepositorio;

@Component
public class ServicoImposto {
    private ICalculaImposto iCalculaImposto;

    @Autowired
    public ServicoImposto(ICalculaImposto iCalculaImposto, ProdutoRepositorio produtoRepositorio) {
        this.iCalculaImposto = iCalculaImposto;
    }

    public double calculaImposto(double valor) {
        return iCalculaImposto.calculaImposto(valor);
    }
}
