
public class helperClass {

	static String str = "";
	
	static String toAirport = "";
	static String fromAirport = "";
	
	static String airline = "";
	
	static String arrivalTime = "";
	
	static String departureTime = "";
	
	static String capacity = "";
	
	static String sort = "";
	
	public helperClass() {
		
	}
	
	public static void setString(String x) {
		
		str = x;
	}
	
	public static String getString() {
		
		String sentinel = str;
		
		str = "";
		
		return sentinel;
	}
	
	public static void setToAirport(String x) {
		
		toAirport = x;
	}
	
	public static void setFromAirport(String x) {
		
		fromAirport = x;
	}
	
	public static String getToAirport() {
		
		return toAirport;
	}

	public static String getFromAirport() {
		
		return fromAirport;
	}
	
	public static void setAirline(String x) {
		
		airline = x;
	}
	
	public static String getAirline() {
		
		return airline;
	}
	
	public static void setArrivalTime(String x) {
		
		arrivalTime = x;
	}
	
	public static String getArrivalTime() {
		
		return arrivalTime;
	}
	
	public static void setDepartureTime(String x) {
		
		departureTime = x;
	}
	
	public static String getDepartureTime() {
		
		return departureTime;
	}
	
	public static void setCapacity(String x) {
		
		capacity = x;
	}
	
	public static String getCapacity() {
		
		return capacity;
	}
	
	public static void setSort(String x) {
		
		sort = x;
	}
	
	public static String getSort() {
		
		return sort;
	}
}
