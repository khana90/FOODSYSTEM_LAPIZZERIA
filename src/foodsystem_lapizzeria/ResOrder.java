package foodsystem_lapizzeria;

import foodsystem_lapizzeria.Shopping_Basket;
import foodsystem_lapizzeria.Login;
import Categories.Sub_MenuOne;
import Categories.Sub_MenuTwo;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import foodsystem_lapizzeria.ProConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author A
 */
public class ResOrder extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet res;
    String qry, qry2;

    public ResOrder() {
        initComponents();
        conn = ProConnection.ConnectDB();
        ResOrderTable();
        getTotal();
        CustAddress();

    }

    public void ResOrderTable() {
        qry = " select item_title,description,price,size,cust_id from shopping_basket where cust_id";
        try {
            pst = conn.prepareStatement(qry);
            res = pst.executeQuery();
            while (res.next()) {
                String itemTitle = res.getString("item_title");
                String dsc = res.getString("description");
                Double prc = res.getDouble("price");
                String size = res.getString("size");
                Login.CustomerId = res.getInt("cust_id");
                //Integer cstId=res.getInt("cust_id");
                order_tbl2.setModel(DbUtils.resultSetToTableModel(res));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "table" + e);
            System.out.println(e.getMessage());
        }
    }

    public void getTotal() {
        double sum = 0.0;
        //  double R=0;

        DefaultTableModel model = (DefaultTableModel) order_tbl2.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            sum = sum + Double.parseDouble(model.getValueAt(i, 2).toString());

            tftotal.setText(String.format("%.2f", sum));

        }
    }

    public void CustAddress() {

        try {
            DefaultListModel model = new DefaultListModel();
            String qry = "select DISTINCT name,email,address,contact from customer group by cust_id order by 2 DESC limit 1";
            pst = conn.prepareStatement(qry);
            res = pst.executeQuery();
            while (res.next()) {
                model.addElement("<CUSTOMER ADDRESS>");
                model.addElement("Name: " + res.getString("name"));
                model.addElement("Email: " + res.getString("email"));
                model.addElement("Address: " + res.getString("address"));
                model.addElement("Contact: " + res.getString("contact"));

                jList1.setModel(model);
                dispose();
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "cust addrs" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        order_tbl2 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        RBCollection = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tftotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        jScrollPane1.setViewportView(order_tbl2);

        jToggleButton1.setText("Cancel");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton1.setText("Checkout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RBCollection);
        RBCollection.setText("Collection");
        RBCollection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBCollectionActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Delivery");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Order");

        jLabel2.setText("Total:");

        tftotal.setEditable(false);

        jLabel3.setBackground(new java.awt.Color(255, 255, 102));
        jLabel3.setForeground(new java.awt.Color(255, 0, 102));

        jLabel4.setText("Order Status");

        jButton2.setText("Amend Address");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tftotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)
                                                .addComponent(jRadioButton2))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(RBCollection))
                                        .addComponent(jButton2))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))))
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jToggleButton1))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RBCollection)
                                    .addComponent(jRadioButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tftotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(47, 47, 47))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//INSERT into `order`(cust_id,basket_id) VALUES ('?','?'),
//(SELECT cust_id, basket_id from shopping_basket where cust_id = (SELECT MAX(cust_id) FROM `shopping_basket`))
        //INSERT INTO `order` (`cust_id`, `basket_id`)(SELECT cust_id,basket_id from shopping_basket)
//        qry = "INSERT INTO `order` (`cust_id`, `basket_id`,`order_status`,`total`) values (?,?,?,?)\n"
//                + "(SELECT cust_id,basket_id from shopping_basket where cust_id=(select MAX(cust_id) from shopping_basket)) ";
        qry = " select basket_id from shopping_basket where cust_id=(select MAX(cust_id) from shopping_basket)";
        try {
            pst = conn.prepareStatement(qry);
            while(res.next()){
           //   Shopping_Basket.basketId=res.getInt("basket_id");
            //  Integer cstId = res.getInt("basket_id");
              // Login.CustomerId = res.getInt("cust_id");
               Integer bskId=res.getInt("basket_id");
            res = pst.executeQuery();
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "1st qry" + e);
        }

        qry2 = "INSERT INTO `order` (`cust_id`, basket_id, total, order_status) VALUES (?,?,?,?)";

        try {
            pst2 = conn.prepareStatement(qry2);

            while (res.next()) {
                pst2.setInt(1, Login.CustomerId);
                pst2.setInt(2, Shopping_Basket.basketId);
                pst2.setDouble(3, Double.parseDouble(tftotal.getText()));
                // pst.setDouble(3, res.getDouble("total"));
//            RBCollection.setActionCommand("collection");
//            jRadioButton2.setActionCommand("delivery");
//            pst.setString(4, buttonGroup1.getSelection().getActionCommand());
                pst2.setString(4, OrderStatus);
                pst2.execute();
                new Payment().setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "wrong entry" + e);
            System.out.print(e.getMessage());
        }
       //  dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void RBCollectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCollectionActionPerformed
        // TODO add your handling code here:
        RBCollection.isSelected();
        jLabel3.setText("20 min");
        OrderStatus = "collection";
//        try {
//            String qry = "insert into order(order_status) values (?)"
//                    + "";
//            pst = conn.prepareStatement(qry);
//          //  pst.setInt(1, Shopping_Basket.basketId);
//              RBCollection.setActionCommand("collection");
//              jRadioButton2.setActionCommand("delivery");
//              pst.setString(1, buttonGroup1.getSelection().getActionCommand());
////           String value= RBCollection.getActionCommand().toString();
////            pst.setString(1,value);
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "collection is requested");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "uu" + e);
//        }
//       // OrderStatus = "Collection";
    }//GEN-LAST:event_RBCollectionActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        new Customer_Address().setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ResOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResOrder().setVisible(true);
            }
        });
    }
    private String OrderStatus;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RBCollection;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable order_tbl2;
    private javax.swing.JTextField tftotal;
    // End of variables declaration//GEN-END:variables
}
