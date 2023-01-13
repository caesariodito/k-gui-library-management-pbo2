/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType;

import java.io.Serializable;

/**
 *
 * @author Dito
 */
public class Koleksi205314159 implements Serializable{
    
    protected String id_koleksi;
    protected String judul;
    protected String penerbit;
    protected String tahun_terbit;
    protected boolean statusPinjam;
    
    public Koleksi205314159() {
        this.id_koleksi = "0000000";
        this.judul="noTitle";
        this.penerbit="none";
        this.statusPinjam = Boolean.FALSE;
    }
    
    /**
     * @param id_koleksi
     * @param judul
     * @param penerbit
     * @param tahun_terbit
     */
    public Koleksi205314159(String id_koleksi, String judul, String penerbit, String tahun_terbit, boolean status) {
        this.id_koleksi = id_koleksi;
        this.judul = judul;
        this.penerbit = penerbit;
        this.tahun_terbit = tahun_terbit;
        this.statusPinjam = status;
    }
    
    /**
     * @return the id_koleksi
     */
    public String getId_koleksi() {
        return id_koleksi;
    }
    /**
     * @return the tahun_terbit
     */
    public String getTahun_terbit() {
        return tahun_terbit;
    }
    /**
     * @param tahun_terbit the tahun_terbit to set
     */
    public void setTahun_terbit(String tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }
    /**
     * @return the penerbit
     */
    public String getPenerbit() {
        return penerbit;
    }
    /**
     * @param penerbit the penerbit to set
     */
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    /**
     * @return the judul
     */
    public String getJudul() {
        return judul;
    }
    /**
     * @param judul the judul to set
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }
    /**
     * @param id_koleksi the id_koleksi to set
     */
    public void setId_koleksi(String id_koleksi) {
        this.id_koleksi = id_koleksi;
    }

    public String toString(){
        String temp = "id\t\t: " +getId_koleksi() + "\njudul\t\t: " +getJudul() + "\npenerbit\t: " +getPenerbit() + "\ntahun terbit\t: " + getTahun_terbit()
                +"\nstatus pinjam: " +isStatusPinjam();
        return temp;
    }

    /**
     * @return the statusPinjam
     */
    public boolean isStatusPinjam() {
        return statusPinjam;
    }

    /**
     * @param statusPinjam the statusPinjam to set
     */
    public void setStatusPinjam(boolean statusPinjam) {
        this.statusPinjam = statusPinjam;
    }
    
}

