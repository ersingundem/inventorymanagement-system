package ui;

import dao.ProductDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteProduct extends JFrame{
    ProductDAO pr2 = new ProductDAO();
    private JPanel deletePanel;
    private JTextField pid;
    private JButton deleteProductButton;

    public deleteProduct() {
        add(deletePanel);
        setSize(400, 400);
        setTitle("Delete Product");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long longid = Long.valueOf(pid.getText());
                pr2.delete(longid);
                JOptionPane.showMessageDialog(null,
                        "The product deleted succesfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
