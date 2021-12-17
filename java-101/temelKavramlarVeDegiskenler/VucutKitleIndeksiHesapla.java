package temelKavramlarVeDegiskenler;

import java.util.Scanner;

public class VucutKitleIndeksiHesapla {
    public static void main(String[] args) {
        float length;
        float weight;
        float bodyMassIndex;

        Scanner scanner = new Scanner(System.in);
        try (scanner) {
            length = getValue("Lütfen boyunuzu (metre cinsinden) giriniz: ", scanner);
            weight = getValue("Lütfen kilonuzu giriniz: ", scanner);
            bodyMassIndex = weight / (float) Math.pow(length, 2);
            System.out.printf("Vücut Kitle İndeksiniz: %.2f", bodyMassIndex);
        }
    }

    public static float getValue(String message, Scanner scan) {
        System.out.print(message);
        while (!scan.hasNextFloat()) {
            System.out.println("Girdiğiniz değer bir sayı olmalı!");
            System.out.print(message + ": ");
            scan.next();
        }
        return scan.nextFloat();
    }
}
