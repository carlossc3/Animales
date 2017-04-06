package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Animaleccion;
import Modelo.Preguntas;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VPreguntas extends JFrame implements Observer {

	private JPanel contentPane;
	JLabel pregunta = new JLabel("");
	private ButtonGroup opciones = new ButtonGroup();
	private JRadioButton op1 = new JRadioButton("init");
	private JRadioButton op2 = new JRadioButton("init");
	private JRadioButton op3 = new JRadioButton("init");
	private JRadioButton op4 = new JRadioButton("init");
	private static VPreguntas miVPreguntas = new VPreguntas();
	private JLabel vidas = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPreguntas frame = miVPreguntas;
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
	public VPreguntas() {
		Preguntas.getPreguntas().addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pregunta.setHorizontalAlignment(SwingConstants.CENTER);
		pregunta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pregunta.setBounds(12, 30, 636, 65);
		contentPane.add(pregunta);
		
		op1.setBounds(74, 150, 214, 25);
		contentPane.add(op1);
		
		op2.setBounds(74, 230, 214, 25);
		contentPane.add(op2);
		
		op3.setBounds(425, 150, 199, 25);
		contentPane.add(op3);
		
		op4.setBounds(425, 230, 214, 25);
		contentPane.add(op4);
		opciones.add(op1);
		opciones.add(op2);
		opciones.add(op3);
		opciones.add(op4);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(259, 305, 141, 25);
		contentPane.add(btnComprobar);
		vidas.setBounds(442, 309, 119, 16);
		
		contentPane.add(vidas);
		btnComprobar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
				if(op4.isSelected()){
					resul = op4.getText();
				}
				if(!resul.equals("None")){
					if(Preguntas.getPreguntas().getFase()<5){
				Preguntas.getPreguntas().comprobar(resul);}
				}
				
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		if(Preguntas.getPreguntas().getVidas()<0){
			VPGameOver.main(null);
		}
		
		if(Preguntas.getPreguntas().getFase()==5){
			VPFin.main(null);
		}
		if(Preguntas.getPreguntas().getFase()<5 && Preguntas.getPreguntas().getVidas()>=0){
		int fase = Preguntas.getPreguntas().getFase();
		vidas.setText("vidas: "+Preguntas.getPreguntas().getVidas());
		pregunta.setText(Preguntas.getPreguntas().getPregunta());
		System.out.println(Preguntas.getPreguntas().getPregunta());
		Random rm = new Random();
		op1.setText("None");
		op1.setSelected(false);
		op2.setText("None");
		op2.setSelected(false);
		op3.setText("None");
		op3.setSelected(false);
		op4.setText("None");
		op4.setSelected(false);
		String[] falsas = Preguntas.getPreguntas().getFalsas();
		String solucion = Preguntas.getPreguntas().getSolucion();
		int pos = rm.nextInt(4);
		System.out.println("random "+pos);
		if(pos == 0){
			op1.setText(solucion);
		}
		if(pos == 1){
			op2.setText(solucion);
		}
		if(pos == 2){
			op3.setText(solucion);
		}
		if(pos == 3){
			op4.setText(solucion);
		}
		pos = 0;
		
		while(pos<3){
			
			if(op1.getText().equals("None")){
				System.out.println(1);
				op1.setText(falsas[pos]);
				
			}else if(op2.getText().equals("None")){
				System.out.println(2);
				op2.setText(falsas[pos]);
			} else if(op3.getText().equals("None")){
				System.out.println(3);
				op3.setText(falsas[pos]);
			}else if(op4.getText().equals("None")){
				System.out.println(4);
				op4.setText(falsas[pos]);
			}
			pos++;
		}

		
		}
	}

	public static VPreguntas getVista() {
		return miVPreguntas;
	}
}
