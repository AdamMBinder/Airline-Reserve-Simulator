import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomeFrame extends JFrame{
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	
	private	JLabel	l1;
	private	JLabel	l2;
	
	public WelcomeFrame() {
		
		super("Online Reservation System");
		
		setLayout(new GridLayout(6, 1));
		
		btn1 = new JButton("Customer Login");
		btn2 = new JButton("Airline Administrator Login");
		btn3 = new JButton("Search Engine Administrator Login");
		btn4 = new JButton("View Airports");
				
		btn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				new CustomerLogin();
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				new AirlineAdminLogin();
			}
			
		});
		
		btn3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				new SearchAdminLogin();
			}
			
		});
		
		btn4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				new AirportsGUI();
			}
			
		});
		
		l1 = new JLabel("Welcome to the Online Reservation System");
		l2 = new JLabel("Click a button to select a specific login");
		
		add(l1);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(l2);
		
		setSize(1200, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setVisible(true);
		
	}
}
