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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author anouer
 */
public class AjoutCandidat extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public String sexee;
    public String etat;
    public ImageIcon Format = null;
    int s = 0;
    public static byte[] photo;
 byte[] imagedata;



    /**
     * Creates new form AjoutCandidat
     */
    public AjoutCandidat() {
        initComponents();
         this.setIconImage(new ImageIcon(getClass().getResource("logocar.png")).getImage());
        conn = ConexionBD.Conexion();
        btnaddpermis.setVisible(false);
          recept();
        Recuper();
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup2.add(act);
        buttonGroup2.add(arc);
        
//        ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
//        image.setIcon(img202);
    }

    public void recept() {
        Liste_des_Candidats ad = new Liste_des_Candidats();
        String r = ad.re();
        if (r == "ah") {
            modifierok.setVisible(true);
             ComboInscription.removeAllItems();
             btnaddpermis.setVisible(true);
        } else if (r != "ah") {
            modifierok.setVisible(false);
        }
        if (r == "a") {
            ajoutbtnok.setVisible(true);

        } else if (r != "a") {
            ajoutbtnok.setVisible(false);
        }

    }

    public void cleardata() {
        txtcin.setText("");
        txtnom.setText("");
        txtprenom.setText("");
        txtdtnaissance.setDate(null);
        txtage.setText("");
//        txtsexe.setText("");
        txtgsm.setText("");
        txtemail.setText("");
//        image.setIcon(null);
        jRadioButton1.setSelected(true);
        sexee = "Masculin";
        act.setSelected(true);
        etat="Actif";
        ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
        txtpath.setText("");
    }

    public void Recuper() {
        Liste_des_Candidats inf = new Liste_des_Candidats();
        inf.Deplace();
        try {
            String rec = inf.gettableresult();
            String requet = "select * from candidat_table where cin = '" + rec + "'";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();
            if (rs.next()) {
                String t1 = rs.getString("cin");
                txtcin.setText(t1);
                String t2 = rs.getString("nomc");
                txtnom.setText(t2);
                String t = rs.getString("prenomc");
                txtprenom.setText(t);
                Date t3 = rs.getDate("date_naissance");
                txtdtnaissance.setDate(t3);
                String t4 = rs.getString("age");
                txtage.setText(t4);
                String t5 = rs.getString("sexe");
                String vbn = t5;
                   String v9 = rs.getString("typeiscri");
                ComboInscription.addItem(v9);
              
                if (vbn.equals("Masculin")) {
                    jRadioButton1.setSelected(true);
                    sexee = "Masculin";
                } else if (vbn.equals("Féminin")) {
                    jRadioButton2.setSelected(true);
                    sexee = "Féminin";
                }
                   String t0 = rs.getString("etatcd");
                String et = t0;
                 if (et.equals("Actif")) {
                    act.setSelected(true);
                    etat = "Actif";
                } else if (et.equals("Archive")) {
                    arc.setSelected(true);
                    etat = "Archive";
                }

                //JOptionPane.showMessageDialog(null, vbn);
//                txtsexe.setText(t5);
                String t6 = rs.getString("gsm");
                txtgsm.setText(t6);
                String t7 = rs.getString("adresse");
                txtemail.setText(t7);
//                byte[] imagedata = rs.getBytes("image");
//                Format = new ImageIcon(imagedata);
//                image.setIcon(Format);
                String t8 = rs.getString("image");
                if(t8.equals("")){
                    ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202); 
                }else{
                    image.setIcon(new ImageIcon(t8));
                    txtpath.setText(t8);
                }
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
//         byte[] photo= imagedata;
//        
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
        ajoutbtnok = new javax.swing.JButton();
        modifierok = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        image = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtgsm = new javax.swing.JTextField();
        txtcin = new javax.swing.JTextField();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtage = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtprenom = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtdtnaissance = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ComboInscription = new javax.swing.JComboBox();
        act = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        arc = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        btnaddpermis = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtpath = new javax.swing.JTextField();
        btnpath = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(859, 578));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        ajoutbtnok.setText("add");
        ajoutbtnok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutbtnokMouseClicked(evt);
            }
        });
        ajoutbtnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutbtnokActionPerformed(evt);
            }
        });
        getContentPane().add(ajoutbtnok);
        ajoutbtnok.setBounds(320, 500, 190, 23);

        modifierok.setText("update");
        modifierok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierokActionPerformed(evt);
            }
        });
        getContentPane().add(modifierok);
        modifierok.setBounds(90, 500, 205, 23);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Photo Candidat :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jScrollPane1.setViewportView(image);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(519, 31, 249, 240);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Inforamation Candidat :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Date de naissance * :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel3.setText("Prénom * :");

        txtgsm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtgsmKeyTyped(evt);
            }
        });

        txtcin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcinActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Féminin");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Sexe * :");

        txtage.setEditable(false);
        txtage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtageMouseEntered(evt);
            }
        });
        txtage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtageActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Nom * :");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Masculin");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Tél  * :");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Cin * :");
        jLabel1.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Adresse * :");

        txtdtnaissance.setDateFormatString("yyyy-MM-dd");
        txtdtnaissance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtdtnaissanceMouseReleased(evt);
            }
        });
        txtdtnaissance.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtdtnaissanceComponentAdded(evt);
            }
        });
        txtdtnaissance.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtdtnaissanceAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtdtnaissance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdtnaissanceKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Age :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcin, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdtnaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(txtgsm, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtdtnaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtgsm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(90, 40, 400, 350);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255))));

        ComboInscription.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "B+E", "C", "C+E", "D", "D1", "D+E", "H" }));

        buttonGroup2.add(act);
        act.setText("actif ");
        act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Etat * :");

        buttonGroup2.add(arc);
        arc.setText("Archive ");
        arc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arcActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Type Permis * :");

        btnaddpermis.setText("Nouveau");
        btnaddpermis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddpermisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(ComboInscription, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnaddpermis, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(act, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(arc)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(ComboInscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddpermis))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(act)
                    .addComponent(arc))
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(90, 398, 400, 83);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnpath.setText("Parcourir");
        btnpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpath, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnpath)
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(571, 289, 156, 85);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcinActionPerformed

    private void ajoutbtnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutbtnokActionPerformed
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;
          String tinscri = (String) ComboInscription.getSelectedItem();
        try {

            String requete = "insert into candidat_table (cin,nomc ,prenomc,date_naissance,age,sexe,gsm,adresse,date_inscription,etatcd,image,typeiscri) values (?,?,?,?,?,?,?,?,'" + dc + "',?,?,'"+tinscri+"')";
            ps = conn.prepareStatement(requete);
            ps.setString(1, txtcin.getText());
            ps.setString(2, txtnom.getText());
            ps.setString(3, txtprenom.getText());
            ps.setString(4, ((JTextField) txtdtnaissance.getDateEditor().getUiComponent()).getText());
            ps.setString(5, txtage.getText());
            ps.setString(6, sexee);
            ps.setString(7, txtgsm.getText());
            ps.setString(8, txtemail.getText());
            ps.setString(9, etat);
            ps.setString(10, txtpath.getText());
            ps.execute();

            JOptionPane.showMessageDialog(null, "Enregistrement avec succès");
 ps.close();
                rs.close();
           

        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, "Tout est Obligatoire");
        } finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }

    }//GEN-LAST:event_ajoutbtnokActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void ajoutbtnokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutbtnokMouseClicked

    }//GEN-LAST:event_ajoutbtnokMouseClicked

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated

    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //modifok.setEnabled(false);  
       
    }//GEN-LAST:event_formWindowOpened

    private void modifierokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierokActionPerformed

     
        String t1 = txtcin.getText();
