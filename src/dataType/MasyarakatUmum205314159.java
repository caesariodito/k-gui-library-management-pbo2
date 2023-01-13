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
public class MasyarakatUmum205314159 extends Peminjam205314159{
    
    protected String no_ktp;

    /**
     * @param no_ktp
     */
    public MasyarakatUmum205314159(String id, String nama, String alamat, int maxPinjam, String no_ktp) {
        super(id, nama, alamat, maxPinjam);
        this.no_ktp = no_ktp;
    }

    /**
     * @return the no_ktp
     */
    public String getNo_ktp() {
        return no_ktp;
    }

    /**
     * @param no_ktp the no_ktp to set
     */
    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String toString(){
        String temp = super.toString();
        temp = temp + "\nno ktp\t: " +getNo_ktp();
        return temp;
    }

}

