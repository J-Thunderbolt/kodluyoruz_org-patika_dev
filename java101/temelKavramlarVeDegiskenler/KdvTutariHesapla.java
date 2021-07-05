/* Eğer girilen tutar 0 ve 1000 TL arasında ise KDV oranı %18, 
tutar 1000 TL'den büyük ise KDV oranını %8 olarak KDV tutarı hesaplayan programı yazınız.
*/

package temelKavramlarVeDegiskenler;

import java.util.Scanner;

public class KdvTutariHesapla {
    public static void main(String[] args) {
        double tutar, kdvOran, kdvliTutar, kdvTutar;

        Scanner input = new Scanner(System.in);
        System.out.print("Ücret tutarını giriniz: ");
        tutar = input.nextDouble();

        kdvOran = tutar > 0 && tutar <= 1000 ? 0.18 : 0.08;
        kdvTutar = tutar * kdvOran;
        kdvliTutar = tutar + kdvTutar;

        input.close();

        System.out.print("Kdvli tutar: " + kdvliTutar);
    }
}
