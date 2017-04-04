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

import javax.swing.JLabel;
import javax.swing.JButton;

public class VAhFin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(VAhorcado vAhorcado) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAhFin frame = new VAhFin();
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
	public VAhFin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHasPerdidoooJaaajajaja = new JLabel("HAS GANADO");
		lblHasPerdidoooJaaajajaja.setBounds(60, 35, 317, 16);
		contentPane.add(lblHasPerdidoooJaaajajaja);
		
		JLabel lblLaSolucinEra = new JLabel("La soluci\u00F3n era: "+ Ahorcado.getAhorcado().getSolucion());
		lblLaSolucinEra.setBounds(60, 87, 180, 16);
		contentPane.add(lblLaSolucinEra);
		
		JButton btnJugarOtraVez = new JButton("Jugar Otra Vez");
		btnJugarOtraVez.setBounds(234, 184, 143, 25);
		contentPane.add(btnJugarOtraVez);
		btnJugarOtraVez.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorAhorcado.getGestorAhorcado().initAhorcado();
				VAhorcado.main(null);
				dispose();
				
			}
		});
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setBounds(60, 184, 123, 25);
		btnMenuPrincipal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VPrincipal.main(null);
				VAhorcado.getVista().setVisible(false);
				dispose();
				
			}
		});
		contentPane.add(btnMenuPrincipal);
		
	}
}
