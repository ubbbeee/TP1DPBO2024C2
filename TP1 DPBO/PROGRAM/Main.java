//    Saya Alfen Fajri Nurulhaq (2201431) mengerjakan TP1 DPBO simulasi game dalam mata
//    kuliah OOP untuk keberkahanNya maka saya tidak
//    melakukan kecurangan seperti yang telah dispesikasikan.Aamiin

public class Main {
    public static void main(String[] args) {
        // Membuat objek barang
        Barang goblet = new Barang("Goblet");
        Barang shell = new Barang("Shell");
        Barang crystal = new Barang("Crystal");
        Barang scroll = new Barang("Scroll");
        Barang mask = new Barang("Mask");
        Barang ore = new Barang("Ore");
        Barang gems = new Barang("Gems");

        // Membuat objek player
        Player player1 = new Player("Nova", "Laki-laki", "Warrior", "Panah", 15, 100, 20, "Strength");
        Player player2 = new Player("Jane", "Perempuan", "Healer", "Tongkat Sihir", 12, 80, 15, "Heal");
        Player player3 = new Player("Sora", "Laki-laki", "Wizard", "Tombak", 12, 100, 15, "Strength");
        Player player4 = new Player("Aloy", "Perempuan", "Rogue", "Dagger", 12, 100, 15, "Purify");

        // Menambahkan barang ke inventaris player
        player1.tambahBarangKeInventory(goblet);
        player2.tambahBarangKeInventory(shell);
        player3.tambahBarangKeInventory(crystal);
        player4.tambahBarangKeInventory(gems);

        // Membuat objek musuh
        Enemy goblin = new Enemy("Goblin", "Laki-laki", "Monster", "Tombak", 8, 50, 10, "Sedang");
        Enemy troll = new Enemy("Troll", "Laki-laki", "Monster", "Batu Besar", 12, 80, 15, "Berbahaya");

        // Menambahkan barang ke inventaris musuh
        goblin.getInventarisEnemy().addBarang(scroll);
        troll.getInventarisEnemy().addBarang(ore);
        troll.getInventarisEnemy().addBarang(mask);

        // Membuat objek NPC
        NPC questGiver = new NPC("Adrian", "Laki - Laki", "Misi Penghancuran",
                "Halo Pemain Tips untuk mengalahkan musuh adalah menggunakan skill", goblin);

        NPC informationGiver = new NPC("Lyra", "Perempuan",
                "Halo anda bisa menukarkan barang untuk menambah level anda");

        // Menampilkan informasi player, musuh, dan NPC
        System.out.println("Informasi Player 1:");
        player1.berikanInformasiPlayer();

        System.out.println("\nInformasi Player 2:");
        player2.berikanInformasiPlayer();
        
        System.out.println("\nInformasi Player 3:");
        player3.berikanInformasiPlayer();

        System.out.println("\nInformasi Player 4:");
        player4.berikanInformasiPlayer();

        System.out.println("\nInformasi Musuh Goblin:");
        goblin.berikanInformasiMusuh();

        System.out.println("\nInformasi Musuh Troll:");
        troll.berikanInformasiMusuh();
        
        System.out.println("\nInformasi NPC Quest Giver:");
        questGiver.berikanInformasiNPC(player1);

        System.out.println("\nInformasi NPC Information Giver:");
        informationGiver.berikanInformasiNPC(player1);

        // Memberikan quest kepada player 1 dari NPC
        System.out.println("\nQuest yang diberikan oleh NPC:");
        questGiver.berikanQuest(player1);

        /*
         *PERTARUNGAN ANTAR PLAYER DENGAN MUSUH 
         */

        // Player 1 menyerang musuh
        System.out.println("\nPlayer 1 menyerang musuh:");
        player1.menyerangEnemy(goblin, player1);

        // Musuh menyerang player 1
        System.out.println("\nMusuh menyerang Player 1:");
        goblin.enemyMenyerang(player1);

        // Player 3 menyerang musuh
        System.out.println("\nPlayer 3 menyerang musuh:");
        player1.menyerangEnemy(goblin, player3);

        // Musuh menyerang player 3
        System.out.println("\nMusuh menyerang Player 3:");
        goblin.enemyMenyerang(player3);

        // Player menggunakan skill
        System.out.println("\nPlayer 2 menggunakan skill kepada musuh:");
        player2.gunakanSkill(goblin);

        System.out.println("\nPlayer 2 menggunakan skill kepada sesama player:");
        player2.gunakanSkill(player1);

        System.out.println("\nPlayer 4 menggunakan skill kepada musuh:");
        player4.gunakanSkill(goblin);

        // Musuh menyerang player 2
        System.out.println("\nMusuh menyerang Player 2:");
        troll.enemyMenyerang(player2);

        System.out.println("\nMusuh menyerang Player 4:");
        goblin.enemyMenyerang(player4);

        //player 1 menyerang enemy
        System.out.println("\nPlayer 1 menyerang Musuh:");
        player1.menyerangEnemy(goblin, player1);

        // Menampilkan inventaris player setelah pertempuran
        System.out.println("\nInventaris Player 1 setelah pertempuran:");
        System.out.println(player1.getInventarisPlayer());

        // Menampilkan inventaris musuh setelah pertempuran
        System.out.println("\nInventaris Musuh Goblin setelah pertempuran:");
        System.out.println(goblin.getInventarisEnemy());

        System.out.println("\nPlayer 1 memberikan barang ke NPC");
        player1.memberikanBarang(goblet, questGiver);

        // Menampilkan inventaris NPC setelah mendapat barang dari player
        System.out.println("\nInventaris NPC setelah mendapat barang dari Player 1:");
        System.out.println(questGiver.getInventarisNPC());

        System.out.println("\nLevel Player Meningkat:!");
        player1.berikanInformasiPlayer();
    }
}
