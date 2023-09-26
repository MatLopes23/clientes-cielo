package com.bootcamp.clientescielo.repository;

import com.bootcamp.clientescielo.model.Cliente;
import com.bootcamp.clientescielo.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
}
