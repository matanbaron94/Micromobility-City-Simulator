package City;

public class House {

    int x;
    int y;
    String location;
    String id;

    public House(int x, int y){
        this.x = x;
        this.y = y;
        this.location = "["+ this.x +"," + this.y + "] ";
        this.id = "10" + x+ 00 + y + (x+y);

    }

    public void print(){
        System.out.print(this.location);
    }

}
