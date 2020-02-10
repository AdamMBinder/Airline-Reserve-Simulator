import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

//12/4/19

public class CustomerViewBookedFlights {

	private JFrame frame;
	private ArrayList<Flight> cancelledFlights = new ArrayList<Flight>();
	
	public CustomerViewBookedFlights() throws IOException {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerViewBookedFlights window = new CustomerViewBookedFlights();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("View Booked Flights");
		frame.setBounds(100, 100, 550, 300);
		frame.setVisible(true);

		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booked Flights");
		lblNewLabel.setBounds(150, 0, 160, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(169, 173, 200, 35);
		frame.getContentPane().add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				writeToCustomerReservations();
				Data.currentCustomerList.clear();
				
			}
		});
		
		ArrayList<Flight> currentList = new ArrayList<Flight>();	
		
		
		currentList = getFlightsFromCustomerReservations();
		
		int y = 20;
		for (int i = 0; i < currentList.size(); i++) {
			Flight thisFlight = currentList.get(i);
			//System.out.println(currentList.get(i));
			JLabel lblFlight = new JLabel(currentList.get(i).toString());
			lblFlight.setBounds(0, y, 400, 45);
			frame.getContentPane().add(lblFlight);
			y = y+20;
			
			JButton cancelButton = new JButton("Cancel");
			
			JLabel cancelLbl = new JLabel("Flight Reservation Cancelled!");
			cancelButton.setBounds(350+25, lblFlight.getY()+10, 150, 26);
			frame.getContentPane().add(cancelLbl);
			cancelLbl.setVisible(false);
			
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cancelledFlights.add(thisFlight); 
					System.out.println("\nCancelledFlights");
					for (int i = 0; i < cancelledFlights.size(); i++) {
						System.out.println(cancelledFlights.get(i));
						cancelButton.setVisible(false);
						cancelLbl.setVisible(true);
					}
				}
			});
			cancelButton.setBounds(350+25, lblFlight.getY()+10, 100, 26);
			frame.getContentPane().add(cancelButton);
			cancelButton.setVisible(true);
		}
	}
	String currentCustomer = Data.getCustomer();
	
	private ArrayList<Flight> getFlightsFromCustomerReservations() {
		ArrayList<Flight>returnList = new ArrayList<Flight>();
		
		String airlineString = "";
		
		File file = new File("customers/", currentCustomer + ".txt");
		
		// if (Data.currentCustomer == "customer1") file = new File("Customer1Reservations.txt"); else  
		// if (Data.currentCustomer == "customer2") file = new File("Customer2Reservations.txt"); else
		// if (Data.currentCustomer == "customer3") file = new File("Customer3Reservations.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			airlineString = "";

			try { 
				while ((st = br.readLine()) != null) {
				    airlineString = airlineString.concat(st + "\n");
				 }
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			airlineString = airlineString.replaceAll("[ \t]", " ").substring(0, airlineString.length());
			airlineString = airlineString.replaceAll("  ", " ");
			airlineString = airlineString.replaceAll("Airline 1", "");
			airlineString = airlineString.replaceAll("Airline 2", "");
			airlineString = airlineString.replaceAll("Airline 3", "");
			airlineString = airlineString.replaceAll("\n" + "\n", "");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<String> airlineStringTokens = new ArrayList<String>();
		StringTokenizer airlineStringTokenizer = new StringTokenizer(airlineString, "\n");
		while(airlineStringTokenizer.hasMoreTokens()) {
			airlineStringTokens.add(airlineStringTokenizer.nextToken());
		}
		
		for (int i = 0; i < airlineStringTokens.size(); i++) {
			
			String flightDataString = airlineStringTokens.get(i);
			StringTokenizer myFlightDataStringTokenizer = new StringTokenizer(flightDataString, " ");
			ArrayList<String> flightDataTokens = new ArrayList<String>();
			while (myFlightDataStringTokenizer.hasMoreTokens()) {
				flightDataTokens.add(myFlightDataStringTokenizer.nextToken());
			}
			
			Flight thisFlight =  new Flight(Integer.parseInt(flightDataTokens.get(0)),
					flightDataTokens.get(1),
					flightDataTokens.get(2),
					flightDataTokens.get(3),
					flightDataTokens.get(4),
					flightDataTokens.get(5),
					//Data.getDate(),
					Integer.parseInt(flightDataTokens.get(6)),
					Integer.parseInt(flightDataTokens.get(7)),
					Integer.parseInt(flightDataTokens.get(8)),
					Integer.parseInt(flightDataTokens.get(9))
					);
			
			returnList.add(thisFlight);
		}
		return returnList;
		
	}
	
	
	private void writeToCustomerReservations() {
	
		ArrayList<Flight> currentCustomerList = new ArrayList<Flight>();
		
		String reservationsString = "";
		File file = new File("customers/", currentCustomer + ".txt");
		
		currentCustomerList = (ArrayList<Flight>) Data.currentCustomerList;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String stringRead;
			while((stringRead = br.readLine()) != null) {
				reservationsString = reservationsString +  stringRead + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String str = "";
		for (int i = 0; i < currentCustomerList.size(); i++) {
			if (!reservationsString.contains(currentCustomerList.get(i).toString())) {
				//TODO: uncomment this
				str = str.replaceAll("/", " ");
				str = str.replaceAll(",", "");
				str = str + currentCustomerList.get(i).toString()+"\n";
				str = str.replaceAll("/", " ");
				str = str.replaceAll(",", "");
			}
		}
			
		for (int i = 0; i < cancelledFlights.size(); i++) {
			reservationsString = reservationsString.replace(cancelledFlights.get(i).toString()+"\n", "");
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(reservationsString);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		frame.dispose();
		initialize();

	}
	
	//private void removeCancelledFlights
	
	private String readFromFile(File inputFile) {
		String returnString = "";
		File file = inputFile;
		String st = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				    returnString = returnString.concat(st);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnString;
	}
	
}
