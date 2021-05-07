/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoplus.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author anouer
 */
public class Notes extends javax.swing.JInternalFrame {
   Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public static String test3;
     public static String test;
       public static String test4;
    /**
     * Creates new form Notes
     */
    public Notes() {
        initComponents();
        remove_title_bar();
        conn = ConexionBD.Conexion();
        Affichageseance();
        Affichageexamen(); 
//        jScrollPane5.setVisible(false);
//        jScrollPane4.setVisible(true);
        ComboEtat.setEnabled(false);
//        alert();
        Affichagesuiviseance();
        calculdepense();
        calcultottalrevenu();
        calculadmis();
        calculrefuser();
        calculnvcandidat();
    }
    void remove_title_bar(){
        putClientProperty("Notes.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
    }
    public void calcultottalrevenu(){
        try {
       Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date; 
       String requetet ="select sum(mtreg) from  regelement where datereg ='" + dc +"'  " ;
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
      int mtcontrat   = rs.getInt("sum(mtreg)");
//       JOptionPane.showMessageDialog(null, mtcontrat);
       String resultat = String.valueOf(mtcontrat);
      txtrevenu.setText(resultat);
       }
         ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Verfier les dates !");
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
       public void rechercherevenu(){
        try {
      
       String requetet ="select sum(mtreg) from  regelement where datereg =?  " ;
        ps = conn.prepareStatement(requetet);
       ps.setString(1, ((JTextField) dateseance.getDateEditor().getUiComponent()).getText());
        rs = ps.executeQuery();
       if (rs.next()) {
      int mtcontrat   = rs.getInt("sum(mtreg)");
//       JOptionPane.showMessageDialog(null, mtcontrat);
       String resultat = String.valueOf(mtcontrat);
      txtrevenu.setText(resultat);
       }
         ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Verfier les dates !");
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
    public void calculdepense() {
    try{
          Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;  
       String requetet ="select sum(montant_dep) from  depenses  where date_dep = '" + dc +"'  " ;
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
      int mtcontrat   = rs.getInt("sum(montant_dep)");

       String resultat = String.valueOf(mtcontrat);
      txtmttotal.setText(resultat);
   }
       ps.close();
                rs.close();
       } catch (Exception e) {
            System.out.println(e);
     
         
    }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
     public void recherchedepense() {
    try{
          
       String requetet ="select sum(montant_dep) from  depenses  where date_dep =?  " ;
        ps = conn.prepareStatement(requetet);
       ps.setString(1, ((JTextField) dateseance.getDateEditor().getUiComponent()).getText());
       rs = ps.executeQuery();
       if (rs.next()) {
      int mtcontrat   = rs.getInt("sum(montant_dep)");

       String resultat = String.valueOf(mtcontrat);
      txtmttotal.setText(resultat);
   }
       ps.close();
                rs.close();
       } catch (Exception e) {
            System.out.println(e);
     
         
    }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
     public void calculrefuser() {
    try{
          Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;  
       String requetet ="select count(idex) from  examen  where dateex = '" + dc +"' and etatex='Refuser' " ;
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
      int mtcontrat   = rs.getInt("count(idex)");

       String resultat = String.valueOf(mtcontrat);
      refuser.setText(resultat);
   }
       ps.close();
                rs.close();
       } catch (Exception e) {
            System.out.println(e);
     
         
    }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
     public void rechercheadmis() {
    try{
            
       String requetet ="select count(idex) from  examen  where dateex = ? and etatex='Admis' " ;
        ps = conn.prepareStatement(requetet);
        ps.setString(1, ((JTextField) dateseance.getDateEditor().getUiComponent()).getText());
       rs = ps.executeQuery();
       if (rs.next()) {
      int mtcontrat   = rs.getInt("count(idex)");

       String resultat = String.valueOf(mtcontrat);
      admis.setText(resultat);
   }
       ps.close();
                rs.close();
       } catch (Exception e) {
            System.out.println(e);
     
         
    }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
       public void rechercherefuser() {
    try{
            
       String requetet ="select count(idex) from  examen  where dateex = ? and etatex='Refuser' " ;
        ps = conn.prepareStatement(requetet);
        ps.setString(1, ((JTextField) dateseance.getDateEditor().getUiComponent()).getText());
       rs = ps.executeQuery();
       if (rs.next()) {
      int mtcontrat   = rs.getInt("count(idex)");

       String resultat = String.valueOf(mtcontrat);
      refuser.setText(resultat);
   }
       ps.close();
                rs.close();
       } catch (Exception e) {
            System.out.println(e);
     
         
    }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
     public void calculadmis() {
    try{
          Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;  
       String requetet ="select count(idex) from  examen  where dateex = '" + dc +"' and etatex='Admis' " ;
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
      int mtcontrat   = rs.getInt("count(idex)");

       String resultat = String.valueOf(mtcontrat);
      admis.setText(resultat);
   }
       ps.close();
                rs.close();
       } catch (Exception e) {
            System.out.println(e);
     
         
    }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
          public void calculnvcandidat() {
    try{
          Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;  
       String requetet ="select count(cin) from  candidat_table  where date_inscription = '" + dc +"' " ;
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
      int mtcontrat   = rs.getInt("count(cin)");

       String resultat = String.valueOf(mtcontrat);
      nv.setText(resultat);
   }
       ps.close();
                rs.close();
       } catch (Exception e) {
            System.out.println(e);
     
         
    }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
 public void Affichageseance() {
        try {
 Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date; 
            String requete6 = "select  ids as 'IdSeance' ,cinc as 'Cin_Candidat' ,cinmoni as 'Cin_Moniteur',date_sean as 'Date_Séance' ,heure_db as 'Heure_Début' ,heure_fin as 'Heure_Fin',duree_sean as 'Durée',typepermis as 'Type_permis' ,type_sean as 'Type_de_Seance',numv as 'Numéro_Vehicule',parcking as Parcking  from  seance where date_sean = '" + dc +"' ";
            ps = conn.prepareStatement(requete6);
            rs = ps.executeQuery();
            Table4.setModel(DbUtils.resultSetToTableModel(rs));
 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }

    }
  public void deplaceexamen() {
   
        try {
          
            int row = Table.getSelectedRow();
            this.test4 = (Table.getModel().getValueAt(row, 0).toString());
            String requet = " select etatex from  examen where idex= '" + test4 + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t1 = rs.getString("etatex");
                 System.out.println(t1);
  if(t1.equals("En cours")){
   
                ComboEtat.setEnabled(true);
                }else {
                  ComboEtat.setEnabled(true);  
                }
            } 
            ps.close();
                rs.close();
        
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
    }
   public void Affichageexamen() {
        try {
   Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date; 
            String requete6 = "select idex as 'IdExamen' ,cincand as 'Cin_Candidat' ,cinmonite as 'Cin_Moniteur',dateex as 'Date_Examen' ,hdbex as 'Heure_Début' ,hfnex as 'Heure_Fin',typepermis as 'Type_permis' ,typeexamen as 'Type_Examen',numve as 'Numéro_Vehicule' ,etatex as 'Etat' from  examen where dateex = '"+dc+"' ";
            ps = conn.prepareStatement(requete6);
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
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }

    }
   public void deplace() {
        try {
            int row = Table4.getSelectedRow();
            this.test3 = (Table4.getModel().getValueAt(row, 1).toString());
              
            String requet = " select * from  candidat_table where cin= '" + test3 + "'  ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                 String t1 = rs.getString("cin");
                txtcin.setText(t1);
                String t2 = rs.getString("nomc");
                txtnom.setText(t2);
                String t3 = rs.getString("prenomc");
                txtprenom.setText(t3);
                String t7 = rs.getString("gsm");
                txtgsm.setText(t7);
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
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
    }
   public void clear(){
       dateseance.setDate(null);
       txtcin.setText("");
       txtnom.setText("");
       txtprenom.setText("");
       txtgsm.setText("");
      
           
   }
    public void deplace2() {
        try {
            int row = Table.getSelectedRow();
            this.test = (Table.getModel().getValueAt(row, 1).toString());
              
            String requet = " select * from  candidat_table where cin= '" + test+ "'  ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                 String t1 = rs.getString("cin");
                txtcin.setText(t1);
                String t2 = rs.getString("nomc");
                txtnom.setText(t2);
                String t3 = rs.getString("prenomc");
                txtprenom.setText(t3);
                String t7 = rs.getString("gsm");
                txtgsm.setText(t7);
               
ps.close();
                rs.close();
            }
             ComboEtat.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
    }
   
//      public void alert() {
//        try {
//        Date actuelle = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String date = dateFormat.format(actuelle);
//        String dc = date;
//              
//            String requet = " select * from  suivivoiture where datealert = '" + dc + "'  ";
//            ps = conn.prepareStatement(requet);
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//                 String t1 = rs.getString("action");
//                action.setText(t1);
//                String t2 = rs.getString("descriptionsuivi");
//                dec.setText(t2);
//              
//               
//ps.close();
//                rs.close();
//            }
//             
//        } catch (Exception e) {
//            System.out.println(e);
//        }finally {
//
//            try {
//                ps.close();
//                rs.close();
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "deja inserre");
//            }
//        }
//    }
         public void Affichagesuiviseance() {

        
        try {
 Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;

            String requete1 = "select idsuivi as 'Id' ,	numvehicule as 'N° Vehicule', action as 'Type',	datedebuts as 'Date Debut' ,datefins as 'Date Fin' ,datealert as 'Date Alert',kilometrage as 'kilometrage',descriptionsuivi as 'Description'  from suivivoiture where datealert = '" + dc + "' ";
            ps = conn.prepareStatement(requete1);
            rs = ps.executeQuery();
            Table10.setModel(DbUtils.resultSetToTableModel(rs));
ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcin = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtgsm = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        ComboEtat = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table10 = new javax.swing.JTable();
        txtmttotal = new javax.swing.JTextField();
        txtrevenu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        admis = new javax.swing.JLabel();
        refuser = new javax.swing.JLabel();
        nv = new javax.swing.JLabel();
        dateseance = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setBorder(null);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/Accueilpage.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1790, 53);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)), "Listes des Séances :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 10))); // NOI18N

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
        jScrollPane4.setBounds(0, 170, 1000, 120);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)), "Listes des Examens :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 10))); // NOI18N

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
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(Table);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(0, 300, 1000, 130);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Cin :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(470, 120, 60, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Nom :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(470, 150, 50, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Resultat :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(750, 80, 70, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Tél :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(750, 150, 60, 17);

        txtcin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcinActionPerformed(evt);
            }
        });
        getContentPane().add(txtcin);
        txtcin.setBounds(540, 120, 180, 20);
        getContentPane().add(txtnom);
        txtnom.setBounds(540, 150, 180, 20);
        getContentPane().add(txtgsm);
        txtgsm.setBounds(820, 150, 180, 20);
        getContentPane().add(txtprenom);
        txtprenom.setBounds(820, 120, 180, 20);

        ComboEtat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En cours ", "Admis", "Refuser" }));
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
        ComboEtat.setBounds(820, 80, 180, 20);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)), "Alertes d'aujourd'hui", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12))); // NOI18N

        Table10.setModel(new javax.swing.table.DefaultTableModel(
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
        Table10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table10MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Table10MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(Table10);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 450, 530, 130);

        txtmttotal.setEditable(false);
        txtmttotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtmttotal.setForeground(new java.awt.Color(51, 153, 255));
        txtmttotal.setText("10000");
        txtmttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmttotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtmttotal);
        txtmttotal.setBounds(860, 510, 60, 20);

        txtrevenu.setEditable(false);
        txtrevenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtrevenu.setForeground(new java.awt.Color(51, 153, 255));
        txtrevenu.setText("150000");
        txtrevenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrevenuActionPerformed(evt);
            }
        });
        getContentPane().add(txtrevenu);
        txtrevenu.setBounds(860, 530, 60, 23);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Dépenses :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(770, 510, 100, 17);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Revenu :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(770, 530, 70, 30);

        admis.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        admis.setForeground(new java.awt.Color(51, 153, 255));
        admis.setText("1");
        getContentPane().add(admis);
        admis.setBounds(710, 500, 30, 30);

        refuser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        refuser.setForeground(new java.awt.Color(51, 153, 255));
        refuser.setText("2");
        getContentPane().add(refuser);
        refuser.setBounds(710, 530, 30, 20);

        nv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nv.setForeground(new java.awt.Color(51, 153, 255));
        nv.setText("7");
        getContentPane().add(nv);
        nv.setBounds(710, 470, 40, 20);

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
        getContentPane().add(dateseance);
        dateseance.setBounds(230, 130, 140, 25);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/search.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(380, 130, 49, 25);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/df.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 70, 50, 50);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("Résumé !...");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(65, 78, 170, 22);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Candidats admis :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(560, 500, 110, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel10.setText("Cette page est un résumé complet de l'activité l'auto-école ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(60, 100, 250, 13);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Candidats refusés :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(560, 530, 119, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Nouvelle inscription :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(560, 470, 131, 20);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(770, 560, 170, 2);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(20, 112, 270, 10);

        jSeparator3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(530, 460, 470, 120);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(760, 510, 10, 40);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(550, 510, 10, 40);

        jLabel14.setText("DT");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(930, 530, 40, 20);

        jLabel15.setText("DT");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(930, 510, 13, 14);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Prénom :");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(750, 120, 60, 17);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(560, 500, 170, 2);
        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(560, 560, 170, 2);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator8);
        jSeparator8.setBounds(550, 470, 2, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/refresh-page-arrow-button.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 130, 49, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table4MouseReleased
   
   deplace();
    }//GEN-LAST:event_Table4MouseReleased

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
      deplaceexamen();
    }//GEN-LAST:event_TableMouseClicked

    private void TableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseReleased
