

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import dataType.*;

public class DaoPerpus205314159 {

    Peminjam205314159 peminjam;
    Koleksi205314159 koleksi;
    ArrayList<Peminjam205314159> peminjamList = new ArrayList<>();
    ArrayList<Koleksi205314159> koleksiList = new ArrayList<>();
    ArrayList<Transaksi205314159> transaksiList = new ArrayList<>();

    Connection conn;
    Statement stmt;
    ResultSet rset;
    String query;

    public DaoPerpus205314159() throws SQLException {
        DataHandler205314159 dataHandler = new DataHandler205314159();
        dataHandler.getDBConnection();
        //buat koneksi
        conn = dataHandler.conn;
        //fillData();
        syncData();

    }

    public void isiDataPeminjam(Peminjam205314159 data) {
        try {
            insertPeminjam(data);
            syncData();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerpus205314159.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void isiDataKoleksi(Koleksi205314159 data) {
        try {
            insertKoleksi(data);
            syncData();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerpus205314159.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void isiDataTransaksi(Transaksi205314159 data) {
        try {
            transaksiList.add(data);
            //blom ada sync
        } catch (Exception ex) {
            Logger.getLogger(DaoPerpus205314159.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteDataPeminjam(String id, String type) throws SQLException {
        System.out.println("processing deletePeminjam");
        try {
            String query = "DELETE FROM " + type + " WHERE id_peminjam = ?";
            PreparedStatement prpStmt = conn.prepareStatement(query);
            prpStmt.setString(1, id);
            prpStmt.execute();
        } catch (SQLException e) {
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
        System.out.println("delete success");
        syncData();
    }

    public void insertPeminjam(Peminjam205314159 pem) throws SQLException {
        System.out.println("processing insertPeminjam");
        try {

            stmt = conn.createStatement();
//            PreparedStatement preparedStmt = conn.prepareStatement(query);

            if (pem instanceof Dosen205314159) {
//                query = " insert into dosen (id_peminjam, nama, alamat, mak_pinjama, nip)"
//                        + " values (?, ?, ?, ?, ?)";
//
//                // create the mysql insert preparedstatement
//                preparedStmt.setString(1, pem.getId());
//                preparedStmt.setString(2, pem.getNama());
//                preparedStmt.setString(3, pem.getAlamat());
//                preparedStmt.setInt(4, pem.getMaxPinjam());
//                preparedStmt.setString(5, ((Dosen205314159) pem).getNip());

                stmt.executeUpdate("INSERT INTO dosen VALUES ('"
                        + pem.getId() + "', '" + pem.getNama() + "', '" + pem.getAlamat() + "', "
                        + pem.getMaxPinjam() + ", '" + ((Dosen205314159) pem).getNip() + "')");
            } else if (pem instanceof Mahasiswa205314159) {
                //belom diisi
                stmt.executeUpdate("INSERT INTO mahasiswa VALUES ('"
                        + pem.getId() + "', '" + pem.getNama() + "', '" + pem.getAlamat() + "', "
                        + pem.getMaxPinjam() + ", '" + ((Mahasiswa205314159) pem).getNo_mhs() + "')");
            } else {    //umum
                //belom diisi
                stmt.executeUpdate("INSERT INTO umum VALUES ('"
                        + pem.getId() + "', '" + pem.getNama() + "', '" + pem.getAlamat() + "', "
                        + pem.getMaxPinjam() + ", '" + ((MasyarakatUmum205314159) pem).getNo_ktp() + "')");
            }

            // execute the preparedstatement
//            preparedStmt.execute();
            System.out.println("Exceute insert success.");
        } catch (SQLException e) {
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
    }

    public void updatePeminjam(Peminjam205314159 pem) throws SQLException {
        System.out.println("processing updatePeminjam");
        try {
            String type = "", unique = "", type1 = "";
            if (pem instanceof Dosen205314159) {
                type = "dosen";
                type1 = "nip";
                unique = ((Dosen205314159) pem).getNip();
            } else if (pem instanceof Mahasiswa205314159) {
                type = "mahasiswa";
                type1 = "nim";
                unique = ((Mahasiswa205314159) pem).getNo_mhs();
            } else {
                type = "umum";
                type1 = "nik";
                unique = ((MasyarakatUmum205314159) pem).getNo_ktp();
            }
            String query = "UPDATE " + type
                    + " SET nama = ?,"
                    + "alamat = ?,"
                    + "mak_pinjam = ?,"
                    +type1 +" = ?"
                    + " where id_peminjam = ?";
            PreparedStatement prpStmt = conn.prepareStatement(query);
            prpStmt.setString(1, pem.getNama());
            prpStmt.setString(2, pem.getAlamat());
            prpStmt.setInt(3, pem.getMaxPinjam());
            prpStmt.setString(4, unique);
            prpStmt.setString(5, pem.getId());
            prpStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
        System.out.println("Update Success");
        syncData();
    }

    public void deleteDataKoleksi(String id, String type) throws SQLException {
        System.out.println("processing deleteKoleksi");
        try {
            String query = "DELETE FROM " + type + " WHERE id_koleksi = ?";
            PreparedStatement prpStmt = conn.prepareStatement(query);
            prpStmt.setString(1, id);
            prpStmt.execute();
        } catch (SQLException e) {
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
        System.out.println("delete success");
        syncData();
    }

    public void insertKoleksi(Koleksi205314159 kol) throws SQLException {
        System.out.println("processing insertKoleksi");
        try {
            stmt = conn.createStatement();
            if (kol instanceof Buku205314159) {
                stmt.executeUpdate("INSERT INTO buku VALUES ('"
                        + kol.getId_koleksi() + "', '" + kol.getJudul() + "', '" + kol.getPenerbit() + "', "
                        + booleanToInt(kol.isStatusPinjam()) + ", " + ((Buku205314159) kol).getJum_halaman() + ", '"
                        + ((Buku205314159) kol).getIsbn() + "')");
            } else if (kol instanceof Cd205314159) {
                stmt.executeUpdate("INSERT INTO dvd VALUES ('"
                        + kol.getId_koleksi() + "', '" + kol.getJudul() + "', '" + kol.getPenerbit() + "', "
                        + booleanToInt(kol.isStatusPinjam()) + ", '" + ((Cd205314159) kol).getFormat() + "', '"
                        + ((Cd205314159) kol).getIsbn() + "')");
            } else {    //majalah
                stmt.executeUpdate("INSERT INTO majalah VALUES ('"
                        + kol.getId_koleksi() + "', '" + kol.getJudul() + "', '" + kol.getPenerbit() + "', "
                        + booleanToInt(kol.isStatusPinjam()) + ", " + ((Majalah205314159) kol).getVolume()
                        + ", " + ((Majalah205314159) kol).getSeries() + ", '" + ((Majalah205314159) kol).getIssn() + "')");
            }
            System.out.println("Exceute insert success.");
        } catch (SQLException e) {
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
    }

    public void updateKoleksi(Koleksi205314159 kol, Koleksi205314159 input) {
        try {
            String type = "", unique = "", unique2 = "";
            int unique3 = 0, unique4 = 0;
            String query = "";
            if (kol instanceof Buku205314159) {
                type = "buku";
                unique = ((Buku205314159) kol).getIsbn();
                unique3 = ((Buku205314159) kol).getJum_halaman();
                query = "UPDATE " + type
                        + "SET id_koleksi = ?,"
                        + "SET judul = ?,"
                        + "SET penerbit = ?,"
                        + "SET status_pinjam = ?,"
                        + "SET halaman = ?"
                        + "SET isbn = ?,"
                        + "where id_peminjam = ?";
            } else if (kol instanceof Cd205314159) {
                type = "dvd";
                unique = ((Cd205314159) kol).getFormat();
                unique2 = ((Cd205314159) kol).getIsbn();
                query = "UPDATE " + type
                        + "SET id_koleksi = ?,"
                        + "SET judul = ?,"
                        + "SET penerbit = ?,"
                        + "SET status_pinjam = ?,"
                        + "SET format = ?"
                        + "SET isbn = ?,"
                        + "where id_peminjam = ?";
            } else {
                type = "majalah";
                unique3 = ((Majalah205314159) kol).getVolume();
                unique4 = ((Majalah205314159) kol).getSeries();
                unique = ((Majalah205314159) kol).getIssn();
                query = "UPDATE " + type
                        + "SET id_koleksi = ?,"
                        + "SET judul = ?,"
                        + "SET penerbit = ?,"
                        + "SET status_pinjam = ?,"
                        + "SET volume = ?"
                        + "SET seri = ?,"
                        + "SET issn = ?,"
                        + "where id_peminjam = ?";
            }
            PreparedStatement prpStmt = conn.prepareStatement(query);
            prpStmt.setString(1, kol.getId_koleksi());
            prpStmt.setString(2, kol.getJudul());
            prpStmt.setString(3, kol.getPenerbit());
            prpStmt.setInt(4, booleanToInt(kol.isStatusPinjam()));
            switch (type) {
                case "dvd":
                    prpStmt.setInt(5, unique3);
                    prpStmt.setString(6, unique);
                    prpStmt.setString(7, input.getId_koleksi());
                    break;
                case "buku":
                    prpStmt.setString(5, unique);
                    prpStmt.setString(6, unique2);
                    prpStmt.setString(7, input.getId_koleksi());
                    break;
                default:
                    prpStmt.setInt(5, unique3);
                    prpStmt.setInt(6, unique4);
                    prpStmt.setString(7, unique);
                    prpStmt.setString(8, input.getId_koleksi());
                    break;
            }
            prpStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
    }

    public void syncData() throws SQLException {
        peminjamList.clear();
        syncDosen();
        syncUmum();
        syncMahasiswa();

        koleksiList.clear();
        syncBuku();
        syncDvd();
        syncMajalah();
    }

    public void syncDosen() throws SQLException {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        query = "SELECT id_peminjam, nama, alamat, mak_pinjam, nip"
                + " FROM dosen";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);
        while (rset.next()) {
            Peminjam205314159 temp = new Dosen205314159(rset.getString(1), rset.getString(2),
                    rset.getString(3), rset.getInt(4), rset.getString(5));
            peminjamList.add(temp);
        }
    }

    public void syncUmum() throws SQLException {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        query = "SELECT id_peminjam, nama, alamat, mak_pinjam, nik"
                + " FROM umum";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);
        while (rset.next()) {
            Peminjam205314159 temp = new MasyarakatUmum205314159(rset.getString(1), rset.getString(2),
                    rset.getString(3), rset.getInt(4), rset.getString(5));
            peminjamList.add(temp);
        }
    }

    public void syncMahasiswa() throws SQLException {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        query = "SELECT id_peminjam, nama, alamat, mak_pinjam, nim"
                + " FROM mahasiswa";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);
        while (rset.next()) {
            Peminjam205314159 temp = new Mahasiswa205314159(rset.getString(1), rset.getString(2),
                    rset.getString(3), rset.getInt(4), rset.getString(5));
            peminjamList.add(temp);
        }
    }

    //String id_koleksi, String judul, String penerbit, String tahun_terbit, boolean status, String isbn, int jum_halaman
    public void syncBuku() throws SQLException {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        query = "SELECT *"
                + " FROM buku";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);
        while (rset.next()) {
            Koleksi205314159 temp = new Buku205314159(rset.getString(1), rset.getString(2),
                    rset.getString(3), yearGenerator(), intToBoolean(rset.getInt(4)), rset.getString(6), rset.getInt(5));
            koleksiList.add(temp);
        }
    }

    //String id_koleksi, String judul, String penerbit, String tahun_terbit, boolean status, String isbn, String format
    public void syncDvd() throws SQLException {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        query = "SELECT *"
                + " FROM dvd";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);
        while (rset.next()) {
            Koleksi205314159 temp = new Cd205314159(rset.getString(1), rset.getString(2),
                    rset.getString(3), yearGenerator(), intToBoolean(rset.getInt(4)), rset.getString(6), rset.getString(5));
            koleksiList.add(temp);
        }
    }

    //String id_koleksi, String judul, String penerbit, String tahun_terbit, boolean status, String issn, int volume, int series
    public void syncMajalah() throws SQLException {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        query = "SELECT *"
                + " FROM majalah";
        System.out.println("\nExecuting query: " + query);
        rset = stmt.executeQuery(query);
        while (rset.next()) {
            Koleksi205314159 temp = new Majalah205314159(rset.getString(1), rset.getString(2),
                    rset.getString(3), yearGenerator(), intToBoolean(rset.getInt(4)), rset.getString(7), rset.getInt(5), rset.getInt(6));
            koleksiList.add(temp);
        }
    }

    public boolean intToBoolean(int input) {
        return input == 1;
    }
    
    public int booleanToInt(boolean input){
        if(input == true){
            return 1;
        }else{
            return 0;
        }
    }

    public String yearGenerator() {
        Random r = new Random();
        int low = 2000;
        int high = 2021;
        int result = r.nextInt(high - low) + low;
        return String.valueOf(result);
    }

//    public void fillData() {
//        
//        ArrayList<Koleksi> temp = new ArrayList<>();
//        
//        try {
////            DateFormat format;
////            format = new SimpleDateFormat("dd/MM/yyyy");
//            peminjam = new Dosen205314159("D1", "Paulus Caesario Dito Putra Hartono", "Jl. Tluki Gege Gemink", 5, "205314159205314159");
//            peminjamList.add(peminjam);
//            peminjam = new Mahasiswa205314159("M1", "Ilham Gemink", "Jl. Godeanpeek 104", 5, "123123123");
//            peminjamList.add(peminjam);
//            peminjam = new MasyarakatUmum205314159("U1", "MakMak Warung", "Jl. Sebelah rumah", 5, "1231234526375643");
//            peminjamList.add(peminjam);
//        } catch (Exception e) {
//
//        }
////          catch (ParseException ex) {
////            Logger.getLogger(dataPeminjam.class.getName()).log(Level.SEVERE, null, ex);
////        }
// 
//        try {
////            DateFormat format;
////            format = new SimpleDateFormat("dd/MM/yyyy");
//            koleksi = new Cd205314159("D1", "Code Genesis", "Gramedya", "2017", true, "123123123123", "Audio");
//            temp.add(koleksi);
//            koleksiList.add(koleksi);
//            koleksi = new Majalah205314159("M1", "CNN News", "BBC", "2020", false, "123123123124", 5, 2);
//            koleksiList.add(koleksi);
//            koleksi = new Buku205314159("B1", "Pemrograman Berorientasi Objek 1", "Sanata Dharma", "2021", false, "123123123125", 100);
//            koleksiList.add(koleksi);
//        } catch (Exception e) {
//            //Logger.getLogger(dataPegawai.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        Peminjam205314159 pem1 = peminjam;
//        Transaksi205314159 trn1 = new Transaksi205314159("100/D1-D2-D3", LocalDate.now(), LocalDate.now().plusDays(3), 0, temp, pem1);
//        isiDataTransaksi(trn1);
//    }
}
