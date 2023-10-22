package v2;


import pedro.Pedro;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> userlist = User.userlist();
        ArrayList<Plane> planelist = Plane.planelist();
        ArrayList<Pilot> pilotlist = Pilot.pilotlist();
        ArrayList<Flight> flightlist = Flight.flightlist();
        ArrayList<Ticket> ticketlist = Ticket.ticketlist();


        Collection<Plane>planeColection=Plane.planecolection();
        Collection<Flight> flightCollection=Flight.flightcolect();


        /*

    Crear una collection de tipus Map on emmagatzemareu els codis dels vols
   (com a clau) i a quin pilot (DNI) s’ha assignat (com a valor).

>> Crea un mètode per poder consultar, fent servir
 el mapa, a quin pilot se li ha assignat un determinat vol.

>> Durant el mètode de creació de vols,
 abans d’assignar un pilot, fes servir el mapa per verificar si
 aquest pilot no està ja assignat a un altre vol. En cas afirmatiu, mostrar un avís
  a l’usuari per fer que triï un pilot diferent.

         */




        //CREACION MAP
        Map<Integer, String> flightPilotMap=Pilot.getFlightPilotMap();




        boolean exit = false;
        while (exit == false) {
            Scanner data = new Scanner(System.in);
            int option = menu();


            switch (option) {

                case 1:
                    User userwork = login(userlist);
                    int optionm;
                    if (userwork.isAdmin()) {
                        // menu admin
                        boolean exitm = false;
                        while (!exitm) {
                            optionm = menuadmin();

                            switch (optionm) {

                                case 1:
                                    createFlight(flightlist, pilotlist, planelist);


                                    break;
                                case 2:
                                    // RECORDATORIO LOS V2 SON USANDO LAS COLECCIONES
                                    showFlightInfov2(flightCollection);
                                  //  showFlightInfo(flightlist);
                                    break;
                                case 3:
                                    modifyFlight(flightlist, pilotlist, planelist); // modify flight info  usar el getdatafligt
                                    break;
                                case 4:
                                    //modificacion colecciones
                                    deleteFlightv2(flightCollection);
                                  //  deleteFlight(flightlist);
                                    break;
                                case 5:
                                    System.out.println("ORDENADO CON EL SORT:");
                                    showPlanesv2(planeColection);
                                    System.out.println("---------------");
                                    System.out.println("con arraylist sin mas");
                                    showPlanes(planelist);
                                    break;
                                case 6:
                                    //prueba
                                    System.out.println(getAssignedPilot(2,flightPilotMap));
                                  //  showPilots(pilotlist);
                                    break;

                                case 0:
                                    exitm = true;
                                    break;

                            }


                        }
                    } else if (!userwork.isAdmin()) {
                        // menu client
                        boolean exitc = false;
                        while (!exitc) {
                            int optionc;
                            optionc = menuClient();

                            switch (optionc) {
                                case 1:
                                    showInfoplusPilot(flightlist);
                                    //   enseña todos los vuelos

                                    break;
                                case 2:   // comprar billetes

                                    showALLFlightInfo(flightlist);
                                    buyTickets(flightlist, userlist, userwork, ticketlist);

                                    break;
                                case 3:
                                    returnTickets(flightlist, userwork, ticketlist);          // anular billetes

                                    break;
                                case 0:
                                    exitc = true;
                                    break;
                            }
                        }


                    }
                    break;


                case 2:
                    createUser(userlist);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exit");
            }
        }


    }

    //FUNCION QUE MIRA SI TIENE ALGUN PILOTO ASIGNADO EN EL MAP
    public static String getAssignedPilot(int flightNumber, Map<Integer, String> flightPilotMap) {
        if (flightPilotMap.containsKey(flightNumber)) {
            return flightPilotMap.get(flightNumber);
        } else {
            return "No s'ha assignat cap pilot a aquest vol.";
        }
    }
    private static void buyTickets(ArrayList<Flight> flightList, ArrayList<User> userlist, User userwork, ArrayList<Ticket> ticketlist) {  // HAY QUE ACABAR ESTA FUNCION


        boolean found = false;
        Scanner data = new Scanner(System.in);
        System.out.println("In which flight do you want to buy tickets?");
        int id = data.nextInt();
        int l = 0;
        for (int i = 0; i < flightList.size(); i++) {

            Flight flight = flightList.get(i);
            if (flight.getIdFlight() == id) {

                found = true;

                System.out.println("How many tickets do you want to buy?");
                int numTickets = data.nextInt();

                if (numTickets > flight.getPlacesAvailable()) {
                    System.out.println("You cant buy " + numTickets + " tickets");
                    System.out.println("There are " + flight.getPlacesAvailable() + " tickets available.");
                } else {

                    double ticketPrice = ticketsprice(flight.getPriceTickets(), numTickets);
                    System.out.println("Price : " + ticketPrice);
                    int newPlacesAvailable = flight.getPlacesAvailable() - numTickets;
                    System.out.println("Places available at the moment: " + newPlacesAvailable);
                    flight.setPlacesAvailable(newPlacesAvailable);


                    for (int j = 0; j < userlist.size(); j++) {
                        User user = userlist.get(j);
                        int res = user.getTicketsOwned() + numTickets;
                        user.setTicketsOwned(res);
                    }

                    Ticket t1 = new Ticket(userwork.getUser(), flight.getIdFlight(), numTickets, ticketPrice, flight.getReturnPercentage());

                   /*
                    t1.setFlightid(flight.getIdFlight());
                    t1.setUserid(userwork.getUser());
                    t1.setTickets(numTickets);     */
                    ticketlist.add(t1);



                  /*  for (int j = 0; j <ticketlist.size() ; j++) {
                        Ticket t = ticketlist.get(j);
                        System.out.println(t.toString());


                    }

                   */
                }


                break;
            }
        }

        if (!found) {
            System.out.println("There is no flight with the ID you are looking for.");
        }
    }

    public static void showUsersData(ArrayList<User> userlist) {


    }// SEGUIR AAQUI MAÑANA


    private static void returnTickets(ArrayList<Flight> flightlist, User user, ArrayList<Ticket> ticketlist) {
        // si no hay tickets que no entre aqui
        Scanner data = new Scanner(System.in);
        Ticket ti = null;
        for (int i = 0; i < ticketlist.size(); i++) {
            ti = ticketlist.get(i);
            if (ti.getUserid().equalsIgnoreCase(user.getUser())) {
                ti.showTicket();
            }
        }
        System.out.println("Introduce the transaction id that u want to cancel");
        int id = data.nextInt();
        Ticket t = null;
        int i = 0;
        boolean ticketFound = false;
        while (i < ticketlist.size() && !ticketFound) {
            t = ticketlist.get(i);
            if (t.getTransactionID() == id) {
                ticketFound = true;
            } else {
                i++;
            }
        }

        if (ticketFound) {
            System.out.println("how many tickets do u want to return?");
            int tickets = data.nextInt();

            for (int j = 0; j < flightlist.size(); j++) {
                Flight f = flightlist.get(j);
                if (f.getIdFlight() == t.getTransactionID()) { // cambiar el if por un if id == t.getidtransaction y probar
                    f.setPlacesAvailable(f.getPlacesAvailable() + tickets);
                    t.setTickets(t.getTickets() - tickets);


                    double h = t.getPrice();
                    double finalprice = h * (t.getReturnprice() / 100);
                    double ticketPrice = ticketsprice(f.getPriceTickets(), tickets);
                    t.setPrice(t.getPrice() - tickets * f.getPriceTickets());

                    System.out.println("refund of " + finalprice);
                    if (t.getTickets() == 0) {
                        ticketlist.remove(t);  // seguir aqui FALTA GESTIONAR EL DINERO QUE DEVUELVE
                        // , PUEDES PONER EN TICKET EL DINERO QUE DEVUELVE POR UNIDAD Y TRABAJAR CON ESO
                    } else {
                        System.out.println();
                    }
                }
            }


        } else {
            System.out.println("There are no tickets with that id, try again");
        }


    }


    public static double ticketsprice(double price, int numtickets) {


        double finalp = 0;
        finalp = price * (double) numtickets;
        return finalp;
    }

    private static void showALLFlightInfo(ArrayList<Flight> flightlist) {
        for (int i = 0; i < flightlist.size(); i++) {
            Flight flight = flightlist.get(i);

            flight.showinfoMini();


        }
    }

    private static void showInfoplusPilot(ArrayList<Flight> flightlist) {

        for (int i = 0; i < flightlist.size(); i++) {
            Flight flight = flightlist.get(i);

            flight.showinfofPilot();

        }
    }

    public static void modifyFlight(ArrayList<Flight> flightlist, ArrayList<Pilot> pilotList, ArrayList<Plane> planelist) {
        int id;
        Scanner data = new Scanner(System.in);
        System.out.println("what id do u wanna find? ");
        id = data.nextInt();
        Flight flight = findFlightId(id, flightlist);
        System.out.println("what do u want to modify?");
        Flight.menuMod();
        int op = data.nextInt();
        Scanner mod = new Scanner(System.in);
        switch (op) {

            case 1:
                System.out.println("current id  : " + flight.getIdFlight());
                System.out.println("Introduce new value ");
                int idn = mod.nextInt();
                flight.setIdFlight(idn);
                break;
            case 2:
                String origin = data.nextLine();
                System.out.println("Current Origin  : " + flight.getOrigin());
                System.out.println("Introduce new value ");
                origin = mod.nextLine();
                flight.setOrigin(origin);
                break;

            case 3:
                System.out.println("Current Destination  : " + flight.getDestination());
                System.out.println("Introduce new value ");
                String destination = mod.nextLine();
                flight.setDestination(destination);
                break;
            case 4:
                Scanner sc = new Scanner(System.in);
                System.out.println("Current Departure time  : " + flight.getDeparture());
                System.out.println("Introduce new value ");
                System.out.print("Hora: ");
                int hora = sc.nextInt();
                System.out.print("Minutos: ");
                int minutos = sc.nextInt();
                LocalTime departure = LocalTime.of(hora, minutos);
                flight.setDeparture(departure);
                calculateDuration(flight);
                break;
            case 5:
                Scanner sca = new Scanner(System.in);
                System.out.println("Current Arrival time  : " + flight.getArrival());
                System.out.println("Introduce new value ");
                System.out.print("Hora: ");
                int horas = sca.nextInt();
                System.out.print("Minutos: ");
                int minutoss = sca.nextInt();
                LocalTime arrivals = LocalTime.of(horas, minutoss);
                flight.setArrival(arrivals);
                calculateDuration(flight);
                break;


            case 6:

                System.out.println("Current places available  : " + flight.getPlacesAvailable());
                System.out.println("Introduce new value ");
                int placesn = mod.nextInt();
                flight.setPlacesAvailable(placesn);
                break;

            case 7:

                System.out.println("Current return percentaje : " + flight.getReturnPercentage());
                System.out.println("Introduce new value ");
                int returnp = mod.nextInt();
                flight.setPlacesAvailable(returnp);
                break;
            case 8:
                System.out.println("Current price tickets: " + flight.getPriceTickets());
                System.out.println("Introduce new value ");
                int pricen = mod.nextInt();
                flight.setPriceTickets(pricen);
                break;

            case 9:
                System.out.println("Current pilot : " + flight.getPilot());
                System.out.println("Introduce new value ");
                System.out.println("Choose one pilot for the flight");
                for (int i = 0; i < pilotList.size(); i++) {
                    System.out.println(i + 1 + ". " + pilotList.get(i).toString());
                }
                int chosenpilot = data.nextInt();
                Pilot pilot = pilotList.get(chosenpilot - 1);
                flight.setPilot(pilot);
                break;

            case 10:
                System.out.println("Current pilot : " + flight.getPlaneused());
                System.out.println("Introduce new value ");
                System.out.println("Choose one pilot for the flight");
                for (int i = 0; i < planelist.size(); i++) {
                    System.out.println(i + 1 + ". " + planelist.get(i).toString());
                }
                int chosenplane = data.nextInt();
                Plane plane = planelist.get(chosenplane - 1);
                flight.setPlaneused(plane);


                break;


        }


    }


    public static User login(ArrayList<User> userlist) {
        boolean login = false;

        while (!login) {
            Scanner data = new Scanner(System.in);

            boolean foundu = false;
            int y = 0;
            System.out.println("Introuce your user");
            String us = data.nextLine();
            while (y < userlist.size() && !foundu) {
                User u = userlist.get(y);
                if (u.getUser().equalsIgnoreCase(us)) {

                    foundu = true;
                }
                y++;
            }

            int x = 0;

            boolean foundp = false;
            System.out.println("Introduce your password");
            String pw = data.nextLine();
            int z = 0;
            while (z < userlist.size() && !foundp) {
                User p = userlist.get(z);
                if (p.getPassword().equalsIgnoreCase(pw)) {

                    foundp = true;
                }
                z++;
            }
            if (foundp == true && foundu == true) {

                System.out.println("login correcto ");
                login = true;
                return userlist.get(y - 1);
            } else {
                System.out.println("Error , type again your credentials");

            }

        }
        return null;
    }

    public static void createUser(ArrayList<User> userlist) {
        Scanner data = new Scanner(System.in);
        System.out.println("New user: ");
        String userdata = data.nextLine();
        System.out.println("Password :");
        String passwordata = data.nextLine();
        System.out.println("Is admin?");
        Boolean ad = data.nextBoolean();



        User user = new User();
        user.setUser(userdata);
        user.setPassword(passwordata);
        user.setAdmin(ad);
        userlist.add(user);


    }

    public static void createFlight(ArrayList<Flight> flightlist, ArrayList<Pilot> pilotList, ArrayList<Plane> planelist) {
        Flight flight = readFlightData(pilotList, planelist);
        flightlist.add(flight);
        calculateDuration(flight);

    }

    public static void calculateDuration(Flight flight) {
        Duration duration = Duration.between(flight.getDeparture(), flight.getArrival());
        double durationInHours = duration.toMinutes() / 60.0;
        flight.setDuration(durationInHours);
    }

