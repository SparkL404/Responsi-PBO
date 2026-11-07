public class motorBensin extends kendaraan {
    private double literBensin;

    public motorBensin(String nomorRangka, String merk, int kecepatan, double literBensin) {
        super(nomorRangka, merk, kecepatan);
        this.literBensin = literBensin;
    }

    public motorBensin(String nomorRangka, String merk) {
        super(nomorRangka, merk);
        this.literBensin = 4.5;
    }

    @Override
    public void nyalakanMesin() {
        if (this.literBensin >= 0.5 && !isMesinMenyala()) {
            setMesinMenyala(true);
            this.literBensin -= 0.1;
            System.out.println("[Motor Bensin] Mesin " + getMerk() + " mber menyala! Sisa Bensin: " + this.literBensin + " liter.");
        } else if (isMesinMenyala()) {
            System.out.println("[Motor Bensin] Mesin sudah menyala.");
        } else {
            setMesinMenyala(false);
            System.out.println("[Motor Bensin] Gagal menyala! Bensin habis/kritis (" + this.literBensin + " liter).");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Sisa BBM      : " + this.literBensin + " Liter");
    }

    public double getLiterBensin() {
        return this.literBensin;
    }

    public void setLiterBensin(double literBensin) {
        this.literBensin = literBensin;
    }
}
