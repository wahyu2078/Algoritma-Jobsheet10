package Tugas;

import java.util.Scanner;

public class PasienMain29 {
    public static void menu() {
        System.out.println("Pilih Menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Semua Antrian");
        System.out.println("5. Cek Antrian Belakang");
        System.out.println("6. Daftar Pasien");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue : ");
        int jumlah = sc.nextInt();
        Queue29 antri = new Queue29(jumlah);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Nomor ID: ");
                    int noID = sc.nextInt();
                    System.out.print("Jenis Kelamin (L/P): ");
                    char jenisKelamin = sc.next().charAt(0);
                    System.out.print("Umur: ");
                    int umur = sc.nextInt();
                    Pasien29 pasien = new Pasien29(nama, noID, jenisKelamin, umur);
                    sc.nextLine();
                    antri.enqueue(pasien);
                    break;
                case 2:
                    Pasien29 data = antri.dequeue();
                    if (data != null) {
                        System.out.println(
                                "Antrian yang keluar : " + data.nama + " " + data.noID + " " + data.jenisKelamin
                                        + " " + data.umur);
                    }
                    break;
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.print();
                    break;
                case 5:
                    antri.peekRear();
                    break;
                case 6:
                    System.out.print("Masukkan nama pasien: ");
                    String namaPasien = sc.nextLine();
                    antri.peekPosition(namaPasien);
                    break;

            }
        } while (pilih >= 1 && pilih <= 6);
    }
}
