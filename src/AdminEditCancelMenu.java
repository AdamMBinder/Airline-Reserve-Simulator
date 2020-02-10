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
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//12/3/19 6:17 PM

public class AdminEditCancelMenu {
	
	ArrayList<Flight> cancelList = new ArrayList<Flight>();
	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEditCancelMenu window = new AdminEditCancelMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminEditCancelMenu() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		
		// GUI stuff
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(225, 100, 953, 778);
		frame.getContentPane().setLayout(null);
		
		// Parsing Stuff
		
		String airlineString = "";
		
		File file = new File("Airlines_Info.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			airlineString = "";

			while ((st = br.readLine()) != null) {
			    airlineString = airlineString.concat(st + "\n");
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
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("Airlines_Info.txt"));
			writer.write(airlineString);
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		ArrayList<String> airlineStringTokens = new ArrayList<String>();
		StringTokenizer airlineStringTokenizer = new StringTokenizer(airlineString, "\n");
		while(airlineStringTokenizer.hasMoreTokens()) {
			airlineStringTokens.add(airlineStringTokenizer.nextToken());
		}
		
 		
		int y = -100;
		for (int i = 0; i < airlineStringTokens.size(); i++) {
			JLabel lblAirlineInfo = new JLabel(airlineStringTokens.get(i));
			lblAirlineInfo.setBounds(0, y, 424, 229);
			frame.getContentPane().add(lblAirlineInfo);
			y = y+24;
			
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
					Integer.parseInt(flightDataTokens.get(6)),
					Integer.parseInt(flightDataTokens.get(7)),
					Integer.parseInt(flightDataTokens.get(8)),
					Integer.parseInt(flightDataTokens.get(9))
					);
			
			JButton myNewButton = new JButton("Edit");
			myNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						new AdminEditFlightMenu(thisFlight);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			myNewButton.setBounds(340, y+80, 90, 23);
			frame.getContentPane().add(myNewButton);
			
			JButton myNewButton2 = new JButton("Cancel");
			myNewButton2.setBounds(340+90, y+80, 90, 23);
			myNewButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					removeFlight(thisFlight);
				}
			});
				
			frame.getContentPane().add(myNewButton2);			
			
			JButton btnSaveChanges = new JButton("Save Changes");
			btnSaveChanges.setBounds(184, 700, 178, 35);
			btnSaveChanges.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					saveChanges();
				}
			});
			frame.getContentPane().add(btnSaveChanges);
			
			JButton btnAddNewFlight = new JButton("Make New Flight");
			btnAddNewFlight.setBounds(184, 650, 178, 35);
			btnAddNewFlight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						new AdminEditFlightMenu(new Flight());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			frame.getContentPane().add(btnAddNewFlight);
			
		}
	}
	
	private void removeFlight(Flight thisFlight) {
		System.out.println("Removing: " + thisFlight.toString());
		Data.currentCustomerList.remove(thisFlight);
		//if (Data.currentCustomer == "customer1") Data.customer1List.remove(thisFlight); else
		//if (Data.currentCustomer == "customer2") Data.customer2List.remove(thisFlight); else
		//if (Data.currentCustomer == "customer3") Data.customer3List.remove(thisFlight);
		Data.customerReservationsMap.remove(thisFlight);	
		cancelList.add(thisFlight);
	}
	
	private void saveChanges() {
		String airlineString = "";
		
		File file = new File("Airlines_Info.txt");
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
			airlineString = airlineString.replaceAll("Airline 1", "");
			airlineString = airlineString.replaceAll("Airline 2", "");
			airlineString = airlineString.replaceAll("Airline 3", "");
			airlineString = airlineString.replaceAll("\n" + "\n", "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String writeToFileString = ""; 
		for (Map.Entry<Integer, Flight> entry : Data.allFlightsMap.entrySet()) {
			
			String checkString = entry.getValue().toString().replaceAll(",", "");
			checkString = checkString.replaceAll("/", " ");
			String tempAirlineString = airlineString.replaceAll("  ", " ");
			tempAirlineString = tempAirlineString.replaceAll("/", " ");

			if (!tempAirlineString.replaceAll("\t", "").contains(checkString)) {
				writeToFileString = writeToFileString + entry.getValue().toString();
			}	
			writeToFileString = writeToFileString.replaceAll(", ", " ");
			writeToFileString = writeToFileString.replaceAll("\t", " ");
		}
		
		
		String printString;

	    BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("Airlines_Info.txt", true));
			writer.append(writeToFileString);
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int i = 0; i < cancelList.size(); i++) {
			System.out.println(cancelList.get(i).toString().replaceAll(",", ""));
			System.out.println(airlineString.substring(0,53));
			
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
				airlineString = airlineString.replaceAll("Airline 1", "");
				airlineString = airlineString.replaceAll("Airline 2", "");
				airlineString = airlineString.replaceAll("Airline 3", "");
				airlineString = airlineString.replaceAll("\n" + "\n", "");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			if (airlineString.contains(cancelList.get(i).toString().replaceAll(",", ""))) 
				System.out.println("airline string contains cancelled flight");
			
			printString = airlineString.replace(cancelList.get(i).toString().replaceAll(",", "")+"\n", "");
			System.out.println("printString: ");
			System.out.println(printString);
			
			try {
				writer = new BufferedWriter(new FileWriter("Airlines_Info.txt"));
				writer.write(printString);
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				
		}
		
		try {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
