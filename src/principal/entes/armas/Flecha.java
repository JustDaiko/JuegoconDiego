package principal.entes.armas;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import principal.entes.modelos.Colision;
import principal.graficos.Hoja;
import principal.librerias.Dibujable;
import principal.librerias.herramientas.Cargador;
import principal.librerias.herramientas.TallerImagenes;

public class Flecha extends Colision implements Dibujable{
	
	private int dir;
	private double vel;
	private BufferedImage flecha;
	public boolean enPantalla;
	private int daño;
	

	public Flecha(double x, double y,  int dir) {
		super(x,y,10,(int) (10*2.13));
		flecha= Cargador.cargarImagen("/imagenes/Flechita.png");
		switch (dir) {
		case 2:
			flecha = TallerImagenes.rotarImagen(1, flecha);
			break;
		case 0:
			break;
		case 1:
			flecha = TallerImagenes.rotarImagen(2, flecha);
			intercambiarBounds();
			break;
		case 3:
			flecha = TallerImagenes.rotarImagen(0, flecha);
			intercambiarBounds();
			break;
		}
		this.dir=dir;
		enPantalla=true;
		
		
		
		//VELOCIDAD, MIRÁ ACA PLEOTUDO. gracias ;) 15 número piola.
		vel=11;
		daño = 10;
	}

	public void dibujar(Graphics2D g) {
		g.drawImage(flecha, (int)x, (int)y,ancho,alto,   null);
//		g.setColor(Color.magenta);
//		g.fillRect((int)x, (int) y, 20, 20);
//		g.setColor(Color.red);
//		g.fillRect((int)x, (int) y, 10, 10);
//		g.draw(getBounds());
	}

	public void actualizar() {
		switch(dir){
		case 0:
			if(y+alto>=0){
				y-=vel;
			}else enPantalla=false;
			break;
		case 1:
			if(x+ancho>=0){
				x-=vel;
				
			}else enPantalla=false;
			break;
		case -1:
		case 2:
			if(y<=Hoja.ALTO){
				y+=vel;
				
			}else enPantalla=false;
			break;
		case 3:
			if(x<=Hoja.ANCHO){
				
				x+=vel;
			}else enPantalla=false;
			break;
		
		}
		
	}

	

}
