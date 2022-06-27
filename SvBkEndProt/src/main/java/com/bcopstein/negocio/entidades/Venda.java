package com.bcopstein.negocio.entidades;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroVenda;
    private ArrayList<ItemDeVenda> produtos;
    private double subTotal;
    private double totalVenda;
    private double imposto;

    public Venda(ArrayList<ItemDeVenda> produtos, double subTotal, double totalVenda, Double imposto) {
        this.produtos = produtos;
        this.totalVenda = totalVenda;
        this.imposto = imposto;
        this.subTotal = subTotal;
    }

    public Venda() {
    }

    public long getNumeroVenda() {
        return numeroVenda;
    }

    public ArrayList<ItemDeVenda> getProdutos() {
        return produtos;
    }

    public double getSubTotalVenda() {
        return subTotal;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public double getImposto() {
        return imposto;
    }

    @Override
    public String toString() {
        return "Venda [imposto=" + imposto + ", numeroVenda=" + numeroVenda + ", subTotal=" + subTotal + ", totalVenda="
                + totalVenda + "]";
    }

}
