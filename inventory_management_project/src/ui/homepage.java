package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homepage extends JFrame {
    private JPanel homePanel;
    private JButton productListButton;
    private JButton customerListButton;
    private JButton productOperatonsButton;
    private JButton soldProductListButton;

    public homepage() {
        add(homePanel);
        setSize(400, 400);
        setTitle("Homepage");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        productListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory inv = new inventory();
                inv.listProduct();
            }
        });
        customerListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerui cus = new customerui();
                cus.listCustomer();
            }
        });
        productOperatonsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productOperations pro = new productOperations();
                pro.setVisible(true);
            }
        });
        soldProductListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soldProduct sol = new soldProduct();
                sol.listSoldProduct();
            }
        });
    }
}

