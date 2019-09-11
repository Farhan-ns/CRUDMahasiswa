package com.example.crudmahasiswa.db;

public class MahasiswaBean {
    private int idMahasiswa = 0;
    private String nama = " EMPTY ";
    private String tglLahir = " EMPTY ";
    private String jenKel = " EMPTY ";
    private String alamat = " EMPTY ";

    public MahasiswaBean(int idMahasiswa, String nama, String tglLahir, String jenKel, String alamat) {
        this.idMahasiswa = idMahasiswa;
        this.nama = nama;
        this.tglLahir = tglLahir;
        this.jenKel = jenKel;
        this.alamat = alamat;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public String getNama() {
        return nama;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public String getJenKel() {
        return jenKel;
    }

    public String getAlamat() {
        return alamat;
    }
}
