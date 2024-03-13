//    Saya Alfen Fajri Nurulhaq (2201431) mengerjakan TP1 DPBO simulasi game dalam mata
//    kuliah OOP untuk keberkahanNya maka saya tidak
//    melakukan kecurangan seperti yang telah dispesikasikan.Aamiin

public class Barang {
    private String namaBarang; // Mendefinisikan atribut untuk menyimpan nama item

    // Konstruktor untuk membuat objek item dengan nama tertentu
    public Barang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    // Metode untuk mendapatkan nama item
    public String getNamaBarang() {
        return namaBarang;
    }

    // Metode untuk merepresentasikan item dalam bentuk string
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    // Override metode toString untuk mencetak nama barang
    @Override
    public String toString() {
        return namaBarang;
    }
}
