import java.util.Random;
import java.util.Scanner;

public class MineSweeper {


    String[][] firstMap;
    String[][] finalMap;
    int row;
    int column;
    int size;
    boolean gameProcess = true;


    Random rand = new Random();
    Scanner x = new Scanner(System.in);


    MineSweeper(int row, int column) {
        this.firstMap = new String[row][column];
        this.finalMap = new String[row][column];
        this.row = row;
        this.column = column;
        this.size = row * column;
    }


    public void Run() {

        int rowNumber, columnNumber;

        prepareGame();
        print(firstMap);
        System.out.println("=================================");
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");

        while (this.gameProcess) {

            print(finalMap);

            System.out.print("Satır Giriniz : ");
            rowNumber = x.nextInt();
            System.out.print("Sütun Giriniz : ");
            columnNumber = x.nextInt();

            while ((rowNumber >= this.row || rowNumber < 0) || (columnNumber >= this.column || columnNumber < 0)) {

                System.out.println("Satır veya Sütun Değerini Yanlış Girdiniz. Tekrar Deneyiniz !!");

                System.out.print("Satır Giriniz : ");
                rowNumber = x.nextInt();
                System.out.print("Sütun Giriniz : ");
                columnNumber = x.nextInt();

            }

            updateGame(rowNumber, columnNumber);

            isLose(rowNumber, columnNumber);

            isWin();

            System.out.println("=================================");

        }
    }


    public void prepareGame() {

        int randomRow, randomColumn, counter = 0;

        for (int i = 0; i < firstMap.length; i++) {

            for (int j = 0; j < firstMap[i].length; j++) {
                firstMap[i][j] = "-";
                finalMap[i][j] = "-";
            }

        }

        while (counter != (size / 4)) {

            randomRow = rand.nextInt(this.row);
            randomColumn = rand.nextInt(this.column);

            if (!firstMap[randomRow][randomColumn].equals("*")) {
                firstMap[randomRow][randomColumn] = "*";
                counter++;
            }

        }

    }


    public void updateGame(int row, int column) {

        if (!finalMap[row][column].equals("-") && !finalMap[row][column].equals("*")) {
            System.out.println("Secili Koordinat Girdiniz Tekrar Deneyiniz !");
        }

        if (firstMap[row][column].equals("-")) {

            firstMap[row][column] = mineControl(row, column);

            finalMap[row][column] = mineControl(row, column);

        }

    }


    public String mineControl(int row, int column) {

        int counterMine = 0;

        if (column > 0 && firstMap[row][column - 1].equals("*")) // sol
            counterMine++;

        if (column < firstMap[row].length - 1 && firstMap[row][column + 1].equals("*")) // sağ
            counterMine++;

        if (row > 0 && firstMap[row - 1][column].equals("*")) // üst
            counterMine++;

        if (row > 0 && column > 0 && firstMap[row - 1][column - 1].equals("*")) // sol üst
            counterMine++;

        if (row > 0 && column < firstMap[row].length - 1 && firstMap[row - 1][column + 1].equals("*")) // sağ üst
            counterMine++;

        if (row < firstMap.length - 1 && firstMap[row + 1][column].equals("*")) // alt
            counterMine++;

        if (row < firstMap.length - 1 && column > 0 && firstMap[row + 1][column - 1].equals("*")) // sol alt
            counterMine++;

        if (row < firstMap.length - 1 && column < firstMap[row].length - 1 && firstMap[row + 1][column + 1].equals("*")) // sağ alt
            counterMine++;

        return String.valueOf(counterMine);

    }


    public void isWin() {

        int sayac = 0;

        for (int i = 0; i < finalMap.length; i++) {

            for (int j = 0; j < finalMap[i].length; j++) {

                if (!firstMap[i][j].equals("-")) {
                    sayac++;
                }

                if (sayac >= size) {
                    System.out.println("Oyunu Kazandınız ! ");
                    print(firstMap);
                    this.gameProcess = false;
                }

            }
        }
    }


    public void isLose(int row, int column) {

        if (firstMap[row][column].equals("*")) {

            System.out.println("Game Over !! ");
            this.gameProcess = false;

        }

    }


    public void print(String[][] map) {

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {

                System.out.print(map[i][j] + " ");

            }
            System.out.println();
        }
    }


}