package principal.entes.objetos;

import principal.entes.Jugador;
import principal.entes.modelos.Colision;

public abstract class Objeto extends Colision {
	protected boolean enPantalla;
	
	protected Jugador jug;

	public Objeto(double x, double y, int ancho, int alto, Jugador jug) {
		super(x, y, ancho, alto);
		enPantalla = true;
		this.jug = jug;
	}

	
}
