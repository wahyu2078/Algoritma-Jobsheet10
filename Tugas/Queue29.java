package Tugas;

public class Queue29 {
    int max, size, front, rear;
    Pasien29[] antrian;

    public Queue29(int n) {
        max = n;
        antrian = new Pasien29[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Data Pasien Terdepan : " + antrian[front].nama + " " + antrian[front].noID + " "
                    + antrian[front].jenisKelamin + " " + antrian[front].umur);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.println("Data Pasien Terbelakang : " + antrian[rear].nama + " " + antrian[rear].noID + " "
                    + antrian[rear].jenisKelamin + " " + antrian[rear].umur);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i].nama + " " + antrian[i].noID + " " + antrian[i].jenisKelamin + " "
                        + antrian[i].umur);
                i = (i + 1) % max;
            }
            System.out.println(
                    antrian[i].nama + " " + antrian[i].noID + " " + antrian[i].jenisKelamin + " " + antrian[i].umur);
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void peekPosition(String nama) {
        int i = front;
        boolean found = false;
        while (i != rear) {
            if (nama.equals(antrian[i].nama)) {
                System.out.println("Data " + antrian[i].nama + " ada di index ke-" + i);
                found = true;
                break;
            }
            i = (i + 1) % max;
        }
        if (!found && nama.equals(antrian[i].nama)) {
            System.out.println("Data " + antrian[i].nama + " ada di index ke-" + i);
        } else if (!found) {
            System.out.println("Data tidak ditemukan");
        }
    }

    public void daftarPasien() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            System.out.println("Daftar Pasien:");
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i].nama + " " + antrian[i].noID + " " + antrian[i].jenisKelamin + " "
                        + antrian[i].umur);
                i = (i + 1) % max;
            }
            System.out.println(
                    antrian[i].nama + " " + antrian[i].noID + " " + antrian[i].jenisKelamin + " " + antrian[i].umur);
        }
    }

    public void enqueue(Pasien29 pasien) {
        if (isFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            antrian[rear] = pasien;
            size++;
        }
    }

    public Pasien29 dequeue() {
        Pasien29 pasien = null;
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            pasien = antrian[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                front = (front + 1) % max;
            }
        }
        return pasien;
    }
}
