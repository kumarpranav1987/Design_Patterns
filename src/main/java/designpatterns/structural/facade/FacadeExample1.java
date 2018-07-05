package designpatterns.structural.facade;

/**
 * http://techytuts.in/facade-design-pattern-with-real-world-example-booking-system/
 * Provide a unified interface to a set of interface(s) in a subsystem. Facade
 * defines a higher-level interface that makes the subsystem easier to use.
 * 
 * Let us keep the definition aside for now and start looking into the below
 * ticket booking example so that it makes more sense.
 * 
 * Let us consider an example of booking a package . Usually when you try to
 * book a package , the ticket booking system interacts with many of subsystems.
 * The various sub-systems may be flight , hotel and cab booking . In addition
 * this may also interact with many other sub systems.
 * 
 * In this case instead of client having the overhead of interacting with
 * various other subsystems , we can introduce a facade layer which interacts
 * will all these subsystems. Finally once it get the response from all the
 * subsystems, it aggregates all these response and send the response back to
 * the client.
 * 
 * @author Pranav.Kumar
 *
 */
public class FacadeExample1 {
	public static void main(String[] args) {
		TravelPackageFacade travel = new TravelPackageFacadeImpl();
		travel.book();
	}
}

interface FlightBooking {
	public void book();
}

interface HotelBooking {
	public void book();
}

interface TranferBooking {
	public void book();
}

interface TravelPackageFacade {
	public void book();
}

class FlightBookingImpl implements FlightBooking {

	@Override
	public void book() {
		System.out.println("Flight Booked Successfully");

	}

}

class HotelbookingImpl implements HotelBooking {

	@Override
	public void book() {
		System.out.println("Hotel Booked Successflly");

	}

}

class TranferBookingImpl implements TranferBooking {

	@Override
	public void book() {
		System.out.println("Tranfer Booked Succesfully");

	}

}

class TravelPackageFacadeImpl implements TravelPackageFacade {

	@Override
	public void book() {
		FlightBooking flightbooking = new FlightBookingImpl();
		flightbooking.book();

		HotelBooking hotelBooking = new HotelbookingImpl();
		hotelBooking.book();

		TranferBooking transferBooking = new TranferBookingImpl();
		transferBooking.book();
	}

}