package code;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import database.*;


public class inscription extends JFrame  {

        
    
    public static void main(String[] args) {
        // VALEUR RETRUN
        String RTN = args[0];
        //COMPONENTS
        JLabel JL_email = new JLabel ("email ");
        JLabel JL_pswd = new JLabel ("password");
        JLabel JL_nom = new JLabel ("nom ");
        JLabel JL_prenom = new JLabel ("prenom");
        JLabel JL_club = new JLabel ("club ");
        JLabel JL_special = new JLabel ("spécialité");

        JTextField JTF_email = new JTextField(30);
        JTextField JTF_pswd = new JTextField(30);
        JTextField JTF_nom = new JTextField(30);
        JTextField JTF_prenom = new JTextField(30);

        String[] club_box = {
            " Select a club ",
            "imc",
            "sas",
            "lib",   };
        JComboBox JCB_club = new JComboBox(club_box);

        String[] special_box = {
            " Select a speciality ",
            "math",
            "info",
            "science",
            "lettre",
            "eco",     };
        JComboBox JCB_special = new JComboBox(special_box);


        JButton JB_enrg = new JButton ("enregistrer");
        JButton JB_return = new JButton ("return");

        //FRAME
        JFrame frame = new JFrame("INSCRIPTION");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 240);

        //LAYOUT
        JPanel panel = new JPanel(new GridLayout (0 , 2));

        panel.add(JL_email);
        panel.add(JTF_email);
        panel.add(JL_pswd);
        panel.add(JTF_pswd);
        panel.add(JL_nom);
        panel.add(JTF_nom);
        panel.add(JL_prenom);
        panel.add(JTF_prenom);
        panel.add(JL_club);
        panel.add(JCB_club);
        panel.add(JL_special);
        panel.add(JCB_special);
    
    
        panel.add(JB_enrg);
        panel.add(JB_return);

        frame.setContentPane(panel);
      
        //EVENTS
        
        JB_enrg.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // SAISIE TAKEN
                String email =  JTF_email.getText();
                String pswd =  new String (JTF_pswd.getText());
                String nom =  JTF_nom.getText();
                String prenom =  JTF_prenom.getText();
                String club = (String) JCB_club.getSelectedItem();
                String special =  (String) JCB_special.getSelectedItem();

                //DATABASE
                
                try{

                    Connection connection = database.getConnection();
                    PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM tab WHERE email = ?");
                    statement1.setString(1, email); 
                    ResultSet resultSet1 = statement1.executeQuery();

                    boolean test = resultSet1.next();
                    if(test ==false && pswd!="" && nom!="" && prenom!=""  && pswd!="" && club!=" Select a club " && special!=" Select a speciality "){
                        PreparedStatement statement = connection.prepareStatement("INSERT INTO tab (email,pswd, nom,prenom,club,special) VALUES (?,?,?,?,?,?)");
                        statement.setString(1, email);
                        statement.setString(2, pswd);
                        statement.setString(3, nom);
                        statement.setString(4, prenom);
                        statement.setString(5, club);
                        statement.setString(6, special);
                        statement.executeUpdate();

                        JOptionPane.showMessageDialog(frame,"inscription successful" );
                        if (RTN.equals("user")){
                            modification.main(new String[] {"user",email});
                            frame.dispose();
                        }
                        else {
                            modification.main(new String[] {"controle"});
                            frame.dispose();
                        }
                    }else{
                        if (test){
                            JOptionPane.showMessageDialog(frame, "this email is not avaible");
                        }
                        else {
                            JOptionPane.showMessageDialog(frame, "verify your email is correct");
                        }
                    }
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                
            }
       });


        JB_return.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (RTN.equals("user")){
                    user.main(new String[] {});
                    frame.dispose();
                }
                else {
                    controle.main(new String[] {});
                    frame.dispose();
                }
                
                                                        }
                                                        }                        
                                );


                
        frame.setVisible(true);
    
}


}