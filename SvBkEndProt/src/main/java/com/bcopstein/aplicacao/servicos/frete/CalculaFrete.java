package com.bcopstein.aplicacao.servicos.frete;

import org.springframework.web.client.RestTemplate;

import com.bcopstein.aplicacao.dtos.ParamSubtotal_DTO;

public class CalculaFrete implements ICalculaFrete {

    public CalculaFrete() {

    }

    public int calculaFrete(ParamSubtotal_DTO param) {
        String key = "AopLPbM5_Uat33hfHt80rAgU4l67qaJpzn0hXk_bOIyZbXRrxsky6D0aKYI6zarz";
        String endPUC = "Av. Ipiranga 6681, Porto Alegre, 90619900";
        String endFinal = param.getEndereco();
        String url = "http://dev.virtualearth.net/REST/V1/Routes/Driving?wp.0=" + endPUC + "&wp.1=" + endFinal
                + "&avoid=minimizeTolls&key=" + key;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        String[] res = response.split("travelDistance");
        return Math.round(Float.parseFloat(res[res.length - 1].split(",")[0].substring(2)));
    }
}
