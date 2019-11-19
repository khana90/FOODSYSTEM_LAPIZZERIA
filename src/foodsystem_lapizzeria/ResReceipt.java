package foodsystem_lapizzeria;

import foodsystem_lapizzeria.Payment;
import foodsystem_lapizzeria.Login;
import foodsystem_lapizzeria.Shopping_Basket;
import static Foodsystem_Admin.AdminPage.jPanel4;
import Foodsystem_Admin.Admin_Login;
//import apple.laf.JRSUIConstants;
import java.awt.HeadlessException;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import static javax.swing.text.StyleConstants.Size;

/**
 *
 * @author A
 */
public class ResReceipt extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet res;
    String qry;

    public static int CustomerId;
    
    

    public ResReceipt() {
        initComponents();
        conn = ProConnection.ConnectDB();
        ResReceipt();
        this.setLocationRelativeTo(null);

    }

    public void ResReceipt() {

        try {

            DefaultListModel model = new DefaultListModel();
            qry = "SELECT s.*,c.*,\n"
                    + "p.* from shopping_basket s INNER JOIN customer c ON c.cust_id=s.cust_id\n"
                    + "INNER JOIN payment p\n"
                    + "where c.cust_id=? and p.paymentId = (SELECT max(paymentId) from payment) \n"
                    + "      GROUP by s.basket_id \n"
                    + "      ORDER BY p.total";

            pst = conn.prepareStatement(qry);
            pst.setInt(1, Login.CustomerId);
            //   pst.setInt(2, Shopping_Basket.BasketId);
            res = pst.executeQuery();

            if (res.next()) {
                model.addElement("<<<<<<<<<<<CUSTOMER Address>>>>>>>>>>>");
                model.addElement("Customer Id: " + res.getInt("cust_id"));
                model.addElement("Customer Name: " + res.getString("name"));
                model.addElement("Customer Email: " + res.getString("email"));
                model.addElement("Customer Address: " + res.getString("address"));
                model.addElement("Customer Contact: " + res.getString("contact"));
                model.addElement("<<<<<<<<<<<PAYMENT OPTION>>>>>>>>>>>");
                //  model.addElement("Payment Id: " + res.getInt("paymentId"));
                model.addElement("Payment Type: " + res.getString("payment_type"));
                model.addElement("Date and Time: " + res.getString("DateTime"));
                model.addElement("Sub Total: " + res.getString("total"));
            }
            jList1.setModel(model);

            while (res.next()) {
                model.addElement("*************CUSTOMER ORDER*************");
                model.addElement("Item Name: " + res.getString("item_title"));
                model.addElement("Item description: " + res.getString("description"));
                model.addElement("Item Price: " + res.getString("price"));
                model.addElement("Item Size: " + res.getString("size"));

            }

            jList1.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error with list fetchData" + e);
            System.out.println(e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        RBDelivery = new javax.swing.JRadioButton();
        RBCollection = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Customer Receipt");

        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Leave Note:");

        jButton3.setText("Send Order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Order Status:");

        buttonGroup1.add(RBDelivery);
        RBDelivery.setText("Delivery");
        RBDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBDeliveryActionPerformed(evt);
            }
        });

        buttonGroup1.add(RBCollection);
        RBCollection.setText("Collection");
        RBCollection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBCollectionActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(125, 125, 125))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(RBDelivery)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RBCollection))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3))))
                        .addContainerGap(224, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RBDelivery)
                                    .addComponent(RBCollection))
                                .addGap(96, 96, 96)))
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Payment().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Send to Restaurant

        String item = "";

        for (int i = 0; i < jList1.getModel().getSize(); i++) {
            item = (String) jList1.getModel().getElementAt(i);

       String qry = "INSERT into Receipt (item_title,item_desc,item_price,item_size,cust_id,cust_name,cust_email,cust_address,cust_contact,payment_type,DateTime,Total,paymentId)\n"
                    + "SELECT s.item_title,s.description,s.price,s.size, \n"
                    + "c.cust_id,c.name,c.email,c.address,c.contact,\n"
                    + "p.Payment_type, p.DateTime,p.Total,p.paymentId from shopping_basket s ,customer c, payment p\n"
                    + " where c.cust_id=? and p.DateTime = (select MAX(DateTime) from payment) \n"
                    + " GROUP by s.basket_id\n"
                    + " Order by p.total";
            try {
                pst = conn.prepareStatement(qry);
               pst.setInt(1, Login.CustomerId);
             //  pst.setInt(2, Payment.PaymentId);
                pst.executeUpdate();
                
                pst.setString(1, item);

                pst.execute();
        
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "There's an error in sending order" + e);
                System.out.print(e.getMessage());
            }
        }
          JOptionPane.showMessageDialog(null, "Order has been sent");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RBDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeliveryActionPerformed
        // TODO add your handling code here:
//                if (RBDelivery.isSelected()) {
//                     JOptionPane.showMessageDialog(null, "Delivery is selected");
//                try{
//                    qry="Insert into Receipt (Order_request) values (?)";
//                    pst=conn.prepareStatement(qry);
//                    RBDelivery.setActionCommand("Delivery");
//                    pst.setString(1,buttonGroup1.getSelection().getActionCommand());
//                    
//                    pst.execute();
//                  //  JOptionPane.showMessageDialog(null, "Order Status has been selected");
//                }catch(Exception e){
//                    JOptionPane.showMessageDialog(null, "Delivery is slected"+e);
//                }
//    }
        

    }//GEN-LAST:event_RBDeliveryActionPerformed

    private void RBCollectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCollectionActionPerformed
        // TODO add your handling code here:
//        if (RBCollection.isSelected()){
//            jLabel3.setText("20 min");
//             JOptionPane.showMessageDialog(null, "Collection is Requested");
//              try{
//                    qry="Insert into Receipt (Order_request) values (?)";
//                    pst=conn.prepareStatement(qry);
//                    RBCollection.setActionCommand("Collection");
//                    pst.setString(1,buttonGroup1.getSelection().getActionCommand());
//                    
//                    pst.execute();
//            
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "collection is selected "+e);
//              
//        }
    }//GEN-LAST:event_RBCollectionActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(ResReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResReceipt().setVisible(true);
            }
        });
    }
   // private String OrderStatus;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RBCollection;
    private javax.swing.JRadioButton RBDelivery;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
