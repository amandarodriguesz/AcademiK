package br.edu.ifms.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifms.dao.EventoDAO;
import br.edu.ifms.modelo.Evento;
import br.edu.ifms.util.jpa.Transactional;

public class CadastroEventoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EventoDAO eventoDAO;
	
	@Transactional
	public void salvar(Evento evento) throws NegocioException{
		if(evento.getConcluida() == null) {
			throw new NegocioException("A pesquisa Concluida é obrigatória!");
		}
		
		this.eventoDAO.salvar(evento);
	}
	
}
