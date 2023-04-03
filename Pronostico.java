package TrabajoPractico;

public class Pronostico {

	private Participante participante;
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum  resultado;
	
	
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public ResultadoEnum getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}
	public Participante getParticipante() {
		return participante;
	}
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	

}
