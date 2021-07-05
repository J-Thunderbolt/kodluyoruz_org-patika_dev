/*Aynı program içerisinde koşullu ifadeler kullanılarak, 
eğer kullanıcının ortalaması 60'dan büyük ise ekrana "Sınıfı Geçti" , 
küçük ise "Sınıfta Kaldı" yazsın.

Not : If ve Else kullanılmayacak...*/

package temelKavramlarVeDegiskenler;

import java.util.Scanner;

class NotOrtalamasiHesapla {
    public static void main(String[] args) {
        int matematik, fizik, kimya, turkce, tarih, muzik;

        int toplam;
        double ortalama;

        Scanner input = new Scanner(System.in);

        System.out.print("Matematik:");
        matematik = input.nextInt();

        System.out.print("Fizik:");
        fizik = input.nextInt();

        System.out.print("Kimya:");
        kimya = input.nextInt();

        System.out.print("Türkce:");
        turkce = input.nextInt();

        System.out.print("Tarih:");
        tarih = input.nextInt();

        System.out.print("Muzik:");
        muzik = input.nextInt();

        input.close();

        toplam = matematik + fizik + kimya + turkce + tarih + muzik;
        ortalama = toplam / 6;
        System.out.println("Ortalama: " + ortalama);
        System.out.println(ortalama > 60 ? "Gecti" : "Kaldi");

    }
}
