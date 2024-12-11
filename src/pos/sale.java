/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class sale extends javax.swing.JPanel {
    

    public static String barcode_c="0";
    public static String cus_id="0";
    
    public Double Stock_qty = 0.0;
    
    public sale() {
        initComponents();
        data_load();
//       avaliable_qty();
    }

    public void data_load(){
        
        //load Customer
        try{
            Statement s = db.mycon().createStatement();
            
             ResultSet rs = s.executeQuery(" SELECT * FROM customer");
            Vector v = new Vector();
            
            while(rs.next()){
                v.add(rs.getString("customer_name"));
                
                DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                com_cus.setModel(com);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        //load Product
        try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM product");
            Vector v = new Vector();
            
            while(rs.next()){
                v.add(rs.getString("Product_name"));
                
                DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                com_pd.setModel(com);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        // load last invoice number
        try{
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM extra WHERE exid=1");
            
            if(rs.next()){
                inid.setText(rs.getString("val"));
            }
            
        }catch(Exception e){
            }
        
        //pluss new invoices
        int i = Integer.valueOf(inid.getText());
        i++;
        inid.setText(String.valueOf(i));
        
    }
    
    public void pd_tatal_cal(){
        
        // Product Calculation
            Double qt = Double.valueOf(p_qty.getText());
            Double price = Double.valueOf(u_price.getText());
            Double tot;
            
            tot = qt * price;
            
            tot_price.setText(String.valueOf(tot));
        
    }
    
    public void avaliable_qty(){
        // Qty calculation
//        
//        Double st_qty = Stock_qty;
//        Double sell_qty = Double.valueOf(p_qty.getText());
//        st_qty = st_qty-sell_qty;
//        Double new_qty = st_qty - sell_qty;
        
//        l_stqty.setText(String.valueOf(st_qty));
//        
//        String nqty = String.valueOf(new_qty);
            try{
            Double Stock_qty = Double.valueOf(l_stqty.getText());
            Double sell_qty = Double.valueOf(p_qty.getText());
//            Double qty;
            
            Stock_qty = Stock_qty - sell_qty;
            
//            String nqty = String.valueOf(new_qty);
            
//            l_stqty.setText(String.valueOf(Stock_qty));
            
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("UPDATE product SET Qty='"+Stock_qty+"'");
            }
            catch(Exception e){
                System.out.println(e);
            }
//            l_stqty.setText(String.valueOf(Stock_qty));
        
//            Double st_qty = Stock_qty;
//            Double Sel_qty = Double.valueOf(sell_qty);
//            
//            Double new_qty = st_qty - Sel_qty; // new_qty = Stock_qty- sell_qty
//            
//            String nqty = String.valueOf(new_qty);
//            
//            try{
//                Statement ss = db.mycon().createStatement();
//                ss.executeQuery("UPDATE product SET Qty = '"+nqty+"' WHERE Bar_code ='"+bcode+"'"); // update new qty in product table 
//                
//            }catch(Exception e){
//                System.out.println(e);
//            }
//        }
    }
//    
    public void cart_total(){
        int numofrow = table.getRowCount();
        
        double total =0;
        
        for(int i = 0; i < numofrow; i++){
            double value = Double.valueOf(table.getValueAt(i, 5).toString());
            total += value;
        }
        bill_tot.setText(Double.toString(total));
        
        //Total qty count
        int numofrows = table.getRowCount();
        
        double totals =0;
        
        for(int i = 0; i < numofrows; i++){
            double values = Double.valueOf(table.getValueAt(i, 3).toString());
            totals += values;
        }
        tot_qty.setText(Double.toString(totals));
      
    }
    
    public void tot(){
        // Paid Amount
        Double paid = Double.valueOf( paid_amt.getText());
        Double tot = Double.valueOf(bill_tot.getText());
        Double due;
        
        due = paid - tot;
        
        balance.setText(String.valueOf(due));
    }
    
    public void stckup(){
        
        // get all table product id and sell qty
        DefaultTableModel dt = (DefaultTableModel) table.getModel();
        int rc = dt.getRowCount();
        
        for(int i=0; i < rc; i++){
            
            String bcode = dt.getValueAt(i, 2).toString();     // id or barcode
            String sell_qty = dt.getValueAt(i, 3).toString();   // id or barcode
            
            System.out.println(bcode);
            System.out.println(sell_qty);
            
            try{
                Statement s = db.mycon().createStatement();
                ResultSet rs = s.executeQuery(" SELECT qty FROM product WHERE Bar_code ='"+bcode+"'");
                
                if(rs.next()){
                    Stock_qty = Double.valueOf(rs.getString("Qty"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
            Double st_qty = Stock_qty;
            Double Sel_qty = Double.valueOf(sell_qty);
            
            Double new_qty = st_qty - Sel_qty; // new_qty = Stock_qty- sell_qty
            
            String nqty = String.valueOf(new_qty);
            
            try{
                Statement ss = db.mycon().createStatement();
                ss.executeQuery("UPDATE product SET Qty = '"+nqty+"' WHERE Bar_code ='"+bcode+"'"); // update new qty in product table 
                
            }catch(Exception e){
                System.out.println(e);
            }
            avaliable_qty();
        }
    }
    
     public void print()
    {
        String paid = paid_amt.getText();
        String tol_amount = bill_tot.getText();
        String bal = balance.getText();
        
        new print(paid, tol_amount, bal, table.getModel()).setVisible(true);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inid = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        u_price = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        com_cus = new javax.swing.JComboBox();
        com_pd = new javax.swing.JComboBox();
        p_qty = new javax.swing.JTextField();
        br_code = new javax.swing.JLabel();
        tot_price = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        l_stqty = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        paid_amt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        bill_tot = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tot_qty = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("INVOICE NO:");

        inid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        inid.setText("01");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close-01.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 926, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inid)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Customer :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Product :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Qty :");

        u_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        u_price.setText("00.00");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Unit Price :");

        com_cus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_cus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select" }));
        com_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_cusActionPerformed(evt);
            }
        });

        com_pd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_pd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select" }));
        com_pd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_pdActionPerformed(evt);
            }
        });

        p_qty.setBackground(new java.awt.Color(204, 204, 204));
        p_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        p_qty.setText("0");
        p_qty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                p_qtyMousePressed(evt);
            }
        });
        p_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_qtyActionPerformed(evt);
            }
        });
        p_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_qtyKeyReleased(evt);
            }
        });

        br_code.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        br_code.setText("0");

        tot_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tot_price.setText("00.00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Total Price :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Stock Qty :");

        l_stqty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l_stqty.setText("0");
        l_stqty.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                l_stqtyAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        l_stqty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_stqtyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(com_pd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(u_price, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tot_price, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(br_code, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_stqty, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(u_price)
                    .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com_pd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(tot_price)
                    .addComponent(br_code))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(l_stqty))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, 1140, 90));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table.setBackground(new java.awt.Color(153, 255, 153));
        table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Bar Code", "Qty", "Unit Price", "Total Price"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 202, 880, 180));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(102, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Add To Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 74, 152, -1));

        jButton2.setBackground(new java.awt.Color(102, 255, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 137, 152, -1));

        jButton3.setBackground(new java.awt.Color(102, 255, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Remove All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 201, 152, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, 260, 310));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Paid Amount :");

        paid_amt.setBackground(new java.awt.Color(204, 204, 204));
        paid_amt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        paid_amt.setText("0");
        paid_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paid_amtKeyReleased(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Total Amount :");

        bill_tot.setBackground(new java.awt.Color(204, 204, 204));
        bill_tot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bill_tot.setText("00.00");
        bill_tot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Balance/Due :");

        balance.setBackground(new java.awt.Color(204, 204, 204));
        balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        balance.setText("00.00");
        balance.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(bill_tot))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(balance))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Total Qty :");

        tot_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tot_qty.setText("00");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paid_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tot_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(paid_amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tot_qty)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 880, -1));

        jButton4.setBackground(new java.awt.Color(102, 255, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/payment.png"))); // NOI18N
        jButton4.setText("PAY");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, 144, 41));

        jButton5.setBackground(new java.awt.Color(102, 255, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/printer.png"))); // NOI18N
        jButton5.setText("PRINT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, -1, 41));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void com_pdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_pdActionPerformed
        // Load unit price
        
            String name = com_pd.getSelectedItem().toString();
            try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT Bar_code,Price,Qty FROM product WHERE Product_Name='"+name+"' ");
            
            if(rs.next()){
                u_price.setText(rs.getString("Price"));
                br_code.setText(rs.getString("Bar_code"));
                l_stqty.setText(rs.getString("Qty"));
            }
            
            pd_tatal_cal();
            
            }catch(Exception e){
            System.out.println(e);
        }
        
    }//GEN-LAST:event_com_pdActionPerformed

    private void p_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_qtyKeyReleased
        // TODO add your handling code here:
        pd_tatal_cal();
//        stckup();
    }//GEN-LAST:event_p_qtyKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Add cart to product details
        Double sell_qty = Double.valueOf(p_qty.getText());
        Double stk_qty = Double.valueOf(l_stqty.getText());
        
        if(sell_qty< stk_qty){
            
            DefaultTableModel dt =(DefaultTableModel) table.getModel();
            Vector v = new Vector();

            v.add(inid.getText()); // invoice id
            v.add(com_pd.getSelectedItem().toString());  // product name
            v.add(br_code.getText()); // barcode
            v.add(p_qty.getText());  // p qty
            v.add(u_price.getText()); // unit price
            v.add(tot_price.getText()); //get total price

            dt.addRow(v);

            cart_total();
            tot();
        
        }else {
            JOptionPane.showMessageDialog(balance, "Stock Have " +stk_qty+" Qty Only");
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Selected Remove Button
        try{
            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            int rw = table.getSelectedRow();
            
            dt.removeRow(rw);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        cart_total();
        tot();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Remove All
        DefaultTableModel dt = (DefaultTableModel) table.getModel();
        dt.setRowCount(0);
        
        cart_total();
        tot();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void paid_amtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paid_amtKeyReleased
        tot();
    }//GEN-LAST:event_paid_amtKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
           // PAy & Print Button (DAta send to database)
        try{
            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            int rc = dt.getRowCount();
            
            for(int i=0; i< rc; i++){
                 String inid = dt.getValueAt(i, 0).toString(); // get inid
                 String P_name = dt.getValueAt(i, 1).toString();   // get product name
                 String bar_code = dt.getValueAt(i, 2).toString();  // getbarcode
                 String qty = dt.getValueAt(i, 3).toString();  // get product qty
                 String un_price = dt.getValueAt(i, 4).toString(); // get product unit price
                 String tot_price = dt.getValueAt(i, 5).toString();    // get product total price
                 
                 // cart DB
                 Statement s = db.mycon().createStatement();
                 s.executeUpdate(" INSERT INTO cart (INID, Product_Name,Bar_code, qty, Unit_Price, Total_Price) VALUES('"+inid+"' ,'"+P_name+"', '"+bar_code+"', '"+qty+"', '"+un_price+"', '"+tot_price+"' )");
                
            }
            JOptionPane.showMessageDialog(null, "Data saved");
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            
                //sales DB
                String inv_id = inid.getText();
                String cname = com_cus.getSelectedItem().toString();
                String totqty =tot_qty.getText();
                String tot_bil = bill_tot.getText();
                String blnc = balance.getText();
                
                //paid check
                Double tot = Double.valueOf(bill_tot.getText());
                Double pid = Double.valueOf(paid_amt.getText());
                String Status = null;
                if(pid.equals(0.0)){
                    
                    Status = "Unpaid";
                    
                }else if(tot>pid){
                    Status = "Partial";
                }else if(tot<=pid){
                    Status = "Paid";
                }
                
                Statement ss = db.mycon().createStatement();
                ss.executeUpdate(" INSERT INTO sales (INID, Cid, Customer_Name, Total_Qty, Total_Bill, Status, Balance) VALUES('"+inv_id+"', '"+cus_id+"', '"+cname+"', '"+totqty+"', '"+tot_bil+"', '"+Status+"', '"+blnc+"')");
                 
        }catch(Exception e){
            System.out.println(e);
        }
        
        //save las inid number
        try{
            String id = inid.getText();
            
            Statement s = db.mycon().createStatement();
            s.executeUpdate(" UPDATE extra SET val='"+id+"' WHERE exid=1");
            
        }catch(Exception e){
            System.out.println(e);
            
            
    }//GEN-LAST:event_jButton4ActionPerformed
    }
    private void com_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_cusActionPerformed
        // Get cid
        
            String name = com_cus.getSelectedItem().toString();
            try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT cid,customer_name FROM customer WHERE customer_Name='"+name+"' ");
            
            if(rs.next()){
                cus_id =(rs.getString("cid"));
            }
            
            pd_tatal_cal();
            
            }catch(Exception e){
            System.out.println(e);
        }
            
