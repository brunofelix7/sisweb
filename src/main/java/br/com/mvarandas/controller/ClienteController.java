package br.com.mvarandas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.com.mvarandas.entity.Cliente;
import br.com.mvarandas.entity.Endereco;
import br.com.mvarandas.model.Routes;
import br.com.mvarandas.model.Views;
import br.com.mvarandas.service.ClienteService;

/**
 * Classe de controle da minha entidade Pessoa
 * @author Bruno Felix
 */
@Controller
@RequestMapping(value = Routes.CLIENTES)
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	/**
	 * Direciona para página de cadastro
	 */
	@RequestMapping(value = Routes.CLIENTES_NOVO, method = RequestMethod.GET)
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView(Views.NOVO);
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	/**
	 * Cadastra um cliente no banco de dados
	 */
	@RequestMapping(value = Routes.CLIENTES_SALVAR, method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute(value = "cliente") @Validated Cliente cliente, Errors errors, @ModelAttribute(value = "endereco") @Validated Endereco endereco, Errors errorsAddress, ModelMap modelMap){
		ModelAndView mv = new ModelAndView(Views.NOVO);
		modelMap.addAttribute("cliente", cliente);
		if(errors.hasErrors() || errorsAddress.hasErrors()){
			return mv;
		}else{
			cliente.setEndereco(endereco);
			clienteService.saveCliente(cliente);
			mv.addObject("mensagem", "Cadastrado com sucesso!");
		}
		return mv;
	}
	
	/**
	 * Direciona para página de atualização
	 */
	@RequestMapping(value = Routes.CLIENTES_ATUALIZAR, method = RequestMethod.GET)
	public ModelAndView alterar(@PathVariable(value = "id") Long id){
		ModelAndView mv = new ModelAndView(Views.ATUALIZAR);
		Cliente cliente = clienteService.findById(id);
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	
	/**
	 * Atualiza um cliente no banco de dados
	 */
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public ModelAndView salvarAlteracoes(@ModelAttribute(value = "endereco") @Validated Endereco endereco, Errors errorsEndereco, @ModelAttribute(value = "cliente") @Validated Cliente cliente, Errors errors, ModelMap modelMap){
		ModelAndView mv = new ModelAndView(Views.ATUALIZAR);
		modelMap.addAttribute("cliente", cliente);
		if(errors.hasErrors() || errorsEndereco.hasErrors()){
			return mv;
		}else{
			cliente.setEndereco(endereco);
			clienteService.updateCliente(cliente);
			mv.addObject("mensagem", "Dados atualizados com sucesso!");
		}
		return mv;
	}
	
	/**
	 * Exclui um cliente do banco de dados
	 */
	@RequestMapping(value = Routes.CLIENTES_EXCLUIR, method =RequestMethod.GET)
	public String excluir(@PathVariable(value = "id") Long id, ModelMap modelMap){
		Cliente cliente = clienteService.findById(id);
		clienteService.deleteCliente(cliente);
		return "redirect:/clientes";
	}
	
	/**
	 * Lista os clientes
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(ModelMap modelMap) {
		List<Cliente> clientes = clienteService.findAllClientes();
		modelMap.addAttribute("clientes", clientes);
		return Views.LISTAR;
	}
	
	/**
	 * Visualizar detalhes de um cliente
	 */
	@RequestMapping(value = Routes.CLIENTES_VISUALIZAR, method = RequestMethod.GET)
	public String visualizar(@PathVariable(value = "id") Long id, ModelMap modelMap){
		Cliente cliente = clienteService.findById(id);
		modelMap.addAttribute("cliente", cliente);
		return Views.VISUALIZAR;
	}	
	
	/**
	 * Pesquisa um cliente pelo nome
	 */
	@RequestMapping(value = Routes.CLIENTES_PESQUISAR, method = RequestMethod.GET)
	public String pesquisar(@ModelAttribute(value = "nome") String nome, @ModelAttribute(value = "cpf") String cpf, ModelMap modelMap){
		List<Cliente> clientes = clienteService.findByNomeOrCpf(nome, cpf);
		modelMap.addAttribute("clientes", clientes);
		return Views.LISTAR;
	}
	
	
	
}
