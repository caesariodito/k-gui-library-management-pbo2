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
public class Majalah205314159 extends Koleksi205314159{
    
    protected String issn;
    protected int volume;
    protected int series;

    /**
     * @param issn
     * @param volume_series
     */
    public Majalah205314159(String id_koleksi, String judul, String penerbit, String tahun_terbit, boolean status, String issn, int volume, int series) {
        super(id_koleksi, judul, penerbit, tahun_terbit, status);
        this.issn = issn;
        this.volume = volume;
        this.series = series;
    }
    /**
     * @return the issn
     */
    public String getIssn() {
        return issn;
    }
    /**
     * @return the volume_series
     */
    public int getVolume() {
        return volume;
    }
    /**
     * @param volume_series the volume_series to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
    /**
     * @param issn the issn to set
     */
    public void setIssn(String issn) {
        this.issn = issn;
    }
    
    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String toString(){
        String temp = super.toString();
        temp = temp + "\nissn\t\t: " +getIssn() +"\nvol series\t: " +getVolume();
        return temp;
    }
}

