package by.it.kruglenja.OOP.atest;

public class Pudel extends Dog {
    boolean checkLife(){
        return true;
    }

    @Override
    void doBark(int barkCount) {
        System.out.println("Pudel bark " + barkCount);
    }
}
