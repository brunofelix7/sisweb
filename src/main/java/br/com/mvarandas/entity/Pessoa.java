package br.com.mvarandas.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import br.com.mvarandas.model.EnumSexo;

/**
 * Classe que representa minha entidade pessoa no banco de dados
 * @author Bruno Felix
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "Campo Nome é obrigatório")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotEmpty(message = "Campo Telefone é obrigatório")
	@Column(name = "telefone", nullable = false)
	private String telefone;

	@NotNull(message = "Selecione uma opção no campo Sexo")
	@Column(name = "sexo", nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumSexo sexo;
	
	@NotEmpty(message = "Campo E-mail é obrigatório")
	@Column(name = "email", nullable = false)
	@Email(message = "E-mail inválido")
	private String email;
	
	@NotEmpty(message = "Campo Cpf é obrigatório")
	@Column(name ="cpf", nullable = false)
	@CPF(message = "CPF inválido")
	private String cpf;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name ="data_nascimento", nullable = true)
	private Date data_nascimento;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
