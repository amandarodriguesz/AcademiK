package br.edu.ifms.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifms.dao.AlunoDAO;
import br.edu.ifms.modelo.Aluno;
import br.edu.ifms.util.jpa.Transactional;

public class CadastroAlunoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void salvar(Aluno aluno)throws NegocioException{
		if(aluno.getNome()==null || aluno.getNome().trim().equals("")) {
			throw new NegocioException("O nome do aluno é obrigatório");
		}
		
		this.alunoDAO.salvar(aluno);
	}

}
