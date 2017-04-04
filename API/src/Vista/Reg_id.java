package Vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelo.GestorJugadores;
import Modelo.OperacionesReg_Id;
import net.miginfocom.swing.MigLayout;

public class Reg_id extends JFrame {

	private JPanel contentPane;	
	private Image fondo;

	private JLabel lblPass;
	private JLabel lblUsuario;
	private JButton btnLogin;
	private JButton btnRegistrarse;
	private JTextField textUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg_id frame = new Reg_id();
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
	public Reg_id() {
		/*Image icon = new ImageIcon(getClass().getResource("img//5.png")).getImage();
		setIconImage(icon);
		fondo = new ImageIcon(getClass().getResource("img//rinoceronte.jpg")).getImage();*/
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 277);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[188.00][][][][][][][224.00]", "[60.00][61.00][50][50][50]"));
		contentPane.add(getLblUsuario(), "cell 1 0,alignx center");
		contentPane.add(getTextUsuario(), "cell 3 0,alignx center");
		contentPane.add(getLblPassword(), "cell 1 1,alignx center");
		contentPane.add(getTextPassword(), "cell 3 1,alignx center");
		contentPane.add(getBtnLogin(), "cell 1 3,alignx center");
		contentPane.add(getBtnRegistrarse(), "cell 3 3,alignx center");
		setTitle("Bienvenido");
	}
	// Creacion de los elementos de la pantalla
		private JTextField getTextUsuario() {
			if (textUsuario == null) {
				textUsuario = new JTextField(10);
				textUsuario.setColumns(10);
				textUsuario.setMaximumSize(new Dimension(200, 50));
			}
			return textUsuario;
		}

		private JPasswordField getTextPassword() {
			if (passwordField == null) {
				passwordField = new JPasswordField();
				passwordField.setColumns(10);
				passwordField.setMaximumSize(new Dimension(200, 50));
			}
			return passwordField;
		}

		private JButton getBtnLogin() {
			if (btnLogin == null) {
				btnLogin = new JButton("Login");
				btnLogin.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						//Si ha pulsado el boton de Login
						if (e.getButton() == MouseEvent.BUTTON1) {
							//Comprobamos primero si los campos han sido rellenados
							// si no es el caso se le mostrara un mensaje, permitiendole volver a introducir los datos.
							if (OperacionesReg_Id.comprobarSiCamposRellenos(getTextUsuario().getText(),
									
									
									getTextPassword().getPassword()) == false) {
								JOptionPane.showMessageDialog(null, "Es obligatorio introducir los datos para logearse.",
										"Datos no introducidos", JOptionPane.WARNING_MESSAGE);
								clearCampos();
							} else {
								// Si los datos han sido introducidos se comprobara si son corrctos
								boolean re = GestorJugadores.getGestorJugadores().datosCorrectos(
										getTextUsuario().getText().toString(),
										OperacionesReg_Id.getContra(getTextPassword().getPassword()));
								// si no son correctos se les mostrara un mensaje y se les permitira volver a introducirlos
								if (re == false) {
									JOptionPane.showMessageDialog(null,
											"Usuario y/o clave incorrectos, introduzcalos nuevamente.", "Datos incorrectos",
											JOptionPane.WARNING_MESSAGE);
									clearCampos();
								} else {
									// si son correcto accederan al menu principal
								
									VPrincipal vMI = new VPrincipal();
									vMI.setVisible(true);
									setVisible(false);
									//clip.stop();
								}
							}
						}
					}
				});
			}
			return btnLogin;
		}

		private JButton getBtnRegistrarse() {
			if (btnRegistrarse == null) {
				btnRegistrarse = new JButton("Registrarse");
				btnRegistrarse.addMouseListener(new MouseAdapter() {
					// Si selecciona esta opcion se dirigira al usuario a la pantalla de registro
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON1) {
							Reg vReg = new Reg();
							vReg.setVisible(true);
							setVisible(false);
						}
					}
				});
			}

			return btnRegistrarse;
		}

		private JLabel getLblUsuario() {
			if (lblUsuario == null) {
				lblUsuario = new JLabel("Usuario:");

			}
			return lblUsuario;
		}

		private JLabel getLblPassword() {
			if (lblPass == null) {
				lblPass = new JLabel("Clave de acceso:");
			}
			return lblPass;
		}

		private void clearCampos(){
			textUsuario.setText(null);
			passwordField.setText(null);
		}
}
