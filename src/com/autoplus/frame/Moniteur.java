/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoplus.frame;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author anouer
 */
public class Moniteur extends javax.swing.JInternalFrame {
 Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test;
     public String sexee;
      public String types;
    /**
     * Creates new form Examen
     */
    public Moniteur() {
       
        initComponents();
         remove_title_bar();
        conn = ConexionBD.Conexion();
        Affichage();
            ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
        txtbachground.setIcon(img);
       txtrechercher.setText("Taper Cin Moniteur");
       ImageIcon img2 = new ImageIcon(getClass().getResource("txt2.png"));
        txtbackground1.setIcon(img2);
       txtrechercher1.setText("Taper Nom Moniteur"); 
       btnsupprimer.setEnabled(false);
       btnmodifier.setEnabled(false);
       btnenregistrer.setEnabled(false);
       buttonGroup1.add(Radiohomme);
       buttonGroup1.add(Radiofemme);
       buttonGroup2.add(Radioconduite);
       buttonGroup2.add(Radiocode);
    }
 void remove_title_bar(){
        putClientProperty("Examen.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
    }
  public void Affichage() {
        try {
            String requete = "select cinmoni as 'CIN' ,nom_moni as 'Nom' ,prenom_moni as 'Prenom' ,date_naissmoni as 'Date de Naissance',sexe As 'Sexe',tel1 as 'GSM1',tel2 as 'GSM1',adresse_moni as 'Adresse',poste_moni as 'Poste' from moniteur ";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }

    }
  public void Deplace() {
        try {

            int row = Table.getSelectedRow();
            this.test = (Table.getModel().getValueAt(row, 0).toString());
            String requet = " select * from  moniteur where cinmoni = '" + test + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t1 = rs.getString("cinmoni");
                txtcin.setText(t1);
                String t2 = rs.getString("nom_moni");
                txtnom.setText(t2);
                String t3 = rs.getString("prenom_moni");
                txtprenom.setText(t3);
                Date t4 = rs.getDate("date_naissmoni");
                txtns.setDate(t4);
                String t5 = rs.getString("tel1");
                txtgsm1.setText(t5);
                String t = rs.getString("sexe");
//                String vbn = t;
//                txtesex.setText(t);
                if (t.equals("Masculin")) {
                    Radiohomme.setSelected(true);
                    sexee = "Masculin";
                } else if (t.equals("F??minin")) {
                    Radiofemme.setSelected(true);
                    sexee = "F??minin";
                }
                String t7 = rs.getString("tel2");
                txtgsm2.setText(t7);
                String t8 = rs.getString("adresse_moni");
                txtadresse.setText(t8);
                
                 String t9 = rs.getString("poste_moni");
//                txtinscri.setText(t9);
//                 if (t9.equals("Code")) {
//                    Radiocode.setSelected(true);
//                    types = "Code";
//                } else if (t9.equals("Conduite")) {
//                    Radioconduite.setSelected(true);
//                    types = "Conduite";
//                }
                if (t9.equals("Code")) {
                    Radiocode.setSelected(true);
                    types = "Code";
                } else if (t9.equals("Conduite")) {
                    Radioconduite.setSelected(true);
                    types = "Conduite";
                }
//                byte[] imagedata =rs.getBytes("image");
//                Format = new ImageIcon(imagedata);
//                image.setIcon(Format);
                String t10 = rs.getString("image");
                System.out.println(t10);
                if (t10.equals("")) {
                    ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
                } else  {
                   image.setIcon(new ImageIcon(t10));
                   txtpath.setText(t10);
                }
//                image.setIcon(new ImageIcon(t10));
                ps.close();
                rs.close();
            }

        } catch (Exception e) {
            System.out.println(e);
            
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }
    }
  public void clear() {
        try {

            txtcin.setText("");
            txtnom.setText("");
            txtprenom.setText("");
            txtns.setDate(null);
//            txtage.setText("");
//            txtesex.setText("");
//            txtesexe.setText("");
            txtadresse.setText("");
            txtgsm1.setText("");
            txtgsm2.setText("");
            txtpath.setText("");
//            image.setIcon(null);
            ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        txtrechercher1 = new javax.swing.JTextField();
        txtbackground1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcin = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txtgsm1 = new javax.swing.JTextField();
        txtgsm2 = new javax.swing.JTextField();
        txtadresse = new javax.swing.JTextField();
        Radiohomme = new javax.swing.JRadioButton();
        Radiofemme = new javax.swing.JRadioButton();
        Radiocode = new javax.swing.JRadioButton();
        Radioconduite = new javax.swing.JRadioButton();
        txtns = new com.toedter.calendar.JDateChooser();
        txtrechercher = new javax.swing.JTextField();
        txtbachground = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable(){
            public boolean isCellEditable(int d , int c){
                return false;

            }
        };
        btnpath = new javax.swing.JButton();
        txtpath = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnnv = new javax.swing.JButton();
        btnenregistrer = new javax.swing.JButton();
        btnmodifier = new javax.swing.JButton();
        btnsupprimer = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        printbtn = new javax.swing.JButton();

        setBorder(null);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/dd_1.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1366, 53);

        txtrechercher1.setBackground(new java.awt.Color(240, 240, 240));
        txtrechercher1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtrechercher1.setForeground(new java.awt.Color(51, 153, 255));
        txtrechercher1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtrechercher1.setBorder(null);
        txtrechercher1.setDoubleBuffered(true);
        txtrechercher1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtrechercher1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtrechercher1MouseEntered(evt);
            }
        });
        txtrechercher1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrechercher1ActionPerformed(evt);
            }
        });
        txtrechercher1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtrechercher1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrechercher1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrechercher1KeyTyped(evt);
            }
        });
        getContentPane().add(txtrechercher1);
        txtrechercher1.setBounds(312, 89, 213, 14);

        txtbackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/frame/txt2.png"))); // NOI18N
        getContentPane().add(txtbackground1);
        txtbackground1.setBounds(310, 80, 220, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/interface.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 70, 70, 40);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Information Moniteur :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12), java.awt.Color.black)); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 204));

        jLabel3.setText("Nom  :");

        jLabel4.setText("Date de naissance  :");

        jLabel5.setText("Prenom  :");

        jLabel8.setText("Adresse :");

        jLabel1.setText("CIN   :            ");

        jLabel7.setText("GSM2   :");

        jLabel6.setText("GSM1 :");

        jLabel10.setText("Poste :");

        jLabel9.setText("Sexe  :");

        txtcin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtcinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtcinMouseExited(evt);
            }
        });

        Radiohomme.setText("Masculin");
        Radiohomme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadiohommeActionPerformed(evt);
            }
        });

        Radiofemme.setText("F??minin");
        Radiofemme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadiofemmeActionPerformed(evt);
            }
        });

        Radiocode.setText("Code");
        Radiocode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadiocodeActionPerformed(evt);
            }
        });

        Radioconduite.setText("Conduite");
        Radioconduite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioconduiteActionPerformed(evt);
            }
        });

        txtns.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtprenom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtns, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtgsm2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(txtgsm1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Radiohomme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Radiofemme))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Radiocode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Radioconduite))
                            .addComponent(txtadresse, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Radiohomme)
                    .addComponent(Radiofemme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgsm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgsm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(txtadresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Radiocode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Radioconduite)))
                .addGap(5, 5, 5))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(538, 115, 270, 340);

        txtrechercher.setBackground(new java.awt.Color(240, 240, 240));
        txtrechercher.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtrechercher.setForeground(new java.awt.Color(51, 153, 255));
        txtrechercher.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtrechercher.setBorder(null);
        txtrechercher.setDoubleBuffered(true);
        txtrechercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtrechercherMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtrechercherMouseEntered(evt);
            }
        });
        txtrechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrechercherActionPerformed(evt);
            }
        });
        txtrechercher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtrechercherKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrechercherKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrechercherKeyTyped(evt);
            }
        });
        getContentPane().add(txtrechercher);
        txtrechercher.setBounds(4, 89, 213, 14);

        txtbachground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/frame/txt2.png"))); // NOI18N
        getContentPane().add(txtbachground);
        txtbachground.setBounds(0, 80, 220, 30);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Photo Moniteur :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12), java.awt.Color.black)); // NOI18N

        image.setBackground(new java.awt.Color(255, 255, 255));
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/file_image_1.png"))); // NOI18N
        jScrollPane2.setViewportView(image);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(810, 120, 200, 240);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)), "Listes des Moniteurs :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12))); // NOI18N

        Table.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
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
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Table.setRowHeight(20);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TableMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableMouseReleased(evt);
            }
        });
        Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 120, 530, 220);

        btnpath.setText("Images");
        btnpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpathActionPerformed(evt);
            }
        });
        getContentPane().add(btnpath);
        btnpath.setBounds(860, 400, 110, 23);
        getContentPane().add(txtpath);
        txtpath.setBounds(840, 370, 140, 20);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)), "Action :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Verdana", 3, 12))); // NOI18N

        btnnv.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/file.png"))); // NOI18N
        btnnv.setText("Nouveau");
        btnnv.setToolTipText("");
        btnnv.setAutoscrolls(true);
        btnnv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnnv.setContentAreaFilled(false);
        btnnv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnv.setOpaque(true);
        btnnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnnvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnnvMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnnvMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnnvMouseReleased(evt);
            }
        });
        btnnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnvActionPerformed(evt);
            }
        });

        btnenregistrer.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnenregistrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/save.png"))); // NOI18N
        btnenregistrer.setText("Enregistrer");
        btnenregistrer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnenregistrer.setContentAreaFilled(false);
        btnenregistrer.setOpaque(true);
        btnenregistrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnenregistrerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnenregistrerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnenregistrerMousePressed(evt);
            }
        });
        btnenregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenregistrerActionPerformed(evt);
            }
        });

        btnmodifier.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnmodifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/file (2).png"))); // NOI18N
        btnmodifier.setText("Modifier");
        btnmodifier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnmodifier.setContentAreaFilled(false);
        btnmodifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmodifier.setOpaque(true);
        btnmodifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmodifierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnmodifierMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnmodifierMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnmodifierMouseReleased(evt);
            }
        });
        btnmodifier.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnmodifierMouseMoved(evt);
            }
        });
        btnmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifierActionPerformed(evt);
            }
        });

        btnsupprimer.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnsupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/file (1).png"))); // NOI18N
        btnsupprimer.setText("Supprimer");
        btnsupprimer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnsupprimer.setContentAreaFilled(false);
        btnsupprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsupprimer.setOpaque(true);
        btnsupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsupprimerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsupprimerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnsupprimerMousePressed(evt);
            }
        });
        btnsupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnv, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnenregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmodifier, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnv, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnenregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmodifier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 340, 390, 130);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Impr??ssion :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        printbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        printbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/printer.png"))); // NOI18N
        printbtn.setText("Imprimer");
        printbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        printbtn.setContentAreaFilled(false);
        printbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printbtn.setOpaque(true);
        printbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printbtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printbtnMousePressed(evt);
            }
        });
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(printbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(390, 350, 140, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Affichage();

//        clear();
//        btnsupprimer.setEnabled(false);
//        modifierbtn.setEnabled(false);
//        btnconrat.setEnabled(false);
        image.setIcon(null);
        ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
        txtbachground.setIcon(img);
        txtrechercher.setText("Taper Cin Moniteur");
        ImageIcon img2 = new ImageIcon(getClass().getResource("txt2.png"));
        txtbackground1.setIcon(img2);
        txtrechercher1.setText("Taper Nom Moniteur");

        ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtrechercher1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrechercher1MouseClicked
        Affichage();
//        clear();
//        btnsupprimer.setEnabled(false);
//        modifierbtn.setEnabled(false);
//        btnconrat.setEnabled(false);
        //       image.setIcon(null);
        ImageIcon img2 = new ImageIcon(getClass().getResource("txt1.png"));
        txtbackground1.setIcon(img2);
        txtrechercher1.setText("");
        ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
        txtbachground.setIcon(img);
        txtrechercher.setText("Taper Cin Moniteur");

        ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);

    }//GEN-LAST:event_txtrechercher1MouseClicked

    private void txtrechercher1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrechercher1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercher1MouseEntered

    private void txtrechercher1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrechercher1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercher1ActionPerformed

    private void txtrechercher1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercher1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercher1KeyPressed

    private void txtrechercher1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercher1KeyReleased
        try {
            String requete = "select cinmoni as 'CIN' ,nom_moni as 'Nom' ,prenom_moni as 'Prenom' ,date_naissmoni as 'Date de Naissance',sexe As 'Sexe',tel1 as 'GSM1',tel2 as 'GSM1',adresse_moni as 'Adresse',poste_moni as 'Poste' from moniteur  where nom_moni LIKE ?";
            ps = conn.prepareStatement(requete);
            ps.setString(1, "%"+txtrechercher1.getText()+"%");
            rs = ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
//            byte[] imagedata =rs.getBytes("image");
//            Format = new ImageIcon(imagedata);
//            image.setIcon(Format);
            ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }

    }//GEN-LAST:event_txtrechercher1KeyReleased

    private void txtrechercher1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercher1KeyTyped
      clear();
