package code;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ResourceBundle.Control;
import java.awt.event.*;

import database.*;


public class admin extends JFrame  {

        
    
    public static void main(String[] args) {
        //COMPONENTS
        JLabel JL_email = new JLabel ("email ");
        JLabel JL_pswd = new JLabel ("password");

        JTextField JTF_email = new JTextField(30);
        JTextField JTF_pswd = new JTextField(30);

        JButton JB_login = new JButton ("login");
        JButton JB_return = new JButton ("return");

        //FRAME
        JFrame frame = new JFrame("WELCOME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 240);

        //LAYOUT
        JPanel panel = new JPanel(new GridLayout (0 , 2));

        panel.add(JL_email);
        panel.add(JTF_email);
        panel.add(JL_pswd);
        panel.add(JTF_pswd);
        panel.add(JB_login);
        panel.add(JB_return);



        frame.setContentPane(panel);

        //EVENTS
        
        JB_login.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // SAISIE TAKEN
                String email =  JTF_email.getText();
                String pswd =  new String (JTF_pswd.getText());

                //VERIFICATION
                    if (email.equals("admin@gmail.com") && pswd.equals("0000")){
                        controle.main(new String[] {});
                        frame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,"please try again");
                    }
                
                                                        }
                                                        
                                                    });

        JB_return.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                welcome.main(new String[] {});
                frame.dispose();
                                                        }
                                                        }                        
                                );


                                                                  
        frame.setVisible(true);
    
}


}