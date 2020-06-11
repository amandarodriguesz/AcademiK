package br.edu.ifms.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifms.dao.ResponsavelPesquisaDAO;
import br.edu.ifms.modelo.ResponsavelPesquisa;
import br.edu.ifms.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=ResponsavelPesquisa.class)
public class ResponsavelPesquisaConverter implements Converter {
	
	private ResponsavelPesquisaDAO responsavelPesquisaDAO;
	
	public ResponsavelPesquisaConverter() {
		this.responsavelPesquisaDAO = CDIServiceLocator.getBean(ResponsavelPesquisaDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ResponsavelPesquisa retorno = null;
		
		if(value != null) {
			retorno = this.responsavelPesquisaDAO.buscarPeloCodigo(new Long(value));
		}
		
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Long codigo = ((ResponsavelPesquisa) value).getCodigo();
			String retorno = (codigo == null ? null: codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

	
}
