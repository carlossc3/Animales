package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Ahorcado;
import Modelo.GestorAhorcado;
import Modelo.GestorAnimaleccion;

import javax.swing.JLabel;
import javax.swing.JButton;

public class VAnGameOver extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(VAhorcado vAhorcado) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAnGameOver frame = new VAnGameOver();
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
	public VAnGameOver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHasPerdido = new JLabel("HAS PERDIDOOO, te has quedado sin vidas");
		lblHasPerdido.setBounds(60, 35, 317, 16);
		contentPane.add(lblHasPerdido);
		
	
		
		JButton btnJugarOtraVez = new JButton("Jugar Otra Vez");
		btnJugarOtraVez.setBounds(234, 184, 143, 25);
		contentPane.add(btnJugarOtraVez);
		btnJugarOtraVez.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VAnimaleccion.main(null);
				GestorAnimaleccion.getGestorAnimaleccion().initAnnimaleccion();
				
				dispose();
				
			}
		});
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setBounds(60, 184, 123, 25);
		btnMenuPrincipal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.main(null);
				VAnimaleccion.getVista().setVisible(false);
				dispose();
				
			}
		});
		contentPane.add(btnMenuPrincipal);
		
	}
}
