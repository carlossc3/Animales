package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.GestorAhorcado;
import Modelo.GestorAnimaleccion;

import javax.swing.JButton;

public class VPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipal frame = new VPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnAhorcado = new JButton("Ahorcado de animalitos");
		contentPane.add(btnAhorcado, BorderLayout.CENTER);
		
		
		JButton btnAnimaleccion = new JButton("Animaleccion");
		contentPane.add(btnAnimaleccion, BorderLayout.SOUTH);
		btnAhorcado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GestorAhorcado.getGestorAhorcado().initAhorcado();

				VAhorcado.main(null);
				
			}
		});
		
		btnAnimaleccion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorAnimaleccion.getGestorAnimaleccion().initAnnimaleccion();
				VAnimaleccion.main(null);
				
			}
		});
		
	}

}
