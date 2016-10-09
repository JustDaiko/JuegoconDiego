package principal.gestores;

import java.awt.Color;
import java.awt.Graphics2D;

import principal.entes.Enemigo;
import principal.entes.Jugador;
import principal.entes.armas.Flecha;
import principal.entes.objetos.Nokia;
import principal.entes.objetos.Objeto;
import principal.graficos.Hoja;
import principal.librerias.Actualizable;
import principal.librerias.Dibujable;

public class GestorJuego implements Dibujable,Actualizable{
	
	private Jugador jug;
	private Enemigo ene;
	public static double translateX, translateY; 
	
	private Color colorFondo1 = new Color(11,100,166);
	private Color colorFondo2 = Color.white;
	private Objeto nokia;
	
	public GestorJuego() {
		translateX = 0;
		translateY = 0;
		jug = new Jugador(0, 0);
		ene = new Enemigo(0, 200);
		nokia = new Nokia(200, 200, 10, jug);
	}
	public void actualizar() {
		jug.actualizar();
		if(ene != null){
			ene.actualizar();
			for (Flecha f : jug.getArco().getFlechas()) {
				if(f.getBounds().intersects(ene.getBounds())){
					ene.bajarVida(10);
					f.enPantalla = false;
				}
			}
			if(!ene.isVivo()){
				ene = null;
			}
		}  
		nokia.actualizar();
		
	}
	public void dibujar(Graphics2D g) {
		g.setColor(colorFondo2);
		g.fillRect(0, 0, Hoja.ANCHO, Hoja.ALTO);
		g.translate(-translateX, -translateY);
		g.setColor(Color.white);
		jug.dibujar(g);
		nokia.dibujar(g);
		if(ene != null){
			ene.dibujar(g);
		}
		g.translate(translateX, translateY);
	}
}