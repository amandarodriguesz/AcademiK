package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.edu.ifms.dao.ConcluidaDAO;
import br.edu.ifms.modelo.Concluida;
import br.edu.ifms.modelolazy.LazyConcluidaDataModel;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaConcluidaBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject 
	ConcluidaDAO concluidaDAO;
	
	private List<Concluida> concluidas = new ArrayList<Concluida>();
	
	private LazyConcluidaDataModel lazyConcluidas;
	
	private Concluida concluidaSelecionada;
	
	public List<Concluida> getConcluidas(){
		return concluidas;
	}
	
	
	public void excluir() {
		try {
			concluidaDAO.excluir(concluidaSelecionada);
			//this.concluidas.remove(concluidaSelecionada);
			RequestContext.getCurrentInstance().update("concluidaTable");
			FacesUtil.addSuccessMessage("Pesquisa concluída "+concluidaSelecionada.getPesquisa().getNome()+"excluido com sucesso");
		}catch(NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Concluida getConcluidaSelecionada() {
		return concluidaSelecionada;
		
	}
	
	public void setConcluidaSelecionada(Concluida concluidaSelecionada) {
		this.concluidaSelecionada = concluidaSelecionada;
	}
	
	@PostConstruct
	public void inicializar() {
		lazyConcluidas = new LazyConcluidaDataModel(concluidaDAO);
	}
	
	public void buscarConcluidaComResponsaveis() {
		concluidaSelecionada = concluidaDAO.buscarConcluidaComResponsaveis(concluidaSelecionada.getCodigo());
	}
	
	public LazyConcluidaDataModel getLazyConcluidas() {
		return lazyConcluidas;
	}
	
	
	
	
}
