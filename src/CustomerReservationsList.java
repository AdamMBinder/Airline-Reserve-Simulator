import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class CustomerReservationsList {

	private JFrame frame = new JFrame();
	private ArrayList<String> customerReservations;

	public CustomerReservationsList(Flight inputFlight) throws IOException {
		initialize();
		if (Data.customerReservationsMap.get(inputFlight) == null) {
			JLabel lblEmpty = new JLabel("Empty");
			frame.getContentPane().add(lblEmpty, BorderLayout.CENTER);
			return;
		}
		else {
			customerReservations = Data.customerReservationsMap.get(inputFlight);
			for (int i = 0; i < customerReservations.size(); i++) {
				System.out.println(customerReservations.get(i));
			}
		}
	} 
	
	public CustomerReservationsList(String inputString) {
		initialize();
		JLabel lblReservations = new JLabel("<html>" + inputString + "</html>");
		frame.getContentPane().add(lblReservations, BorderLayout.CENTER);
		lblReservations.setVisible(true);
		//frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerReservationsList window = new CustomerReservationsList();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	public CustomerReservationsList() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Customer Reservations List");
		frame.setVisible(true);
		frame.setBounds(100, 100, 750, 600);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
