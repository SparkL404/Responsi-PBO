public class Main {
    public static void main(String[] args) {
        System.out.println("SIMULASI SISTEM MANAJEMEN OTOMOTIF\n");

        System.out.println("Pengujian Mobil Listrik (Kondisi Baterai Kritis)");
        mobilListrik mobil1 = new mobilListrik("VIN-EV-2026-008", "Hyundai Ioniq 5", 0, 5);
        mobil1.nyalakanMesin();
        mobil1.tampilkanInfo();

        MengisiDaya stasiunCharging = mobil1;
        stasiunCharging.isiDaya(50);
        System.out.println("[Charging] Daya " + mobil1.getMerk() + " berhasil diisi. Kapasitas kini: " + stasiunCharging.cekKapasitasDaya() + "%");

        System.out.println("\nStarter Mesin");
        mobil1.nyalakanMesin();
        mobil1.nyalakanMesin();
        modeOtonom sistemOtonom = mobil1;
        sistemOtonom.aktifkanAutopilot("Ngawi");
        mobil1.tampilkanInfo();
        System.out.println("Estimasi jarak tempuh 1.5 jam: " + ((mobilListrik) sistemOtonom).hitungEstimasiJarak(1.5) + " km");

        System.out.println("\nPengujian Motor Bensin");
        motorBensin motor1 = new motorBensin("VIN-IF-2077-676", "Honda PCX", 60, 3.5);
        motor1.nyalakanMesin();
        motor1.tampilkanInfo();
        System.out.println("Estimasi jarak tempuh 1 jam: " + motor1.hitungEstimasiJarak(1) + " km");
    }
}