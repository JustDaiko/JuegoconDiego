package principal.entes;

import java.awt.Graphics2D;

import principal.controles.Controles;
import principal.entes.armas.Arco;
import principal.entes.modelos.Vivo;
import principal.graficos.animacion.AnimacionVivo;

public class Jugador extends Vivo {
	private AnimacionVivo animacion;
	private Arco arco;
	
	
	public Jugador(double x, double y) {
		super(x, y, 64, 64, 100, 2);
		animacion = new AnimacionVivo("/imagenes/male.png",this,velocidad);
		arco = new Arco(5,3);
		
	}
	public void dibujar(Graphics2D g) {
		arco.dibujar(g);
		animacion.dibujar(g,(int)x,(int)y);
	}

	public void actualizar() {
		if(!Controles.teclado.ataca){
			ataca = false;
			mover();
		}else{
			atacar();
		}
		animacion.actualizar();
		arco.actualizar(getCenter().getX()-6, getCenter().getY()-5, dir);
	}
	private void mover(){
		/*
		 * 0 arriba
		 * 1 izquierda
		 * 2 abajo
		 * 3 derecha
		 */
		
		if(Controles.teclado.getUltimaTecla() != -1){
			mueve = true;
			switch (Controles.teclado.getUltimaTecla()) {
			case 0:
				y-= velocidad;
				dir = 0;
				break;
			case 1:
				x-= velocidad;
				dir = 1;
				break;
			case 2:
				y+= velocidad;
				dir = 2;
				break;
			case 3:
				x+= velocidad;
				dir = 3;
				break;
			}
		}else{
			mueve = false;
		}
	}
	
	
	private void atacar(){
		mueve = false;
		ataca = true;
		arco.disparar();
		
	}
	public Arco getArco() {
		return arco;
	}
}
