package views;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import config.conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AddPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtEstatura;
	private JTextField txtPeso;
	private JTextArea txtNotas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPaciente frame = new AddPaciente();
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
	public AddPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddPaciente.class.getResource("/images/nutri_logo.png")));
		setResizable(false);
		setTitle("Registrar Nuevo Paciente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int validacion = 0;
				String nombre;
				String notas;
				String edad;
				String estatura;
				String peso;
				
				//Tomar datos de los campos
				nombre = txtNombre.getText().trim();
				notas = txtNotas.getText();				
				edad = txtEdad.getText().trim();
				estatura = txtEstatura.getText().trim();
				peso = txtPeso.getText().trim();
				
				//Validar los datos de los campos
				if (nombre.equals("")){
					txtNombre.setBackground(Color.red);
					validacion++;
				}
				if (notas.equals("")){
					txtNotas.setBackground(Color.red);
					validacion++;
				}
				if (edad.equals("")){
					txtEdad.setBackground(Color.red);
					validacion++;
				}
				if (estatura.equals("")){
					txtEstatura.setBackground(Color.red);
					validacion++;
				}
				if (peso.equals("")){
					txtPeso.setBackground(Color.red);
					validacion++;
				}
				
				//validar no exista paciente repetido
				try {
					Connection cn = conexion.conectar();
					PreparedStatement pst = cn.prepareStatement("select nombre_paciente from pacientes where nombre_paciente ='" + nombre + "'");
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()) {
						txtNombre.setBackground(Color.red);
						JOptionPane.showMessageDialog(null,"El paciente ya existe!");
						cn.close();						
					} else {
						
						cn.close();
						
						if(validacion == 0) {
							try {
								Connection cn2 = conexion.conectar();
								PreparedStatement pst2 = cn2.prepareStatement("insert into pacientes values(?,?,?,?,?,?)");
								
								pst2.setInt(1,0);
								pst.setString(2, nombre);
								pst.setInt(3, Integer.valueOf(edad));
								pst.setDouble(4, Double.valueOf(estatura));
								pst.setDouble(5, Double.valueOf(peso));
								pst.setString(6, notas);
								
								pst2.executeUpdate();
								cn2.close();
								
								Limpiar();
								
								txtNombre.setBackground(Color.green);
								txtEdad.setBackground(Color.green);
								txtEstatura.setBackground(Color.green);
								txtPeso.setBackground(Color.green);
								txtNotas.setBackground(Color.green);
								
								JOptionPane.showMessageDialog(null,"Registro exitoso.");
								//Code to close window
								cerrarVentana();
								
							} catch (SQLException e2) {
								System.err.println("Error en el registro del paciente." + e2);
								JOptionPane.showMessageDialog(null, "Error al registrar paciente!");
							}		
						
						}else {
							JOptionPane.showMessageDialog(null, "Debes llenar todos los campos!");
						}
					}
				
				}	catch (SQLException error) {
						System.err.println("Error al validar nombre del paciente." + error);
						JOptionPane.showMessageDialog(null, "Error al agregar el nombre del nuevo paciente!");				
				}
			
		}
		});
		
		txtNotas = new JTextArea();
		txtNotas.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNotas.setWrapStyleWord(true);
		txtNotas.setLineWrap(true);
		txtNotas.setBounds(452, 124, 280, 232);
		contentPane.add(txtNotas);
		
		btnSave.setIcon(new ImageIcon(AddPaciente.class.getResource("/images/add.png")));
		btnSave.setBounds(549, 442, 95, 92);
		contentPane.add(btnSave);
		
		JLabel lblNotas = new JLabel("Anotaciones del Paciente");
		lblNotas.setForeground(Color.WHITE);
		lblNotas.setFont(new Font("Arial", Font.BOLD, 14));
		lblNotas.setBounds(495, 91, 192, 22);
		contentPane.add(lblNotas);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Arial", Font.BOLD, 14));
		lblPeso.setBounds(30, 441, 59, 22);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(30, 474, 220, 20);
		contentPane.add(txtPeso);
		
		JLabel lblEstatura = new JLabel("Estatura");
		lblEstatura.setForeground(Color.WHITE);
		lblEstatura.setFont(new Font("Arial", Font.BOLD, 14));
		lblEstatura.setBounds(30, 303, 59, 22);
		contentPane.add(lblEstatura);
		
		txtEstatura = new JTextField();
		txtEstatura.setColumns(10);
		txtEstatura.setBounds(30, 336, 220, 20);
		contentPane.add(txtEstatura);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(new Font("Arial", Font.BOLD, 14));
		lblEdad.setBounds(30, 194, 59, 22);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(30, 227, 220, 20);
		contentPane.add(txtEdad);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(30, 124, 220, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre del Paciente");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(30, 91, 160, 22);
		contentPane.add(lblNombre);
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(5, 5, 774, 556);
		contentPane.add(jLabel_Wallpaper);
		
		ImageIcon wallpaper = new ImageIcon("src/images/wallPaperPrincipal.jpg");
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
	}
	public void Limpiar() {
		txtNombre.setText("");
		txtEdad.setText("");
		txtEstatura.setText("");
		txtPeso.setText("");
		txtNotas.setText("");
	}
	public void cerrarVentana() {
	    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

	    setVisible(false);
	    dispose();	    
	}
}
