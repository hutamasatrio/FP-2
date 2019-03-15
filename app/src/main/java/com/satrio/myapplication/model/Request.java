package com.satrio.myapplication.model;

import java.io.Serializable;

public class Request implements Serializable{

    private String namabarang;
    private String key;
    public String hargatotal;
    public String gambarproduk;
    public String alamatpemesanan;
    public String atmpemesanan;
    public String deskripsibarang;
    public String jumlahbarang;

    public Request() {
    }

    public Request(String namabarang, String hargatotal, String gambarproduk, String alamatpemesanan, String atmpemesanan, String deskripsibarang, String jumlahbarang) {
        this.namabarang = namabarang;
        this.key = key;
        this.hargatotal = hargatotal;
        this.gambarproduk = gambarproduk;
        this.alamatpemesanan = alamatpemesanan;
        this.atmpemesanan = atmpemesanan;
        this.deskripsibarang = deskripsibarang;
        this.jumlahbarang = jumlahbarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHargatotal() {
        return hargatotal;
    }

    public void setHargatotal(String hargatotal) {
        this.hargatotal = hargatotal;
    }

    public String getGambarproduk() {
        return gambarproduk;
    }

    public void setGambarproduk(String gambarproduk) {
        this.gambarproduk = gambarproduk;
    }

    public String getAlamatpemesanan() {
        return alamatpemesanan;
    }

    public void setAlamatpemesanan(String alamatpemesanan) {
        this.alamatpemesanan = alamatpemesanan;
    }

    public String getAtmpemesanan() {
        return atmpemesanan;
    }

    public void setAtmpemesanan(String atmpemesanan) {
        this.atmpemesanan = atmpemesanan;
    }

    public String getDeskripsibarang() {
        return deskripsibarang;
    }

    public void setDeskripsibarang(String deskripsibarang) {
        this.deskripsibarang = deskripsibarang;
    }

    public String getJumlahbarang() {
        return jumlahbarang;
    }

    public void setJumlahbarang(String jumlahbarang) {
        this.jumlahbarang = jumlahbarang;
    }



    @Override
    public String toString() {
        return  ""+namabarang+"\n"+
                ""+hargatotal+"\n"+
                ""+gambarproduk+"\n"+
                ""+alamatpemesanan+"\n"+
                ""+atmpemesanan+"\n"+
                ""+deskripsibarang+"\n"+
                ""+jumlahbarang+"\n";
    }
}

