/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import dataType.*;

/**
 *
 * @author Dito
 */
public class Transaksi205314159 implements Serializable{
    protected String id_transaksi;
    protected LocalDate tgl_pinjam;
    protected LocalDate tgl_kembali;
    protected float denda = 0;
    protected ArrayList<Koleksi205314159> arkoleksi;
    protected Peminjam205314159 peminjam;
    static final float priceDenda = 2000; 
    
    public Transaksi205314159() {
        this.id_transaksi = "0000000";
        this.tgl_pinjam=LocalDate.of(2020, 2, 20);
        this.tgl_kembali=LocalDate.of(2020, 2, 20);
        this.denda=0;
        this.arkoleksi = new ArrayList<Koleksi205314159>();
        this.peminjam = new Peminjam205314159();
    }

    public Transaksi205314159(String id_transaksi, LocalDate tgl_pinjam, LocalDate tgl_kembali, int denda, ArrayList<Koleksi205314159> arkoleksi, Peminjam205314159 peminjam) {
        this.id_transaksi = id_transaksi;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
        this.denda = denda;
        this.arkoleksi = arkoleksi;
        this.peminjam = peminjam;
    }

    public void pinjam(String id_transaksi, ArrayList<Koleksi205314159> arkoleksi, Peminjam205314159 peminjam){
        this.id_transaksi = id_transaksi;
        tgl_pinjam = LocalDate.now();
        tgl_kembali = tgl_pinjam;
        this.denda = 0;
        this.arkoleksi = arkoleksi;
        this.peminjam = peminjam;
        
    }
    public void kembali(){
        LocalDate harini = LocalDate.now();
        this.tgl_kembali = harini;
        long telat =  ChronoUnit.DAYS.between(tgl_pinjam, harini);
        if (telat > 30) {
            denda = (telat - 30)* priceDenda;
        }
    }

    /**
     * @return the id_transaksi
     */
    public String getId_transaksi() {
        return id_transaksi;
    }

    /**
     * @param id_transaksi the id_transaksi to set
     */
    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    /**
     * @return the tgl_pinjam
     */
    public LocalDate getTgl_pinjam() {
        return tgl_pinjam;
    }

    /**
     * @param tgl_pinjam the tgl_pinjam to set
     */
    public void setTgl_pinjam(LocalDate tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    /**
     * @return the tgl_kembali
     */
    public LocalDate getTgl_kembali() {
        return tgl_kembali;
    }

    /**
     * @param tgl_kembali the tgl_kembali to set
     */
    public void setTgl_kembali(LocalDate tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    /**
     * @return the denda
     */
    public float getDenda() {
        return denda;
    }

    /**
     * @param denda the denda to set
     */
    public void setDenda(float denda) {
        this.denda = denda;
    }

    /**
     * @return the peminjam
     */
    public Peminjam205314159 getPeminjam() {
        return peminjam;
    }

    /**
     * @param peminjam the peminjam to set
     */
    public void setPeminjam(Peminjam205314159 peminjam) {
        this.peminjam = peminjam;
    }
    
    public ArrayList<Koleksi205314159> getArrKoleksi(){
        return arkoleksi;
    }
    
    public int getYearKembali(){
        return this.tgl_kembali.getYear();
    }
    
    public int getYearPinjam(){
        return this.tgl_pinjam.getYear();
    }
    
//    protected String id_transaksi;
//    protected LocalDate tgl_pinjam;
//    protected LocalDate tgl_kembali;
//    protected float denda = 0;
//    protected ArrayList<Koleksi> arkoleksi;
//    protected Peminjam205314159 peminjam;
//    static final float priceDenda = 2000; 
    
    public String toString(){
        return "{\n\t" + "Id Transaksi: " +getId_transaksi() +"\n\t" +"Tgl Pinjam: " +getTgl_pinjam().toString() 
                +"\n\t" +"Tgl Kembali: " +getTgl_kembali().toString() +"\n\t" +"Denda: " +getDenda() +"\n\t"
                +"List Koleksi:\n" +getArrKoleksi().toString() +"\n\t" +"Peminjam: " +getPeminjam().getNama()
                +"\n}";
    }
    
}
