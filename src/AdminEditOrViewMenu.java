import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AdminEditOrViewMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEditOrViewMenu window = new AdminEditOrViewMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminEditOrViewMenu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Admin - Edit or View Reservations");
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		//File directory = new File("Z:\\customers");
		File directory = new File("customers/", "");
		File[] list = directory.listFiles();
		
		JButton btnNewButton = new JButton("Edit flight information.");
		btnNewButton.setBounds(56, 80, 323, 35);
		
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new AdminEditCancelSearchOrDropdownMenu();
			}
		});
		
		frame.getContentPane().add(btnNewButton);
		
		JButton btnViewReservations = new JButton("View reservations");
		btnViewReservations.setBounds(56, 136, 323, 35);
		
		btnViewReservations.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String printString = "";
				
				//System.out.println("All Customer Reservations: ");
				for (int i = 0; i < list.length; i++) {
					if (list[i].isFile()) {
						printString = printString + list[i].getName() + "<br>";
						//System.out.println(list[i].getName());
					}
					String fileName = list[i].getPath();
					BufferedReader br;
					try {
						br = new BufferedReader(new FileReader(fileName));
						// getting file contents
						String line = null;
						while ((line = br.readLine()) != null) {
							printString = printString + line + "<br>";
							//System.out.println(line);
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					
				}
				
				System.out.println("printString");
				System.out.println(printString);
				printString = printString.replaceAll(".txt", "");
				
				new CustomerReservationsList(printString);
			}
		});
		
		frame.getContentPane().add(btnViewReservations);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome, Admin.");
		lblWelcomeAdmin.setBounds(128, 33, 172, 26);
		frame.getContentPane().add(lblWelcomeAdmin);
	}
}
