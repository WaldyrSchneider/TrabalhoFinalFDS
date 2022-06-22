package com.bcopstein.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemDeEstoque {

    @Id
    private int codigo;
    private int qtdade;

    public ItemDeEstoque(int codigo, int qtdade) {
        this.codigo = codigo;
        this.qtdade = qtdade;
    }

    public ItemDeEstoque(){}

    public int getCodigo() {
        return codigo;
    }

    public int getQtdade() {
        return qtdade;
    }

}
