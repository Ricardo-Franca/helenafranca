package br.com.helenafranca.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.helenafranca.controller.BiografiaFacade;
import br.com.helenafranca.controller.BiografiaFacadeImpl;
import br.com.helenafranca.controller.FotoFacade;
import br.com.helenafranca.controller.FotoFacadeImpl;
import br.com.helenafranca.model.entity.Foto;


public class FotoMB implements Serializable {

	private static final long serialVersionUID = 5537619173537523023L;
	private Foto foto = new Foto();
	private static String imagePath;

	public FotoMB() {
		System.out
				.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do Foto_MB <<<<<<<<<<<<<<<<<<");

		if (this.foto == null) {
			this.foto = new Foto();
		}
	}

	public String updateFoto(long codigo) throws IOException {
		FotoFacade fotoService = new FotoFacadeImpl();
		this.foto = fotoService.procura(codigo);
						
		if(getImagePath()!=null)
		{						
			String nome = this.foto.getFoto(); 						
			
			nome = nome.substring(21);
			nome = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps" + nome;
					
			File f = new File(nome);  
			f.delete();			
			
			this.foto.setFoto(imagePath);
			this.imagePath = null;
			
		}	
		BiografiaFacade biografiaService = new BiografiaFacadeImpl(); 
		
		this.foto.setBiografia(biografiaService.procura(1L));
		fotoService.atualiza(this.foto);	
		this.foto = new Foto();
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext
		.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest rq = (HttpServletRequest) FacesContext
		.getCurrentInstance().getExternalContext().getRequest();
		rp.sendRedirect(rq.getContextPath() + "/pages/artista/manterFotos.jsf");


		return "atualizaSucesso";
	}

	public Foto getFotos(Long codigo) {

		FotoFacade fotoService = new FotoFacadeImpl();
		Foto foto = new Foto();
		
		foto = fotoService.procura(codigo);	

		return foto;
	}
	
	public Foto getFoto1() {

		Foto foto = new Foto();
		FotoFacade fotoService = new FotoFacadeImpl();
		
		foto = fotoService.procura(1L);

		return foto;
	}
	
	public Foto getFoto2() {

		Foto foto = new Foto();
		FotoFacade fotoService = new FotoFacadeImpl();
		
		foto = fotoService.procura(2L);

		return foto;
	}
	
	public Foto getFoto3() {

		Foto foto = new Foto();
		FotoFacade fotoService = new FotoFacadeImpl();
		
		foto = fotoService.procura(3L);

		return foto;
	}
	
	public Foto getFoto4() {

		Foto foto = new Foto();
		FotoFacade fotoService = new FotoFacadeImpl();
		
		foto = fotoService.procura(4L);

		return foto;
	}
	
	public Foto getFoto5() {

		Foto foto = new Foto();
		FotoFacade fotoService = new FotoFacadeImpl();
		
		foto = fotoService.procura(5L);

		return foto;
	}
	
	public void  uploadImage(UploadEvent evento) throws FileNotFoundException 
	{		
		String caminhoReal = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/imagensHelenaFranca";
		String extensao = "";
		UploadItem item = evento.getUploadItem();
		String fileName = item.getFileName();
		String ext[] = fileName.split("\\.");
		int i = ext.length;

		Long tempo = System.currentTimeMillis();
		
		if (i > 1) {
			extensao = ext[i - 1];

		}
				
		OutputStream out = new FileOutputStream(caminhoReal+"/" + "img"+ tempo + "." + extensao);
		setImagePath("http://localhost:8081/imagensHelenaFranca/" + "img"	+ tempo + "." + extensao);
		
		try {
			out.write(item.getData());
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
	}
}