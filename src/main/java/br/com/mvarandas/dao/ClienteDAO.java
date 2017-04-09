package br.com.mvarandas.dao;

import java.util.List;
import br.com.mvarandas.entity.Cliente;
import br.com.mvarandas.model.EnumSexo;

public interface ClienteDAO {

	Cliente findById(Long id);
	
	List<Cliente> findByNomeStartingWith(String nome);
	
	List<Cliente> findByTelefoneStartingWith(String telefone);
	
	List<Cliente> findBySexo(EnumSexo sexo);
	
	List<Cliente> findByEnderecoCidade(String cidade);
	
	Long count();

    void saveCliente(Cliente cliente);
 
    void updateCliente(Cliente cliente);
 
    void deleteClienteById(Long id);
    
    void deleteCliente(Cliente cliente);
  
    List<Cliente> findAllClientes();
 	
}
