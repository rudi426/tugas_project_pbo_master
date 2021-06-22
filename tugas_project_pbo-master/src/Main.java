import model.Pegawai;
import model.PegawaiMagang;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {

        // Object 1
        Pegawai RudiMaulana = new Pegawai("KD-01", "M. Rudi Maulana", "Direktur", "Paringin", "18-05-2019", false);
        RudiMaulana.absensiPegawai("M. Rudi Maulana");
        RudiMaulana.tampilkanData();
        RudiMaulana.hitungGaji();

        System.out.println();

        // Object 2
        Pegawai udin = new Pegawai("KD-02", "M.udin", "Staf", "tanjung", "24-04-2018", true);
        udin.tampilkanData();
        udin.hitungGaji();

        System.out.println();

        // Object 3
        PegawaiMagang andi = new PegawaiMagang("MG-01", "M andi", "Banjarbaru", "POLTEKES", "10-05-2021", "17-08-2021");
        andi.absensiPegawai("m andi");
        andi.tampilkanDataPegawaiMagang();
        andi.hitungGajiMagang();

        System.out.println();

        // Object 4
        PegawaiMagang wawan = new PegawaiMagang("MG-02", "A. wawan", "Banjarbaru", "UNISKA", "19-06-2021", "21-07-2021");
        wawan.tampilkanDataPegawaiMagang();
        wawan.hitungGajiMagang();

        System.out.println();

        // Object 5
        Pegawai vicco = new Pegawai("KD-03", "Vicco Dwi P", "vicco", "vicco123");

        System.out.println();

        // Object 6
        Pegawai wahyu = new Pegawai("KD-04", "wahyudin akbar", "wahyu", "wahyu123");
    }

}
