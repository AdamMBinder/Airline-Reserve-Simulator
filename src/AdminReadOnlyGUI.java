import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AdminReadOnlyGUI {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminReadOnlyGUI window = new AdminReadOnlyGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public AdminReadOnlyGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 553, 378);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String airlineString = "";
		
		File file = new File("Airlines_Info.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			airlineString = "";
			
			while ((st = br.readLine()) != null) {
			    airlineString = airlineString.concat(st + "\n");
			 }
			
			//airlineString = airlineString.replaceAll("[ \t]", " ").substring(airlineString.indexOf("Airline 1")+10, airlineString.indexOf("Airline 2")-9);
			airlineString = airlineString.replaceAll("Airline 1", "");
			
			System.out.println(airlineString);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			ArrayList<String> flightDataTokens = new ArrayList<String>();
			while (myFlightDataStringTokenizer.hasMoreTokens()) {
				flightDataTokens.add(myFlightDataStringTokenizer.nextToken());
			}
			
			for (int j = 0; j < flightDataTokens.size(); j++) {
				JLabel flightDataLabel = new JLabel(flightDataTokens.get(i));
			}
		
			Flight thisFlight =  new Flight(Integer.parseInt(flightDataTokens.get(0)),
					flightDataTokens.get(1),
					flightDataTokens.get(2),
					flightDataTokens.get(3),
					flightDataTokens.get(4),
					flightDataTokens.get(5),
					Integer.parseInt(flightDataTokens.get(6).substring(0,flightDataTokens.get(6).indexOf("/"))),
					Integer.parseInt(flightDataTokens.get(6).substring(flightDataTokens.get(6).indexOf("/")+1)),
					Integer.parseInt(flightDataTokens.get(7)),
					Integer.parseInt(flightDataTokens.get(8))
					);
		
			JButton myNewButton = new JButton("View Reservations");
			myNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						new CustomerReservationsList(thisFlight);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			
			myNewButton.setBounds(340, y+80, 175, 23);
			frame.getContentPane().add(myNewButton);
			
		}
		
		//System.out.println(airlineString);
	}
}