//        String t2 = txtnom.getText();
//        String t3 = txtprenom.getText();
//     Date t4 = txtdtnaissance.getDate();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//        String d = sdf.format(txtdtnaissance.getDate());
//        String t5 = txtage.getText();

//        String t6 = txtsexe.getText();
//        String t7 = txtgsm.getText();
//        String t8 = txtemail.getText();
String tinscri = (String) ComboInscription.getSelectedItem();
        String requete = "update candidat_table set cin =?,nomc =?,prenomc=?,date_naissance =?,age =?,sexe =?,gsm =?,adresse=?,etatcd=?,image =?,typeiscri=? where  cin ='" + t1 + "'";
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, txtcin.getText());
            ps.setString(2, txtnom.getText());
            ps.setString(3, txtprenom.getText());
            ps.setString(4, ((JTextField) txtdtnaissance.getDateEditor().getUiComponent()).getText());
            ps.setString(5, txtage.getText());
            ps.setString(6, sexee);
            ps.setString(7, txtgsm.getText());
            ps.setString(8, txtemail.getText());
            ps.setString(9, etat);
            ps.setString(10, txtpath.getText());
            ps.setString(11,tinscri);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modification avec succès");
 ps.close();
                rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "errer");
            }
        }

       
    }//GEN-LAST:event_modifierokActionPerformed

    private void txtageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtageActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        sexee = "Masculin";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        sexee = "Féminin";
    }//GEN-LAST:event_jRadioButton2ActionPerformed
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
//                    bs.write(b, 0, re);
//
//                }
//                this.photo = bs.toByteArray();

