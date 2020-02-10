import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class SearchEngineWindow {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEngineWindow window = new SearchEngineWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchEngineWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame SearchEngineWindow;
		JTextField arrivalTimeField;
		JTextField departingTimeField;
	//	JTextField capacityField;
		
		SearchEngineWindow = new JFrame();
		SearchEngineWindow.setVisible(true);
		SearchEngineWindow.setTitle("Search Engine Window");
		SearchEngineWindow.setBounds(100, 100, 500, 475);
		SearchEngineWindow.getContentPane().setLayout(null);
		
		JPanel searchEngineHeaderPane = new JPanel();
		searchEngineHeaderPane.setBounds(162, 17, 173, 31);
		SearchEngineWindow.getContentPane().add(searchEngineHeaderPane);
		
		JLabel searchEngineHeaderLbl = new JLabel("Search Engine");
		searchEngineHeaderLbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		searchEngineHeaderPane.add(searchEngineHeaderLbl);
		
		JLabel searchEngineDescLbl = new JLabel("<html>Looking for a specific flight?<br>Enter information about your flight here!</html>");
		searchEngineDescLbl.setBounds(21, 72, 264, 31);
		SearchEngineWindow.getContentPane().add(searchEngineDescLbl);
		
		JPanel searchEngineSearchForm = new JPanel();
		searchEngineSearchForm.setBounds(21, 115, 444, 305);
		SearchEngineWindow.getContentPane().add(searchEngineSearchForm);
		searchEngineSearchForm.setLayout(null);
		
		arrivalTimeField = new JTextField();
		arrivalTimeField.setBounds(130, 144, 106, 20);
		searchEngineSearchForm.add(arrivalTimeField);
		arrivalTimeField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		arrivalTimeField.setColumns(10);
		
		JLabel arrivalAirportLbl = new JLabel("From:");
		arrivalAirportLbl.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		arrivalAirportLbl.setBounds(20, 22, 55, 16);
		searchEngineSearchForm.add(arrivalAirportLbl);
		
		JLabel departureAirportLbl = new JLabel("To:");
		departureAirportLbl.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		departureAirportLbl.setBounds(194, 22, 30, 16);
		searchEngineSearchForm.add(departureAirportLbl);
		
		JLabel airlineLbl = new JLabel("Airline:");
		airlineLbl.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		airlineLbl.setBounds(20, 84, 55, 16);
		searchEngineSearchForm.add(airlineLbl);
		
		JLabel arrivalTimeLbl = new JLabel("Arrival Time:");
		arrivalTimeLbl.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		arrivalTimeLbl.setBounds(20, 144, 97, 16);
		searchEngineSearchForm.add(arrivalTimeLbl);
		
		JComboBox arrivalAirportDropdown = new JComboBox();
		
		arrivalAirportDropdown.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// TODO
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
				
					String str = (String) arrivalAirportDropdown.getSelectedItem();
				
					helperClass.setString(str);
					
					helperClass.setFromAirport(str);
				
					System.out.println(str);
				
				}
			}
		});
		String fromAirport = helperClass.getString();
		System.out.println(fromAirport);
		
		arrivalAirportDropdown.setBounds(67, 20, 86, 27);
		arrivalAirportDropdown.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		arrivalAirportDropdown.setModel(new DefaultComboBoxModel(new String[] {"", "AUS", "LAX", "ORD"}));
		arrivalAirportDropdown.setMaximumRowCount(4);
		searchEngineSearchForm.add(arrivalAirportDropdown);
		
		JComboBox departureAirportDropdown = new JComboBox();
		
		departureAirportDropdown.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent f) {

				if (f.getStateChange() == ItemEvent.SELECTED) {
					
					String str = (String) departureAirportDropdown.getSelectedItem();
					
					helperClass.setString(str);
					
					helperClass.setToAirport(str);
					
					System.out.println(str);
			
				}
			}
		});
		String toAirport = helperClass.getString();
		System.out.println(toAirport);
		
		departureAirportDropdown.setBounds(223, 20, 86, 27);
		departureAirportDropdown.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		departureAirportDropdown.setModel(new DefaultComboBoxModel(new String[] {"", "AUS", "LAX", "ORD"}));
		departureAirportDropdown.setMaximumRowCount(4);
		searchEngineSearchForm.add(departureAirportDropdown);
		
		
		JComboBox airlineDropdown = new JComboBox();
		
		
		
		
		airlineDropdown.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent f) {

				if (f.getStateChange() == ItemEvent.SELECTED) {
					
					String str = (String) airlineDropdown.getSelectedItem();
					
					helperClass.setString(str);
					
					helperClass.setAirline(str);
					
					System.out.println(str);
			
				}
			}
		});
		String airlineName = helperClass.getString();
		System.out.println(airlineName);
		
		
		airlineDropdown.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3"}));
		airlineDropdown.setBounds(77, 80, 147, 27);
		airlineDropdown.setMaximumRowCount(4);
		airlineDropdown.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		searchEngineSearchForm.add(airlineDropdown);
		
		JLabel departingTimeLbl = new JLabel("Departing Time:");
		departingTimeLbl.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		departingTimeLbl.setBounds(20, 205, 117, 16);
		searchEngineSearchForm.add(departingTimeLbl);
		
		departingTimeField = new JTextField();
		departingTimeField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		departingTimeField.setColumns(10);
		departingTimeField.setBounds(139, 205, 106, 20);
		searchEngineSearchForm.add(departingTimeField);
		
		//JLabel capacityLbl = new JLabel("Capacity:");
		//capacityLbl.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		//capacityLbl.setBounds(20, 270, 63, 16);
		//searchEngineSearchForm.add(capacityLbl);
		
		//capacityField = new JTextField();
		//capacityField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		//capacityField.setColumns(10);
		//capacityField.setBounds(95, 270, 106, 20);
		//searchEngineSearchForm.add(capacityField);
		
		JButton btnSearchFromTo = new JButton("Search");
		
		
		//new helperClassTwo(fromAirport, toAirport);
		
		btnSearchFromTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					new SearchEngineQuery(helperClass.getFromAirport(), helperClass.getToAirport());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		btnSearchFromTo.setBounds(321, 20, 106, 27);
		searchEngineSearchForm.add(btnSearchFromTo);
		btnSearchFromTo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JButton btnSearchAirline = new JButton("Search Airline");
		
		
		
		
		btnSearchAirline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
				// Add search for the airlines
				try {
					new SearchEngineQuery(helperClass.getAirline(), 0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		

		
		
		btnSearchAirline.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSearchAirline.setBounds(230, 80, 141, 27);
		searchEngineSearchForm.add(btnSearchAirline);
		
		JButton btnSearchArrivalTime = new JButton("Search Arrivals");
		
		
		
		
		btnSearchArrivalTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//String str = (String) airlineDropdown.getSelectedItem();
				
				String str = arrivalTimeField.getText();
				
				helperClass.setString(str);
				
				helperClass.setArrivalTime(str);
				
				System.out.println(str);
				
				try {
					new SearchEngineQuery(str, 1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// TODO
				// Add search for the Arrival Times
			}
		});
		//String arrivalTime = helperClass.getString();
		//System.out.println(airlineName);
		
		
		
		btnSearchArrivalTime.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSearchArrivalTime.setBounds(248, 143, 158, 27);
		searchEngineSearchForm.add(btnSearchArrivalTime);
		
		JButton btnSearchDepartureTime = new JButton("Search Departures");
		
		
		
		
		btnSearchDepartureTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
				// Add search for the Departure Times
				
				String str = departingTimeField.getText();
				
				helperClass.setString(str);
				
				helperClass.setDepartureTime(str);
				
				System.out.println(str);
				
				try {
					new SearchEngineQuery(str, 2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		btnSearchDepartureTime.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSearchDepartureTime.setBounds(259, 205, 179, 27);
		searchEngineSearchForm.add(btnSearchDepartureTime);
		
		
		JPanel border1 = new JPanel();
		border1.setBackground(SystemColor.textHighlight);
		border1.setBounds(6, 59, 432, 5);
		searchEngineSearchForm.add(border1);
		
		JPanel border2 = new JPanel();
		border2.setBackground(SystemColor.textHighlight);
		border2.setBounds(6, 120, 432, 5);
		searchEngineSearchForm.add(border2);
		
		JPanel border3 = new JPanel();
		border3.setBackground(SystemColor.textHighlight);
		border3.setBounds(6, 180, 432, 5);
		searchEngineSearchForm.add(border3);
		
		JPanel border4 = new JPanel();
		border4.setBackground(SystemColor.textHighlight);
		border4.setBounds(6, 245, 432, 5);
		searchEngineSearchForm.add(border4);
		
		JLabel lblSortResultsBy = new JLabel("Sort Results By:");
		lblSortResultsBy.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSortResultsBy.setBounds(327, 71, 107, 16);
		SearchEngineWindow.getContentPane().add(lblSortResultsBy);
		
		JComboBox sortDropdown = new JComboBox();
		sortDropdown.setBounds(308, 87, 147, 27);
		SearchEngineWindow.getContentPane().add(sortDropdown);
		
		
		
		sortDropdown.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//TODO
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					String str = (String) sortDropdown.getSelectedItem();
				
					helperClass.setString(str);
					
					helperClass.setSort(str);
				
					System.out.println(str);
				
				}
			}
		});
		
		String sort = helperClass.getSort();
		System.out.println(sort);
		
		
		
		sortDropdown.setModel(new DefaultComboBoxModel(new String[] {"", "Airline Name", "Fare"}));
		sortDropdown.setMaximumRowCount(3);
	}
}

