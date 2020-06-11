package Tampilan;
/*import komponen dari SQL agar proses pada database dapat dilakukan*/
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Faiz Muazzam
 */
public class Koneksi 
{
    //Deklarasi Connector
    com.sun.jdi.connect.spi.Connection getConnection;
    //Buat methot yang sama dengan nama class
    public Koneksi(){
    }
    //Buat methot bukaKoneksi untuk membuat koneksi dengan data base
    public static Connection bukaKoneksi()throws SQLException{
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");//Contoh Driver MySQL
            //Format URL dimana lokasi data base disimpan 
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbhamasah","root","");
            //Tampilan Ketika sudah terhubung
            System.out.println("Connection Success");
            return con;
        }
        
        catch(SQLException se){
            //Tampilan Jika Belum Terhubung
            JOptionPane.showMessageDialog(null,"Coba Lagi");
            System.out.println("No Connection open");
            return null;
        }
        catch(Exception ex){
            //Tampilan Jika Tidak Ada Data Base yang tersedia
            JOptionPane.showMessageDialog(null,"Tidak Ditemukan");
            System.out.println("Cound not open connection");
            return null;
        }
        
    }//Buat Fungsi main untuk eksekusi Program
    public static void main(String[] args) throws SQLException {
        bukaKoneksi();//Panggil Fungsi untuk di eksekusi
    }
}
