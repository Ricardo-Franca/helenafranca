package br.com.helenafranca.controller;

import br.com.helenafranca.model.entity.SlideShow;

public interface SlideShowFacade extends BaseFacade<SlideShow>{
	public void salva(SlideShow s);
	
	public SlideShow procura(Long id);

	public void atualiza(SlideShow s);
	
	public SlideShow procuraById(Long codigo);
}