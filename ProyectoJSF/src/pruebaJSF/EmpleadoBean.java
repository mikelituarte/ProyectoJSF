package pruebaJSF;

import hibernateAll.empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaces.interfaceRecuperable.Recuperable;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.Action;

import servicios.Empleados.EmployeesServices;
import tablas_Clases.Employees;


@ManagedBean
@RequestScoped
public class EmpleadoBean {

	
	private int id;
	private Employees empleado;

	
	
	//@Action
	public void buscar() throws ClassNotFoundException, SQLException{
		EmployeesServices servicioEmpleado = new EmployeesServices();
		Recuperable objetoDao = new EmpleadoHibernateDAO();
		servicioEmpleado.setRecuperable(objetoDao);
		this.empleado = (Employees) servicioEmpleado.leerEmpleadoServices(this.id);
		
	}




	public EmpleadoBean(int id, Employees empleado) {
		super();
		this.id = id;
		this.empleado = empleado;
	}




	public EmpleadoBean() {
		super();
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Employees getEmpleado() {
		return empleado;
	}




	public void setEmpleado(Employees empleado) {
		this.empleado = empleado;
	}
	



}
