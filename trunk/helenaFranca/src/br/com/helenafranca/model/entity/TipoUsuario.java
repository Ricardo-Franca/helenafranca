package br.com.helenafranca.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tipousuario")
public class TipoUsuario implements Serializable {

	private static final long serialVersionUID = 1302821089486522214L;
	@Id
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "descricao")
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}