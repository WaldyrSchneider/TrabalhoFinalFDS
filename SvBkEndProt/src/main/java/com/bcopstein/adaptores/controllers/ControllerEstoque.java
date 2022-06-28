package com.bcopstein.adaptores.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcopstein.aplicacao.casosDeUso.estoque.ConsultaEstoqueUC;
import com.bcopstein.aplicacao.casosDeUso.estoque.GerenciaEstoqueUC;
import com.bcopstein.aplicacao.casosDeUso.estoque.InsereEstoqueUC;
import com.bcopstein.negocio.entidades.ItemDeEstoque;

@RestController
@RequestMapping("/estoque")
public class ControllerEstoque {
    private ConsultaEstoqueUC consultaEstoqueUC;
    private InsereEstoqueUC insereEstoqueUC;
    private GerenciaEstoqueUC gerenciaEstoqueUC;

    public ControllerEstoque(ConsultaEstoqueUC consultaEstoqueUC, InsereEstoqueUC insereEstoqueUC,
            GerenciaEstoqueUC gerenciaEstoqueUC) {
        this.consultaEstoqueUC = consultaEstoqueUC;
        this.insereEstoqueUC = insereEstoqueUC;
        this.gerenciaEstoqueUC = gerenciaEstoqueUC;
    }

    @GetMapping("/produtos")
    @CrossOrigin(origins = "*")
    public List<ItemDeEstoque> listaProdutos() {
        return consultaEstoqueUC.run();
    }

    @PostMapping("/insere")
    @CrossOrigin(origins = "*")
    public boolean insere(@RequestParam final Integer codigo, @RequestParam final Integer qtdade) {
        return insereEstoqueUC.run(codigo, qtdade);
    }

    @GetMapping("/gerencia")
    @CrossOrigin(origins = "*")
    public String gerencia() {
        return gerenciaEstoqueUC.run();
    }
}
