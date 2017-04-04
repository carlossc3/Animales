package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Animaleccion;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VAnimaleccion extends JFrame implements Observer {

	private JPanel contentPane;
	private JLabel img = new JLabel("AQUI IRA LA IMAGEN");
	private ButtonGroup opciones = new ButtonGroup();
	private JRadioButton op1 = new JRadioButton("init");
	private JRadioButton op2 = new JRadioButton("init");
	private JRadioButton op3 = new JRadioButton("init");
	private static VAnimaleccion miVAnimaleccion = new VAnimaleccion();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAnimaleccion frame = miVAnimaleccion;
					frame.actualizar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void actualizar() {
		
		Random rm = new Random();
		ArrayList<String> opc = (Animaleccion.getAnimaleccion().getOpciones());
		int random = rm.nextInt(opc.size());
		op1.setText(opc.get(random));
		opc.remove(random);
		random = rm.nextInt(opc.size());
		op2.setText(opc.get(random));
		opc.remove(random);
		random = rm.nextInt(opc.size());
		op3.setText(opc.get(random));
	}

	/**
	 * Create the frame.
	 */
	public VAnimaleccion() {
		Animaleccion.getAnimaleccion().addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		op1.setBounds(38, 42, 127, 25);
		contentPane.add(op1);
		
		
		op2.setBounds(38, 152, 127, 25);
		contentPane.add(op2);
		
		
		op3.setBounds(38, 271, 127, 25);
		contentPane.add(op3);
		
		
		opciones.add(op1);
		opciones.add(op2);
		opciones.add(op3);
		contentPane.add(img);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(415, 286, 116, 25);
		contentPane.add(btnComprobar);
		btnComprobar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String resul = "None";
				if(op1.isSelected()){
					resul = op1.getText();
				}
				if(op2.isSelected()){
					resul = op2.getText();
				}
				if(op3.isSelected()){
					resul = op3.getText();
				}
				if(!resul.equals("None")){
				Animaleccion.getAnimaleccion().comprobar(resul);
				}
				
			}
		});
		
		JLabel vidas = new JLabel("vidas");
		vidas.setBounds(647, 13, 56, 16);
		contentPane.add(vidas);
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
			Random rm = new Random();
			ArrayList<String> opc = (Animaleccion.getAnimaleccion().getOpciones());
			int random = rm.nextInt(opc.size());
			op1.setText(opc.get(random));
			opc.remove(random);
			random = rm.nextInt(opc.size());
			op2.setText(opc.get(random));
			opc.remove(random);
			random = rm.nextInt(opc.size());
			op3.setText(opc.get(random));
			img.setIcon(Animaleccion.getAnimaleccion().getImagen());
		
		
	}

	
	
	
	
}
