package v2;



import pedro.Pedro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Plane implements Comparable<Plane> {


    private  String name;
    private LocalDate fabricationdate;
    int fuelcapacity;
    int seatcapacity;  //tiene que ir preconfigurada
    public Plane(String name, LocalDate fabricationdate, int fuelcapacity, int seatcapacity) {
        this.name = name;
        this.fabricationdate = fabricationdate;
        this.fuelcapacity = fuelcapacity;
        this.seatcapacity = seatcapacity;
    }

// SECCION COLECCIONES

    public static Collection<Plane> planecolection() {
        Collection<Plane> planeList = new ArrayList<>();
        LocalDate date1 = LocalDate.of(1990, 1, 22);
        LocalDate date2 = LocalDate.of(1995, 8, 4);
        LocalDate date3 = LocalDate.of(1965, 6, 11);
        Plane plane1 = new Plane("Boeing 747", date1, 200, 15000);
        Plane plane2 = new Plane("Airbus A380", date2, 400, 80);
        Plane plane3 = new Plane("Embraer E190", date3, 100, 200);
        Plane plane4 = new Plane("Embraer E190", date3, 100, 200);

        planeList.add(plane1);
        planeList.add(plane2);
        planeList.add(plane3);
        planeList.add(plane4);
        return planeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return fuelcapacity == plane.fuelcapacity &&
                seatcapacity == plane.seatcapacity &&
                name.equals(plane.name) &&
                Objects.equals(fabricationdate, plane.fabricationdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fabricationdate, fuelcapacity, seatcapacity);
    }

    @Override
    public int compareTo(Plane otherPlane) {
        // Comparación basada en los criterios de ordenación especificados
        if (this.seatcapacity != otherPlane.seatcapacity) {
            return Integer.compare(otherPlane.seatcapacity, this.seatcapacity);
        }
        if (this.fuelcapacity != otherPlane.fuelcapacity) {
            return Integer.compare(otherPlane.fuelcapacity, this.fuelcapacity);
        }
        return this.name.compareTo(otherPlane.name);
    }




















    public static ArrayList planelist(){

        ArrayList<Plane> planeList = new ArrayList<>();
        LocalDate date1 = LocalDate.of(1990, 1, 22);
        LocalDate date2 = LocalDate.of(1995, 8, 04);
        LocalDate date3 = LocalDate.of(1965, 6, 11);
        Plane plane1 = new Plane("Boeing 747", date1, 200, 150);
        Plane plane2 = new Plane("Airbus A380", date2, 400, 8);
        Plane plane3 = new Plane("Embraer E190", date3, 100, 80);
        planeList.add(plane1);
        planeList.add(plane2);
        planeList.add(plane3);

        return planeList;

    }


    public static Plane getPlanebyName(ArrayList<Plane> planelist, String name) {
        for (Plane plane : planelist) {
            if (plane.getName().equalsIgnoreCase(name)){
                return plane;
            }
        }
        return null;
    }


    public static void showPlanes(ArrayList<Plane> planeslist) {
        for (int i = 0; i < planeslist.size(); i++) {

            Plane plane = planeslist.get(i);
            System.out.println(plane);

        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFabricationdate() {
        return this.fabricationdate;
    }

    public void setFabricationdate(LocalDate fabricationdate) {
        this.fabricationdate = fabricationdate;
    }

    public int getFuelcapacity() {
        return this.fuelcapacity;
    }

    public void setFuelcapacity(int fuelcapacity) {
        this.fuelcapacity = fuelcapacity;
    }

    public int getSeatcapacity() {
        return this.seatcapacity;
    }

    public void setSeatcapacity(int seatcapacity) {
        this.seatcapacity = seatcapacity;
    }

    public void showPlaneData() {
        System.out.println("   ------------");
        System.out.println("   Plane Info: ");
        System.out.print("   Name: " + this.name+"  ");
        System.out.print("   Fabrication date: " + this.fabricationdate+"  ");
        System.out.print("   Fuel capacity: " + this.fuelcapacity+"  ");
        System.out.println("   Seat capacity: " + this.seatcapacity+"  ");
        System.out.println("   ------------");

    }

    @Override
    public String toString() {

        return "Plane :  " +
                "Name:" + name  +
                " Fabricationdate :" + fabricationdate +
                " Fuel Capacity:  "+fuelcapacity +
                " Seat Capacity:  " + seatcapacity

                ;

    }
}

