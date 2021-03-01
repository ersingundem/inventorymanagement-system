package ui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class login extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;





    public login() {
        add(panel1);
        setSize(400, 400);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String user_name;

                char[] input = passwordField1.getPassword();
                String passString = new String(input);
                user_name = textField1.getText();

                if (user_name.equals("Admin")){
                   if(passString.equals ("1")){

                        homepage h = new homepage();
                        h.setVisible(true);

                   }
                   else {
                       JOptionPane.showMessageDialog(null,
                               "Password Incorrect!!.",
                               "Warning",
                               JOptionPane.INFORMATION_MESSAGE);
                                textField1.setText("");
                                passwordField1.setText("");
                                textField1.requestFocus();
                   }
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "User Name Incorrect!!.",
                            "Warning",
                            JOptionPane.INFORMATION_MESSAGE);
                            textField1.setText("");
                            passwordField1.setText("");
                            textField1.requestFocus();
                }

            }
        });
    }

}