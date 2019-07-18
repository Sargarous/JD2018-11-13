package by.it.kruglenja.atest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = "";
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        Pattern pattern = Pattern.compile("[1-9]{2,}");
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()){
            sb.append(str.substring(matcher.start(), matcher.end()));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