deplace2();

    }//GEN-LAST:event_TableMouseReleased

    private void txtcinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcinActionPerformed

    private void ComboEtatPopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboEtatPopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboEtatPopupMenuCanceled
public void refreshExamen(){
    try {
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;
if(dateseance.getDate()==null){
      
       
            String requete6 = "select idex as 'IdExamen' ,cincand as 'Cin_Candidat' ,cinmonite as 'Cin_Moniteur',dateex as 'Date_Examen' ,hdbex as 'Heure_Début' ,hfnex as 'Heure_Fin',typepermis as 'Type_permis' ,typeexamen as 'Type_Examen',numve as 'Numéro_Vehicule' ,etatex as 'Etat'from  examen where dateex = '"+dc+"'";
            ps = conn.prepareStatement(requete6);
            rs = ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
            calculadmis();
       
        calculrefuser();
  ps.close();
                rs.close();
}else {
          String requete2 = "select idex as 'IdExamen' ,cincand as 'Cin_Candidat' ,cinmonite as 'Cin_Moniteur',dateex as 'Date_Examen' ,hdbex as 'Heure_Début' ,hfnex as 'Heure_Fin',typepermis as 'Type_permis'  ,typeexamen as 'Type_Examen',numve as 'Numéro_Vehicule' ,etatex as 'Etat'from  examen where dateex =? ";
            ps = conn.prepareStatement(requete2);
            ps.setString(1, ((JTextField) dateseance.getDateEditor().getUiComponent()).getText());
            rs = ps.executeQuery();
            
            Table.setModel(DbUtils.resultSetToTableModel(rs));
             rechercheadmis();
    rechercherefuser();
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
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
}
    private void ComboEtatPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboEtatPopupMenuWillBecomeInvisible
        String t1 = (String) ComboEtat.getSelectedItem();
        String requete = "update examen set etatex= '"+t1+"'  where idex ='" + test4 + "'";
        try {
            ps = conn.prepareStatement(requete);
            ps.execute();
System.out.println(test3);
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
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
        // T
//        calculadmis();
//       
//        calculrefuser();
         refreshExamen();
    }//GEN-LAST:event_ComboEtatPopupMenuWillBecomeInvisible

    private void Table10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table10MouseReleased
        
    }//GEN-LAST:event_Table10MouseReleased

    private void dateseanceAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dateseanceAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceAncestorMoved

    private void dateseanceAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dateseanceAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceAncestorResized

    private void dateseanceHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dateseanceHierarchyChanged
            // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceHierarchyChanged

    private void dateseancePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateseancePropertyChange
      
    }//GEN-LAST:event_dateseancePropertyChange

    private void dateseanceCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateseanceCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceCaretPositionChanged

    private void dateseanceInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateseanceInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceInputMethodTextChanged

    private void dateseanceVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dateseanceVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateseanceVetoableChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        try {

            String requete = "select ids as 'IdSeance' ,cinc as 'Cin_Candidat' ,cinmoni as 'Cin_Moniteur',date_sean as 'Date_Séance' ,heure_db as 'Heure_Début' ,heure_fin as 'Heure_Fin',typepermis as 'Type_permis' ,type_sean as 'Type_de_Seance',numv as 'Numéro_Vehicule' ,parcking as Parcking from  seance where date_sean =? ";
            ps = conn.prepareStatement(requete);
            ps.setString(1, ((JTextField) dateseance.getDateEditor().getUiComponent()).getText());
            rs = ps.executeQuery();

            Table4.setModel(DbUtils.resultSetToTableModel(rs));
            //            Table4.setForeground(Color.green);
            //            Table4.setBackground(Color.green);
ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
        }
        try {

            String requete2 = "select idex as 'IdExamen' ,cincand as 'Cin_Candidat' ,cinmonite as 'Cin_Moniteur',dateex as 'Date_Examen' ,hdbex as 'Heure_Début' ,hfnex as 'Heure_Fin',typepermis as 'Type_permis'  ,typeexamen as 'Type_Examen',numve as 'Numéro_Vehicule' ,etatex as 'Etat'from  examen where dateex =? ";
            ps = conn.prepareStatement(requete2);
            ps.setString(1, ((JTextField) dateseance.getDateEditor().getUiComponent()).getText());
            rs = ps.executeQuery();

            Table.setModel(DbUtils.resultSetToTableModel(rs));
//            Table4.setForeground(Color.green);
//            Table4.setBackground(Color.green);
ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "deja inserre");
            }
    }//GEN-LAST:event_jButton2ActionPerformed
    rechercheadmis();
    rechercherefuser();
    rechercherevenu();
    recherchedepense();
            }
    private void txtrevenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrevenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrevenuActionPerformed

    private void txtmttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmttotalActionPerformed

    private void Table4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table4MouseClicked
   ComboEtat.setEnabled(false);
    }//GEN-LAST:event_Table4MouseClicked

    private void Table10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table10MouseClicked
     ComboEtat.setEnabled(false);
    }//GEN-LAST:event_Table10MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
clear();
  calculdepense();
        calcultottalrevenu();
        calculadmis();
        calculrefuser();
        calculnvcandidat();
        Affichageseance();
        Affichageexamen(); 
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboEtat;
    private javax.swing.JTable Table;
    private javax.swing.JTable Table10;
    private javax.swing.JTable Table4;
    private javax.swing.JLabel admis;
    private com.toedter.calendar.JDateChooser dateseance;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel nv;
    private javax.swing.JLabel refuser;
    private javax.swing.JTextField txtcin;
    private javax.swing.JTextField txtgsm;
    private javax.swing.JTextField txtmttotal;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txtrevenu;
    // End of variables declaration//GEN-END:variables
}
