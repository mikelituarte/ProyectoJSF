package servicios.departamentos;

import hibernateAll.empleadoHibernateDAO.DepartamentoHibernateDAO;

import java.util.List;

import tablas_Clases.Departments;

public class DepartmentsServices {

	
	public List<Departments> obtenerDepartamentos(){
				
		DepartamentoHibernateDAO departamentoDao = new DepartamentoHibernateDAO();
		List<Departments> lista = departamentoDao.obtenerDepartamentos();
		return lista;
	}
}
