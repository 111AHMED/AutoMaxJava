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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author anouer
 */
public class SuiviVehiculeGUI extends javax.swing.JFrame {
Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    /**
     * Creates new form SuiviVehiculeGUI
     */
    public SuiviVehiculeGUI() {
        initComponents();
         conn = ConexionBD.Conexion();
         Recuper();
         Affichagesuiviseance();
         btnadd.setEnabled(false);
         btnsupp.setEnabled(false);
         btnmodifier.setEnabled(false);
    }
     public void Affichagesuiviseance() {
      Vehicule info = new Vehicule();
        
        try {
String rec = info.getvehicule();

            String requete1 = "select idsuivi as 'Id' ,	numvehicule as 'N° Vehicule', action as 'Type',	datedebuts as 'Date Debut' ,datefins as 'Date Fin' ,datealert as 'Date Alert',kilometrage as 'kilometrage',descriptionsuivi as 'Description'  from  suivivoiture where numvehicule = '" + rec + "' ";
            ps = conn.prepareStatement(requete1);
            rs = ps.executeQuery();
            Table10.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
      public void Deplace() {
          
        try {

            int row = Table10.getSelectedRow();
            String test = (Table10.getModel().getValueAt(row,0).toString());
            System.out.println(test);
            String requet = "select * from suivivoiture where idsuivi = '" + test + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t9 = rs.getString("idsuivi");
                txtid.setText(t9);
                String t1 = rs.getString("numvehicule");
                txtnum.setText(t1);               
                String t2 = rs.getString("action");
                Comboaction.addItem(t2);
                Date db = rs.getDate("datedebuts");
                dtdebut.setDate(db);
                 Date df = rs.getDate("datefins");
                dtfin.setDate(df);
                 Date dalert = rs.getDate("datealert");
                dtalert.setDate(dalert);
                String t3 = rs.getString("kilometrage");
                txtkilometrage.setText(t3);
                String t4 = rs.getString("descriptionsuivi");
                txtdescription.setText(t4);

            }

        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
   public void Recuper() {
        Vehicule info = new Vehicule();
        try {
            String rec = info.getvehicule();
            String requet = "select * from Vehicule where numv = '" + rec + "'";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();
            if (rs.next()) {
                String t1 = rs.getString("numv");
                txtnum.setText(t1);
                String t2 = rs.getString("modelev");
                txtmodele.setText(t2);
//                Comboaction.addItem("Ahmed Akremi");
            }         
        } catch (Exception e) {
            System.out.println(e);
        }

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

        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtmodele = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtkilometrage = new javax.swing.JTextField();
        Comboaction = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dtdebut = new com.toedter.calendar.JDateChooser();
        dtfin = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescription = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        dtalert = new com.toedter.calendar.JDateChooser();
        btnadd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table10 = new javax.swing.JTable();
        btnsupp = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnmodifier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1089, 547));
        getContentPane().setLayout(null);

        jLabel1.setText("N° Véhicule :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(122, 74, 81, 14);

        txtid.setBackground(new java.awt.Color(255, 255, 255));
        txtid.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(txtid);
        txtid.setBounds(268, 31, 66, 22);

        txtnum.setEditable(false);
        getContentPane().add(txtnum);
        txtnum.setBounds(268, 71, 185, 20);

        jLabel2.setText("Modèle  :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(122, 112, 44, 14);

        txtmodele.setEditable(false);
        getContentPane().add(txtmodele);
        txtmodele.setBounds(268, 109, 185, 20);

        jLabel3.setText("Action à suivi :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(122, 156, 70, 14);
        getContentPane().add(txtkilometrage);
        txtkilometrage.setBounds(268, 300, 185, 20);

        getContentPane().add(Comboaction);
        Comboaction.setBounds(268, 153, 185, 20);

        jLabel4.setText("Date d'action ou Date Debut:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(122, 193, 140, 14);

        jLabel5.setText("Date Fin  :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(122, 231, 50, 14);

        jLabel6.setText("Kimometrage Acuel :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(122, 303, 98, 14);

        jLabel7.setText("Description :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(122, 331, 98, 14);

        dtdebut.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dtdebut);
        dtdebut.setBounds(268, 193, 185, 20);

        dtfin.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dtfin);
        dtfin.setBounds(268, 231, 185, 20);

        txtdescription.setColumns(20);
        txtdescription.setRows(5);
        jScrollPane1.setViewportView(txtdescription);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(268, 331, 185, 96);

        jLabel8.setText("Date Alert :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(122, 271, 56, 14);

        dtalert.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dtalert);
        dtalert.setBounds(268, 269, 185, 20);

        btnadd.setText("Ajouter");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        getContentPane().add(btnadd);
        btnadd.setBounds(270, 460, 160, 60);

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Table10MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(Table10);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(471, 109, 608, 211);

        btnsupp.setText("Supprimer");
        btnsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuppActionPerformed(evt);
            }
        });
        getContentPane().add(btnsupp);
        btnsupp.setBounds(440, 460, 100, 60);

        jLabel9.setText("ID :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(122, 39, 18, 14);

        jButton2.setText("Nouveau");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 450, 130, 70);

        btnmodifier.setText("Modifier");
        btnmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifierActionPerformed(evt);
            }
        });
        getContentPane().add(btnmodifier);
        btnmodifier.setBounds(540, 450, 140, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
      String taction = (String) Comboaction.getSelectedItem();
        try {

            String requete = "insert into  suivivoiture (numvehicule,action,datedebuts,datefins,datealert,kilometrage,descriptionsuivi) values (?,'" + taction + "',?,?,?,?,?)";
            ps = conn.prepareStatement(requete);
            ps.setString(1, txtnum.getText());
            ps.setString(2, ((JTextField) dtdebut.getDateEditor().getUiComponent()).getText());
             ps.setString(3, ((JTextField) dtfin.getDateEditor().getUiComponent()).getText());
              ps.setString(4, ((JTextField) dtalert.getDateEditor().getUiComponent()).getText());
            ps.setString(5, txtkilometrage.getText());

            ps.setString(6, txtdescription.getText());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Enregistrement avec succès");

           

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
        Affichagesuiviseance();
       clear();
        
    }//GEN-LAST:event_btnaddActionPerformed
public void clear(){
    
     dtdebut.setDate(null);
        dtfin.setDate(null);
        dtalert.setDate(null);
        txtkilometrage.setText("");
        txtdescription.setText("");
}
    private void btnsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuppActionPerformed
        try {
            int row = Table10.getSelectedRow();
            String test = (Table10.getModel().getValueAt(row, 0).toString());
            if (JOptionPane.showConfirmDialog(null, "attention vous devez suprimer une Seance,est ce que tu es sur?",
                    "Supprimer Seance", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                String requete = "delete from suivivoiture where idsuivi = '" + test + "'";
                ps = conn.prepareStatement(requete);

                ps.execute();

            }
            
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de supprimer \n" + e.getMessage());
        }
         Affichagesuiviseance();
         clear();
    }//GEN-LAST:event_btnsuppActionPerformed

    private void Table10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table10MouseReleased
     btnsupp.setEnabled(true);
     btnmodifier.setEnabled(true);
     btnadd.setEnabled(false);
        Comboaction.removeAllItems();
        Deplace() ;
    }//GEN-LAST:event_Table10MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      btnsupp.setEnabled(false);
      btnmodifier.setEnabled(false);
        btnadd.setEnabled(true);
        dtdebut.setDate(null);
        dtfin.setDate(null);
        dtalert.setDate(null);
         Comboaction.removeAllItems();
        Comboaction.addItem("Assurance");
       Comboaction.addItem("Visite");
       Comboaction.addItem("Vingette");
       Comboaction.addItem("Autre");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifierActionPerformed
String t1 = txtid.getText();
String taction = (String) Comboaction.getSelectedItem();
        try {
            String requete = "update suivivoiture set idsuivi =?,numvehicule =?,action=?,datedebuts =?,datefins =?,datealert =?,kilometrage =?,descriptionsuivi=? where  idsuivi ='" + t1 + "'";
            ps = conn.prepareStatement(requete);
            ps.setString(1, txtid.getText());
            ps.setString(2, txtnum.getText());
            ps.setString(3, taction);
            ps.setString(4, ((JTextField) dtdebut.getDateEditor().getUiComponent()).getText());
            ps.setString(5, ((JTextField) dtfin.getDateEditor().getUiComponent()).getText());
             ps.setString(6, ((JTextField) dtalert.getDateEditor().getUiComponent()).getText());
            ps.setString(7, txtkilometrage.getText());
            ps.setString(8, txtdescription.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modification avec succès");

        } catch (SQLException ex) {
            System.out.println(ex);
             JOptionPane.showMessageDialog(null, "Tout les champs obligatoire \n" + ex.getMessage());
        } 
         Affichagesuiviseance();
         clear();
    }//GEN-LAST:event_btnmodifierActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SuiviVehiculeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuiviVehiculeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuiviVehiculeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuiviVehiculeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuiviVehiculeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Comboaction;
    private javax.swing.JTable Table10;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnmodifier;
    private javax.swing.JButton btnsupp;
    private com.toedter.calendar.JDateChooser dtalert;
    private com.toedter.calendar.JDateChooser dtdebut;
    private com.toedter.calendar.JDateChooser dtfin;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextArea txtdescription;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtkilometrage;
    private javax.swing.JTextField txtmodele;
    private javax.swing.JTextField txtnum;
    // End of variables declaration//GEN-END:variables
}