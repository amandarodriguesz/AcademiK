package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.dao.AlunoDAO;
import br.edu.ifms.modelo.Aluno;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	AlunoDAO alunoDAO;
	
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	private Aluno alunoSelecionado;
	
	public List<Aluno> getAlunos(){
		return alunos;
	}
	
	public void excluir() {
		try {
			alunoDAO.excluir(alunoSelecionado);
			this.alunos.remove(alunoSelecionado);
			FacesUtil.addSuccessMessage("Aluno " + alunoSelecionado.getNome() + "excluido com sucesso");
		}catch(NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}
	
	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		alunos = alunoDAO.buscarTodos();
	}
	
}
