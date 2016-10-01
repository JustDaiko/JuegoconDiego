package principal.graficos.animacion;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import principal.librerias.Actualizable;

public class AnimacionIndividual implements Actualizable{
	private BufferedImage[] sprites;
	private double intervalo;
	private long bandera;
	private boolean animar;
	private int index;
	private final int seg = 1000000000;
	
	public AnimacionIndividual(BufferedImage [] sprites, double intervalo) {
		this.sprites = sprites;
		this.intervalo = intervalo;
		index = 0;
	}
	
	public void dibujar(Graphics2D g, int x, int y) {
		g.drawImage(sprites[index],x,y, null);
	}
	public void actualizar() {
		if(animar){
			if(System.nanoTime() - bandera > intervalo*seg){
				index++;
				bandera = System.nanoTime();
			}
			if(index == sprites.length){
				index = 0;
			}
		}
	}
	public void setAnimar(boolean animar) {
		this.animar = animar;
		if(animar == false){
			index = 0;
		}
	}
	
}
