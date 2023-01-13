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
public class Buku205314159 extends Koleksi205314159{
    
    protected String isbn;
    protected int jum_halaman;
    /**
     * @param isbn
     * @param jum_halaman
     */
    public Buku205314159(String id_koleksi, String judul, String penerbit, String tahun_terbit, boolean status, String isbn, int jum_halaman) {
        super(id_koleksi, judul, penerbit, tahun_terbit, status);
        this.isbn = isbn;
        this.jum_halaman = jum_halaman;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * @return the jum_halaman
     */
    public int getJum_halaman() {
        return jum_halaman;
    }
    /**
     * @param jum_halaman the jum_halaman to set
     */
    public void setJum_halaman(int jum_halaman) {
        this.jum_halaman = jum_halaman;
    }
    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString(){
        String temp = super.toString();
        temp = temp + "\nisbn\t\t: " +getIsbn() +"\njum hal\t\t: " +getJum_halaman();
        return temp;
    }
}

