import java.awt.*;
import java.awt.List;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminEditFlightMenu {

	// THIS CAN"T BE HERE - PUT IN INITALIZE CLASS
	public ArrayList<JTextField> infoTextFields;
	public static Flight flightToEdit = new Flight(1, "fdsfd", "fdsfd", "fdsfd", "fdsfd", "fdsfd", 0, 0, 0, 0);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEditFlightMenu window = new AdminEditFlightMenu(flightToEdit);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AdminEditFlightMenu(Flight inputFlight) throws IOException {
		flightToEdit = inputFlight;
		initialize();
	} 

	private void initialize() throws IOException {
		
		JFrame frame;
		JTextField textField;
		JTextField textField_1;
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 200, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Flight thisFlight = new Flight(Integer.parseInt(infoTextFields.get(0).getText()),
						infoTextFields.get(1).getText(),
						infoTextFields.get(2).getText(),
						infoTextFields.get(3).getText(),
						infoTextFields.get(4).getText(),
						infoTextFields.get(5).getText(),
						Integer.parseInt(infoTextFields.get(6).getText()),
						Integer.parseInt(infoTextFields.get(7).getText()),
						Integer.parseInt(infoTextFields.get(8).getText()),
						Integer.parseInt(infoTextFields.get(9).getText())
						);
				Data.allFlightsMap.put(thisFlight.flightNo, thisFlight);
				System.out.println(Data.allFlightsMap);
			}
		});
		btnApply.setBounds(46, 220, 141, 35);
		frame.getContentPane().add(btnApply);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBack.setBounds(212, 220, 141, 35);
		frame.getContentPane().add(btnBack);

		ArrayList<String> flightInfoNames = new ArrayList<String>();
		flightInfoNames.add("Flight No.: ");
		flightInfoNames.add("Flight From: ");
		flightInfoNames.add("Flight To: ");
		flightInfoNames.add("Depart Time: ");
		flightInfoNames.add("Arrival Time: ");
		flightInfoNames.add("Date: ");
		flightInfoNames.add("Reservations: ");
		flightInfoNames.add("Capacity: ");
		flightInfoNames.add("Fare: ");
		flightInfoNames.add("Airline: ");
				
		ArrayList<String> flightInfoList = new ArrayList<String>();
		flightInfoList.add(Integer.toString(flightToEdit.flightNo));
		flightInfoList.add(flightToEdit.flightFrom);
		flightInfoList.add(flightToEdit.flightTo);
		flightInfoList.add(flightToEdit.departTime);
		flightInfoList.add(flightToEdit.arrivalTime);
		flightInfoList.add(flightToEdit.date);
		flightInfoList.add(Integer.toString(flightToEdit.reservations));
		flightInfoList.add(Integer.toString(flightToEdit.capacity));
		flightInfoList.add(Integer.toString(flightToEdit.fare));
		flightInfoList.add(Integer.toString(flightToEdit.airlineNo));
		
		ArrayList<String> flightInfoEnteredList = new ArrayList<String>();
		infoTextFields = new ArrayList<JTextField>();
		
		int y = 0; 
		for (int i = 0; i < 10; i++) {
			JLabel lblNewLabel = new JLabel(flightInfoNames.get(i));			
			frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
			lblNewLabel.setBounds(10, y, 100, 35);
			y = y+20;
			
			textField = new JTextField(flightInfoList.get(i));
			textField.setBounds(150,lblNewLabel.getY()+5,160,15);
			frame.getContentPane().add(textField, BorderLayout.CENTER);
			textField.setColumns(10);
			infoTextFields.add(textField);
			
		}
		
		
	}
}
