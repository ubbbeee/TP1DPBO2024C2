//    Saya Alfen Fajri Nurulhaq (2201431) mengerjakan TP1 DPBO simulasi game dalam mata
//    kuliah OOP untuk keberkahanNya maka saya tidak
//    melakukan kecurangan seperti yang telah dispesikasikan.Aamiin

class Player extends Karakter {
    private Inventaris inventarisPlayer;//composite inventaris barang untuk player jadi player punya inventori barang untuk nanti dijual ke NPC untuk menambah level
    private String skill;//atribut player untuk skill player
    private int experience;//exp untuk menambah level player

    public Player(String nama, String jenisKelamin, String role, String senjata, int level, int health, int attack, String skill) {//constructor untuk player
        super(nama, jenisKelamin, role, senjata, level, health, attack);//super untuk mengambil atribut inherit dari karakter
        this.skill = skill;//ditambah dengan skill player
        this.experience = 0;//dan experience di set 0 nanti untuk menambah level ketika barang dijual ke NPC maka exp player bertambah 100 dan level player bertambah
        inventarisPlayer = new Inventaris();//instansiasi untuk barang inventaris player
    }
    //getter dan setter untuk properti di player
    public void setInventarisPlayer(Inventaris inventarisPlayer) {
        this.inventarisPlayer = inventarisPlayer;
    }

    Inventaris getInventarisPlayer() {
        return inventarisPlayer;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    int getExperience(){
        return experience;
    }

    // Metode untuk memberikan barang kepada NPC
    public void memberikanBarang(Barang barang, NPC npc) {
        if (inventarisPlayer.contains(barang)) {//cek dulu apakah player punya barang tersebut kalau punya
            inventarisPlayer.removeBarang(barang); // Hapus barang dari inventaris player
            npc.tambahBarangDiterima(barang); // NPC menerima barang dari player
            tambahExperience(100); // Player mendapatkan experience
            System.out.println(getNama() + " memberikan " + barang.getNamaBarang() + " kepada " + npc.getNama());//player memberi barang ke NPC
        } else {//kalau ga punya beri alert
            System.out.println("Anda tidak memiliki " + barang.getNamaBarang());
        }
    }

    // Metode untuk menambahkan experience dan menangani penambahan level
    private void tambahExperience(int exp) {
        this.experience += exp;
        if (experience >= 100) { // Misalnya, setiap 100 experience akan naik level
            levelUp();
            experience -= 100; // Kurangi experience setelah naik level
        }
    }

    private void levelUp() {
        this.setLevel(this.getLevel() + 1);
        // Tampilkan pesan bahwa player naik level
        System.out.println(getNama() + " naik level menjadi " + this.getLevel());
        this.setHealth(this.getHealth() + 20); // Meningkatkan kesehatan sebanyak 20
        // atau
        this.setAttack(this.getAttack() + 10); // Meningkatkan serangan sebanyak 10
    }

    public void tambahBarangKeInventory(Barang barang) {//method ini untuk menambah barang ke inventaris player dari enemy
        inventarisPlayer.addBarang(barang);
    }

    public void tambahHealth(int tambahan) {
        // Tambahkan kesehatan sebanyak 'tambahan'
        this.setHealth(this.getHealth() + tambahan);
    }

    public void tambahAttack(int tambahan) {
        // Tambahkan serangan sebanyak 'tambahan'
        this.setAttack(this.getAttack() + tambahan);
    }

    public void berikanInformasiPlayer() {//untuk memberikan informasi player
        super.berikanInformasi();
        System.out.println("Jenis Skill: " + getSkill());//ditambah dengan jenis skill
    }

    public void menyerangEnemy(Enemy target, Player player) {//method untuk player menyerang enemy
        System.out.println(this.getNama() + " menyerang " + target.getNama() + " dengan kekuatan serangan sebesar " + this.getAttack());
        target.diserangEnemy(this.getAttack(), player);//method diserang enemy ini untuk enemy ketika player menyerang maka health enemy berkurang 10 tiap diserang enemy
    }

    public void diserangPlayer(int damage) {//ini untuk player ketika player diserang enemy
        this.setHealth(this.getHealth() - damage);//maka darah player berkurang dengan attack yang diberikan oleh enemy
        System.out.println("Darah Player " + getNama() + " Berkurang Menjadi " + getHealth() +" AKU TIDAK AKAN MENYERAH!");
        if (this.getHealth() <= 0) {//kalau darah player kosong atau kurang dari 0
            System.out.println(this.getNama() + " telah dikalahkan!");//maka print bahwa player telah dikalahkan
        }
    }

    public void gunakanSkill(Karakter target) {//ini adalah method untuk player menggunakan skill
        switch (skill.toLowerCase()) {//ubah menjadi lowercase semua jenis skill
            case "heal"://kalau skillnya heal
                if (target instanceof Player) {//kalau targetnya player lain atau diri sendiri
                    ((Player) target).tambahHealth(10);//maka player tsb akan heal sebanyak 10
                    System.out.println(getNama() + " menggunakan skill Heal.");
                } else {//skill heal ini hanya bisa diguunakan untuk pemain
                    System.out.println("Skill Heal hanya dapat digunakan untuk pemain.");
                }
                break;
            case "strength"://kalau skillnya strentgh
                if (target instanceof Player) {//targetnya bisa untuk player lain atau diri sendiri
                    ((Player) target).tambahAttack(15);//player tsb akan menambah kekuattan attack sebanyak 15
                    System.out.println(getNama() + " menggunakan skill Strength.");
                } else {//sama dengan heal skill strentgh ini hanya bisa digunakan untuk pemain
                    System.out.println("Skill Strength hanya dapat digunakan untuk pemain.");
                }
                break;
            case "purify"://kalau skillnya purify
                if (target instanceof Enemy) {//targetnya hanya untuk musuh
                    ((Enemy) target).kurangiAttack(5);//mengurangi jumlah attack musuh sebanyak 5
                    System.out.println(getNama() + " menggunakan skill Purify untuk mengurangi attack musuh.");
                } else {
                    System.out.println("Skill Purify hanya dapat digunakan untuk musuh.");
                }
                break;
            default://kasih kondisi lain jika jenis skill tidak sesuai
                System.out.println("Skill tidak valid.");
        }
    }

}