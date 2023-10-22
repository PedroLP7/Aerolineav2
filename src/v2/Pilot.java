package v2;



import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pilot {


    private String name;
    private String LastsNames;
    private String dni;
    private String phoneNum;
    private int idPilot;
    private LocalDate birthdate;

    public Pilot(String name, String lastsNames, String dni, String phoneNum, int idPilot, LocalDate birthdate) {
        this.name = name;
        LastsNames = lastsNames;
        this.dni = dni;
        this.phoneNum = phoneNum;
        this.idPilot = idPilot;
        this.birthdate = birthdate;
    }



    public static ArrayList pilotlist(){
        ArrayList<Pilot> pilotList = new ArrayList<>();
        LocalDate datebirth = LocalDate.of(1995, 8, 21);
        LocalDate datebirth2 = LocalDate.of(1995, 9, 22);
        LocalDate datebirth3 = LocalDate.of(1996, 4, 1);
        LocalDate datebirth4 = LocalDate.of(1976, 4, 1);
        Pilot pilot1;
        pilot1 = new Pilot("Pedro", "Lopez Perez", "41008373V", "66468806", 1, datebirth);
        Pilot pilot2 = new Pilot("Juan", "Gonzalez Martinez", "41008374V", "66468807", 2, datebirth2);
        Pilot pilot3 = new Pilot("Antonio", "Rodriguez Fernandez", "41008375V", "66468808", 3, datebirth3);
        Pilot pilot4 = new Pilot("Prueba","JESUS TAN","363892N","665437392",4,datebirth4);

        pilotList.add(pilot1);
        pilotList.add(pilot2);
        pilotList.add(pilot3);
        pilotList.add(pilot4);


        return pilotList;

    }




    public static Map<Integer, String> getFlightPilotMap() {
        Map<Integer, String> flightPilotMap = new HashMap<>();

        flightPilotMap.put(1, "41008373V");
        flightPilotMap.put(2, "41008374V");
        flightPilotMap.put(3, "41008375V");
        flightPilotMap.put(4,"363892N");
        return flightPilotMap;
    }



Map<Integer,String>flightPilotMap=getFlightPilotMap();






    private boolean verificarDisponibilitatPilot(String pilot) {
        for (String assignatPilot : flightPilotMap.values()) {
            if (assignatPilot.equals(pilot)) {
                return false;
            }
        }
        return true;
    }

    public static void showPilots(ArrayList<Pilot> pilotslist) {
        for (int i = 0; i < pilotslist.size(); i++) {

            Pilot pilot = pilotslist.get(i);
            System.out.println(pilot);


        }

    }
    public static Pilot getPilotByName(ArrayList<Pilot> pilotList, int idPilot) {
        for (Pilot pilot : pilotList) {
            if (pilot.getIdPilot()==idPilot ){
                return pilot;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastsNames() {
        return this.LastsNames;
    }

    public void setLastsNames(String lastsNames) {
        LastsNames = lastsNames;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getIdPilot() {
        return this.idPilot;
    }

    public void setIdPilot(int idPilot) {
        this.idPilot = idPilot;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }


    public void showPilotData() {
        System.out.println("   ------------");
        System.out.println("   PILOT INFO: ");
        System.out.print("   Name: " + this.name + "  ");
        System.out.print("   Last Names: " + this.LastsNames + "  ");
        System.out.print("   DNI: " + this.dni + "  ");
        System.out.print("   Phone Number: " + this.phoneNum + "  ");
        System.out.print("   ID Pilot: " + this.idPilot + "  ");
        System.out.println("   Birthdate: " + this.birthdate + "  ");


    }


    @Override
    public String toString() {
        return "Pilot :  " +
                "Name:" + name +
                " LastsNames:" + LastsNames +
                " Dni:  " + dni +
                " PhoneNum:  " + phoneNum +
                " IdPilot:  " + idPilot +
                " Birthdate:  " + birthdate
                ;
    }


}
