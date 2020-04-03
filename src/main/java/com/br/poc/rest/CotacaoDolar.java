package com.br.cateno.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cateno.application.BancoCentral;
import com.br.cateno.domain.Cateno;
import com.br.cateno.dto.BodyDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CotacaoDolar {

    private final BancoCentral bc;

    @GetMapping("cotacao/banco-central/{data}")
    public BodyDTO consultarBc(final HttpServletRequest request, @PathVariable("data") final String data) {
        return bc.cotacao(data);
    }

    @GetMapping("cotacao/pesquisadas")
    public List<Cateno> consultarBd() {
        return bc.listagemCotacao();
    }
}
