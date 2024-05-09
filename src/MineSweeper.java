import java.util.Random;
import java.util.Scanner;

public class MineSweeper {


    // Proje Nitelikleri
    String[][] firstMap;
    String[][] finalMap;
    int row;
    int column;
    int size;
    boolean gameProcess = true;


    Random rand = new Random();
    Scanner x = new Scanner(System.in);


    //  Oyun alanının boyutlarını parametre olarak alan bir kurucu metod.
    MineSweeper(int row, int column) {
        this.firstMap = new String[row][column];
        this.finalMap = new String[row][column];
        this.row = row;
        this.column = column;
        this.size = row * column;
    }


    // Oyunun ana döngüsünü içeren metot. Oyunu başlatır ve kullanıcı girişlerini alır.
    public void Run() {

        int rowNumber, columnNumber;

        prepareGame();
        print(firstMap);
        System.out.println("=================================");
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");

        while (this.gameProcess) {

            print(finalMap);

            do{

                System.out.print("Satır Giriniz : ");
                rowNumber = x.nextInt();
                System.out.print("Sütun Giriniz : ");
                columnNumber = x.nextInt();

                if((rowNumber >= this.row || rowNumber < 0) || (columnNumber >= this.column || columnNumber < 0)){
                    System.out.println("Lütfen geçerli bir satır ve sütun numarası giriniz !!!");
                }

            }while((rowNumber >= this.row || rowNumber < 0) || (columnNumber >= this.column || columnNumber < 0));

            updateGame(rowNumber, columnNumber);

            isLose(rowNumber, columnNumber);

            isWin();

            System.out.println("=================================");

        }
    }


    // Oyun alanını hazırlar ve rastgele mayın yerleştirir.
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


    // Oyun alanını güncelleyerek kullanıcının hamlesine yanıt verir.
    public void updateGame(int row, int column) {

        if (!finalMap[row][column].equals("-") && !finalMap[row][column].equals("*")) {
            System.out.println("Secili Koordinat Girdiniz Tekrar Deneyiniz !");
        }

        if (firstMap[row][column].equals("-")) {

            firstMap[row][column] = mineControl(row, column);

            finalMap[row][column] = mineControl(row, column);

        }

    }


    // Belirtilen koordinatlarda mayın yoksa, koordinatın etrafındaki mayın sayısını bulma
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


    //  Oyunun kazanılıp kazanılmadığını kontrol eder.
    public void isWin() {

        int counter = 0;

        for (int i = 0; i < finalMap.length; i++) {

            for (int j = 0; j < finalMap[i].length; j++) {

                if (!firstMap[i][j].equals("-")) {
                    counter++;
                }

                if (counter >= size) {
                    System.out.println("OYUNU KAZANDINIZ !!");
                    print(firstMap);
                    this.gameProcess = false;
                }

            }
        }
    }


    // Oyunun kaybedilip kaybedilmediğini kontrol eder.
    public void isLose(int row, int column) {

        if (firstMap[row][column].equals("*")) {

            System.out.println("GAME OVER !! ");
            this.gameProcess = false;

        }

    }


    // Oyun alanını ekrana yazdırır.
    public void print(String[][] map) {

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {

                System.out.print(map[i][j] + " ");

            }
            System.out.println();
        }
    }


}