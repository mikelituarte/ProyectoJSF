package pruebaJSF;

import hibernateAll.empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaces.interfaceRecuperable.Recuperable;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servicios.Empleados.EmployeesServices;
import servicios.departamentos.DepartmentsServices;
import tablas_Clases.Departments;
import tablas_Clases.Employees;

@ManagedBean
@SessionScoped
//@RequestScoped
public class DepartamentoBean implements Serializable {

	private List<Departments> lista;
	private final  Logger log = LogManager.getRootLogger();
	private List<Employees> listaEmpleados;
	private short idDepartamento;
	private int idEmpleado;
	private Employees empleado;
	
	
	@PostConstruct
	public void recuperarDepartamentos(){
		System.out.println("Entra a recuperar departamentos");
		
		if ((null==lista)||(lista.isEmpty()))
		{
			List<Departments> listaDepartamentos = null;
			DepartmentsServices servicioDepartamentos = new DepartmentsServices();
			listaDepartamentos = servicioDepartamentos.obtenerDepartamentos();
			//log.trace(listaDepartamentos);
			//int i = Integer.parseInt("eer");
			System.out.println(listaDepartamentos);
			this.lista = listaDepartamentos;
		}
		
	}
	
	public String recuperarEmpleados(){
		EmployeesServices servicioEmpleado = new EmployeesServices();
		Recuperable objetoDao = new EmpleadoHibernateDAO();
		servicioEmpleado.setRecuperable(objetoDao);
		this.listaEmpleados = servicioEmpleado.obtenerEmpleadosPorDepartamento(this.idDepartamento);
		return "mostrarEmpleados";
	}
	
	public void detalleEmpleado() {
		EmployeesServices servicioEmpleado = new EmployeesServices();
		Recuperable objetoDao = new EmpleadoHibernateDAO();
		servicioEmpleado.setRecuperable(objetoDao);
		//log.trace("XXXXXXXXXXXXXXXXXXXXX " +this.idEmpleado);
		//int i = Integer.parseInt("er");
		try {
			this.empleado = (Employees) servicioEmpleado.leerEmpleadoServices(this.idEmpleado);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DepartamentoBean() {
		//super();
	}

	public DepartamentoBean(List<Departments> lista,
			List<Employees> listaEmpleados, short idDepartamento,
			int idEmpleado, Employees empleado) {
		super();
		this.lista = lista;
		this.listaEmpleados = listaEmpleados;
		this.idDepartamento = idDepartamento;
		this.idEmpleado = idEmpleado;
		this.empleado = empleado;
	}

	public List<Departments> getLista() {
		return lista;
	}

	public void setLista(List<Departments> lista) {
		this.lista = lista;
	}

	public List<Employees> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Employees> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public short getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(short idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Employees getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employees empleado) {
		this.empleado = empleado;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return idEmpleado*idDepartamento;
	}
	
	@Override
	public boolean equals(Object arg0) {
		boolean iguales = false;
		
		if (arg0 instanceof DepartamentoBean) {
			DepartamentoBean newdtpo = (DepartamentoBean) arg0;
			iguales = (newdtpo.idEmpleado == this.idEmpleado);
		}
		return iguales;
	}
	
	
	
	


	
	
	
}
