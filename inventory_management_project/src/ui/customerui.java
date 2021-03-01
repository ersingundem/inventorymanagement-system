package ui;

import java.awt.BorderLayout;
import java.util.List;
import dao.CustomerDAO;
import dto.CustomerDTO;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class customerui extends JDialog  {
    private static final long serialVersionUID = 1L;

    public void listCustomer() {
        JPanel customerPanel = customerm();

        add(customerPanel);
        setTitle("Customer List");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setResizable(true);
        setVisible(true);

        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

    }

    private JPanel customerPanel;
    private JScrollPane scrollpane1;
    private JTable customertable;


    public JPanel customerm() {
        JPanel customerPanel = new JPanel();
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer List"));
        add(customerPanel);
        setSize(400, 400);
        setTitle("Customer List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        CustomerDAO connect = new CustomerDAO();
        List<CustomerDTO> dList = connect.getCustomer();

        DefaultTableModel clist = new DefaultTableModel();
        JTable customertable = new JTable(clist);
        customertable.setAutoCreateRowSorter(true);
        JScrollPane scrollpane = new JScrollPane(customertable);
        clist.addColumn("ID");
        clist.addColumn("First Name");
        clist.addColumn("Last Name");
        clist.addColumn("Email");
        clist.addColumn("Adress");
        clist.addColumn("Birth Date");
        clist.addColumn("Phone");

        for (CustomerDTO customer : dList) {
            clist.addRow(customer.getObjects());
        }
        customerPanel.add(scrollpane, BorderLayout.CENTER);
        return customerPanel;

    }

}