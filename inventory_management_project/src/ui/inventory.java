package ui;

import java.awt.BorderLayout;
import java.util.List;
import dao.ProductDAO;
import dto.ProductDTO;


import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class inventory extends JDialog  {
    private static final long serialVersionUID = 1L;

    public void listProduct() {
        JPanel panel2 = inventorym();

        add(panel2);
        setTitle("Inventory");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setResizable(true);
        setVisible(true);

        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

    }

    private JPanel panel2;
    private JScrollPane scrollpane;
    private JTable table;



    public JPanel inventorym() {
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder("Product List"));
        add(panel2);
        setSize(400, 400);
        setTitle("Inventory");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



                ProductDAO connect = new ProductDAO();
                List<ProductDTO> uList = connect.getProduct();

                DefaultTableModel plist = new DefaultTableModel();
                JTable table = new JTable(plist);
                table.setAutoCreateRowSorter(true);
                JScrollPane scrollpane = new JScrollPane(table);
                plist.addColumn("ID");
                plist.addColumn("Title");
                plist.addColumn("Price");
                plist.addColumn("Stock");

                for (ProductDTO urun : uList) {
                    plist.addRow(urun.getObjects());
                }
                panel2.add(scrollpane, BorderLayout.CENTER);
        return panel2;

            }

}