package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class productOperations extends JFrame{
    private JPanel producto;
    private JButton addProductButton;
    private JButton deleteProductButton;
    private JButton updateProductButton;
    private JButton sellProductButton;

    public productOperations() {
        add(producto);
        setSize(400, 400);
        setTitle("Product Operations");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct add = new addProduct();
                add.setVisible(true);
            }
        });
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProduct delete = new deleteProduct();
                delete.setVisible(true);
            }
        });
        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProduct update = new updateProduct();
                update.setVisible(true);
            }
        });
        sellProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellProduct sell = new sellProduct();
                sell.setVisible(true);
            }
        });
    }

}




