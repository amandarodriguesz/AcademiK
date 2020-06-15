package br.edu.ifms.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifms.dao.ProfessorDAO;
import br.edu.ifms.modelo.Professor;
import br.edu.ifms.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Professor.class)
public class ProfessorConverter implements Converter{
	
	private ProfessorDAO professorDAO;
	
	public ProfessorConverter() {
		this.professorDAO = CDIServiceLocator.getBean(ProfessorDAO.class);		
	}
	
	@Override
	public Object getAsObject(FacesContext context,UIComponent component,String value) {
		Professor retorno = null;
		
		if(value!=null) {
			retorno = this.professorDAO.buscarPeloCodigo(new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null) {
			Long codigo = ((Professor) value).getCodigo();
			String retorno = (codigo == null? null: codigo.toString());
			return retorno;
		}
		return "";
	}
}
