import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        // Oyunun başlangıç ekranını yazdırıyoruz
        System.out.println(" \t MAYIN TARLASI OYUNU");
        System.out.println("Lütfen oynamak isteğiniz boyutları giriniz !");


        // Kullanıcıdan satır ve sütun sayısını alıyoruz
        System.out.print("Satır Sayısı Giriniz : ");
        int satir = x.nextInt();

        System.out.print("Sütun Sayısı Giriniz : ");
        int sutun = x.nextInt();


        boolean game = true;

        // Oyun döngüsünü başlatıyoruz
        while (game) {

            // Kullanıcının girdiği satır ve sütun değerlerini kontrol ediyoruz
            if (satir < 2 || sutun < 2) {

                // Eğer girdi yanlışsa kullanıcıya hata mesajı gösteriyoruz ve tekrar giriş yapmasını istiyoruz
                System.out.println("Yanlış Değer Girdiniz Lütfen Tekrar Deneyiniz !");
                System.out.print("Satır Sayısı Giriniz : ");
                satir = x.nextInt();

                System.out.print("Sütun Sayısı Giriniz : ");
                sutun = x.nextInt();

            } else {        // Doğru girdi girildiyse oyun alanını başlatıyoruz

                // Kullanıcıya girdi aralıklarını hatırlatıyoruz
                System.out.println("Satır için 0-" + (satir - 1) + " aralığında değer giriniz");
                System.out.println("Sütun için 0-" + (sutun - 1) + " aralığında değer giriniz");

                System.out.println("=================================");
                System.out.println(" MAYINLARIN KONUMU");

                // Mayın tarlası oyununu başlatıyoruz
                MineSweeper ms = new MineSweeper(satir, sutun);
                ms.Run();

                // Oyun döngüsünü sonlandırıyoruz
                game = false;

            }
        }

    }
}