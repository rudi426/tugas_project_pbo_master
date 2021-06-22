package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PegawaiMagang extends Pegawai {
    // Atribut
    public String asalKampus;
    public int lamaMagang;
    public Date tglMulaiMagang, tglAkhirMagang;

    String polaTanggal = "dd-MM-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(polaTanggal);

    public String getAsalKampus() {
        return asalKampus;
    }

    public void setAsalKampus(String asalKampus) {
        this.asalKampus = asalKampus;
    }

    public int getLamaMagang() {
        return lamaMagang;
    }

    public void setLamaMagang(int lamaMagang) {
        this.lamaMagang = lamaMagang;
    }

    public Date getTglMulaiMagang() {
        return tglMulaiMagang;
    }

    public void setTglMulaiMagang(Date tglMulaiMagang) {
        this.tglMulaiMagang = tglMulaiMagang;
    }

    public Date getTglAkhirMagang() {
        return tglAkhirMagang;
    }

    public void setTglAkhirMagang(Date tglAkhirMagang) {
        this.tglAkhirMagang = tglAkhirMagang;
    }

    public PegawaiMagang(String idPegawai, String nama, String alamat, String asalKampus, String tglMulaiMagang, String tglAkhirMagang) throws ParseException {
        super(idPegawai, nama, alamat, asalKampus, tglMulaiMagang, tglAkhirMagang);
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.alamat = alamat;
        this.asalKampus = asalKampus;
        this.jabatan = "Magang";
        this.tglMulaiMagang = simpleDateFormat.parse(tglMulaiMagang);
        this.tglAkhirMagang = simpleDateFormat.parse(tglAkhirMagang);
        this.lamaMagang = hitungLamaMagang();
        this.absen = false;
        this.pesanAbsen = "";
    }

    // Overriding 1
    public boolean cariPegawaiMagang() {
        system.out.println("--------------------------------");
        system.out.println("        Hasil Pencarian         ");
        system.out.println("--------------------------------");
        system.out.println("ID Pegawai : " + this.idPegawai);
        system.out.println("Nama : " + this.nama);
        return false;
    }

    // Overriding 2
    public boolean cariPegawaiMagang(String asalKampus) {
        system.out.println("--------------------------------");
        system.out.println("        Hasil Pencarian         ");
        system.out.println("--------------------------------");
        system.out.println("ID Pegawai : " + this.idPegawai);
        system.out.println("Nama : " + this.nama);
        return false;
    }

    // Method 1
    public int hitungLamaMagang() {
        Calendar tglMulaiMagang = Calendar.getInstance();
        tglMulaiMagang.setTime(this.tglMulaiMagang);
        Calendar tglAkhirMagang = Calendar.getInstance();
        tglAkhirMagang.setTime(this.tglAkhirMagang);

        int selisihBulan = tglAkhirMagang.get(Calendar.MONTH) -  tglMulaiMagang.get(Calendar.MONTH);

        if (tglAkhirMagang.get(Calendar.DAY_OF_MONTH) < tglMulaiMagang.get(Calendar.DAY_OF_MONTH)) {
            selisihBulan--;
        }

        return selisihBulan;
    }

    // Method 2
    public void hitungGajiMagang() {
        int gajiPerBulan = 2000000;

        int gajiTotal = lamaMagang * gajiPerBulan;

        System.out.println("---------------------------------");
        System.out.println(" Menghitung Gaji Pegawai Magang  ");
        System.out.println("---------------------------------");

        System.out.println("Gaji Per Bulan = " + gajiPerBulan);
        System.out.println(this.nama + " Magang Selama " + lamaMagang + " Bulan = " + lamaMagang + " * " + gajiPerBulan);
        System.out.println("Total Gaji " + this.nama + " = " + gajiTotal);
    }

    public void tampilkanDataPegawaiMagang() {
        String polaTanggal = "dd-MM-yyyy";
        String absen;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(polaTanggal);

        System.out.println("---------------------------------");
        System.out.println("       Data Pegawai Magang       ");
        System.out.println("---------------------------------");
        System.out.println("ID Pegawai = " + this.idPegawai);
        System.out.println("Nama = " + this.nama);
        System.out.println("Asal Kampus = " + this.asalKampus);
        System.out.println("Jabatan = " + this.jabatan);
        System.out.println("Alamat = " + this.alamat);
        System.out.println("Tanggal Mulai Magang = " + simpleDateFormat.format(this.tglMulaiMagang));
        System.out.println("Tanggal Akhir Magang = " + simpleDateFormat.format(this.tglAkhirMagang));
        System.out.println("Lama Magang = " + this.lamaMagang + " Bulan");

        if (this.absen) {
            absen = "Hadir";
        } else {
            absen = "Tidak Hadir";
        }

        System.out.println("---------------------------------");
        System.out.println("         Absensi Pegawai         ");
        System.out.println("---------------------------------");
        if (pesanAbsen.isEmpty()) {
            System.out.println(this.nama + " " + simpleDateFormat.format(new Date()) + " = " + absen);
        } else {
            System.out.println(pesanAbsen);
        }
    }
}
