package City;


import java.util.*;

public class City {

    Random rand = new Random();


    // ------------ MAP SETUP ------------------ 
    String[][] map;
    public int size = 30;
   



// ------------- OBJECTS SETUP -------------------- 
    protected int numOfParkings;
    protected int numOfHouses;
    protected int numOfUsaers = 1;
    protected int numOfCompaneis = 3;
    protected int numOfScooters;

    public Parking[] parkings;
    public House[] houses;
    public Company[] companies = new Company[numOfCompaneis];
    public Scooter[] scooters;
    public User[] users;


// -------------- COMPANIES ------------------
    public Company bird;
    public Company lime;
    public Company wind;
    



// ---------- SYMBOLS ON MAP ----------------


    final String parkingSymbol = "P";
    final String houseSymbol = "H";
    final String userSymbol = "U";
    final String scooterSymbol = "S";





//-------------------------------------------------------------------------------------------------



    public City(){
        this.size = 30;
        this.numOfParkings =  this.size;
        this.numOfHouses = this.size;
        this.numOfScooters = this.numOfParkings*3;

        this.map = new String[this.size][this.size];
        this.parkings = new Parking[numOfParkings];
        this.houses = new House[numOfHouses];
        this.scooters = new Scooter[numOfScooters];

        this.init();
    }


    public City(int size){
        this.size = size;
        this.numOfParkings =  this.size;
        this.numOfHouses = this.size;
        this.numOfScooters = this.numOfParkings*3;

        this.map = new String[size][size];
        this.parkings = new Parking[numOfParkings];
        this.houses = new House[numOfHouses];
        this.scooters = new Scooter[numOfScooters];

        this.init();
    }



//------------------------------------------------------------------------------------------------



    private void init(){

        for (int i =0; i < size; i++){
            for (int j = 0; j < size; j++ ){
                this.map[i][j] = ":";
            }
        }


        setUpParkings();
        setUpHouses();
        setUpCompaneis();
        setUpScooters();
        setupUsers();



    }



    //------------------------------------------ METHODS ---------------------------------------------

    // ------------ MAP METHODS ----------------
    public Boolean onFrame(User user){
        if (user.x == this.size-1){
            return false;
        }
        else{
            return true;
        }      
    }

    public void refresh(){
        for (int i =0; i < size; i++){
            for (int j = 0; j < size; j++ ){
                this.map[i][j] = ":";
            }
        }

        for (House house : this.houses){
            this.map[house.x][house.y] = this.houseSymbol;
        }
        
        for (Parking park : this.parkings){
            this.map[park.x][park.y] = this.parkingSymbol;
        }

        for (User user : this.users){
            this.map[user.x][user.y] = this.userSymbol;
        }


    }

    public void print(){
        // for (String[] row : this.map){
        //     System.out.println(Arrays.toString(row));

        for (int i = 0; i<this.size; i++){
            for(int j = 0; j<this.size; j++){
                System.out.print(" " + map[i][j] + " ");
            }
            System.out.println("");

        }
            
    }



    // ------------ SETUP METHODS ----------------
    public void setupUsers(){
        this.users = new User[1];
        User user = new User(this);
        users[0] = user;

       
        this.map[user.x][user.y] = this.userSymbol;
        
    }

    private void setUpCompaneis(){
        this.bird = new Company("bird");
        this.lime = new Company("lime");
        this.wind = new Company("wind");
        this.companies[0] = bird;
        this.companies[1] = lime;
        this.companies[2] = wind;
    }

    private void setUpParkings(){
        for(int i =0; i<this.numOfParkings; i++){
            Parking parking = new Parking(rand.nextInt(this.size),rand.nextInt(this.size));
            this.parkings[i] = parking;
        }


        for (Parking park : this.parkings){
            this.map[park.x][park.y] = this.parkingSymbol;
        }
    }

    private void setUpHouses(){
        for(int i =0; i<this.numOfHouses; i++){
            House house = new House(rand.nextInt(this.size),rand.nextInt(this.size));
            this.houses[i] = house;
        }


        for (House house : this.houses){
            this.map[house.x][house.y] = this.houseSymbol;
        }
    }

    private void setUpScooters(){
        int k = 0;
        int j = 0;
        int y = 0;
        for(int i =0; i<this.numOfScooters; i++){
            int r = rand.nextInt(3);

            if (k==3){
                y++;
                k=0;
            }

            if (j == 3){
                j = 0;
            }

            Scooter scooter = new Scooter(this.parkings[y].x, this.parkings[y].y, companies[r]);
            this.parkings[y].scooters[j] = scooter;
            // this.parkings[i].scooters[k-1] = scooter;
            j++;
            k++;
            this.scooters[i] = scooter;
        }
            
        for (int f=0; f<this.scooters.length; f++){
            switch(this.scooters[f].company.getName()){
            case "bird":
                this.bird.addUnit();
                break;
            case "lime":
                this.lime.addUnit();
                break;
            case "wind":
                this.wind.addUnit();
                break;


            
        }
    }
        

            
     
    }


    
    


    // ----------------- REPORTS ---------------------
    public Scooter[] getScooters(){
        return this.scooters;
    }

    public void listParking(){
        for(Parking park : this.parkings){
            park.print();
        }
    }


}


