package ui;

import dao.ProductDAO;
import dto.ProductDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateProduct extends JFrame{
    ProductDAO pr4 = new ProductDAO();
    private JPanel updatePanel;
    private JTextField prid;
    private JTextField prtitle;
    private JTextField prprice;
    private JTextField prstock;
    private JButton updateProductButton;

    public updateProduct() {
        add(updatePanel);
        setSize(400, 400);
        setTitle("Update Product");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long longid = Long.valueOf(prid.getText());
                int stockb = (Integer.valueOf(prstock.getText()));
                double priceb = (Double.valueOf(prprice.getText()));
                String titleb = prtitle.getText();
                ProductDTO pr3 = new ProductDTO();
                pr3.setId(longid);
                pr3.setTitle(titleb);
                pr3.setPrice(priceb);
                pr3.setStock(stockb);
                pr4.update(pr3);
                JOptionPane.showMessageDialog(null,
                        "The product updated succesfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
