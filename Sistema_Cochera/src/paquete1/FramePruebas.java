package paquete1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePruebas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Object[][] tabla;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePruebas frame = new FramePruebas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FramePruebas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 557, 369);
		contentPane.add(scrollPane);
		
		table = new JTable();
		tabla= new Object[][]{
				{"RENZO","TUCUMAN"}
		};
		table.setModel(new DefaultTableModel(
				tabla,
				new String[] {
						"NOMBRE","DIRECCION"
				}
		));
		scrollPane.setViewportView(table);
		tabla[0][0]="MARIANO";
		tabla[0][1]="SALTA";
		
		table.setModel(new DefaultTableModel(
				tabla,
				new String[] {
						"NOMBRE","DIRECCION"
				}
		));
		/*
		  table.setModel(new DefaultTableModel(
			new Object[][] {
				{"RENZO", "TUCUMAN"},
			},
			new String[] {
				"NOMBRE", "DIRECCION"
			}
		));
		*/
		
		
		
		/***  CREO BOTON Y SU EVENTO ***/
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(170, 380, 89, 23);
		contentPane.add(btnNewButton);
		
		
		/*
		Object[][] filas= {
				{"MARIANO","SALTA"}
		};
		table.setModel(new DefaultTableModel(
				filas,
				new String[] {
					"NOMBRE", "DIRECCION"
				}
			));
			*/
	}
}
