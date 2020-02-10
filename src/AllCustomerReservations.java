import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

public class AllCustomerReservations {

	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllCustomerReservations window = new AllCustomerReservations();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AllCustomerReservations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		File[] files = new File("").listFiles();
		showFiles(files);
		//System.out.println(readFromFile(new File("")));
		
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
	
	private void showFiles(File[] files) {
	    for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println("customers" + file.getName());
	            showFiles(file.listFiles()); 
	        } else {
	            System.out.println("File: " + file.getName());
	        }
	    }
	}

}
