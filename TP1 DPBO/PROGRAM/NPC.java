//    Saya Alfen Fajri Nurulhaq (2201431) mengerjakan TP1 DPBO simulasi game dalam mata
//    kuliah OOP untuk keberkahanNya maka saya tidak
//    melakukan kecurangan seperti yang telah dispesikasikan.Aamiin

class NPC extends Karakter {
    private String quest;//quest untuk player dari NPC
    private String informasi;//informasi berupa chat random dari NPC
    private Inventaris inventarisNPC;//atribut untuk barang yang dimiliki NPC
    private Enemy musuh;//atribut musuh untuk quest dari npc

    public NPC(String nama, String jenisKelamin, String informasi) {//constructor untuk NPC
        super(nama, jenisKelamin);
        this.informasi = informasi;
        inventarisNPC = new Inventaris();
    }

    public NPC(String nama, String jenisKelamin, String quest, String informasi, Enemy musuh) {//constructor untuk NPC
        super(nama, jenisKelamin);
        this.quest = quest;
        this.informasi = informasi;
        inventarisNPC = new Inventaris();
        this.musuh = musuh;
    }


    //getter dan setter
    public void setQuest(String quest){
        this.quest = quest;
    }

    String getQuest(){
        return quest;
    }

    public void setInformasi(String informasi){
        this.informasi = informasi;
    }

    String getInformasi(){
        return informasi;
    }

    public void setInventarisNPC(Inventaris inventarisNPC){
        this.inventarisNPC = inventarisNPC;
    }

    Inventaris getInventarisNPC() {
        return inventarisNPC;
    }

    public void berikanQuest(Player player){
        if (musuh == null) {//cek kondisi kalau musuh nya gaada
            System.out.println("NPC tidak memiliki musuh yang ditentukan.");
            return;
        }
        
        musuh.ancamanMusuh(player); // Cek ancaman musuh terhadap player
        // Berikan quest sesuai dengan ancaman musuh
        if (musuh.getAncaman().equalsIgnoreCase("berbahaya") && player.getLevel() > 10) {
            System.out.println("NPC memberikan quest kepada " + player.getNama() + ".");
            System.out.println("Tugas Anda adalah mengalahkan musuh " + musuh.getNama() + ".");
        } else if (musuh.getAncaman().equalsIgnoreCase("sedang") && (player.getLevel() > 5 && player.getLevel() <= 10)) {
            System.out.println("NPC memberikan quest kepada " + player.getNama() + ".");
            System.out.println("Tugas Anda adalah mengalahkan musuh " + musuh.getNama() + ".");
        } else if (player.getLevel() <= 10) {
            System.out.println("Maaf, Anda belum cukup kuat untuk melawan musuh " + musuh.getNama() + ".");
        } else {
            System.out.println("NPC memberikan quest kepada " + player.getNama() + ".");
            System.out.println("Tugas Anda adalah mengalahkan musuh " + musuh.getNama() + ".");
        }
    }

    // Metode untuk menambahkan barang yang diterima dari player
    public void tambahBarangDiterima(Barang barang) {
        inventarisNPC.addBarang(barang);
    }
    // Metode untuk memberikan informasi NPC ke pada player
    public void berikanInformasiNPC(Player player){
        System.out.println("Nama NPC: " + getNama());
        System.out.println("Jenis Kelamin NPC: " + getJenisKelamin());
        if (getQuest() != null) {
            System.out.println("Quest dari NPC: " + getQuest());
        }else{
            System.out.println("tidak ada quest dari NPC ini");

        }
        if (this.musuh == null) {
            System.out.println("NPC ini hanya pemberi informasi saja");
        }
        System.out.println("Informasi dari NPC: " + getInformasi());
    }
}
