package principal.entes.modelos;

public abstract class Vivo extends Colision {
	protected double vida, velocidad;
	protected boolean vivo;
	protected int dir = 0;
	protected boolean mueve, ataca;

	//Contructores
	public Vivo(double x, double y, int ancho, int alto, double vida, double velocidad) {
		super(x, y, ancho, alto);
		this.vida = vida;
		this.velocidad = velocidad;
		vivo = true;
		
	}
	public Vivo(double x, double y, int ancho, int alto, double vida, double velocidad, boolean vivo) {
		super(x, y, ancho, alto);
		this.vida = vida;
		this.velocidad = velocidad;
		this.vivo = vivo;
	}

	
	//Metodos
	public void bajarVida(int daño){
		vida-=daño;
		if(vida <= 0){
			vivo = false;
		}
	}
	
	//Getters & setters
//	public Line2D getLineaArriba(){
//		Rectangle2D a = getBounds();
//		return new Line2D.Double(a.getMinX() +4, a.getMinY() + rateGraviti, a.getMaxX()-4, a.getMinY() + rateGraviti);
//	}
//	public Line2D getLineaIzquierda(){
//		Rectangle2D a = getBounds();
//		return new Line2D.Double(a.getMinX() - velocidad, a.getMinY()+4, a.getMinX() - velocidad, a.getMaxY()-4);
//	}
//	public Line2D getLineaAbajo(){
//		Rectangle2D a = getBounds();
//		return new Line2D.Double(a.getMinX()+4, a.getMaxY() + rateGraviti, a.getMaxX()-4, a.getMaxY() + rateGraviti);
//	}
//	public Line2D getLineaDerecha(){
//		Rectangle2D a = getBounds();
//		return new Line2D.Double(a.getMaxX() + velocidad, a.getMinY()+4, a.getMaxX() + velocidad, a.getMaxY()-4);
//	}
	
	
	public double getVida() {
		return vida;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public int getDir() {
		return dir;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public boolean getMueve() {
		return mueve;
	}
	public boolean getAtaca() {
		return ataca;
	}
}
