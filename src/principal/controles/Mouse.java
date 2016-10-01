package principal.controles;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import principal.gestores.GestorJuego;
import principal.graficos.Hoja;

public class Mouse implements MouseListener,MouseMotionListener{
	private int x,y;
	private boolean click, click2;
	
	public void mouseClicked(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			click = true;
		}
		if(e.getButton() == MouseEvent.BUTTON3){
			click2 = true;
		}
		x = e.getX();
		y = e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			click = false;
		}
		if(e.getButton() == MouseEvent.BUTTON3){
			click2 = false;
		}
	}
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	public int getX() {
		if(Hoja.fullScreen){
			return (int)(x / Hoja.escalaY)-Hoja.anchoEscala/2;
		}
		return x;
	}
	public int getY() {
		if(Hoja.fullScreen){
			return (int) (y / Hoja.escalaY);
		}
		return y;
	}
	public int getXtrans() {
		if(Hoja.fullScreen){
			return (int) ((( x / Hoja.escalaY)-Hoja.anchoEscala/2)+GestorJuego.translateX);
		}
		return (int) (x+ GestorJuego.translateX);
	}
	public int getYtrans() {
		if(Hoja.fullScreen){
			return (int) ((y / Hoja.escalaY) + GestorJuego.translateY);
		}
		return (int) (y+ GestorJuego.translateY);
	}
	public Point2D getPoint(){
		if(Hoja.fullScreen){
			return new Point((int)(x / Hoja.escalaY)-Hoja.anchoEscala/2,(int) (y / Hoja.escalaY));
		}
		return new Point(x,y);
	}
	/**
	 *Devuelve si esta clickeando e inmediatamente deja el click en falso 
	 *@return
	 */
	public boolean isClick() {
		if(click){
			click = false;
			return true;
		}
		return false;
	}
	/**
	 * Devuelve si esta clickeando
	 * @return
	 */
	public boolean isClickJuego() {
		return click;
	}
	/**
	 * Devuelve si esta clickeando el click derecho e inmediatamente deja el click en falso 
	 * @return
	 */
	
	public boolean isClick2(){
		if(click2){
			click2 = false;
			return true;
		}
		return false;
	}
	/**
	 * Devuelve si esta clickeando el click derecho
	 * @return
	 */
	public boolean isClick2Juego() {
		return click2;
	}
}
