/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoplus.frame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
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
public class Examens extends javax.swing.JInternalFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public static String v4;
    public static String type;
    public static String parc;
    public static String typepermis;
    public static String test;
    public static String test2;
    public static String test3;
public static String tes;
    /**
     * Creates new form Formation
     */
    public Examens() {
        initComponents();
        remove_title_bar();
        conn = ConexionBD.Conexion();
        Affichageexamen();
        affichagelecon();
        affichageCandidat();
        buttonGroup1.add(radiocode);
        buttonGroup1.add(radioconduite);
      ComboEtat.setEnabled(false);
//        combodata();
//        combodat();
//      vcs.setVisible(false);
        suppseance.setEnabled(false);
        PanelVehicule.setVisible(false);
        Panelmoniteur.setVisible(false);
        Panelseance.setVisible(false);
ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
        txtbachground.setIcon(img);
        txtreca.setText("Taper Nom Candidat");
    }
    public void clearsuivi(){
        txtconduite.setText("");
        txtcodeh.setText("");
        txtcodeprix.setText("");
        txtmtconduite.setText("");
        txttotalh.setText("");
        txttotalpri.setText("");
    }
            

    public void radiocombo() {
        String rbc = type;
        if (rbc.equals("ExamenCode")) {
            Combocin.removeAllItems();
            combodata2();
            combodat();
            PanelVehicule.setVisible(false);
            Panelseance.setVisible(true);
            Panelmoniteur.setVisible(false);
            
        } else if (rbc.equals("ExamenConduite")) {
            Combocin.removeAllItems();
            combodata();
            combodat();
            Combov.removeAllItems();
            comboVehicule();
            Vehiculedata();
            Panelmoniteur.setVisible(true);
            PanelVehicule.setVisible(true);
            Panelseance.setVisible(true);
            
        }

    }
  public void recherchelecon() {
        
      try {

            if(radiocode.isSelected()){
                searchtypes();
            }else if(radioconduite.isSelected()){
                searchtypes(); 
            }
 
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void deplaceexamen() {
//        vcs.setText("");
        try {
            int row = Table4.getSelectedRow();
            this.test3 = (Table4.getModel().getValueAt(row, 0).toString());
            String requet = " select etatex from  examen where idex= '" + test3 + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();
 System.out.println(test3);
            if (rs.next()) {
                String t1 = rs.getString("etatex");
//                vcs.setText(t1);
                 
               
//                txtidlecon.setText(t1);
//                String t2 = rs.getString("typepermis");
//                txtper.setText(t2);
//                String t3 = rs.getString("mtsean");
//                txtmtlecon.setText(t3);
//                String t4 = rs.getString("cinc");
//                txtcin.setText(t4);
////                String t5 = rs.getString("nomc");
////
////                String t6 = rs.getString("prenomc");
////                txtnomprenom.setText(t5 + "  " + " " + " " + t6);
               
                  
         
               
            } 
             
        
        } catch (Exception e) {
            System.out.println(e);
        }
               ComboEtat.setEnabled(true);
    }

    public void suppexamen() {
        try {
            if (JOptionPane.showConfirmDialog(null, "attention vous devez suprimer une Seance,est ce que tu es sur?",
                    "Supprimer Seance", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                String requete = "delete from examen where idex = '" + test3 + "'";
                ps = conn.prepareStatement(requete);

                ps.execute();

            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de supprimer \n" + e.getMessage());
        }
         refreshExamen();

    }

    public void deplacelecon() {
        try {
            int row = Table3.getSelectedRow();
            this.test2 = (Table3.getModel().getValueAt(row, 0).toString());
            String requet = " select * from  lecon where idlecon = '" + test2 + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t1 = rs.getString("idlecon");
                txtidlecon.setText(t1);
//                String t2 = rs.getString("Categoriepermis");
//                txtper.setText(t2);
                String t3 = rs.getString("mt_lec");
                txtmtlecon.setText(t3);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void recherecandidat() {
        
            
           try {
               
String requete = "select cin as 'CIN' ,nomc as 'Nom' ,prenomc as 'Prenom' ,gsm as 'GSM',adresse as 'Adresse',date_inscription as 'Date dinscription' from  candidat_table where nomc LIKE ?";
            ps = conn.prepareStatement(requete);
            ps.setString(1, "%"+txtreca.getText()+"%");
            rs = ps.executeQuery();
            Table2.setModel(DbUtils.resultSetToTableModel(rs));
                    
         }catch (Exception e) {
            System.out.println(e);
        }

    }
public void refreshExamen(){
    try {

            String requete6 = "select idex as 'IdExamen' ,cincand as 'Cin_Candidat' ,cinmonite as 'Cin_Moniteur',dateex as 'Date_Examen' ,hdbex as 'Heure_Début' ,hfnex as 'Heure_Fin',typepermis as 'Type_permis' ,mtex as 'Montant_Examen' ,typeexamen as 'Type_Examen',numve as 'Numéro_Vehicule' ,etatex as 'Etat',idlec as 'IdLecon'from  examen where cincand='"+test+"' and typepermis='"+txtper.getText()+"'";
            ps = conn.prepareStatement(requete6);
            rs = ps.executeQuery();
            Table4.setModel(DbUtils.resultSetToTableModel(rs));
 
        } catch (Exception e) {
            System.out.println(e);
        }
}
public void calculsommeconduite(){
        try{
       String requetet ="select count(idex),sum(mtex) from  examen where cincand='"+test+"'and typeexamen ='ExamenConduite' and typepermis='"+txtper.getText()+"'";
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
       String sm = rs.getString("count(idex)");
       txtconduite.setText(sm);
       
       if(txtconduite.getText().length()!=0){
       txtconduite.setText(sm);
       }else{
        txtconduite.setText("0");
       }
       
        String mtc = rs.getString("sum(mtex)");
       txtmtconduite.setText(mtc);
       
       if(txtmtconduite.getText().length()!=0){
       txtmtconduite.setText(mtc);}
       else{
        txtmtconduite.setText("0");
        
       }
       }
    }catch(Exception e){
        System.out.println(e);
    }
}
public void calculsommecode(){
      try{
       String requetet ="select count(idex),sum(mtex) from  examen where cincand='"+test+"'and typeexamen ='ExamenCode' and typepermis='"+txtper.getText()+"'";
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
       String smc = rs.getString("count(idex)");
       txtcodeh.setText(smc);
       if(txtcodeh.getText().length()!=0){
      txtcodeh.setText(smc);
       }else  {
       txtcodeh.setText("0");  
    }
        String mco = rs.getString("sum(mtex)");
       txtcodeprix.setText(mco);
       if(txtcodeprix.getText().length()!=0){
       txtcodeprix.setText(mco);
       }else  {
       txtcodeprix.setText("0");
       }
       }
    }catch(Exception e){
        System.out.println(e);
    }
}
public void calcultotal(){
     try{
       String tb= txtconduite.getText();
       String tbs= txtcodeh.getText();
        int d1 = Integer.parseInt(tb);
            int d2 = Integer.parseInt(tbs);
            
            int r = (d1 + d2);
            String resultat = String.valueOf(r);
            txttotalh.setText(resultat);
    }catch(Exception e){
       System.out.println(e); 
    }
    
      try{
       String tb2= txtmtconduite.getText();
       String tbs2= txtcodeprix.getText();

        int d1 = Integer.parseInt(tb2);
        int d2 = Integer.parseInt(tbs2);
 
            int r = (d1 + d2);

            String resultat = String.valueOf(r);

            txttotalpri.setText(resultat);

    }catch(Exception e){
       System.out.println(e); 
    }
}
    public void deplacecandidat() {
        try {
            txttotalh.setText("");
             txttotalpri.setText("");
            int row = Table2.getSelectedRow();
            this.test = (Table2.getModel().getValueAt(row, 0).toString());
            String requet = " select * from  candidat_table where cin = '" + test + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t1 = rs.getString("cin");
                txtcin.setText(t1);
                String t2 = rs.getString("nomc");
                this.v4= rs.getString("typeiscri");
                txtper.setText(v4);
                String t3 = rs.getString("prenomc");
                txtnomprenom.setText(t3 + "  " + " " + " " + t2);
            }
            
             
            ImageIcon img = new ImageIcon(getClass().getResource("sign.png"));
        txnom.setIcon(img);
             ImageIcon img1 = new ImageIcon(getClass().getResource("sign.png"));
        jLabel24.setIcon(img1);
        
        } catch (Exception e) {
            System.out.println(e);
        }
   
    }

    void remove_title_bar() {
        putClientProperty("Formation.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
    }

    public void comboVehicule() {

        try {
            String requete4 = "select * from vehicule where etatv='En service'";
            ps = conn.prepareStatement(requete4);

            rs = ps.executeQuery();
            while (rs.next()) {
                String numv = rs.getString("numv");
                Combov.addItem(numv);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Vehiculedata() {
        String t = (String) Combov.getSelectedItem();
        try {
            String requete4 = "select * from vehicule  where numv=?";
            ps = conn.prepareStatement(requete4);
            ps.setString(1, t);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tmarque = rs.getString("marquev");
                txtmarque.setText(tmarque);
                String tmodele = rs.getString("modelev");
                txtmodele.setText(tmodele);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
  public void rechercheExamen() {
        
      try {

            String requete6 = "select idex as 'IdExamen' ,cincand as 'Cin_Candidat' ,cinmonite as 'Cin_Moniteur',dateex as 'Date_Examen' ,hdbex as 'Heure_Début' ,hfnex as 'Heure_Fin',typepermis as 'Type_permis' ,mtex as 'Montant_Examen' ,typeexamen as 'Type_Examen',numve as 'Numéro_Vehicule' ,etatex as 'Etat',idlec as 'IdLecon'from  examen where cincand='"+test+"' ";
            ps = conn.prepareStatement(requete6);
            rs = ps.executeQuery();
            Table4.setModel(DbUtils.resultSetToTableModel(rs));
 
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void Affichageexamen() {
        try {

            String requete6 = "select idex as 'IdExamen' ,cincand as 'Cin_Candidat' ,cinmonite as 'Cin_Moniteur',dateex as 'Date_Examen' ,hdbex as 'Heure_Début' ,hfnex as 'Heure_Fin',typepermis as 'Type_permis' ,mtex as 'Montant_Examen' ,typeexamen as 'Type_Examen',numve as 'Numéro_Vehicule' ,etatex as 'Etat',idlec as 'IdLecon'from  examen  ";
            ps = conn.prepareStatement(requete6);
            rs = ps.executeQuery();
            Table4.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
public void affichagelecon(){
    try{
      String requete2 = "select idlecon as 'Id' ,Categoriepermis as 'Categorie' ,type_lec as 'Type' ,mt_lec as 'Montant',description_lec as 'Description' from lecon  ";
            ps = conn.prepareStatement(requete2);
            rs = ps.executeQuery();
            Table3.setModel(DbUtils.resultSetToTableModel(rs));  
    }catch(Exception e){
        System.out.println(e);
    }
}
public void affichageCandidat(){
    try{
      String requete = "select cin as 'CIN' ,nomc as 'Nom' ,prenomc as 'Prenom' ,gsm as 'GSM',adresse as 'Adresse',date_inscription as 'Date dinscription' from candidat_table where etatcd ='Actif' ";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            Table2.setModel(DbUtils.resultSetToTableModel(rs));  
    }catch(Exception e){
        System.out.println(e);
    }
}
//    public void Affichage() {
//        try {
//            String requete6 = "select idex as 'IdExamen' ,cincand as 'Cin_Candidat' ,cinmonite as 'Cin_Moniteur',dateex as 'Date_Examen' ,hdbex as 'Heure_Début' ,hfnex as 'Heure_Fin',typepermis as 'Type_permis' ,mtex as 'Montant_Examen' ,typeexamen as 'Type_Examen',numve as 'Numéro_Vehicule' ,etatex as 'Etat',idlec as 'IdLecon'from  examen";
//            ps = conn.prepareStatement(requete6);
//            rs = ps.executeQuery();
//            Table4.setModel(DbUtils.resultSetToTableModel(rs));
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }

    public void searchtypes() {

        try {
            String requete3 = "select idlecon as 'Id' ,Categoriepermis as 'Categorie' ,type_lec as 'Type' ,mt_lec as 'Montant',description_lec as 'Description' from lecon where type_lec ='" + type + "' and Categoriepermis ='" + txtper.getText() + "' ";
            ps = conn.prepareStatement(requete3);
            rs = ps.executeQuery();
            Table3.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void combodata2() {

        try {
            String requete4 = "select * from moniteur where poste_moni='Code'";
            ps = conn.prepareStatement(requete4);

            rs = ps.executeQuery();
            while (rs.next()) {
                String cinm = rs.getString("cinmoni");
                Combocin.addItem(cinm);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void combodata() {

        try {
            String requete4 = "select * from moniteur where poste_moni='Conduite'";
            ps = conn.prepareStatement(requete4);

            rs = ps.executeQuery();
            while (rs.next()) {
                String cinm = rs.getString("cinmoni");
                Combocin.addItem(cinm);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void combodat() {
        String t = (String) Combocin.getSelectedItem();
        try {
            String requete4 = "select * from moniteur  where cinmoni=?";
            ps = conn.prepareStatement(requete4);
            ps.setString(1, t);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tnom = rs.getString("nom_moni");
                txtnom.setText(tnom);
                String tprenom = rs.getString("prenom_moni");
                txtprenom.setText(tprenom);
                String tposte = rs.getString("poste_moni");
                txtposte.setText(tposte);
                String ttel = rs.getString("tel1");
                txttel.setText(ttel);

            }

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
        txtreca = new javax.swing.JTextField();
        txtbachground = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table3 = new javax.swing.JTable();
        radiocode = new javax.swing.JRadioButton();
        radioconduite = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        Panelmoniteur = new javax.swing.JPanel();
        Combocin = new javax.swing.JComboBox();
        txttel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        txtposte = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtprenom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        PanelVehicule = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtmarque = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtmodele = new javax.swing.JTextField();
        Combov = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table4 = new javax.swing.JTable();
        Ajoutexamen = new javax.swing.JButton();
        Panelinfo = new javax.swing.JPanel();
        txtidlecon = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtnomprenom = new javax.swing.JTextField();
        txtcin = new javax.swing.JTextField();
        txtper = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtmtlecon = new javax.swing.JTextField();
        Panelseance = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        dateseance = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        combodebut = new javax.swing.JComboBox();
        combofin = new javax.swing.JComboBox();
        txtseance = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txnom = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txttotalh = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtcodeh = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        prix1 = new javax.swing.JLabel();
        txttotalpri = new javax.swing.JTextField();
        NOMBREheures = new javax.swing.JLabel();
        txtcodeprix = new javax.swing.JTextField();
        txtmtconduite = new javax.swing.JTextField();
        code = new javax.swing.JLabel();
        prix2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtconduite = new javax.swing.JTextField();
        dt1 = new javax.swing.JLabel();
        dt2 = new javax.swing.JLabel();
        dt3 = new javax.swing.JLabel();
        ComboEtat = new javax.swing.JComboBox();
        printbtn = new javax.swing.JButton();
        suppseance = new javax.swing.JButton();

        setBorder(null);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        txtreca.setBackground(new java.awt.Color(240, 240, 240));
        txtreca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtreca.setForeground(new java.awt.Color(51, 153, 255));
        txtreca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtreca.setToolTipText("");
        txtreca.setBorder(null);
        txtreca.setDoubleBuffered(true);
        txtreca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtrecaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtrecaMouseEntered(evt);
            }
        });
        txtreca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrecaActionPerformed(evt);
            }
        });
        txtreca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtrecaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrecaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrecaKeyTyped(evt);
            }
        });
        getContentPane().add(txtreca);
        txtreca.setBounds(52, 58, 213, 14);

        txtbachground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/frame/txt2.png"))); // NOI18N
        getContentPane().add(txtbachground);
        txtbachground.setBounds(50, 50, 220, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/exa.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1030, 50);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        Table2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Table2.setModel(new javax.swing.table.DefaultTableModel(
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
        Table2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Table2.setRowHeight(20);
        Table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Table2MouseReleased(evt);
            }
        });
        Table2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table2KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 79, 350, 140);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        Table3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Table3.setModel(new javax.swing.table.DefaultTableModel(
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
        Table3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Table3.setRowHeight(20);
        Table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Table3MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(Table3);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(719, 81, 280, 130);

        buttonGroup1.add(radiocode);
        radiocode.setText("Cour de Code");
        radiocode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radiocodeMouseClicked(evt);
            }
        });
        radiocode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiocodeActionPerformed(evt);
            }
        });
        getContentPane().add(radiocode);
        radiocode.setBounds(380, 80, 91, 23);

        buttonGroup1.add(radioconduite);
        radioconduite.setText(" Cour de Conduite");
        radioconduite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioconduiteMouseClicked(evt);
            }
        });
        radioconduite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioconduiteActionPerformed(evt);
            }
        });
        getContentPane().add(radioconduite);
        radioconduite.setBounds(530, 80, 120, 23);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Type Examen :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 60, 130, 17);

        Panelmoniteur.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Choisir un Moniteur  :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        Combocin.setToolTipText("");
        Combocin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CombocinMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CombocinMouseReleased(evt);
            }
        });
        Combocin.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CombocinPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                CombocinPopupMenuWillBecomeVisible(evt);
            }
        });
        Combocin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CombocinItemStateChanged(evt);
            }
        });
        Combocin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombocinActionPerformed(evt);
            }
        });

        txttel.setEditable(false);

        jLabel6.setText("Poste :");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setText("Prénom :");

        txtnom.setEditable(false);

        txtposte.setEditable(false);

        jLabel5.setText("Tel :");

        txtprenom.setEditable(false);

        jLabel3.setText("Nom :");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel7.setText("Cin :");

        javax.swing.GroupLayout PanelmoniteurLayout = new javax.swing.GroupLayout(Panelmoniteur);
        Panelmoniteur.setLayout(PanelmoniteurLayout);
        PanelmoniteurLayout.setHorizontalGroup(
            PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelmoniteurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelmoniteurLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelmoniteurLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttel))
                    .addGroup(PanelmoniteurLayout.createSequentialGroup()
                        .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelmoniteurLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelmoniteurLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelmoniteurLayout.createSequentialGroup()
                                .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtposte, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Combocin, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelmoniteurLayout.setVerticalGroup(
            PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelmoniteurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Combocin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelmoniteurLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtposte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelmoniteurLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelmoniteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        getContentPane().add(Panelmoniteur);
        Panelmoniteur.setBounds(360, 110, 350, 140);

        PanelVehicule.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Choisir une Véhicule  :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel9.setText("Marque :");

        txtmarque.setEditable(false);

        jLabel10.setText("Modèle :");

        txtmodele.setEditable(false);
        txtmodele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmodeleActionPerformed(evt);
            }
        });

        Combov.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CombovPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel8.setText("Num :");

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout PanelVehiculeLayout = new javax.swing.GroupLayout(PanelVehicule);
        PanelVehicule.setLayout(PanelVehiculeLayout);
        PanelVehiculeLayout.setHorizontalGroup(
            PanelVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVehiculeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtmarque, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmodele, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PanelVehiculeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Combov, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelVehiculeLayout.setVerticalGroup(
            PanelVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVehiculeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Combov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtmarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtmodele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(PanelVehicule);
        PanelVehicule.setBounds(360, 260, 350, 95);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)), "Listes des Examens :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 10))); // NOI18N

        Table4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Table4.setModel(new javax.swing.table.DefaultTableModel(
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
        Table4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table4MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Table4MouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(Table4);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(0, 450, 1000, 170);

        Ajoutexamen.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Ajoutexamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/save.png"))); // NOI18N
        Ajoutexamen.setText("Enregistrer");
        Ajoutexamen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Ajoutexamen.setContentAreaFilled(false);
        Ajoutexamen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjoutexamenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjoutexamenMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AjoutexamenMousePressed(evt);
            }
        });
        Ajoutexamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutexamenActionPerformed(evt);
            }
        });
        getContentPane().add(Ajoutexamen);
        Ajoutexamen.setBounds(370, 370, 120, 30);

        Panelinfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Ajout Examen :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        txtidlecon.setEditable(false);

        jLabel11.setText("Cin Candidat :");

        jLabel13.setText("Nom & Prénom :");

        jLabel12.setText("ID lecon :");

        jLabel14.setText("Montant Lecon :");

        txtnomprenom.setEditable(false);
        txtnomprenom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnomprenom.setForeground(new java.awt.Color(0, 0, 153));
        txtnomprenom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnomprenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomprenomActionPerformed(evt);
            }
        });

        txtcin.setEditable(false);
        txtcin.setForeground(new java.awt.Color(0, 0, 153));

        txtper.setForeground(new java.awt.Color(0, 0, 153));
        txtper.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtperKeyReleased(evt);
            }
        });

        jLabel15.setText("Type Permis :");

        txtmtlecon.setEditable(false);

        jLabel18.setText("Heure Fin :");

        dateseance.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        dateseance.setDateFormatString("yyyy-MM-dd");
        dateseance.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                dateseanceAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                dateseanceAncestorResized(evt);
            }
        });
        dateseance.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                dateseanceHierarchyChanged(evt);
            }
        });
        dateseance.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateseancePropertyChange(evt);
            }
        });
        dateseance.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                dateseanceCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dateseanceInputMethodTextChanged(evt);
            }
        });
        dateseance.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                dateseanceVetoableChange(evt);
            }
        });

        jLabel17.setText("Heure Début :");

        jLabel16.setText("Date Séance  :");

        combodebut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "22", "23", "00", "1", "2", "3", "4", "5", "6" }));
        combodebut.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combodebutPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        combofin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "22", "23", "00", "1", "2", "3", "4", "5", "6", "7" }));
        combofin.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combofinPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/search.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel30.setName(""); // NOI18N

        jLabel31.setName(""); // NOI18N

        javax.swing.GroupLayout PanelseanceLayout = new javax.swing.GroupLayout(Panelseance);
        Panelseance.setLayout(PanelseanceLayout);
        PanelseanceLayout.setHorizontalGroup(
            PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelseanceLayout.createSequentialGroup()
                .addGroup(PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelseanceLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelseanceLayout.createSequentialGroup()
                        .addGroup(PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelseanceLayout.createSequentialGroup()
                                .addComponent(combodebut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combofin, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelseanceLayout.createSequentialGroup()
                                .addComponent(dateseance, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtseance)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        PanelseanceLayout.setVerticalGroup(
            PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelseanceLayout.createSequentialGroup()
                .addGroup(PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelseanceLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelseanceLayout.createSequentialGroup()
                                .addGroup(PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateseance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtseance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelseanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combodebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combofin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addContainerGap())
        );

        jLabel25.setName(""); // NOI18N

        txnom.setName(""); // NOI18N

        javax.swing.GroupLayout PanelinfoLayout = new javax.swing.GroupLayout(Panelinfo);
        Panelinfo.setLayout(PanelinfoLayout);
        PanelinfoLayout.setHorizontalGroup(
            PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelinfoLayout.createSequentialGroup()
                .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelinfoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Panelseance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelinfoLayout.createSequentialGroup()
                        .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelinfoLayout.createSequentialGroup()
                                .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelinfoLayout.createSequentialGroup()
                                        .addComponent(txtcin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtper, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtnomprenom)))
                            .addGroup(PanelinfoLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidlecon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmtlecon, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                                .addComponent(jLabel25))
                            .addComponent(txnom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        PanelinfoLayout.setVerticalGroup(
            PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelinfoLayout.createSequentialGroup()
                .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnomprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txnom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidlecon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtmtlecon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panelseance, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Panelinfo);
        Panelinfo.setBounds(0, 225, 360, 220);
        getContentPane().add(jLabel21);
        jLabel21.setBounds(1040, 180, 40, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Suivi  :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        txttotalh.setEditable(false);
        txttotalh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotalh.setForeground(new java.awt.Color(51, 153, 0));
        txttotalh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalhActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel23.setText("Conduite :");

        txtcodeh.setEditable(false);
        txtcodeh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcodeh.setForeground(new java.awt.Color(51, 153, 0));
        txtcodeh.setBorder(null);
        txtcodeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodehActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel27.setText("Total :");

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel28.setText("Total :");

        prix1.setText("Prix :");

        txttotalpri.setEditable(false);
        txttotalpri.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotalpri.setForeground(new java.awt.Color(51, 153, 0));
        txttotalpri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalpriActionPerformed(evt);
            }
        });

        NOMBREheures.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NOMBREheures.setText("Nombre d'Examens & Prix  :");

        txtcodeprix.setEditable(false);
        txtcodeprix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcodeprix.setForeground(new java.awt.Color(51, 153, 0));
        txtcodeprix.setBorder(null);

        txtmtconduite.setEditable(false);
        txtmtconduite.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtmtconduite.setForeground(new java.awt.Color(51, 153, 0));
        txtmtconduite.setBorder(null);

        code.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        code.setText("Code :");

        prix2.setText("Prix :");

        txtconduite.setEditable(false);
        txtconduite.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtconduite.setForeground(new java.awt.Color(51, 153, 0));
        txtconduite.setBorder(null);
        txtconduite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconduiteActionPerformed(evt);
            }
        });

        dt1.setText("DT");

        dt2.setText("DT");

        dt3.setText("DT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtconduite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(prix1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmtconduite)
                        .addGap(28, 28, 28)
                        .addComponent(dt1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator5)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txttotalh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttotalpri)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dt3)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcodeh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(prix2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcodeprix, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(dt2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(NOMBREheures, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtconduite, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prix1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmtconduite, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dt1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(NOMBREheures, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodeh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prix2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodeprix, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txttotalh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txttotalpri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dt3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(720, 216, 280, 220);

        ComboEtat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En cours ", "Admis", "Refuser" }));
        ComboEtat.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultat :"));
        ComboEtat.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                ComboEtatPopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ComboEtatPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(ComboEtat);
        ComboEtat.setBounds(590, 370, 120, 20);

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
        getContentPane().add(printbtn);
        printbtn.setBounds(550, 410, 120, 27);

        suppseance.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        suppseance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/file (1).png"))); // NOI18N
        suppseance.setText("Supprimer");
        suppseance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        suppseance.setContentAreaFilled(false);
        suppseance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suppseance.setOpaque(true);
        suppseance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suppseanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                suppseanceMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                suppseanceMousePressed(evt);
            }
        });
        suppseance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppseanceActionPerformed(evt);
            }
        });
        getContentPane().add(suppseance);
        suppseance.setBounds(410, 410, 120, 27);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radiocodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiocodeActionPerformed
        type = "ExamenCode";
        clearajoutseance();
