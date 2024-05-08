import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.println(" \t MAYIN TARLASI OYUNU");
        System.out.println("Lütfen oynamak isteğiniz boyutları giriniz !");


        System.out.print("Satır Sayısı Giriniz : ");
        int satir = x.nextInt();

        System.out.print("Sütun Sayısı Giriniz : ");
        int sutun = x.nextInt();


        boolean game = true;
        while (game)
            if (satir < 2 || sutun < 2) {

                System.out.println("Yanlış Değer Girdiniz Lütfen Tekrar Deneyiniz !");
                System.out.print("Satır Sayısı Giriniz : ");
                satir = x.nextInt();

                System.out.print("Sütun Sayısı Giriniz : ");
                sutun = x.nextInt();

            } else {
                System.out.println("Satır için 0-" + (satir - 1) + " aralığında değer giriniz");
                System.out.println("Sütun için 0-" + (sutun - 1) + " aralığında değer giriniz");

                System.out.println("=================================");
                System.out.println(" MAYINLARIN KONUMU");

                MineSweeper ms = new MineSweeper(satir, sutun);
                ms.Run();

                game = false;

            }
    }
}