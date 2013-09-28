package br.com.helenafranca.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import br.com.helenafranca.util.CriptografaSenha;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -4257017967929318546L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String senha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoTipoUsuario")
	private TipoUsuario tipoUsuario = new TipoUsuario();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoStatus")
	private Status status = new Status();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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