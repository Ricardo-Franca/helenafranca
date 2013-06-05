package br.com.helenafranca.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1302821089486522214L;
	@Id
	@Column(name = "cod_categoria")
	private Integer codigo;

	@Column(name = "desc_categoria")
	private String descricao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}