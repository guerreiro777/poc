package com.br.cateno.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoRepositoy extends JpaRepository<Requisicao, Long> {

    @Query("SELECT r FROM Requisicao r WHERE r.dtCotacao = :dtCotacao")
    public List<Requisicao> listagemCotacaoPorData(@Param("dtCotacao") final LocalDate dtCotacao);

}
