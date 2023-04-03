package TrabajoPractico;

import java.io.IOException;
import java.util.Arrays;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		System.out.println(args.length);
		System.out.println(Arrays.toString(args));
		// TODO Auto-generated method stub
		String pathArchivoRondas = args[0];
		String pathArchivoPronosticos = args[1];
		
		
		LectorArchivoRondas lector = new LectorArchivoRondas(pathArchivoRondas);
		
		try {
			Ronda ronda = lector.ronda();
			for (Partido partido : ronda.getPartidos()) {
				
				System.out.println(partido.getEquipo1().getNombre());
				System.out.println(partido.getEquipo2().getNombre());
				System.out.println(partido.getGolesEquipo1());
				System.out.println(partido.getGolesEquipo2());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	LectorArchivoPronosticos p = new LectorArchivoPronosticos(pathArchivoPronosticos);
		System.out.println("pronosticos");
		try {
			Pronostico[] pronosticos = p.pronosticos();
			for (Pronostico pronostico : pronosticos) {
				System.out.println("Jugador: "+pronostico.getParticipante().getNombre());
				System.out.println("Equipo "+pronostico.getEquipo().getNombre());
				System.out.println("Pronostico "+pronostico.getResultado());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
