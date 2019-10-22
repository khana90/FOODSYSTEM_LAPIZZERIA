package foodsystem_lapizzeria;

import foodsystem_lapizzeria.Payment;
import foodsystem_lapizzeria.Login;
import foodsystem_lapizzeria.Shopping_Basket;
import Foodsystem_Admin.AdminPage;
import static Foodsystem_Admin.AdminPage.jListAdmin;
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
import net.proteanit.sql.DbUtils;

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
    public static int PaymentId;

    public ResReceipt() {
        initComponents();
        conn = ProConnection.ConnectDB();
        ResReceipt();
        this.setLocationRelativeTo(null);

    }

    public final void ResReceipt() {
        //  DefaultListModel model = new DefaultListModel();
        // System.out.println("JList item size: " + list.getModel().getSize());

//        System.out.println("Reading all list items:");
//        System.out.println("-----------------------");
//        for (int i = 0; i < list.getModel().getSize(); i++) {
//            Object item = list.getModel().getElementAt(i);
//            System.out.println("Item = " + item);
//        }
//    }  
        try {
            qry = "SELECT s.item_title,s.description,s.price,s.size, "
                    + "c.name,c.email,c.address,c.contact,"
                    + "p.paymentId,p.Payment_type, p.DateTime,p.Total from shopping_basket s INNER JOIN customer c ON c.cust_id=s.cust_id \n"
                    + "INNER JOIN payment p \n"
                    + " where c.cust_id=? and PaymentId =(SELECT Max(PaymentId) from payment) \n"
                    + " GROUP by s.basket_id  \n"
                    + " ORDER BY p.total";

            pst = conn.prepareStatement(qry);
            //  pst.setInt(1, PaymentId);
            pst.setInt(1, Login.CustomerId);
            res = pst.executeQuery();

            jTextArea1.append("*******************LAPIZZERIA*****************" + "\n\n");

            if (res.next()) {
                String custname = res.getString("name");
                String custAddress = res.getString("address");
                String custContact = res.getString("contact");

                jTextArea1.append("Customer Name: " + custname + "\n"
                        + "Address:" + custAddress + "\n"
                        + "Contact:" + custContact + "\n");

                String pyType = res.getString("payment_type");
                String date = res.getString("DateTime");
                Double total = res.getDouble("total");

                jTextArea1.append(" ***************Payment Options**************" + "\n"
                        + "Payment Type : " + pyType + "\n"
                        + "Order Date Time:" + date + "\n"
                        + "Order Total: " + total + "\n");
            }

            while (res.next()) {
                String itemt = res.getString("item_title");
                String desc = res.getString("description");
                Double price = res.getDouble("price");
                String size = res.getString("size");

                jTextArea1.append("**************Items Details*******************" + "\n"
                        + "Item Name: " + itemt + " \n "
                        + "Description: " + desc + " \n "
                        + "Price: " + price + "\n"
                        + "Size: " + size + "\n\n");
            }
            jTextArea1.append("************Thanks for Choosing Us***********");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "rec" + e);
            System.out.println(e.getMessage());
        }

        // dispose();
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
        jRadioButton2 = new javax.swing.JRadioButton();
        RBCollection = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Delivery");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
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

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(0, 289, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addGap(125, 125, 125))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRadioButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RBCollection)))
                                .addComponent(jLabel4))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RBCollection)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(40, 40, 40)
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
    //Send to Restaurant////pst.setInt(3, Integer.parseInt(jTextArea1.getText()));
        //  ArrayList<String> arrayList = new ArrayList<String>();
        //                int i = 1;
//                int numberOfColumns = 0;
//                while (i <= numberOfColumns) {
//                arrayList.add(res.getString(i++));
        int row = 0;
        try {
  String qry = "INSERT into Receipt (item_title,item_desc,item_price,item_size,cust_id,cust_name,cust_email,cust_address,cust_contact,paymentId,payment_type,DateTime,Total)\n" +
"\n" +
"SELECT s.item_title,s.description,s.price,s.size, \n" +
"c.cust_id,c.name,c.email,c.address,c.contact,\n" +
"p.PaymentId,p.Payment_type, p.DateTime,p.Total from shopping_basket s ,customer c, payment p\n" +
"      where c.cust_id=137 and PaymentId =(SELECT Max(PaymentId) from payment)"
                    + "group by s.basket_id"
                   + "Order by p.total";

            pst = conn.prepareStatement(qry);
            
     
            pst.execute();
            JOptionPane.showMessageDialog(null, "Order has been sent");
          //  }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There's an error in sending order" + e);
            System.out.print(e.getMessage());
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        //        if (RBCollection.isSelected()) {
        //            jLabel3.setText("20 min");
        //        } else {
        //            jRadioButton2.isSelected();
        //
        //        }
        OrderStatus = "Delivery";

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void RBCollectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCollectionActionPerformed
        // TODO add your handling code here:
        RBCollection.isSelected();
        jLabel3.setText("20 min");
        OrderStatus = "collection";
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
    private String OrderStatus;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RBCollection;
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
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
