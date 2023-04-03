package TrabajoPractico;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LectorArchivoRondas {
	
private final String SEPARADOR = ",";
private String path;

public LectorArchivoRondas(String path) {
	super();
	this.path = path;
}

public Ronda ronda() throws IOException {
	
	//Generamos la ruta del archvo
	Path ruta = Paths.get(path);
	
	//Leemos el archivo a una lista de String
	List<String> lineasArchivo = Files.readAllLines(ruta, StandardCharsets.UTF_8);
	
	//Creamos el array de partidos que se va a devolver por ronda
	Partido[] partidos = new Partido[lineasArchivo.size()];
	
	//Recorremos los datos del archivo y separamos por coma ,
	for (int i = 0; i < lineasArchivo.size(); i++) {
		String linea = lineasArchivo.get(i);
		String[] split = linea.split(SEPARADOR);
		
		Equipo equipo1 = new Equipo(split[0]);
		Equipo equipo2	 = new Equipo(split[3] );
		
		Partido partido = new Partido();
		partido.setEquipo1(equipo1);
		partido.setEquipo2(equipo2);
		partido.setGolesEquipo1(Integer.valueOf(split[1]));
		partido.setGolesEquipo2(Integer.valueOf(split[2]));
		partidos[i] = partido;
	}
	
	
	Ronda ronda = new Ronda();
	
	ronda.setPartidos(partidos);
	
	return ronda ;
}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
		
	

	}

	


