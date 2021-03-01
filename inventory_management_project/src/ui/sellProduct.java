package ui;

import dao.SoldProductDAO;
import dto.SoldProductDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class sellProduct extends JFrame{
    private JPanel sellPanel;
    private JTextField prid;
    private JTextField cuid;
    private JTextField soda;
    private JButton sellProductButton;
    SoldProductDAO soldpr = new SoldProductDAO();

    public sellProduct() {
        add(sellPanel);
        setSize(400, 400);
        setTitle("Sell Product");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sellProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long prodid = (Long.valueOf(prid.getText()));
                Long curid = (Long.valueOf(cuid.getText()));

                SoldProductDTO soldPro = new SoldProductDTO();
                soldPro.setProduct_id(prodid);
                soldPro.setCustomer_id(curid);
                soldPro.setSold_date(new Date());

                soldpr.insert(soldPro);
                JOptionPane.showMessageDialog(null,
                        "The product selled succesfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
