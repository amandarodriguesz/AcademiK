package br.edu.ifms.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifms.dao.PesquisaDAO;

import br.edu.ifms.modelo.Pesquisa;
import br.edu.ifms.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Pesquisa.class)
public class PesquisaConverter implements Converter{
	
	private PesquisaDAO pesquisaDAO;
	
	public PesquisaConverter() {
		this.pesquisaDAO = CDIServiceLocator.getBean(PesquisaDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Pesquisa retorno = null;
		
		if(value != null) {
			retorno = this.pesquisaDAO.buscarPeloCodigo(new Long(value));
		}
		
		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext contex, UIComponent component, Object value) {
		if(value != null) {
			Long codigo = ((Pesquisa) value).getCodigo();
			return codigo == null ? null : codigo.toString();
		}
		return "";
	}

}

