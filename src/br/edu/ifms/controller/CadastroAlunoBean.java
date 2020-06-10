package br.edu.ifms.controller;



import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.modelo.Aluno;
import br.edu.ifms.service.CadastroAlunoService;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroAlunoService cadastroAlunoService;

	private Aluno aluno;
	
	public void salvar() {
		try {
			this.cadastroAlunoService.salvar(aluno);
			FacesUtil.addSuccessMessage("Aluno salvo com sucesso");
			
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
		this.aluno= new Aluno();
		
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
