/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5_2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java. sql.Blob;
import java.util.ArrayList;
import java.util.List;
//import javax.imageio.ImageIO;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hp
 */
public class dbConnection {
    public static Connection con;
    public static Statement stm;
    private ArrayList<Buku> listBuku;
    private ArrayList<Author> listAuthor;
    
    public void connect(){//untuk membuka koneksi ke database
        try {
            String url ="jdbc:mysql://localhost/db_tp5";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
            System.out.println("koneksi berhasil;");
        } catch (Exception e) {
            System.err.println("koneksi gagal" +e.getMessage());
        }
    }
    

    
    public ArrayList<Buku> getItemListBuku(){
        
        listBuku = new ArrayList<>();
        
        try{
            connect();
            ResultSet rs = stm.executeQuery("SELECT * FROM buku");
            
            Buku buku;
            while(rs.next()){
                buku = new Buku(rs.getInt("id_buku"), rs.getString("nama"), 
                        rs.getString("genre"), rs.getBytes("image"));
                
                listBuku.add(buku);
                
            }
            
        }catch (Exception e){
            System.err.println("Read gagal " +e.getMessage());

        }
        
        return listBuku;
    }
    
       
    public ArrayList<Author> getItemListAuthor(){
        
        listAuthor = new ArrayList<>();
        try{
            connect();
            ResultSet rs = stm.executeQuery("SELECT * FROM author");
            
            Author author;
            while(rs.next()){
                author = new Author(rs.getInt("id_author"), rs.getString("nama"),
                        rs.getInt("jumlah_buku"), rs.getString("email"), rs.getBytes("image"));
                listAuthor.add(author);
                
            }
            
            
        }catch (Exception e){
            System.err.println("Read gagal " +e.getMessage());

        }
//        
        return listAuthor;
    }
    
    public void Query(String inputan){
        
        try{
            connect();
            String sql = inputan;
            stm.execute(sql);
            
        }catch(Exception e){
            System.err.println("Read gagal " +e.getMessage());
        }
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
