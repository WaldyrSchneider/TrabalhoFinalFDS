package com.bcopstein.adaptores.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bcopstein.aplicacao.casosDeUso.produto.ConsultaProdutosUC;
import com.bcopstein.aplicacao.casosDeUso.produto.SelecionaProdutoUC;
import com.bcopstein.aplicacao.dtos.ParamSubtotal_DTO;
import com.bcopstein.negocio.entidades.ItemCarrinho;
import com.bcopstein.negocio.entidades.Produto;

@RestController
@RequestMapping("/vendas")
public class Controller {
  private final List<String> vendasEfetuadas;
  private final Map<String, Integer> cacheFrete;
  private final ConsultaProdutosUC consultaProdutosUC;
  private final SelecionaProdutoUC selecionaProdutoUC;

  @Autowired
  public Controller(ConsultaProdutosUC consultaProdutosUC, SelecionaProdutoUC selecionaProdutoUC) {

    this.consultaProdutosUC = consultaProdutosUC;
    this.selecionaProdutoUC = selecionaProdutoUC;
    // Cria cache frete
    cacheFrete = new HashMap<>();

    // Cria a lista de vendas efetuadas
    vendasEfetuadas = new ArrayList<>();
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

  // @PostMapping("/confirmacao")
  // @CrossOrigin(origins = "*")
  // public boolean confirmaVenda(@RequestBody final ItemCarrinho[] itens) {

  // ArrayList<Produto> listaProdutos = new ArrayList<>();
  // ArrayList<Integer> listaQtdades = new ArrayList<>();

  // for (ItemCarrinho item : itens) {
  // final Produto produto =
  // produtos.stream().filter(p -> p.getCodigo() ==
  // item.getCodigo()).findAny().orElse(null);

  // if (produto == null) {
  // return false;
  // }

  // listaQtdades.add(item.getQuantidade());
  // listaProdutos.add(produto);
  // }

  // StringBuilder builder = new StringBuilder();

  // for (int i = 0; i < listaProdutos.size(); i++) {
  // final Produto produto = listaProdutos.get(i);
  // final int qtdade = listaQtdades.get(i);
  // produto.saidaDeProduto(qtdade);

  // builder.append(produto.getCodigo());
  // builder.append(" ");
  // builder.append(produto.getDescricao());
  // builder.append(" ");
  // builder.append(qtdade);
  // builder.append("\n");
  // }

  // vendasEfetuadas.add(builder.toString());
  // return true;
  // }

  // @GetMapping("/historico")
  // @CrossOrigin(origins = "*")
  // public List<String> vendasEfetuadas() {
  // return vendasEfetuadas;
  // }

  // @PostMapping("/subtotal")
  // @CrossOrigin(origins = "*")
  // public Integer[] calculaSubtotal(@RequestBody final ParamSubtotal_DTO param)
  // {
  // Integer subtotal = 0;
  // Integer imposto = 0;

  // System.out.println(param.getEndereco());

  // // Verifica se o endereço é invalido
  // if (param.getEndereco() == null ||
  // param.getEndereco().isEmpty() ||
  // param.getEndereco().isBlank()){
  // throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Endereco
  // invalido");
  // }
  // // Verifica se o endereço já está na cache
  // if (!cacheFrete.keySet().contains(param.getEndereco())){
  // // Calcula o frete
  // cacheFrete.put(param.getEndereco(),25);
  // }

  // for (final ItemCarrinho it : param.getItens()) {
  // // Procurar o produto pelo código
  // final Produto prod =
  // produtos.stream().filter(p -> p.getCodigo() ==
  // it.getCodigo()).findAny().orElse(null);

  // if (prod != null) {
  // subtotal += (int) (prod.getPreco() * it.getQuantidade());
  // } else {
  // throw new IllegalArgumentException("Codigo invalido");
  // }
  // }
  // imposto = (int) (subtotal * 0.1);
  // final Integer[] resp = new Integer[4];
  // resp[0] = subtotal;
  // resp[1] = imposto;
  // resp[2] = subtotal + imposto;
  // resp[3] = cacheFrete.get(param.getEndereco()); // Frete: custo fixo por
  // enquanto
  // return resp;
  // }
}
