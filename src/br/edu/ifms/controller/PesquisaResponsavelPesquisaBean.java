package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.dao.ResponsavelPesquisaDAO;
import br.edu.ifms.modelo.ResponsavelPesquisa;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaResponsavelPesquisaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	ResponsavelPesquisaDAO responsavelPesquisaDAO;
	
	private List<ResponsavelPesquisa> responsavelPesquisas = new ArrayList<ResponsavelPesquisa>();
	
	private ResponsavelPesquisa responsavelPesquisaSelecionado;
	
	public List<ResponsavelPesquisa> getResponsavelPesquisas(){
		return responsavelPesquisas;
	}
	
	public void excluir() {
		try {
			responsavelPesquisaDAO.excluir(responsavelPesquisaSelecionado);
			this.responsavelPesquisas.remove(responsavelPesquisaSelecionado);
			FacesUtil.addSuccessMessage("Responsavel pela esquisa " + responsavelPesquisaSelecionado.getNomeCompleto() + " excluido com sucesso!");
		}catch(NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public ResponsavelPesquisa getResponsavelPesquisaSelecionado() {
		return responsavelPesquisaSelecionado;
	}
	
	public void setResponsavelPesquisaSelecionado(ResponsavelPesquisa responsavelPesquisaSelecionado) {
		this.responsavelPesquisaSelecionado = responsavelPesquisaSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		responsavelPesquisas = responsavelPesquisaDAO.buscarTodos();
	}
	
}
