package pruebaJSF;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servicios.departamentos.DepartmentsServices;
import tablas_Clases.Departments;

@ManagedBean
@RequestScoped
public class DepartamentoBean {

	private List<Departments> lista;
	//private final  Logger log = LogManager.getRootLogger();
	
	@PostConstruct
	public void recuperarDepartamentos(){
		List<Departments> listaDepartamentos = null;
		DepartmentsServices servicioDepartamentos = new DepartmentsServices();
		listaDepartamentos = servicioDepartamentos.obtenerDepartamentos();
		//log.trace(listaDepartamentos);
		//int i = Integer.parseInt("eer");
		System.out.println(listaDepartamentos);
		this.lista = listaDepartamentos;
	}

	public List<Departments> getLista() {
		return lista;
	}

	public void setLista(List<Departments> lista) {
		this.lista = lista;
	}

	public DepartamentoBean(List<Departments> lista) {
		super();
		this.lista = lista;
	}

	public DepartamentoBean() {
		super();
	}
	
}
