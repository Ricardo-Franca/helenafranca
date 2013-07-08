package br.com.helenafranca.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import br.com.helenafranca.util.CriptografaSenha;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -4257017967929318546L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario")
	private Long cod_usuario;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String senha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_tipousuario")
	private TipoUsuario tipoUsuario = new TipoUsuario();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_status")
	private Status status = new Status();

	public Long getCodigo() {
		return cod_usuario;
	}

	public void setCodigo(Long codigo) {
		this.cod_usuario = codigo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha =senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}