package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Ahorcado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VAhorcado extends JFrame implements Observer{

	private JPanel contentPane;
	private JTextField input;
	private JLabel lblImg = new JLabel("");
	private JLabel lblAnimalito = new JLabel("Animalito");
	private static VAhorcado miVAhorcado = new VAhorcado();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAhorcado frame = miVAhorcado;
				    frame.actualizar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void actualizar() {
		setAnimal(Ahorcado.getAhorcado().getGame());

		lblImg.setIcon(Ahorcado.getAhorcado().getImg());
		
	}
	
	public static VAhorcado getVista(){
		return miVAhorcado;
	}

	/**
	 * Create the frame.
	 */
	public VAhorcado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setAnimal(Ahorcado.getAhorcado().getGame());
		lblAnimalito.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAnimalito.setBounds(173, 37, 541, 49);
		contentPane.add(lblAnimalito);
		
		input = new JTextField();
		input.setBounds(474, 150, 61, 22);
		contentPane.add(input);
		input.setColumns(10);
		
		JLabel lblIntrouceUnaLetra = new JLabel("Introduce una letra");
		lblIntrouceUnaLetra.setBounds(290, 153, 117, 16);
		contentPane.add(lblIntrouceUnaLetra);
		
		JButton btnRendirse = new JButton("Rendirse");
		btnRendirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRendirse.setBounds(218, 199, 97, 25);
		contentPane.add(btnRendirse);
		
		JButton btnComprobar = new JButton("Comprobar");
		
		btnComprobar.setBounds(579, 199, 97, 25);
		btnComprobar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(input.getText().length()==1){
					Ahorcado.getAhorcado().comprobar(input.getText().toUpperCase().charAt(0));
				}
				
			}
		});
		contentPane.add(btnComprobar);
		
		
		
		
		lblImg.setBounds(30, 24, 97, 116);
		contentPane.add(lblImg);
		Ahorcado.getAhorcado().addObserver(this);
		
		
	}

	private void setAnimal(String[] game) {
		String animal="";
		for(String gap: game){
			animal= animal+gap+" ";
		}
		lblAnimalito.setText(animal);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int cont = (Integer) arg1;
		if(cont==0){
			lblImg.setIcon(Ahorcado.getAhorcado().getImg());
			if(Ahorcado.getAhorcado().getIntentos()==0){
				
			}
			
		}

		//Finalizado con exito
		if(cont==-1){
			VAhFin.main(null);
		}
		
		if(cont==-2){
			lblImg.setIcon(Ahorcado.getAhorcado().getImg());
			VAhGameOver.main(null);
		}
		
		if(cont!=0 && cont != -1 && cont != -2){		
			setAnimal(Ahorcado.getAhorcado().getGame());
		}
		
		
	}
}
