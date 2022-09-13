package City;



import java.util.Random;

public class User {
    String firstName;
    String lastName;
    String username;

    City city;
    public Scooter scooter;

    String premissions;

    public int x;

    public int y;

    
    public String location;
    Random rand = new Random();


    public User(String firstName, String lastName, String username, String premmisions, int x, int y) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.premissions = premmisions;
        this.x = x;
        this.y = y;
        
        this.location = "["+ this.x +"," + this.y + "] ";
    }

    public User(City city){
        int id = rand.nextInt(999);
        this.firstName = "first" + id;
        this.lastName = "last" + id;
        this.username = "user" + id;
        this.premissions = "user";
        this.city = city;
        this.scooter = null;
        this.x = 0;
        this.y = 0;
        this.location = "["+ this.x +"," + this.y + "] ";

    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public void goTo(int x, int y){
        if (this.scooter == null){
            if(this.x<x){
                this.setX(this.x + 1);
                
            }
            if(this.x>x){
                this.setX(this.x - 1);
            }
            
            
            if(this.y<y){
                this.setY(this.y + 1);
            }
            if(this.y>y){
                this.setY(this.y - 1);
            }
        }

        if (this.scooter != null){
            if(this.x<x){
                this.setX(this.x + 1);
                this.scooter.setX(this.x);
                
            }
            if(this.x>x){
                this.setX(this.x - 1);
                this.scooter.setX(this.x);
            }
            
            
            if(this.y<y){
                this.setY(this.y + 1);
                this.scooter.setY(this.y);
            }
            if(this.y>y){
                this.setY(this.y - 1);
                this.scooter.setY(this.y);
            }
        }
        

    
    }


    public void chooseScooter(Parking parking){
        if (this.scooter == null){
            for (int i =0; i<parking.scooters.length; i++){
                if(parking.scooters[i] != null){
                this.scooter = parking.scooters[i];
                parking.scooters[i] = null;
                break;
                }
            }
        }


    }
}
