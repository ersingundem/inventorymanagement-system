package ui;

import javax.swing.*;

import dao.ProductDAO;
import dto.ProductDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addProduct extends JFrame{
    ProductDAO pr1 = new ProductDAO();
    private JPanel addPanel;
    private JButton addProductButton;
    private JTextField price;
    private JTextField stock;
    private JTextField titlefield;

    public addProduct() {
        add(addPanel);
        setSize(400, 400);
        setTitle("Add Product");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int stockb = (Integer.valueOf(stock.getText()));
                double priceb = (Double.valueOf(price.getText()));
                String titleb = titlefield.getText();

                ProductDTO pr = new ProductDTO();
                pr.setTitle(titleb);
                pr.setPrice(priceb);
                pr.setStock(stockb);
                pr1.insert(pr);

                JOptionPane.showMessageDialog(null,
                        "The product added succesfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }

}
