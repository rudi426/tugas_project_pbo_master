package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pegawai {
    // Atribut
    public String idPegawai, nama, jabatan, alamat, pesanAbsen, username, password;
    public int gajiPokok, lamaKerja;
    public Date tglPertamaKerja;
    public Boolean menikah, absen;

    String polaTanggal = "dd-MM-yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(polaTanggal);

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPesanAbsen() {
        return pesanAbsen;
    }

    public void setPesanAbsen(String pesanAbsen) {
        this.pesanAbsen = pesanAbsen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public int getLamaKerja() {
        return lamaKerja;
    }

    public void setLamaKerja(int lamaKerja) {
        this.lamaKerja = lamaKerja;
    }

    public Date getTglPertamaKerja() {
        return tglPertamaKerja;
    }

    public void setTglPertamaKerja(Date tglPertamaKerja) {
        this.tglPertamaKerja = tglPertamaKerja;
    }

    public Boolean getMenikah() {
        return menikah;
    }

    public void setMenikah(Boolean menikah) {
        this.menikah = menikah;
    }

    public Boolean getAbsen() {
        return absen;
    }

    public void setAbsen(Boolean absen) {
        this.absen = absen;
    }

    // Constructor 1
    public Pegawai(String idPegawai, String nama, String jabatan, String alamat, String tglPertamaKerja, Boolean menikah) throws ParseException {
        this.pesanAbsen = "";
        this.absen = false;

        this.idPegawai = idPegawai;
        this.nama = nama;
        this.jabatan = inputJabatan(jabatan);
        this.alamat = alamat;
        this.tglPertamaKerja = sdf.parse(tglPertamaKerja);
        this.lamaKerja = hitungLamaKerja();
        this.menikah = menikah;
    }

    // Constructor 2, Blueprint Untuk Constructor di Model PegawaiMagang
    public Pegawai(String idPegawai, String nama, String alamat, String asalKampus, String tglMulaiMagang, String tglAkhirMagang) {
    }

    // Constructor 3
    public Pegawai(String idPegawai, String nama, String username, String password) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.username = username;
        this.password = password;

        System.out.println("---------------------------------");
        System.out.println("  Username dan Password Pegawai  ");
        System.out.println("---------------------------------");
        System.out.println("ID Pegawai = " + idPegawai);
        System.out.println("Nama = " + nama);
        System.out.println("Username = " + username);
        System.out.println("Password = " + password);
    }

    // Method 1
    public void absensiPegawai(String nama) {
        if (nama.equalsIgnoreCase(this.nama)) {
            this.absen = true;
        } else {
            pesanAbsen = nama + " Tidak Terdaftar di Data Pegawai";
        }
    }

    // Method 2
    public int hitungLamaKerja() {
        Calendar tglPertamaKerja = Calendar.getInstance();
        tglPertamaKerja.setTime(this.tglPertamaKerja);
        Calendar hariIni = Calendar.getInstance();

        int selisihTahun = hariIni.get(Calendar.YEAR) -  tglPertamaKerja.get(Calendar.YEAR);

        if (hariIni.get(Calendar.MONTH) < tglPertamaKerja.get(Calendar.MONTH)) {
            selisihTahun--;
        } else if (hariIni.get(Calendar.MONTH) == tglPertamaKerja.get(Calendar.MONTH) && hariIni.get(Calendar.DAY_OF_MONTH) < tglPertamaKerja.get(Calendar.DAY_OF_MONTH)) {
            selisihTahun--;
        }

        return selisihTahun;
    }

    // Method 3
    public void tampilkanData() {
        if (this.jabatan.equals("Direktur") || this.jabatan.equals("Manajer") || this.jabatan.equals("Staf")) {
            String polaTanggal = "dd-MM-yyyy";
            String absen;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(polaTanggal);

            System.out.println("---------------------------------");
            System.out.println("          Data Pegawai           ");
            System.out.println("---------------------------------");
            System.out.println("ID Pegawai = " + this.idPegawai);
            System.out.println("Nama = " + this.nama);
            System.out.println("Jabatan = " + this.jabatan);
            System.out.println("Gaji Pokok = " + this.gajiPokok);
            System.out.println("Tanggal Pertama Kerja = " + simpleDateFormat.format(this.tglPertamaKerja));
            System.out.println("Alamat = " + this.alamat);
            System.out.println("Lama Kerja = " + this.lamaKerja + " Tahun");

            if (this.menikah) {
                System.out.println("Menikah = Sudah Menikah");
            } else {
                System.out.println("Menikah = Belum Menikah");
            }

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
        } else {
            System.out.println("Maaf " + this.nama + ", Jabatan Yang Anda Masukkan Tidak Tersedia, Silahkan Input Ulang");
            System.out.println("Jabatan Yang Tersedia : ");
            System.out.println("1.Manajer");
            System.out.println("2.Direktur");
            System.out.println("3.Staf");
        }
    }

    // Method 4
    public String inputJabatan(String jabatan) {
        switch (jabatan) {
            case "Direktur" -> {
                this.jabatan = jabatan;
                this.gajiPokok = 8000000;
            }
            case "Manajer" -> {
                this.jabatan = jabatan;
                this.gajiPokok = 7000000;
            }
            case "Staf" -> {
                this.jabatan = jabatan;
                this.gajiPokok = 6000000;
            } default -> this.jabatan = jabatan;
        }
        return this.jabatan;
    }

    // Method 5
    public void hitungGaji() {
        if (this.jabatan.equals("Direktur") || this.jabatan.equals("Manajer") || this.jabatan.equals("Staf")) {
            int bonus, tunjangan, gajiTotal;

            if (lamaKerja >= 1 && lamaKerja < 3) {
                bonus = 1000000;
            } else if (lamaKerja >= 3) {
                bonus = 1500000;
            } else {
                bonus = 0;
            }

            if (menikah) {
                tunjangan = 750000;
            } else {
                tunjangan = 0;
            }

            gajiTotal = this.gajiPokok + bonus + tunjangan;

            System.out.println("---------------------------------");
            System.out.println("      Menghitung Total Gaji      ");
            System.out.println("---------------------------------");

            System.out.println("Gaji Pokok = " + gajiPokok);
            System.out.println("Bonus Kerja " + this.lamaKerja + " Tahun = " + bonus);
            System.out.println("Tunjangan Menikah = " + tunjangan);
            System.out.println("Total Gaji " + this.nama + " = " + gajiTotal);
        }
    }

}
