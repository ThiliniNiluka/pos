/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class stock extends javax.swing.JPanel {
    
//    Connection con = null;
//    PreparedStatement pst = null;
//    ResultSet rs = null;

    /**
     * Creates new form stock
     */
    public stock() {
        initComponents();
        //tbload();
    }

    public void tbload(){
        
        try{
            
            DefaultTableModel dt = (DefaultTableModel) stock_table.getModel();
            dt.setRowCount(0);
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM product");
            
            while(rs.next()){
            Vector v = new Vector();
            
            v.add(rs.getString(1));
            v.add(rs.getString(2));
            v.add(rs.getString(3));
            v.add(rs.getString(4));
            v.add(rs.getString(6));
            v.add(rs.getString(7));
            v.add(rs.getString(8));
            
            dt.addRow(v);
            
        }
            
        }catch(Exception e){
            
        }
    }
    
    public void paras(){
            // table serach
            String bname = txt_bname.getText();
            String pname = txt_pname.getText();
            String sid = txt_sid.getText();
            
            try{
            DefaultTableModel dt = (DefaultTableModel) stock_table.getModel();
            dt.setRowCount(0);
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM product WHERE Bar_code LIKE '%"+bname+"%' AND Product_Name LIKE '%"+pname+"%' AND Sid LIKE '%"+sid+"%'");
            
            while(rs.next()){
                 Vector v = new Vector();
                
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                
                dt.addRow(v);
               
            }
        }catch(Exception e){
            System.out.println(e);
            tbload();
        }
    }     
//            String bname = txt_bname.getText();
//            String pname = txt_pname.getText();
//            String sid = txt_sid.getText();
//            
//            try{
//                String sql = "Select * from product where Bar_code LIKE '%"+bname+"%' And Product_Name LIKE '%"+pname+"%' and Sid LIKE '%"+sid+"%'";
//                
//                pst = con.prepareStatement(sql);
//                rs = pst.executeQuery();
//                stock_table.setModel(DbUtils.resultSetToTableModel(rs));
//                
//            }catch (Exception e){
//                System.out.println(e);
//                tbload();
//            }
//            
//        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        stock_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_bname = new javax.swing.JTextField();
        txt_sid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_pname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stock_table.setAutoCreateRowSorter(true);
        stock_table.setBackground(new java.awt.Color(153, 255, 153));
        stock_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Product Name", "Bar Code", "Cost Price", "Stock Qty", "Supplier ID", "Supplier Name"
            }
        ));
        stock_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stock_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(stock_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 1140, 240));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_bname.setBackground(new java.awt.Color(204, 204, 204));
        txt_bname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_bname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bnameActionPerformed(evt);
            }
        });
        txt_bname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_bnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_bnameKeyTyped(evt);
            }
        });

        txt_sid.setBackground(new java.awt.Color(204, 204, 204));
        txt_sid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_sid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sidActionPerformed(evt);
            }
        });
        txt_sid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_sidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sidKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Bar code :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Supplier ID :");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Product Name :");

        txt_pname.setBackground(new java.awt.Color(204, 204, 204));
        txt_pname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pnameActionPerformed(evt);
            }
        });
        txt_pname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pnameKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ID");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_bname, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pname, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_sid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(199, 199, 199)
                .addComponent(jButton1)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jButton2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_bname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1140, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close-01.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 20, 46, -1));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setText("MANAGE STOCK");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bnameKeyPressed
        // TODO add your handling code here:
        //paras();
    }//GEN-LAST:event_txt_bnameKeyPressed

    private void txt_sidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sidKeyPressed
        // TODO add your handling code here:
        //paras();
    }//GEN-LAST:event_txt_sidKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tbload();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_pnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pnameKeyPressed
        // TODO add your handling code here:
        //paras();
    }//GEN-LAST:event_txt_pnameKeyPressed

    private void txt_sidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sidActionPerformed
        // TODO add your handling code here:
        //paras();
    }//GEN-LAST:event_txt_sidActionPerformed

    private void txt_pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pnameActionPerformed
        // TODO add your handling code here:
        //paras();
    }//GEN-LAST:event_txt_pnameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // clear
        txt_bname.setText(null);
        txt_pname.setText(null);
        txt_sid.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_bnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bnameActionPerformed
        // TODO add your handling code here:
        //paras();
    }//GEN-LAST:event_txt_bnameActionPerformed

    private void txt_bnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bnameKeyTyped
        // TODO add your handling code here:
        //paras();
    }//GEN-LAST:event_txt_bnameKeyTyped

    private void txt_bnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bnameKeyReleased
        // TODO add your handling code here:
        paras();
    }//GEN-LAST:event_txt_bnameKeyReleased

    private void txt_pnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pnameKeyReleased
        // TODO add your handling code here:
        paras();
    }//GEN-LAST:event_txt_pnameKeyReleased

    private void txt_sidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sidKeyReleased
        // TODO add your handling code here:
        paras();
    }//GEN-LAST:event_txt_sidKeyReleased

    private void stock_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stock_tableMouseClicked
        // TODO add your handling code here:
        int r =stock_table.getSelectedRow();
        
        String bname = stock_table.getValueAt(r, 2).toString();
        String pname = stock_table.getValueAt(r, 1).toString();
        String sid = stock_table.getValueAt(r, 5).toString();
        
        txt_bname.setText(bname);
        txt_pname.setText(pname);
        txt_sid.setText(sid);
    }//GEN-LAST:event_stock_tableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stock_table;
    private javax.swing.JTextField txt_bname;
    private javax.swing.JTextField txt_pname;
    private javax.swing.JTextField txt_sid;
    // End of variables declaration//GEN-END:variables
}
