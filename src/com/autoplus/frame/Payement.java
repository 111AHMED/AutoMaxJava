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
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author anouer
 */
public class Payement extends javax.swing.JInternalFrame {
 Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test;
    static String test3;
    static String te;
    static int mtcontrat;
  public static String resultatcvc;
  public static String res;
    public static int r;
    public ImageIcon Format =null;
       public static String nbrh; 
      public static String nbrh2;
      public static String datfin; 
      public static String mont;
      public static String catp; 
      public static String datfin2; 
      public static String mont2;
      public static String catp2;
        public static String v4;
     
    /**
     * Creates new form Payement
     */
    public Payement() {
        initComponents();
        remove_title_bar();
      conn = ConexionBD.Conexion();
      Affichage();
      Affichageregelement();
//      ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
//        txtbachground.setIcon(img);
//       txtrechercher.setText("Taper Cin Candidat");
       ImageIcon img2 = new ImageIcon(getClass().getResource("txt2.png"));
        txtbackground1.setIcon(img2);
       txtrechercher1.setText("Taper Nom Candidat"); 
    }
    void remove_title_bar(){
        putClientProperty("Payement.isPalette",Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
        
    }
    public void clear() {
        try {

            txtcin.setText("");
            txtnom.setText("");
            txtprenom.setText("");
//            txtns.setText("");
            txtage.setText("");
//            txtesex.setText("");
//            txtesexe.setText("");
//            txtetat.setText("");
//            txtmail.setText("");
//            txtinscri.setText("");
//            image.setIcon(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 public void Deplace() {
        try {

            int row = Table2.getSelectedRow();
            this.test = (Table2.getModel().getValueAt(row, 0).toString());
            String requet = " select * from  candidat_table where cin = '" + test + "'  ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t1 = rs.getString("cin");
                txtcin.setText(t1);
                String t2 = rs.getString("nomc");
                txtnom.setText(t2);
                String t3 = rs.getString("prenomc");
                txtprenom.setText(t3);
//                String t4 = rs.getString("date_naissance");
//                txtns.setText(t4);
                String t5 = rs.getString("age");
                txtage.setText(t5);
                this.v4= rs.getString("typeiscri");
                txtper.setText(v4);
//                String t = rs.getString("sexe");
//                txtesex.setText(t);
//                String t7 = rs.getString("gsm");
//                txtesexe.setText(t7);
//                String t8 = rs.getString("adresse");
//                txtmail.setText(t8);
//                String t6 = rs.getString("etatcd");
//                txtetat.setText(t6);
//                 String t9 = rs.getString("date_inscription");
//                txtinscri.setText(t9);
//                byte[] imagedata =rs.getBytes("image");
//                Format = new ImageIcon(imagedata);
//                image.setIcon(Format);
                
            }
 
        } catch (Exception e) {
            System.out.println(e);
            
        }
        try {

            String requete6 = "select idreg as 'Id' ,cinct as 'CIN_Candidat' ,datereg as 'Date_regelement' , mtreg as 'Montant',mode as 'Mode_Reg' ,numche as 'Num_Cheque',typesp as 'type Permis' from regelement where cinct='"+test+"' ";
            ps = conn.prepareStatement(requete6);
            rs = ps.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));
 
        } catch (Exception e) {
            System.out.println(e);
        }
//            try{
//       String requetet ="select sum(duree_sean),sum(mtsean) from  seance where cinc='"+test+"'and type_sean ='Conduite'";
//        ps = conn.prepareStatement(requetet);
//       rs = ps.executeQuery();
//       if (rs.next()) {
//       String sm = rs.getString("sum(duree_sean)");
//       txtconduite.setText(sm);
//       
//       if(txtconduite.getText().length()!=0){
//       txtconduite.setText(sm);
//       }else{
//        txtconduite.setText("0");
//       }
//       
//        String mtc = rs.getString("sum(mtsean)");
//       txtmtconduite.setText(mtc);
//       
//       if(txtmtconduite.getText().length()!=0){
//       txtmtconduite.setText(mtc);}
//       else{
//        txtmtconduite.setText("0");
//        
//       }
//       }
//    }catch(Exception e){
//        System.out.println(e);
//    }
     
