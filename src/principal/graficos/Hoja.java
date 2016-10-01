package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import principal.Constantes;
import principal.controles.Controles;
import principal.gestores.GestorPrincipal;
import principal.librerias.Actualizable;
import principal.librerias.herramientas.Cargador;

public class Hoja extends Canvas implements Actualizable{
	
	public static int ANCHO_PANTALLA, ALTO_PANTALLA;
	
	public static int ANCHO = 800,ALTO = 600;
	
	private Dimension pantalla;
	public static boolean fullScreen = false;
	private static boolean copyScreen = fullScreen;
	public static int anchoEscala;
	public static double escalaX, escalaY;
	
	private GestorPrincipal gp;
	private Font font;
	private Ventana ven;
	
	public Hoja() {
		addMouseListener(Controles.mouse);
		addMouseMotionListener(Controles.mouse);
		addKeyListener(Controles.teclado);
		gp = new GestorPrincipal();
		pantalla = new Dimension(ANCHO,ALTO);
		font = Cargador.cargarFont(Constantes.rutaFont);
		font = font.deriveFont(Font.PLAIN, 35);
		if(fullScreen){
			pantalla = Toolkit.getDefaultToolkit().getScreenSize();
			ANCHO_PANTALLA = pantalla.width;
			ALTO_PANTALLA = pantalla.height;
			escalaX = (double)ANCHO_PANTALLA/ANCHO;
			escalaY = (double)ALTO_PANTALLA/ALTO;
			anchoEscala =  (int) (ANCHO_PANTALLA  - (ANCHO * escalaY));
		}else{
			ANCHO_PANTALLA = ANCHO;
			ALTO_PANTALLA = ALTO;
			escalaY = 1;
			escalaX = 1;
		}
		setPreferredSize(pantalla);
		anchoEscala = (int) (anchoEscala / escalaY);
	}
	public void dibujar(){
		if(getBufferStrategy() == null){
			createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) getBufferStrategy().getDrawGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(font);
		g.setColor(Color.black);
		
		if(fullScreen){
			g.scale(escalaY ,escalaY);
			g.translate((double)anchoEscala/2, 0);
		}
		
		g.fillRect(0, 0, ANCHO_PANTALLA, ALTO_PANTALLA);
		g.setColor(Color.white);
		
		gp.dibujar(g);
		
		g.setColor(Color.BLACK);
		
		if(fullScreen){
			g.fillRect(0-(anchoEscala/2), 0, anchoEscala/2, ALTO);
			g.fillRect(ANCHO, 0, anchoEscala/2, ALTO);
		}
		g.dispose();
		getBufferStrategy().show();
		
	}
	public void actualizar(){
		gp.actualizar();
		verificarCambioPantalla();
	}
	
	
	public void verificarCambioPantalla(){
		if(copyScreen != fullScreen){
			copyScreen = fullScreen;
			if(fullScreen){
				pantalla = Toolkit.getDefaultToolkit().getScreenSize();
				ANCHO_PANTALLA = pantalla.width;
				ALTO_PANTALLA = pantalla.height;
				escalaX = (double)ANCHO_PANTALLA/ANCHO;
				escalaY = (double)ALTO_PANTALLA/ALTO;
				anchoEscala =  (int) (ANCHO_PANTALLA  - (ANCHO * escalaY));
				setPreferredSize(pantalla);
				anchoEscala = (int) (anchoEscala / escalaY);
				ven.dispose();
				ven.setUndecorated(true);
				ven.pack();
				ven.setVisible(true);
				ven.setLocationRelativeTo(null);
			}else{
				pantalla = new Dimension(ANCHO,ALTO);
				ANCHO_PANTALLA = ANCHO;
				ALTO_PANTALLA = ALTO;
				escalaY = 1;
				escalaX = 1;
				anchoEscala =  (int) (ANCHO_PANTALLA  - (ANCHO * escalaY));
				setPreferredSize(pantalla);
				anchoEscala = (int) (anchoEscala / escalaY);
				ven.dispose();
				ven.setUndecorated(false);
				ven.pack();
				ven.setVisible(true);
				ven.setLocationRelativeTo(null);
			}
		}
	}
//	Getters
	public double getEscalaX() {
		return escalaX;
	}
	public double getEscalaY() {
		return escalaY;
	}
	public void setVen(Ventana ven) {
		this.ven = ven;
	}
}
