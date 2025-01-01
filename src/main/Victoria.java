package main;

import javax.swing.*;

@SuppressWarnings("serial")
public class Victoria extends JDialog{
	private JLabel lblIntentos;
	private JLabel lblErrores;
	
	public Victoria(Ventana parent, boolean modal, int intentos, int errores, int CONSTintentos, int CONSTerrores) {
		super(parent, modal);

		lblErrores = new JLabel("Errores cometidos: " + (CONSTerrores - errores));
		lblIntentos = new JLabel("Intentos necesarios: " + (CONSTintentos - intentos));
		
		setLayout(null);
		setSize(200, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
		add(lblErrores);
		add(lblIntentos);
		
		lblErrores.setBounds(10, 10, 150, 20);
		lblIntentos.setBounds(10, 30, 150, 20);
		
	}

}
