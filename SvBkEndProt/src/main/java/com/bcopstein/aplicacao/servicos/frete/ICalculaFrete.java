package com.bcopstein.aplicacao.servicos.frete;

import com.bcopstein.aplicacao.dtos.ParamSubtotal_DTO;

public interface ICalculaFrete {
    int calculaFrete(ParamSubtotal_DTO param);
}