//        btnconrat.setEnabled(false);
//        btnsupprimer.setEnabled(false);
//        modifierbtn.setEnabled(false);

          ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);      // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercher1KeyTyped

    private void txtrechercherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrechercherMouseClicked
        Affichage();
        clear();
//
//        btnsupprimer.setEnabled(false);
//        modifierbtn.setEnabled(false);
//        btnconrat.setEnabled(false);
        //       image.setIcon(null);

        ImageIcon img = new ImageIcon(getClass().getResource("txt1.png"));
        txtbachground.setIcon(img);
        txtrechercher.setText("");
        ImageIcon img2 = new ImageIcon(getClass().getResource("txt2.png"));
        txtbackground1.setIcon(img2);
        txtrechercher1.setText("Taper Nom Moniteur");

        ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercherMouseClicked

    private void txtrechercherMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrechercherMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercherMouseEntered

    private void txtrechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrechercherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercherActionPerformed

    private void txtrechercherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercherKeyPressed

    }//GEN-LAST:event_txtrechercherKeyPressed

    private void txtrechercherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercherKeyReleased

        try {
            String requete = "select cinmoni as 'CIN' ,nom_moni as 'Nom' ,prenom_moni as 'Prenom' ,date_naissmoni as 'Date de Naissance',sexe As 'Sexe',tel1 as 'GSM1',tel2 as 'GSM1',adresse_moni as 'Adresse',poste_moni as 'Poste' from moniteur  where cinmoni LIKE ?";
            ps = conn.prepareStatement(requete);
            ps.setString(1, "%"+txtrechercher.getText()+"%");
            rs = ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
//            byte[] imagedata =rs.getBytes("image");
//            Format = new ImageIcon(imagedata);
//            image.setIcon(Format);
             ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }
    }//GEN-LAST:event_txtrechercherKeyReleased
