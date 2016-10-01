package principal;

import principal.graficos.Hoja;
import principal.graficos.Ventana;

public class Principal {
	public static int APS = 0,FPS = 0;
	public static void main(String[] args) {
		Hoja hoja = new Hoja();
		Ventana ven = new Ventana(hoja);
		hoja.setVen(ven);
		
		int APS = 0,FPS = 0;
		
		byte apsEstimado = 60;
		long inicioBucle = System.nanoTime();
		long tiempoRecorrido = System.nanoTime();
		long seg = 1000000000;
		long objetivo = seg/apsEstimado;
		double delta = 0;
		double alfa = 0;
		
		
		while(1<2){
			tiempoRecorrido = System.nanoTime() - inicioBucle;
			inicioBucle = System.nanoTime();
			delta +=(double) tiempoRecorrido/objetivo;
			alfa +=(double) tiempoRecorrido/seg;
			while(delta >= 1){
				delta--;
				hoja.actualizar();
				APS++;
			}
			hoja.dibujar();
			FPS++;
			while(alfa >= 1){
				Principal.APS = APS;
				Principal.FPS = FPS;
				
				APS = 0;
				FPS = 0;
				alfa--;
			}
		}
	}
}
