package br.com.mvarandas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.mvarandas.entity.Cliente;

public interface ClienteDAO {

	Cliente findById(Long id);
	
	List<Cliente> findByNomeOrCpf(String nome, String cpf);

    void saveCliente(Cliente cliente);
 
    void updateCliente(Cliente cliente);
 
    void deleteClienteById(Long id);
    
    void deleteCliente(Cliente cliente);
  
    List<Cliente> findAllClientes();
 	
}
