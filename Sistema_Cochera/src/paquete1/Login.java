package paquete1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.sql.Date;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JPasswordField passwordField;
	public boolean acceso=false;
	private Usuario usuario=new Usuario();
	
	
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public Login(JFrame frame,String titulo, boolean b) {
		super(frame,titulo,b);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Login");
		setBounds(100, 100, 280, 172);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUsuario.setBounds(10, 11, 78, 26);
			contentPanel.add(lblUsuario);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblContrasea.setBounds(10, 60, 98, 26);
			contentPanel.add(lblContrasea);
		}
		{
			textUsuario = new JTextField();
			textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textUsuario.setBounds(108, 12, 146, 24);
			contentPanel.add(textUsuario);
			textUsuario.setColumns(10);
		}
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(108, 60, 146, 24);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registrarUsuario();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	protected void registrarUsuario() {
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Conexion conexion=new Conexion();
		String user=textUsuario.getText();
		String pass=new String(passwordField.getPassword());
		try {
			con=conexion.conexion();
			ps=con.prepareStatement("SELECT usuario FROM usuarios WHERE usuario=? AND contrasena=?");
			ps.setString(1, user);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			if(rs.next()) {
				acceso=true;
				usuario.cambiarUsuario(rs.getString(1));
				
				// grabo horario de logeo bd
				ps=con.prepareStatement("INSERT INTO login(usuario,logeo) VALUES(?,?)");
				ps.setString(1, usuario.getNombre());			
				Date date=new Date();
				Timestamp d=new Timestamp(date.getTime());	
				ps.setTimestamp(2, d);
				ps.executeUpdate();
							
				setVisible(false);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
				textUsuario.setText("");
				passwordField.setText("");
			}	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	private void grabarIngreso() {
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			
	}
	*/
	public Usuario getUsuario() {
		return usuario;
	}
}

