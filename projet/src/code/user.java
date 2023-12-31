package code;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import database.*;



public class user extends JFrame  {

        
    
    public static void main(String[] args) {
        //COMPONENTS
        JLabel JL_email = new JLabel ("email ");
        JLabel JL_pswd = new JLabel ("password");

        JTextField JTF_email = new JTextField(30);
        JTextField JTF_pswd = new JTextField(30);

        JButton JB_login = new JButton ("login");
        JButton JB_sign = new JButton ("sign up");
        JButton JB_return = new JButton ("return");

        //FRAME
        JFrame frame = new JFrame("USER LOGIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 240);

        //LAYOUT
        JPanel panel = new JPanel(new GridLayout (0 , 2));

        panel.add(JL_email);
        panel.add(JTF_email);
        panel.add(JL_pswd);
        panel.add(JTF_pswd);
        panel.add(JB_login);
    
        panel.add(JB_sign);
        panel.add(JB_return);



        frame.setContentPane(panel);

        //EVENTS
        
        JB_login.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // SAISIE TAKEN
                String email =  JTF_email.getText();
                String pswd =  new String (JTF_pswd.getText());

                //DATABASE
                try{
                    Connection connection = database.getConnection();
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM tab WHERE email = ? AND pswd = ?");
                    statement.setString(1, email);
                    statement.setString(2, pswd);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()){
                        JOptionPane.showMessageDialog(frame,"login successfull");
                        modification.main(new String[] {"user",email});//  RETURNNNNNNNNNNNNNNNNNNNNNNNN
                        frame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,"please try again");
                    }
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                
                                                        }
                                                        }
                                  );

        JB_sign.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                inscription.main(new String[] {"user"});
                frame.dispose();
                                                        }
                                                        }                        
                                 );

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