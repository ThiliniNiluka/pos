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
public class sup extends javax.swing.JPanel {

    /**
     * Creates new form sup
     */
    public sup() {
        initComponents();
         //tb_load();
    }

    public void tb_load(){
        
        try{
            DefaultTableModel dt = (DefaultTableModel) sup_table.getModel();
            dt.setRowCount(0);
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM supplier");
            
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sup_search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        sup_name = new javax.swing.JTextField();
        sup_tp = new javax.swing.JTextField();
        sup_ad = new javax.swing.JTextField();
        sup_per = new javax.swing.JTextField();
        sup_mob = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sup_table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        sup_search_tbl = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Search ID :");

        sup_search.setBackground(new java.awt.Color(204, 204, 204));
        sup_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sup_search.setText("0");
        sup_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sup_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(sup_search, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sup_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 490, 60));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 53, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("T.P. Number :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 94, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Address :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 135, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Conatct Person :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 181, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Mobile :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 235, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 106, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search x30.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 113, -1));

        sup_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sup_name.setText("0");
        jPanel2.add(sup_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 50, 307, -1));

        sup_tp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sup_tp.setText("0");
        jPanel2.add(sup_tp, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 91, 307, -1));

        sup_ad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sup_ad.setText("0");
        jPanel2.add(sup_ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 132, 307, -1));

        sup_per.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sup_per.setText("0");
        jPanel2.add(sup_per, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 178, 305, -1));

        sup_mob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sup_mob.setText("0");
        jPanel2.add(sup_mob, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 224, 305, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset.png"))); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 110, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 620, 330));

        sup_table.setBackground(new java.awt.Color(153, 255, 153));
        sup_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "T.P Number", "Address", "Contact Person", "Mobile"
            }
        ));
        sup_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sup_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sup_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 510, 250));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Search");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        sup_search_tbl.setBackground(new java.awt.Color(204, 204, 204));
        sup_search_tbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sup_search_tbl.setText("0");
        sup_search_tbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sup_search_tblActionPerformed(evt);
            }
        });
        sup_search_tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sup_search_tblKeyReleased(evt);
            }
        });
        add(sup_search_tbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 162, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 140, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setText("MANAGE SUPPLIER");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close-01.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void sup_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sup_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sup_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // Save Button
        String name = sup_name.getText();
        String tp = sup_tp.getText();
        String address = sup_ad.getText();
        String con_per =  sup_per.getText();
        String mob = sup_mob.getText();
        
        try{
            Statement s = db.mycon().createStatement();
            s.executeUpdate(" INSERT INTO supplier(supplier_Name, Tp_Number, Address, Contact_person, Mobile) VALUES('"+name+"', '"+tp+"', '"+address+"', '"+con_per+"', '"+mob+"')");
            JOptionPane.showMessageDialog(null, "Supplier saved successfully");
            
        }catch(Exception e){
            System.out.println(e);
        }
        tb_load();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Search Button
        String search = sup_search.getText();
        
        try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM supplier WHERE sid='"+search+"'");
            
            if(rs.next()){
                sup_name.setText(rs.getString("supplier_Name"));
                sup_tp.setText(rs.getString("Tp_Number"));
                sup_ad.setText(rs.getString("Address"));
                sup_per.setText(rs.getString("Contact_person"));
                sup_mob.setText(rs.getString("Mobile"));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String name = sup_name.getText();
        String tp = sup_tp.getText();
        String id = sup_search.getText();
        String address = sup_ad.getText();
        String con_per =  sup_per.getText();
        String mob = sup_mob.getText();
        
        try{
            
            Statement s = db.mycon().createStatement();
            s.executeUpdate(" UPDATE supplier SET supplier_Name='"+name+"', Tp_Number='"+tp+"', Address='"+address+"', Contact_person='"+con_per+"', Mobile='"+mob+"' WHERE sid='"+id+"' ");
            JOptionPane.showMessageDialog(null, "Supplier updated successfully");
            
        }catch(Exception e){
            System.out.println(e);
        }
        tb_load();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Delete Button
        String id = sup_search.getText();
        
        try{
            Statement s = db.mycon().createStatement();
            s.executeUpdate(" DELETE FROM supplier WHERE sid='"+id+"'");
            JOptionPane.showMessageDialog(null, "Supplier delete successfully");
            
        }catch(Exception e){
            System.out.println(e);
        }
        tb_load();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void sup_search_tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sup_search_tblKeyReleased
        // TODO add your handling code here:
        String name = sup_search_tbl.getText();
        try{
            DefaultTableModel dt = (DefaultTableModel) sup_table.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM supplier WHERE supplier_Name LIKE '%"+name+"%'");
            
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
            tb_load();
            System.out.println(e);
           
        }
    }//GEN-LAST:event_sup_search_tblKeyReleased

    private void sup_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sup_tableMouseClicked
        // TODO add your handling code here:
        int r =sup_table.getSelectedRow();
        
        String id = sup_table.getValueAt(r, 0).toString();
        String name = sup_table.getValueAt(r, 1).toString();
        String tp = sup_table.getValueAt(r, 2).toString();
        String address = sup_table.getValueAt(r, 3).toString();
        String con_per = sup_table.getValueAt(r, 4).toString();
        String mob = sup_table.getValueAt(r, 5).toString();
        
        sup_search.setText(id);
        sup_name.setText(name);
        sup_tp.setText(tp);
        sup_ad.setText(address);
        sup_per.setText(con_per);
        sup_mob.setText(mob);
    }//GEN-LAST:event_sup_tableMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Reset button
        sup_search.setText(null);
        sup_name.setText(null);
        sup_tp.setText(null);
        sup_ad.setText(null);
        sup_per.setText(null);
        sup_mob.setText(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TAble Refresh
        tb_load();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Table clear button
        sup_search_tbl.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void sup_search_tblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sup_search_tblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sup_search_tblActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sup_ad;
    private javax.swing.JTextField sup_mob;
    private javax.swing.JTextField sup_name;
    private javax.swing.JTextField sup_per;
    private javax.swing.JTextField sup_search;
    private javax.swing.JTextField sup_search_tbl;
    private javax.swing.JTable sup_table;
    private javax.swing.JTextField sup_tp;
    // End of variables declaration//GEN-END:variables
}
