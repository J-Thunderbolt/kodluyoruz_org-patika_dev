/*Java ile gidilen mesafeye (KM) göre taksimetre tutarını ekrana yazdıran programı yazın.

Taksimetre KM başına 2.20 TL tutmaktadır.

Minimum ödenecek tutar 20 TL'dir. 20 TL altında ki ücretlerde yine 20 TL alınacaktır.

Taksimetre açılış ücreti 10 TL'dir.*/

package temelKavramlarVeDegiskenler;

import java.util.Scanner;

public class TaksimetreProgrami {
    public static void main(String[] args) {
        float startPrice = 10.0f, perKm = 2.20f, totalPrice;
        int km;

        Scanner input = new Scanner(System.in);
        System.out.println("Mesafeyi giriniz (KM) : ");
        km = input.nextInt();

        totalPrice = (km * perKm) + startPrice;
        totalPrice = totalPrice <= 20 ? 20f : totalPrice;
        input.close();

        System.out.println("Toplam Tutar : " + totalPrice);
    }
}
