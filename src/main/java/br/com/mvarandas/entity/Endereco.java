package br.com.mvarandas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.mvarandas.model.EnumEstado;

/**
 * Classe que representa minha entidade endereco no banco de dados
 * @author Bruno Felix
 */
@Entity(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "Campo Rua é obrigatório")
	@Column(name = "rua", nullable = false)
	private String rua;
	
	@NotEmpty(message = "Campo Número é obrigatório")
	@Column(name = "numero", nullable = false)
	private String numero;
	
	@NotEmpty(message = "Campo CEP é obrigatório")
	@Column(name = "cep", nullable = false)
	private String cep;
	
	@NotEmpty(message = "Campo Bairro é obrigatório")
	@Column(name = "bairro", nullable = false)
	private String bairro;
	
	@NotEmpty(message = "Campo Cidade é obrigatório")
	@Column(name = "cidade", nullable = false)
	private String cidade;
	
	@NotNull(message = "Selecione uma opção no campo Estado")
	@Column(name = "estado", nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumEstado estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public EnumEstado getEstado() {
		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}


}
