import java.util.Scanner;    
import java.util.*;

class Flight {
    String flightId;
    String from;
    String to;
    int price;

    public Flight(String flightId, String from, String to, int price) {
        this.flightId = flightId;
        this.from = from;
        this.to = to;
        this.price = price;
    }
}
 class Main {
    public static void main(String[] args) {
        Flight[] flights = {
            new Flight("AI161E90", "BLR", "BOM", 5600),
            new Flight("BR161F91", "BOM", "BBI", 6750),
            new Flight("AI161F99", "BBI", "BLR", 8210),
            new Flight("VS171E20", "JLR", "BBI", 5500),
            new Flight("AS171G30", "HYD", "JLR", 4400),
            new Flight("AI131F49", "HYD", "BOM", 3499)
        };

        Scanner sc= new Scanner(System.in);
        System.out.println("Choose a search parameter:");
        System.out.println("1. Flights for a particular City");
        System.out.println("2. Flights From a city");
        System.out.println("3. Flights between two given cities");
        int ch = sc.nextInt();

        if (ch == 1) {
            System.out.println("Enter the city: ");
            String city = sc.next();
            searchFlightsForCity(flights, city);
        } else if (ch == 2) {
            System.out.println("Enter the departure city: ");
            String fromCity = sc.next();
            searchFlightsFromCity(flights, fromCity);
        } else if (ch == 3) {
            System.out.println("Enter the source city: ");
            String sourceCity = sc.next();
            System.out.println("Enter the destination city: ");
            String destCity = sc.next();
            searchFlightsBetweenCities(flights, sourceCity, destCity);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void searchFlightsForCity(Flight[] flights, String city) {
        System.out.println("Flights for " + city + ":");
        for (Flight flight : flights) {
            if (flight.from.equals(city) || flight.to.equals(city)) {
                System.out.println(flight.flightId + " - Price: " + flight.price);
            }
        }
    }

    public static void searchFlightsFromCity(Flight[] flights, String fromCity) {
        System.out.println("Flights from " + fromCity + ":");
        for (Flight flight : flights) {
            if (flight.from.equals(fromCity)) {
                System.out.println(flight.flightId + " - To: " + flight.to + " - Price: " + flight.price);
            }
        }
    }

    public static void searchFlightsBetweenCities(Flight[] flights, String sourceCity, String destCity) {
        System.out.println("Flights between " + sourceCity + " and " + destCity + ":");
        for (Flight flight : flights) {
            if (flight.from.equals(sourceCity) && flight.to.equals(destCity)) {
                System.out.println(flight.flightId + " - Price: " + flight.price);
            }
        }
    }
}
