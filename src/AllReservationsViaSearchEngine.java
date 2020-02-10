import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AllReservationsViaSearchEngine extends JFrame {
	
	JFrame frame;
	
	public AllReservationsViaSearchEngine() {
		
		frame = new JFrame();
		frame.setTitle("Admin - Edit or View Reservations");
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		
		JButton btnViewReservations = new JButton("View reservations");
		btnViewReservations.setBounds(56, 136, 323, 35);
		
		File directory = new File("customers/", "");
		File[] list = directory.listFiles();
		
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
	}
}
