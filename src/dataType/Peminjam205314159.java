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
public class Peminjam205314159 implements Serializable{
    
    protected String id;
    protected String nama;
    protected String alamat;
    protected int maxPinjam;
    
    public Peminjam205314159() {
        this.id = "0000000";
        this.nama="noname";
        this.alamat="none";
        this.maxPinjam = 0;
    }
    
    /**
     * @param nama
     * @param alamat
     */
    public Peminjam205314159(String id, String nama, String alamat, int maxPinjam) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.maxPinjam = maxPinjam;
    }
    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }
    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }
    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the maxPinjam
     */
    public int getMaxPinjam() {
        return maxPinjam;
    }

    /**
     * @param maxPinjam the maxPinjam to set
     */
    public void setMaxPinjam(int maxPinjam) {
        this.maxPinjam = maxPinjam;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    public String toString(){
        String temp = "nama\t: " +getNama() +"\nalamat\t: " +getAlamat() +"\nmaks pinjam\t: " +getMaxPinjam();
        return temp;
    }
}

