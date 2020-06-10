package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.dao.AlunoDAO;

import br.edu.ifms.enums.TipoPesquisa;
import br.edu.ifms.modelo.Aluno;
import br.edu.ifms.modelo.Pesquisa;
import br.edu.ifms.service.CadastroPesquisaService;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;
@Named
@ViewScoped
public class CadastroPesquisaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Pesquisa pesquisa;
	
	private List<Aluno> alunos;
	
	private List<TipoPesquisa> tipos;
	
	@Inject
	private CadastroPesquisaService cadastroPesquisaService;
	
	@Inject
	private AlunoDAO alunoDAO; 
	
	public void salvar() {
		try {
			this.cadastroPesquisaService.salvar(pesquisa);
			FacesUtil.addSuccessMessage("Pesquisa salvo com sucesso!");
		}catch(NegocioException e){
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.alunos = alunoDAO.buscarTodos();
		this.tipos = Arrays.asList(TipoPesquisa.values());
	}
	
	public void limpar() {
		
			this.pesquisa = new Pesquisa();

		
	}
	
	public Pesquisa getPesquisa() {
		return pesquisa;
	}
	
	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public List<Aluno> getAlunos(){
		return alunos;
	}
	
	public List<TipoPesquisa> getTipos(){
		return tipos;
	}
}
