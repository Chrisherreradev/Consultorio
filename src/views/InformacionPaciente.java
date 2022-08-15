package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class InformacionPaciente extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionPaciente frame = new InformacionPaciente();
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
	public InformacionPaciente() {				
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformacionPaciente.class.getResource("/images/nutri_logo.png")));
		setTitle("Visualizar Informacion del Paciente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre del Paciente");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(31, 40, 160, 22);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(31, 73, 220, 20);
		contentPane.add(textField);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(new Font("Arial", Font.BOLD, 14));
		lblEdad.setBounds(31, 143, 59, 22);
		contentPane.add(lblEdad);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(31, 176, 220, 20);
		contentPane.add(textField_1);
		
		JLabel lblEstatura = new JLabel("Estatura");
		lblEstatura.setForeground(Color.WHITE);
		lblEstatura.setFont(new Font("Arial", Font.BOLD, 14));
		lblEstatura.setBounds(31, 252, 59, 22);
		contentPane.add(lblEstatura);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(31, 285, 220, 20);
		contentPane.add(textField_2);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Arial", Font.BOLD, 14));
		lblPeso.setBounds(31, 390, 59, 22);
		contentPane.add(lblPeso);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(31, 423, 220, 20);
		contentPane.add(textField_3);
		
		JTextArea txtNotas = new JTextArea();
		txtNotas.setWrapStyleWord(true);
		txtNotas.setLineWrap(true);
		txtNotas.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNotas.setBounds(453, 73, 280, 232);
		contentPane.add(txtNotas);
		
		JLabel lblNotas = new JLabel("Anotaciones del Paciente");
		lblNotas.setForeground(Color.WHITE);
		lblNotas.setFont(new Font("Arial", Font.BOLD, 14));
		lblNotas.setBounds(496, 40, 192, 22);
		contentPane.add(lblNotas);
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 784, 561);
		contentPane.add(jLabel_Wallpaper);
		
		//Cambiar imagen de fondo
		ImageIcon wallpaper = new ImageIcon("src/images/wallPaperPrincipal.jpg");
		this.repaint();
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		
		
		
	}
}
