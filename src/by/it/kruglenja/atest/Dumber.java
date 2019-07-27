package by.it.kruglenja.atest;

public class Dumber extends Dumb{

    int id = 9;
    Dumber(){
        System.out.println("constructor Dumber ");
        id = this.getId();
        System.out.println(" id = " + id);
    }

    @Override
    int getId() {
        System.out.println("getId() classa Dumber ");
        return id;
    }
}
