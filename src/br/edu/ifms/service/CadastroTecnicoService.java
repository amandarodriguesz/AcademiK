package br.edu.ifms.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifms.dao.TecnicoDAO;
import br.edu.ifms.modelo.Tecnico;
import br.edu.ifms.util.jpa.Transactional;

public class CadastroTecnicoService  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TecnicoDAO tecnicoDAO;
	
	@Transactional
	public void salvar(Tecnico tecnico) throws NegocioException{
		this.tecnicoDAO.salvar(tecnico);
	}

}
