package principal.graficos;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	public Ventana(final Hoja hoja) {
		setFocusable(true);
		if(Hoja.fullScreen){
			setUndecorated(true);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(hoja);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