//           radioparc.setSelected(false);
    }//GEN-LAST:event_radiocodeActionPerformed

    private void radioconduiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioconduiteActionPerformed
       type = "ExamenConduite";
       clearajoutseance();
       
    }//GEN-LAST:event_radioconduiteActionPerformed

    private void radiocodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radiocodeMouseClicked
Combov.removeAllItems();        searchtypes();
        radiocombo();

    }//GEN-LAST:event_radiocodeMouseClicked

    private void radioconduiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioconduiteMouseClicked
        searchtypes();
        radiocombo();

    }//GEN-LAST:event_radioconduiteMouseClicked

    private void CombocinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CombocinMouseEntered

    }//GEN-LAST:event_CombocinMouseEntered

    private void CombocinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CombocinItemStateChanged

    }//GEN-LAST:event_CombocinItemStateChanged

    private void CombocinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombocinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombocinActionPerformed

    private void CombocinMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CombocinMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CombocinMouseReleased

    private void CombocinPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CombocinPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_CombocinPopupMenuWillBecomeVisible

    private void CombocinPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CombocinPopupMenuWillBecomeInvisible
        combodat();
    }//GEN-LAST:event_CombocinPopupMenuWillBecomeInvisible

    private void CombovPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_CombovPopupMenuWillBecomeInvisible
        Vehiculedata();
    }//GEN-LAST:event_CombovPopupMenuWillBecomeInvisible

    private void txtnomprenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomprenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomprenomActionPerformed

    private void Table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Table2MouseClicked

    private void Table2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table2MouseReleased
        deplacecandidat();
        calculsommeconduite();
        calculsommecode();
        calcultotal();
        recherchelecon();
        refreshExamen();
        ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
        txtbachground.setIcon(img);
       txtreca.setText("Taper Nom Candidat");
      ComboEtat.setEnabled(false);
      suppseance.setEnabled(false);
       txtidlecon.setText("");
             txtmtlecon.setText("");
             ImageIcon img0110 = new ImageIcon(getClass().getResource("signxv.png"));
        jLabel25.setIcon(img0110);
