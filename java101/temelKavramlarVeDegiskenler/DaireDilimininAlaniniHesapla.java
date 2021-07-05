/* Yarıçapı r, merkez açısısının a ölçüsü  olan daire 
diliminin alanı bulan programı yazınız.
a sayısını = 3.14 alınız.
Formül : (PI * (r*r) * a) / 360  */

package temelKavramlarVeDegiskenler;

import java.util.Scanner;

public class DaireDilimininAlaniniHesapla {

    public static void main(String[] args) {
        int r, a;
        final double PI = 3.14;
        double alan;

        Scanner input = new Scanner(System.in);

        System.out.print("Dairenin yarıçapı: ");
        r = input.nextInt();

        System.out.print("Merkez açısının ölçüsü: ");
        a = input.nextInt();
        input.close();

        alan = (PI * (r * r) * a) / 360;

        System.out.print("Alan: " + alan);
    }

}