public void imagess() {
        ConexionBD v = new ConexionBD();
        v.filen();
        String vpath = v.getp();
         try {
        if (vpath == null) {

        } else {
            image.setIcon(new ImageIcon(vpath));
            txtpath.setText(vpath);

           
//                File image = new File(vpath);
//                FileInputStream fs = new FileInputStream(image);
//                ByteArrayOutputStream bs = new ByteArrayOutputStream();
//                byte[] b = new byte[1024];
//                for (int re; (re = fs.read(b)) != -1;) {
////                    bs.write(b, 0, re);
//
//                }
//                this.photo = bs.toByteArray();

//            
            } 
        }catch (Exception e) {
                e.printStackTrace();
            }

    }

    private void txtrechercherKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercherKeyTyped
       clear();
//        btnsupprimer.setEnabled(false);
//        modifierbtn.setEnabled(false);
//        btnconrat.setEnabled(false);
         ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);

    }//GEN-LAST:event_txtrechercherKeyTyped

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        //        Deplace();

    }//GEN-LAST:event_TableMouseClicked

    private void TableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseEntered
        //Affichage();
    }//GEN-LAST:event_TableMouseEntered

    private void TableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseReleased
//        btnsupprimer.setEnabled(true);
//        modifierbtn.setEnabled(true);
//        btnconrat.setEnabled(true);
        ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
        txtpath.setText("");
        Deplace();
        ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
        txtbachground.setIcon(img);
        txtrechercher.setText("Taper Cin Moniteur");
        ImageIcon img2 = new ImageIcon(getClass().getResource("txt2.png"));
        txtbackground1.setIcon(img2);
        txtrechercher1.setText("Taper Nom Moniteur");
        btnsupprimer.setEnabled(true);
       btnmodifier.setEnabled(true);
       btnenregistrer.setEnabled(false);
    }//GEN-LAST:event_TableMouseReleased

    private void RadiofemmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadiofemmeActionPerformed
        sexee = "F??minin";
    }//GEN-LAST:event_RadiofemmeActionPerformed

    private void RadiohommeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadiohommeActionPerformed
        sexee = "Masculin";
    }//GEN-LAST:event_RadiohommeActionPerformed

    private void RadiocodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadiocodeActionPerformed
        types="Code";       
    }//GEN-LAST:event_RadiocodeActionPerformed

    private void RadioconduiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioconduiteActionPerformed
        types="Conduite"; 
    }//GEN-LAST:event_RadioconduiteActionPerformed

    private void btnpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpathActionPerformed
        imagess();
    }//GEN-LAST:event_btnpathActionPerformed

    private void btnenregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenregistrerActionPerformed
