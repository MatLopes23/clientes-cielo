package com.bootcamp.clientescielo.repository;

import com.bootcamp.clientescielo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Boolean existsByPessoaFisicaCpfAndIdNot(String cpf, Long id);
    public Boolean existsByPessoaJuridicaCnpjAndIdNot(String cpf, Long id);

}
