package principal.librerias.herramientas;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class MedidorStrings {
	public static int altoString(String s, Graphics2D g){
		return g.getFontMetrics().getHeight();
	}
	public static int anchoString(String s,Graphics2D g){
		return g.getFontMetrics().stringWidth(s);
	}
	public static Rectangle2D boundsString(String s, Graphics2D g, int x, int y){
		Rectangle2D bounds = g.getFontMetrics().getStringBounds(s, g);
		bounds.setRect(x, y, bounds.getWidth(), bounds.getHeight());
		return bounds;
	}
	public static Rectangle2D boundsStringMargen(String s, Graphics2D g, int margen){
		Rectangle2D bounds = g.getFontMetrics().getStringBounds(s, g);
		Rectangle2D boundsMargen = new Rectangle((int)bounds.getX()-margen, (int)bounds.getY()-margen ,(int)bounds.getWidth()+(margen*2), (int)bounds.getHeight()+(margen*2));
		return boundsMargen;
	}
}
