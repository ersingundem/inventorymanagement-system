package ui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;


import dao.SoldProductDAO;

import dto.SoldProductDTO;


import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class soldProduct extends JDialog{
    private static final long serialVersionUID = 1L;
    public void listSoldProduct() {
        JPanel panel2 = soldm();

        add(panel2);
        setTitle("Sold Product List");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setResizable(true);
        setVisible(true);

        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

    }
    private JPanel soldPanel;
    private JScrollPane soldpane;
    private JTable soldtable;


    public JPanel soldm() {
        JPanel soldPanel = new JPanel();
        soldPanel.setBorder(BorderFactory.createTitledBorder("Sold Product List"));
        add(soldPanel);
        setSize(400, 400);
        setTitle("Sold Product List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        SoldProductDAO connect = new SoldProductDAO();
        List<SoldProductDTO> aList = connect.getSoldProduct();

        DefaultTableModel alist = new DefaultTableModel();
        JTable soldtable = new JTable(alist);
        soldtable.setAutoCreateRowSorter(true);
        JScrollPane soldpane = new JScrollPane(soldtable);
        alist.addColumn("ID");
        alist.addColumn("Product ID");
        alist.addColumn("Customer ID");
        alist.addColumn("Sold Date");

        for (SoldProductDTO urun : aList) {
            alist.addRow(urun.getObjects());
        }
        soldPanel.add(soldpane, BorderLayout.CENTER);
        return soldPanel;

    }
}
