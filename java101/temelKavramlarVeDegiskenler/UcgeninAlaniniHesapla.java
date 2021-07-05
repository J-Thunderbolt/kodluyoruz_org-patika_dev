// Üç kenar uzunluğunu kullanıcıdan aldığınız üçgenin alanını hesaplayan programı yazınız.

package temelKavramlarVeDegiskenler;

import java.util.Scanner;

public class UcgeninAlaniniHesapla {
    public static void main(String[] args) {
        int a, b, c, cevre;
        double u, alan;

        Scanner input = new Scanner(System.in);

        System.out.print("İlk Kenar : ");
        a = input.nextInt();

        System.out.print("İkinci Kenar : ");
        b = input.nextInt();

        System.out.print("Üçüncü Kenar : ");
        c = input.nextInt();

        input.close();

        cevre = (a + b + c);
        u = cevre / 2;

        alan = Math.sqrt(u * (u - a) * (u - b) * (u - c));

        System.out.println("Üçgenin alani : " + alan);
    }
}
