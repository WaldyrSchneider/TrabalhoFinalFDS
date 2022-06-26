package com.bcopstein.negocio.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroVenda;
    ArrayList<Produto> produtos;
    private double totalVenda;
    private double imposto;
    private Date data;

    public Venda(ArrayList<Produto> produtos, double totalVenda, Double imposto, Date data) {
        this.produtos = produtos;
        this.totalVenda = totalVenda;
        this.imposto = imposto;
        this.data = data;
    }

    public Venda() {
    }

    public long getNumeroVenda() {
        return numeroVenda;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public double getImposto() {
        return imposto;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Venda [numeroVenda=" + numeroVenda + ", produtos=" + produtos + ", totalVenda=" + totalVenda + "]";
    }

}
