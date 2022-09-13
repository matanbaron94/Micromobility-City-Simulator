package City;

public class Company {
    String name;
    public int units;

    public Company(String name){
        this.name = name;
        this.units = 0;

    }

    public int getUnits() {
        return this.units;
    }

    public void addUnit(){
        this.units = this.units +1;
    }

    protected String getName(){
        return this.name;
    }

}
