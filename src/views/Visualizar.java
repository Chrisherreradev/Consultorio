package views;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import config.conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import java.sql.*;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Visualizar extends JFrame {	
	private JTable table;
	public String user_update = "";
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizar frame = new Visualizar();
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
	public Visualizar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Visualizar.class.getResource("/images/nutri_logo.png")));
		setTitle("Visualizar / Gestionar");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 110, 677, 317);
		getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JLabel lblTitulo = new JLabel("PACIENTES REGISTRADOS");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(275, 36, 238, 53);
		getContentPane().add(lblTitulo);
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 784, 561);
		getContentPane().add(jLabel_Wallpaper);
		
				//Cambiar imagen de fondo
				ImageIcon wallpaper = new ImageIcon("src/images/wallPaperPrincipal.jpg");
				Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
				jLabel_Wallpaper.setIcon(icono);
				this.repaint();							
			
		try {
			Connection cn = conexion.conectar();
			PreparedStatement pst = cn.prepareStatement("select id_paciente, nombre_paciente, edad, estatura, peso, anotaciones_paciente from pacientes");
			
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel)table.getModel();	
			
			model.addColumn("ID");
			model.addColumn("EDAD");
			model.addColumn("ESTATURA");
			model.addColumn("PESO");
			model.addColumn("NOTAS");
			
			//Este codigo es para agregar el nombre a las columnas tal cual estan en la BD
			/*int columnas = rsmd.getColumnCount();
			String[] colName = new String[columnas];
			
			for (int i = 0; i < columnas; i++)
				colName[i] = rsmd.getColumnName(i + 1);
			model.setColumnIdentifiers(colName);*/
			
			String id, nombre, edad, estatura, peso, notas;
			
			while (rs.next()) {
				id = rs.getString(1);
				nombre = rs.getString(2);
				edad = rs.getString(3);
				estatura = rs.getString(4);
				peso = rs.getString(5);
				notas = rs.getString(6);
				String[] row = { id, nombre, edad, estatura, peso, notas };
				model.addRow(row);
			}
			pst.close();
			cn.close();
			
		} catch (SQLException e) {
			System.err.println("Error al llenar la tabla." + e);
			JOptionPane.showMessageDialog(null, "Error al mostrar la información, verifique la conexión!");
		}
		
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();//???
				int fila_point = table.rowAtPoint(e.getPoint());
				int columna_point = 2;
				
				if(fila_point > -1) {
					user_update = (String)model.getValueAt(fila_point, columna_point);
					InformacionPaciente informacionPaciente = new InformacionPaciente();
					informacionPaciente.setVisible(true);
				}
			}
		});
	}
}


