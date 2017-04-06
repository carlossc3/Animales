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
import Modelo.GestorPreguntas;

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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAhorcado = new JButton("Ahorcado de animalitos");
		btnAhorcado.setBounds(5, 5, 422, 31);
		contentPane.add(btnAhorcado);
		
		
		JButton btnAnimaleccion = new JButton("Animaleccion");
		btnAnimaleccion.setBounds(5, 111, 422, 25);
		contentPane.add(btnAnimaleccion);
		
		JButton btnPreguntas = new JButton("AnimalQuizz");
		btnPreguntas.setBounds(0, 215, 427, 25);
		contentPane.add(btnPreguntas);
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
				VAnimaleccion.main(null);
				GestorAnimaleccion.getGestorAnimaleccion().initAnnimaleccion();
				
				
			}
		});
		
		btnPreguntas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPreguntas.main(null);
				GestorPreguntas.getGestorPreguntas().initPreguntas();
				
			}
		});
	}

}
