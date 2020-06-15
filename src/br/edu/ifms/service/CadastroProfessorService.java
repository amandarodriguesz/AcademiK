package br.edu.ifms.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifms.dao.ProfessorDAO;
import br.edu.ifms.modelo.Professor;
import br.edu.ifms.util.jpa.Transactional;

public class CadastroProfessorService  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProfessorDAO professorDAO;
	
	@Transactional
	public void salvar(Professor professor) throws NegocioException{
		this.professorDAO.salvar(professor);
	}

}
