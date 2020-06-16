package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.dao.EventoDAO;
import br.edu.ifms.dao.PesquisaDAO;
import br.edu.ifms.modelo.Concluida;
import br.edu.ifms.modelo.Evento;
import br.edu.ifms.modelo.Pesquisa;

@Named
@ViewScoped
public class PesquisaEventoBean implements Serializable{
	private static final long serialVersionUID=1L;
	
	private List<Pesquisa> pesquisas;
	private Evento evento;
	private Concluida concluida;
	
	private List<Evento> eventos;
	
	
	@Inject
	private PesquisaDAO pesquisaDAO;
	

	@Inject 
	private EventoDAO eventoDAO;
	
	@PostConstruct
	public void inicializar() {
		this.evento = new Evento();
		this.concluida = new Concluida();
		this.pesquisas = this.pesquisaDAO.buscarTodos();
		
		this.eventos = new ArrayList<Evento>();
	}
	
	public void pesquisar() {
		this.eventos = eventoDAO.buscarPorDataDoEventoEPesquisa(this.evento.getDataEvento());
	}
	
	public List<Pesquisa> getPesquisas(){
		return pesquisas;
	}
	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public Concluida getConcluida() {
		return concluida;
	}
	
	public void setConcluida(Concluida concluida) {
		this.concluida = concluida;
	}
	
	public List<Evento> getEventos(){
		return eventos;
	}

}
