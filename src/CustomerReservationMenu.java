import java.awt.EventQueue;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;


//12/4/19
public class CustomerReservationMenu {

	private JFrame frame;
	private ArrayList<Flight> reservedFlights = new ArrayList<Flight>(); 

	public static void main(String[] args) {
		  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerReservationMenu window = new CustomerReservationMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerReservationMenu() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		// GUI setup
		frame = new JFrame();
		frame.setTitle("Customer Reservation Menu");
		frame.setVisible(true);
		frame.setBounds(50, 50, 791, 671);
		frame.getContentPane().setLayout(null);
		String currentDate = Data.getDate();
				
		String airlineString = "";
		String st;
		
		File file = new File("Airlines_Info.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
			    airlineString = airlineString.concat(st + "\n");
			 }
			
			airlineString = airlineString.replaceAll("[ \t]", " ").substring(0, airlineString.length());
			airlineString = airlineString.replaceAll("Airline 1", "");
			airlineString = airlineString.replaceAll("Airline 2", "");
			airlineString = airlineString.replaceAll("Airline 3", "");
			airlineString = airlineString.replaceAll("\n" + "\n", "");
			airlineString = airlineString.replaceAll("/", " ");
			
			
			StringTokenizer myAirlineStringTokenizer = new StringTokenizer(airlineString, "\n");
			List<String> airlineTokens = new ArrayList<String>();
			
			while (myAirlineStringTokenizer.hasMoreTokens()) {
				airlineTokens.add(myAirlineStringTokenizer.nextToken());
			}
			
			List<Flight> flights = new ArrayList<Flight>();
			
			
			for (int i = 0; i < airlineTokens.size(); i++) {
				String flightDataString = airlineTokens.get(i);
				StringTokenizer myFlightDataStringTokenizer = new StringTokenizer(flightDataString, " ");
				List<String> flightDataTokens = new ArrayList<String>();
				while (myFlightDataStringTokenizer.hasMoreTokens()) {
					flightDataTokens.add(myFlightDataStringTokenizer.nextToken());
				}
				
				Flight thisFlight =  new Flight(Integer.parseInt(flightDataTokens.get(0)),
						flightDataTokens.get(1),
						flightDataTokens.get(2),
						flightDataTokens.get(3),
						flightDataTokens.get(4),
						//flightDataTokens.get(5),
						Data.getDate(),
						Integer.parseInt(flightDataTokens.get(6)),
						Integer.parseInt(flightDataTokens.get(7)),
						Integer.parseInt(flightDataTokens.get(8)),
						Integer.parseInt(flightDataTokens.get(9))
						);
				
				flights.add(thisFlight);	
			}
			
			int currentAirlineNo = 1;
			if (Data.currentAirline == "airline1") currentAirlineNo = 1; else
			if (Data.currentAirline == "airline2") currentAirlineNo = 2; else
			if (Data.currentAirline == "airline3") currentAirlineNo = 3;
			
			int y = 21;
			for (int i = 0; i < flights.size(); i++) {
				
				
				if (flights.get(i).airlineNo == currentAirlineNo) {
				
					///
					//
					//
				JLabel lblNewLabel = new JLabel(flights.get(i).toString());
				///
				//
				///
				
				lblNewLabel.setBounds(0, 21+y, 500, 26);
				frame.getContentPane().add(lblNewLabel);
				
				
				JButton reserveButton = new JButton("Reserve");
				reserveButton.setBounds(350+25, 21+y, 100, 26);
				frame.getContentPane().add(reserveButton);
				
				JLabel reservedLbl = new JLabel("Flight Reserved!");
				reservedLbl.setBounds(350+25, 21+y, 100, 26);
				frame.getContentPane().add(reservedLbl);
				reservedLbl.setVisible(false);
				
				Flight myFlight = flights.get(i);	
				// myFlight.date = currentDate;
				reserveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (myFlight.capacity <= myFlight.reservations) {
							JOptionPane.showMessageDialog(null, "The flight you've chosen is full! Please select another flight.", "Full Flight",
							JOptionPane.ERROR_MESSAGE);
							
						}
						else {
							
						customerReserveFlight(myFlight, Data.currentCustomer);
						reservedFlights.add(myFlight);
						reserveButton.setVisible(false);
						reservedLbl.setVisible(true);
						for (int i = 0; i < Data.currentCustomerList.size(); i++) {
							System.out.println(Data.currentCustomerList.get(i));
						}
					}
				}
				});
				
				}
				y = y+21;
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		
		
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(284, 551, 178, 35);
		frame.getContentPane().add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveChanges();
				Data.currentCustomerList.clear();
				frame.dispose();
				try {
					initialize();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnViewFlights = new JButton("View Booked Flights...");
		btnViewFlights.setBounds(284,501,178,35);
		frame.getContentPane().add(btnViewFlights);
		btnViewFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				try {
					new CustomerViewBookedFlights();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}

	private void customerReserveFlight(Flight inputFlight, String customer) {

	if (!Data.currentCustomerList.contains(inputFlight)) {
		Data.currentCustomerList.add(inputFlight);
	}
	//	if (Data.currentCustomer == "customer1" && !Data.customer1List.contains(inputFlight)) 
	//		Data.customer1List.add(inputFlight); else
	//	if (Data.currentCustomer == "customer2" && !Data.customer2List.contains(inputFlight)) 
	//		Data.customer2List.add(inputFlight); else
	//	if (Data.currentCustomer == "customer3" && !Data.customer3List.contains(inputFlight)) 
	//		Data.customer3List.add(inputFlight);
		
	}
	
	private void saveChanges() {
		
		// Checking for Customer
		List<Flight> currentCustomerList = new ArrayList<Flight>();
		
		currentCustomerList = Data.currentCustomerList;
		//if (Data.currentCustomer == "customer1") currentCustomerList = Data.customer1List; else
		//if (Data.currentCustomer == "customer2") currentCustomerList = Data.customer2List; else
		//if (Data.currentCustomer == "customer3") currentCustomerList = Data.customer3List;
		
		String reservationsString = "";
		File file;
		String currentCustomer = Data.getCustomer();
		
		file = new File("customers/", currentCustomer + ".txt");

		//if (Data.currentCustomer == "customer1") file = new File("Customer1Reservations.txt"); else
		//if (Data.currentCustomer == "customer2") file = new File("Customer2Reservations.txt"); else
		//if (Data.currentCustomer == "customer3") file = new File("Customer3Reservations.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String stringRead;
			while((stringRead = br.readLine()) != null) {
				reservationsString = reservationsString + stringRead + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String str = "";
		for (int i = 0; i < currentCustomerList.size(); i++) {
			if (!reservationsString.contains(currentCustomerList.get(i).toString())) {
				//str = str.replaceAll("/", " ");
				str = str.replaceAll(",", "");
				str = str + currentCustomerList.get(i).toString()+"\n";
				//str = str.replaceAll("/", " ");
				str = str.replaceAll(",", "");
			}
		}
		
		writeToCustomerReservations(file, str);
		refreshAirlinesInfo();
		
		reservedFlights = new ArrayList<Flight>(); 

	}
	
	private ArrayList<Flight> getFlightsFromFile(File inputFile) {
		ArrayList<Flight >returnList = new ArrayList<Flight>();
		
		String airlineString = "";
		
		//File file = new File("Airlines_Info.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
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
			airlineString = airlineString.replaceAll("/", " ");
			
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
			List<String> flightDataTokens = new ArrayList<String>();
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
	
	private void refreshAirlinesInfo() {
		
		ArrayList<Flight> flightsList = getFlightsFromFile(new File("Airlines_Info.txt"));
		
		for (int i = 0; i < flightsList.size(); i++) {
			for (int j = 0; j < reservedFlights.size(); j++) {
				if (reservedFlights.get(j).Equals(flightsList.get(i))) {
					flightsList.get(i).reservations = flightsList.get(i).reservations + 1;
				}
			}
		}

		String printString = "";
		for (int i = 0; i < flightsList.size(); i++) {	
			printString = printString + flightsList.get(i).toString() + "\n";
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Airlines_Info.txt"));
			writer.write(printString);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	private void writeToCustomerReservations(File inputFile, String inputString) {
		getFlightsFromFile(inputFile);
	
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile, true));
			writer.append("" + inputString);// This works, it writes to a file
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
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
