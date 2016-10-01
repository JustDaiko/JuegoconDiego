package principal.controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Teclado implements KeyListener {
	private ArrayList<Integer> ultimoApretado = new ArrayList<Integer>();
	private boolean escuchaTecla = false;
	
	public boolean ataca;
	
	private int tecla_arriba = KeyEvent.VK_W;
	private int tecla_izq = KeyEvent.VK_A;
	private int tecla_abajo = KeyEvent.VK_S;
	private int tecla_der = KeyEvent.VK_D;
	private int tecla_atacar = KeyEvent.VK_SPACE;
	
	private int indiceTeclaEscucha = 0;
	
	/*
	 * 0 arriba
	 * 1 izquierda
	 * 2 abajo
	 * 3 derecha
	 */
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == tecla_arriba){
			insertarTecla(0);
		}
		if(e.getKeyCode() == tecla_izq){
			insertarTecla(1);
		}
		if(e.getKeyCode() == tecla_abajo){
			insertarTecla(2);
		}
		if(e.getKeyCode() == tecla_der){
			insertarTecla(3);
		}
		if(e.getKeyCode() == tecla_atacar){
			ataca = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		
		if(escuchaTecla){
			switch (indiceTeclaEscucha) {
			case 0:
				tecla_arriba = e.getKeyCode();
				break;
			case 1:
				tecla_izq = e.getKeyCode();
				break;
			case 2:
				tecla_abajo = e.getKeyCode();
				break;
			case 3:
				tecla_der = e.getKeyCode();
				break;
			}
			escuchaTecla = false;
		}
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == tecla_arriba){
			sacarTecla(0);
		}
		if(e.getKeyCode() == tecla_izq){
			sacarTecla(1);
		}
		if(e.getKeyCode() == tecla_abajo){
			sacarTecla(2);
		}
		if(e.getKeyCode() == tecla_der){
			sacarTecla(3);
		}
		if(e.getKeyCode() == tecla_atacar){
			ataca = false;
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
	
	
	
	public int getUltimaTecla(){
		if(ultimoApretado.isEmpty()){
			return -1;
		}else{
			return ultimoApretado.get(ultimoApretado.size()-1);
		}
	}
	private void insertarTecla(int a){
		if(verificarSiEsta(a) == -1){
			ultimoApretado.add(a);
		}
	}
	private void sacarTecla(int a){
		int b = 0;
		if((b = verificarSiEsta(a)) != -1){
			ultimoApretado.remove(b);
		}
	}
	private int verificarSiEsta(int a){
		for (int i = 0; i < ultimoApretado.size(); i++) {
			if(ultimoApretado.get(i) == a){
				return i;
			}
		}
		return -1;
	}
	public void escucharTecla(int indiceTecla){
		escuchaTecla = true;
		indiceTeclaEscucha = indiceTecla;
	}
	public void dejarDeEscucharTecla(){
		escuchaTecla = false;
	}
	
	
	//Getters
	public int getTecla_salto() {
		return tecla_arriba;
	}
	public int getTecla_izq() {
		return tecla_izq;
	}
	public int getTecla_abajo() {
		return tecla_abajo;
	}
	public int getTecla_der() {
		return tecla_der;
	}
	public void setTecla_salto(int tecla_salto) {
		this.tecla_arriba = tecla_salto;
	}
	public void setTecla_izq(int tecla_izq) {
		this.tecla_izq = tecla_izq;
	}
	public void setTecla_abajo(int tecla_abajo) {
		this.tecla_abajo = tecla_abajo;
	}
	public void setTecla_der(int tecla_der) {
		this.tecla_der = tecla_der;
	}
	
	public String getStringTecla_salto(){
		return (String)(KeyEvent.getKeyText(tecla_arriba));
	}
	public String getStringTecla_izq(){
		return (String)(KeyEvent.getKeyText(tecla_izq));
	}
	public String getStringTecla_abajo(){
		return (String)(KeyEvent.getKeyText(tecla_abajo));
	}
	public String getStringTecla_der(){
		return (String)(KeyEvent.getKeyText(tecla_der));
	}
	
}
