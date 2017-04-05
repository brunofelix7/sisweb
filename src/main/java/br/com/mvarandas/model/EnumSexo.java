package br.com.mvarandas.model;

public enum EnumSexo {

	FEMININO("Feminino"),
	MASCULINO("Masculino");
	
	private String descricao;
	
	EnumSexo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
}
