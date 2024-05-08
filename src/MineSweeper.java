import java.util.Random;
import java.util.Scanner;

public class MineSweeper {


    int row;
    int column;
    int size;
    String[][] firstMap;
    String[][] finalMap;
    boolean game = true;


    Random rand = new Random();
    Scanner x = new Scanner(System.in);


    MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.firstMap = new String[row][column];
        this.finalMap = new String[row][column];
        this.size = row * column;
    }


    public void Run() {

        int satirno, sutunno;

        prepareGame();
        print(firstMap);
        System.out.println("=================================");
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");

        while (this.game) {

            print(finalMap);

            System.out.print("Satır Giriniz : ");
            satirno = x.nextInt();
            System.out.print("Sütun Giriniz : ");
            sutunno = x.nextInt();

            while (satirno >= this.row || sutunno >= this.column) {

                System.out.println("Satır veya Sütun Değerini Yanlış Girdiniz. Tekrar Deneyiniz !!");

                System.out.print("Satır Giriniz : ");
                satirno = x.nextInt();
                System.out.print("Sütun Giriniz : ");
                sutunno = x.nextInt();

            }

            isLose(satirno, sutunno);

            isWin();

            System.out.println("=================================");

        }
    }

    public void prepareGame() {

        int randomRow, randomColumn, sayac = 0;

        for (int i = 0; i < firstMap.length; i++) {

            for (int j = 0; j < firstMap[i].length; j++) {
                firstMap[i][j] = "-";
                finalMap[i][j] = "-";
            }

        }

        while (sayac != (size / 4)) {

            randomRow = rand.nextInt(this.row);
            randomColumn = rand.nextInt(this.column);

            if (!firstMap[randomRow][randomColumn].equals("*")) {
                firstMap[randomRow][randomColumn] = "*";
                sayac++;
            }

        }

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
                    print(finalMap);
                    this.game = false;
                }

            }

        }
    }


    public void isLose(int row, int column) {

        if (finalMap[row][column].equals("1")) {
            System.out.println("Secili Koordinat Girdiniz Tekrar Deneyiniz !");
        }

        if (firstMap[row][column].equals("-")) {

            firstMap[row][column] = "1";

            finalMap[row][column] = "1";

        }

        if (firstMap[row][column].equals("*")) {

            System.out.println("Game Over !! ");
            this.game = false;

        }

    }

    public void print(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j].equals("-")) {
                    System.out.print(" ");
                }

                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}