try {

            String requete = "insert into  moniteur (cinmoni,nom_moni ,prenom_moni,date_naissmoni,sexe,adresse_moni,tel1,tel2,poste_moni,image) values (?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(requete);
            ps.setString(1, txtcin.getText());
            ps.setString(2, txtnom.getText());
            ps.setString(3, txtprenom.getText());
            ps.setString(4, ((JTextField) txtns.getDateEditor().getUiComponent()).getText());
            ps.setString(5, sexee);
            ps.setString(6, txtadresse.getText());
            ps.setString(7, txtgsm1.getText());
            ps.setString(8, txtgsm2.getText());
            ps.setString(9, types);
            ps.setString(10, txtpath.getText());
            ps.execute();

            JOptionPane.showMessageDialog(null, "Enregistrement avec succ??s");

           

        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, "Tout est Obligatoire");
        } finally {

            try {
                ps.close();
                rs.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "deja inserre"+ex);
            }
        } 
Affichage();
    }//GEN-LAST:event_btnenregistrerActionPerformed

    private void TableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKeyReleased
       if((evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
           ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
        txtpath.setText("");
           Deplace();
       }
    }//GEN-LAST:event_TableKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
clear();       
    }//GEN-LAST:event_formMouseClicked

    private void txtcinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcinMouseEntered
       
    }//GEN-LAST:event_txtcinMouseEntered

    private void txtcinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcinMouseExited
     
    }//GEN-LAST:event_txtcinMouseExited

    private void btnnvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnvMouseEntered
        btnnv.setBackground(new java.awt.Color(32,242,4));
    }//GEN-LAST:event_btnnvMouseEntered

    private void btnnvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnvMouseExited
        btnnv.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_btnnvMouseExited

    private void btnnvMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnvMousePressed
        btnnv.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btnnvMousePressed

    private void btnnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnvActionPerformed
       
    }//GEN-LAST:event_btnnvActionPerformed

    private void btnnvMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnvMouseReleased
    btnenregistrer.setEnabled(true); 
