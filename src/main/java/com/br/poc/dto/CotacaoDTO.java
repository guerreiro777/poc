package com.br.poc.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder
public class CotacaoDTO {

    private String cotacaoCompra;
    private String cotacaoVenda;
    private String dataHoraCotacao;

}