      //Examen
        
       
        calculseance();
      calcullexamen();
      calcultotal();
       calcultotalregelement();
      claculreste();
    }
   public String gettableresulto() {
        return test;
    }
  
 public void calcultotal(){
//     try{
    
//       txtreg.setText(smt);
       
//       if(txtreg.getText().length()!=0){
//       txtreg.setText(smt);
//       }else{
//        txtreg.setText("0");
//       }
//       }
//      }catch(Exception e){
//        System.out.println(e);
//               
//       }
      try{
       String requetet ="select sum(montantctr) from  contrat where cinctr='"+test+"' and catpermis='"+txtper.getText()+"' and etat='Actif'" ;
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
       this.mtcontrat   = rs.getInt("sum(montantctr)");
//       JOptionPane.showMessageDialog(null, mtcontrat);
        
       }
       String tbc= txttotalpri1.getText();
       String tbsc= txttotalpri2.getText();
        int d1c = Integer.parseInt(tbc);
            int d2c = Integer.parseInt(tbsc);
            
            int rc = (d1c + d2c+mtcontrat);
            String resultatcv = String.valueOf(rc);
            totalcandidat.setText(resultatcv);
//           JOptionPane.showMessageDialog(null, d3);
    }catch(Exception e){
       System.out.println(e); 
    }
 }
 
 public void claculreste(){
  try{
       String tbts= totalcandidat.getText();
       String tbsts= txtreg.getText();
        int d1ts = Integer.parseInt(tbts);
            int d2ts = Integer.parseInt(tbsts);
            
            int rts = (d1ts - d2ts);
            this.r = rts;
             this.resultatcvc = String.valueOf(rts);
            
            resteapayer.setText(resultatcvc);
            String tvv= resteapayer.getText();
            this.res=resteapayer.getText();
            System.out.println(r);
    }catch(Exception e){
       System.out.println(e); 
    }
 }  
  public String gettableresults() {
        return res;
    }
