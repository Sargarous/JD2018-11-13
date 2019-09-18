package by.it.kruglenja.OOP.atest;

public class Runner {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Pudel();
        Pudel dog3 = new Pudel();

        dog1.doBark(5);
        dog2.doBark(2);
        if (dog3.checkLife())
            dog3.doBark(4);

        ((Pudel) dog2).checkLife();
        ((Pudel) dog1).checkLife();
    }
}
