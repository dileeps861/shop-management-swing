import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
public class ShowOrders extends javax.swing.JFrame {

    DefaultTableModel dt;

    public ShowOrders() {

        dt = new DefaultTableModel();
        dt.addColumn("Order Id");
        dt.addColumn("Customer Name");
        dt.addColumn("Customer Phone");
        dt.addColumn("Customer Address");
        dt.addColumn("Total Amount");
        dt.addColumn("Ordered Items");
        dt.addColumn("Order Date");


        try
        {
            DBConnect x = new DBConnect();
            String sql =
                    "select o.order_id, c.customer_name, c.phone_number, c.address, o.order_total, sum(oi.qty) qty,  o.order_date\n" +
                            "from orders o, invoice i, order_items oi, customer c  where oi.order_id = o.order_id\n" +
                            "and i.order_id = o.order_id and c.customer_id = i.customer_id group by " +
                            "o.order_id, c.customer_name, c.phone_number, c.address, o.order_total order by  o.order_id";
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
            this.setTitle("Order details");
            ordersTable = new javax.swing.JTable();
            ordersTable.setModel(dt);
            JScrollPane orderTablePanel = new JScrollPane();
            orderTablePanel.setBounds(new java.awt.Rectangle(100, 150, 550, 500));
            orderTablePanel.setViewportView(ordersTable);
            this.add(orderTablePanel);
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
    private javax.swing.JTable ordersTable;
}
