package br.com.helenafranca.util;

import java.io.IOException;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.transaction.Transaction;

import org.apache.catalina.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.helenafranca.controller.QuadroFacade;
import br.com.helenafranca.controller.QuadroFacadeImpl;
import br.com.helenafranca.model.dao.DAO;
import br.com.helenafranca.model.entity.Artista;
import br.com.helenafranca.model.entity.Quadro;
import br.com.helenafranca.model.entity.Categoria;
import br.com.helenafranca.model.entity.Status;
import br.com.helenafranca.model.entity.TipoUsuario;
import br.com.helenafranca.model.entity.Usuario;
import br.com.helenafranca.view.ArtistaMB;
import br.com.helenafranca.view.QuadroMB;
import br.com.helenafranca.view.CategoriaMB;
import br.com.helenafranca.view.StatusMB;
import br.com.helenafranca.view.TipoUsuarioMB;
import br.com.helenafranca.view.UsuarioMB;
import br.com.helenafranca.util.CriptografaSenha;


public class GerarTabelas {
	
	public static void main(String[] args) throws IOException {
		
	
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();

		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
		
		// Cadastrando categorias *************************************
		
		
		Categoria categoria = new Categoria();
		categoria.setCodigo(1L);
		categoria.setDescricao("Abstrato");
		CategoriaMB categoriaMB = new CategoriaMB();
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();		
		
		categoria.setCodigo(2L);
		categoria.setDescricao("Animais");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		categoria.setCodigo(3L);
		categoria.setDescricao("Florais");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		categoria.setCodigo(4L);
		categoria.setDescricao("Paisagens");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		categoria.setCodigo(5L);
		categoria.setDescricao("Pessoas");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		categoria.setCodigo(6L);
		categoria.setDescricao("Natureza Morta");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		categoria.setCodigo(7L);
		categoria.setDescricao("Releitura");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		// Cadastrando status *************************************
		
		Status status = new Status();
		status.setCodigo(1L);
		status.setDescricao("Ativo");		
		StatusMB statusMB = new StatusMB();
		statusMB.setStatus(status);
		statusMB.save();
		
		status.setCodigo(2L);
		status.setDescricao("Inativo");		
		statusMB.setStatus(status);
		statusMB.save();
		
		// Cadastrando tipo de usuário *************************************
		
		TipoUsuario tipoUsuario = new TipoUsuario();
		TipoUsuarioMB tipoUsuarioMB = new TipoUsuarioMB();
			
		tipoUsuario.setCodigo(1L);
		tipoUsuario.setDescricao("Artista");
		tipoUsuarioMB.setTipoUsuario(tipoUsuario);
		tipoUsuarioMB.save();
		
		tipoUsuario.setCodigo(2L);
		tipoUsuario.setDescricao("Cliente");
		tipoUsuarioMB.setTipoUsuario(tipoUsuario);
		tipoUsuarioMB.save();
		
		// Cadastrando Usuario *************************************
		
		Usuario usuario = new Usuario();
		UsuarioMB usuarioMB = new UsuarioMB();
		
		usuario.setCodigo(1L);		
		usuario.setLogin("helenaadmin");
		usuario.setSenha(CriptografaSenha.md5("helenaadmin"));		
		usuario.getStatus().setCodigo(1L);
		usuario.getTipoUsuario().setCodigo(1L);
		
		usuarioMB.setUsuario(usuario);
		usuarioMB.save();
	}
}