//           ImageIcon img013 = new ImageIcon(getClass().getResource("signxv.png"));
//        jLabel24.setIcon(img013);
    }//GEN-LAST:event_Table2MouseReleased

    private void Table3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table3MouseReleased
ComboEtat.setEnabled(false);

deplacelecon();

    
        ImageIcon img2 = new ImageIcon(getClass().getResource("sign.png"));
        jLabel25.setIcon(img2);
        
//        CalculmtDure();
        
    }//GEN-LAST:event_Table3MouseReleased

    private void AjoutexamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutexamenActionPerformed
        String tbebut = (String) combodebut.getSelectedItem();
        String tfin = (String) combofin.getSelectedItem();
        
        String t1 = (String) Combocin.getSelectedItem();
        String t2 = (String) Combov.getSelectedItem();
        
       
        try {
           
  
 if(dateseance.getDate()==null){
        ImageIcon img = new ImageIcon(getClass().getResource("sign2.png"));
        txtseance.setIcon(img);
       }
  int d1 = Integer.parseInt(tbebut);
  int d2 = Integer.parseInt(tfin);
            if((d1>d2)||(d1==d2)){
                
                JOptionPane.showMessageDialog(null, "Verfier la Date");
//                txtdure.setText("");
//                txtmtsean.setText("");
//                txtdure.setBackground(Color.red);
//                txtmtsean.setBackground(Color.red);
                Ajoutexamen.setVisible(false);
        ImageIcon img14 = new ImageIcon(getClass().getResource("sign2.png"));
        jLabel30.setIcon(img14);
        ImageIcon img4 = new ImageIcon(getClass().getResource("sign2.png"));
        jLabel31.setIcon(img4);
            }
 if(txtnomprenom.getText().length()==0){
//        ImageIcon img01 = new ImageIcon(getClass().getResource("sign2.png"));
//        txheure.setIcon(img01);
//        ImageIcon img012 = new ImageIcon(getClass().getResource("sign2.png"));
//        txdure.setIcon(img012);
        ImageIcon img0120 = new ImageIcon(getClass().getResource("sign2.png"));
        txnom.setIcon(img0120);
             ImageIcon img013 = new ImageIcon(getClass().getResource("signxv.png"));
        jLabel24.setIcon(img013);
}  
// if(txtnomprenom.getText().length()==0){
////        ImageIcon img01 = new ImageIcon(getClass().getResource("sign2.png"));
////        jLabel30.setIcon(img01);
//        ImageIcon img012 = new ImageIcon(getClass().getResource("sign2.png"));
//        txnom.setIcon(img012);
// 
//}
 if(txtidlecon.getText().length()==0){
        ImageIcon img0110 = new ImageIcon(getClass().getResource("sign2.png"));
        jLabel25.setIcon(img0110);
      
}
// if(txtdure.getText().length()==0){
//        ImageIcon img0110 = new ImageIcon(getClass().getResource("sign2.png"));
//        jLabel30.setIcon(img0110);
//        ImageIcon img0115 = new ImageIcon(getClass().getResource("sign2.png"));
//        jLabel31.setIcon(img0115);
//}
//  if(txtmtsean.getText().length()==0){
//        ImageIcon img0110 = new ImageIcon(getClass().getResource("sign2.png"));
//        jLabel30.setIcon(img0110);
//        ImageIcon img0115 = new ImageIcon(getClass().getResource("sign2.png"));
//        jLabel31.setIcon(img0115);
//}
       else{
     String tbebu = (String) combodebut.getSelectedItem();
        String tfi = (String) combofin.getSelectedItem();
//      if(radioparc.isSelected()){
//          parc="parcking";
//      }else{
//          parc="";
//      }
            String requete = "insert into examen (dateex ,hdbex,hfnex,typeexamen,typepermis,mtex,cincand,cinmonite,numve,idlec,etatex) values (?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(requete);
            ps.setString(1, ((JTextField) dateseance.getDateEditor().getUiComponent()).getText());
//            ps.setString(2, txthdb.getText());
//            ps.setString(3, txtfin.getText());
            ps.setString(2, tbebu);
            ps.setString(3, tfi);
            ps.setString(4, type);
            ps.setString(5, txtper.getText());
            ps.setString(6, txtmtlecon.getText());
            ps.setString(7, txtcin.getText());
            ps.setString(8, t1);
            ps.setString(9, t2);
            ps.setString(10, txtidlecon.getText());
            ps.setString(11, "En cours");
            
//            ps.setString(12, "en cours");
            ps.execute();
            ImageIcon img01 = new ImageIcon(getClass().getResource("sign.png"));
        txnom.setIcon(img01);
        
        ImageIcon img = new ImageIcon(getClass().getResource("sign.png"));
        txtseance.setIcon(img);
        
            JOptionPane.showMessageDialog(null, "Enregistrement avec succès");
            Table4.setBackground(Color.WHITE);
}
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
//        radioparc.setSelected(false);
        refreshExamen();
         calculsommeconduite();
        calculsommecode();
        calcultotal();
    
    }//GEN-LAST:event_AjoutexamenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String t1 = (String) Combocin.getSelectedItem();
        try {

            String requete = "select idex as 'IdExamen' ,cincand as 'Cin_Candidat' ,cinmonite as 'Cin_Moniteur',dateex as 'Date_Examen' ,hdbex as 'Heure_Début' ,hfnex as 'Heure_Fin',typepermis as 'Type_permis' ,mtex as 'Montant_Examen' ,typeexamen as 'Type_Examen',numve as 'Numéro_Vehicule' ,etatex as 'Etat',idlec as 'IdLecon'from  examen where dateex =? and cinmonite ='" + t1 + "'";
            ps = conn.prepareStatement(requete);
            ps.setString(1, ((JTextField) dateseance.getDateEditor().getUiComponent()).getText());
            rs = ps.executeQuery();

            Table4.setModel(DbUtils.resultSetToTableModel(rs));
//            Table4.setForeground(Color.green);
//            Table4.setBackground(Color.green);

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtmodeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmodeleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmodeleActionPerformed

    private void Table4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table4MouseReleased

        deplaceexamen();

        suppseance.setEnabled(true);

//clearsuivi();
        

    }//GEN-LAST:event_Table4MouseReleased

    private void txtrecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrecaMouseClicked
        Affichageexamen();
        

        ImageIcon img = new ImageIcon(getClass().getResource("txt1.png"));
        txtbachground.setIcon(img);
        txtreca.setText("");
