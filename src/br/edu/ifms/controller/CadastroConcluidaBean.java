package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;



import br.edu.ifms.dao.PesquisaDAO;
import br.edu.ifms.dao.ResponsavelPesquisaDAO;

import br.edu.ifms.modelo.Pesquisa;
import br.edu.ifms.modelo.Concluida;
import br.edu.ifms.modelo.ResponsavelPesquisa;
import br.edu.ifms.service.CadastroConcluidaService;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;
@Named
@ViewScoped
public class CadastroConcluidaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Concluida concluida;
	
	private List<Pesquisa> pesquisasConcluidas; //Pesquisa
	private List<ResponsavelPesquisa> responsaveisPesquisas;


	//service
	@Inject
	private CadastroConcluidaService cadastroConcluidaService;
	
	@Inject
	private ResponsavelPesquisaDAO responsaveisPesquisasDAO;
	
	@Inject
	private PesquisaDAO pesquisaDAO;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.responsaveisPesquisas = responsaveisPesquisasDAO.buscarTodos();
		this.pesquisasConcluidas = this.pesquisaDAO.buscarTodos();
	}
	
	public void salvar() {
		try {
			this.cadastroConcluidaService.salvar(concluida);
			FacesUtil.addSuccessMessage("Pesquisa Concluída registrada com sucesso!");
		}catch(NegocioException e){
			FacesUtil.addErrorMessage(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Erro desconhecido. Contatar o administrador");
		}
		this.limpar();
	}
	

	
	public void limpar() {
		this.concluida = new Concluida();	
		this.concluida.setResponsaveisPesquisas(new ArrayList<ResponsavelPesquisa>());
	}
	
	public Concluida getConcluida() {
		return concluida;
	}
	
	public void setConcluida(Concluida concluida) {
		this.concluida = concluida;
	}
	
	public List<ResponsavelPesquisa> getResponsaveisPesquisas(){
		return responsaveisPesquisas;
	}
	
	public List<Pesquisa> getPesquisas(){
		return pesquisasConcluidas;
	}
}
