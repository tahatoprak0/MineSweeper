import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("*****Mayın Tarlasına Hoş Geldiniz.*****"+
                "\nOyunun Toplam Alanını Belirlemek İçimn Satır ve Sütün Değerlerini Girin");
        System.out.print("\nSatır: ");
        int row=input.nextInt();
        System.out.print("\nSütun: ");
        int column=input.nextInt();
        MineSweeper mineSweeper = new MineSweeper(row,column);
        mineSweeper.run();
    }
}
