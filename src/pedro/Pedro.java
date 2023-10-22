package pedro;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Pedro {


    public static int menureturnint(String[] op) {
        int r;
        Scanner data = new Scanner(System.in);
        boolean validOption;

        do {
            validOption = true;
            for (int i = 0; i < op.length; i++) {
                System.out.println(i+1 + "." + op[i]);
            }

            r =  Pedro.checkInt();

            for (int i = 0; i < op.length; i++) {
                if (r == i+1) {
                    validOption = true;
                    break;
                } else if (r ==0) {
                    validOption = false;
                    break;
                } else {
                    validOption = false;
                }
            }

            if (!validOption) {
                System.out.println("Invalid option , try again");
            }
        } while (!validOption);

        return r;
    }




public static LocalDate checkDate(){
    boolean error = false;
LocalDate date= null;

    do {
        try {
            date = inputLocalDate();
            error = true;
        } catch (Exception e) {
            System.out.println("Date have to be formatted dd/MM/yyyy  ");
        }
    } while(!error);

    return date;

}
public static LocalTime checkTime(){
    boolean error = false;
    LocalTime t1= null;

    do {
        try {
            t1 = inputLocalTime();
            error = true;
        } catch (Exception e) {
            System.out.println("Time have to be formatted as HH:MM (hour and minutes)  ");
        }
    } while(!error);

    return t1;




}
        public static int checkInt(){

            boolean error = false;
            int i = 0;

            do {
                try {
                    i = inputInt();
                    error = true;
                } catch (Exception e) {
                    System.out.println("Only numbers allowed, try again");
                }
            } while(!error);

            return i;
        }

        public static String checkString(){

            boolean error = false;
            String i = "";

            do {
                try {
                    i = inputString();
                    error = true;
                } catch (Exception e) {
                    System.out.println("Only Strings Allowed , try again");
                }
            } while(!error);

            return i;

        }
        public static char checkChar(){

            boolean error = false;
            char i = 0;

            do {
                try {
                    i = inputChar();
                    error = true;
                } catch (Exception e) {
                    System.out.println("Only chars allowed, try again");
                }
            } while(!error);

            return i;

        }
        public static Float checkFloat(){

            boolean error = false;
            float i = 0;

            do {
                try {
                    i = inputFloat();
                    error = true;
                } catch (Exception e) {
                    System.out.println("Only floats allowed , try again");
                }
            } while(!error);

            return i;

        }
        public static double checkDouble(){

            boolean error = false;
            double i = 0;

            do {
                try {
                    i = inputDouble();
                    error = true;
                } catch (Exception e) {
                    System.out.println("Only doubles allowed, try again");
                }
            } while(!error);

            return i;
        }
    public static boolean checkBoolean(){

        boolean error = false;
        boolean i = false;

        do {
            try {
                i = inputBoolean();
                error = true;
            } catch (Exception e) {
                System.out.println("-- Input is not correct, try again: --");
            }
        } while(!error);

        return i;
    }



    private static int inputInt() {
            return new Scanner(System.in).nextInt();
        }

        private static String inputString() {
            return new Scanner(System.in).next();
        }

        private static char inputChar() {
            return new Scanner(System.in).next().charAt(0);
        }

        private static float inputFloat() {
            return new Scanner(System.in).nextFloat();
        }

        private static double inputDouble() {
            return new Scanner(System.in).nextDouble();
        }

    private static LocalDate inputLocalDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce a date (dd/MM/yyyy):");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(input, formatter);
        return date;
    }
    private static LocalTime inputLocalTime(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce hour");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time1 = LocalTime.parse(input, formatter);

        return time1;
    }

    private static boolean inputBoolean(){
        return new Scanner(System.in).nextBoolean();
    }

/*
  private static void returnTickets(ArrayList<Flight> flightlist, ArrayList<User> userlist,ArrayList<Ticket>ticketlist) {
        Scanner data = new Scanner(System.in);
        double price;
        double returnn;
        double finalprice = 0;
        System.out.println("In which flight do you want to return tickets");
        int id = data.nextInt();
        System.out.println("How many do u want to return?");
        int numtickets = data.nextInt();
        //  if (numtickets >  )
        //mirar como hacer que no devuelva mas de las que compra xd

        for (int i = 0; i < flightlist.size(); i++) {
            Flight flight = flightlist.get(i);
            price = flight.getPriceTickets();
            returnn = flight.getReturnPercentage() / 100;

            flight.setPlacesAvailable(flight.getPlacesAvailable() + numtickets);
            double h = price * numtickets;
            finalprice = h * returnn;


        }
        System.out.println("Money returned " + finalprice);

    }

 */



public void buscarenarrayconwhile(){
/*
    while(i < userlist.size() && !found) {
        User u = userlist.get(i);
        if (u.getUser().equalsIgnoreCase(user)) {
            System.out.println("correcto titan");
            found = true;

        } else {
            System.out.println("No username found on the array.");
        }

        i++;
    }

 */
}












}
