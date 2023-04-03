package TrabajoPractico;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LectorArchivoPronosticos {
	
private final String SEPARADOR = ",";
private String path;

public LectorArchivoPronosticos(String path) {
	super();
	this.path = path;
}

public Pronostico[] pronosticos() throws IOException {
	
	//Generamos la ruta del archvo
	Path ruta = Paths.get(path);
	
	//Leemos el archivo a una lista de String
	List<String> lineasArchivo = Files.readAllLines(ruta, StandardCharsets.UTF_8);
	
	//Creamos el array de partidos que se va a devolver por ronda
	Pronostico[] pronosticos = new Pronostico[lineasArchivo.size()];
	
	//Recorremos los datos del archivo y separamos por coma ,
	for (int i = 0; i < lineasArchivo.size(); i++) {
		String linea = lineasArchivo.get(i);
		String[] split = linea.split(SEPARADOR);
		
		boolean gana = split[1].equalsIgnoreCase("x");
		boolean empata = split[2].equalsIgnoreCase("x");
		boolean pierde = split[3].equalsIgnoreCase("x");
		
		Equipo equipo1 = new Equipo(split[0]);
		Equipo equipo2	 = new Equipo(split[3]);
		
		Partido partido = new Partido();
		partido.setEquipo1(equipo1);
		partido.setEquipo2(equipo2);
		
		Pronostico pronostico = new Pronostico();
		pronostico.setEquipo(equipo1);
		pronostico.setPartido(partido);
		
		pronostico.setParticipante(new Participante(split[5]));
		
		if (gana) {
			pronostico.setResultado(ResultadoEnum.ganador);
		}else if(empata) {
			pronostico.setResultado(ResultadoEnum.empate);
		}else {
			pronostico.setResultado(ResultadoEnum.perdedor);
		}
		pronosticos[i] = pronostico;
	}
	return pronosticos ;
}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
		
	

	}

	


