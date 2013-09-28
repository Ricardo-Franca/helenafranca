package br.com.helenafranca.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "slideshow")
public class SlideShow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigoQuadro")
	private Quadro quadro = new Quadro();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigoArtista")
	private Artista artista = new Artista();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Quadro getQuadro() {
		return quadro;
	}

	public void setQuadro(Quadro quadro) {
		this.quadro = quadro;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}	
}