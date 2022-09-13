
import City.*;

import java.io.IOException;

public class Main {


    private static void clean() {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
    }

    

    public static void main(String[] args) throws InterruptedException, IOException {

        
        City city = new City(20);

        boolean run = true;
        city.parkings[1].report();
        System.out.println(city.bird.getUnits());
        System.out.println(city.lime.getUnits());
        System.out.println(city.wind.getUnits());
        System.out.println(city.bird.getUnits() + city.wind.getUnits() + city.wind.getUnits());
        
        int a = 0;
        while(run == true){ 
            clean();
            city.print();
           
           
            if (a == 0){
                if (city.onFrame(city.users[0]) == true){
                    city.users[0].goTo(city.parkings[5].x,city.parkings[5].y);
                    
                }
    
                if (city.users[0].x == city.parkings[5].x && city.users[0].y == city.parkings[5].y){
                    city.users[0].chooseScooter(city.parkings[5]);
                    a = 1;
                }
            }

            if (a ==1){
            
                if (city.onFrame(city.users[0]) == true){
                    city.users[0].goTo(0,0);
                }
            }
            

            
            System.out.println(city.users[0].x + " " + city.users[0].y);
            city.parkings[5].report();
            System.out.println(" ");
            System.out.println("User scooter:");
            System.out.println(city.users[0].scooter);

            System.out.println(a);
            
            
            city.refresh();

            Thread.sleep(1000);
            clean();
        }

        
        


        // clean();
        // map.print();
        // clean();
        // map.print();
        // System.out.println("");
        // map.print();  
        




    }


}