import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
public class StockReport extends javax.swing.JFrame {

    DefaultTableModel dt;

    public StockReport() {
        // initComponents();

        dt = new DefaultTableModel();
        dt.addColumn("Category");
        dt.addColumn("Product Id");
        dt.addColumn("Product Name");
        dt.addColumn("Model");
        dt.addColumn("Company");
        dt.addColumn("Rate/ Item");
        dt.addColumn("Quantity");


        try
        {
            DBConnect x = new DBConnect();
            String sql =
                    "select category,p.product_id, p.pname, model, company, rate , qty " +
                            "from stock s, productmaster p where p.product_id = s.product_id order by category;";

            ResultSet rs = x.queryReturner(sql);

            while(rs.next())
            {
                dt.addRow(
                        new Object[]{
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7)

                        });

            }

            this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            this.setBounds(new java.awt.Rectangle(100, 200, 550, 500));
            this.setMinimumSize(new Dimension(550, 500));
            this.setTitle("Stocks details");
            stocksTable = new javax.swing.JTable();
            stocksTable.setModel(dt);
            JScrollPane stockTablePanel = new JScrollPane();
            stockTablePanel.setBounds(new java.awt.Rectangle(100, 150, 550, 500));
            stockTablePanel.setViewportView(stocksTable);
            this.add(stockTablePanel);
            rs.close();
            this.repaint();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stocksTable;
}
