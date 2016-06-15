package pe.edu.upeu.to;

public class CuestionarioTo {
	int id_cuestionario, id_leccion;
	String pregunta, verso, respuesta;
	public CuestionarioTo() {
		// TODO Auto-generated constructor stub
	}
	public int getId_cuestionario() {
		return id_cuestionario;
	}
	public void setId_cuestionario(int id_cuestionario) {
		this.id_cuestionario = id_cuestionario;
	}
	public int getId_leccion() {
		return id_leccion;
	}
	public void setId_leccion(int id_leccion) {
		this.id_leccion = id_leccion;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getVerso() {
		return verso;
	}
	public void setVerso(String verso) {
		this.verso = verso;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}	
	
}
