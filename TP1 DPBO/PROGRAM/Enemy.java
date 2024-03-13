//    Saya Alfen Fajri Nurulhaq (2201431) mengerjakan TP1 DPBO simulasi game dalam mata
//    kuliah OOP untuk keberkahanNya maka saya tidak
//    melakukan kecurangan seperti yang telah dispesikasikan.Aamiin

class Enemy extends Karakter {
    private String ancaman;//properti ancaman untuk jenis ancaman musuh
    private Inventaris inventarisEnemy;//composite inventaris untuk enemy jadi enemy punya inventori barang kenapa untuk nanti ketika musuh kalah maka enemy akan mengdrop barang

    public Enemy(String nama, String jenisKelamin, String role, String senjata, int level, int health, int attack, String ancaman) {//constructor untuk enemy
        super(nama, jenisKelamin, role, senjata, level, health, attack);//super untuk mengambil atribut inherit dari karakter
        this.ancaman = ancaman;//ditambah dengan jenis ancaman
        inventarisEnemy = new Inventaris();//dan instansiasi untuk inventaris barang enemy
    }
    //getter dan setter untuk properti di enemy
    public String getAncaman() {
        return ancaman;
    }

    public void setancaman(String ancaman) {
        this.ancaman = ancaman;
    }

    public void setInventarisEnemy(Inventaris inventarisEnemy) {
        this.inventarisEnemy = inventarisEnemy;
    }

    Inventaris getInventarisEnemy() {
        return inventarisEnemy;
    }
    //disini saya membuat method ancaman musuh berbahaya atau tidaknya untuk player
    public void ancamanMusuh(Player player) {
        int playerLevel = player.getLevel();//ambil level playernya
        if (ancaman.equalsIgnoreCase("berbahaya")) {//kalau jenis musuh nya berbahaya berikan kondisi kembali
            if (playerLevel > 10) {//kalau level playernya misal diatas 10
                System.out.println(this.getNama() + " Bisa untuk dikalahkan oleh pemain dengan level " + playerLevel);//kalau level player diatas 10 maka print bahwa musuh masih bisa dilawan
            } else {
                System.out.println(this.getNama() + " Sangat Berbahaya");//print bahwa musuh tersebut sangat berbahaya untuk level player di bawah 10
            }
        } else if (ancaman.equalsIgnoreCase("sedang")) {//kalau jenis musuh nya medium mereun sedang lah berikan kondisi lagi
            if (playerLevel > 5 && playerLevel <= 10) {//kalau level player 6 - 10
                System.out.println(this.getNama() + " Masih bisa dilawan dengan level" + playerLevel);//print bahwa musuh masih bisa dilawan
            }
        }else if(ancaman.equalsIgnoreCase("mudah")){
            if (playerLevel >= 1 && playerLevel <=5) {
                System.out.println(this.getNama() + " Mudah untuk dikalahkan oleh pemain dengan level " + playerLevel);
            }
        }//kondisi lain kalau ancaman nya tidak sesuai dengan ancaman yang ditentukan
         else {
            System.out.println("Ancaman tidak valid.");//berikan output bahwa ancaman tidak valid
        }
    }
    

    public void kurangiAttack(int jumlah) {
        // Mengurangi serangan musuh sebanyak 'jumlah'
        this.setAttack(this.getAttack() - jumlah);
    }

    public void enemyMenyerang(Player player) {//method untuk enemy menyerang player dengan attack sebesar yang dimiliki enemy
        System.out.println(this.getNama() + " menyerang " + player.getNama() + " dengan kekuatan serangan sebesar " + this.getAttack());
        player.diserangPlayer(this.getAttack());//method diserang player ini untuk player ketika enemy menyerang maka health player berkurang 10 tiap diserang enemy
    }

     // Metode untuk mentransfer barang dari inventaris musuh ke inventaris pemain saat musuh dikalahkan
     public void transferBarangKePlayer(Player player) {
        for (Barang barang : inventarisEnemy.getDaftarBarang()) {
            player.tambahBarangKeInventory(barang);
        }
        // Setelah mentransfer, kosongkan inventaris musuh
        inventarisEnemy.getDaftarBarang().clear();
    }


    public void diserangEnemy(int damage, Player player) {//ini untuk enemy ketika enemy diserang player
        this.setHealth(this.getHealth() - damage);//maka darah enemy berkurang dengan attack yang diberikan oleh player
        System.out.println("Darah Enemy " + getNama() + " Berkurang Menjadi " + getHealth() + "\nUGHHH AKAN KU BALAS KAU " + player.getNama());
        if (this.getHealth() <= 0) {//kalau darah enemy kosong atau kurang dari 0
            System.out.println(this.getNama() + " telah dikalahkan!");//maka print bahwa musuh telah dikalahkan
             transferBarangKePlayer(player); // Panggil metode transfer saat musuh mati
        }
    }

    public void berikanInformasiMusuh() {//ini untuk tampilkan informasi musuh
        berikanInformasi();
        System.out.println("Jenis Musuh: " + getAncaman());//ditambah dengan jenis ancaman musuh
    }
}