//  public void calcultotalcontrat(){
//    try{
//       String requetet ="select sum(montantctr) from  contrat where cinctr='"+test+"'";
//        ps = conn.prepareStatement(requetet);
//       rs = ps.executeQuery();
//       if (rs.next()) {
//       String mtcontrat   = rs.getString("sum(montantctr)");
//       int d3 = Integer.parseInt(mtcontrat);
////       txtreg.setText(smt);
//       
////       if(txtreg.getText().length()!=0){
////       txtreg.setText(smt);
////       }else{
////        txtreg.setText("0");
////       }
//       }
//      }catch(Exception e){
//        System.out.println(e);
//               
//       }
//    
// }
 public void calcultotalregelement(){
    try{
       String requetet ="select sum(mtreg) from  regelement where cinct='"+test+"' and typesp='"+txtper.getText()+"'";
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
       String smt = rs.getString("sum(mtreg)");
       txtreg.setText(smt);
       
       if(txtreg.getText().length()!=0){
       txtreg.setText(smt);
       }else{
        txtreg.setText("0");
       }
       }
      }catch(Exception e){
        System.out.println(e);
               
       }
    
 }
 public void calculseance(){
    try{
       String requetet ="select sum(duree_sean),sum(mtsean) from  seance where cinc='"+test+"'and type_sean ='Conduite' and typepermis='"+txtper.getText()+"'";
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
       String smt = rs.getString("sum(duree_sean)");
       txtconduite2.setText(smt);
       
       if(txtconduite2.getText().length()!=0){
       txtconduite2.setText(smt);
       }else{
        txtconduite2.setText("0");
       }
       
        String mtct = rs.getString("sum(mtsean)");
       txtmtconduite2.setText(mtct);
       
       if(txtmtconduite2.getText().length()!=0){
       txtmtconduite2.setText(mtct);}
       else{
        txtmtconduite2.setText("0");
        
       }
       }
    }catch(Exception e){
        System.out.println(e);
    }
     try{
       String requetet ="select sum(duree_sean),sum(mtsean) from  seance where cinc='"+test+"'and type_sean ='Code'and typepermis='"+txtper.getText()+"'";
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
       String smct = rs.getString("sum(duree_sean)");
       txtcodeh2.setText(smct);
       if(txtcodeh2.getText().length()!=0){
      txtcodeh2.setText(smct);
       }else  {
       txtcodeh2.setText("0");  
    }
        String mcot = rs.getString("sum(mtsean)");
       txtcodeprix2.setText(mcot);
       if(txtcodeprix2.getText().length()!=0){
       txtcodeprix2.setText(mcot);
       }else  {
       txtcodeprix2.setText("0");
       }
       }
    }catch(Exception e){
        System.out.println(e);
    }
    try{
       String tbt= txtconduite2.getText();
       String tbst= txtcodeh2.getText();
        int d1t = Integer.parseInt(tbt);
            int d2t = Integer.parseInt(tbst);
            
            int rt = (d1t + d2t);
            String resultatt = String.valueOf(rt);
            txttotalh2.setText(resultatt);
    }catch(Exception e){
       System.out.println(e); 
    }
    
      try{
       String tb2b= txtmtconduite2.getText();
       String tbs2b= txtcodeprix2.getText();

        int d1b = Integer.parseInt(tb2b);
        int d2b = Integer.parseInt(tbs2b);
 
            int rb = (d1b + d2b);

            String resultatb = String.valueOf(rb);

            txttotalpri2.setText(resultatb);

    }catch(Exception e){
       System.out.println(e); 
    }
 }
 public void calcullexamen(){
    try{
       String requetet ="select count(idex),sum(mtex) from  examen where cincand='"+test+"'and typeexamen ='ExamenConduite' and typepermis='"+txtper.getText()+"'";
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
       String ssm = rs.getString("count(idex)");
       txtconduite1.setText(ssm);
       
       if(txtconduite1.getText().length()!=0){
       txtconduite1.setText(ssm);
       }else{
        txtconduite1.setText("0");
       }
       
        String mtc = rs.getString("sum(mtex)");
       txtmtconduite1.setText(mtc);
       
       if(txtmtconduite1.getText().length()!=0){
       txtmtconduite1.setText(mtc);}
       else{
        txtmtconduite1.setText("0");
        
       }
       }
    }catch(Exception e){
        System.out.println(e);
    }
     try{
       String requetet ="select count(idex),sum(mtex) from  examen where cincand='"+test+"'and typeexamen ='ExamenCode' and typepermis='"+txtper.getText()+"'";
        ps = conn.prepareStatement(requetet);
       rs = ps.executeQuery();
       if (rs.next()) {
       String smc = rs.getString("count(idex)");
       txtcodeh1.setText(smc);
       if(txtcodeh1.getText().length()!=0){
      txtcodeh1.setText(smc);
       }else  {
       txtcodeh1.setText("0");  
    }
        String mco = rs.getString("sum(mtex)");
       txtcodeprix1.setText(mco);
       if(txtcodeprix1.getText().length()!=0){
       txtcodeprix1.setText(mco);
       }else  {
       txtcodeprix1.setText("0");
       }
       }
    }catch(Exception e){
        System.out.println(e);
    }
    try{
       String tb= txtconduite1.getText();
       String tbs= txtcodeh1.getText();
        int d1 = Integer.parseInt(tb);
            int d2 = Integer.parseInt(tbs);
            
            int r = (d1 + d2);
            String resultat = String.valueOf(r);
            txttotalh1.setText(resultat);
    }catch(Exception e){
       System.out.println(e); 
    }
    
      try{
       String tb2= txtmtconduite1.getText();
       String tbs2= txtcodeprix1.getText();

        int d1 = Integer.parseInt(tb2);
        int d2 = Integer.parseInt(tbs2);
 
            int r = (d1 + d2);

            String resultat = String.valueOf(r);

            txttotalpri1.setText(resultat);

    }catch(Exception e){
       System.out.println(e); 
    }
    


    }

   

  public void Affichage() {
        try {
            String requete = "select cin as 'CIN' ,nomc as 'Nom' ,prenomc as 'Prenom',gsm as 'GSM' from candidat_table ";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            Table2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
  public void Affichageregelement() {
        try {
            String requete = "select idreg as 'Id' ,cinct as 'CIN_Candidat' ,datereg as 'Date_regelement' , mtreg as 'Montant',mode as 'Mode_Reg' ,numche as 'Num_Cheque' from regelement ";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
//        
    }
public void contratconduite(){
 

    
        try{
            String requete ="select * from contrat where cinctr = '" + test + "' and typectr ='Conduite' and catpermis='"+txtper.getText()+"' and etat='Actif'";
            ps = conn.prepareStatement(requete);
           
            rs = ps.executeQuery();
        if(rs.next()){
             this.nbrh = rs.getString("nbrheure");
             this.datfin = rs.getString("datfinctr");
             this.mont = rs.getString("montantctr");
             this.catp = rs.getString("catpermis");
//                System.out.println(nbrh);
//                      JOptionPane.showMessageDialog(null,nbrh);
          System.out.println("Conduite" ) ;  
           ImageIcon img = new ImageIcon(getClass().getResource("conduite.png"));
       cconduite.setIcon(img); 
               ImageIcon img02 = new ImageIcon(getClass().getResource("etat0.png"));
       nncontart.setIcon(img02);
                      ImageIcon img020 = new ImageIcon(getClass().getResource("etat0.png"));
       nncontart.setIcon(img020);  
       
                        
        }   
           
       
 
       

             
        }catch(Exception e){
            System.out.println("--> Exception : " + e) ;
           
        }
}
public void contratcode(){
    
  
        try{
              String requete ="select * from contrat where cinctr = '" + test + "' and typectr ='Code' and catpermis='"+txtper.getText()+"' and etat='Actif'";
            ps = conn.prepareStatement(requete);
           
            rs = ps.executeQuery();
        if(rs.next()){
            this.nbrh2 = rs.getString("nbrheure");
             this.datfin2= rs.getString("datfinctr");
             this.mont2 = rs.getString("montantctr");
             this.catp2 = rs.getString("catpermis");
//                System.out.println(nbrh2);
//                      JOptionPane.showMessageDialog(null,nbrh);
          System.out.println("code" ) ;  
           ImageIcon img = new ImageIcon(getClass().getResource("code.png"));
       ccode.setIcon(img); 
               ImageIcon img02 = new ImageIcon(getClass().getResource("etat0.png"));
       nncontart.setIcon(img02);
                  ImageIcon img020 = new ImageIcon(getClass().getResource("etat0.png"));
       nncontart.setIcon(img020);
       
        }   
         
 
            
        }catch(Exception e){
            System.out.println("--> Exception : " + e) ;
           
        }
}
public void nncontrat(){
    String requete ="select * from contrat where cinctr = '" + test + "' and typectr ='Code' and typectr ='Conduite' and catpermis='"+txtper.getText()+"' and etat='Actif' ";
        try{
            
            ps = conn.prepareStatement(requete);
           
            rs = ps.executeQuery();
        if(rs.next()){
              ImageIcon img02 = new ImageIcon(getClass().getResource("etat0.png"));
       nncontart.setIcon(img02);
          
                        
        } else{
            System.out.println("nncontrat" ) ;
           ImageIcon img = new ImageIcon(getClass().getResource("nncontart.png"));
       nncontart.setIcon(img);
     
        }  
             
          
        }catch(Exception e){
            System.out.println("--> Exception : " + e) ;
           
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

        nncontart = new javax.swing.JLabel();
        ccode = new javax.swing.JLabel();
        cconduite = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtprenom = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtcin = new javax.swing.JLabel();
        txtage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txttotalh1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtcodeh1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        prix3 = new javax.swing.JLabel();
        txttotalpri1 = new javax.swing.JTextField();
        txtcodeprix1 = new javax.swing.JTextField();
        txtmtconduite1 = new javax.swing.JTextField();
        code1 = new javax.swing.JLabel();
        prix4 = new javax.swing.JLabel();
        txtconduite1 = new javax.swing.JTextField();
        dt4 = new javax.swing.JLabel();
        dt5 = new javax.swing.JLabel();
        dt6 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        txtconduite2 = new javax.swing.JTextField();
        prix1 = new javax.swing.JLabel();
        txtmtconduite2 = new javax.swing.JTextField();
        dt1 = new javax.swing.JLabel();
        dt2 = new javax.swing.JLabel();
        prix2 = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        txtcodeh2 = new javax.swing.JTextField();
        txtcodeprix2 = new javax.swing.JTextField();
        dt3 = new javax.swing.JLabel();
        txttotalpri2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txttotalh2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        totalcandidat = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtreg = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dt7 = new javax.swing.JLabel();
        dt8 = new javax.swing.JLabel();
        dt9 = new javax.swing.JLabel();
        resteapayer = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtper = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtrechercher1 = new javax.swing.JTextField();
        txtbackground1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable(){
            public boolean isCellEditable(int d , int c){
                return false;

            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable(){
            public boolean isCellEditable(int d , int c){
                return false;

            }
        };
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBorder(null);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        nncontart.setToolTipText("Pas du Contrat");
        nncontart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(nncontart);
        nncontart.setBounds(820, 6, 40, 40);

        ccode.setToolTipText("Contrat du code de la route");
        ccode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ccode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ccodeMouseClicked(evt);
            }
        });
        getContentPane().add(ccode);
        ccode.setBounds(880, 6, 40, 40);

        cconduite.setToolTipText("Contrat du Conduite");
        cconduite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cconduite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cconduiteMouseClicked(evt);
            }
        });
        getContentPane().add(cconduite);
        cconduite.setBounds(940, 6, 40, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/images/finance.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1366, 53);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Informations :"));
        jPanel1.setForeground(new java.awt.Color(0, 0, 204));

        jLabel3.setText("Nom  :");

        txtprenom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtprenom.setForeground(new java.awt.Color(0, 0, 153));

        jLabel5.setText("Prenom  :");

        txtnom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnom.setForeground(new java.awt.Color(0, 0, 153));

        jLabel1.setText("Cin :");

        txtcin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcin.setForeground(new java.awt.Color(0, 0, 153));

        txtage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtage.setForeground(new java.awt.Color(0, 0, 153));

        jLabel6.setText("Age  :");

        txttotalh1.setEditable(false);
        txttotalh1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotalh1.setForeground(new java.awt.Color(51, 153, 0));
        txttotalh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalh1ActionPerformed(evt);
            }
        });

        jLabel24.setText("Nombre d'examen Pratique :");

        txtcodeh1.setEditable(false);
        txtcodeh1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcodeh1.setForeground(new java.awt.Color(0, 0, 153));
        txtcodeh1.setBorder(null);
        txtcodeh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeh1ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel29.setText("Examen Total :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel30.setText("Total :");

        prix3.setText("Prix :");

        txttotalpri1.setEditable(false);
        txttotalpri1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotalpri1.setForeground(new java.awt.Color(51, 153, 0));
        txttotalpri1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalpri1ActionPerformed(evt);
            }
        });

        txtcodeprix1.setEditable(false);
        txtcodeprix1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcodeprix1.setForeground(new java.awt.Color(0, 0, 153));
        txtcodeprix1.setBorder(null);

        txtmtconduite1.setEditable(false);
        txtmtconduite1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtmtconduite1.setForeground(new java.awt.Color(0, 0, 153));
        txtmtconduite1.setBorder(null);

        code1.setText("Nombre d'examen Theorique :");

        prix4.setText("Prix :");

        txtconduite1.setEditable(false);
        txtconduite1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtconduite1.setForeground(new java.awt.Color(0, 0, 153));
        txtconduite1.setBorder(null);
        txtconduite1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconduite1ActionPerformed(evt);
            }
        });

        dt4.setText("DT");

        dt5.setText("DT");

        dt6.setText("DT");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(code1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtconduite1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(txttotalh1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcodeh1)))
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txttotalpri1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dt6))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(prix4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                        .addComponent(txtcodeprix1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dt5))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(prix3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtmtconduite1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dt4)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtconduite1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prix3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmtconduite1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dt4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(code1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcodeh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prix4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcodeprix1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dt5))
                                .addGap(0, 11, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txttotalh1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel30)
                                .addComponent(txttotalpri1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dt6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel23.setText("Nombre d'heure de Conduite :");

        txtconduite2.setEditable(false);
        txtconduite2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtconduite2.setForeground(new java.awt.Color(0, 0, 153));
        txtconduite2.setBorder(null);
        txtconduite2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconduite2ActionPerformed(evt);
            }
        });

        prix1.setText("Prix :");

        txtmtconduite2.setEditable(false);
        txtmtconduite2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtmtconduite2.setForeground(new java.awt.Color(0, 0, 153));
        txtmtconduite2.setBorder(null);

        dt1.setText("DT");

        dt2.setText("DT");

        prix2.setText("Prix :");

        code.setText("Nombre d'heure de Code :");

        txtcodeh2.setEditable(false);
        txtcodeh2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcodeh2.setForeground(new java.awt.Color(0, 0, 153));
        txtcodeh2.setBorder(null);
        txtcodeh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeh2ActionPerformed(evt);
            }
        });

        txtcodeprix2.setEditable(false);
        txtcodeprix2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcodeprix2.setForeground(new java.awt.Color(0, 0, 153));
        txtcodeprix2.setBorder(null);

        dt3.setText("DT");

        txttotalpri2.setEditable(false);
        txttotalpri2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotalpri2.setForeground(new java.awt.Color(51, 153, 0));
        txttotalpri2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalpri2ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel28.setText("Total :");

        txttotalh2.setEditable(false);
        txttotalh2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotalh2.setForeground(new java.awt.Color(51, 153, 0));
        txttotalh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalh2ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel27.setText("Heures  Total :");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setText("Montant total :");

        jLabel9.setText("Montant déja payer :");

        dt7.setText("DT");

        dt8.setText("DT");

        dt9.setText("DT");

        jLabel10.setText("Reste :");

        txtper.setForeground(new java.awt.Color(0, 0, 153));
        txtper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtperActionPerformed(evt);
            }
        });
        txtper.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtperKeyReleased(evt);
            }
        });

        jLabel15.setText("Type Permis :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtcin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtprenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtper, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(code))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttotalh2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(txtcodeh2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtconduite2))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(prix1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(prix2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmtconduite2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcodeprix2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttotalpri2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtreg)
                                    .addComponent(totalcandidat)
                                    .addComponent(resteapayer, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dt3)
                            .addComponent(dt2)
                            .addComponent(dt1)
                            .addComponent(dt7)
                            .addComponent(dt8)
                            .addComponent(dt9))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtconduite2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prix1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmtconduite2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dt1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtcodeh2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(prix2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcodeprix2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txttotalpri2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dt3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txttotalh2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGap(3, 3, 3))))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8)))
                            .addComponent(dt2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalcandidat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(dt7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(dt8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dt9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resteapayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(txtprenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(310, 90, 680, 300);

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
        txtrechercher1.setBounds(44, 68, 212, 14);

        txtbackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/autoplus/frame/txt2.png"))); // NOI18N
        getContentPane().add(txtbackground1);
        txtbackground1.setBounds(40, 60, 220, 30);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)), "Réglement :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 10))); // NOI18N

        Table1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Table1.setModel(new javax.swing.table.DefaultTableModel(
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
        Table1.setRowHeight(20);
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Table1MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Table1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 450, 990, 170);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

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
        Table2.setRowHeight(20);
        Table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Table2MouseEntered(evt);
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
        jScrollPane2.setViewportView(Table2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 90, 300, 350);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(1030, 250, 360, 163);

        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(1000, 10, 40, 40);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)), "Action :"));

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(310, 396, 190, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtrechercher1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrechercher1MouseClicked
        Affichage();
        clear();
//        btnmodifier.setEnabled(false);
//        modifierbtn.setEnabled(false);
//        image.setIcon(null);
        ImageIcon img2 = new ImageIcon(getClass().getResource("txt1.png"));
        txtbackground1.setIcon(img2);
        txtrechercher1.setText("");
//        ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
//        txtbachground.setIcon(img);
//        txtrechercher.setText("Taper Cin Candidat");

//        ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
//        image.setIcon(img202);

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
            String requete = "select cin as 'CIN' ,nomc as 'Nom' ,prenomc as 'Prenom' ,gsm as 'GSM' from  candidat_table where nomc LIKE ?";
            ps = conn.prepareStatement(requete);
            ps.setString(1, "%"+txtrechercher1.getText()+"%");
            rs = ps.executeQuery();
            Table2.setModel(DbUtils.resultSetToTableModel(rs));
//            byte[] imagedata =rs.getBytes("image");
//            Format = new ImageIcon(imagedata);
//            image.setIcon(Format);
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_txtrechercher1KeyReleased

    private void txtrechercher1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrechercher1KeyTyped
        clear();
//        btnmodifier.setEnabled(false);
//        modifierbtn.setEnabled(false);
//        image.setIcon(null);         // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercher1KeyTyped

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
// Affichage();
//        clear();
//        btnmodifier.setEnabled(false);
//        modifierbtn.setEnabled(false);
//        image.setIcon(null);
//        txtrechercher.setText("");
//        ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
//        txtbachground.setIcon(img);
//        txtrechercher.setText("Taper Cin Candidat");
        ImageIcon img2 = new ImageIcon(getClass().getResource("txt2.png"));
        txtbackground1.setIcon(img2);
       txtrechercher1.setText("Taper Nom Candidat");        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        //        Deplace();

    }//GEN-LAST:event_Table1MouseClicked

    private void Table1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseEntered
        //Affichage();
    }//GEN-LAST:event_Table1MouseEntered

    private void Table1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseReleased
