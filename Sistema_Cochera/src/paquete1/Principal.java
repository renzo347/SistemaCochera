package paquete1;

import java.awt.EventQueue;


public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Login logIn=new Login(null,"Login",true);				
					logIn.setVisible(true);	
					Usuario usuario=logIn.getUsuario();
					VentanaPrin frame = new VentanaPrin(usuario);
					if(logIn.acceso==true) 
						frame.setVisible(true);								
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
