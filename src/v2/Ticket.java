package v2;

import java.util.ArrayList;

public class Ticket {
    private static int contador = 0;
    private int transactionID;
    private String userid;
    private int flightid;
    private int tickets;
    private double returnprice;
private double price;

    public int getTransactionID() {
        return transactionID;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Ticket.contador = contador;
    }


    public Ticket(String userid, int flightid, int numTickets,double price,double returnprice) {
        contador++;
        this.transactionID = contador;
        this.userid = userid;
        this.flightid = flightid;
        this.tickets = numTickets;
        this.price =price;
        this.returnprice = returnprice;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }


    public static ArrayList<Ticket> ticketlist() {
        ArrayList<Ticket> ticketlist = new ArrayList<>();


        return ticketlist;

    }

    @Override
    public String toString() {
        return "Ticket{" +
                "transactionID=" + this.transactionID +
                ", userid='" + this.userid + '\'' +
                ", flightid=" + this.flightid +
                ", tickets=" + this.tickets +
                '}';
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public double getReturnprice() {
        return returnprice;
    }

    public void setReturnprice(double returnprice) {
        this.returnprice = returnprice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void showTicket() {

        System.out.println("----------");
        System.out.println("Ticket  ");
        System.out.println("transaction id : " + this.transactionID);
        System.out.println("User id :" + this.userid);
        System.out.println("Flight id :" + this.flightid);
        System.out.println("Num tickets :" + this.tickets);
        System.out.println("Price : "+this.price);
        System.out.println("Return  :"+this.returnprice+"%");
        System.out.println("----------");
        System.out.println("");


    }

}
