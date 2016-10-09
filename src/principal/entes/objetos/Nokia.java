package principal.entes.objetos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import principal.Constantes;
import principal.entes.Jugador;

public class Nokia extends Objeto {
	private BufferedImage imagen;
	private int municion;
	
	
	public Nokia(double x, double y, int municion,Jugador jug) {
		super(x, y, 64, 64,jug);
		imagen = Constantes.MUN_NOKIA;
		this.municion = municion;
	}

	public void dibujar(Graphics2D g) {
		g.drawImage(imagen,(int) x,(int) y, ancho, alto, null);
	}

	public void actualizar() {
		if(jug.getBounds().intersects(getBounds())){
			jug.getArco().recogerMunicion(agarranMunicion());
		}
	}
	public int agarranMunicion(){
		enPantalla = false;
		return municion;
	}
	
}
