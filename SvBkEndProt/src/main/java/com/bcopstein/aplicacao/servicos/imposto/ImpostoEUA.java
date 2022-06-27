package com.bcopstein.aplicacao.servicos.imposto;

public class ImpostoEUA implements ICalculaImposto{

    public ImpostoEUA() {

    }

    public double calculaImposto(double valor) {
        if(valor > 10000) {
            return valor * 0.25;
        }
        return valor * 0.5;
    }
    
}
