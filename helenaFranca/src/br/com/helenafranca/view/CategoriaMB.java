package br.com.helenafranca.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.helenafranca.controller.CategoriaFacade;
import br.com.helenafranca.controller.CategoriaFacadeImpl;
import br.com.helenafranca.controller.QuadroFacade;
import br.com.helenafranca.controller.QuadroFacadeImpl;
import br.com.helenafranca.model.entity.Categoria;
import br.com.helenafranca.model.entity.Quadro;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.model.SelectItem;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CategoriaMB implements Serializable {

	private static final long serialVersionUID = 9186380132421958551L;

	private Categoria categoria = new Categoria();

	private Long id;
	private List<SelectItem> categorias;

	public CategoriaMB(){
		System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do CATEGORIA_MB <<<<<<<<<<<<<<<<<<");
		
		if(this.categoria == null){
			this.categoria = new Categoria(); 
		}
	}
	
	public String save(){
		CategoriaFacade categoriaService = new CategoriaFacadeImpl();
			
		categoriaService.salva(this.categoria);
		
		this.categoria = new Categoria(); 
		return "cadastraSucesso";
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<SelectItem> getCategorias()
	{
		if(this.categorias == null)
		{
			this.categorias = new ArrayList<SelectItem>();
			this.categorias.add(new SelectItem("1","Abstrato"));
			this.categorias.add(new SelectItem("2","Animais"));
			this.categorias.add(new SelectItem("3","Florais"));
			this.categorias.add(new SelectItem("4","Paisagens"));			
			this.categorias.add(new SelectItem("5","Pessoas"));
			this.categorias.add(new SelectItem("6","Natureza Morta"));	
		}
		return categorias;	
	}
}