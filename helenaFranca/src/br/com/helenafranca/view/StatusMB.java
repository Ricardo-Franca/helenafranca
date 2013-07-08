package br.com.helenafranca.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.helenafranca.controller.StatusFacade;
import br.com.helenafranca.controller.StatusFacadeImpl;
import br.com.helenafranca.model.entity.Status;

public class StatusMB implements Serializable {

	private static final long serialVersionUID = 2273212693618648253L;

	private List<SelectItem> listStatus;
	
	private Status status = new Status();
	
	public StatusMB(){
		System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor da Status_MB <<<<<<<<<<<<<<<<<<");
		
		if(this.status == null){
			this.status = new Status(); 			
		}
	}

	public String save(){
		StatusFacade statusService = new StatusFacadeImpl();
			
		statusService.salva(this.status);
		
		this.status = new Status(); 
		return "cadastraSucesso";
	}
	
	public List<SelectItem> getSituacoes()
	{
		if(this.listStatus == null)
		{
			this.listStatus = new ArrayList<SelectItem>();
			this.listStatus.add(new SelectItem("1","Ativo"));
			this.listStatus.add(new SelectItem("2","Inativo"));	
		}
		return listStatus;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}	
}