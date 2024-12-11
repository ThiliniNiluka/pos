/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos;

import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class print extends javax.swing.JFrame {

    /**
     * Creates new form print
     */
    public print() {
        initComponents();
    }
    
    String lpaid;
    String ltot_amount;
    String lbal;
    
    public print(String paid, String tol_amount, String bal, TableModel tableModel) {
        initComponents();
        
        this.lpaid = paid;
        this.ltot_amount = tol_amount;
        this.lbal = bal;
        
        txtprint.setText(txtprint.getText()+ "******************************************************\n");
        txtprint.setText(txtprint.getText()+ " ******** W M S (PVT) LTD - KURUNEGALA ********\n");
        txtprint.setText(txtprint.getText()+ "\n");
        txtprint.setText(txtprint.getText()+ "\n");

        for(int i = 0; i< tableModel.getRowCount(); i++)
        {

            String Product_Name = (String) tableModel.getValueAt(i, 1);
            String Bar_Code = (String) tableModel.getValueAt(i, 2);
            String Unit_Price = (String) tableModel.getValueAt(i, 4);
            String Qty = (String) tableModel.getValueAt(i, 3);
            
               txtprint.setText(txtprint.getText()+ "Product Name : ");
               txtprint.setText(txtprint.getText()+ Product_Name + "\t");
               txtprint.setText(txtprint.getText()+ "\n\n");
               txtprint.setText(txtprint.getText()+ "Bar Code : " );
               txtprint.setText(txtprint.getText()+ Bar_Code + "\t");
               txtprint.setText(txtprint.getText()+ "\n\n");
               txtprint.setText(txtprint.getText()+ "Unit Price : ");
               txtprint.setText(txtprint.getText()+ Unit_Price + "\t");
               txtprint.setText(txtprint.getText()+ "\n\n");
               txtprint.setText(txtprint.getText()+ "Qty : ");
               txtprint.setText(txtprint.getText()+ Qty + "\t");
               txtprint.setText(txtprint.getText()+ "\n\n");
               txtprint.setText(txtprint.getText()+ "\n\n");
               txtprint.setText(txtprint.getText()+ "\n\n");

            
            txtprint.setText(txtprint.getText()+ "\n");
            txtprint.setText(txtprint.getText()+ "\n");
            
            txtprint.setText(txtprint.getText()+ "             " + "Total Amount : " + tol_amount + "\n");
            txtprint.setText(txtprint.getText()+ "             " + "Paid : " + paid + "\n");
            txtprint.setText(txtprint.getText()+ "             " + "Balance : " + bal + "\n");
            
            txtprint.setText(txtprint.getText()+ "*******************************************************\n");
            txtprint.setText(txtprint.getText()+ "*******************************************************\n");
            txtprint.setText(txtprint.getText()+ "Thank You come again!............\n");
            
            try {
                txtprint.print();
            } catch (PrinterException ex) {
                Logger.getLogger(print.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtprint = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(txtprint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtprint;
    // End of variables declaration//GEN-END:variables
}
