package br.com.helenafranca.model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Artista")
public class Artista implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nome_Artistico")
	private String nomeArtistico;

	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_usuario")
	private Usuario usuario = new Usuario();
	
	@Column(name="foto_artista")
	private String fotoArtista;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeArtistico() {
		return nomeArtistico;
	}

	public void setNomeArtistico(String nomeArtistico) {
		this.nomeArtistico = nomeArtistico;
	}

	public String getFotoArtista() {
		return fotoArtista;
	}

	public void setFotoArtista(String fotoArtista) {
		this.fotoArtista = fotoArtista;
	}	
	
}
