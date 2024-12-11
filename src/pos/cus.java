/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class cus extends javax.swing.JPanel {

    /**
     * Creates new form cus
     */
    public cus() {
        initComponents();
        //tb_load();
    }

    public void tb_load(){
        
        try{
            DefaultTableModel dt = (DefaultTableModel) cus_table.getModel();
            dt.setRowCount(0);
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM customer");
            
            while(rs.next()){
                Vector v = new Vector();
                
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                
                
                dt.addRow(v);
            
        }
        }catch(Exception e){
            System.out.println(e);
           
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cus_name = new javax.swing.JTextField();
        cus_tp = new javax.swing.JTextField();
        cus_ad = new javax.swing.JTextField();
        cus_per = new javax.swing.JTextField();
        cus_mob = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cus_table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cus_search_tbl = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cus_search = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(153, 153, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Name :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Address :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 70, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Contact Person :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Mobile :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("T.P Number :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        cus_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cus_name.setText("0");
        jPanel2.add(cus_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 330, -1));

        cus_tp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cus_tp.setText("0");
        jPanel2.add(cus_tp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 330, -1));

        cus_ad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cus_ad.setText("0");
        jPanel2.add(cus_ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 330, -1));

        cus_per.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cus_per.setText("0");
        jPanel2.add(cus_per, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 330, -1));

        cus_mob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cus_mob.setText("0");
        jPanel2.add(cus_mob, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 330, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 111, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search x30.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 111, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset.png"))); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 100, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 630, 340));

        cus_table.setBackground(new java.awt.Color(153, 255, 153));
        cus_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "T.P Number", "Address", "Contact Person", "Mobile"
            }
        ));
        cus_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cus_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cus_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 500, 210));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Search");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 50, -1));

        cus_search_tbl.setBackground(new java.awt.Color(204, 204, 204));
        cus_search_tbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cus_search_tbl.setText("0");
        cus_search_tbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cus_search_tblActionPerformed(evt);
            }
        });
        cus_search_tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cus_search_tblKeyReleased(evt);
            }
        });
        add(cus_search_tbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 180, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 90, -1, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close-01.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 50, 40));

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel6.setText("MANAGE CUSTOMER");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Search ID :");

        cus_search.setBackground(new java.awt.Color(204, 204, 204));
        cus_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cus_search.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(cus_search, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cus_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 520, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Save Button
        String name = cus_name.getText();
        String tp = cus_tp.getText();
        String address = cus_ad.getText();
        String con_per =  cus_per.getText();
        String mob = cus_mob.getText();
        
        try{
            Statement s = db.mycon().createStatement();
            s.executeUpdate(" INSERT INTO customer(customer_name, Tp_Number, Address, Contact_Person, Mobile) VALUES('"+name+"', '"+tp+"', '"+address+"', '"+con_per+"', '"+mob+"')");
            JOptionPane.showMessageDialog(null, "customer saved successfully");
            
        }catch(Exception e){
            System.out.println(e);
        }
        tb_load();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Search Button
        String search = cus_search.getText();
        
        try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM customer WHERE cid='"+search+"'");
            
            if(rs.next()){
                cus_name.setText(rs.getString("customer_name"));
                cus_tp.setText(rs.getString("Tp_Number"));
                cus_ad.setText(rs.getString("Address"));
                cus_per.setText(rs.getString("Contact_Person"));
                cus_mob.setText(rs.getString("Mobile"));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         // Update Button
        String name = cus_name.getText();
        String tp = cus_tp.getText();
        String id = cus_search.getText();
        String address = cus_ad.getText();
        String con_per =  cus_per.getText();
        String mob = cus_mob.getText();
        
        try{
            
            Statement s = db.mycon().createStatement();
            s.executeUpdate(" UPDATE customer SET customer_name='"+name+"', Tp_Number='"+tp+"', Address='"+address+"',  Contact_Person='"+con_per+"', Mobile='"+mob+"' WHERE cid='"+id+"' ");
            JOptionPane.showMessageDialog(null, "Customer updated successfully");
            
        }catch(Exception e){
            System.out.println(e);
        }
        tb_load();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Delete Button
        String id = cus_search.getText();
        
        try{
            Statement s = db.mycon().createStatement();
            s.executeUpdate(" DELETE FROM customer WHERE cid='"+id+"'");
            JOptionPane.showMessageDialog(null, "customer delete successfully");
            
        }catch(Exception e){
            System.out.println(e);
        }
        tb_load();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cus_search_tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cus_search_tblKeyReleased
        String name = cus_search_tbl.getText();
        try{
            DefaultTableModel dt = (DefaultTableModel) cus_table.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM customer WHERE customer_name LIKE '%"+name+"%'");
            
            while(rs.next()){
                Vector v = new Vector();
                
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                
                dt.addRow(v);
            }
        }catch(Exception e){
            System.out.println(e);
             tb_load();
            
            }
        
    }//GEN-LAST:event_cus_search_tblKeyReleased

    private void cus_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cus_tableMouseClicked
        // TODO add your handling code here:
        int r =cus_table.getSelectedRow();
        
        String id = cus_table.getValueAt(r, 0).toString();
        String name = cus_table.getValueAt(r, 1).toString();
        String tp = cus_table.getValueAt(r, 2).toString();
        String address = cus_table.getValueAt(r, 3).toString();
        String con_per = cus_table.getValueAt(r, 4).toString();
        String mob = cus_table.getValueAt(r, 5).toString();
        
        cus_search.setText(id);
        cus_name.setText(name);
        cus_tp.setText(tp);
        cus_ad.setText(address);
        cus_per.setText(con_per);
        cus_mob.setText(mob);
    }//GEN-LAST:event_cus_tableMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Clear Button
        cus_search.setText(null);
        cus_name.setText(null);
        cus_tp.setText(null);
        cus_ad.setText(null);
        cus_per.setText(null);
        cus_mob.setText(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Clear button table
        cus_search_tbl.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Table refresh
        tb_load();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cus_search_tblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cus_search_tblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cus_search_tblActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cus_ad;
    private javax.swing.JTextField cus_mob;
    private javax.swing.JTextField cus_name;
    private javax.swing.JTextField cus_per;
    private javax.swing.JTextField cus_search;
    private javax.swing.JTextField cus_search_tbl;
    private javax.swing.JTable cus_table;
    private javax.swing.JTextField cus_tp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
