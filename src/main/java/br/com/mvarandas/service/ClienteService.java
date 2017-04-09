package br.com.mvarandas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mvarandas.dao.ClienteDAO;
import br.com.mvarandas.entity.Cliente;
import br.com.mvarandas.model.EnumSexo;
import br.com.mvarandas.repository.ClienteRepository;

@Service
public class ClienteService implements ClienteDAO{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente findById(Long id) {
		Cliente cliente = clienteRepository.findOne(id);
		return cliente;
	}

	@Override
	public List<Cliente> findByNomeStartingWith(String nome) {
		List<Cliente> clientes = clienteRepository.findByNomeStartingWith(nome);
		return clientes;
	}
	
	@Override
	public List<Cliente> findByTelefoneStartingWith(String telefone) {
		List<Cliente> clientes = clienteRepository.findByTelefoneStartingWith(telefone);
		return clientes;
	}
	
	@Override
	public List<Cliente> findBySexo(EnumSexo sexo) {
		List<Cliente> clientes = clienteRepository.findBySexo(sexo);
		return clientes;
	}

	@Override
	public List<Cliente> findByEnderecoCidade(String cidade) {
		List<Cliente> clientes = clienteRepository.findByEnderecoCidade(cidade);
		return clientes;
	}
	
	@Override
	public Long count(){
		return clienteRepository.count();
	}

	@Override
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void updateCliente(Cliente cliente) {
		saveCliente(cliente);
	}

	@Override
	public void deleteClienteById(Long id) {
		clienteRepository.delete(id);
	}

	@Override
	public void deleteCliente(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	@Override
	public List<Cliente> findAllClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}
	
}
