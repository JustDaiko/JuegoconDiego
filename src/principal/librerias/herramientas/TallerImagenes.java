package principal.librerias.herramientas;

import java.awt.image.BufferedImage;

public class TallerImagenes {
	
	/**
	 * 0 = 90 Grados
	 * 1 = 180 Grados
	 * 2 = 270 Grados
	 */
	public static BufferedImage rotarImagen(int deg, BufferedImage im){
		BufferedImage aux = null;
		switch (deg) {
		case 0:
			aux = new BufferedImage(im.getHeight(), im.getWidth(), im.getType());
			for (int x = 0; x < im.getWidth(); x++) {
				for (int y = im.getHeight()-1; y >= 0; y--) {
					aux.setRGB(im.getHeight()-1 - y, x, im.getRGB(x, y));
				}
			}
			break;
		case 1:
			aux = new BufferedImage(im.getWidth(),im.getHeight(), im.getType());
			for (int y = im.getHeight()-1; y >= 0; y--) {
				for (int x = im.getWidth() -1; x >= 0; x--) {
					aux.setRGB(im.getWidth() -1 - x, im.getHeight()-1 - y, im.getRGB(x, y));
				}
			}
			break;
		case 2:
			aux = new BufferedImage(im.getHeight(), im.getWidth(), im.getType());
			for (int x = im.getWidth() -1; x >= 0; x--) {
				for (int y = 0; y < im.getHeight(); y++) {
					aux.setRGB(y, im.getWidth() - 1 - x, im.getRGB(x, y));
				}
			}
			break;
		default:
			System.err.println("Error: no hay opcion " + deg + " para rotar la Imagen");
			return null;
		}
		
		return aux;
	}
}
