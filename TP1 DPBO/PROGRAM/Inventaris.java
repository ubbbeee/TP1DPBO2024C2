//    Saya Alfen Fajri Nurulhaq (2201431) mengerjakan TP1 DPBO simulasi game dalam mata
//    kuliah OOP untuk keberkahanNya maka saya tidak
//    melakukan kecurangan seperti yang telah dispesikasikan.Aamiin

import java.util.ArrayList;//import library java array list

class Inventaris {
    private ArrayList<Barang> daftarBarang; // Mendefinisikan atribut untuk menyimpan daftar barang dalam inventaris

    // Konstruktor untuk membuat objek inventaris dengan daftar barang kosong
    public Inventaris() {
        daftarBarang = new ArrayList<>();
    }

    // Getter untuk mendapatkan daftar barang
    public ArrayList<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    // Setter untuk mengatur daftar barang
    public void setDaftarBarang(ArrayList<Barang> daftarBarang) {
        this.daftarBarang = daftarBarang;
    }


    // Metode untuk menambahkan barang ke dalam inventaris
    public void addBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Metode untuk menghapus barang dari inventaris
    public void removeBarang(Barang barang) {
        daftarBarang.remove(barang);
    }

    // Metode untuk memeriksa apakah barang tertentu ada dalam inventaris
    public boolean contains(Barang barang) {
        return daftarBarang.contains(barang);
    }

    // Metode untuk merepresentasikan inventaris dalam bentuk string
    public String toString() {
        return daftarBarang.toString();
    }
}