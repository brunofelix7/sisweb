package br.com.mvarandas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mvarandas.entity.Cliente;
import br.com.mvarandas.model.EnumSexo;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNomeStartingWith(String nome);
	
	List<Cliente> findByTelefoneStartingWith(String telefone);
	
	List<Cliente> findBySexo(EnumSexo sexo);
	
	List<Cliente> findByEnderecoCidade(String cidade);
	
}
