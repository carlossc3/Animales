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
import Modelo.GestorAnimaleccion;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VAnimaleccion extends JFrame implements Observer {

	private JPanel contentPane;
	JLabel vidas = new JLabel("vidas");
	private JLabel img = new JLabel("AQUI IRA LA IMAGEN");
	private ButtonGroup opciones = new ButtonGroup();
	private JRadioButton op1 = new JRadioButton("init");
	private JRadioButton op2 = new JRadioButton("init");
	private JRadioButton op3 = new JRadioButton("init");
	private static VAnimaleccion miVAnimaleccion = new VAnimaleccion();
	private final JLabel fase = new JLabel("fase");

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
	public static VAnimaleccion getVista(){
		return miVAnimaleccion;
	}

	protected void actualizar() {
		
		/*Random rm = new Random();
		ArrayList<String> opc = (Animaleccion.getAnimaleccion().getOpciones());
		int random = rm.nextInt(opc.size());
		op1.setText(opc.get(random));
		opc.remove(random);
		random = rm.nextInt(opc.size());
		op2.setText(opc.get(random));
		opc.remove(random);
		random = rm.nextInt(opc.size());
		op3.setText(opc.get(random));

		img.setIcon(Animaleccion.getAnimaleccion().getImagen());*/
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
		img.setBounds(261, 46, 409, 214);
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
					if(Animaleccion.getAnimaleccion().getFase()<4){
				Animaleccion.getAnimaleccion().comprobar(resul);}
				}
				
			}
		});
		
		
		vidas.setBounds(647, 13, 56, 16);
		contentPane.add(vidas);
		fase.setBounds(647, 290, 56, 16);
		
		contentPane.add(fase);
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
			Random rm = new Random();
			System.out.println("update");
			vidas.setText("vidas: "+Animaleccion.getAnimaleccion().getVidas());
			fase.setText("fase: "+Animaleccion.getAnimaleccion().getFase()+1);
			if(Animaleccion.getAnimaleccion().getVidas()<0){
				VAnGameOver.main(null);
			}else if(Animaleccion.getAnimaleccion().getFase()>3){
				VAnFin.main(null);
			}else{
				ArrayList<String> opc = new ArrayList<String>();
				opc = (Animaleccion.getAnimaleccion().getOpciones());
				int random = rm.nextInt(opc.size());
				System.out.println(opc.size());
				op1.setText(opc.get(random));
				op1.setSelected(false);
				//opc.remove(random);
				random = rm.nextInt(opc.size());
				op2.setText(opc.get(random));
				op2.setSelected(false);
				//opc.remove(random);
				random = rm.nextInt(opc.size());
				op3.setText(opc.get(random));
				op3.setSelected(false);
				System.out.println(op1.getText());
				System.out.println(op2.getText());
				System.out.println(op3.getText());
				random = rm.nextInt(3);
				System.out.println(random);
				if(random ==0){
					System.out.println("entro en 0");
					op1.setText(Animaleccion.getAnimaleccion().getSolucion2());
					System.out.println(op1.getText());
				}
				if(random ==1){
					System.out.println("entro en 1");
					op2.setText(Animaleccion.getAnimaleccion().getSolucion2());
					System.out.println(op2.getText());
				}
				if(random ==2){
					System.out.println("entro en 2");
					op3.setText(Animaleccion.getAnimaleccion().getSolucion2());
					System.out.println(op3.getText());
				}
				img.setIcon(Animaleccion.getAnimaleccion().getImagen());
				System.out.println(Animaleccion.getAnimaleccion().getSolucion2());
			}
		}
		
	}

	
	
	
	