//            
            } 
            }catch (Exception e) {
                e.printStackTrace();
        }

    }

    private void btnpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpathActionPerformed
        imagess();

    }//GEN-LAST:event_btnpathActionPerformed

    private void txtageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtageMouseEntered
        try {
            Date actuelle = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy");
            String date = dateFormat.format(actuelle);
            String dc = date;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy", Locale.getDefault());
            String d = sdf.format(txtdtnaissance.getDate());

            int d1 = Integer.parseInt(dc);
            int d2 = Integer.parseInt(d);

            int r = (d1 - d2);
            String resultat = String.valueOf(r);
            txtage.setText(resultat);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Taper Date de Naissance");
        }


    }//GEN-LAST:event_txtageMouseEntered

    private void txtgsmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgsmKeyTyped
        char t = evt.getKeyChar();
        if (!(Character.isDigit(t) || (t == KeyEvent.VK_BACK_SPACE) || (t == KeyEvent.VK_DELETE))) {
            evt.consume();
        }


    }//GEN-LAST:event_txtgsmKeyTyped

    private void actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actActionPerformed
etat ="Actif";      
    }//GEN-LAST:event_actActionPerformed

    private void arcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arcActionPerformed
    etat ="Archive"; 
    }//GEN-LAST:event_arcActionPerformed

    private void txtdtnaissanceAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtdtnaissanceAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtnaissanceAncestorAdded

    private void txtdtnaissanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdtnaissanceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtnaissanceKeyReleased

    private void txtdtnaissanceComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtdtnaissanceComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtnaissanceComponentAdded

    private void txtdtnaissanceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdtnaissanceMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdtnaissanceMouseReleased

    private void btnaddpermisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddpermisActionPerformed
       ComboInscription.removeAllItems();
       ComboInscription.addItem("A");
       ComboInscription.addItem("B");
       ComboInscription.addItem("B+E");
       ComboInscription.addItem("c");
       ComboInscription.addItem("C+E");
       ComboInscription.addItem("D");
       ComboInscription.addItem("D1");
       ComboInscription.addItem("D+E");
       ComboInscription.addItem("H");
    }//GEN-LAST:event_btnaddpermisActionPerformed

    /**
     * red();
     *
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjoutCandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutCandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutCandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutCandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutCandidat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboInscription;
    private javax.swing.JRadioButton act;
    private javax.swing.JButton ajoutbtnok;
    private javax.swing.JRadioButton arc;
    private javax.swing.JButton btnaddpermis;
    private javax.swing.JButton btnpath;
    public javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel image;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifierok;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtcin;
    private com.toedter.calendar.JDateChooser txtdtnaissance;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtgsm;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtpath;
    private javax.swing.JTextField txtprenom;
    // End of variables declaration//GEN-END:variables
}
