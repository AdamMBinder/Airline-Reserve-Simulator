import java.util.*;
//12/4/19
public class Data {
	public static String currentAirline = "airline3";
	static String currentCustomer = "";
	
	public static List<Flight> currentCustomerList = new ArrayList<Flight>();

	//public static List<Flight> customer1List = new ArrayList<Flight>();
//	public static List<Flight> customer2List = new ArrayList<Flight>();
//	public static List<Flight> customer3List = new ArrayList<Flight>();
	
	public static HashMap<Flight, ArrayList<String>> customerReservationsMap = new HashMap<Flight, ArrayList<String>>();
	public static HashMap<Integer, Flight> allFlightsMap = new HashMap<Integer, Flight>(); 	
	
	static String currentDate = "";
	
	public static void setDate(String x) {
		currentDate = x;
	}
	
	public static String getDate() {
		
		return currentDate;
	}
	
	public static void setCustomer(String x) {
		currentCustomer = x;
	}
	
	public static String getCustomer() {
		
		return currentCustomer;
	}
}
