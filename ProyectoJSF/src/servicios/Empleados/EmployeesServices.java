//package Empleados;
package servicios.Empleados;

import hibernateAll.sesion.manager.SesionManager;
import interfaces.interfaceRecuperable.Recuperable;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import practicaHibernate.EmployeesDAO;




import tablas_Clases.Employees;

//import empleadoHibernateDAO.EmpleadoHibernateDAO;
//import interfaceRecuperable.Recuperable;

public class EmployeesServices {

	private Recuperable objetoDao;
	private EmployeesDAO empleadoDao;
	private final static Logger log = Logger.getLogger("mylog");
	
	public EmployeesServices(){
		empleadoDao = new EmployeesDAO();
	}
	
	public void setRecuperable(Recuperable objetoDao){
		this.objetoDao = objetoDao;
	}
	
	public Object leerEmpleadoServices(int id)throws ClassNotFoundException, SQLException{
		Object empleado = null;
		empleado = this.objetoDao.leerEmpleado(id);//en funcion del tipo, llamara a un metodo o a otro (hibernate, jdb, hibernateJPa)
		return empleado;
	}
	
	
	/**
	 * Metodo para incrementar el salario a todos los empleados
	 * @return Devuelve un lista con todos los empleados a los que le ha incrementado el salario
	 */
	public List<Employees> incrementarSalario(BigDecimal incremento){
		List<Employees> lista = null;
		Transaction transaccion = null;
		Iterator<Employees> it = null;
		Employees empleado = null;
		//BigDecimal bd = new BigDecimal(1.2);
		try{
			//obtener una sesion con el sesionManager
			Session s = SesionManager.getSesion();
			//esta secion la usara el employeesDao
			empleadoDao.setSesion(s);
			//inicio transaccion
			transaccion = s.beginTransaction();
			lista = empleadoDao.obtenerEmpleados();
			it = lista.iterator();
			while(it.hasNext()){
				empleado = it.next();
				empleado.setSalary(empleado.getSalary().multiply(incremento));
			}
			transaccion.commit();
		}
		catch(Exception e){
			log.error("Error al incrementar los salario en la clase EmployeesSevices");
			e.printStackTrace();
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		return lista;
	}
	
	public List<Employees> obtenerEmpleadosPorDepartamento(short departamentoID){
		
		List<Employees> lista = null;
		Transaction transaccion = null;
		
		try{
			//obtener una sesion con el sesionManager
			Session s = SesionManager.getSesion();
			//esta secion la usara el employeesDao
			empleadoDao.setSesion(s);
			//inicio transaccion
			transaccion = s.beginTransaction();
			lista = empleadoDao.obtenerEmpleadosPorDepartamento(departamentoID);
			
		}
		catch(Exception e){
			log.error("Error alobtenerEmpleadosPorDepartamento en la clase EmployeesSevices");
			e.printStackTrace();
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		
		return lista;
	}
	
}
