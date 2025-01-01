package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements ActionListener{
	/**
	 * Inicializaci�n de los componentes
	 */
	private JPanel imagenes;
	private JPanel interfaz;
	private JLabel lblImg;
	private JLabel lblErrores;
	private JLabel lblIntentos;
	private Icon imgInicio;
	private Icon img1;
	private Icon img2;
	private Icon img3;
	private Icon img4;
	private Icon imgFin;
	private Ahorcado juego;
	private JLabel lblPalabraCensurada;
	private JLabel lblIntroducirLetra;
	private JLabel lblCompletarPalabra;
	private JTextField txtLetra;
	private JTextField txtPalabra;
	private JButton btnIntroducir;
	private JButton btnCompletarPalabra;
	private Victoria v;
	
	public Ventana(){
		/**
		 * Inicializaci�n de los componentes
		 */
		juego = new Ahorcado();
		lblPalabraCensurada = new JLabel("Palabra a adivinar: " + juego.getPalabraCensurada());
		imgInicio = new ImageIcon("src/ahorcado_imagenes/ahorcado_inicio.png");
		img1 = new ImageIcon("src/ahorcado_imagenes/ahorcado_1.png");
		img2 = new ImageIcon("src/ahorcado_imagenes/ahorcado_2.png");
		img3 = new ImageIcon("src/ahorcado_imagenes/ahorcado_3.png");
		img4 = new ImageIcon("src/ahorcado_imagenes/ahorcado_4.png");
		imgFin = new ImageIcon("src/ahorcado_imagenes/ahorcado_fin.png");
		lblImg = new JLabel(imgInicio);
		lblIntroducirLetra = new JLabel("Introduce una letra");
		lblErrores = new JLabel("Número de errores permitidos: " + juego.getErrores());
		lblIntentos = new JLabel("Número de intentos restantes: " + juego.getIntentos());
		lblCompletarPalabra = new JLabel("Introduce la palabra");
		imagenes = new JPanel();
		interfaz = new JPanel();
		txtLetra = new JTextField();
		btnIntroducir = new JButton("Introducir letra");
		btnCompletarPalabra = new JButton("Completar");
		txtPalabra = new JTextField();
		
		
		/**
		 * Construcción de la interfaz
		 */
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setTitle("Ahorcado");
		

		add(interfaz);
		interfaz.setLayout(new GridLayout(10, 1, 10, 10));
		interfaz.add(lblPalabraCensurada);
		lblPalabraCensurada.setBounds(10, 10, 100, 10);
		
		interfaz.add(lblIntroducirLetra);
		
		interfaz.add(txtLetra);
		interfaz.add(btnIntroducir);
		interfaz.add(lblCompletarPalabra);
		interfaz.add(txtPalabra);
		interfaz.add(btnCompletarPalabra);
		
		interfaz.add(lblErrores);
		interfaz.add(lblIntentos);
		
		
		add(imagenes);
		imagenes.add(lblImg);
		
		/**
		 * Eventos
		 */
		
		btnIntroducir.addActionListener(this);
		btnCompletarPalabra.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean palabraAcertada;
		if(e.getSource() == btnIntroducir) {
			
			/**
			 * En caso de que el campo de texto est� vac�o se ejecutar� este bloque de c�digo
			 */
			if(txtLetra.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "El campo está vacío", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				
				/**
				 * Mientras no se superen los 10 intentos se podr� seguir jugando. Despu�s se cerrar� el juego
				 */
				if(juego.getIntentos() > 1) {
					
					/**
					 * Se actualiza la palabra censurada con el caracter que se ha indicado en el campo de texto
					 */
					palabraAcertada = juego.intento(txtLetra.getText().toUpperCase().charAt(0));
					lblPalabraCensurada.setText("Palabra a adivinar: " + juego.getPalabraCensurada());
					txtLetra.setText("");
					if(palabraAcertada) {
						juegoGanado();
					}
					
					/**
					 * Contador de errores que actualiza las im�genes seg�n el usuario va cometiendo errores
					 */
					actualizarContadores();
					contadorErrores();
					
				/**
				 * Este bloque se ejecutar� si el juegador se queda sin intentos
				 */
				} else {
					actualizarContadores();
					JOptionPane.showMessageDialog(this, "Te has quedado sin intentos", "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
			
		}
		
		/**
		 * Evento para el bot�n de completar palabra
		 */
		if(e.getSource() == btnCompletarPalabra) {
			if(juego.resolver(txtPalabra.getText().toUpperCase())) {
				juegoGanado();
			} else {
				
				if(txtPalabra.getText() == "") {
					JOptionPane.showMessageDialog(this, "El campo está vacío", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					actualizarContadores();
					contadorErrores();
					txtPalabra.setText("");
				}
			}
		}
		
	}
	
	public void contadorErrores() {
		switch(juego.getErrores()) {
			case 0:
				lblImg.setIcon(imgFin);
				JOptionPane.showMessageDialog(this, "Has alcanzado el m�ximo de errores", "Fin de juego", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
				break;
			case 1:
				lblImg.setIcon(img4);
				break;
			case 2:
				lblImg.setIcon(img3);
				break;
			case 3:
				lblImg.setIcon(img2);
				break;
			case 4:
				lblImg.setIcon(img1);
				break;
				
			/**
			 * Cuando se cometen 5 errores el juego actualiza la im�gen y finaliza 
			 */
			case 5: 
				lblImg.setIcon(imgInicio);
				
		}
	}
	
	public void juegoGanado() {
		JOptionPane.showMessageDialog(this, "FELICIDADES, HAS ACERTADO LA PALABRA", "Fin de juego", JOptionPane.INFORMATION_MESSAGE);
		v = new Victoria(this, true, juego.getIntentos(), juego.getErrores(), juego.getINTENTOS(), juego.getERRORES());
		v.setVisible(true);
		System.exit(0);
	}

	public void actualizarContadores() {
		lblErrores.setText("N�mero de errores permitidos: " + juego.getErrores());
		lblIntentos.setText("N�mero de intentos restantes: " + juego.getIntentos());
	}
}
