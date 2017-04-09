package br.com.mvarandas.model;

/**
 * Classe que contém as rotas
 * @author Bruno Felix
 */
public class Routes {
	
	//	Rota da página principal
	public static final String INDEX = "/";
	
	//	Rotas de cliente
	public static final String CLIENTES 					= "/clientes";
	public static final String CLIENTES_NOVO 				= "/novo";
	public static final String CLIENTES_SALVAR 				= "/salvar";
	public static final String CLIENTES_ALTERAR 			= "/alterar";
	public static final String CLIENTES_ATUALIZAR 			= "/atualizar/{id}";
	public static final String CLIENTES_EXCLUIR 			= "/excluir/{id}";
	public static final String CLIENTES_VISUALIZAR 			= "/visualizar/{id}";
	public static final String CLIENTES_PESQUISAR_NOME 		= "/pesquisar/nome";
	public static final String CLIENTES_PESQUISAR_TELEFONE 	= "/pesquisar/telefone";
	public static final String CLIENTES_FILTRAR_SEXO 		= "/filtrar/sexo";
	public static final String CLIENTES_FILTRAR_CIDADE		= "/filtrar/cidade";
	public static final String CLIENTES_FILTRAR_IDADE		= "/filtrar/idade";
	
	//	Rotas de login
	public static final String LOGIN 	= "/login";
	public static final String LOGOUT 	= "/logout";
	
	//	Rotas de erro
	public static final String ERROR_404 = "/error404";
	
}
