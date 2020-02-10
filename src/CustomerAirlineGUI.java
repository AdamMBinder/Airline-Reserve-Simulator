import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class CustomerAirlineGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerAirlineGUI window = new CustomerAirlineGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerAirlineGUI() {
		initialize();
	}

	private void initialize() {
		
		//setVisible(true);
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(81, 105, 92, 26);
		frame.getContentPane().add(label);
		
		JLabel lblSelectAFlight = new JLabel("Or browse the flights of each airline using our dropdown menu: ");
		lblSelectAFlight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectAFlight.setBounds(21, 77, 382, 43);
		frame.getContentPane().add(lblSelectAFlight);
		
		JButton btnNewButton = new JButton("Search for a flight using our search engine...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new SearchEngineWindow();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(21, 21, 382, 35);
		frame.getContentPane().add(btnNewButton);
		
		String s1[] = {"Airline 1" , "Airline 2", "Airline 3"};
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setBounds(31, 141, 372, 32);
		frame.getContentPane().add(comboBox);
		
		JButton btnBrowseFlights = new JButton("Browse flights...");
		
		btnBrowseFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data.currentAirline = comboBox.getSelectedItem().toString();
				System.out.println(Data.currentAirline);
			
				JLabel lblAirline = new JLabel("Airline");
				frame.getContentPane().add(lblAirline, BorderLayout.NORTH);
				lblAirline.setText(Data.currentAirline);
				
				if (comboBox.getSelectedItem() == "Airline 1") Data.currentAirline = "airline1"; else
				if (comboBox.getSelectedItem() == "Airline 2") Data.currentAirline = "airline2"; else
				if (comboBox.getSelectedItem() == "Airline 3") Data.currentAirline = "airline3";	
				
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			
					try {
						new CustomerReservationMenu();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});

		btnBrowseFlights.setBounds(109, 173, 197, 35);
		frame.getContentPane().add(btnBrowseFlights);
		
		frame.setVisible(true);
		
	}
}