//        btnmodifier.setEnabled(true);
//        modifierbtn.setEnabled(true);
        
//        ImageIcon img = new ImageIcon(getClass().getResource("txt2.png"));
//        txtbachground.setIcon(img);
//        txtrechercher.setText("Taper Cin Candidat");
        ImageIcon img2 = new ImageIcon(getClass().getResource("txt2.png"));
        txtbackground1.setIcon(img2);
        txtrechercher1.setText("Taper Nom Candidat");
    }//GEN-LAST:event_Table1MouseReleased

    private void Table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Table2MouseClicked

    private void Table2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Table2MouseEntered

    private void Table2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table2MouseReleased
totalcandidat.setText("");      
Deplace(); 
ImageIcon img2 = new ImageIcon(getClass().getResource("txt2.png"));
        txtbackground1.setIcon(img2);
       txtrechercher1.setText("Taper Nom Candidat"); 
       
             ImageIcon img01 = new ImageIcon(getClass().getResource("etat0.png"));
       cconduite.setIcon(img01);
            ImageIcon img0 = new ImageIcon(getClass().getResource("etat0.png"));
       ccode.setIcon(img0);
            ImageIcon img02 = new ImageIcon(getClass().getResource("etat0.png"));
       nncontart.setIcon(img02);
        nncontrat();
       contratconduite();
       contratcode();
    }//GEN-LAST:event_Table2MouseReleased

    private void txttotalh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalh2ActionPerformed

    private void txtcodeh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeh2ActionPerformed

    private void txttotalpri2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalpri2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpri2ActionPerformed

    private void txtconduite2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconduite2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconduite2ActionPerformed

    private void txtconduite1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconduite1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconduite1ActionPerformed

    private void txttotalpri1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalpri1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpri1ActionPerformed

    private void txtcodeh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeh1ActionPerformed

    private void txttotalh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalh1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Ajoutregelement act = new Ajoutregelement();
        act.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
        try {
            int row = Table1.getSelectedRow();
            this.test3 = (Table1.getModel().getValueAt(row, 0).toString());
            if (JOptionPane.showConfirmDialog(null, "attention vous devez suprimer une Seance,est ce que tu es sur?",
                    "Supprimer Seance", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                String requete = "delete from regelement where idreg = '" + test3 + "'";
                ps = conn.prepareStatement(requete);

                ps.execute();

            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de supprimer \n" + e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cconduiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cconduiteMouseClicked
      String info="<html><head></head><body><h3 color='#2C4CCC'><center>Contrat du Conduite</center></h3> <p >Cin :<b><i>"+test+"</i></b></p>"
       + "<br><p>Nom & Prénom :<b><i>"+txtnom.getText()+"</i>  "+txtprenom.getText()+"</b></p>"
        + "<br><p >Nombre D'heures du contrat :<b><i>"+nbrh+"</i></b></p>"
        + "<br><p >Montant du Contrat  :<b><i>"+mont+"Dt</i></b></p>"
        + "<br><p >Catégorie du Permis :<b><i>"+catp+"</i></b></p>"
        + "<br><p >Date Fin du Contrat :<b><i>"+datfin+"</i></b></p><br></body></html>" ;
JOptionPane p =new JOptionPane();
p.setMessage(info);
p.setMessageType(JOptionPane.INFORMATION_MESSAGE);
JDialog d=p.createDialog(null,"Informations sur le contrat");
d.setVisible(true);
    }//GEN-LAST:event_cconduiteMouseClicked

    private void ccodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ccodeMouseClicked
          String info ="<html><head></head><body><h3 color ='#2C4CCC'><center>Contrat du Code de la route</center></h3><p>Cin :<b><i>"+test+"</i></b></p>"
            + "<br><p>Nom & Prénom :<b><i>"+txtnom.getText()+"</i> "+txtprenom.getText()+"</b></p>"
            + "<br><p >Nombre D'heures du contrat :<b><i>"+nbrh2+"</i></b></p>"
        + "<br><p >Montant du Contrat  :<b><i>"+mont2+"Dt</i></b></p>"
        + "<br><p >Catégorie du Permis :<b><i>"+catp2+"</i></b></p>"
        + "<br><p >Date Fin du Contrat :<b><i>"+datfin2+"</i></b></p><br></body></html>";
    JOptionPane p =new JOptionPane();
    p.setMessage(info);
    p.setMessageType(JOptionPane.INFORMATION_MESSAGE);
    JDialog d =p.createDialog(null,"Information sur le contrat ");
    d.setVisible(true);
    }//GEN-LAST:event_ccodeMouseClicked

    private void Table2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table2KeyReleased
         if((evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
              ImageIcon img01 = new ImageIcon(getClass().getResource("etat0.png"));
       cconduite.setIcon(img01);
            ImageIcon img0 = new ImageIcon(getClass().getResource("etat0.png"));
       ccode.setIcon(img0);
            ImageIcon img02 = new ImageIcon(getClass().getResource("etat0.png"));
       nncontart.setIcon(img02);
            Deplace(); 
            nncontrat();
       contratconduite();
       contratcode();
        }
    }//GEN-LAST:event_Table2KeyReleased

    private void txtperKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtperKeyReleased
        if((evt.getKeyCode()==KeyEvent.VK_ENTER)){
              calculseance();
      calcullexamen();
      calcultotal();
       calcultotalregelement();
      claculreste();
        }
    }//GEN-LAST:event_txtperKeyReleased

    private void txtperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtperActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JTable Table2;
    private javax.swing.JLabel ccode;
    private javax.swing.JLabel cconduite;
    private javax.swing.JLabel code;
    private javax.swing.JLabel code1;
    private javax.swing.JLabel dt1;
    private javax.swing.JLabel dt2;
    private javax.swing.JLabel dt3;
    private javax.swing.JLabel dt4;
    private javax.swing.JLabel dt5;
    private javax.swing.JLabel dt6;
    private javax.swing.JLabel dt7;
    private javax.swing.JLabel dt8;
    private javax.swing.JLabel dt9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel nncontart;
    private javax.swing.JLabel prix1;
    private javax.swing.JLabel prix2;
    private javax.swing.JLabel prix3;
    private javax.swing.JLabel prix4;
    private javax.swing.JTextField resteapayer;
    private javax.swing.JTextField totalcandidat;
    private javax.swing.JLabel txtage;
    private javax.swing.JLabel txtbackground1;
    private javax.swing.JLabel txtcin;
    private javax.swing.JTextField txtcodeh1;
    private javax.swing.JTextField txtcodeh2;
    private javax.swing.JTextField txtcodeprix1;
    private javax.swing.JTextField txtcodeprix2;
    private javax.swing.JTextField txtconduite1;
    private javax.swing.JTextField txtconduite2;
    private javax.swing.JTextField txtmtconduite1;
    private javax.swing.JTextField txtmtconduite2;
    private javax.swing.JLabel txtnom;
    private javax.swing.JTextField txtper;
    private javax.swing.JLabel txtprenom;
    private javax.swing.JTextField txtrechercher1;
    private javax.swing.JTextField txtreg;
    private javax.swing.JTextField txttotalh1;
    private javax.swing.JTextField txttotalh2;
    private javax.swing.JTextField txttotalpri1;
    private javax.swing.JTextField txttotalpri2;
    // End of variables declaration//GEN-END:variables
}
