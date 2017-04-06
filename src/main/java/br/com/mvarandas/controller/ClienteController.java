package br.com.mvarandas.controller;

import java.util.Arrays;
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
import br.com.mvarandas.model.EnumEstado;
import br.com.mvarandas.model.EnumSexo;
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
	 * DIRECIONAR PARA PÁGINA DE CADASTRO
	 */
	@RequestMapping(value = Routes.CLIENTES_NOVO, method = RequestMethod.GET)
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView(Views.NOVO);
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		mv.addObject("endereco", endereco);
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	/**
	 * CADASTRAR UM CLIENTE
	 */
	@RequestMapping(value = Routes.CLIENTES_SALVAR, method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute(value = "cliente") @Validated Cliente cliente, Errors errors, @ModelAttribute(value = "endereco") @Validated Endereco endereco, Errors errorsAddress, ModelMap modelMap){
		ModelAndView mv = new ModelAndView(Views.NOVO);
		modelMap.addAttribute("endereco", endereco);
		modelMap.addAttribute("cliente", cliente);
		if(errors.hasErrors() || errorsAddress.hasErrors()){
			System.out.println(errors.getFieldErrors());
			System.out.println(errorsAddress.getFieldErrors());
			return mv;
		}else{
			cliente.setEndereco(endereco);
			clienteService.saveCliente(cliente);
			mv.addObject("mensagem", "Cadastrado com sucesso!");
		}
		return mv;
	}
	
	/**
	 * DIRECIONAR PARA PÁGINA DE ATUALIZAÇÃO
	 */
	@RequestMapping(value = Routes.CLIENTES_ATUALIZAR, method = RequestMethod.GET)
	public ModelAndView alterar(@PathVariable(value = "id") Long id){
		ModelAndView mv = new ModelAndView(Views.ATUALIZAR);
		Cliente cliente = clienteService.findById(id);
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	/**
	 * ATUALIZAR UM CLIENTE
	 */
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public ModelAndView salvarAlteracoes(@ModelAttribute(value = "endereco") @Validated Endereco endereco, Errors errorsEndereco, @ModelAttribute(value = "cliente") @Validated Cliente cliente, Errors errors, ModelMap modelMap){
		ModelAndView mv = new ModelAndView(Views.ATUALIZAR);
		modelMap.addAttribute("endereco", endereco);
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
	 * EXCLUIR UM CLIENTE
	 */
	@RequestMapping(value = Routes.CLIENTES_EXCLUIR, method =RequestMethod.GET)
	public String excluir(@PathVariable(value = "id") Long id, ModelMap modelMap){
		Cliente cliente = clienteService.findById(id);
		clienteService.deleteCliente(cliente);
		return "redirect:/clientes";
	}
	
	/**
	 * LISTAR CLIENTES
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(ModelMap modelMap) {
		List<Cliente> clientes = clienteService.findAllClientes();
		modelMap.addAttribute("clientes", clientes);
		return Views.LISTAR;
	}
	
	/**
	 * VISUALIZAR DETALHES DE UM CLIENTE
	 */
	@RequestMapping(value = Routes.CLIENTES_VISUALIZAR, method = RequestMethod.GET)
	public String visualizar(@PathVariable(value = "id") Long id, ModelMap modelMap){
		Cliente cliente = clienteService.findById(id);
		modelMap.addAttribute("cliente", cliente);
		return Views.VISUALIZAR;
	}	
	
	/**
	 * PESQUISAR UM CLIENTE PELO NOME
	 */
	@RequestMapping(value = Routes.CLIENTES_PESQUISAR, method = RequestMethod.GET)
	public String pesquisar(@ModelAttribute(value = "nome") String nome, @ModelAttribute(value = "cpf") String cpf, ModelMap modelMap){
		List<Cliente> clientes = clienteService.findByNomeOrCpf(nome, cpf);
		modelMap.addAttribute("clientes", clientes);
		return Views.LISTAR;
	}

	/**
	 * RETORNA TODOS OS ENUNS EM UM ARRAY DINAMICAMENTE 
	 */
	@ModelAttribute("enumSexo")		// Define o nome que eu quero chamar lá na View com o thymeleaf
	public List<EnumSexo> enumSexo(){
		return Arrays.asList(EnumSexo.values());
	}
	
	/**
	 * RETORNA TODOS OS ENUNS EM UM ARRAY DINAMICAMENTE 
	 */
	@ModelAttribute("enumEstado")		// Define o nome que eu quero chamar lá na View com o thymeleaf
	public List<EnumEstado> enumEstado(){
		return Arrays.asList(EnumEstado.values());
	}

}
