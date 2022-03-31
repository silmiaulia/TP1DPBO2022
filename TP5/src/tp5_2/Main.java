/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp5_2;

import java.sql.Connection;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.DriverManager;

/**
 *
 * @author Hp
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    boolean isBook = true;
    String filenameBuku = null;
    String filenameAuthor = null;
    byte[] buku_image = null;
    byte[] author_image = null;

    
    dbConnection dbcon = new dbConnection();
    
    public Main() {
        initComponents();
        populateTabelBuku();
        PanelAuthor.setVisible(false);
        PanelBuku.setVisible(true);
        PanelAddAuthor.setVisible(false);
        PanelAddBuku.setVisible(false);
        
        

    }
    
    public void populateTabelBuku(){
        
        dbConnection myq = new dbConnection();
        ArrayList<Buku> list = myq.getItemListBuku();
        String[] columnName = {"No", "Nama", "Jumlah", "Image"};
        Object[][] rows = new Object[list.size()][4];
        for(int i=0; i<list.size(); i++){
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getNama();
            rows[i][2] = list.get(i).getGenre();
            
            
            if(list.get(i).getImage() != null){
                
              ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
             .getScaledInstance(120, 150, Image.SCALE_SMOOTH) );   
              
              rows[i][3] = image;
            }else{
              rows[i][3] = null;
            }
            
            
        }

//      set tabel        
        theModel model = new theModel(rows, columnName);
        tbl_buku.setModel(model);
        tbl_buku.setRowHeight(200);
        tbl_buku.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        
//        Membuat tabel align center
        
        ((DefaultTableCellRenderer)tbl_buku.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(SwingConstants.CENTER );
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment( SwingConstants.CENTER );

        for (int columnIndex = 0; columnIndex < model.getColumnCount()-1; columnIndex++)
        {
            tbl_buku.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        
    }
    
    public void populateTabelAuthor(){
        
        dbConnection myq = new dbConnection();
        ArrayList<Author> list = myq.getItemListAuthor();
        String[] columnName = {"No", "Nama", "Jumlah", "Email", "Image"};
        Object[][] rows = new Object[list.size()][5];
        for(int i=0; i<list.size(); i++){
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getNama();
            rows[i][2] = list.get(i).getJumlah();
            rows[i][3] = list.get(i).getEmail();
            
            
            if(list.get(i).getImage() != null){
                
              ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
             .getScaledInstance(120, 150, Image.SCALE_SMOOTH) );   
              
              rows[i][4] = image;
            }else{
              rows[i][4] = null;
            }
            
            
        }

//      set tabel        
        theModel model = new theModel(rows, columnName);
        tbl_author.setModel(model);
        tbl_author.setRowHeight(200);
        tbl_author.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        
//        Membuat tabel align center
        
        ((DefaultTableCellRenderer)tbl_author.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(SwingConstants.CENTER );
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment( SwingConstants.CENTER );

        for (int columnIndex = 0; columnIndex < model.getColumnCount()-1; columnIndex++)
        {
            tbl_author.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBuku = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_buku = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_buku = new javax.swing.JButton();
        btn_author = new javax.swing.JButton();
        btn_deleteBuku = new javax.swing.JButton();
        btn_updateBuku = new javax.swing.JButton();
        PanelAuthor = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_author = new javax.swing.JTable();
        btn_author1 = new javax.swing.JButton();
        btn_buku1 = new javax.swing.JButton();
        btn_add1 = new javax.swing.JButton();
        btn_updateAuthor = new javax.swing.JButton();
        btn_deleteAuthor = new javax.swing.JButton();
        PanelAddBuku = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_genreBuku = new javax.swing.JTextField();
        tf_namaBuku = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        up_imageBuku = new javax.swing.JButton();
        btn_addBuku = new javax.swing.JButton();
        lbl_imageBuku = new javax.swing.JLabel();
        PanelAddAuthor = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tf_jumlahBuku = new javax.swing.JTextField();
        tf_namaAuthor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        up_imageAuthor = new javax.swing.JButton();
        btn_addAuthor = new javax.swing.JButton();
        lbl_imageAuthor = new javax.swing.JLabel();
        tf_Email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_buku);

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_buku.setText("Buku");
        btn_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bukuActionPerformed(evt);
            }
        });

        btn_author.setText("Author");
        btn_author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_authorActionPerformed(evt);
            }
        });

        btn_deleteBuku.setText("Delete");
        btn_deleteBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteBukuActionPerformed(evt);
            }
        });

        btn_updateBuku.setText("Update");
        btn_updateBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateBukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBukuLayout = new javax.swing.GroupLayout(PanelBuku);
        PanelBuku.setLayout(PanelBukuLayout);
        PanelBukuLayout.setHorizontalGroup(
            PanelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBukuLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(PanelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBukuLayout.createSequentialGroup()
                        .addComponent(btn_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelBukuLayout.createSequentialGroup()
                        .addComponent(btn_author, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBukuLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(PanelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBukuLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBukuLayout.createSequentialGroup()
                        .addComponent(btn_updateBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(btn_deleteBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222))))
        );
        PanelBukuLayout.setVerticalGroup(
            PanelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBukuLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btn_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_author, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(PanelBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_updateBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deleteBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        tbl_author.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_author);

        btn_author1.setText("Author");
        btn_author1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_author1ActionPerformed(evt);
            }
        });

        btn_buku1.setText("Buku");
        btn_buku1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buku1ActionPerformed(evt);
            }
        });

        btn_add1.setText("Add");
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });

        btn_updateAuthor.setText("Update");
        btn_updateAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateAuthorActionPerformed(evt);
            }
        });

        btn_deleteAuthor.setText("Delete");
        btn_deleteAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAuthorLayout = new javax.swing.GroupLayout(PanelAuthor);
        PanelAuthor.setLayout(PanelAuthorLayout);
        PanelAuthorLayout.setHorizontalGroup(
            PanelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAuthorLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(PanelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAuthorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PanelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAuthorLayout.createSequentialGroup()
                                .addComponent(btn_buku1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelAuthorLayout.createSequentialGroup()
                                .addComponent(btn_author1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAuthorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_updateAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btn_deleteAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );
        PanelAuthorLayout.setVerticalGroup(
            PanelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAuthorLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btn_buku1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_author1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(PanelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_updateAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deleteAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        PanelAddBuku.setPreferredSize(new java.awt.Dimension(740, 633));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Add Record Baru Buku");

        jLabel2.setText("Nama Buku :");

        jLabel3.setText("Genre Buku :");

        jLabel4.setText("Image :");

        up_imageBuku.setText("Load");
        up_imageBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_imageBukuActionPerformed(evt);
            }
        });

        btn_addBuku.setText("Add Buku");
        btn_addBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addBukuActionPerformed(evt);
            }
        });

        lbl_imageBuku.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PanelAddBukuLayout = new javax.swing.GroupLayout(PanelAddBuku);
        PanelAddBuku.setLayout(PanelAddBukuLayout);
        PanelAddBukuLayout.setHorizontalGroup(
            PanelAddBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAddBukuLayout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(PanelAddBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(PanelAddBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_namaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_genreBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAddBukuLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbl_imageBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(up_imageBuku)))
                .addGap(176, 176, 176))
            .addGroup(PanelAddBukuLayout.createSequentialGroup()
                .addGroup(PanelAddBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAddBukuLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAddBukuLayout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(btn_addBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelAddBukuLayout.setVerticalGroup(
            PanelAddBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddBukuLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(PanelAddBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_namaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(PanelAddBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_genreBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(PanelAddBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAddBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(up_imageBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_imageBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btn_addBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelAddAuthor.setPreferredSize(new java.awt.Dimension(740, 633));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Add Record Baru Author");

        jLabel6.setText("Nama Author :");

        jLabel7.setText("Jumlah Buku :");

        jLabel8.setText("Image :");

        up_imageAuthor.setText("Load");
        up_imageAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_imageAuthorActionPerformed(evt);
            }
        });

        btn_addAuthor.setText("Add Author");
        btn_addAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addAuthorActionPerformed(evt);
            }
        });

        jLabel9.setText("Email           :");

        javax.swing.GroupLayout PanelAddAuthorLayout = new javax.swing.GroupLayout(PanelAddAuthor);
        PanelAddAuthor.setLayout(PanelAddAuthorLayout);
        PanelAddAuthorLayout.setHorizontalGroup(
            PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                .addGroup(PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(btn_addAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAddAuthorLayout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(112, 112, 112)
                        .addComponent(lbl_imageAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(up_imageAuthor))
                    .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                        .addGroup(PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(42, 42, 42)
                        .addGroup(PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_namaAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_jumlahBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(176, 176, 176))
        );
        PanelAddAuthorLayout.setVerticalGroup(
            PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_namaAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_jumlahBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(lbl_imageAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                        .addGroup(PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(PanelAddAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(80, 80, 80)
                                .addComponent(up_imageAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelAddAuthorLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btn_addAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelAddBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelAddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelAddBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelAddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        PanelBuku.setVisible(false);
        PanelAuthor.setVisible(false);
        PanelAddAuthor.setVisible(false);
        PanelAddBuku.setVisible(true);
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        // TODO add your handling code here:
        PanelBuku.setVisible(false);
        PanelAuthor.setVisible(false);
        PanelAddAuthor.setVisible(true);
        PanelAddBuku.setVisible(false);
    }//GEN-LAST:event_btn_add1ActionPerformed

    private void btn_authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_authorActionPerformed
        // TODO add your handling code here:
        PanelBuku.setVisible(false);
        PanelAuthor.setVisible(true);
        populateTabelAuthor();
    }//GEN-LAST:event_btn_authorActionPerformed

    private void btn_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bukuActionPerformed
        // TODO add your handling code here:
        PanelBuku.setVisible(true);
        PanelAuthor.setVisible(false);
        PanelAddAuthor.setVisible(false);
        PanelAddBuku.setVisible(false);
        populateTabelBuku();
    }//GEN-LAST:event_btn_bukuActionPerformed

    private void btn_author1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_author1ActionPerformed
        // TODO add your handling code here:
        PanelBuku.setVisible(false);
        PanelAuthor.setVisible(true);
        PanelAddAuthor.setVisible(false);
        PanelAddBuku.setVisible(false);
        populateTabelAuthor();
    }//GEN-LAST:event_btn_author1ActionPerformed

    private void btn_buku1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buku1ActionPerformed
        // TODO add your handling code here:
        PanelBuku.setVisible(true);
        PanelAuthor.setVisible(false);
        PanelAddAuthor.setVisible(false);
        PanelAddBuku.setVisible(false);
        populateTabelBuku();
    }//GEN-LAST:event_btn_buku1ActionPerformed

    private void btn_updateAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateAuthorActionPerformed

    private void btn_deleteAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteAuthorActionPerformed

    private void btn_deleteBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteBukuActionPerformed

    private void btn_updateBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateBukuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_updateBukuActionPerformed

    private void btn_addBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addBukuActionPerformed
        // TODO add your handling code here:
        
            
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db_tp5", "root", "");
                String sql = "insert into buku (nama, genre, `image`) values (?, ?, ?) ";
                PreparedStatement pst = connection.prepareStatement(sql);

                pst.setString(1,tf_namaBuku.getText());
                pst.setString(2,tf_genreBuku.getText());
                pst.setBytes(3,buku_image);

                pst.execute();
                pst.close();
                
            }catch (Exception e){
                
            }

//            String nama = tf_namaBuku.getText();
//            String genre = tf_genreBuku.getText();
//            
//            dbcon.Query("insert into mahasiswa (nama, genre, `image`) values (\""+nama+"\","+genre+", "+person_image+")");

            PanelAddBuku.setVisible(false);
            populateTabelBuku();
            PanelBuku.setVisible(true);
            
        
    }//GEN-LAST:event_btn_addBukuActionPerformed

    private void up_imageBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_imageBukuActionPerformed
        // TODO add your handling code here:

        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        
        filenameBuku = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filenameBuku).getImage().getScaledInstance(lbl_imageBuku.getWidth(), lbl_imageBuku.getHeight(), Image.SCALE_DEFAULT));
        lbl_imageBuku.setIcon(imageIcon);
        try {

            File image = new File(filenameBuku);
            FileInputStream fis = new FileInputStream (image);
            ByteArrayOutputStream bos= new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for(int readNum; (readNum=fis.read(buf))!=-1; ){

                bos.write(buf,0,readNum);
            }
            buku_image=bos.toByteArray();
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);

        }

    }//GEN-LAST:event_up_imageBukuActionPerformed

    private void up_imageAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_imageAuthorActionPerformed
        // TODO add your handling code here:
          
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        
        filenameAuthor = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filenameAuthor).getImage().getScaledInstance(lbl_imageAuthor.getWidth(), lbl_imageAuthor.getHeight(), Image.SCALE_DEFAULT));
        lbl_imageAuthor.setIcon(imageIcon);
        try {

            File image = new File(filenameAuthor);
            FileInputStream fis = new FileInputStream (image);
            ByteArrayOutputStream bos= new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for(int readNum; (readNum=fis.read(buf))!=-1; ){

                bos.write(buf,0,readNum);
            }
            author_image=bos.toByteArray();
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }//GEN-LAST:event_up_imageAuthorActionPerformed

    private void btn_addAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addAuthorActionPerformed
        // TODO add your handling code here:
                    try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db_tp5", "root", "");
                String sql = "insert into author (nama, jumlah_buku, email, `image`) values (?, ?, ?, ?) ";
                PreparedStatement pst = connection.prepareStatement(sql);

                pst.setString(1,tf_namaAuthor.getText());
                pst.setInt(2,Integer.parseInt(tf_jumlahBuku.getText()));
                pst.setString(3,tf_Email.getText());
                pst.setBytes(4,author_image);

                pst.execute();
                pst.close();
                
            }catch (Exception e){
                
            }

//            String nama = tf_namaBuku.getText();
//            String genre = tf_genreBuku.getText();
//            
//            dbcon.Query("insert into mahasiswa (nama, genre, `image`) values (\""+nama+"\","+genre+", "+person_image+")");

            PanelAddAuthor.setVisible(false);
            populateTabelAuthor();
            PanelAuthor.setVisible(true);
    }//GEN-LAST:event_btn_addAuthorActionPerformed

    private void tbl_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bukuMouseClicked
        // TODO add your handling code here:
        //Get Selected Data

    }//GEN-LAST:event_tbl_bukuMouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAddAuthor;
    private javax.swing.JPanel PanelAddBuku;
    private javax.swing.JPanel PanelAuthor;
    private javax.swing.JPanel PanelBuku;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_add1;
    private javax.swing.JButton btn_addAuthor;
    private javax.swing.JButton btn_addBuku;
    private javax.swing.JButton btn_author;
    private javax.swing.JButton btn_author1;
    private javax.swing.JButton btn_buku;
    private javax.swing.JButton btn_buku1;
    private javax.swing.JButton btn_deleteAuthor;
    private javax.swing.JButton btn_deleteBuku;
    private javax.swing.JButton btn_updateAuthor;
    private javax.swing.JButton btn_updateBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_imageAuthor;
    private javax.swing.JLabel lbl_imageBuku;
    private javax.swing.JTable tbl_author;
    private javax.swing.JTable tbl_buku;
    private javax.swing.JTextField tf_Email;
    private javax.swing.JTextField tf_genreBuku;
    private javax.swing.JTextField tf_jumlahBuku;
    private javax.swing.JTextField tf_namaAuthor;
    private javax.swing.JTextField tf_namaBuku;
    private javax.swing.JButton up_imageAuthor;
    private javax.swing.JButton up_imageBuku;
    // End of variables declaration//GEN-END:variables
}
