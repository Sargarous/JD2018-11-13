package by.it.kruglenja.jd01_01;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {//Первоначальная инициализация игрового поля и присвоение игрокам желаемых идентификаторов
    private static String[] gameField = new String[9];

    static String[] getGameField() { return gameField; }

    public static void setGameField(String[] gameField) { Input.gameField = gameField; }

    private void finalField(int ind1, int ind2, int ind3 ){
       String[] temp =  getGameField();
        for (int i = 0; i < temp.length; i++) {
            if (i == ind1 || i == ind2 || i == ind3){
                temp[i] = temp[i].toLowerCase();
            }
        }
        setGameField(temp);
    }

    private static String player1 = "";
    private static String player2 = "";

    static void gameFieldInitialization() {                   //Выбираем каким символом будет ходить первый игрок
        for (int i = 0; i < gameField.length; i++) {
            gameField[i] = String.valueOf(i);
        }
        System.out.println("Здравствуйте, вас приветствует приложение крестики-нолики, введите букву латинскиго алфавита Х или О, которой вы будете ходить: ");
        Scanner sc = new Scanner(System.in);
        while (player1.equals("")) {
            String temp = sc.next();
            sc.nextLine();
            if ((temp.equalsIgnoreCase("O"))) {
                player1 = "O";
                player2 = "X";
                System.out.println("Игрок 1 :: " + player1 + "\n" + "Игрок 2 :: " + player2 + "\n");
            } else if (temp.equalsIgnoreCase("X")) {
                player1 = "X";
                player2 = "O";
                System.out.println("Игрок 1 :: " + player1 + "\n" + "Игрок 2 :: " + player2 + "\n");
            } else {
                System.out.println("Введен неккоректный идентификатор игрока 1, пожалуйста, введите букву еще раз :");
            }
        }
    }

    static void playersTurn() {
        int emptySquare = 9;
        boolean player1Turn = true;
        Pattern pattern = Pattern.compile("[0-8]{1}");
        for (int i = 0; i <= 8; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите цифру, вместо которой будет " + (player1Turn ? player1 : player2));
            String fieldIndex = sc.next();
            Matcher matcher = pattern.matcher(fieldIndex);
            if (matcher.find() && fieldIndex.length() == 1) {
                if (gameField[Integer.parseInt(fieldIndex)].equalsIgnoreCase("x") || gameField[Integer.parseInt(fieldIndex)].equalsIgnoreCase("o")) {
                    System.out.println("Эта клетка уже занята");
                    i--;
                } else {
                    gameField[Integer.parseInt(fieldIndex)] = player1Turn ? player1 : player2;
                    player1Turn = !player1Turn;
                    emptySquare--;
                }

            } else {
                System.out.println("Не балуйся и вводи нормально");
                i--;
            }


            if (i >= 3) {
                int win = Logic.isWin();
                if (Logic.getWin()) {
                    if ((player1.equalsIgnoreCase("O") && win == 0) || (player1.equalsIgnoreCase("X") && win == 1)) {
                        Printer.printField(Input.getGameField());
                        System.out.println("Поздравляем, игрок 1 подебил");
                        break;
                    } else {
                        System.out.println("Поздравляем, игрок 2 победил");
                        Printer.printField(Input.getGameField());
                        break;
                    }
                } else if (emptySquare == 0) {
                    System.out.println("Ничья, епта");//<-------------КАСЯК------!!!!!!!!!!!!!!
                }
            }
            Printer.printField(Input.getGameField());
        }
    }
}