//        ImageIcon img2 = new ImageIcon(getClass().getResource("txt2.png"));
//        txtbachground.setIcon(img2);
//        txtreca.setText("Taper Nom Candidat");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrecaMouseClicked

    private void txtrecaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrecaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrecaMouseEntered

    private void txtrecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrecaActionPerformed

    private void txtrecaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrecaKeyPressed

    }//GEN-LAST:event_txtrecaKeyPressed

    private void txtrecaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrecaKeyReleased

     recherecandidat() ;
    }//GEN-LAST:event_txtrecaKeyReleased

    private void txtrecaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrecaKeyTyped
        

    }//GEN-LAST:event_txtrecaKeyTyped

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//affichagelecon();
//Affichage();
        ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
        txtbachground.setIcon(img);
        txtreca.setText("Taper Nom Candidat");
        suppseance.setVisible(false);
//        clearsuivi();
    }//GEN-LAST:event_formMouseClicked

    private void txtcodehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodehActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodehActionPerformed

    private void txtconduiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconduiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconduiteActionPerformed

    private void txttotalhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalhActionPerformed

    private void txttotalpriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalpriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpriActionPerformed
public void clearajoutseance(){
//    txtdure.setText("");
//    txtmtsean.setText("");
//            txtper.setText("");
            txtidlecon.setText("");
                    txtmtlecon.setText("");
                    dateseance.setDate(null);
                     ImageIcon img0 = new ImageIcon(getClass().getResource("signxv.png"));
        txtseance.setIcon(img0); 
                ImageIcon img01 = new ImageIcon(getClass().getResource("signxv.png"));
        jLabel30.setIcon(img01);
                ImageIcon img011 = new ImageIcon(getClass().getResource("signxv.png"));
        jLabel31.setIcon(img011);
                ImageIcon img012 = new ImageIcon(getClass().getResource("signxv.png"));
        jLabel25.setIcon(img012);
           
         if(txtnomprenom.getText().length()==0){

        ImageIcon img0120 = new ImageIcon(getClass().getResource("sign2.png"));
        txnom.setIcon(img0120);
         ImageIcon img013 = new ImageIcon(getClass().getResource("signxv.png"));
        jLabel24.setIcon(img013);
}
}
    public void CalculmtDure(){
    String tbebut = (String) combodebut.getSelectedItem();
        String tfin = (String) combofin.getSelectedItem();
        int d1 = Integer.parseInt(tbebut);
            int d2 = Integer.parseInt(tfin);
            if((d1>d2)||(d1==d2)){
                JOptionPane.showMessageDialog(null,"Verfier la Date ");
//                txtdure.setText("");
//                txtdure.setBackground(Color.red);
//                txtmtsean.setBackground(Color.red);
////                txtmtsean.setText("");
        ImageIcon img14 = new ImageIcon(getClass().getResource("sign2.png"));
        jLabel30.setIcon(img14);
        Ajoutexamen.setEnabled(false); 
//        ImageIcon img4 = new ImageIcon(getClass().getResource("sign2.png"));
//        jLabel31.setIcon(img4);
            }else{
//            int r = (d2 - d1);
//            String resultat = String.valueOf(r);
//            txtdure.setBackground(Color.WHITE);
//            txtmtsean.setBackground(Color.WHITE);
//            txtdure.setText(resultat);
//            if(txtmtlecon.getText().length()!=0){
//            String mtlecon=txtmtlecon.getText();
//            int m = Integer.parseInt(mtlecon);
//            int r2 = (m * r);
//            String resultat2 = String.valueOf(r2);
//            txtmtsean.setText(resultat2);
            ImageIcon img2 = new ImageIcon(getClass().getResource("sign.png"));
        jLabel30.setIcon(img2);
//        ImageIcon img44 = new ImageIcon(getClass().getResource("sign.png"));
//        jLabel31.setIcon(img44);
//            }else{
//                JOptionPane.showMessageDialog(null,"Selectionner une Leçon");
//                ImageIcon img2 = new ImageIcon(getClass().getResource("sign2.png"));
//        jLabel25.setIcon(img2);
          Ajoutexamen.setEnabled(true);  
            }
            
}
    private void combofinPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combofinPopupMenuWillBecomeInvisible
  CalculmtDure();
    }//GEN-LAST:event_combofinPopupMenuWillBecomeInvisible

    private void dateseanceHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dateseanceHierarchyChanged
 ImageIcon img0 = new ImageIcon(getClass().getResource("signxv.png"));
        txtseance.setIcon(img0);        // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceHierarchyChanged

    private void dateseanceCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateseanceCaretPositionChanged
      // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceCaretPositionChanged

    private void dateseanceInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateseanceInputMethodTextChanged
 // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceInputMethodTextChanged

    private void dateseanceAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dateseanceAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceAncestorMoved

    private void dateseanceAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dateseanceAncestorResized
       // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceAncestorResized

    private void dateseancePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateseancePropertyChange
      ImageIcon img = new ImageIcon(getClass().getResource("sign.png"));
        txtseance.setIcon(img); 
    }//GEN-LAST:event_dateseancePropertyChange

    private void dateseanceVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dateseanceVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceVetoableChange

    private void combodebutPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combodebutPopupMenuWillBecomeInvisible
