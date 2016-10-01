package principal.graficos.animacion;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import principal.entes.modelos.Vivo;
import principal.librerias.Actualizable;
import principal.librerias.herramientas.Cargador;
public class AnimacionVivo implements Actualizable{
	private int dir = 0;
	private boolean ataca, mueve=true;
	private Vivo ente;
	private BufferedImage spriteImagen;
	private AnimacionIndividual abrirMano_Arriba, abrirMano_Izq, abrirMano_Abajo, abrirMano_Der;
	private AnimacionIndividual[] animacionesDeCaminar, animacionesDeAtacar, animacionesDeArco;
	public AnimacionVivo(String ruta, Vivo ente,double vel) {
		spriteImagen = Cargador.cargarImagen(ruta);
		this.ente = ente;
//Arco!!
		animacionesDeArco = new AnimacionIndividual[4];
		animacionesDeArco[0]= new AnimacionIndividual (cargarArrayImagenes(16,5,5,9),0.1);
		animacionesDeArco[1]= new AnimacionIndividual(cargarArrayImagenes(17,5,5,9),0.1 );
		animacionesDeArco[2]= new AnimacionIndividual(cargarArrayImagenes(18,5,5,9),0.1);
		animacionesDeArco[3]= new AnimacionIndividual(cargarArrayImagenes(19,5,5,9),0.1);
//Espadita que va para un sólo lado y no colabora con mi TOC-
		animacionesDeAtacar = new AnimacionIndividual[4];
		animacionesDeAtacar[0] = new AnimacionIndividual(cargarArrayImagenes(12, 6), 0.1);
		animacionesDeAtacar[1] = new AnimacionIndividual(cargarArrayImagenes(13, 6), 0.1);
		animacionesDeAtacar[2] = new AnimacionIndividual(cargarArrayImagenes(14, 6), 0.1);
		animacionesDeAtacar[3] = new AnimacionIndividual(cargarArrayImagenes(15, 6), 0.1);
		
		
		
		abrirMano_Arriba = new AnimacionIndividual(cargarArrayImagenes(0, 7), 0.1);
		abrirMano_Izq = new AnimacionIndividual(cargarArrayImagenes(1, 7), 0.1);
		abrirMano_Izq = new AnimacionIndividual(cargarArrayImagenes(2, 7), 0.1);
		abrirMano_Izq = new AnimacionIndividual(cargarArrayImagenes(3, 7), 0.1);
		
		
		animacionesDeCaminar = new AnimacionIndividual[4];
		animacionesDeCaminar[0] = new AnimacionIndividual(cargarArrayImagenes(8, 9), (3*0.06)/vel);
		animacionesDeCaminar[1] = new AnimacionIndividual(cargarArrayImagenes(9, 9), (3*0.06)/vel);
		animacionesDeCaminar[2] = new AnimacionIndividual(cargarArrayImagenes(10, 9), (3*0.06)/vel);
		animacionesDeCaminar[3] = new AnimacionIndividual(cargarArrayImagenes(11, 9), (3*0.06)/vel);
	}
	public void dibujar(Graphics2D g, int x, int y) {
		if(ataca){
			animacionesDeArco[dir].dibujar(g, x, y);
		}else{
			animacionesDeCaminar[dir].dibujar(g,x,y);
		}
	}
	public void actualizar() {
		this.dir = ente.getDir();
		this.mueve = ente.getMueve();
		this.ataca = ente.getAtaca();
		if(ataca){
			animacionesDeArco[dir].actualizar();
		}else{
			animacionesDeCaminar[dir].actualizar();
		}
		animacionesDeCaminar[dir].setAnimar(mueve);
		animacionesDeArco[dir].setAnimar(ataca);
	}
	private BufferedImage[] cargarArrayImagenes(int y, int cant){
		BufferedImage[] array = new BufferedImage[cant];
		for (int i = 0; i < array.length; i++) {
			array[i] = spriteImagen.getSubimage(i*64, y*64, 64, 64);
		}
		return array;
	}
	private BufferedImage[] cargarArrayImagenes(int y,int cant, int inicio, int fin){
		BufferedImage[] array = new BufferedImage[cant];
		for (int i = inicio; i <= fin; i++) {
			array[i-inicio] = spriteImagen.getSubimage(i*64, y*64, 64, 64);
		}
		return array;
	}
}