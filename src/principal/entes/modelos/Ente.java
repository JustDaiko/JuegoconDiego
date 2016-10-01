package principal.entes.modelos;

import principal.librerias.Actualizable;
import principal.librerias.Dibujable;

public abstract class Ente implements Dibujable, Actualizable {
	protected double x,y;
	
	
	public Ente(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
}
