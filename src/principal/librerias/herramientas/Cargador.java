package principal.librerias.herramientas;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Cargador {
	public static Font cargarFont(final String ruta){
		Font font = null;
		try {
            InputStream is =  ClassLoader.class.getResourceAsStream(ruta);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            System.err.println(ruta + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
		return font;
	}
	public static BufferedImage cargarImagen(final String ruta){
		BufferedImage imagenAcelerada = null;
		try {
			Image imagen = ImageIO.read(ClassLoader.class.getResource(ruta));
			
			GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
			imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.TRANSLUCENT);
			Graphics g = imagenAcelerada.getGraphics();
			g.drawImage(imagen, 0, 0, null);
			g.dispose();
			
		} catch (IOException e) {
			System.err.println(ruta + "No se cargo la imagen");
		}
		return imagenAcelerada;
	}
	public static BufferedImage invertirImagenX(BufferedImage imagen){
		BufferedImage imagenInvertida = new BufferedImage(imagen.getWidth(),
										imagen.getHeight(),imagen.getType());
		for (int y = 0; y < imagen.getHeight(); y++) {
			for (int x = 0; x < imagen.getWidth(); x++) {
				imagenInvertida.setRGB(imagen.getWidth()-1 - x, y, imagen.getRGB(x, y));
			}
		}
		
		
		return imagenInvertida;
	}
}
