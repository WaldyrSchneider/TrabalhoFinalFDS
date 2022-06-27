package com.bcopstein.adaptores.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcopstein.aplicacao.casosDeUso.estoque.ConsultaEstoqueUC;
import com.bcopstein.aplicacao.casosDeUso.estoque.InsereEstoqueUC;
import com.bcopstein.negocio.entidades.ItemDeEstoque;

@RestController
@RequestMapping("/estoque")
public class ControllerEstoque {
    private ConsultaEstoqueUC consultaEstoqueUC;
    private InsereEstoqueUC insereEstoqueUC;

    public ControllerEstoque(ConsultaEstoqueUC consultaEstoqueUC, InsereEstoqueUC insereEstoqueUC) {
        this.consultaEstoqueUC = consultaEstoqueUC;
        this.insereEstoqueUC = insereEstoqueUC;
    }

    @GetMapping("/produtos")
    @CrossOrigin(origins = "*")
    public List<ItemDeEstoque> listaProdutos() {
        return consultaEstoqueUC.run();
    }

    @PostMapping("/insere")
    @CrossOrigin(origins = "*")
    public boolean podeVender(@RequestParam final Integer codigo, @RequestParam final Integer qtdade) {
      return insereEstoqueUC.run(codigo, qtdade);
    }
}
