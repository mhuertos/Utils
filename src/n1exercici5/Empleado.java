package n1exercici5;

import java.io.Serializable;

public class Empleado implements Serializable {
	
	private String nom;
	private double sueldo;
	
	public Empleado(String n, double sueldo) {
		nom = n;
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [nom=" + nom + ", sueldo=" + sueldo + "]";
	}
	
	
}
