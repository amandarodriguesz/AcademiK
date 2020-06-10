package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.dao.PesquisaDAO;
import br.edu.ifms.modelo.Pesquisa;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaPesquisaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Pesquisa> pesquisas;
	
	private Pesquisa pesquisaSelecionado;
	
	@Inject
	PesquisaDAO pesquisaDAO;
	
	public List<Pesquisa> getPesquisas(){
		return pesquisas;
	}
	
	@PostConstruct
	public void inicializar() {
		this.pesquisas = this.pesquisaDAO.buscarTodos();
	}
	
	public void excluir() {
		try {
			pesquisaDAO.excluir(pesquisaSelecionado);
			this.pesquisas.remove(pesquisaSelecionado);
			FacesUtil.addSuccessMessage("Registro excluído com sucesso!" );
		}catch(NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Pesquisa getPesquisaSelecionado() {
		return pesquisaSelecionado;
	}

	public void setPesquisaSelecionado(Pesquisa pesquisaSelecionado) {
		this.pesquisaSelecionado = pesquisaSelecionado;
	}
	
	
}
