package City;

public class Parking {

    public int x;
    public int y;
    public String location;
    int parkingUnits = 4;
    String id;


    Scooter sco1;
    Scooter sco2;
    Scooter sco3;
    Scooter sco4;

    Scooter[] scooters = {sco1, sco2, sco3, sco4};


    public Parking(int x, int y){
        this.x = x;
        this.y = y;
        this.location = "["+ this.x +"," + this.y + "] ";
        this.id = "P" + x+ 00 + y + (x+y);


    }

    public void addScooter(Scooter scooter){
        this.scooters[0] = sco2;
    }

    public void print(){
        System.out.print(this.location);
    }

    public void report(){
        System.out.println("Parking ID: " + this.id);
        System.out.println("Parking Location: " + this.location);
        System.out.println("------- Scooters -------");
        for (Scooter sco : this.scooters){
            if (sco == null){
                continue;
            }
            System.out.println(sco.toString());
        }

    }
}
