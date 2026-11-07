public class mobilListrik extends kendaraan implements MengisiDaya, modeOtonom {
    private int kapasitasBaterai;
    private boolean statusAutopilot;

    public mobilListrik(String nomorRangka, String merk, int kecepatan, int kapasitasBaterai) {
        super(nomorRangka, merk, kecepatan);
        this.kapasitasBaterai = kapasitasBaterai;
        this.statusAutopilot = false;
    }

    public mobilListrik(String nomorRangka, String merk) {
        super(nomorRangka, merk);
        this.kapasitasBaterai = 100;
        this.statusAutopilot = false;
    }

    @Override
    public void nyalakanMesin() {
        if (this.kapasitasBaterai > 10 && !isMesinMenyala()) {
            setMesinMenyala(true);
            this.kapasitasBaterai -= 1;
            System.out.println("[Mobil Listrik] Sistem kelistrikan " + getMerk() + " aktif. Baterai: " + this.kapasitasBaterai + "%");
        } else if (isMesinMenyala()) {
            System.out.println("[Mobil Listrik] Mesin " + getMerk() + " sudah dalam keadaan menyala.");
        } else {
            setMesinMenyala(false);
            System.out.println("[Mobil Listrik] Gagal menyala! Baterai kritis (" + this.kapasitasBaterai + "%). Harap isi daya.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Baterai       : " + this.kapasitasBaterai + "%");
        System.out.println("Mode Autopilot: " + (this.statusAutopilot ? "Aktif" : "Nonaktif"));
    }


    @Override
    public void isiDaya(int tambahanPersen) {
        if (this.kapasitasBaterai + tambahanPersen >= 100) {
            this.kapasitasBaterai = 100;
        } else {
            this.kapasitasBaterai += tambahanPersen;
        }
    }

    @Override
    public int cekKapasitasDaya() {
        return this.kapasitasBaterai;
    }

    @Override
    public void aktifkanAutopilot(String tujuan) {
        if (isMesinMenyala() && this.kapasitasBaterai >= 20) {
            this.statusAutopilot = true;
            setKecepatan(80);
            System.out.println("[Autopilot] Mode otonom aktif menuju " + tujuan + " pada kecepatan konstan 80 km/jam.");
        } else {
            System.out.println("[Autopilot] Gagal aktif! Pastikan mesin menyala dan baterai minimal 20%.");
        }
    }

    public int getKapasitasBaterai() {
        return this.kapasitasBaterai;
    }

    public void setKapasitasBaterai(int kapasitasBaterai) {
        this.kapasitasBaterai = kapasitasBaterai;
    }

    public boolean isStatusAutopilot() {
        return this.statusAutopilot;
    }

    public void setStatusAutopilot(boolean statusAutopilot) {
        this.statusAutopilot = statusAutopilot;
    }
}
