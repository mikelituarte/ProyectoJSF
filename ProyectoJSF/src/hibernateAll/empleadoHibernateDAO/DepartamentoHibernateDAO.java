package hibernateAll.empleadoHibernateDAO;

import hibernateAll.sesion.manager.SesionManager;

import java.util.List;

import org.hibernate.Session;

import tablas_Clases.Departments;

public class DepartamentoHibernateDAO {

	
	public List<Departments> obtenerDepartamentos(){
		Session sesion = SesionManager.getSesion();
		List<Departments> lista = sesion.createSQLQuery("SELECT * FROM DEPARTMENTS").addEntity(Departments.class).list();
		sesion.close();
		return lista;
	}
	
	
}
