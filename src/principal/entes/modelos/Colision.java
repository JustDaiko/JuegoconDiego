package principal.entes.modelos;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class Colision extends Ente {
	
	protected int ancho,alto;
	
	public Colision(double x, double y, int ancho, int alto) {
		super(x, y);
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public boolean colision(Rectangle2D bounds){
		return this.getBounds().intersects(bounds);
	}
	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(x,y,ancho,alto);
	}
	public Point2D getCenter(){
		return new Point2D.Double(x + (ancho/2) , y + (alto/2));
	}
	protected void intercambiarBounds(){
		int aux = ancho;
		ancho = alto;
		alto = aux;
	}
}
