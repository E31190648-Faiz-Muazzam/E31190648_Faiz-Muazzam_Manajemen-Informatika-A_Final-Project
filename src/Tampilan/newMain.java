/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;

import java.awt.Color;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.Arrays;
import javax.swing.JOptionPane; 
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.awt.print.*;
import java.util.logging.*;
import java.text.*;
import java.util.Date;

/**
 *
 * @author Faiz-Muazzam
 */
public class newMain extends javax.swing.JFrame {
     Connection con =null;    
     Statement st = null; 
     private boolean status=false;
     private boolean hitung=false;
     private boolean hitung1=false;
     private String datePesan;
     private String dateAmbil;

    /**
     * Creates new form mainNew
     */
    public newMain() {
        initComponents();
        tampilTabelPesan(); 
        tampilTabelAmbil();
        tampilTabelTransaksi();
        tampilTabelCariTransaksi();
        tampilTabelCariPesan();
    }
    void hapusPesan(){
        try{
            
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "delete from pesan where No_Loker = '"+hapusPesan.getText()+"' ";
            int row = st.executeUpdate(sql);
            if (row ==1){
                JOptionPane.showMessageDialog(this,"Data Sudah Di Hapus" ,"infomasi",JOptionPane.INFORMATION_MESSAGE);
                
                con.close();
                
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data tidak dihapus","infomasi",JOptionPane.
                    INFORMATION_MESSAGE);
        }
        tampilTabelPesan();
    }
    void tampilTabelCariPesan(){
        DefaultTableModel tb=new DefaultTableModel();
        //Memberi judul kolom
        tb.addColumn("No_Loker");
        tb.addColumn("Nama");
        tb.addColumn("Berat");
        tb.addColumn("Service");
        tb.addColumn("Time_Service");
        tb.addColumn("Parfum");
        tb.addColumn("Harga");
        tb.addColumn("Tanggal_Pesan");
        tb.addColumn("Tanggal_Ambil");
        tblPesan.setModel(tb);
        
        //Mengambil Data Dari Data Base
        try{
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM pesan where No_Loker like'"+cariPesan.getText()+"%'";
            ResultSet set = st.executeQuery(sql);
            while (set.next()){
                tb.addRow(new Object[]{
                    set.getString("No_Loker"),
                    set.getString("Nama_Pelanggan"),
                    set.getString("Berat_Barang"),
                    set.getString("Service"),
                    set.getString("Time_Service"),
                    set.getString("Jenis_Parfum"),
                    set.getString("Total_Harga"),
                    set.getString("Tanggal_Pesan"),
                    set.getString("Tanggal_Ambil")
                });
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    void cariPesan(){
        try{
                
                Connection con = Koneksi.bukaKoneksi();
                Statement st = con.createStatement();
                String sql = ("select * from transaksi where No_Loker like '%"
                        +txtCariTransaksi.getText()+"%'");             
                ResultSet rs = st.executeQuery(sql); 
                if(rs.next()){
                JOptionPane.showMessageDialog(this,"Data Di Temukan","Infomasi",JOptionPane.INFORMATION_MESSAGE);
                
                }else{                
                    JOptionPane.showMessageDialog(rootPane, "Data Tidak Ada", "Pesan", JOptionPane.ERROR_MESSAGE);
                    hapuslayar();
                }
            
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
        tampilTabelCariPesan();
    }
    void hapusTransaksi(){
    try{
            
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "delete from transaksi where No_Loker = '"+textHapusTrans.getText()+"' ";
            int row = st.executeUpdate(sql);
            if (row ==1){
                JOptionPane.showMessageDialog(this,"Data Sudah Di Hapus " ,"infomasi",JOptionPane.INFORMATION_MESSAGE);
                
                con.close();
                
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data tidak dihapus","infomasi",JOptionPane.
                    INFORMATION_MESSAGE);
        }
        tampilTabelTransaksi();
}
    void cariTransaksi (){
        try{
                
                Connection con = Koneksi.bukaKoneksi();
                Statement st = con.createStatement();
                String sql = ("select * from transaksi where No_Loker like '%"
                        +txtCariTransaksi.getText()+"%'");             
                ResultSet rs = st.executeQuery(sql); 
                if(rs.next()){
                JOptionPane.showMessageDialog(this,"Data Di Temukan","Infomasi",JOptionPane.INFORMATION_MESSAGE);
                
                }else{                
                    JOptionPane.showMessageDialog(rootPane, "Data Tidak Ada", "Pesan", JOptionPane.ERROR_MESSAGE);
                    hapuslayar();
                }
            
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
        tampilTabelCariTransaksi();
    }
        void tampilTabelCariTransaksi(){
       DefaultTableModel tb=new DefaultTableModel();
        //Memberi judul kolom
        tb.addColumn("No_Loker");
        tb.addColumn("Nama");
        tb.addColumn("Harga");
        tb.addColumn("Uang_Tunai");
        tb.addColumn("Kembalian");
        tb.addColumn("Tanggal_Pesan");
        tb.addColumn("Tanggal_Ambil");
        tblTransaksi.setModel(tb);
        
        //Mengambil Data Dari Data Base
        try{
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM transaksi where No_Loker like'"+txtCariTransaksi.getText()+"%'";
            ResultSet set = st.executeQuery(sql);
            while (set.next()){
                tb.addRow(new Object[]{
                    set.getString("No_Loker"),
                    set.getString("Nama"),
                    set.getString("Harga"),
                    set.getString("Uang_Tunai"),
                    set.getString("Kembalian"),
                    set.getString("Tanggal_Pesan"),
                    set.getString("Tanggal_Ambil"),
                });
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    void tampilTabelTransaksi(){
        DefaultTableModel tb=new DefaultTableModel();
        //Memberi judul kolom
        tb.addColumn("No_Loker");
        tb.addColumn("Nama");
        tb.addColumn("Harga");
        tb.addColumn("Uang_Tunai");
        tb.addColumn("Kembalian");
        tb.addColumn("Tanggal_Pesan");
        tb.addColumn("Tanggal_Ambil");
        tblTransaksi.setModel(tb);
        
        //Mengambil Data Dari Data Base
        try{
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM transaksi";
            ResultSet set = st.executeQuery(sql);
            while (set.next()){
                tb.addRow(new Object[]{
                    set.getString("No_Loker"),
                    set.getString("Nama"),
                    set.getString("Harga"),
                    set.getString("Uang_Tunai"),
                    set.getString("Kembalian"),
                    set.getString("Tanggal_Pesan"),
                    set.getString("Tanggal_Ambil"),
                });
            }
        }catch(Exception e){
            System.out.println("Enek Seng Salah Bro"+e);
        }
    }
    void tampilTabelPesan(){
        DefaultTableModel tb=new DefaultTableModel();
        //Memberi judul kolom
        tb.addColumn("No_Loker");
        tb.addColumn("Nama");
        tb.addColumn("Berat");
        tb.addColumn("Service");
        tb.addColumn("Time_Service");
        tb.addColumn("Parfum");
        tb.addColumn("Harga");
        tb.addColumn("Tanggal_Pesan");
        tb.addColumn("Tanggal_Ambil");
        tblPesan.setModel(tb);
        
        //Mengambil Data Dari Data Base
        try{
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM pesan";
            ResultSet set = st.executeQuery(sql);
            while (set.next()){
                tb.addRow(new Object[]{
                    set.getString("No_Loker"),
                    set.getString("Nama_Pelanggan"),
                    set.getString("Berat_Barang"),
                    set.getString("Service"),
                    set.getString("Time_Service"),
                    set.getString("Jenis_Parfum"),
                    set.getString("Total_Harga"),
                    set.getString("Tanggal_Pesan"),
                    set.getString("Tanggal_Ambil")
                });
            }
        }catch(Exception e){
            System.out.println("Enek Seng Salah Bro"+e);
        }
    }
    
    void tampilTabelAmbil(){
        DefaultTableModel tb=new DefaultTableModel();
        //Memberi judul kolom
        tb.addColumn("No_Loker");
        tb.addColumn("Nama");
        tb.addColumn("Berat");
        tb.addColumn("Service");
        tb.addColumn("Time_Service");
        tb.addColumn("Parfum");
        tb.addColumn("Harga");
        tb.addColumn("Tanggal_Pesan");
        tb.addColumn("Tanggal_Ambil");
        tblAmbil.setModel(tb);
        
        //Mengambil Data Dari Data Base
        try{
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM pesan where No_Loker like'"+txtLokerAmbil.getText()+"%'";
            ResultSet set = st.executeQuery(sql);
            while (set.next()){
                tb.addRow(new Object[]{
                    set.getString("No_Loker"),
                    set.getString("Nama_Pelanggan"),
                    set.getString("Berat_Barang"),
                    set.getString("Service"),
                    set.getString("Time_Service"),
                    set.getString("Jenis_Parfum"),
                    set.getString("Total_Harga"),
                    set.getString("Tanggal_Ambil"),
                    set.getString("Tanggal_Pesan")
                });
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    void transaksi(){
        try{
            
            
            
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "insert into transaksi values ('"+txtNoLokerAmbil.getText()+
                    "','"+txtNamaAmbil.getText()+
                    "','"+txtHargaAmbil.getText()+
                    "','"+txtTunai.getText()+
                    "','"+txtJujul.getText()+
                    "','"+txttanggalPesan1.getText()+
                    "','"+txttanggalPesan1.getText()+
                    "')";
            
            int row = st.executeUpdate(sql);
            
            if (row ==1){
                JOptionPane.showMessageDialog(this,"Data Berhasil Disimpan","Infomasi",JOptionPane.INFORMATION_MESSAGE);
                
                con.close();
            }
            hapuslayarpesan();
            
                                  
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Data Tidak Dapat Di Simpan ", "Pesan", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
            hapuslayarpesan(); 
        }
        tampilTabelTransaksi();
    }
    
     void Daftar(){
        try{            
            if(txtUsername.getText().equals("") || txtPassword.getPassword().equals("") || txtNama.getText().equals("") || txtNoTelepon.getText().equals("") || txtAlamat.getText().equals("")){ 
                 JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);                  
                 hapuslayar();   
            }else{
                Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "insert into daftar values ('"+txtUsername.getText()+
                    "','"+Arrays.toString(txtPassword.getPassword())+
                    "','"+txtNama.getText()+
                    "','"+txtNoTelepon.getText()+ 
                    "','"+txtAlamat.getText()+"')";
            
            int row = st.executeUpdate(sql);          
            if (row ==1){
                JOptionPane.showMessageDialog(this,"Berhasil Regristrasi","Infomasi",JOptionPane.INFORMATION_MESSAGE);
                
                con.close();
            }
            mainPanel.removeAll();
                mainPanel.repaint();
                mainPanel.revalidate();
                
                //isikan/panggil
                mainPanel.add(isiHome);
                mainPanel.repaint();
                mainPanel.revalidate();
            }           
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"This Account is Already exist / Duplicate Account ", "Pesan", JOptionPane.WARNING_MESSAGE);             
            hapuslayar(); 
        }
    }
    
    
    private void cekLogin(){
        try{
            if(txtUserLogin.getText().equals("") || txtPassLogin.getPassword().equals("")){
                 JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);                 
                 txtUsername.requestFocus();                 
                 hapuslayar(); 
            }else{
                status=true;
                Connection con = Koneksi.bukaKoneksi();
                Statement st = con.createStatement();
                String sql = ("select * from daftar where Username = '"
                        +txtUserLogin.getText()+"' and Password = '"
                        +Arrays.toString(txtPassLogin.getPassword())+"'");             
                ResultSet rs = st.executeQuery(sql); 
                if(rs.next()){
                JOptionPane.showMessageDialog(this,"Berhasil Login","Infomasi",JOptionPane.INFORMATION_MESSAGE);
                mainPanel.removeAll();
                mainPanel.repaint();
                mainPanel.revalidate();
                
                //isikan/panggil
                mainPanel.add(isiPesan);
                mainPanel.repaint();
                mainPanel.revalidate();
                }else{                
                    JOptionPane.showMessageDialog(rootPane, "User Name dan Password Salah\nAtau Akun Belum Terdaftar", "Pesan", JOptionPane.ERROR_MESSAGE);
                    hapuslayar();
                }
            }
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
    
    private void pesan (){
        try{
            
            if(txtLoker.getText().equals("") && txtNamaPelanggan.getText().equals("") && txtBerat.getText().equals("")){ 
                 JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);                  
                 
            }else{
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "insert into pesan values ('"+txtLoker.getText()+
                    "','"+txtNamaPelanggan.getText()+
                    "','"+txtBerat.getText()+
                    "','"+comboService.getSelectedItem()+
                    "','"+comboTime.getSelectedItem()+
                    "','"+comboFarfum.getSelectedItem()+
                    "','"+txtHarga.getText()+"','"+datePesan+"','"+dateAmbil+
                    "')";
            
            int row = st.executeUpdate(sql);
            
            if (row ==1){
                JOptionPane.showMessageDialog(this,"Data Berhasil Disimpan","Infomasi",JOptionPane.INFORMATION_MESSAGE);
                
                con.close();
            }
            hapuslayarpesan();
            }
                                  
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Data Tidak Dapat Di Simpan\n"+"Atau Loker Sudah Digunakan", "Pesan", JOptionPane.WARNING_MESSAGE);             
            hapuslayarpesan(); 
        }
        tampilTabelPesan(); 
    }
    
    private void ambil () {
        try{
            if(txtLokerAmbil.getText().equals("")){
                 JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);                 
                 txtUsername.requestFocus();                 
                 hapuslayar(); 
            }else{
                
                Connection con = Koneksi.bukaKoneksi();
                Statement st = con.createStatement();
                String sql = ("select * from pesan where No_Loker like '%"
                        +txtLokerAmbil.getText()+"%'");             
                ResultSet rs = st.executeQuery(sql); 
                if(rs.next()){
                JOptionPane.showMessageDialog(this,"Data Di Temukan","Infomasi",JOptionPane.INFORMATION_MESSAGE);
                mainPanel.removeAll();
                mainPanel.repaint(); 
                mainPanel.revalidate();
                
                //isikan/panggil
                mainPanel.add(isiTabelAmbil);
                mainPanel.repaint();
                mainPanel.revalidate();
                }else{                
                    JOptionPane.showMessageDialog(rootPane, "Data Tidak Ada", "Pesan", JOptionPane.ERROR_MESSAGE);
                    hapuslayar();
                }
            }
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
        tampilTabelAmbil();
    }
    
    private void hapus(){
        try{
            
            Connection con = Koneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "delete from pesan where No_Loker = '"+txtNoLokerAmbil.getText()+"' ";
            int row = st.executeUpdate(sql);
            if (row ==1){
                JOptionPane.showMessageDialog(this,"Data Sudah Di Ambil " ,"infomasi",JOptionPane.INFORMATION_MESSAGE);
                
                con.close();
                
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data tidak dihapus","infomasi",JOptionPane.
                    INFORMATION_MESSAGE);
        }
        tampilTabelAmbil();
    }
    
    private void hapuslayar(){
        txtUsername.setText("");
        txtPassword.setText("");
        txtNama.setText("");
        txtNoTelepon.setText("");
        txtAlamat.setText("");
    }
    
    private void hapuslayarpesan(){
        txtLoker.setText("");
        txtNamaPelanggan.setText("");
        txtBerat.setText("");
        comboService.setSelectedItem("");
        comboTime.setSelectedItem("");
        comboFarfum.setSelectedItem("");
        txtHarga.setText("");
        
    }
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        bodyPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnPesan = new javax.swing.JButton();
        btnAmbil = new javax.swing.JButton();
        btnClose = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        isiHome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtUserLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBuatAkun = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtPassLogin = new javax.swing.JPasswordField();
        isiPesan = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtLoker = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNamaPelanggan = new javax.swing.JTextField();
        comboService = new javax.swing.JComboBox<>();
        comboTime = new javax.swing.JComboBox<>();
        comboFarfum = new javax.swing.JComboBox<>();
        txtHarga = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        txtBerat = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        tanggalPesan = new com.toedter.calendar.JDateChooser();
        tanggalAmbil = new com.toedter.calendar.JDateChooser();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCetakPesan = new javax.swing.JTextArea();
        btnCetakPesan = new javax.swing.JButton();
        btnStruck = new javax.swing.JButton();
        isiAmbil = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtLokerAmbil = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        isiForm = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel19 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtNoTelepon = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        isiTabelPesan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPesan = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        cariPesan = new javax.swing.JTextField();
        btnCariPesan = new javax.swing.JButton();
        hapusPesan = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        isiTabelAmbil = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAmbil = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        txtNoLokerAmbil = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtHargaAmbil = new javax.swing.JTextField();
        btnAmbilTabel = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtNamaAmbil = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtTunai = new javax.swing.JTextField();
        txtJujul = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnHitungAmbil = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txttanggalPesan1 = new javax.swing.JTextField();
        txttanggalAmbil1 = new javax.swing.JTextField();
        btnTransaksi = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtPrint = new javax.swing.JTextArea();
        btnCetak = new javax.swing.JButton();
        btnPrintAmbil = new javax.swing.JButton();
        isiTabelTransaksi = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        txtCariTransaksi = new javax.swing.JTextField();
        cariTransaksi = new javax.swing.JButton();
        hapusTransaksi = new javax.swing.JButton();
        textHapusTrans = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Havana Laundry");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menuPanel.setBackground(new java.awt.Color(0, 51, 0));

        judul.setBackground(new java.awt.Color(255, 255, 255));
        judul.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setText("Hamasah Laundry");

        btnHome.setBackground(new java.awt.Color(204, 204, 204));
        btnHome.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnHome.setForeground(new java.awt.Color(0, 52, 0));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-home-page-20.png"))); // NOI18N
        btnHome.setText("HOME");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnPesan.setBackground(new java.awt.Color(204, 204, 204));
        btnPesan.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPesan.setForeground(new java.awt.Color(0, 52, 0));
        btnPesan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-purchase-order-20.png"))); // NOI18N
        btnPesan.setText("PESAN");
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });

        btnAmbil.setBackground(new java.awt.Color(204, 204, 204));
        btnAmbil.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnAmbil.setForeground(new java.awt.Color(0, 52, 0));
        btnAmbil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-clothes-in-laundry-20.png"))); // NOI18N
        btnAmbil.setText("AMBIL");
        btnAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbilActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLOSE");

        javax.swing.GroupLayout btnCloseLayout = new javax.swing.GroupLayout(btnClose);
        btnClose.setLayout(btnCloseLayout);
        btnCloseLayout.setHorizontalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCloseLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        btnCloseLayout.setVerticalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCloseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Aplication");

        jLabel26.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("By Faiz-Muazzam (E31190648)");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnAmbil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPesan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addComponent(judul)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(25, 25, 25))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addGap(106, 106, 106)
                .addComponent(btnHome)
                .addGap(34, 34, 34)
                .addComponent(btnPesan)
                .addGap(34, 34, 34)
                .addComponent(btnAmbil)
                .addGap(82, 82, 82)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(29, 29, 29))
        );

        mainPanel.setBackground(new java.awt.Color(204, 255, 204));
        mainPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Selamat Datang");

        jLabel21.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("Silahkan Login Untuk Menjalankan Aplikasi :");

        btnBuatAkun.setText("Buat Akun");
        btnBuatAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuatAkunActionPerformed(evt);
            }
        });

        jLabel22.setText("Pilih Sesuai Kebutuhan :");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout isiHomeLayout = new javax.swing.GroupLayout(isiHome);
        isiHome.setLayout(isiHomeLayout);
        isiHomeLayout.setHorizontalGroup(
            isiHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, isiHomeLayout.createSequentialGroup()
                .addGap(0, 264, Short.MAX_VALUE)
                .addGroup(isiHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(isiHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(isiHomeLayout.createSequentialGroup()
                            .addComponent(btnBuatAkun)
                            .addGap(39, 39, 39)
                            .addComponent(btnLogin))
                        .addGroup(isiHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(isiHomeLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPassLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(isiHomeLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(isiHomeLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel22))))
                .addGap(290, 290, 290))
        );
        isiHomeLayout.setVerticalGroup(
            isiHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiHomeLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(isiHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(isiHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(isiHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuatAkun)
                    .addComponent(btnLogin))
                .addContainerGap(359, Short.MAX_VALUE))
        );

        mainPanel.add(isiHome, "card2");

        jLabel8.setText("Nama Pelanggan");

        jLabel9.setText("Berat Barang");

        jLabel11.setText("Kg");

        jLabel12.setText("Service  ");

        jLabel13.setText("Time Service");

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 0));
        jLabel14.setText("Isilah Data Pemesanan Di Sini :");

