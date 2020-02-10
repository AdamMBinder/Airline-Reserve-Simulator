import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AirportsGUI extends JFrame {
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	private	JLabel	l1;
	
	public AirportsGUI() {
		
		super("Airports");
		
		setLayout(new GridLayout(4, 1));
		
		btn1 = new JButton("Austin-Bergstrom International Airport(AUS)");
		btn2 = new JButton("Los Angeles International Airport(LAX)");
		btn3 = new JButton("O'Hare International Airport(ORD)");
		
		btn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				new AUS_Welcome();
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				new LAX_Welcome();
			}
			
		});
		
		btn3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				new ORD_Welcome();
			}
			
		});
		
		l1 = new JLabel("Please select an airport to view it's arrivals and departures");
		
		add(l1);
		add(btn1);
		add(btn2);
		add(btn3);
		
		setSize(600, 300);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setVisible(true);
	}
}
