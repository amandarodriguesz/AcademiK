package br.edu.ifms.modelolazy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.edu.ifms.dao.ConcluidaDAO;
import br.edu.ifms.modelo.*;

public class LazyConcluidaDataModel extends LazyDataModel<Concluida> implements Serializable{
	private static final long serialVersionUID =1L; 
	
	private ConcluidaDAO concluidaDAO;
	
	
	public LazyConcluidaDataModel(ConcluidaDAO concluidaDAO) {
		// TODO Auto-generated constructor stub
		this.concluidaDAO = concluidaDAO;
	}

	@Override
	public List<Concluida> load(int first,int pageSize,String sortfield
						,SortOrder sortOrder,Map<String,String>filters){
		
		List<Concluida> concluidas = this.concluidaDAO.buscarComPaginacao(first, pageSize);
		this.setRowCount(this.concluidaDAO.encontrarQuantidadeDePesquisasConcluidas().intValue());
		return concluidas;
	}
	
	
}
