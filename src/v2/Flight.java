package v2;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Flight {
    private int idFlight;
    private String origin;
    private String destination;
    private double duration;
    private LocalTime departure; //hora salida
    private LocalTime arrival;  // cambiar este double a un formato de horas de java
    private Pilot pilot;
    private Plane planeused;
    private int placesAvailable;
    private double returnPercentage;
    private double priceTickets;

    public Flight() {
    }

    public Flight(int idFlight) {
        this.idFlight = idFlight;
    }

    public Flight(int idFlight, String origin, String destination, LocalTime departure, LocalTime arrival, int placesAvailable, double returnPercentage, double priceTickets, Pilot pilot, Plane planeused) {
        this.idFlight = idFlight;
        this.origin = origin;
        this.destination = destination;

        Duration duration1 = Duration.between(departure, arrival);
        double durationInHours = (double) duration1.toMillis() / (60 * 60 * 1000);


        this.duration = durationInHours;
        this.departure = departure;
        this.arrival = arrival;
        this.pilot = pilot;
        this.planeused = planeused;
        this.placesAvailable = placesAvailable;
        this.returnPercentage = returnPercentage;
        this.priceTickets = priceTickets;
    }

    ArrayList<Pilot> pilotlist = Pilot.pilotlist();

    public static Collection<Flight> flightcolect() {
        Collection<Flight> flightList = new ArrayList<>();
        LocalTime arrival1 = LocalTime.of(23, 0);
        LocalTime departure1 = LocalTime.of(0, 0);
        LocalTime arrival2 = LocalTime.of(12, 0);
        LocalTime departure2 = LocalTime.of(6, 0);
        LocalTime arrival3 = LocalTime.of(20, 0);
        LocalTime departure3 = LocalTime.of(8, 0);
        Flight flight1 = new Flight(1, "Madrid", "Barcelona", departure1, arrival1, 23, 50, 25, Pilot.getPilotByName(Pilot.pilotlist(), 1), Plane.getPlanebyName(Plane.planelist(), "Boeing 747"));
        Flight flight2 = new Flight(2, "Barcelona", "Paris", departure2, arrival2, 153, 40, 20, Pilot.getPilotByName(Pilot.pilotlist(), 2), Plane.getPlanebyName(Plane.planelist(), "Airbus A380"));
        Flight flight3 = new Flight(3, "Madrid", "London", departure3, arrival3, 243, 50, 28, Pilot.getPilotByName(Pilot.pilotlist(), 3), Plane.getPlanebyName(Plane.planelist(), "Embraer E190"));

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);

        return flightList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;
        return idFlight == flight.idFlight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFlight);
    }

    public static ArrayList flightlist() {
        ArrayList<Flight> flightlist = new ArrayList<>();
        LocalTime arrival1 = LocalTime.of(23, 0);
        LocalTime departure1 = LocalTime.of(0, 0);
        LocalTime arrival2 = LocalTime.of(12, 0);
        LocalTime departure2 = LocalTime.of(6, 0);
        LocalTime arrival3 = LocalTime.of(20, 0);
        LocalTime departure3 = LocalTime.of(8, 0);
        Flight flight1 = new Flight(1, "Madrid", "Barcelona", departure1, arrival1, 23, 50, 25, Pilot.getPilotByName(Pilot.pilotlist(), 1), Plane.getPlanebyName(Plane.planelist(), "Boeing 747"));
        Flight flight2 = new Flight(2, "Barcelona", "Paris", departure2, arrival2, 153, 40, 20, Pilot.getPilotByName(Pilot.pilotlist(), 2), Plane.getPlanebyName(Plane.planelist(), "Airbus A380"));
        Flight flight3 = new Flight(3, "Madrid", "London", departure3, arrival3, 243, 50, 28, Pilot.getPilotByName(Pilot.pilotlist(), 3), Plane.getPlanebyName(Plane.planelist(), "Embraer E190"));

        flightlist.add(flight1);
        flightlist.add(flight2);
        flightlist.add(flight3);


        return flightlist;
    }


    public static void menuMod() {
        System.out.println("1.ID");
        System.out.println("2.Origin");
        System.out.println("3.Destination");
        System.out.println("4.Departure time");
        System.out.println("5.Arrival time");
        System.out.println("6.places available");
        System.out.println("7.return percentaje");
        System.out.println("8.price tickets");
        System.out.println("9.Pilot");
        System.out.println("10. planes");

    }


    public void showinfoMini() {
        System.out.println("------------");
        System.out.println("Flight info");
        System.out.print("Id: " + this.idFlight + "  ");
        System.out.print("Origin: " + this.origin + "  ");
        System.out.println("Destination: " + this.destination + "  ");

        System.out.print("Departure: " + this.departure + "  ");
        System.out.print("Arrival: " + this.arrival + "  ");
        System.out.println("Duration: " + this.duration + "  ");
        System.out.print("Places available: " + this.placesAvailable + "  ");
        System.out.print("Return perentage: " + this.returnPercentage + "  ");
        System.out.println("Price tickets: " + this.priceTickets + "  ");
        System.out.println("");

    }

    public void showinfofPilot() {
        System.out.println("");
        System.out.println("   ------------");

        System.out.println("   Flight info");
        System.out.println("   Id: " + this.idFlight + "  ");
        System.out.println("   Origin: " + this.origin + "  ");
        System.out.println("   Destination: " + this.destination + "  ");

        System.out.println("   Departure: " + this.departure + "  ");
        System.out.println("   Arrival: " + this.arrival + "  ");
        System.out.println("   Duration: " + this.duration + "  ");
        System.out.println("   Places available: " + this.placesAvailable + "  ");
        System.out.println("   Return perentage: " + this.returnPercentage + "  ");
        System.out.println("   Price tickets: " + this.priceTickets + "  ");


        System.out.println("   ------------");
        System.out.println("");
    }

    public void showFinfo() {

        System.out.println("   ------------");
        System.out.println("   Flight info");
        System.out.println("   Id: " + this.idFlight + "  ");
        System.out.println("   Origin: " + this.origin + "  ");
        System.out.println("   Destination: " + this.destination + "  ");

        System.out.println("   Departure: " + this.departure + "  ");
        System.out.println("   Arrival: " + this.arrival + "  ");
        System.out.println("   Duration: " + this.duration + "  ");
        System.out.println("   Places available: " + this.placesAvailable + "  ");
        System.out.println("   Return perentage: " + this.returnPercentage + "  ");
        System.out.println("   Price tickets: " + this.priceTickets + "  ");

        this.pilot.showPilotData();
        this.planeused.showPlaneData();


    }

    @Override
    public String toString() {
        return "Flight{" +
                "idFlight=" + idFlight +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", duration=" + duration +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", placesAvailable=" + placesAvailable +
                ", returnPercentage=" + returnPercentage +
                ", priceTickets=" + priceTickets +
                ", pilot=" + pilot +
                ", planeused=" + planeused +
                '}';
    }

    public int getIdFlight() {
        return this.idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalTime arrival) {
        this.arrival = arrival;
    }

    public Pilot getPilot() {
        return this.pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Plane getPlaneused() {
        return this.planeused;
    }

    public void setPlaneused(Plane planeused) {
        this.planeused = planeused;
    }

    public int getPlacesAvailable() {
        return this.placesAvailable;
    }

    public void setPlacesAvailable(int placesAvailable) {
        this.placesAvailable = placesAvailable;
    }

    public double getReturnPercentage() {
        return this.returnPercentage;
    }

    public void setReturnPercentage(double returnPercentage) {
        this.returnPercentage = returnPercentage;
    }

    public double getPriceTickets() {
        return this.priceTickets;
    }

    public void setPriceTickets(double priceTickets) {
        this.priceTickets = priceTickets;
    }
}


