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

public class Reg extends JFrame {

	private JPanel contentPane;
	private Image fondo;

	private JLabel lblNombre;
	private JLabel lblUsuario;
	private JLabel lblPass;
	private JTextField textNombre;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg frame = new Reg();
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
	public Reg() {
		/*Image icon = new ImageIcon(getClass().getResource("img//5.png")).getImage();
		setIconImage(icon);
		fondo = new ImageIcon(getClass().getResource("img//rinoceronte.jpg")).getImage();*/
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
		contentPane.add(getLblNombre(), "cell 1 0,alignx center");
		contentPane.add(getLblUsuario(), "cell 1 1,alignx center");
		contentPane.add(getLblPass(), "cell 1 2,alignx center");
		contentPane.add(getTextNombre(), "cell 3 0,alignx center");
		contentPane.add(getTextUsuario(), "cell 3 1,alignx center");
		contentPane.add(getTextPassword(), "cell 3 2,alignx center");
		contentPane.add(getBtnAceptar(), "cell 1 4,alignx center");
		contentPane.add(getBtnCancelar(), "cell 3 4,alignx center");
		setTitle("Registro");
	}

	// Creacion de los elementos de la pantall
	private JTextField getTextUsuario() {
		if (textUsuario == null) {
			textUsuario = new JTextField();
			textUsuario.setColumns(10);
			textUsuario.setMaximumSize(new Dimension(200, 50));
		}
		return textUsuario;
	}

	private JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setColumns(10);
			textNombre.setMaximumSize(new Dimension(200, 50));
		}
		return textNombre;
	}

	private JPasswordField getTextPassword() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setColumns(10);
			passwordField.setMaximumSize(new Dimension(200, 50));
		}
		return passwordField;
	}

	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
		}
		return lblUsuario;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
		}
		return lblNombre;
	}

	private JLabel getLblPass() {
		if (lblPass == null) {
			lblPass = new JLabel("Clave:");
		}
		return lblPass;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Registrarse");
			btnAceptar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// Comprobamos si ha pulsado el boton aceptar
					if (e.getButton() == MouseEvent.BUTTON1) {
						// Miramos si el usuario ha introducido todos los campos
						// que se solicitan
						// si no los ha introducido se le mostrara un mensaje
						// informativo y podra volver a introducir datos
						if (OperacionesReg_Id.comprobarSiCamposRellenos(getTextNombre().getText(),
								getTextUsuario().getText(), getTextPassword().getPassword()) == false) {
							JOptionPane.showMessageDialog(null, "Es obligatorio introducir los datos para registrarse.",
									"Faltan Datos", JOptionPane.INFORMATION_MESSAGE);
							clearCampos();
						} else {
							// Si ha introducido datos en los campos, se
							// comprueba si es posible registrarse con dichos
							// datos introducido
							// si no lo es, se le informa y podra volver a
							// rellenar los datos.
							if (GestorJugadores.getGestorJugadores()
									.buscarSiExisteUsuario(getTextUsuario().getText()) == true) {
								JOptionPane.showMessageDialog(null,
										"El usuario con el que desea registrarse en el juego ya existe, introduzca otro.",
										"Usuario no valido", JOptionPane.WARNING_MESSAGE);
								clearCampos();
							} else {
								// Si es posible registrarse con los datos
								// introducidos, se añade el nuevo jugador a la
								// base de datos, y
								// entrara a la aplicacion.
								boolean bien = GestorJugadores.getGestorJugadores().anadirJugador(
										getTextNombre().getText(), getTextUsuario().getText(),
										OperacionesReg_Id.getContra(getTextPassword().getPassword()));
								if (bien) {
									JOptionPane.showMessageDialog(null, "El registro se ha realizado con exito.",
											"Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
									VPrincipal vMI = new VPrincipal();
									vMI.setVisible(true);
									setVisible(false);
								} else {
									// si ocurre algun error al añadir el
									// jugador se informara al usuario.
									JOptionPane.showMessageDialog(null,
											"No ha sido posible realizar el registro, intentelo de nuevo.",
											"Registro Fallido", JOptionPane.ERROR_MESSAGE);
									clearCampos();
								}
							}
						}
					}
				}
			});
		}
		return btnAceptar;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						Reg_id vReid = new Reg_id();
						vReid.setVisible(true);
						setVisible(false);
					}
				}
			});
		}

		return btnCancelar;
	}

	private void clearCampos() {
		textNombre.setText(null);
		textUsuario.setText(null);
		passwordField.setText(null);
	}

}
