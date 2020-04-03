package com.br.poc.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POCRepositoy extends JpaRepository<POC, Long> {

}
