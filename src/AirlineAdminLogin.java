import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class AirlineAdminLogin {

	private static JFrame airlineAdminLogInFrame;
	private JTextField signinWindowUsernameField;
	private JPasswordField signinWindowPasswordField;
	private JTextField registerWindowUsernameField;
	private JPasswordField registerWindowPasswordField;
	private String filePath = "airlineAdminLogin.txt"; // File where account details will be stored

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AirlineAdminLogin window = new AirlineAdminLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AirlineAdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		airlineAdminLogInFrame = new JFrame("Airline Administrator Sign-In Page");
		airlineAdminLogInFrame.setVisible(true);
		airlineAdminLogInFrame.setTitle("Airline Administrator Sign-In Page");
		airlineAdminLogInFrame.setBounds(100, 100, 730, 510);
		//airlineAdminLogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		airlineAdminLogInFrame.getContentPane().setLayout(null);

		JPanel signinWindow = new JPanel();
		signinWindow.setBorder(new LineBorder(UIManager.getColor("Desktop.background")));
		signinWindow.setBounds(30, 70, 280, 340);
		airlineAdminLogInFrame.getContentPane().add(signinWindow);
		signinWindow.setLayout(null);

		JLabel signinWindowHeader = new JLabel("Sign In");
		signinWindowHeader.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		signinWindowHeader.setBounds(21, 23, 98, 39);
		signinWindow.add(signinWindowHeader);

		JPanel signinWindowUnderline = new JPanel();
		signinWindowUnderline.setBackground(new Color(0, 204, 204));
		signinWindowUnderline.setBounds(17, 58, 102, 6);
		signinWindow.add(signinWindowUnderline);

		signinWindowUsernameField = new JTextField();
		signinWindowUsernameField.setBounds(74, 132, 200, 40);
		signinWindow.add(signinWindowUsernameField);
		signinWindowUsernameField.setColumns(10);

		signinWindowPasswordField = new JPasswordField();
		signinWindowPasswordField.setBounds(74, 191, 200, 40);
		signinWindow.add(signinWindowPasswordField);

		JLabel signinWindowUsernameLbl = new JLabel("Username");
		signinWindowUsernameLbl.setBounds(9, 144, 62, 16);
		signinWindow.add(signinWindowUsernameLbl);

		JLabel signinWindowPasswordLbl = new JLabel("Password");
		signinWindowPasswordLbl.setBounds(9, 203, 59, 16);
		signinWindow.add(signinWindowPasswordLbl);

		JPanel signinWindowBtn = new JPanel();
		signinWindowBtn.addMouseListener(new MouseAdapter() {

			// Uses verifyLogin function to check if username and password is valid in the
			// text file. If valid details, logs in.
			public void mousePressed(MouseEvent e) {
				boolean found = false;
				String tempUsername = "";
				String tempPassword = "";
				Scanner x;

				try {
					x = new Scanner(new File(filePath));
					x.useDelimiter("[,\n]"); // Separate username and password by a , or newline

					while (x.hasNext() && !found) {
						tempUsername = x.next();
						tempPassword = x.next();

						if (tempUsername.trim().contentEquals(signinWindowUsernameField.getText().trim())
								&& tempPassword.trim().equals(signinWindowPasswordField.getText().trim())) {
							found = true;
						}
					}
					x.close();
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "There was an error logging you in. Please try again.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				if (found == true) {
					JOptionPane.showMessageDialog(airlineAdminLogInFrame, "Log-in Successful!", "Success",
							JOptionPane.PLAIN_MESSAGE);

					/*
					 * 
					 * 
					 * 
					 * 
					 * 
					 */
					airlineAdminLogInFrame.dispose();
					
					new AdminEditOrViewMenu();
					
					/*
					 * 
					 * 
					 * 
					 * 
					 * 
					 */
					
				} else {
					JOptionPane.showMessageDialog(airlineAdminLogInFrame,
							"Invalid username or password. Please try again.", "Wrong Username or Password",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		signinWindowBtn.setBorder(new LineBorder(new Color(0, 153, 153)));
		signinWindowBtn.setBounds(38, 263, 206, 36);
		signinWindow.add(signinWindowBtn);
		signinWindowBtn.setLayout(null);

		JLabel signInWindowBtnLbl = new JLabel("Sign In");
		signInWindowBtnLbl.setBounds(65, 3, 80, 30);
		signInWindowBtnLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		signinWindowBtn.add(signInWindowBtnLbl);

		JLabel signinWindowDescriptionLbl = new JLabel(
				"<html>Welcome back!<br/>Enter your account details to continue.</html>");
		signinWindowDescriptionLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		signinWindowDescriptionLbl.setBounds(17, 74, 257, 36);
		signinWindow.add(signinWindowDescriptionLbl);

		JPanel registerWindow = new JPanel();
		registerWindow.setLayout(null);
		registerWindow.setBorder(new LineBorder(UIManager.getColor("Desktop.background")));
		registerWindow.setBounds(384, 70, 280, 340);
		airlineAdminLogInFrame.getContentPane().add(registerWindow);
		registerWindow.setVisible(false);

		JLabel registerWindowHeader = new JLabel("Create Account");
		registerWindowHeader.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		registerWindowHeader.setBounds(21, 23, 200, 39);
		registerWindow.add(registerWindowHeader);

		JPanel registerWindowUnderline = new JPanel();
		registerWindowUnderline.setBackground(new Color(0, 204, 204));
		registerWindowUnderline.setBounds(17, 58, 200, 6);
		registerWindow.add(registerWindowUnderline);

		registerWindowUsernameField = new JTextField();
		registerWindowUsernameField.setColumns(10);
		registerWindowUsernameField.setBounds(74, 132, 200, 40);
		registerWindow.add(registerWindowUsernameField);

		registerWindowPasswordField = new JPasswordField();
		registerWindowPasswordField.setBounds(74, 191, 200, 40);
		registerWindow.add(registerWindowPasswordField);

		JLabel registerWindowUsernameLbl = new JLabel("Username");
		registerWindowUsernameLbl.setBounds(9, 144, 62, 16);
		registerWindow.add(registerWindowUsernameLbl);

		JLabel registerWindowPasswordLbl = new JLabel("Password");
		registerWindowPasswordLbl.setBounds(9, 203, 59, 16);
		registerWindow.add(registerWindowPasswordLbl);

		JPanel registerWindowBtn = new JPanel();
		registerWindowBtn.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				boolean found = false;
				String tempUsername = "";
				String tempPassword = "";
				Scanner x;

				try {
					x = new Scanner(new File(filePath));
					x.useDelimiter("[,\n]");

					while (x.hasNext() && !found) {
						tempUsername = x.next();
						tempPassword = x.next();

						if (tempUsername.trim().contentEquals(registerWindowUsernameField.getText().trim())) {
							found = true;
						}
					}
					x.close();
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, filePath + " does not exist. Creating the file now.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				// Check if username already exists
				if (found == true) {
					JOptionPane.showMessageDialog(airlineAdminLogInFrame,
							"That username is already taken. Please try another.", "Invalid Username",
							JOptionPane.WARNING_MESSAGE);
				}

				// Check if username contains only letters and numbers
				else if ((registerWindowUsernameField.getText().length() <= 3)
						|| !(registerWindowUsernameField.getText().matches("[a-zA-Z0-9]*"))) {
					JOptionPane.showMessageDialog(airlineAdminLogInFrame,
							"Username should be at least 4 characters long and contain only letters and numbers.",
							"Invalid Username", JOptionPane.WARNING_MESSAGE);
				}

				// Check if password >= 4 and contains only letters and numbers
				else if ((registerWindowPasswordField.getText().length() <= 3)
						|| !(registerWindowPasswordField.getText().matches("[a-zA-Z0-9]*"))) {
					JOptionPane.showMessageDialog(airlineAdminLogInFrame,
							"Password should be at least 4 characters long and contain only letters and numbers.",
							"Invalid Password", JOptionPane.WARNING_MESSAGE);
				}

				// Username and password meets requirements, create the account (write in
				// filePath)
				else {

					try {
						FileWriter fileWriter = new FileWriter(filePath, true);
						fileWriter.write(registerWindowUsernameField.getText() + ","
								+ registerWindowPasswordField.getText() + "\n"); // Write username and password in
																					// filePath.txt
						fileWriter.close();
						JOptionPane.showMessageDialog(airlineAdminLogInFrame,
								"Account successfully created! You may now use your details to log-in.",
								"Account Created", JOptionPane.PLAIN_MESSAGE);
					} catch (Exception E) {
						JOptionPane.showMessageDialog(airlineAdminLogInFrame,
								"There was an error registering, please try again.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		registerWindowBtn.setLayout(null);
		registerWindowBtn.setBorder(new LineBorder(new Color(0, 153, 153)));
		registerWindowBtn.setBounds(38, 263, 206, 36);
		registerWindow.add(registerWindowBtn);

		JLabel registerWindowBtnLbl = new JLabel("Register");
		registerWindowBtnLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		registerWindowBtnLbl.setBounds(65, 3, 101, 30);
		registerWindowBtn.add(registerWindowBtnLbl);

		JLabel registerWindowDescriptionLbl = new JLabel(
				"<html>Let's get started!<br/>Create a username and password below.</html>");
		registerWindowDescriptionLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		registerWindowDescriptionLbl.setBounds(16, 74, 265, 39);
		registerWindow.add(registerWindowDescriptionLbl);

		JLabel registerWindowPasswordReqLbl = new JLabel(
				"<html>Username and Password should be at least 4 characters long</br> and contain only letters (a-z, A-Z) and numbers (0-9).</html>");
		registerWindowPasswordReqLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		registerWindowPasswordReqLbl.setBounds(9, 231, 265, 20);
		registerWindow.add(registerWindowPasswordReqLbl);

		JPanel signinBtn = new JPanel();

		signinBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				signinWindow.setVisible(true);
				registerWindow.setVisible(false);
			}
		});

		signinBtn.setBorder(new LineBorder(UIManager.getColor("Desktop.background")));
		signinBtn.setBounds(119, 237, 134, 40);
		airlineAdminLogInFrame.getContentPane().add(signinBtn);
		signinBtn.setLayout(null);

		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setBounds(39, 6, 74, 28);
		lblSignIn.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		signinBtn.add(lblSignIn);

		JPanel registerBtn = new JPanel();
		registerBtn.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				registerWindow.setVisible(true);
				signinWindow.setVisible(false);
			}
		});

		registerBtn.setBorder(new LineBorder(UIManager.getColor("Desktop.background")));
		registerBtn.setBounds(484, 237, 134, 40);
		airlineAdminLogInFrame.getContentPane().add(registerBtn);
		registerBtn.setLayout(null);

		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRegister.setBounds(34, 6, 74, 28);
		registerBtn.add(lblRegister);

		JPanel airlineAdminLoginHeader = new JPanel();
		airlineAdminLoginHeader.setBorder(new LineBorder(new Color(65, 105, 170)));
		airlineAdminLoginHeader.setBounds(235, 16, 278, 32);
		airlineAdminLogInFrame.getContentPane().add(airlineAdminLoginHeader);
		airlineAdminLoginHeader.setLayout(null);

		JLabel airlineAdminLoginHeaderLbl = new JLabel("Airline Administrator Log-In");
		airlineAdminLoginHeaderLbl.setBounds(6, 6, 264, 22);
		airlineAdminLoginHeader.add(airlineAdminLoginHeaderLbl);
		airlineAdminLoginHeaderLbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));

		JLabel windowBG = new JLabel("");
		windowBG.setIcon(new ImageIcon(AirlineAdminLogin.class.getResource("/loginbackground.jpg")));
		windowBG.setBounds(0, 0, 730, 510);
		airlineAdminLogInFrame.getContentPane().add(windowBG);
	}

}
