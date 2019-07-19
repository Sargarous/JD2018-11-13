package by.it.kruglenja.jd01_01;

class Logic {

    private static boolean win = false;//Состояние победы

    public static boolean getWin() { return win; }

    //проверка наличия последовательности три-в-ряд

    static int isWin() {
        String[] tempGameField = Input.getGameField();
        int winner = 2; //Идентификатор победителя, 2 - ничья, 1 - Х, 0 - О

        //Цикл проверки по внешнему контуру поля
        for (int i = 0; i < tempGameField.length - 2; i += 2) {
            String temp = tempGameField[i];
            if (temp.equals(tempGameField[i + 1]) && temp.equals(tempGameField[i + 2])||(tempGameField[0].equals(tempGameField[6]) && tempGameField[0].equals(tempGameField[7]))) {
                win = true;
                if (temp.equalsIgnoreCase("O")){
                    winner = 0;
                }else {
                    winner = 1;
                }
            }
        }

        //Цикл проверки по внутренним пересечениям поля
        String temp = tempGameField[8];//Берем центр игрового поля
        int rotateX = 4;//Правая вращалка диагонали
        for (int i = 0; i < 4; i++) {// i - Левая вращалка, вращаем вращалки вокруг центра [8]
            if (temp.equals(tempGameField[i]) && temp.equals(tempGameField[rotateX])) {
                win = true;
                if (temp.equalsIgnoreCase("O")) {
                    winner = 0;
                } else {
                    winner = 1;
                }
            }
            rotateX++;
        }

        return winner;
    }
}
