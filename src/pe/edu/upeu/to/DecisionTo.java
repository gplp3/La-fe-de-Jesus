package pe.edu.upeu.to;

public class DecisionTo {
	int id_decision, id_leccion ,estado;
	String nombre, verso;
	public DecisionTo() {
		// TODO Auto-generated constructor stub
	}
	public int getId_decision() {
		return id_decision;
	}
	public void setId_decision(int id_decision) {
		this.id_decision = id_decision;
	}
	public int getId_leccion() {
		return id_leccion;
	}
	public void setId_leccion(int id_leccion) {
		this.id_leccion = id_leccion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getVerso() {
		return verso;
	}
	public void setVerso(String verso) {
		this.verso = verso;
	}	
}