        jLabel16.setText("No. Loker");

        comboService.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reguler", "Expert" }));
        comboService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboServiceActionPerformed(evt);
            }
        });

        comboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilat", "Santai" }));

        comboFarfum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stawberry", "Orange", "Lavenda", "Vanila" }));

        jLabel23.setText("Total Harga");

        jLabel24.setText("Rp.");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnShow.setText("Lihat Data");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        jLabel15.setText("Jenis Parfum");

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        jLabel27.setText("Di ambil");

        tanggalPesan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalPesanPropertyChange(evt);
            }
        });

        tanggalAmbil.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalAmbilPropertyChange(evt);
            }
        });

        jLabel36.setText("Tanggal Pesan");

        txtCetakPesan.setColumns(20);
        txtCetakPesan.setRows(5);
        jScrollPane5.setViewportView(txtCetakPesan);

        btnCetakPesan.setText("Print");
        btnCetakPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakPesanActionPerformed(evt);
            }
        });

        btnStruck.setText("Buat Struck");
        btnStruck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStruckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout isiPesanLayout = new javax.swing.GroupLayout(isiPesan);
        isiPesan.setLayout(isiPesanLayout);
        isiPesanLayout.setHorizontalGroup(
            isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiPesanLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(tanggalAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel16)
                    .addGroup(isiPesanLayout.createSequentialGroup()
                        .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(isiPesanLayout.createSequentialGroup()
                                .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(isiPesanLayout.createSequentialGroup()
                                        .addComponent(txtBerat)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(isiPesanLayout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(comboService, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(comboTime, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboFarfum, javax.swing.GroupLayout.Alignment.LEADING, 0, 132, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel36)
                            .addComponent(jLabel8)
                            .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtLoker, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                            .addComponent(jLabel9)
                            .addComponent(tanggalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(isiPesanLayout.createSequentialGroup()
                                .addComponent(btnShow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStruck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCetakPesan)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        isiPesanLayout.setVerticalGroup(
            isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiPesanLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel14)
                .addGap(20, 20, 20)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(isiPesanLayout.createSequentialGroup()
                        .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(isiPesanLayout.createSequentialGroup()
                                .addComponent(txtLoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addGap(10, 10, 10)
                                .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboFarfum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)
                                    .addComponent(btnHitung))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel36))
                            .addComponent(jScrollPane5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(isiPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCetakPesan)
                        .addComponent(btnSimpan)
                        .addComponent(btnShow)
                        .addComponent(btnStruck)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        mainPanel.add(isiPesan, "card3");

        jLabel10.setText("No Loker");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Isi Sesuai Perintah :");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("Ambil Barang");

        javax.swing.GroupLayout isiAmbilLayout = new javax.swing.GroupLayout(isiAmbil);
        isiAmbil.setLayout(isiAmbilLayout);
        isiAmbilLayout.setHorizontalGroup(
            isiAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiAmbilLayout.createSequentialGroup()
                .addGroup(isiAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(isiAmbilLayout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addGroup(isiAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(isiAmbilLayout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addGroup(isiAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLokerAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(isiAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnNext)
                                .addGroup(isiAmbilLayout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(126, 126, 126))))))
                .addContainerGap(342, Short.MAX_VALUE))
        );
        isiAmbilLayout.setVerticalGroup(
            isiAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiAmbilLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLokerAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext)
                .addContainerGap(433, Short.MAX_VALUE))
        );

        mainPanel.add(isiAmbil, "card4");

        jLabel17.setText("Username");

        jLabel18.setText("Password");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel19.setText("Nama Lengkap");

        jLabel20.setText("No Telepon");

        txtNoTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoTeleponActionPerformed(evt);
            }
        });

        jLabel25.setText("Alamat (Desa/Kecamatan/Kota)");

        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });

        jButton1.setText("Daftar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 102, 0));
        jLabel43.setText("Regristrasi");

        javax.swing.GroupLayout isiFormLayout = new javax.swing.GroupLayout(isiForm);
        isiForm.setLayout(isiFormLayout);
        isiFormLayout.setHorizontalGroup(
            isiFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiFormLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(isiFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(isiFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel43)
                        .addGroup(isiFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword)
                            .addComponent(txtNama)
                            .addComponent(txtNoTelepon)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                .addContainerGap(478, Short.MAX_VALUE))
        );
        isiFormLayout.setVerticalGroup(
            isiFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiFormLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel43)
                .addGap(29, 29, 29)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        mainPanel.add(isiForm, "card6");

        tblPesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPesan);

        jLabel31.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 0));
        jLabel31.setText("Tabel Pemesanan");

        btnCariPesan.setText("Cari");
        btnCariPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPesanActionPerformed(evt);
            }
        });

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout isiTabelPesanLayout = new javax.swing.GroupLayout(isiTabelPesan);
        isiTabelPesan.setLayout(isiTabelPesanLayout);
        isiTabelPesanLayout.setHorizontalGroup(
            isiTabelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiTabelPesanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(isiTabelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(isiTabelPesanLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(isiTabelPesanLayout.createSequentialGroup()
                        .addGroup(isiTabelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cariPesan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariPesan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                        .addComponent(hapusPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(49, 49, 49))))
        );
        isiTabelPesanLayout.setVerticalGroup(
            isiTabelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiTabelPesanLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel31)
                .addGap(27, 27, 27)
                .addGroup(isiTabelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariPesan)
                    .addComponent(hapusPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        mainPanel.add(isiTabelPesan, "card7");

        tblAmbil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAmbil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAmbilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAmbil);

        jLabel28.setText("No Loker");

        txtNoLokerAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoLokerAmbilActionPerformed(evt);
            }
        });

        jLabel29.setText("Harga");

        txtHargaAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaAmbilActionPerformed(evt);
            }
        });

        btnAmbilTabel.setText("Ambil");
        btnAmbilTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbilTabelActionPerformed(evt);
            }
        });

        jLabel30.setText("Nama");

        txtNamaAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaAmbilActionPerformed(evt);
            }
        });

        jLabel32.setText("Uang Tunai");

        txtTunai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTunaiActionPerformed(evt);
            }
        });

        jLabel33.setText("Kembali");

        jLabel34.setText("Rp.");

        jLabel35.setText("Rp.");

        btnHitungAmbil.setText("Hitung");
        btnHitungAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungAmbilActionPerformed(evt);
            }
        });

        jLabel37.setText("Tanggal Di ambil");

        jLabel38.setText("Tanggal Pesan");

        txttanggalPesan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalPesan1ActionPerformed(evt);
            }
        });

        btnTransaksi.setText("Lihat Transaksi");
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });

        jLabel39.setText("Rp.");

        jLabel40.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 0));
        jLabel40.setText("Transaksi");

        jLabel42.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 0));
        jLabel42.setText("Data Pemesanan");

        txtPrint.setColumns(20);
        txtPrint.setRows(5);
        jScrollPane4.setViewportView(txtPrint);

        btnCetak.setText("Buat Struck");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnPrintAmbil.setText("Print");
        btnPrintAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintAmbilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout isiTabelAmbilLayout = new javax.swing.GroupLayout(isiTabelAmbil);
        isiTabelAmbil.setLayout(isiTabelAmbilLayout);
        isiTabelAmbilLayout.setHorizontalGroup(
            isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel40))
                            .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnHitungAmbil)
                                    .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                                                    .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                                                            .addComponent(jLabel29)
                                                            .addGap(101, 101, 101)
                                                            .addComponent(jLabel39))
                                                        .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                                                            .addComponent(jLabel32)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel34)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                                                    .addComponent(jLabel33)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel35)
                                                    .addGap(8, 8, 8))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, isiTabelAmbilLayout.createSequentialGroup()
                                                    .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                                                .addComponent(jLabel37)
                                                .addGap(74, 74, 74)))
                                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txttanggalAmbil1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                            .addComponent(txtNoLokerAmbil, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNamaAmbil, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtJujul, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTunai, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHargaAmbil, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttanggalPesan1))))))
                        .addGap(0, 446, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, isiTabelAmbilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                                .addComponent(btnCetak)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrintAmbil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAmbilTabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTransaksi))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );
        isiTabelAmbilLayout.setVerticalGroup(
            isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, isiTabelAmbilLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, isiTabelAmbilLayout.createSequentialGroup()
                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoLokerAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(16, 16, 16)
                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHargaAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJujul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel33))
                        .addGap(21, 21, 21)
                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttanggalPesan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(19, 19, 19)
                        .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttanggalAmbil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addComponent(btnHitungAmbil)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, isiTabelAmbilLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(isiTabelAmbilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAmbilTabel)
                        .addComponent(btnTransaksi)
                        .addComponent(btnPrintAmbil)
                        .addComponent(btnCetak))
                    .addGroup(isiTabelAmbilLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel42)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );

        mainPanel.add(isiTabelAmbil, "card6");

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTransaksi);

        jLabel41.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 102, 0));
        jLabel41.setText("Tabel Transaksi");

        cariTransaksi.setText("Cari");
        cariTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariTransaksiActionPerformed(evt);
            }
        });

        hapusTransaksi.setText("Hapus");
        hapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusTransaksiActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout isiTabelTransaksiLayout = new javax.swing.GroupLayout(isiTabelTransaksi);
        isiTabelTransaksi.setLayout(isiTabelTransaksiLayout);
        isiTabelTransaksiLayout.setHorizontalGroup(
            isiTabelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiTabelTransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(isiTabelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                    .addGroup(isiTabelTransaksiLayout.createSequentialGroup()
                        .addGroup(isiTabelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCariTransaksi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariTransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textHapusTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapusTransaksi))
                    .addGroup(isiTabelTransaksiLayout.createSequentialGroup()
                        .addComponent(btnKembali)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        isiTabelTransaksiLayout.setVerticalGroup(
            isiTabelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(isiTabelTransaksiLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnKembali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addGroup(isiTabelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariTransaksi)
                    .addComponent(hapusTransaksi)
                    .addComponent(textHapusTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        mainPanel.add(isiTabelTransaksi, "card8");

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbilActionPerformed
        // TODO add your handling code here:
         //Hapus
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //isikan/panggil
        mainPanel.add(isiAmbil);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnAmbilActionPerformed

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
        // TODO add your handling code here:
         //Hapus
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //isikan/panggil
        mainPanel.add(isiPesan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnPesanActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        //Hapus
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //isikan/panggil
        mainPanel.add(isiHome);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnBuatAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuatAkunActionPerformed
        // TODO add your handling code here:
         //Hapus
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //isikan/panggil
        mainPanel.add(isiForm);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnBuatAkunActionPerformed

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        // TODO add your handling code here:
        btnClose.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        // TODO add your handling code here:
        btnClose.setBackground(Color.red);
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:
        btnClose.setBackground(Color.GRAY);
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (status==false) {
            JOptionPane.showMessageDialog(this, "Silahkan Login Dahulu", "Pesan", JOptionPane.ERROR_MESSAGE);
            //Hapus
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();
            
            //isikan/panggil
            mainPanel.add(isiHome);
            mainPanel.repaint();
            mainPanel.revalidate();
        }else{
           ambil(); 
           txtLokerAmbil.setText("");
        }
        
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtNoTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoTeleponActionPerformed

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Daftar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        cekLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //isikan/panggil
        mainPanel.add(isiTabelTransaksi);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void txttanggalPesan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalPesan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttanggalPesan1ActionPerformed

    private void btnHitungAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungAmbilActionPerformed
        // TODO add your handling code here:
        DecimalFormat x=new DecimalFormat("#.000");
        double rego=Double.parseDouble(txtHargaAmbil.getText());
        double tunai=Double.parseDouble(txtTunai.getText())/1000;
        double jujul=tunai-rego;

        txtJujul.setText(""+x.format(jujul));
        hitung1=true;
    }//GEN-LAST:event_btnHitungAmbilActionPerformed

    private void txtTunaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTunaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTunaiActionPerformed

    private void txtNamaAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaAmbilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaAmbilActionPerformed

    private void btnAmbilTabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbilTabelActionPerformed
        // TODO add your handling code here:
        if(hitung1==false){
            JOptionPane.showMessageDialog(this, "Hitung Terlebih Dulu", "Pesan", JOptionPane.ERROR_MESSAGE);
        }else{
            hapus();
            transaksi();
            txtNoLokerAmbil.setText("");
            txtNamaAmbil.setText("");
            txtHargaAmbil.setText("");
            txtTunai.setText("");
            txtJujul.setText("");
            txttanggalPesan1.setText("");
            txttanggalAmbil1.setText("");

        }

    }//GEN-LAST:event_btnAmbilTabelActionPerformed

    private void txtHargaAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaAmbilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaAmbilActionPerformed

    private void txtNoLokerAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoLokerAmbilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoLokerAmbilActionPerformed

    private void tblAmbilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAmbilMouseClicked
        // TODO add your handling code here:
        int tabel = tblAmbil.getSelectedRow();
        txtNoLokerAmbil.setText(tblAmbil.getValueAt(tabel, 0).toString());
        txtNamaAmbil.setText(tblAmbil.getValueAt(tabel, 1).toString());
        txtHargaAmbil.setText(tblAmbil.getValueAt(tabel, 6).toString());
        txttanggalPesan1.setText(tblAmbil.getValueAt(tabel, 7).toString());
        txttanggalAmbil1.setText(tblAmbil.getValueAt(tabel, 8).toString());

    }//GEN-LAST:event_tblAmbilMouseClicked

    private void tanggalAmbilPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalAmbilPropertyChange
        // TODO add your handling code here:
        if (tanggalAmbil.getDate()!=null) {
            SimpleDateFormat Format=new SimpleDateFormat("yyyy-MMM-dd");
            dateAmbil=Format.format(tanggalAmbil.getDate());
        }
    }//GEN-LAST:event_tanggalAmbilPropertyChange

    private void tanggalPesanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalPesanPropertyChange
        // TODO add your handling code here:
        if (tanggalPesan.getDate()!=null) {
            SimpleDateFormat Format=new SimpleDateFormat("yyyy-MMM-dd");
            datePesan=Format.format(tanggalPesan.getDate());
        }
    }//GEN-LAST:event_tanggalPesanPropertyChange

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
        double jumlahHarga;
        double berat;
        double service=0;
        double timeService = 0;
        String dayService = null;
        DecimalFormat x=new DecimalFormat("#.000");

        berat= Double.parseDouble(txtBerat.getText())*3;
        switch(comboService.getSelectedIndex()){
            case 0 :
            service=0;
            break;
            case 1 :
            service=2;
            break;
            default :
            service=0;
        }

        switch(comboTime.getSelectedIndex()){
            case 0 :
            timeService=2;
            dayService="Besok";
            break;
            case 1 :
            timeService=0;
            dayService="2 Hari";
            break;
            default :
            service=0;
        }

        jumlahHarga=berat+service+timeService;
        txtHarga.setText(""+x.format(jumlahHarga));
        hitung=true;
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        if (status==false) {
        JOptionPane.showMessageDialog(this, "Silahkan Login Dulu", "Pesan", JOptionPane.ERROR_MESSAGE);
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //isikan/panggil
        mainPanel.add(isiHome);
        mainPanel.repaint();
        mainPanel.revalidate();
        }else{
        //Hapus
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //isikan/panggil
        mainPanel.add(isiTabelPesan);
        mainPanel.repaint();
        mainPanel.revalidate();
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (status==false) {
        JOptionPane.showMessageDialog(this, "Silahkan Login Dulu", "Pesan", JOptionPane.ERROR_MESSAGE);
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //isikan/panggil
        mainPanel.add(isiHome);
        mainPanel.repaint();
        mainPanel.revalidate();
        }
        else if(hitung==false ){
            JOptionPane.showMessageDialog(this, "Hitung Terlebih Dulu", "Pesan", JOptionPane.ERROR_MESSAGE);
        }else{
            pesan();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void comboServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboServiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboServiceActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        Date obj = new Date();
        String date = obj.toString();
        txtPrint.setText("===========================================================\n");
        txtPrint.setText(txtPrint.getText()+"*                      Struck Transaksi                    *\n");
        txtPrint.setText(txtPrint.getText()+"=============================================================\n");
        txtPrint.setText(txtPrint.getText()+"\n"+date+"\n\n");
        txtPrint.setText(txtPrint.getText()+"No Loker\t\t"+": "+txtNoLokerAmbil.getText()+"\n");
        txtPrint.setText(txtPrint.getText()+"Nama\t\t"+": "+txtNamaAmbil.getText()+"\n");
        txtPrint.setText(txtPrint.getText()+"Harga\t\t"+": Rp. "+txtHargaAmbil.getText()+"\n");
        txtPrint.setText(txtPrint.getText()+"Uang Tunai\t\t"+": Rp.  "+txtTunai.getText()+"\n");
        txtPrint.setText(txtPrint.getText()+"Kembalian\t\t"+": Rp. "+txtJujul.getText()+"\n");
        txtPrint.setText(txtPrint.getText()+"Tgl Pesan\t\t"+": "+txttanggalPesan1.getText()+"\n");
        txtPrint.setText(txtPrint.getText()+"Tgl Ambil\t\t"+": "+txttanggalAmbil1.getText()+"\n");
        txtPrint.setText(txtPrint.getText()+"=============================================================\n\n");
        txtPrint.setText(txtPrint.getText()+"\t\t\t\tJember, "+txttanggalAmbil1.getText()+"\n\n\n");
        txtPrint.setText(txtPrint.getText()+"\t\t\t\tHamasah Laundry\n");
        
        
        
        
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnCetakPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakPesanActionPerformed
        // TODO add your handling code here:
        try {
            txtCetakPesan.print();
        }catch(java.awt.print.PrinterException e){
            System.err.format("No Printer Found", e.getMessage());
        }
    }//GEN-LAST:event_btnCetakPesanActionPerformed

    private void btnStruckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStruckActionPerformed
        // TODO add your handling code here:
        Date obj = new Date();
        String date = obj.toString();
        txtCetakPesan.setText("===========================================================\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"*                      Struck Pemesanan                    *\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"=============================================================\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"\n"+date+"\n\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"No Loker\t\t"+": "+txtLoker.getText()+"\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"Nama\t\t"+": "+txtNamaPelanggan.getText()+"\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"Berat\t\t"+": "+txtBerat.getText()+" Kg\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"Layanan\t\t"+": "+comboService.getSelectedItem()+"\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"Layanan Waktu\t"+": "+comboTime.getSelectedItem()+"\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"Parfum\t\t"+": "+comboFarfum.getSelectedItem()+"\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"Total Harga\t\t"+": Rp. "+txtHarga.getText()+"\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"Tanggal Pesan\t"+": "+datePesan+"\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"Tanggal Ambil\t\t"+": "+dateAmbil+"\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"=============================================================\n\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"\t\t\t\tJember, "+datePesan+"\n\n\n");
        txtCetakPesan.setText(txtCetakPesan.getText()+"\t\t\t\tHamasah Laundry\n");
    }//GEN-LAST:event_btnStruckActionPerformed

    private void btnPrintAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintAmbilActionPerformed
        // TODO add your handling code here:
        try {
            txtPrint.print();
        }catch(java.awt.print.PrinterException e){
            System.err.format("No Printer Found", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintAmbilActionPerformed

    private void cariTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariTransaksiActionPerformed
        // TODO add your handling code here:
        cariTransaksi();
        
    }//GEN-LAST:event_cariTransaksiActionPerformed

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransaksiMouseClicked
        // TODO add your handling code here:
        int tabel = tblTransaksi.getSelectedRow();
        textHapusTrans.setText(tblTransaksi.getValueAt(tabel, 0).toString());
    }//GEN-LAST:event_tblTransaksiMouseClicked

    private void hapusTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusTransaksiActionPerformed
        // TODO add your handling code here:
        hapusTransaksi();
        textHapusTrans.setText("");
    }//GEN-LAST:event_hapusTransaksiActionPerformed

    private void tblPesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesanMouseClicked
        // TODO add your handling code here:
        int tabel = tblPesan.getSelectedRow();
        hapusPesan.setText(tblPesan.getValueAt(tabel, 0).toString());
    }//GEN-LAST:event_tblPesanMouseClicked

    private void btnCariPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPesanActionPerformed
        // TODO add your handling code here:
        cariPesan();
    }//GEN-LAST:event_btnCariPesanActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        hapusPesan();
        hapusPesan.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //isikan/panggil
        mainPanel.add(isiTabelAmbil);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnKembaliActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(newMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnAmbil;
    private javax.swing.JButton btnAmbilTabel;
    private javax.swing.JButton btnBuatAkun;
    private javax.swing.JButton btnCariPesan;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnCetakPesan;
    private javax.swing.JPanel btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnHitungAmbil;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPesan;
    private javax.swing.JButton btnPrintAmbil;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnStruck;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField cariPesan;
    private javax.swing.JButton cariTransaksi;
    private javax.swing.JComboBox<String> comboFarfum;
    private javax.swing.JComboBox<String> comboService;
    private javax.swing.JComboBox<String> comboTime;
    private javax.swing.JTextField hapusPesan;
    private javax.swing.JButton hapusTransaksi;
    private javax.swing.JPanel isiAmbil;
    private javax.swing.JPanel isiForm;
    private javax.swing.JPanel isiHome;
    private javax.swing.JPanel isiPesan;
    private javax.swing.JPanel isiTabelAmbil;
    private javax.swing.JPanel isiTabelPesan;
    private javax.swing.JPanel isiTabelTransaksi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel judul;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private com.toedter.calendar.JDateChooser tanggalAmbil;
    private com.toedter.calendar.JDateChooser tanggalPesan;
    private javax.swing.JTable tblAmbil;
    private javax.swing.JTable tblPesan;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField textHapusTrans;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtBerat;
    private javax.swing.JTextField txtCariTransaksi;
    private javax.swing.JTextArea txtCetakPesan;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtHargaAmbil;
    private javax.swing.JTextField txtJujul;
    private javax.swing.JTextField txtLoker;
    private javax.swing.JTextField txtLokerAmbil;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaAmbil;
    private javax.swing.JTextField txtNamaPelanggan;
    private javax.swing.JTextField txtNoLokerAmbil;
    private javax.swing.JTextField txtNoTelepon;
    private javax.swing.JPasswordField txtPassLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextArea txtPrint;
    private javax.swing.JTextField txtTunai;
    private javax.swing.JTextField txtUserLogin;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txttanggalAmbil1;
    private javax.swing.JTextField txttanggalPesan1;
    // End of variables declaration//GEN-END:variables
}
