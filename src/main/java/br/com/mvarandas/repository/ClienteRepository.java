package br.com.mvarandas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mvarandas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNomeOrCpf(String nome, String cpf);
	
	//	Filtro para Sexo, Idade ou Cidade
	
}
