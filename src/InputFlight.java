import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.*;

public class InputFlight {
	
	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblDate;
	private JLabel lblTime;
	private JLabel lblFare;
	private JButton btnInputFlight;
	private JButton btnSaveChanges;
	private JLabel lblMaxCapacity;
	private JTextField textField_4;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputFlight window = new InputFlight();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InputFlight() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 307);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterFlight = new JLabel("Please enter flight information: ");
		lblPleaseEnterFlight.setBounds(0, 0, 424, 26);
		frame.getContentPane().add(lblPleaseEnterFlight);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(183, 36, 235, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(183, 70, 235, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(183, 104, 235, 32);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(183, 140, 235, 32);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblDate = new JLabel("Date");
		lblDate.setBounds(21, 39, 141, 26);
		frame.getContentPane().add(lblDate);
		
		lblTime = new JLabel("Time");
		lblTime.setBounds(21, 73, 141, 26);
		frame.getContentPane().add(lblTime);
		
		lblFare = new JLabel("Fare");
		lblFare.setBounds(21, 107, 141, 26);
		frame.getContentPane().add(lblFare);
		
		lblMaxCapacity = new JLabel("Max Capacity");
		lblMaxCapacity.setBounds(21, 143, 141, 26);
		frame.getContentPane().add(lblMaxCapacity);
		
		btnInputFlight = new JButton("Input Flight");
		btnInputFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInputFlight.setBounds(109, 193, 143, 25);
		frame.getContentPane().add(btnInputFlight);
		
		btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveChanges.setBounds(109, 230, 143, 25);
		frame.getContentPane().add(btnSaveChanges);
	}
}
