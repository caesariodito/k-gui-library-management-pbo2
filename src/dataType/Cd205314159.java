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
public class Cd205314159 extends Koleksi205314159{
    
    protected String isbn;
    protected String format;
    /**
     * @param isbn
     * @param format
     */
    public Cd205314159(String id_koleksi, String judul, String penerbit, String tahun_terbit, boolean status, String isbn, String format) {
        super(id_koleksi, judul, penerbit, tahun_terbit, status);
        this.isbn = isbn;
        this.format = format;
    }
    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }
    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }
    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString(){
        String temp = super.toString();
        temp = temp + "\nisbn\t\t: " +getIsbn() +"\nformat\t\t: " +getFormat();
        return temp;
    }
}

