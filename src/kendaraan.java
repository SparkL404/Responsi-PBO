public abstract class kendaraan {
    public static final int BATAS_KECEPATAN_MAKS = 220;
    private final String nomorRangka;

    private String merk;
    private int kecepatan;
    private boolean mesinMenyala;

    public kendaraan(String nomorRangka, String merk, int kecepatan) {
        this.nomorRangka = nomorRangka;
        this.merk = merk;
        this.kecepatan = kecepatan;
        this.mesinMenyala = false;
    }

    public kendaraan(String nomorRangka, String merk) {
        this(nomorRangka, merk, 0);
    }

    public abstract void nyalakanMesin();

    public void tampilkanInfo() {
        System.out.println("Nomor Rangka  : " + getNomorRangka());
        System.out.println("Merk          : " + getMerk());
        System.out.println("Status Mesin  : " + (isMesinMenyala() ? "Menyala" : "Mati"));
        System.out.println("Kecepatan     : " + getKecepatan() + " km/jam (Batas: " + BATAS_KECEPATAN_MAKS + " km/jam)");
    }

    public double hitungEstimasiJarak(double waktuJam) {
        if (!isMesinMenyala()) {
            return 0.0;
        }
        return getKecepatan() * waktuJam;
    }

    public String getNomorRangka() {
        return this.nomorRangka;
    }

    public String getMerk() {
        return this.merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getKecepatan() {
        return this.kecepatan;
    }

    public void setKecepatan(int kecepatan) {
        if (kecepatan <= BATAS_KECEPATAN_MAKS && kecepatan >= 0) {
            this.kecepatan = kecepatan;
        } else {
            System.out.println("[Peringatan] Kecepatan tidak valid atau melebihi batas maksimal!");
        }
    }

    public boolean isMesinMenyala() {
        return this.mesinMenyala;
    }

    public void setMesinMenyala(boolean mesinMenyala) {
        this.mesinMenyala = mesinMenyala;
    }
}
