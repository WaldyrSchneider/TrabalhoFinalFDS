package com.bcopstein.aplicacao.servicos.frete;

import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.dtos.ParamSubtotal_DTO;

@Component
public class ServicoCalculaFrete {
    private ICalculaFrete iCalculaFrete;

    public ServicoCalculaFrete(ICalculaFrete iCalculaFrete) {
        this.iCalculaFrete = iCalculaFrete;
    }

    public int calculaFrete(ParamSubtotal_DTO param) {
        return iCalculaFrete.calculaFrete(param);
    }
}
