package foodsystem_lapizzeria;

import foodsystem_lapizzeria.Payment;
import Foodsystem_Admin.AdminPage;
import foodsystem_lapizzeria.Login;
//import foodsystem_lapizzeria.Shopping_Basket;
import Foodsystem_Admin.Admin_Login;
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
public final class ResReceipt extends javax.swing.JFrame {

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
                model.addElement("Total: " + res.getString("total"));
                // model.addElement("Order Request: " + res.getString("order_request"));
            }
            jList1.setModel(model);

            res = pst.executeQuery();
            while (res.next()) {
                model.addElement("*************CUSTOMER ORDER*************");
                model.addElement("Item Name: " + res.getString("item_title"));
                model.addElement("Item description: " + res.getString("description"));
                model.addElement("Item Price: " + res.getString("price"));
                model.addElement("Item Size: " + res.getString("size"));
            }
            model.addElement("##############Enjoy Your Meal##############");
            jList1.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error with list fetchData" + e);
            // System.out.println(e.getMessage());
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
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Customer Receipt");

        jScrollPane1.setViewportView(jList1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Symbols/Back.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Symbols/Cancel.png"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Leave Note for Restaurant:");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Symbols/Screen Shot 2018-12-12 at 04.10.21.png"))); // NOI18N
        jButton3.setText("Send Order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Symbols/Tick.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(RBDelivery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RBCollection))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(109, 109, 109)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addGap(201, 201, 201)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jButton3))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBDelivery)
                    .addComponent(RBCollection))
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String orderreq = null ;
        
        qry = "INSERT into Receipt (item_title,item_desc,item_price,item_size,cust_id,cust_name,cust_email,cust_address,cust_contact,payment_type,DateTime,Total,paymentId)"
                + "SELECT s.item_title,s.description,s.price,s.size, c.cust_id,c.name,c.email,c.address,c.contact, p.Payment_type, p.DateTime,p.Total,p.paymentId "
                + "from shopping_basket s ,customer c, payment p where c.cust_id=? and s.cust_id = c.cust_id and p.DateTime = (select MAX(DateTime) from payment)\n"
                + "GROUP by s.basket_id  \n"
                + "Order by p.total";
        try {
            pst = conn.prepareStatement(qry);
            pst.setInt(1, Login.CustomerId);
       //    pst.setString(2, (String) jTextField1.getText());
            pst.executeUpdate();

            if (res.next()) {
                pst.setString(1, res.getString("item_title"));
                pst.setString(2, res.getString("item_desc"));
                pst.setString(3, res.getString("item_price"));
                pst.setString(4, res.getString("item_size"));
                pst.setString(5, res.getString("cust_id"));
                pst.setString(6, res.getString("cust_email"));
                pst.setString(7, res.getString("cust_address"));
                pst.setString(8, res.getString("cust_contact"));
                pst.setString(9, res.getString("payment_type"));
                pst.setString(10, res.getString("datetime"));
                pst.setString(11, res.getString("total"));
                pst.setString(12, res.getString("paymentId"));
                
               
                pst.execute();
                // pst.addBatch();
           }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There's an error in sending order" + e);
            //  System.out.print(e.getMessage());
        }
        //   }
        JOptionPane.showMessageDialog(null, "Order has been sent");
        //  new AdminPage().setVisible(true);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void RBDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeliveryActionPerformed
        // TODO add your handling code here:
//        if (RBDelivery.isSelected()) {
//            //JOptionPane.showMessageDialog(null, "Delivery is selected");
//            try {
//                qry = "Insert into Receipt (Order_request) values (?)";
//                pst = conn.prepareStatement(qry);
//                RBDelivery.setActionCommand("Delivery");
//                pst.setString(1, buttonGroup1.getSelection().getActionCommand());
//
//                pst.execute();
//                //  JOptionPane.showMessageDialog(null, "Order Status has been selected");
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Delivery is slected" + e);
//            }
//        }


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
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
