import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AUS_Arrivals extends JFrame{

	String[][] queryStore;
	JTable queryResult;
	String[] columnNames = {"Flight Number", "Departure Airport", "Arrival Ariport", "Departure Time",
			"Arrival Time", "Date", "Capacity", "Fare", "Airline Company", "Status"};
	ArrayList<String[]> parseList = new ArrayList<>();
	
	public AUS_Arrivals() throws IOException {
		
		super("AUS Arrivals Screen");
		
		queryKeyword("Airlines_Info_2.txt", "AUS");
		
		JScrollPane window = new JScrollPane(queryResult);
		
		add(window);
		
		setSize(900, 900);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void queryKeyword(String database, String keyword) throws IOException {
		
		File file = new File(database); 
		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		String str;
		ArrayList<String[]> list = new ArrayList<>();
		
		//int index = 0;
		
		int column = 2;
		
		//sort by
		//if(sort.compareTo("Airline Name") == 0) index = 8;
	     
	    //if(sort.compareTo("Fare") == 0) index = 7;
	    
	    //if(n == 0) column = 8;
	    //if(n == 1) column = 4;
	    //if(n == 2) column = 3;
	    
	    //Capacity
	    //if(n == 3) column = 6;
		  
		while ((str = br.readLine()) != null) {
		    
			   
			String[] arrOfStr = str.split(" ", -2);
		    
			arrOfStr[5] = Data.getDate();
			
		    //index 0: Flight ID
		    //index 1: Departure Airport
		    //index 2: Arrival Airport
		    //index 3: Departure Time
		    //index 4: Arrival Time
		    //index 5: Current Date
		    //index 6: Capacity
		    //index 7: Fare
		    //index 8: Airline Name
			
		    if(arrOfStr[column].equals(keyword)) {
		    	  
		    	list.add(arrOfStr);
		    }
		 }
		  
		int count = list.size();
		  
		System.out.println(count);
	      
		//String[] temp;
	      
	    //for (int i = 0; i < count; i++) {
	    //	for (int j = i + 1; j < count; j++) { 
	    //		if (list.get(i)[index].compareTo(list.get(j)[index]) > 0) {
	    //			temp = list.get(i);
	    //		    list.set(i, list.get(j));
	    //		    list.set(j, temp);
	    //		    }
	    //		}
	    //	}
	      
	    queryStore = new String[count][10];
	    
	    for(int i = 0; i < count; i++) {
	    	for(int j = 0; j < 10; j++) {
	    		
	    		//queryStore = new String[count][9];
	    		
	    		queryStore[i][j] = list.get(i)[j];
	    		
	    		System.out.print(list.get(i)[j]);
	    		System.out.print(" ");
	    	}
	    System.out.println();
	    }
	    
	    queryResult = new JTable(queryStore, columnNames);
	    
	    parseList = list;
	    
	}
}
