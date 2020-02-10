//12/4/19
public class Flight {
	
	int flightNo;
	String flightFrom;
	String flightTo;
	String departTime;
	String arrivalTime;
	String date;
	int reservations;
	int capacity;
	int fare;
	int airlineNo;
	
	public Flight() {

	}
	
	public Flight (int inputFlightNo, String inputFlightFrom, String inputFlightTo, String inputDepartTime, 
			String inputArrivalTime, String inputDate, int inputReservations, int inputCapacity, int inputFare,
			int inputAirlineNo) {
		flightNo = inputFlightNo;
		flightFrom = inputFlightFrom;
		flightTo = inputFlightTo;
		departTime = inputDepartTime;
		arrivalTime = inputArrivalTime;
		date = inputDate;
		reservations = inputReservations;
		capacity = inputCapacity;
		fare = inputFare;
		airlineNo = inputAirlineNo;
	}
	
	public boolean Equals(Flight otherFlight) {
		/*
		if ((flightNo == otherFlight.flightNo) &&
				(flightFrom.equals(otherFlight.flightFrom)))
			return true;
		else
			return false;
		*/
		
		if ((flightNo == otherFlight.flightNo) &&
			(flightFrom.equals(otherFlight.flightFrom)) &&
			(flightTo.equals(otherFlight.flightTo)) &&
			(departTime.equals(otherFlight.departTime)) &&
			(arrivalTime.equals(otherFlight.arrivalTime)) &&
			(date.equals(otherFlight.date)) &&
			(reservations == otherFlight.reservations) &&
			(capacity == otherFlight.capacity) &&
			(fare == otherFlight.fare) &&
			(airlineNo == otherFlight.airlineNo))
		return true;
		else return false;
		
	}

	public String toString() {
		String returnString = "";
		returnString = flightNo + " "
				+ flightFrom + " "
				+ flightTo + " "
				+ departTime + " "
				+ arrivalTime + " "
				+ date + " "
				+ reservations + " "
				+ capacity + " "
				+ fare + " "
				+ airlineNo;
		return returnString;
	}
	
	
}