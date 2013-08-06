package br.com.helenafranca.model.entity;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="texto")
	@Type(type="text")
	private String texto;
	
	@Column(name="data")
	private String data;
	
	@Column(name="hora")
	private String hora;
	
	@Column(name="imagem")
	private String imagem;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "codigoArtista")
	private Artista artista = new Artista();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}	
	
}
