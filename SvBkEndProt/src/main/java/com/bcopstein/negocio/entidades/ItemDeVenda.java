package com.bcopstein.negocio.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemDeVenda implements Serializable{

    @Id
    private int codigo;
    private String descricao;
    private double preco;
    private int qnt;

    public ItemDeVenda(int codigo, String descricao, double preco, int qnt) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.qnt = qnt;
    }

    public ItemDeVenda() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
}
