import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

//index 0: Flight ID
//index 1: Departure Airport
//index 2: Arrival Airport
//index 3: Departure Time
//index 4: Arrival Time
//index 5: Current Date
//index 6: Capacity
//index 7: Fare
//index 8: Airline Company

public class SearchEngineQuery extends JFrame {
	
	String from;
	String to;
	
	String airline;
	String arrivalTime;
	String departureTime;
	String capacity;
	
	String sort;
	
	String keyword;
	
	String database = "Airlines_Info_2.txt";
	
	JTextArea query = new JTextArea();
	
	JTable queryResult;
	String[][] queryStore;
	
	String[] columnNames = {"Flight Number", "Departure Airport", "Arrival Ariport", "Departure Time",
			"Arrival Time", "Date", "Capacity", "Fare", "Airline Company", "Reserve?"};
	
	JTable table;
	JScrollPane scrollPane;
	
	//Idea is to give this parseList to inTable, and just parse it in JTableModel
	ArrayList<String[]> parseList = new ArrayList<>();
	
	//From To Query
	public SearchEngineQuery(String x, String y) throws IOException {
		
		super("Query Results");
		
		sort = helperClass.getSort();
		from = x;
		to = y;
		int rows = queryToFrom(database, from, to, sort);
		
		setVisible(true);
		
		JTableModel inTable = new JTableModel(parseList);
		inTable.setRowCount(rows);
		
		JTable table = new JTable(inTable); 
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true); 
        table.addMouseListener(new JTableButtonMouseListener(table));

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        table.getColumn("Reserve?").setCellRenderer(buttonRenderer);
		
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
		setSize(1000, 500);
        
	}
	
	//Search by KeyWord Query
	public SearchEngineQuery(String x, int y) throws IOException {
		
		super("Query Results");
		
		sort = helperClass.getSort();
		
		//int rows;
		
		//JTableModel inTable;
		JScrollPane scrollPane = null;
		
		if(y == 0) {
		
			airline = x;
			keyword = airline;
			int rows = queryKeyword(database, airline, sort, y);
			
			setVisible(true);
			
			JTableModel inTable = new JTableModel(parseList);
			
			inTable.setRowCount(rows);
			
			JTable table = new JTable(inTable); 
			
			scrollPane = new JScrollPane(table);
			
			table.setFillsViewportHeight(true); 
	        table.addMouseListener(new JTableButtonMouseListener(table));

	        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
	        table.getColumn("Reserve?").setCellRenderer(buttonRenderer);
			
			//add(new JScrollPane(queryResult));
		}
		
		if(y == 1) {
			
			arrivalTime = x;
			keyword = arrivalTime;
			int rows = queryKeyword(database, arrivalTime, sort, y);
			
			setVisible(true);
			
			JTableModel inTable = new JTableModel(parseList);
			
			inTable.setRowCount(rows);
			
			JTable table = new JTable(inTable); 
			
			scrollPane = new JScrollPane(table);
			
			table.setFillsViewportHeight(true); 
	        table.addMouseListener(new JTableButtonMouseListener(table));

	        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
	        table.getColumn("Reserve?").setCellRenderer(buttonRenderer);
			
			//add(new JScrollPane(queryResult));
		}
		
		if(y == 2) {
			
			departureTime = x;
			keyword = departureTime;
			int rows = queryKeyword(database, departureTime, sort, y);
			
			setVisible(true);
			
			JTableModel inTable = new JTableModel(parseList);
			
			inTable.setRowCount(rows);
			
			JTable table = new JTable(inTable); 
			
			scrollPane = new JScrollPane(table);
			
			table.setFillsViewportHeight(true); 
	        table.addMouseListener(new JTableButtonMouseListener(table));

	        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
	        table.getColumn("Reserve?").setCellRenderer(buttonRenderer);
			
			//add(new JScrollPane(queryResult));
		}
		
		if(y == 3) {
			
			capacity = x;
			keyword = capacity;
			int rows = queryKeyword(database, capacity, sort, y);
			
			setVisible(true);
			
			JTableModel inTable = new JTableModel(parseList);
			
			inTable.setRowCount(rows);
			
			JTable table = new JTable(inTable); 
			
			scrollPane = new JScrollPane(table);
			
			table.setFillsViewportHeight(true); 
	        table.addMouseListener(new JTableButtonMouseListener(table));

	        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
	        table.getColumn("Reserve?").setCellRenderer(buttonRenderer);
			
			//add(new JScrollPane(queryResult));
		}
		
		setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
		setSize(1000, 500);
	}
	
	public int queryToFrom(String database, String from, String to, String sort) throws IOException {
		
		File file = new File(database); 
		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		String str;
		
		ArrayList<String[]> list = new ArrayList<>();
		  
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
		      
		    if(arrOfStr[1].equals(from) && arrOfStr[2].equals(to)) {
		    	  
		    	list.add(arrOfStr);
		    	}
		    }
		  
		int count = list.size();
		  
		System.out.println(count);
	      
		String[] temp;
	      		      
	    int index = 0;
	      
	    if(sort.compareTo("Airline Name") == 0) index = 8;
	     
	    if(sort.compareTo("Fare") == 0) index = 7;
	     
	      
	    for (int i = 0; i < count; i++) {
	    	for (int j = i + 1; j < count; j++) { 
	    		if (list.get(i)[index].compareTo(list.get(j)[index]) > 0) {
	    			temp = list.get(i);
	    		    list.set(i, list.get(j));
	    		    list.set(j, temp);
	    		    }
	    		}
	    	}
	      
	    queryStore = new String[count][10];
	    
	    for(int i = 0; i < count; i++) {
	    	for(int j = 0; j < 10; j++) {
	    		
	    		//queryStore = new String[count][9];
	    		
	    		if(j == 9) {
	    			queryStore[i][j] = "test";
	    			break;
	    		}
	    		
	    		queryStore[i][j] = list.get(i)[j];
	    		
	    		System.out.print(list.get(i)[j]);
	    		System.out.print(" ");
	    		}
	    	  System.out.println();
	    	  }
	    
	    	queryResult = new JTable(queryStore, columnNames);
	    	
	    	parseList = list;
	    	
	    	return count;
	    }
	
	public int queryKeyword(String database, String keyword, String sort, int n) throws IOException {
		
		File file = new File(database); 
		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		String str;
		ArrayList<String[]> list = new ArrayList<>();
		
		int index = 0;
		
		int column = 0;
		
		//sort by
		if(sort.compareTo("Airline Name") == 0) index = 8;
	     
	    if(sort.compareTo("Fare") == 0) index = 7;
	    
	    if(n == 0) column = 8;
	    if(n == 1) column = 4;
	    if(n == 2) column = 3;
	    
	    //Capacity
	    if(n == 3) column = 6;
		  
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
	      
		String[] temp;
	      
	    for (int i = 0; i < count; i++) {
	    	for (int j = i + 1; j < count; j++) { 
	    		if (list.get(i)[index].compareTo(list.get(j)[index]) > 0) {
	    			temp = list.get(i);
	    		    list.set(i, list.get(j));
	    		    list.set(j, temp);
	    		    }
	    		}
	    	}
	      
	    queryStore = new String[count][9];
	    
	    for(int i = 0; i < count; i++) {
	    	for(int j = 0; j < 9; j++) {
	    		
	    		//queryStore = new String[count][9];
	    		
	    		queryStore[i][j] = list.get(i)[j];
	    		
	    		System.out.print(list.get(i)[j]);
	    		System.out.print(" ");
	    	}
	    System.out.println();
	    }
	    
	    queryResult = new JTable(queryStore, columnNames);
	    
	    parseList = list;
	    
	    return count;
	}
}
