package com.bcopstein.adaptores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcopstein.aplicacao.casosDeUso.produto.ConsultaProdutosUC;
import com.bcopstein.aplicacao.casosDeUso.produto.SelecionaProdutoUC;
import com.bcopstein.aplicacao.casosDeUso.venda.ConfirmaVendaUC;
import com.bcopstein.aplicacao.casosDeUso.venda.ConsultaVendaUC;
import com.bcopstein.aplicacao.casosDeUso.venda.SubTotalUC;
import com.bcopstein.aplicacao.dtos.ParamSubtotal_DTO;
import com.bcopstein.negocio.entidades.ItemCarrinho;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.Venda;

@RestController
@RequestMapping("/vendas")
public class Controller {
  private final ConsultaProdutosUC consultaProdutosUC;
  private final SelecionaProdutoUC selecionaProdutoUC;
  private final ConfirmaVendaUC confirmaVendaUC;
  private final ConsultaVendaUC consultaVendaUC;
  private final SubTotalUC subTotalUC;

  @Autowired
  public Controller(ConsultaProdutosUC consultaProdutosUC, SelecionaProdutoUC selecionaProdutoUC,
      ConfirmaVendaUC confirmaVendaUC, ConsultaVendaUC consultaVendaUC, SubTotalUC subTotalUC) {

    this.consultaProdutosUC = consultaProdutosUC;
    this.selecionaProdutoUC = selecionaProdutoUC;
    this.confirmaVendaUC = confirmaVendaUC;
    this.consultaVendaUC = consultaVendaUC;
    this.subTotalUC = subTotalUC;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return consultaProdutosUC.run();
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Integer codProd, @RequestParam final Integer qtdade) {
    return selecionaProdutoUC.run(codProd, qtdade);
  }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaVenda(@RequestBody final ItemCarrinho[] itens) {
    return confirmaVendaUC.run(itens);
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<Venda> vendasEfetuadas() {
    return consultaVendaUC.run();
  }

  @PostMapping("/subtotal")
  @CrossOrigin(origins = "*")
  public Integer[] calculaSubtotal(@RequestBody final ParamSubtotal_DTO param) {
    return subTotalUC.run(param);
  }
}
