package br.com.mvarandas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.mvarandas.dao.ClienteDAO;
import br.com.mvarandas.entity.Cliente;
import br.com.mvarandas.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService implements ClienteDAO{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente findById(Long id) {
		Cliente cliente = clienteRepository.findOne(id);
		return cliente;
	}

	@Override
	public List<Cliente> findByNomeOrCpf(String nome, String cpf) {
		List<Cliente> clientes = clienteRepository.findByNomeOrCpf(nome, cpf);
		return clientes;
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
