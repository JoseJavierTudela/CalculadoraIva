import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadorIva {

	private JFrame frmCalculadoraDeIva;
	private JTextField cajaPrecio;
	private JTextField cajaIva;
	private JTextField cajaDif;
	private JButton botonIva;
	private JButton botonReset;
	
	String contenidoCajaPrecio = "";
	String contenidoCajaIva ="";
	String contenidoCajaDif = "";
	float resultadoIva=0.0f;
	float resultadoDif=0.0f;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadorIva window = new CalculadorIva();
					window.frmCalculadoraDeIva.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculadorIva() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraDeIva = new JFrame();
		frmCalculadoraDeIva.setResizable(false);
		frmCalculadoraDeIva.setTitle("CALCULADORA DE IVA");
		frmCalculadoraDeIva.setBounds(100, 100, 450, 300);
		frmCalculadoraDeIva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadoraDeIva.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INTRODUCE EL PRECIO");
		lblNewLabel.setBounds(88, 12, 230, 45);
		frmCalculadoraDeIva.getContentPane().add(lblNewLabel);
		
		JLabel lblPrecioConIva = new JLabel("PRECIO CON IVA");
		lblPrecioConIva.setBounds(72, 121, 116, 45);
		frmCalculadoraDeIva.getContentPane().add(lblPrecioConIva);
		
		JLabel lblDiferencia = new JLabel("DIFERENCIA");
		lblDiferencia.setBounds(278, 121, 116, 45);
		frmCalculadoraDeIva.getContentPane().add(lblDiferencia);
		
		cajaPrecio = new JTextField();
		cajaPrecio.setFont(new Font("Dialog", Font.PLAIN, 40));
		cajaPrecio.setBounds(39, 46, 230, 63);
		frmCalculadoraDeIva.getContentPane().add(cajaPrecio);
		cajaPrecio.setColumns(10);
		
		cajaIva = new JTextField();
		cajaIva.setEditable(false);
		cajaIva.setFont(new Font("Dialog", Font.PLAIN, 30));
		cajaIva.setColumns(10);
		cajaIva.setBounds(39, 154, 159, 45);
		frmCalculadoraDeIva.getContentPane().add(cajaIva);
		
		cajaDif = new JTextField();
		cajaDif.setEditable(false);
		cajaDif.setFont(new Font("Dialog", Font.PLAIN, 30));
		cajaDif.setColumns(10);
		cajaDif.setBounds(235, 154, 159, 45);
		frmCalculadoraDeIva.getContentPane().add(cajaDif);
		
		botonIva = new JButton("IVA");
		botonIva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contenidoCajaPrecio = cajaPrecio.getText();
				if(contenidoCajaPrecio.equals("")) {
					cajaPrecio.setFont(new Font("Dialog", Font.BOLD, 12));
					cajaPrecio.setText("Error: Introduce una cantidad");
					cajaPrecio.setEditable(false);
				} else {
					
					
					resultadoIva= Float.parseFloat(contenidoCajaPrecio) + (Float.parseFloat(contenidoCajaPrecio) * 0.21f);
					contenidoCajaIva= Float.toString(resultadoIva);
					cajaIva.setText(contenidoCajaIva);
					
					resultadoDif= Float.parseFloat(contenidoCajaPrecio) * 0.21f;
					contenidoCajaDif= Float.toString(resultadoDif);
					cajaDif.setText(contenidoCajaDif);
					
				}
			}
		});
		botonIva.setFont(new Font("Dialog", Font.BOLD, 30));
		botonIva.setBounds(278, 46, 132, 63);
		frmCalculadoraDeIva.getContentPane().add(botonIva);
		
		botonReset = new JButton("Reset");
		botonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cajaPrecio.setText("");
				cajaIva.setText("");
				cajaDif.setText("");
				cajaPrecio.setFont(new Font("Dialog", Font.BOLD, 40));
				cajaPrecio.setEditable(true);
				
			}
		});
		botonReset.setBounds(171, 227, 98, 24);
		frmCalculadoraDeIva.getContentPane().add(botonReset);
	}
}
