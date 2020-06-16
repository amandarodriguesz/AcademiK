package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.dao.ConcluidaDAO;
import br.edu.ifms.dao.ProfessorDAO;
import br.edu.ifms.modelo.Concluida;
import br.edu.ifms.modelo.Evento;
import br.edu.ifms.modelo.Professor;
import br.edu.ifms.modelo.RequisitoParticipacao;
import br.edu.ifms.service.CadastroEventoService;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class NovoEventoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Evento evento;
	
	private List<Concluida> concluidas;
	
	@Inject
	private CadastroEventoService cadastroEventoService;
	
	@Inject
	private ConcluidaDAO concluidaDAO;
	
	@Inject
	private ProfessorDAO professorDAO;
	
	private List<Professor> professores;
	
	public void salvar() {
		try {
			this.cadastroEventoService.salvar(evento);
			FacesUtil.addSuccessMessage("Evento salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.professores = this.professorDAO.buscarTodos();
		this.concluidas = this.concluidaDAO.buscarTodos();
	}
	
	public void limpar() {
		this.evento = new Evento();
		this.evento.setRequisitoParticipacao(new RequisitoParticipacao());
	}
	
	public Evento getEvento() {
		return evento;
	}
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public List<Concluida> getConcluidas(){
		return concluidas;
	}
	
	public List<Professor> getProfessores(){
		return professores;
	}
	
	
}
