package hibernateAll.empleadoHibernateDAO;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tablas_Clases.Employees;
import tablas_Clases.Usuario;

import hibernateAll.sesion.manager.SesionManager;
import interfaces.interfaceRecuperable.Recuperable;

public class UsuarioHibernateDAO  {

	private final Logger log = LogManager.getRootLogger();

	public Object leerUsuario(String nombre) throws ClassNotFoundException, SQLException {
		
		Session sesion = null;;
		Usuario usuario = null;
		try{
			sesion = SesionManager.getSesion();
			usuario = (Usuario) sesion.get(Usuario.class, nombre);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		return usuario;
	}

}
