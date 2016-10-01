package principal.entes;

import java.awt.Graphics2D;

import principal.entes.modelos.Vivo;
import principal.graficos.animacion.AnimacionVivo;

public class Enemigo extends Vivo{
	private AnimacionVivo animacion;
	
	public Enemigo(double x, double y) {
		super(x, y, 64, 64, 50, 0.5);//x,y, alto, ancho, vida y velocidad.
		animacion = new AnimacionVivo("/imagenes/enemigo.png",this,velocidad);
	}
	public void dibujar(Graphics2D g) {
		animacion.dibujar(g,(int)x, (int)y);
		
	}

	public void actualizar() {
		animacion.actualizar();
		x+= velocidad;
		dir = 3;
		mueve = true;
	}

}
