import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminViewSearchOrDropdownMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewSearchOrDropdownMenu window = new AdminViewSearchOrDropdownMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminViewSearchOrDropdownMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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
				
				try {
					new AdminReadOnlyGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		btnBrowseFlights.setBounds(109, 173, 197, 35);
		frame.getContentPane().add(btnBrowseFlights);
	}

}
