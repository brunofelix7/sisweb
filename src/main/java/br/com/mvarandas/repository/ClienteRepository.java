package br.com.mvarandas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mvarandas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNomeStartingWith(String nome);
	
	List<Cliente> findByTelefoneStartingWith(String telefone);
	
	List<Cliente> findBySexo(String sexo);
	
	List<Cliente> findByEnderecoCidade(String cidade);
	
}
