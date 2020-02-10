import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Airline {

	private JFrame frmAirline;
	private String role = "Customer"; // role can be "Customer" or "Administrator"
	private static final LayoutManager H = new GridLayout(1,0);
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		File file = new File("C:\\Users\\Max\\Desktop\\airlinedata.txt");
		BufferedWriter writer = new BufferedWriter (new FileWriter("C:\\Users\\Max\\Desktop\\airlinedata.txt"));
		
		try {
			 br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Airline window = new Airline();
					window.frmAirline.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}
	
	public void writeToAirlineData(String flight) {
		
	}

	/**
	 * Create the application.
	 */
	public Airline() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAirline = new JFrame();
		frmAirline.setTitle("Airline");
		frmAirline.setBounds(100, 100, 450, 300);
		frmAirline.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAirline.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(205, 0, 74, 229);
		frmAirline.getContentPane().add(label);
		
		JButton btnMakeANew = new JButton("Admin");
		btnMakeANew.setBounds(0, 0, 205, 229);
		frmAirline.getContentPane().add(btnMakeANew);
		
		JButton btnViewFlights = new JButton("Customer");
		btnViewFlights.setBounds(206, 0, 218, 229);
		frmAirline.getContentPane().add(btnViewFlights);
			
	}
}
