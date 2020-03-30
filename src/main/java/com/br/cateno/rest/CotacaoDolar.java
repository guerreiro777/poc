package com.br.cateno.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.cateno.application.BancoCentral;
import com.br.cateno.domain.Requisicao;
import com.br.cateno.dto.BodyDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CotacaoDolar {

    private final BancoCentral bc;

    @GetMapping("cotacao/banco-central/{data}")
    public BodyDTO consultarBc(@RequestParam(name = "data") final String data) {
        return bc.cotacao(data);
    }

    @GetMapping("cotacao/pesquisadas")
    public List<Requisicao> consultarBd() {
        return bc.listagemCotacao();
    }
}