//        stock();   sell qty and stock update
    }//GEN-LAST:event_com_cusActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Print 
//        try
//        {
//            table.print();
//        }
//        catch(Exception e)
//        {
//            
//        }
           print();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void p_qtyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_qtyMousePressed
        // TODO add your handling code here:
        pd_tatal_cal();
//        avaliable_qty();
    }//GEN-LAST:event_p_qtyMousePressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void l_stqtyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_stqtyMouseClicked
        // stock avaliable qty
//        avaliable_qty();
    }//GEN-LAST:event_l_stqtyMouseClicked

    private void p_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_qtyActionPerformed
        // TODO add your handling code here:
//        stckup();
    }//GEN-LAST:event_p_qtyActionPerformed

    private void l_stqtyAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_l_stqtyAncestorAdded
        // TODO add your handling code here:
//        avaliable_qty();
    }//GEN-LAST:event_l_stqtyAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balance;
    private javax.swing.JLabel bill_tot;
    private javax.swing.JLabel br_code;
    private javax.swing.JComboBox com_cus;
    private javax.swing.JComboBox com_pd;
    private javax.swing.JLabel inid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_stqty;
    private javax.swing.JTextField p_qty;
    private javax.swing.JTextField paid_amt;
    private javax.swing.JTable table;
    private javax.swing.JLabel tot_price;
    private javax.swing.JLabel tot_qty;
    private javax.swing.JLabel u_price;
    // End of variables declaration//GEN-END:variables

    
}