public static void showFlightInfov2(Collection<Flight>flightCollection){
    System.out.println("What flight do you want to see info about? Introduce the id:");
    Scanner data = new Scanner(System.in);
    int id = data.nextInt();


    Flight flight = findFlightIdv2(id, flightCollection);
    if (flight != null) {
        flight.showFinfo();

    } else {
        System.out.println("There is no flight with the id you are looking for.");
    }
}
    public static void showFlightInfo(ArrayList<Flight> flightlist) {
        System.out.println("What flight do you want to see info about? Introduce the id:");
        Scanner data = new Scanner(System.in);
        int id = data.nextInt();


        Flight flight = findFlightId(id, flightlist);
        if (flight != null) {
            flight.showFinfo();

        } else {
            System.out.println("There is no flight with the id you are looking for.");
        }
    }
    public static Flight findFlightIdv2(int id, Collection<Flight> flightList) {
        Flight searchFlight = new Flight(id);
        for (Flight flight : flightList) {
            if (flight.equals(searchFlight)) {
                return flight;
            }
        }
        return null;
    }
    public static Flight findFlightId(int id, ArrayList<Flight> flightList) {
        for (int i = 0; i < flightList.size(); i++) {
            Flight flight = flightList.get(i);
            if (flight.getIdFlight() == id) {
                return flight;
            }
        }
        return null;
    }


    private static int menu() {
        Scanner data = new Scanner(System.in);
        int n;
        System.out.println("1. Login");
        System.out.println("2. SignIn");
        System.out.println("3. Exit");
        n = data.nextInt();
        return n;

    }

    public static Flight readFlightData(ArrayList<Pilot> pilotList, ArrayList<Plane> planelist) {
        Scanner data = new Scanner(System.in);
        Flight flight = new Flight();

        System.out.println("Introduce flights Id");
        int id = data.nextInt();
        data.nextLine();
        flight.setIdFlight(id);
        System.out.print("Introduce origin ");
        String origin = data.nextLine();
        flight.setOrigin(origin);
        System.out.println();
        System.out.println("Introduce destination: ");
        String destination = data.nextLine();
        flight.setDestination(destination);
        System.out.println();
        System.out.println("Introduce departure: ");
        String departure1 = data.nextLine();
        LocalTime departure = LocalTime.parse(departure1, DateTimeFormatter.ofPattern("HH.mm"));
        flight.setDeparture(departure);
        System.out.println("Introduce arrival: ");
        String arrival1 = data.nextLine();
        LocalTime arrival = LocalTime.parse(arrival1, DateTimeFormatter.ofPattern("HH.mm"));
        flight.setArrival(arrival);


        System.out.println("Introduce places available");
        int plac = data.nextInt();
        flight.setPlacesAvailable(plac);
        System.out.println("Introduce return percentage");
        double ret = data.nextInt();
        flight.setReturnPercentage(ret);
        System.out.println("Introduce tickets price");
        double price = data.nextDouble();
        flight.setPriceTickets(price);


        System.out.println("Choose one pilot for thr flight");
        for (int i = 0; i < pilotList.size(); i++) {
            System.out.println(i + 1 + ". " + pilotList.get(i).toString());
        }
        int chosenpilot = data.nextInt();
        Pilot pilot = pilotList.get(chosenpilot - 1);
        flight.setPilot(pilot);


        System.out.println("Choose one plane for your flight");
        for (int i = 0; i < planelist.size(); i++) {
            System.out.println(i + 1 + ". " + planelist.get(i).toString());
        }
        int chosenplane = data.nextInt();
        Plane plane = planelist.get(chosenplane - 1);
        flight.setPlaneused(plane);


        return flight;
    }
    public static void deleteFlightv2(Collection<Flight> flightList) {
        Scanner data = new Scanner(System.in);
        int flightId;

        while (true) {
            System.out.println("Introduce the Flight id you want to delete");
            flightId = data.nextInt();
            boolean flightFound = false;

            Flight flightToDelete = new Flight(flightId);  // Crea un objeto Flight con el flightId proporcionado

            for (Iterator<Flight> iterator = flightList.iterator(); iterator.hasNext(); ) {
                Flight flight = iterator.next();
                if (flight.equals(flightToDelete)) {  // Utiliza el método equals() para comparar el vuelo con el objeto creado
                    iterator.remove();
                    flightFound = true;
                    break;
                }
            }

            if (flightFound) {
                break;
            } else {
                System.out.println("There is no flight with id " + flightId);
            }
        }






    }
    public static void deleteFlight(ArrayList<Flight> flightlist) {

        Scanner data = new Scanner(System.in);
        int flightId;

        while (true) {
            System.out.println("Introduce the Flight id u want to delete");
            flightId = data.nextInt();
            boolean flightFound = false;

            for (int i = 0; i < flightlist.size(); i++) {
                Flight flight = flightlist.get(i);
                if (flight.getIdFlight() == flightId) {
                    flightlist.remove(i);
                    flightFound = true;
                    break;
                }
            }

            if (flightFound) {
                break;
            } else {
                System.out.println("There is no flight with id " + flightId);
            }
        }
    }

    public static int menuadmin() {
        int r;
        Scanner data = new Scanner(System.in);
        System.out.println("1.Create flight");
        System.out.println("2.Show flight info");
        System.out.println("3.Modify flight info");
        System.out.println("4.Delete flight");
        System.out.println("5.Show planes");
        System.out.println("6.Show pilots");
        System.out.println("0.Exit");
        r = data.nextInt();


        return r;
    }
public static void showPlanesv2(Collection<Plane>planeCollection){
    ArrayList<Plane> planeList = new ArrayList<>(planeCollection);
    Collections.sort(planeList);
 //   Collections.sort(planeList,Collections.reverseOrder());

    for (Plane plane : planeList) {
        System.out.println(plane);
    }
}
    public static void showPlanes(ArrayList<Plane> planeslist) {
        for (int i = 0; i < planeslist.size(); i++) {

            Plane plane = planeslist.get(i);
            System.out.println(plane);

        }
    }

    public static void showPilots(ArrayList<Pilot> pilotslist) {
        for (int i = 0; i < pilotslist.size(); i++) {

            Pilot pilot = pilotslist.get(i);
            System.out.println(pilot);


        }

    }


    public static int menuClient() {
        Scanner data = new Scanner(System.in);
        System.out.println("1.Show flight info");
        System.out.println("2.Buy tickets");
        System.out.println("3.Cancel tickets");
        System.out.println("0.Logout");
        int r = data.nextInt();
        return r;

    }












}

