package br.edu.ifms.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifms.dao.ConcluidaDAO;
import br.edu.ifms.modelo.Concluida;
import br.edu.ifms.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Concluida.class)
public class ConcluidaConverter implements Converter{
	
	private ConcluidaDAO concluidaDAO;
	
	public ConcluidaConverter() {
		this.concluidaDAO = CDIServiceLocator.getBean(ConcluidaDAO.class);
	}
	
	/*
	 * @Override public Object getAsObject(FacesContext context, UIComponent
	 * component, String value) { Concluida retorno = null;
	 * 
	 * if(value!=null) { retorno = this.concluidaDAO.buscarPeloCodigo(new
	 * Long(value)); }
	 * 
	 * return retorno; }
	 * 
	 * @Override public String getAsString(FacesContext context,UIComponent
	 * component,Object value) { if(value !=null) { Long codigo =
	 * ((Concluida)value).getCodigo(); String retorno =
	 * (codigo==null?null:codigo.toString());
	 * 
	 * return retorno; } return null; }
	 */
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {	
		Concluida retorno = null;
		if(value != null) {
			retorno = this.concluidaDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext contex, UIComponent component, Object value) {
		if(value != null) {
			Long codigo = ((Concluida) value).getCodigo();
			return codigo == null ? null : codigo.toString();
		}
		return "";
	}
}
