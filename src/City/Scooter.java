package City;

import java.util.Random;

public class Scooter {
    int x;
    int y;
    int battaryLevel;
    String location;
    String id;
    public boolean onUse;
    Company company;
    Random rand = new Random();



    public Scooter(int x, int y, Company company){
        this.x = x;
        this.battaryLevel = 100;
        this.y = y;
        this.onUse = false;
        this.location = "["+ this.x +"," + this.y + "] ";
        this.id = "S" + rand.nextInt(99)+ 00 + rand.nextInt(99);
        this.company = company;

    }

    public String toString(){
        return "location: " + this.x +", " +this.y + "\nID: " + this.id + "\nCompany: " +this.company.getName() + "\nBattary: " + this.battaryLevel + "%" + "\nOn use: " +this.onUse;
    }

    public void setX(int x){
        if(x!=this.x){
            this.battaryLevel =this.battaryLevel -1;
        }
        this.x = x;
    }
    public void setY(int y){
        if(y!=this.y){
            this.battaryLevel =this.battaryLevel -1;
        }
        this.y = y;
    }



    public void rideTo(int x, int y){
        if (this.battaryLevel>10){
      
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
    }




}
