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
public class Dosen205314159 extends Peminjam205314159{
    
    protected String nip;

    /**
     * @param nip
     */
    public Dosen205314159(String id, String nama, String alamat, int maxPinjam, String nip) {
        super(id, nama, alamat, maxPinjam);
        this.nip = nip;
    }

    /**
     * @return the nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * @param nip the nip to set
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    public String toString(){
        String temp = super.toString();
        temp = temp + "\nnip\t: " +getNip();
        return temp;
    }

}

