package br.com.mvarandas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mvarandas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNomeOrTelefone(String nome, String telefone);
	
	//	Filtro para Sexo, Idade ou Cidade
	
}