btnsupprimer.setEnabled(false);
       btnmodifier.setEnabled(false);
       clear();
    }//GEN-LAST:event_btnnvMouseReleased

    private void btnenregistrerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnenregistrerMouseExited
  btnenregistrer.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_btnenregistrerMouseExited

    private void btnenregistrerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnenregistrerMousePressed
             btnenregistrer.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btnenregistrerMousePressed

    private void btnenregistrerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnenregistrerMouseEntered
      btnenregistrer.setBackground(new java.awt.Color(0,218,170));
    }//GEN-LAST:event_btnenregistrerMouseEntered

    private void btnmodifierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodifierMouseEntered
        btnmodifier.setBackground(new java.awt.Color(188,1,255));
    }//GEN-LAST:event_btnmodifierMouseEntered

    private void btnmodifierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodifierMouseExited
        btnmodifier.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_btnmodifierMouseExited

    private void btnmodifierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodifierMousePressed
        btnmodifier.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btnmodifierMousePressed

    private void btnmodifierMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodifierMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmodifierMouseReleased

    private void btnmodifierMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmodifierMouseMoved

    }//GEN-LAST:event_btnmodifierMouseMoved

    private void btnmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifierActionPerformed
          String requete = "update moniteur set cinmoni =?,nom_moni =?,prenom_moni=?,date_naissmoni =?,sexe =?,adresse_moni =?,tel1 =?,tel2=?,poste_moni=?,image =? where  cinmoni ='" +txtcin.getText()+ "'";
        try {
            ps = conn.prepareStatement(requete);
             ps.setString(1, txtcin.getText());
            ps.setString(2, txtnom.getText());
            ps.setString(3, txtprenom.getText());
            ps.setString(4, ((JTextField) txtns.getDateEditor().getUiComponent()).getText());
            ps.setString(5, sexee);
            ps.setString(6, txtadresse.getText());
            ps.setString(7, txtgsm1.getText());
            ps.setString(8, txtgsm2.getText());
            ps.setString(9, types);
            ps.setString(10, txtpath.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modification avec succ??s");
ps.close();
                rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }
       
        
        Affichage();
    }//GEN-LAST:event_btnmodifierActionPerformed

    private void btnsupprimerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsupprimerMouseEntered
        btnsupprimer.setBackground(new java.awt.Color(255,1,18));
    }//GEN-LAST:event_btnsupprimerMouseEntered

    private void btnsupprimerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsupprimerMouseExited
        btnsupprimer.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_btnsupprimerMouseExited

    private void btnsupprimerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsupprimerMousePressed
        btnsupprimer.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btnsupprimerMousePressed

    private void btnsupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupprimerActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(null, "attention vous devez suprimer un Moniteur,est ce que tu es sur?",
                    "Supprimer Moniteur", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                String requete = "delete from moniteur where cinmoni = '" + txtcin.getText() + "'";
                ps = conn.prepareStatement(requete);

                ps.execute();
 ps.close();
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de supprimer \n" + e.getMessage());
        }
          finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }
       Affichage(); 

    }//GEN-LAST:event_btnsupprimerActionPerformed

    private void printbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbtnMouseEntered
        printbtn.setBackground(new java.awt.Color(0,153,153));
    }//GEN-LAST:event_printbtnMouseEntered

    private void printbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbtnMouseExited
        printbtn.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_printbtnMouseExited

    private void printbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printbtnMousePressed
        printbtn.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_printbtnMousePressed

    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed

        MessageFormat header = new MessageFormat("Liste des Moniteurs:");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            Table.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }

    }//GEN-LAST:event_printbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Radiocode;
    private javax.swing.JRadioButton Radioconduite;
    private javax.swing.JRadioButton Radiofemme;
    private javax.swing.JRadioButton Radiohomme;
    private javax.swing.JTable Table;
    private javax.swing.JButton btnenregistrer;
    public javax.swing.JButton btnmodifier;
    private javax.swing.JButton btnnv;
    private javax.swing.JButton btnpath;
    private javax.swing.JButton btnsupprimer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printbtn;
    private javax.swing.JTextField txtadresse;
    private javax.swing.JLabel txtbachground;
    private javax.swing.JLabel txtbackground1;
    private javax.swing.JTextField txtcin;
    private javax.swing.JTextField txtgsm1;
    private javax.swing.JTextField txtgsm2;
    private javax.swing.JTextField txtnom;
    private com.toedter.calendar.JDateChooser txtns;
    private javax.swing.JTextField txtpath;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txtrechercher;
    private javax.swing.JTextField txtrechercher1;
    // End of variables declaration//GEN-END:variables
}
