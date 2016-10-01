package principal.entes.armas;

import java.awt.Color;
import java.awt.Graphics2D;

import principal.graficos.Hoja;
import principal.librerias.Dibujable;

public abstract class Arma implements  Dibujable{
	
	
	protected int municion;
	protected int municionMax;
	protected int municionAcumulada=25;
	abstract void disparar();
	abstract void recargar();
	abstract void recogerMunicion(int recogida);
	abstract void actualizar(double x,double y, int dir);
	
	public void dibujar(Graphics2D g) {
		Color rosita=new Color(255,0,255);
		g.setColor(Color.BLACK);
		g.fillRect(Hoja.ANCHO-123, Hoja.ALTO-80, 120, 50);
		g.setColor(rosita);
		g.drawString(municion+"",Hoja.ANCHO-120,Hoja.ALTO-50);
		g.drawString(" - ", Hoja.ANCHO-80, Hoja.ALTO-50);
		g.drawString(municionAcumulada+"", Hoja.ANCHO-40, Hoja.ALTO-50);
		g.setColor(Color.WHITE);
		g.drawRect(Hoja.ANCHO-123, Hoja.ALTO-80, 120, 50);
		
		
	}

}
