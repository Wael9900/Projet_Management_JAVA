package code;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import database.*;


public class select_email extends JFrame  {

        
    
    public static void main(String[] args) {
        //COMPONENTS
        JLabel JL_email = new JLabel ("select an exiting email ");

        JTextField JTF_email = new JTextField(30);

        JButton JB_search = new JButton ("search");
        JButton JB_return = new JButton ("return");

        //FRAME
        JFrame frame = new JFrame("USER LOGIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 240);

        //LAYOUT
        JPanel panel = new JPanel(new GridLayout (0 , 2));

        panel.add(JL_email);
        panel.add(JTF_email);

        panel.add(JB_search);
        panel.add(JB_return);


        frame.setContentPane(panel);

        //EVENTS
        
        JB_search.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // SAISIE TAKEN
                String email =  JTF_email.getText();

                //DATABASE
                try{
                    Connection connection = database.getConnection();
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM tab WHERE email = ?");
                    statement.setString(1, email);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()){
                        JOptionPane.showMessageDialog(frame,"login successfull");
                        modification.main(new String[] {"select_email",email});//  RETURNNNNNNNNNNNNNNNNNNNNNNNN
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
        } );


        JB_return.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                controle.main(new String[] {});
                frame.dispose();
                                                        }
        });


                        
        frame.setVisible(true);
    
}


}