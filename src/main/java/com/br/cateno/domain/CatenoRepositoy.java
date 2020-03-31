package com.br.cateno.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatenoRepositoy extends JpaRepository<Cateno, Long> {

}
