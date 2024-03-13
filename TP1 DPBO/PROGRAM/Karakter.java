//    Saya Alfen Fajri Nurulhaq (2201431) mengerjakan TP1 DPBO simulasi game dalam mata
//    kuliah OOP untuk keberkahanNya maka saya tidak
//    melakukan kecurangan seperti yang telah dispesikasikan.Aamiin

//class Karakter
class Karakter{
    private String nama;//properti untuk nama karakter
    private String jenisKelamin;//properti untuk gender karakter
    private String role;//properti untuk role karakter
    private String senjata;//properti untuk senjata karakter
    private int level;//properti untuk level karakter
    private int health;//properti untuk health karakter
    private int attack;//properti untuk attack karakter

    public Karakter (){//constructor default
        this.nama = "";
        this.jenisKelamin = "";
        this.role = "";
        this.senjata = "";
        this.level = 1;
        this.health = 100;
        this.attack = 0;
    }

    public Karakter (String nama, String jenisKelamin){//constructor ini dibuat untuk NPC supaya cuma ada nama dan gender saja
        this.nama = nama;
        this.jenisKelamin = nama;
    }

    public Karakter (String nama, String jenisKelamin, String role, String senjata, int level, int health, int attack){//constructor dengan seluruh parameter properti untuk player dan emeny
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.role = role;
        this.senjata = senjata;
        this.level = level;
        this.health = health;
        this.attack = attack;
    }
    //getter setter untuk masing masing atribut
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSenjata() {
        return senjata;
    }

    public void setSenjata(String senjata) {
        this.senjata = senjata;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    //ini untuk memberikan informasi player dan enemy
    public void berikanInformasi() {
        System.out.println("Nama: " + getNama());
        System.out.println("Jenis Kelamin: " + getJenisKelamin());
        System.out.println("Role: " + getRole());
        System.out.println("Senjata: " + getSenjata());
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack: " + getAttack());
    }
}
