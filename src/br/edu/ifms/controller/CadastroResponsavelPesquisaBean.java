package br.edu.ifms.controller;



import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.modelo.ResponsavelPesquisa;
import br.edu.ifms.service.CadastroResponsavelPesquisaService;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroResponsavelPesquisaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroResponsavelPesquisaService cadastroResponsavelPesquisaService;

	private ResponsavelPesquisa responsavelPesquisa;
	
	public void salvar() {
		try {
			this.cadastroResponsavelPesquisaService.salvar(responsavelPesquisa);
			FacesUtil.addSuccessMessage("ResponsavelPesquisa salvo com sucesso");
			
			this.limpar();
		}catch(NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar() {
		this.responsavelPesquisa= new ResponsavelPesquisa();
		
	}
	
	public ResponsavelPesquisa getResponsavelPesquisa() {
		return responsavelPesquisa;
	}
	public void setResponsavelPesquisa(ResponsavelPesquisa responsavelPesquisa) {
		this.responsavelPesquisa = responsavelPesquisa;
	}
}
