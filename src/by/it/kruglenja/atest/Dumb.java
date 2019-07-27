package by.it.kruglenja.atest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dumb {
    {this.id = 6;}
    int id;
    Dumb(){
        System.out.println("конструктор класса Тест ");

        id = this.getId();
        System.out.println("id = " + id);
    }
    int getId(){
        System.out.println("getId() класса Test");
        return id;
    }
}
