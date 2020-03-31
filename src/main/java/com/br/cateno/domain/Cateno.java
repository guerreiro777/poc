package com.br.cateno.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "cateno")
public class Cateno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_requisicao")
    private Long idRequisicao;

    @NotNull
    @Column(name = "dt_requisicao")
    private LocalDateTime dtRequisicao;

    @NotNull
    @Column(name = "dt_cotacao")
    private String dtCotacao;

    @NotNull
    @Column(name = "vl_compra")
    private Float vlCompra;

    @NotNull
    @Column(name = "vl_venda")
    private Float vlVenda;

    @NotNull
    @Column(name = "dt_hora_cotacao")
    private String dtHoraCotacao;

}