CalculmtDure();        
    }//GEN-LAST:event_combodebutPopupMenuWillBecomeInvisible

    private void ComboEtatPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboEtatPopupMenuWillBecomeInvisible
 String t1 = (String) ComboEtat.getSelectedItem();
        String requete = "update examen set etatex= '"+t1+"'  where idex ='" + test3 + "'";
        try {
            ps = conn.prepareStatement(requete);
             ps.execute();
            
            JOptionPane.showMessageDialog(null, "Modification avec succès");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
// T
        refreshExamen();
    }//GEN-LAST:event_ComboEtatPopupMenuWillBecomeInvisible

    private void Table4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Table4MouseClicked

    private void ComboEtatPopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboEtatPopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboEtatPopupMenuCanceled

    private void Table2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table2KeyReleased
        if((evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
         
           deplacecandidat();
        calculsommeconduite();
        calculsommecode();
        calcultotal();
        recherchelecon();
        refreshExamen();
        txtidlecon.setText("");
             txtmtlecon.setText("");
        }
    }//GEN-LAST:event_Table2KeyReleased

    private void txtperKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtperKeyReleased
       if((evt.getKeyCode()==KeyEvent.VK_ENTER)){
      refreshExamen(); 
    calculsommeconduite();
        calculsommecode();
        calcultotal();
        
       }
    }//GEN-LAST:event_txtperKeyReleased

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

        MessageFormat header = new MessageFormat("Liste des Examens:");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            Table4.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }
    }//GEN-LAST:event_printbtnActionPerformed

    private void suppseanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppseanceMouseEntered
        suppseance.setBackground(new java.awt.Color(255,1,18));
    }//GEN-LAST:event_suppseanceMouseEntered

    private void suppseanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppseanceMouseExited
        suppseance.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_suppseanceMouseExited

    private void suppseanceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppseanceMousePressed
        suppseance.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_suppseanceMousePressed

    private void suppseanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppseanceActionPerformed
        suppexamen(); 
    }//GEN-LAST:event_suppseanceActionPerformed

    private void AjoutexamenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjoutexamenMouseEntered
       Ajoutexamen.setBackground(new java.awt.Color(0,218,170));
    }//GEN-LAST:event_AjoutexamenMouseEntered

    private void AjoutexamenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjoutexamenMouseExited
       Ajoutexamen.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_AjoutexamenMouseExited

    private void AjoutexamenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjoutexamenMousePressed
      Ajoutexamen.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_AjoutexamenMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ajoutexamen;
    private javax.swing.JComboBox ComboEtat;
    private javax.swing.JComboBox Combocin;
    private javax.swing.JComboBox Combov;
    private javax.swing.JLabel NOMBREheures;
    private javax.swing.JPanel PanelVehicule;
    private javax.swing.JPanel Panelinfo;
    private javax.swing.JPanel Panelmoniteur;
    private javax.swing.JPanel Panelseance;
    private javax.swing.JTable Table2;
    private javax.swing.JTable Table3;
    private javax.swing.JTable Table4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel code;
    private javax.swing.JComboBox combodebut;
    private javax.swing.JComboBox combofin;
    private com.toedter.calendar.JDateChooser dateseance;
    private javax.swing.JLabel dt1;
    private javax.swing.JLabel dt2;
    private javax.swing.JLabel dt3;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton printbtn;
    private javax.swing.JLabel prix1;
    private javax.swing.JLabel prix2;
    private javax.swing.JRadioButton radiocode;
    private javax.swing.JRadioButton radioconduite;
    private javax.swing.JButton suppseance;
    private javax.swing.JLabel txnom;
    private javax.swing.JLabel txtbachground;
    private javax.swing.JTextField txtcin;
    private javax.swing.JTextField txtcodeh;
    private javax.swing.JTextField txtcodeprix;
    private javax.swing.JTextField txtconduite;
    private javax.swing.JTextField txtidlecon;
    private javax.swing.JTextField txtmarque;
    private javax.swing.JTextField txtmodele;
    private javax.swing.JTextField txtmtconduite;
    private javax.swing.JTextField txtmtlecon;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnomprenom;
    private javax.swing.JTextField txtper;
    private javax.swing.JTextField txtposte;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txtreca;
    private javax.swing.JLabel txtseance;
    private javax.swing.JTextField txttel;
    private javax.swing.JTextField txttotalh;
    private javax.swing.JTextField txttotalpri;
    // End of variables declaration//GEN-END:variables
}
