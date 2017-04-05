package br.com.mvarandas.crud;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mvarandas.entity.Cliente;
import br.com.mvarandas.entity.Endereco;
import br.com.mvarandas.model.EnumEstado;
import br.com.mvarandas.model.EnumSexo;
import br.com.mvarandas.service.ClienteService;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudTest extends TestCase{
	
	@Autowired
	private ClienteService clienteService;
	private Date date;
	private Cliente cliente;
	private Endereco endereco;

	@Test
	public void save() throws Exception{
		date 	 = new Date();
		cliente  = new Cliente();
		endereco = new Endereco();
		
		endereco.setRua("Comerciante José Formiga de Assis");
		endereco.setNumero(77);
		endereco.setBairro("Funcionários IV");
		endereco.setCidade("João Pessoa");
		endereco.setCep("58079666");
		endereco.setEstado(EnumEstado.PB);
		
		cliente.setNome("Bruno");
		cliente.setCpf("06807087403");
		cliente.setEmail("bruno.felix10@hotmail.com");
		cliente.setTelefone(32342610);
		cliente.setSexo(EnumSexo.MASCULINO);
		cliente.setData_nascimento(date);
		cliente.setEndereco(endereco);		
		
		clienteService.saveCliente(cliente);

	}

}
