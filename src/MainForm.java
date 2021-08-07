import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainForm extends javax.swing.JFrame {

    public MainForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainMenuBar = new javax.swing.JMenuBar();
        masterMenu = new javax.swing.JMenu();
        categoryMenuItem = new javax.swing.JMenuItem();
        categoryMenuItemSeprator = new javax.swing.JPopupMenu.Separator();
        productMenuItem = new javax.swing.JMenuItem();
        productMenuItemSeperator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        transactionMenu = new javax.swing.JMenu();
        stockMenuItem = new javax.swing.JMenuItem();
        stockMenuItemSeperator = new javax.swing.JPopupMenu.Separator();
        invoiceMenuItem = new javax.swing.JMenuItem();
        reportMenu = new javax.swing.JMenu();
        showOrdersMenuItem = new JMenuItem();
        findOrderMenuItem = new JMenuItem();
        stockReportMenuItem = new JMenuItem();
        findOrderMenuItemSeperator = new javax.swing.JPopupMenu.Separator();
        JPopupMenu.Separator showOrdersMenuItemSeperator = new JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        masterMenu.setText("Master");

        categoryMenuItem.setText("Add New Category");
        categoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryMenuItemActionPerformed(evt);
            }
        });
        masterMenu.add(categoryMenuItem);
        masterMenu.add(categoryMenuItemSeprator);

        productMenuItem.setText("Add New Product");
        productMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productMenuItemActionPerformed(evt);
            }
        });
        masterMenu.add(productMenuItem);
        masterMenu.add(productMenuItemSeperator);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        masterMenu.add(exitMenuItem);

        mainMenuBar.add(masterMenu);

        transactionMenu.setText("Transaction");

        stockMenuItem.setText("Stock");
        stockMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockMenuActionPerformed(evt);
            }
        });
        transactionMenu.add(stockMenuItem);
        transactionMenu.add(stockMenuItemSeperator);

        invoiceMenuItem.setText("Invoice");
        invoiceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceMenuActionPerformed(evt);
            }
        });
        transactionMenu.add(invoiceMenuItem);

        mainMenuBar.add(transactionMenu);

        reportMenu.setText("Report");

        findOrderMenuItem.setText("Find Order");
        findOrderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findOrderMenuItemActionPerformed(evt);
            }
        });

        showOrdersMenuItem.setText("Show all Orders");
        showOrdersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showOrdersMenuItemActionPerformed(evt);
            }
        });

        stockReportMenuItem.setText("Stock Report");
        stockReportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockReportMenuItemActionPerformed(evt);
            }
        });
        
        reportMenu.add(findOrderMenuItem);
        
        reportMenu.add(findOrderMenuItemSeperator);
        reportMenu.add(showOrdersMenuItem);
        reportMenu.add(stockMenuItemSeperator);
        reportMenu.add(stockReportMenuItem);
        mainMenuBar.add(reportMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1046, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findOrderMenuItemActionPerformed(ActionEvent evt) {
        new FindOrder();
        this.repaint();
    }

    private void showOrdersMenuItemActionPerformed(ActionEvent evt) {
        ShowOrders frm = new ShowOrders();
        frm.setVisible(true);
    }

    private void stockReportMenuItemActionPerformed(ActionEvent evt) {
        StockReport frm = new StockReport();
        frm.setVisible(true);
    }

    private void categoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        CategoryMaster frm = new CategoryMaster();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void productMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ProductMaster frm = new ProductMaster();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void stockMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       Stock frm = new Stock();
       frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void invoiceMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       Invoice frm = new Invoice();
       frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu masterMenu;
    private javax.swing.JMenu transactionMenu;
    private javax.swing.JMenu reportMenu;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenuItem categoryMenuItem;
    private javax.swing.JMenuItem productMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem stockMenuItem;
    private javax.swing.JMenuItem invoiceMenuItem;

    private javax.swing.JMenuItem findOrderMenuItem;
    private javax.swing.JMenuItem showOrdersMenuItem;
    private javax.swing.JMenuItem stockReportMenuItem;

    private javax.swing.JPopupMenu.Separator categoryMenuItemSeprator;
    private javax.swing.JPopupMenu.Separator productMenuItemSeperator;
    private javax.swing.JPopupMenu.Separator stockMenuItemSeperator;

    private javax.swing.JPopupMenu.Separator findOrderMenuItemSeperator;

    // End of variables declaration//GEN-END:variables
}
