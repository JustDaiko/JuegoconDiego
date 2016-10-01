package principal.gestores;

import java.awt.Color;
import java.awt.Graphics2D;

import principal.Principal;
import principal.graficos.interfaz.Menu;
import principal.librerias.Actualizable;
import principal.librerias.Dibujable;

public class GestorPrincipal implements Dibujable,Actualizable{
	private Menu menu;
	private GestorJuego juego;
	
	
	
	
	enum estados_Juego {MENU,JUEGO}
	private estados_Juego estadoJuego = estados_Juego.MENU;
	
	public GestorPrincipal() {
		if(estadoJuego == estados_Juego.MENU){
			menu =  new Menu();
		}
		
		
	}
	public void actualizar() {
		if(estadoJuego == estados_Juego.MENU){
			menu.actualizar();
			if(menu.estado == menu.estado.JUEGO){
				estadoJuego = estados_Juego.JUEGO;
				juego = new GestorJuego();
				menu = null;
			}
		}else if(estadoJuego == estados_Juego.JUEGO){
			juego.actualizar();
		}
	}
	public void dibujar(Graphics2D g) {
		if(estadoJuego == estados_Juego.MENU){
			menu.dibujar(g);
			
		}else if(estadoJuego == estados_Juego.JUEGO){
			juego.dibujar(g);
		}
		g.setColor(Color.red);
		g.drawString("APS: " + Principal.APS + " FPS: " + Principal.FPS, 20, 20);
	}
}
