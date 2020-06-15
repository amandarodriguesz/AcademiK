package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.dao.TecnicoDAO;
import br.edu.ifms.modelo.Tecnico;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaTecnicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	TecnicoDAO tecnicoDAO;
	
	private List<Tecnico> tecnicos = new ArrayList<Tecnico>();
	
	private Tecnico tecnicoSelecionado;
	
	public List<Tecnico> getTecnicos(){
		return tecnicos;
	}
	
	public void excluir() {
		try {
			tecnicoDAO.excluir(tecnicoSelecionado);
			this.tecnicos.remove(tecnicoSelecionado);
			FacesUtil.addSuccessMessage("Tecnico "+tecnicoSelecionado.getNome()+" excluido com sucesso! ");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Tecnico getTecnicoSelecionado() {
		return tecnicoSelecionado;
	}
	
	public void setTecnicoSelecionado(Tecnico tecnicoSelecionado) {
		this.tecnicoSelecionado = tecnicoSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		tecnicos = tecnicoDAO.buscarTodos();
	}
}
