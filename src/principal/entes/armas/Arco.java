package principal.entes.armas;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class Arco extends Arma {
	

	private ArrayList<Flecha> flechas;
	private double x,y;
	private int dir;
	private long sec = 1000000000, bandera;
	private double rateDisparo;
	
	
	public Arco(int maxMunicion, double rateDisparo) {
		this.municionMax=maxMunicion;
		municion=maxMunicion;
		flechas=new ArrayList<Flecha>();
		this.rateDisparo = rateDisparo;
	}


	public void actualizar(double x,double y, int dir) {
		this.dir=dir;
		this.x=x;
		this.y=y;
		
		for (int i=0;i<flechas.size();i++){
			Flecha f=flechas.get(i);
			if(f.enPantalla){
				
				f.actualizar();
			}else{
				flechas.remove(i);
			}
		}
		
		if(municion==0){
			recargar();
		}
	}
	public void dibujar(Graphics2D g){
		super.dibujar(g);
		for (Flecha f:flechas){
			
			f.dibujar(g);
		}
		
	}


	@Override
	public void disparar() {
		if(System.nanoTime() - bandera > sec/rateDisparo){
			if (municion!=0){
				flechas.add(new Flecha(x,y,dir));
				municion-=1;
			}
			bandera = System.nanoTime();
		}
	}

	@Override
	public void recargar() {
		if(municionAcumulada>=municionMax){
			municion=municionMax;
			municionAcumulada-=municionMax;
		}else{
			municion=municionAcumulada;
			municionAcumulada=0;
		}
		
	}

	public void recogerMunicion(int recogida) {
		municionAcumulada+=recogida;
		
	}


	public ArrayList<Flecha> getFlechas() {
		return flechas;
	}



	
	

}
