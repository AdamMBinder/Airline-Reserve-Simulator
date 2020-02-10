/*
 * 
 * 2.0
 * Change if its fucked TODO:
 * 
 * */


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CurrentDate {

	private JFrame frmMy;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentDate window = new CurrentDate();
					window.frmMy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CurrentDate() {
		initialize();
	}

	private void initialize() {
		frmMy = new JFrame();
		frmMy.setTitle("Enter Date");
				
		frmMy.setBounds(100, 100, 424, 215);
		frmMy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMy.getContentPane().setLayout(null);
		
		JLabel lblEnterCurrentDate = new JLabel(" Enter date in MM/DD/YY form: ");
		lblEnterCurrentDate.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblEnterCurrentDate.setBounds(0, 0, 424, 26);
		frmMy.getContentPane().add(lblEnterCurrentDate);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 36));
		textField.setBounds(10, 47, 224, 90);
		frmMy.getContentPane().add(textField);
		textField.setColumns(8);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnEnter.setBounds(255, 47, 122, 90);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMy.dispose();
				new WelcomeFrame();
				Data.currentDate = textField.getText();
				System.out.println(Data.currentDate);
			}
		});
		frmMy.getContentPane().add(btnEnter);
	}

}
