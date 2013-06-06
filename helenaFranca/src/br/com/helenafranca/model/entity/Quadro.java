package br.com.helenafranca.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "quadro")
public class Quadro implements Serializable {
	
	private static final long serialVersionUID = 3076099532882712710L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_quadro")
	private Long cod_quadro;
	
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
	
	@Column(name="quadro_imagem")
	private String quadro_imagem;
		
	@OneToOne(cascade=CascadeType.ALL)
   	@JoinColumn(name="cod_categoria")   
   	private Categoria categoria = new Categoria();

	public Long getCod_quadro() {
		return cod_quadro;
	}

	public void setCod_quadro(Long cod_quadro) {
		this.cod_quadro = cod_quadro;
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

	public String getQuadro_imagem() {
		return quadro_imagem;
	}

	public void setQuadro_imagem(String quadro_imagem) {
		this.quadro_imagem = quadro_imagem;
	}		
	
}