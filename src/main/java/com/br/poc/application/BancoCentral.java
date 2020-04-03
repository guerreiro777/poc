package com.br.poc.application;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.poc.domain.POC;
import com.br.poc.domain.POCRepositoy;
import com.br.poc.dto.BodyDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service("BancoCentral")
public class BancoCentral {

    private final Environment env;
    POCRepositoy repository;

    public BodyDTO cotacao(final String data) {
        final RestTemplate rest = new RestTemplate();
        final String url = env.getProperty("api.bc.url").concat("?@dataCotacao='" + data + "'");
        BancoCentral.log.info(url);
        final ResponseEntity<BodyDTO> postForEntity = rest.getForEntity(url, BodyDTO.class);
        persiste(postForEntity.getBody());
        return postForEntity.getBody();
    }

    public List<POC> listagemCotacao() {
        return repository.findAll();
    }

    private void persiste(final BodyDTO bodyDTO) {
        try {
            final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            final String json = ow.writeValueAsString(bodyDTO);
            BancoCentral.log.info(json);
        } catch (final Exception e) {
            BancoCentral.log.info(e.getMessage());
        }
        if (!bodyDTO.getValue().isEmpty()) {
            bodyDTO.getValue().stream().forEach(cotacao -> {
                final POC requisicao = new POC();
                requisicao.setDtCotacao(cotacao.getDataHoraCotacao());
                requisicao.setDtHoraCotacao(cotacao.getDataHoraCotacao());
                requisicao.setDtRequisicao(LocalDateTime.now());
                requisicao.setVlCompra(Float.parseFloat(cotacao.getCotacaoCompra()));
                requisicao.setVlVenda(Float.parseFloat(cotacao.getCotacaoVenda()));
                repository.save(requisicao);
            });
        }
    }

}
