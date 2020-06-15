package br.edu.ifms.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifms.dao.TecnicoDAO;
import br.edu.ifms.modelo.Tecnico;
import br.edu.ifms.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Tecnico.class)
public class TecnicoConverter implements Converter{
	
	private TecnicoDAO tecnicoDAO;
	
	public TecnicoConverter() {
		this.tecnicoDAO = CDIServiceLocator.getBean(TecnicoDAO.class);		
	}
	
	@Override
	public Object getAsObject(FacesContext context,UIComponent component,String value) {
		Tecnico retorno = null;
		
		if(value!=null) {
			retorno = this.tecnicoDAO.buscarPeloCodigo(new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null) {
			Long codigo = ((Tecnico) value).getCodigo();
			String retorno = (codigo == null? null: codigo.toString());
			return retorno;
		}
		return "";
	}
}
