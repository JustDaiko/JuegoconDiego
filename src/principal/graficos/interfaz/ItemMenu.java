package principal.graficos.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import principal.controles.Controles;
import principal.librerias.Actualizable;
import principal.librerias.Dibujable;
import principal.librerias.herramientas.MedidorStrings;

public class ItemMenu implements Dibujable,Actualizable {
	private String palabraFija, palabraActualizable = "",palabra = "";
	private int x,y;
	private Rectangle2D bounds;
	private boolean mouseArriba;
	private int tamañoFont = 35;
	private int tamañoFontSeleccion = 40;
	private boolean clickeado = false;
	
	
	public ItemMenu(String palabraFija, int x, int y) {
		this.palabraFija = palabraFija;
		this.x = x;
		this.y = y;
		bounds = new Rectangle();
	}
	public void actualizar() {
		palabra = palabraFija + palabraActualizable;
		if(bounds.contains(Controles.mouse.getPoint())){
			mouseArriba = true;
			if(Controles.mouse.isClick()){
				clickeado = true;
			}else{
				clickeado = false;
			}
		}else{
			clickeado = false;
			mouseArriba = false;
		}
	}
	public void dibujar(Graphics2D g) {
		if(mouseArriba){
			g.setColor(new Color(255,0,150));
			g.setFont(g.getFont().deriveFont(Font.PLAIN, tamañoFontSeleccion));
		}else{
			g.setColor(new Color(0,80,170));
			g.setFont(g.getFont().deriveFont(Font.PLAIN, tamañoFont));
		}
		bounds = MedidorStrings.boundsString(palabra, g, x - MedidorStrings.anchoString(palabra, g)/2, y - g.getFontMetrics().getAscent());
		g.drawString(palabra, x -MedidorStrings.anchoString(palabra, g)/2, y);
	}
	public boolean isClickeado() {
		return clickeado;
	}
	public String getPalabraActualizable() {
		return palabraActualizable;
	}
	public void setPalabraActualizable(String palabraActualizable) {
		this.palabraActualizable = palabraActualizable;
	}
	public void setPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
}
