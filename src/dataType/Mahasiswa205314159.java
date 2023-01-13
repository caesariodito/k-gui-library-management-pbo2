/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType;

/**
 *
 * @author Dito
 */
public class Mahasiswa205314159 extends Peminjam205314159{
    
    protected String no_mhs;

    /**
     * @param no_mhs
     */
    public Mahasiswa205314159(String id, String nama, String alamat, int maxPinjam, String no_mhs) {
        super(id, nama, alamat, maxPinjam);
        this.no_mhs = no_mhs;
    }

    /**
     * @return the no_mhs
     */
    public String getNo_mhs() {
        return no_mhs;
    }

    /**
     * @param no_mhs the no_mhs to set
     */
    public void setNo_mhs(String no_mhs) {
        this.no_mhs = no_mhs;
    }

    public String toString(){
        String temp = super.toString();
        temp = temp + "\nno mhs\t: " +getNo_mhs();
        return temp;
    }

}

