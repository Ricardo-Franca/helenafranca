package br.com.helenafranca.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.ForeignKey;

import br.com.helenafranca.model.entity.Status;
import br.com.helenafranca.model.entity.Artista;

@Entity
@Table(name = "quadro")
public class Quadro implements Serializable {
	
	private static final long serialVersionUID = 3076099532882712710L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="nome")
	private String nome; 
	
	@Column(name="altura")
	private String altura;	
	
	@Column(name="largura")
	private String largura;	
	
	@Column(name="peso")
	private String peso;
	
	@Column(name="preco")
	private String preco;
	
	@Column(name="foto")
	private String foto;
		
	@ManyToOne(fetch = FetchType.EAGER)
   	@JoinColumn(name="codigoCategoria")   
   	private Categoria categoria = new Categoria();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoArtista")
	private Artista artista = new Artista();
	
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

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getLargura() {
		return largura;
	}

	public void setLargura(String largura) {
		this.largura = largura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getFoto() {
		return foto;
	}

	public void setQuadroImagem(String foto) {
		this.foto = foto;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}	
}