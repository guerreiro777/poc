package com.br.cateno.application;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.cateno.domain.Cateno;
import com.br.cateno.domain.CatenoRepositoy;
import com.br.cateno.dto.BodyDTO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service("BancoCentral")
public class BancoCentral {

    private final Environment env;
    CatenoRepositoy repository;

    public BodyDTO cotacao(final String data) {
        final RestTemplate rest = new RestTemplate();
        final String url = env.getProperty("api.bc.url").concat("?@dataCotacao='" + data + "'");
        BancoCentral.log.info(url);
        final ResponseEntity<BodyDTO> postForEntity = rest.getForEntity(url, BodyDTO.class);
        persiste(postForEntity.getBody());
        return postForEntity.getBody();
    }

    public List<Cateno> listagemCotacao() {
        return repository.findAll();
    }

    private void persiste(final BodyDTO bodyDTO) {
        bodyDTO.getValue().stream().forEach(cotacao -> {
            final Cateno requisicao = new Cateno();
            requisicao.setDtCotacao(cotacao.getDataHoraCotacao());
            requisicao.setDtHoraCotacao(cotacao.getDataHoraCotacao());
            requisicao.setDtRequisicao(LocalDateTime.now());
            requisicao.setVlCompra(Float.parseFloat(cotacao.getCotacaoCompra()));
            requisicao.setVlVenda(Float.parseFloat(cotacao.getCotacaoVenda()));
            repository.save(requisicao);
        });
    }

}
