package pruebaJSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class NumeroBeanM {

	private int n;
	
	public void mostrar(){
		//String numero = ""+n+1;
		//return numero;
		this.n++;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public NumeroBeanM(int n) {
		super();
		this.n = n;
	}

	public NumeroBeanM() {
		super();
	}
	
	
}
