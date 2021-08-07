import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class Invoice extends javax.swing.JFrame {

    DefaultTableModel dt;
    double finalAmt = 0;
    private javax.swing.JComboBox categoryList;
    private javax.swing.JLabel totalAmountText;
    private javax.swing.JLabel currentDateLebel;
    private javax.swing.JLabel itemRateLabel;
    private javax.swing.JLabel balanceQtyAmountLabel;
    private javax.swing.JTable addedItemsTable;
    private javax.swing.JTextField customerNameTextField;

    private javax.swing.JLabel customerPhoneLabel;
    private javax.swing.JTextField customerPhoneTextField;
    private javax.swing.JLabel customerAddressLabel;
    private javax.swing.JTextField customerAddressTextField;

    private javax.swing.JTextField qtyTextField;

    public Invoice() {
        initComponents();

        dt = new DefaultTableModel();
        dt.addColumn("Product Id");
        dt.addColumn("Product Name");
        dt.addColumn("Qty");
        dt.addColumn("Rate");
        dt.addColumn("Amount");

        currentDateLebel.setText(new java.util.Date().toString());
        fetchDt();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabel invoiceLabel = new JLabel();
        JLabel nameLabel = new JLabel();
        JLabel dateLabel = new JLabel();
        currentDateLebel = new javax.swing.JLabel();
        customerNameTextField = new javax.swing.JTextField();
        categoryList = new javax.swing.JComboBox();
        JLabel productLabel = new JLabel();
        qtyTextField = new javax.swing.JTextField();
        JLabel rateLabel = new JLabel();
        itemRateLabel = new javax.swing.JLabel();
        JLabel balanceQtyLabel = new JLabel();
        balanceQtyAmountLabel = new javax.swing.JLabel();
        JLabel qtyItemLabel = new JLabel();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JButton addItemButton = new JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        addedItemsTable = new javax.swing.JTable();
        JButton newOrderButton = new JButton();
        JButton removeButton = new JButton();
        JButton saveButton = new JButton();
        JButton printButton = new JButton();
        JLabel totalAmmountLabel = new JLabel();
        totalAmountText = new javax.swing.JLabel();

        customerPhoneLabel = new JLabel();
        customerPhoneTextField = new javax.swing.JTextField();
        customerAddressLabel = new JLabel();
        customerAddressTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(100, 100, 0, 0));

        invoiceLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        invoiceLabel.setText("Invoice");

        nameLabel.setText("Name");
        customerPhoneLabel.setText("Phone");
        customerAddressLabel.setText("Address");
        dateLabel.setText("Date");


        currentDateLebel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        currentDateLebel.setForeground(new java.awt.Color(255, 0, 51));
        currentDateLebel.setText("");

        categoryList.setModel(new javax.swing.DefaultComboBoxModel(new String[]{}));
        categoryList.addItemListener(evt -> itemsListActionPerformed(evt));

        productLabel.setText("Product ");

        rateLabel.setText("Rate");

        itemRateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemRateLabel.setForeground(new java.awt.Color(255, 0, 51));
        itemRateLabel.setText("0.0");

        balanceQtyLabel.setText("Balance Qty");

        balanceQtyAmountLabel.setText("0.0");


        qtyItemLabel.setText("Qty");

        addItemButton.setText("Add");
        addItemButton.addActionListener(evt -> addButtonActionPerformed(evt));

        addedItemsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Product", "Qty", "Rate", "Amount"
                }
        ) {
            final boolean[] canEdit = new boolean[]{
                    false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(addedItemsTable);

        removeButton.setText("Remove");
        removeButton.addActionListener(evt -> jButton2ActionPerformed(evt));

        saveButton.setText("Save");
        saveButton.addActionListener(evt -> saveButtonActionPerformed());

        newOrderButton.setText("New Order");
        newOrderButton.addActionListener(evt -> newOrderButtonActionPerformed());
        printButton.setText("Print");
        printButton.addActionListener(evt -> printButtonActionPerformed(evt));

        totalAmmountLabel.setText("Total");

        totalAmountText.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        totalAmountText.setForeground(new java.awt.Color(255, 0, 0));
        totalAmountText.setText("0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(newOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(totalAmmountLabel)
                                                                .addComponent(totalAmountText)
                                                        )
                                                       )
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,true)
                                                                        .addComponent(productLabel)
                                                                        .addComponent(categoryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(36, 36, 36)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, true)
                                                                        .addComponent(rateLabel)
                                                                        .addComponent(itemRateLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, true)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(balanceQtyAmountLabel))
                                                                        .addComponent(balanceQtyLabel)))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,true)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(nameLabel)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                )
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(this.customerPhoneLabel)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(this.customerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                )
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(this.customerAddressLabel)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(this.customerAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                )
                                                                .addComponent(invoiceLabel)))
                                                .addGap(18, 111, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(addItemButton)
                                                                .addContainerGap())
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        //.addComponent(totalAmmountLabel)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(qtyItemLabel)
                                                                                        .addComponent(dateLabel))
                                                                                .addGap(45, 45, 45)
                                                                                .addComponent(currentDateLebel)))
                                                                .addGap(87, 87, 87))))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(invoiceLabel)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(currentDateLebel)
                                        .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameLabel)
                                )
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(customerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(customerPhoneLabel)
                                )
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(customerAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(customerAddressLabel)
                                )
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(productLabel)
                                        .addComponent(rateLabel)
                                        .addComponent(balanceQtyLabel)
                                        .addComponent(qtyItemLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(categoryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(itemRateLabel)
                                        .addComponent(balanceQtyAmountLabel)
                                        .addComponent(addItemButton))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(totalAmmountLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(totalAmountText)
                                                .addGap(34, 34, 34)
                                                .addComponent(newOrderButton)
                                                .addGap(34, 34, 34)
                                                .addComponent(removeButton)
                                                .addGap(26, 26, 26)
                                                .addComponent(saveButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(printButton)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newOrderButtonActionPerformed() {
        while (dt.getRowCount() > 0)
            dt.removeRow(0);
        customerNameTextField.setText("");
        qtyTextField.setText("");
    }

    private void saveButtonActionPerformed() {

        try {
            DBConnect x = new DBConnect();
            String sql = "insert into orders (order_total) values (" + totalAmountText.getText() + ");";

            PreparedStatement preparedStatement = x.queryExecuterPreparedStmt(sql);

            preparedStatement.execute();

            HashMap<Integer, Integer> stockMap = new HashMap<>();
            sql = "select product_id, qty from stock;";
            ResultSet rs = x.queryReturner(sql);
            while (rs.next()) {
                stockMap.put(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)));
            }


            sql = "select max(order_id) from orders;";
            rs = x.queryReturner(sql);

            int orderId = 0;
            if(rs.next()) orderId = rs.getInt(1);

            for (int i = 0; i < dt.getRowCount(); i++) {
                if (!stockMap.containsKey(dt.getValueAt(i, 0)) ||
                        dt.getValueAt(i, 1).toString().matches("\\d+") ||
                        stockMap.get(dt.getValueAt(i, 0)) < Integer.parseInt(dt.getValueAt(i, 2).toString())) {
                    JOptionPane.showMessageDialog(this, "Not a valid quantity " +
                            dt.getValueAt(i, 2).toString() +
                            " for product: " +
                            dt.getValueAt(i, 1).toString());
                    x.closeConnection();
                    return;

                }


                sql = "insert into order_items(order_id, product_id, qty, item_total) values (" +
                        orderId + ", '" + dt.getValueAt(i, 0) +
                        "', " + dt.getValueAt(i, 2) + ", " +
                        dt.getValueAt(i, 4) +
                        ");";
                Statement statement = x.queryExecuterWithoutAutoCommit();

                statement.execute(sql);
                sql = "update stock set qty = qty -" + dt.getValueAt(i, 2)
                        + " where product_id = " + dt.getValueAt(i, 0) + ";";

                statement.execute(sql);
                statement.close();
            }

            sql = "insert into customer( customer_name, phone_number, address) values ('" +
                     customerNameTextField.getText()+"', "+
                    customerPhoneTextField.getText()+", '"+ customerAddressTextField.getText()+
                    "');";

            PreparedStatement pStatement = x.queryExecuterPreparedStmt(sql);
            pStatement.executeUpdate();

            sql = "select max(customer_id) from customer where "+
                    "customer_name = '"+ customerNameTextField.getText() +
                   "' and phone_number =  "+  customerPhoneTextField.getText() +
                    " and address = '"+  customerAddressTextField.getText()+ "';";

            rs = x.queryReturner(sql);

            int custId = 0;
            if(rs.next()) custId = rs.getInt(1);



            sql = "insert into invoice(order_id, customer_id) values (" +
                    orderId + ", '" + custId + "');";

            x.queryExecuter(sql);

            x.commit();
            x.closeConnection();
            JOptionPane.showMessageDialog(this, "Order placed successfully!");
            fetchDt();
            this.repaint();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void printButtonActionPerformed(ActionEvent evt) {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.LANDSCAPE);
        PageFormat postformat = pjob.pageDialog(preformat);
        //If user does not hit cancel then print.
        if (preformat != postformat) {
            //Set print component
            pjob.setPrintable(new Printer(this), postformat);
            if (pjob.printDialog()) {
                try {
                    pjob.print();
                } catch (PrinterException e) {
                    JOptionPane.showMessageDialog(this, "Invoice: " + e.getMessage());
                }
            }
        }
    }

    private void itemsListActionPerformed(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        try {
            DBConnect x = new DBConnect();
            if(categoryList.getSelectedItem() != null) {
                ProductItem selectedItem = (ProductItem) categoryList.getSelectedItem();
                itemRateLabel.setText(selectedItem.getRate() + "");
                balanceQtyAmountLabel.setText(selectedItem.getStackQty() + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invoice: " + ex.getMessage());
        }


    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double amt = 0.0;
        try {
            amt = Double.parseDouble(qtyTextField.getText()) *
                    Double.parseDouble(itemRateLabel.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


        finalAmt = finalAmt + amt;
        totalAmountText.setText(String.valueOf(finalAmt));
        ProductItem selectedItem= (ProductItem)categoryList.getSelectedItem();
        dt.addRow(new Object[]{
                selectedItem.getProductId()
                ,selectedItem.toString(),
                qtyTextField.getText(),
                itemRateLabel.getText(), amt
        });

        addedItemsTable.setModel(dt);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (addedItemsTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "No item selected to remove!");
            return;
        }
        try {
            double amt = Double.parseDouble(dt.getValueAt(
                    addedItemsTable.getSelectedRow()
                    , 3).toString());
            finalAmt = finalAmt - amt;
            totalAmountText.setText(String.valueOf(finalAmt));

            dt.removeRow(addedItemsTable.getSelectedRow());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        addedItemsTable.setModel(dt);


    }//GEN-LAST:event_jButton2ActionPerformed
    // End of variables declaration//GEN-END:variables

    public static class Printer implements Printable {
        final Component comp;

        public Printer(Component comp) {
            this.comp = comp;
        }

        @Override
        public int print(Graphics g, PageFormat format, int page_index)
                throws PrinterException {
            if (page_index > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            // get the bounds of the component
            Dimension dim = comp.getSize();
            double cHeight = dim.getHeight();
            double cWidth = dim.getWidth();

            // get the bounds of the printable area
            double pHeight = format.getImageableHeight();
            double pWidth = format.getImageableWidth();

            double pXStart = format.getImageableX();
            double pYStart = format.getImageableY();

            double xRatio = pWidth / cWidth;
            double yRatio = pHeight / cHeight;


            Graphics2D g2 = (Graphics2D) g;
            g2.translate(pXStart, pYStart);
            g2.scale(xRatio, yRatio);
            comp.paint(g2);

            return Printable.PAGE_EXISTS;
        }

    }

    private void fetchDt(){
        try {
            DBConnect x = new DBConnect();
            String sql =
                    "select p.category,p.rate,p.model,p.company, p.pname, p.product_id, s.qty " +
                            " from productmaster p, stock s where s.product_id = p.product_id";
            ResultSet rs = x.queryReturner(sql);
            categoryList.removeAllItems();
            while (rs.next()) {
                categoryList.addItem(new ProductItem(rs.getString(1),
                        Double.parseDouble(rs.getString(2)),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        Integer.parseInt(rs.getString(6)),
                        Integer.parseInt(rs.getString(7))
                ));
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
