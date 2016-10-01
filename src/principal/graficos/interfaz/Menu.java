package principal.graficos.interfaz;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import principal.controles.Controles;
import principal.graficos.Hoja;
import principal.librerias.Actualizable;
import principal.librerias.Dibujable;
import principal.librerias.herramientas.Cargador;

public class Menu implements Dibujable,Actualizable{
	
	public enum estadoMenu{MENU,OPCIONES,JUEGO,CONTROLES}
	
	public estadoMenu estado = estadoMenu.MENU;
	
	private BufferedImage fondo,fondo2;
	private double x1,x2;
	
	private int mitadPantalla = Hoja.ANCHO/2;
	
	
	
	private ItemMenu stringJugar;
	private ItemMenu stringOpciones;
	private ItemMenu stringSalir;
	private ItemMenu stringAtras;
	private ItemMenu stringControles;
	private ItemMenu stringPantallaCompleta;
	private ItemMenu stringTeclaSalto,stringTeclaIzq,stringTeclaAbajo,stringTeclaDerecha;
	public Menu() {
		fondo = Cargador.cargarImagen("/imagenes/paisaje.png");
		fondo2 = Cargador.invertirImagenX(fondo);
		x1 = 0;
		x2 = (int) (fondo.getWidth()*0.55);
		stringJugar = new ItemMenu("Jugar", mitadPantalla, 250);
		stringOpciones = new ItemMenu("Opciones", mitadPantalla, 300);
		stringSalir = new ItemMenu("Salir",mitadPantalla,350);
		
		
		stringControles = new ItemMenu("Controles", mitadPantalla,250);
		stringPantallaCompleta = new ItemMenu("Pantalla completa: ", mitadPantalla, 300);
		stringAtras = new ItemMenu("Atras", mitadPantalla, 350);
		
		stringTeclaSalto = new ItemMenu("Arriba: ", mitadPantalla, 200);
		stringTeclaIzq = new ItemMenu("Izquierda: ", mitadPantalla, 250);
		stringTeclaAbajo = new ItemMenu("Abajo: ", mitadPantalla, 300);
		stringTeclaDerecha = new ItemMenu("Derecha: ", mitadPantalla, 350);
		
		
	}
	public void actualizar() {
		moverFondo();
		if(estado == estadoMenu.MENU){
			stringJugar.actualizar();
			stringOpciones.actualizar();
			stringSalir.actualizar();
			
			if(stringJugar.isClickeado()){
				estado = estadoMenu.JUEGO;
			}
			if(stringOpciones.isClickeado()){
				estado = estadoMenu.OPCIONES;
			}
			
			if(stringSalir.isClickeado()){
				System.exit(0);
			}
		}else if(estado == estadoMenu.OPCIONES){
			stringAtras.setPoint(mitadPantalla, 350);
			stringAtras.actualizar();
			stringControles.actualizar();
			
			if(Hoja.fullScreen){
				stringPantallaCompleta.setPalabraActualizable("On");
				if(stringPantallaCompleta.isClickeado()){
					Hoja.fullScreen = false;
				}
			}else{
				stringPantallaCompleta.setPalabraActualizable("Off");
				if(stringPantallaCompleta.isClickeado()){
					Hoja.fullScreen = true;
				}
			}
			
			
			stringPantallaCompleta.actualizar();
			
			
			if(stringControles.isClickeado()){
				estado = estadoMenu.CONTROLES;
			}
			
			
			if(stringAtras.isClickeado()){
				estado = estadoMenu.MENU;
			}
		}else if(estado == estadoMenu.CONTROLES){
			stringAtras.setPoint(mitadPantalla, 400);
			stringTeclaSalto.setPalabraActualizable(Controles.teclado.getStringTecla_salto());
			stringTeclaIzq.setPalabraActualizable(Controles.teclado.getStringTecla_izq());
			stringTeclaAbajo.setPalabraActualizable(Controles.teclado.getStringTecla_abajo());
			stringTeclaDerecha.setPalabraActualizable(Controles.teclado.getStringTecla_der());
			stringTeclaSalto.actualizar();
			stringTeclaIzq.actualizar();
			stringTeclaAbajo.actualizar();
			stringTeclaDerecha.actualizar();
			stringAtras.actualizar();
			
			if(stringTeclaSalto.isClickeado()){
				Controles.teclado.escucharTecla(0);
			}
			if(stringTeclaIzq.isClickeado()){
				Controles.teclado.escucharTecla(1);
			}
			if(stringTeclaAbajo.isClickeado()){
				Controles.teclado.escucharTecla(2);
			}
			if(stringTeclaDerecha.isClickeado()){
				Controles.teclado.escucharTecla(3);
			}
			if(stringAtras.isClickeado()){
				Controles.teclado.dejarDeEscucharTecla();
				estado = estadoMenu.OPCIONES;
			}
			
		}
	}
	public void dibujar(Graphics2D g) {
		g.drawImage(fondo, (int) x1, 0,(int)(fondo.getWidth()*0.55),(int)(fondo.getHeight()*0.55), null);
		g.drawImage(fondo2, (int) x2, 0,(int)(fondo2.getWidth()*0.55),(int)(fondo2.getHeight()*0.55), null);
		
		if(estado == estadoMenu.MENU){
			stringJugar.dibujar(g);
			stringOpciones.dibujar(g);
			stringSalir.dibujar(g);
		}else if(estado == estadoMenu.OPCIONES){
			stringControles.dibujar(g);
			stringPantallaCompleta.dibujar(g);
			stringAtras.dibujar(g);
		}else if(estado == estadoMenu.CONTROLES){
			stringTeclaSalto.dibujar(g);
			stringTeclaIzq.dibujar(g);
			stringTeclaAbajo.dibujar(g);
			stringTeclaDerecha.dibujar(g);
			stringAtras.dibujar(g);
		}
	}
	
	private void moverFondo(){
		x1-= 0.5;
		x2-= 0.5;
		if(x1 + fondo.getWidth()*0.55 < 0){
			x1 = x2 + fondo2.getWidth()*0.55;
		}
		if(x2 + fondo2.getWidth()*0.55 < 0){
			x2 = x1 + fondo.getWidth()*0.55;
		}
	}
}
