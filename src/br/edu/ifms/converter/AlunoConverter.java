package br.edu.ifms.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifms.dao.AlunoDAO;
import br.edu.ifms.modelo.Aluno;
import br.edu.ifms.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Aluno.class)
public class AlunoConverter implements Converter {
	
	private AlunoDAO alunoDAO;
	
	public AlunoConverter() {
		this.alunoDAO = CDIServiceLocator.getBean(AlunoDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aluno retorno = null;
		
		if(value != null) {
			retorno = this.alunoDAO.buscarPeloCodigo(new Long(value));
		}
		
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Long codigo = ((Aluno) value).getCodigo();
			String retorno = (codigo == null ? null: codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

	
}
