 package paquete1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrin extends JFrame {

	private JPanel contentPane;
	private Usuario usuario;
	private JTextField textField_Patente;
	private JTextField textField_Nombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox chckbxAuto;
	private JCheckBox chckbxCamioneta;
	private JCheckBox chckbxMoto;
	private JCheckBox chckbxTrafic;
	private JLabel lblAvisos;
	private JTextField textField_1;
	private JTextField textField_Patente1;
	private JLabel lblPatente;
	private JLabel lblNombre;
	private JLabel lblTiempoCochera;
	

/*	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrin frame = new VentanaPrin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    */
	/**
	 * Create the frame.
	 */
	public VentanaPrin(Usuario user) {
		Color color=UIManager.getColor("TabbedPane.selected");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 648, 27);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmExportarCaja = new JMenuItem("Exportar Caja");
		mnArchivo.add(mntmExportarCaja);
		
		JMenuItem mntmExpMov = new JMenuItem("Exportar movimientos");
		mnArchivo.add(mntmExpMov);
		
		JMenuItem mntmBorrarBD = new JMenuItem("Borrar base de datos");
		mnArchivo.add(mntmBorrarBD);
		
		JMenuItem mntmImportarBD = new JMenuItem("Importar base de datos");
		mnArchivo.add(mntmImportarBD);
		
		JMenu mnNewMenu = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Tafifas...");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios...");
		mnNewMenu.add(mntmUsuarios);
		
		JMenu mnNewMenu_1 = new JMenu("Caja");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnNewMenu_1.add(mntmCerrar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ver parcial");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnLogeo = new JMenu("Logeo");
		menuBar.add(mnLogeo);
		
		JMenuItem mntmTerminarTurno = new JMenuItem("Terminar turno");
		mnLogeo.add(mntmTerminarTurno);
		
		JPanel panel_inferior = new JPanel();
		panel_inferior.setBackground(Color.LIGHT_GRAY);
		panel_inferior.setForeground(Color.GRAY);
		panel_inferior.setBorder(new LineBorder(Color.GRAY, 2, true));
		panel_inferior.setBounds(10, 399, 628, 62);
		contentPane.add(panel_inferior);
		panel_inferior.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario: "+user.getNombre());
		lblUsuario.setBounds(443, 37, 175, 14);
		panel_inferior.add(lblUsuario);
		
		JLabel lblNewLabel = new JLabel("Caja Inicial:");
		lblNewLabel.setBounds(10, 11, 114, 14);
		panel_inferior.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Caja Parcial");
		lblNewLabel_1.setBounds(10, 37, 114, 14);
		panel_inferior.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 30, 648, 358);
		contentPane.add(tabbedPane);
		
		JPanel ingreso = new JPanel();
		ingreso.setBackground(color);
		tabbedPane.addTab("Ingreso", null, ingreso, null);
		
		JLabel lblNewLabel_2 = new JLabel("Patente");
		lblNewLabel_2.setBounds(22, 28, 65, 31);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textField_Patente = new JTextField();
		textField_Patente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblAvisos.setText("");
			}
		});
		textField_Patente.setBounds(102, 28, 101, 27);
		textField_Patente.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_Patente.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre");
		lblNewLabel_2_1.setBounds(262, 28, 73, 31);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(341, 28, 277, 27);
		textField_Nombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_Nombre.setColumns(10);
		
		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnNewButton.setBounds(499, 288, 119, 31);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		ingreso.setLayout(null);
		ingreso.add(lblNewLabel_2);
		ingreso.add(textField_Patente);
		ingreso.add(lblNewLabel_2_1);
		ingreso.add(textField_Nombre);
		ingreso.add(btnNewButton);
		
		chckbxAuto = new JCheckBox("AUTO");
		buttonGroup.add(chckbxAuto);
		chckbxAuto.setBackground(color);
		chckbxAuto.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxAuto.setBounds(32, 73, 73, 38);
		ingreso.add(chckbxAuto);
		
		chckbxCamioneta = new JCheckBox("CAMIONETA");
		buttonGroup.add(chckbxCamioneta);
		chckbxCamioneta.setBackground(color);
		chckbxCamioneta.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxCamioneta.setBounds(179, 73, 124, 38);
		ingreso.add(chckbxCamioneta);
		
		chckbxMoto = new JCheckBox("MOTO");
		buttonGroup.add(chckbxMoto);
		chckbxMoto.setBackground(color);
		chckbxMoto.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxMoto.setBounds(354, 73, 88, 38);
		ingreso.add(chckbxMoto);
		
		chckbxTrafic = new JCheckBox("TRAFIC");
		buttonGroup.add(chckbxTrafic);
		chckbxTrafic.setBackground(color);
		chckbxTrafic.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxTrafic.setBounds(485, 73, 133, 38);
		ingreso.add(chckbxTrafic);
		
		lblAvisos = new JLabel("");
		lblAvisos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvisos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAvisos.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		lblAvisos.setBounds(27, 137, 591, 126);
		ingreso.add(lblAvisos);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Egreso", null, panel, null);
		panel.setBackground(color);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Patente");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(22, 30, 65, 31);
		panel.add(lblNewLabel_2_2);
		
		textField_Patente1 = new JTextField();
		textField_Patente1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					buscar();
				}
			}
		});
		textField_Patente1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_Patente1.setColumns(10);
		textField_Patente1.setBounds(102, 30, 101, 27);
		panel.add(textField_Patente1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(341, 30, 277, 27);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Nombre");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(262, 30, 73, 31);
		panel.add(lblNewLabel_2_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.BLACK, 2));
		panel_3.setBounds(10, 88, 623, 231);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Patente:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 11, 59, 30);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nombre: ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(301, 11, 59, 30);
		panel_3.add(lblNewLabel_3_1);
		
		lblPatente = new JLabel("");
		lblPatente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPatente.setBounds(71, 11, 152, 30);
		panel_3.add(lblPatente);
		
		lblNombre = new JLabel("");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(362, 11, 251, 30);
		panel_3.add(lblNombre);
		
		JLabel lblNewLabel_3_3 = new JLabel("Tiempo en cochera:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(10, 62, 129, 30);
		panel_3.add(lblNewLabel_3_3);
		
		lblTiempoCochera = new JLabel("");
		lblTiempoCochera.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTiempoCochera.setBounds(149, 62, 343, 30);
		panel_3.add(lblTiempoCochera);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("PAGAR:");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_3_1.setBounds(149, 143, 65, 30);
		panel_3.add(lblNewLabel_3_3_1);
		
		JLabel lblPagar = new JLabel("");
		lblPagar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPagar.setBounds(218, 143, 129, 30);
		panel_3.add(lblPagar);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Autos en cochera", null, panel_1, null);
		panel_1.setBackground(color);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(color);
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setPreferredSize(new Dimension(105, 66));
		chckbxNewCheckBox_1.setBounds(84, 104, 97, 23);
		panel_2.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		chckbxNewCheckBox_2.setBounds(251, 104, 97, 23);
		panel_2.add(chckbxNewCheckBox_2);
	}

	protected void buscar() {
		Conexion conexion=new Conexion();
		Connection con=conexion.conexion();
		String placa, propietario;
		Date dateSalida=new Date(new java.util.Date().getTime());
		Date dateEntrada=null;
		String sql="SELECT placa, propietario, horaentrada FROM vehiculos WHERE placa='"+textField_Patente1.getText()+"'";
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				lblPatente.setText(rs.getString(1));
				lblNombre.setText(rs.getString(2));
				dateEntrada=new Date(rs.getDate(3).getTime());
				System.out.println(dateEntrada.getTime());
				System.out.println(dateSalida.getTime());
			}else {
				lblPatente.setText("NO ENCONTRADO");
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long minutos=dateSalida.getTime()-dateEntrada.getTime();
		minutos=minutos/60000;
		lblTiempoCochera.setText(Long.toString(minutos));
}
	protected void ingresar() {
		// TODO Auto-generated method stub
		Conexion conexion=new Conexion();
		String tipo="";
		String patente=textField_Patente.getText().toUpperCase();
		String propietario=textField_Nombre.getText().toUpperCase();
		String estado="Disponible";
		Date date=new Date(new java.util.Date().getTime());
		SimpleDateFormat formato=new SimpleDateFormat("YYYY-MM-dd HH:mm");
		String horaEntrada=formato.format(date);
		
		
		
		if(chckbxAuto.isSelected()) tipo="AUTO";
		if(chckbxMoto.isSelected()) tipo="MOTO";
		if(chckbxCamioneta.isSelected()) tipo="CAMIONETA";
		if(chckbxTrafic.isSelected()) tipo="TRAFIC";
		
		if(tipo.isEmpty() || patente.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Faltan datos!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else {
			String sql="INSERT INTO vehiculos (placa, propietario, tipovehiculo, horaentrada,estado) VALUES ('"+patente+"','"+propietario+"','"+tipo+"','"+horaEntrada+"','Disponible')";        
			Connection con= conexion.conexion();
		try {
			Statement stm=con.createStatement();
			stm.executeUpdate(sql);
			textField_Patente.setText("");
			textField_Nombre.setText("");	
			buttonGroup.clearSelection();	
			lblAvisos.setText("SE GUARDÓ CORRECTAMENTE");	
			stm.close();
		} catch (SQLException e) {
			lblAvisos.setText("ERROR AL GUARDAR");
		} 
		}	
	}
}
