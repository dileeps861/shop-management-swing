import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class FindOrder extends javax.swing.JFrame {

    DefaultTableModel dt;

    public FindOrder() {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(new java.awt.Rectangle(100, 200, 550, 500));
        this.setMinimumSize(new Dimension(550, 500));
        this.setTitle("Searched Order Details");
        this.setVisible(false);
        try {
            DBConnect x = new DBConnect();
            String customerName = JOptionPane.showInputDialog(this, "Please provide the customer name.");
            String sql =
                    "select  i.order_id, i.customer_id, c.customer_name, c.phone_number, c.address" +
                            " from invoice i, customer c where c.customer_id = i.customer_id and lower(customer_name) like lower('%" + customerName + "%')";

            ResultSet rs = x.queryReturner(sql);
            int orderId;
            boolean foundOrder = false;
            JScrollPane dtPanel = new JScrollPane();
            JPanel panel = new JPanel();
            dtPanel.setBounds(new java.awt.Rectangle(100, 150, 550, 500));

            int ordersCount = 0;
            while (rs.next()) {
                ordersCount++;
                foundOrder = true;
                orderId = Integer.parseInt(rs.getString(1));
                int custId = Integer.parseInt(rs.getString(2));
                sql =
                        "select p.category, p.pname, p.model,p.company, oi.qty, oi.item_total\n" +
                                "  from productmaster p, order_items oi where oi.product_id = p.product_id\n" +
                                "and oi.order_id = " + orderId + "   order by p.category, p.pname";

                ResultSet rsOrderItem = x.queryReturner(sql);


                dt = new DefaultTableModel();
                dt.addColumn("Category");
                dt.addColumn("Item Name");
                dt.addColumn("Item Make");
                dt.addColumn("Item Company");
                dt.addColumn("Item Quantity");
                dt.addColumn("Item Total");


                while (rsOrderItem.next()) {

                    dt.addRow(
                            new Object[]{
                                    rsOrderItem.getString(1),
                                    rsOrderItem.getString(2),
                                    rsOrderItem.getString(3),
                                    rsOrderItem.getString(4),
                                    rsOrderItem.getString(5)
                            });

                }
                rsOrderItem.close();

                JLabel orderDetailLabel = new JLabel("Order Id: " + rs.getString(1));
                orderDetailLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
                orderDetailLabel.setForeground(new java.awt.Color(183, 10, 189));
                JLabel customerNameLabel = new JLabel("Customer Name: " + rs.getString(3));
                JLabel customerPhoneLabel = new JLabel("Customer Phone: " + rs.getString(4));
                JLabel customerAddressLabel = new JLabel("Customer Address: " + rs.getString(5));

                JPanel customerPanel = new JPanel(new GridLayout(2, 2));
                customerPanel.add(orderDetailLabel);
                customerPanel.add(customerNameLabel);
                customerPanel.add(customerPhoneLabel);
                customerPanel.add(customerAddressLabel);

                customerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                dt.setColumnIdentifiers(
                        new Object[]{"Category", "Item Name", "Item Make", "Item Company", "Item Quantity", "Item Total"});

                JTable dtTable = new JTable(dt);
                JPanel panelOneItem = new JPanel();
                panelOneItem.setBorder(new BevelBorder(BevelBorder.RAISED));
                panelOneItem.setLayout(new GridLayout((2), 1));
                panelOneItem.add(customerPanel);
                panelOneItem.add(dtTable);
                panel.add(panelOneItem);
            }
            if (!foundOrder) {
                JOptionPane.showMessageDialog(this, "No matching order found.");
                return;
            }

            panel.setLayout(new GridLayout((ordersCount), 1));
            dtPanel.setViewportView(panel);
            this.add(dtPanel);
            rs.close();
            this.setVisible(true);
            this.repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

}
