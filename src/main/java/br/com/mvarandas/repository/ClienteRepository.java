package br.com.mvarandas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mvarandas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	//	@Query("select c from Cliente c where c.nome like %:nome%")
	//	@Param("nome")
	List<Cliente> findByNomeStartingWith(String nome);
	
	//	@Query("select c from Cliente c where c.telefone like %:telefone%")
	//	@Param("telefone")
	List<Cliente> findByTelefoneStartingWith(String telefone);
	
	//	Filtro para Sexo, Idade ou Cidade
	
}
