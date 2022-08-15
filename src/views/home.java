package views;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame{

	private JFrame frmInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicio = new JFrame();
		frmInicio.setIconImage(Toolkit.getDefaultToolkit().getImage(home.class.getResource("/images/nutri_logo.png")));
		frmInicio.setResizable(false);
		frmInicio.setTitle("Inicio");
		frmInicio.setBounds(100, 100, 800, 600);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicio.getContentPane().setLayout(null);
		
		JButton btnIMC = new JButton("");
		btnIMC.setIcon(new ImageIcon(home.class.getResource("/images/IMC.png")));
		btnIMC.setBounds(599, 346, 128, 128);
		frmInicio.getContentPane().add(btnIMC);
		
		JLabel lblLMC = new JLabel("IMC");
		lblLMC.setForeground(Color.WHITE);
		lblLMC.setFont(new Font("Arial", Font.BOLD, 13));
		lblLMC.setBounds(640, 485, 43, 14);
		frmInicio.getContentPane().add(lblLMC);
		
		JLabel lblMainTitle = new JLabel("CONSULTORIO NUTRICIONAL");
		lblMainTitle.setForeground(Color.WHITE);
		lblMainTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblMainTitle.setBounds(46, 56, 274, 14);
		frmInicio.getContentPane().add(lblMainTitle);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(home.class.getResource("/images/nutri_logo.png")));
		lblTitle.setBounds(53, 98, 240, 195);
		frmInicio.getContentPane().add(lblTitle);
		
		ImageIcon mainLogo = new ImageIcon("src/images/nutri_logo.png");
		Icon mainIcono = new ImageIcon(mainLogo.getImage().getScaledInstance(lblTitle.getWidth(), lblTitle.getHeight(), Image.SCALE_DEFAULT));
		lblTitle.setIcon(mainIcono);
		this.repaint();
		
		JLabel lblNuevaCita = new JLabel("AGENDAR CITA");
		lblNuevaCita.setForeground(Color.WHITE);
		lblNuevaCita.setFont(new Font("Arial", Font.BOLD, 13));
		lblNuevaCita.setBounds(609, 272, 106, 14);
		frmInicio.getContentPane().add(lblNuevaCita);
		
		JLabel lblVisualizar = new JLabel("VISUALIZAR");
		lblVisualizar.setForeground(Color.WHITE);
		lblVisualizar.setFont(new Font("Arial", Font.BOLD, 13));
		lblVisualizar.setBounds(396, 485, 90, 14);
		frmInicio.getContentPane().add(lblVisualizar);
		
		JLabel lblAddPatient = new JLabel("AGREGAR PACIENTE");
		lblAddPatient.setForeground(Color.WHITE);
		lblAddPatient.setFont(new Font("Arial", Font.BOLD, 13));
		lblAddPatient.setBounds(372, 272, 150, 14);
		frmInicio.getContentPane().add(lblAddPatient);
		
		JButton btnAddCita = new JButton("");
		btnAddCita.setIcon(new ImageIcon(home.class.getResource("/images/Calendar_icon.png")));
		btnAddCita.setBounds(599, 133, 128, 128);
		frmInicio.getContentPane().add(btnAddCita);
		
		JButton btnView = new JButton("");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visualizar visualizar = new Visualizar();
				visualizar.setVisible(true);
			}
		});
		btnView.setIcon(new ImageIcon(home.class.getResource("/images/informationuser.png")));
		btnView.setBounds(374, 346, 128, 128);
		frmInicio.getContentPane().add(btnView);
		
		JButton btnAddUser = new JButton("");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPaciente addPaciente = new AddPaciente();
				addPaciente.setVisible(true);
			}
		});
		btnAddUser.setIcon(new ImageIcon(home.class.getResource("/images/addUser.png")));
		btnAddUser.setBounds(374, 133, 128, 128);
		frmInicio.getContentPane().add(btnAddUser);
				
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBackground(new Color(255, 255, 255));
		jLabel_Wallpaper.setBounds(0, 0, 794, 561);
		frmInicio.getContentPane().add(jLabel_Wallpaper);		
		
		//Cambiar imagen de fondo
		ImageIcon wallpaper = new ImageIcon("src/images/wallPaperPrincipal.jpg");
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();

	}
}
