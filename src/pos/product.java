/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class product extends javax.swing.JPanel {

    /**
     * Creates new form customer
     */
    public product() {
        initComponents();
        //tb_load();
        supplier_load();
    }

    public void tb_load(){
        
        try{
            DefaultTableModel dt = (DefaultTableModel) pd_table.getModel();
            dt.setRowCount(0);
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM product");
            
            while(rs.next()){
                Vector v = new Vector();
                
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                
                dt.addRow(v);
            
        }
        }catch(Exception e){
            System.out.println(e);
            
        }
    }
    
    public void supplier_load(){
    
        // all supplier load to com_sup combo box
        try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM supplier");
            
            Vector v = new Vector();
            
            while(rs.next()){
                v.add(rs.getString("supplier_Name"));
                DefaultComboBoxModel cm = new DefaultComboBoxModel(v);
                com_sup.setModel(cm);
            }
            
        }catch(Exception e){
            System.out.println(e);
        
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pd_name = new javax.swing.JTextField();
        pd_barcode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pd_cost = new javax.swing.JTextField();
        pd_sid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pd_sell = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pd_qty = new javax.swing.JTextField();
        com_sup = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pd_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pd_src = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pd_search_tbl = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));
        setMinimumSize(new java.awt.Dimension(100, 100));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Name:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Bar Code:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        pd_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pd_name.setText("0");
        pd_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pd_nameActionPerformed(evt);
            }
        });
        jPanel2.add(pd_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 324, -1));

        pd_barcode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pd_barcode.setText("0");
        jPanel2.add(pd_barcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 324, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search x30.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 102, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Qty:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cost Price:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        pd_cost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pd_cost.setText("0");
        jPanel2.add(pd_cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 324, -1));

        pd_sid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pd_sid.setText("0");
        jPanel2.add(pd_sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 324, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Sell Price:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        pd_sell.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pd_sell.setText("0");
        jPanel2.add(pd_sell, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 324, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Supplier ID:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Supplier Name:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        pd_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pd_qty.setText("0");
        jPanel2.add(pd_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 324, -1));

        com_sup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_sup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        com_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_supActionPerformed(evt);
            }
        });
        jPanel2.add(com_sup, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 324, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset.png"))); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 111, -1));

        jLabel4.setText("Created card number:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));
        jPanel2.add(cra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 240, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 610, 440));

        pd_table.setAutoCreateRowSorter(true);
        pd_table.setBackground(new java.awt.Color(153, 255, 153));
        pd_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Bar Code", "Cost Price", "Sell Price", "Qty", "Supplier ID", "Supplier Name", "Cradit"
            }
        ));
        pd_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pd_tableMouseClicked(evt);
            }
        });
        pd_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pd_tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(pd_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 510, 190));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Search ID:");

        pd_src.setBackground(new java.awt.Color(204, 204, 204));
        pd_src.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pd_src.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(pd_src, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pd_src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Search :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, -1));

        pd_search_tbl.setBackground(new java.awt.Color(204, 204, 204));
        pd_search_tbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pd_search_tbl.setText("0");
        pd_search_tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pd_search_tblKeyReleased(evt);
            }
        });
        jPanel1.add(pd_search_tbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 178, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 100, -1, -1));

        jLabel11.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel11.setText("MANAGE PRODUCT");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close-01.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Save Button
        String name=  pd_name.getText();
        String bar_code = pd_barcode.getText();
        String price = pd_cost.getText();
        String sell = pd_sell.getText();
        String qty = pd_qty.getText();
        String sid = pd_sid.getText();
        String sname = com_sup.getSelectedItem().toString(); 
        String crdit = cra.getText();//pd_sname.getText();
        
        try{
            Statement s = db.mycon().createStatement();
            s.executeUpdate(" INSERT INTO product(Product_Name, Bar_code,Price, Sell,Qty,sid, Sname, Cradit_number) VALUES('"+name+"','"+bar_code+"','"+price+"','"+sell+"','"+qty+"', '"+sid+"','"+sname+"','"+crdit+"')");
            JOptionPane.showMessageDialog(null, "Product saved successfully");
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        tb_load();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Search Button
        String search = pd_src.getText();
        
        try{
            Statement s = db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT* FROM product WHERE pid='"+search+"'");
            
            if(rs.next()){
                pd_name.setText(rs.getString("Product_Name"));
                pd_barcode.setText(rs.getString("Bar_code"));
                pd_cost.setText(rs.getString("Price"));
                pd_sell.setText(rs.getString("Sell"));
                pd_qty.setText(rs.getString("Qty"));
                pd_sid.setText(rs.getString("sid"));
                com_sup.setSelectedItem(rs.getString("Sname"));
                cra.setText(rs.getString("Cradit_number"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Update Button
        String pid = pd_src.getText();
        String name= pd_name.getText();
        String bar_code = pd_barcode.getText();
        String price = pd_cost.getText();
        String sell = pd_sell.getText();
        String qty = pd_qty.getText();
        String sid = pd_sid.getText();
        String sname =  com_sup.getSelectedItem().toString(); //pd_sname.getText();
        String crdit = cra.getText();
        
        try{
            Statement s = db.mycon().createStatement();
            s.executeUpdate(" UPDATE product SET Product_Name='"+name+"', Bar_code='"+bar_code+"',Price='"+price+"', Sell='"+sell+"',Qty='"+qty+"',sid='"+sid+"', Sname='"+sname+"',  Cradit_number='"+crdit+"' WHERE pid='"+pid+"'" );
            JOptionPane.showMessageDialog(null, "Product updated successfully");
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        tb_load();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Delete Button
        String pid = pd_src.getText();
        
        try{
            Statement s= db.mycon().createStatement();
            s.executeUpdate(" DELETE FROM product WHERE pid='"+pid+"'");
            JOptionPane.showMessageDialog(null, "Product delete successdully");
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        tb_load();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void pd_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pd_tableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pd_tableKeyPressed

    private void pd_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pd_tableMouseClicked
        // TODO add your handling code here:
        int r = pd_table.getSelectedRow();
        
        String id = pd_table.getValueAt(r, 0).toString();
        String name = pd_table.getValueAt(r, 1).toString();
        String bar_code = pd_table.getValueAt(r, 2).toString();
        String price = pd_table.getValueAt(r, 3).toString();
        String sell = pd_table.getValueAt(r, 4).toString();
        String qty = pd_table.getValueAt(r, 5).toString();
        String sid = pd_table.getValueAt(r, 6).toString();
        String sname = pd_table.getValueAt(r, 7).toString();
        String crdit = pd_table.getValueAt(r, 8).toString();
        
        pd_src.setText(id);
        pd_name.setText(name);
        pd_barcode.setText(bar_code);
        pd_cost.setText(price);
        pd_sell.setText(sell);
        pd_qty.setText(qty);
        pd_sid.setText(sid);
        com_sup.setSelectedItem(sname); //pd_sname.setText(sname);
        cra.setText(crdit);
    }//GEN-LAST:event_pd_tableMouseClicked

    private void pd_search_tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pd_search_tblKeyReleased
        // TODO add your handling code here:
        String name = pd_search_tbl.getText();
        try{
            DefaultTableModel dt = (DefaultTableModel) pd_table.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT * FROM product WHERE Product_Name LIKE '%"+name+"%'");
            
            while(rs.next()){
                Vector v = new Vector();
                
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                
                
                dt.addRow(v);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_pd_search_tblKeyReleased

    private void com_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_supActionPerformed
        // TODO add your handling code here:
        try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM supplier where supplier_Name='"+com_sup.getSelectedItem().toString()+"'");
            if(rs.next()){
                pd_sid.setText(rs.getString("sid"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_com_supActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Reset Button
        pd_src.setText(null);
        pd_name.setText(null);
        pd_barcode.setText(null);
        pd_cost.setText(null);
        pd_sell.setText(null);
        pd_qty.setText(null);
        pd_sid.setText(null);
        cra.setText(null);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Table search button clear
        pd_search_tbl.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TAble refresh
        tb_load();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void pd_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pd_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pd_nameActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox com_sup;
    private javax.swing.JTextField cra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pd_barcode;
    private javax.swing.JTextField pd_cost;
    private javax.swing.JTextField pd_name;
    private javax.swing.JTextField pd_qty;
    private javax.swing.JTextField pd_search_tbl;
    private javax.swing.JTextField pd_sell;
    private javax.swing.JTextField pd_sid;
    private javax.swing.JTextField pd_src;
    private javax.swing.JTable pd_table;
    // End of variables declaration//GEN-END:variables
}
