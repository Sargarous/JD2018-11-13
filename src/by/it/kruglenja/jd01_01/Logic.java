package by.it.kruglenja.jd01_01;

class Logic {

    private static boolean win = false;//Состояние победы
    public static boolean getWin() { return win; }

    //проверка наличия последовательности три-в-ряд
    static int isWin() {
        int winner = 2; //Идентификатор победителя, 2 - ничья, 1 - Х, 0 - О
        boolean endCycle = false; //В результате хода победителя нет
        String tempGameField[] = Input.getGameField();

        //Цикл проверки по внешнему контуру поля
        for (int i = 0; i < Input.getGameField().length - 2; i += 2) {
            String temp = tempGameField[i];
            if (temp.equals(tempGameField[i + 1]) && temp.equals(tempGameField[i + 2])) {
                win = true;
                if (temp.equalsIgnoreCase("O")) {
                    winner = 0;
                    break;
                } else {
                    break;
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
