package br.com.helenafranca.model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="cliente")


public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 3076099532882712710L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="nome")
	private String nome; 
	
	@Column(name="cpf")
	private String cpf;	
	
	@Column(name="email")
	private String email;	
	
	@Column(name="telefone")
	private String telefone;	

	@OneToOne(cascade=CascadeType.ALL)
   	@JoinColumn(name="codigoUsuario")
	private Usuario usuario = new Usuario();	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario= usuario;
	}
}