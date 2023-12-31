package code;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import database.*;


public class modification extends JFrame  {

        public static void getData (String email,JTextField nom, JTextField prenom, JComboBox club , JComboBox special){
            
            try{
                Connection connection = database.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT nom , prenom , club , special FROM tab WHERE email=?");
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    nom.setText(resultSet.getString("nom"));
                    prenom.setText(resultSet.getString("prenom"));
        
                    club.setSelectedItem(resultSet.getString("club").trim());
                    special.setSelectedItem(resultSet.getString("special").trim());
                }
                
            
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
              }
        }
        
    
    public static void main(String[] args) {

         //FRAME
         JFrame frame = new JFrame("PERSONAL DATA");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(400, 240);
 
        
         JPanel panel = new JPanel(new GridLayout (0 , 2));
         
         
        //COMPONENTS

        JLabel JL_nom = new JLabel ("nom ");
        JLabel JL_prenom = new JLabel ("prenom");
        JLabel JL_club = new JLabel ("club ");
        JLabel JL_special = new JLabel ("spécialité");
        
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
        //JButton JB_suprm = new JButton ("delete_account");  // verification optionpanel
        JButton JB_return = new JButton ("return");
         
        //LAYOUT
        

         
        // VALEUR RETRUN
        String RTN = args[0];
        String EML =args[1];

        getData ( EML,JTF_nom, JTF_prenom, JCB_club , JCB_special);

        //A PARTIE DE CONTROLE
        /*if (RTN.equals("controle")){
            JLabel JL_email = new JLabel ("email ");
            panel.add(JL_email);
        
            String[] email_box = new String[100];
            email_box[0]=" Select a speciality " ;

            try{
                Connection connection = database.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT email FROM tab");
                ResultSet resultSet = statement.executeQuery();

                int index = 1; 
                while (resultSet.next() && index < email_box.length) {
                    String value = resultSet.getString("email");
                    email_box[index] = value;
                    index++;
                }
            
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
              }
            
            final  JComboBox<String> JCB_email = new JComboBox<>(email_box);
            panel.add(JCB_email);
        }
*/
                


                

       
        panel.add(JL_nom);
        panel.add(JTF_nom);
        panel.add(JL_prenom);
        panel.add(JTF_prenom);
        panel.add(JL_club);
        panel.add(JCB_club);
        panel.add(JL_special);
        panel.add(JCB_special);
    
    
        panel.add(JB_enrg);
        //panel.add(JB_suprm);
        panel.add(JB_return);

        frame.setContentPane(panel);
      
        //EVENTS
        
        
        
       /* JCB_email.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the JComboBox
                String selectedItem= (String) JCB_email.getSelectedItem();


                if (!"Select a speciality".equals(selectedItem)) {
                    // Call the getData method with the selected item
                    getData(selectedItem.toString(), JTF_nom, JTF_prenom, JCB_club, JCB_special);
                }
            }
        });*/
        

        JB_enrg.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // SAISIE TAKEN
               
                String nom =  JTF_nom.getText();
                String prenom =  JTF_prenom.getText();
                String club = (String) JCB_club.getSelectedItem();
                String special =  (String) JCB_special.getSelectedItem();

                //DATABASE
                try{
                    Connection connection = database.getConnection();
                    PreparedStatement statement = connection.prepareStatement("UPDATE tab SET nom = ?, prenom = ? , club = ?, special = ? WHERE email = ?");
                    statement.setString(1, nom);
                    statement.setString(2, prenom);
                    statement.setString(3, club);
                    statement.setString(4, special);
                    statement.setString(5, EML);
                    int resultSet = statement.executeUpdate();

                    
                
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(frame,"user UPDATED");

            }
        });
        


        /*JB_suprm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
        
                //DATABASE
                try{ 
                    Connection connection = database.getConnection();
                
                    PreparedStatement statement = connection.prepareStatement("DELETE FROM your_table WHERE email = ?");
                
                    statement.setString(1, EML);
                    
                    statement.executeUpdate();
                    System.out.println("hiiiiiiiiiiiiiiii");

                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


                if (RTN.equals("select_email")){
                    select_email.main(new String[] {});
                    frame.dispose();
                }

                else {
                    user.main(new String[] {});
                    frame.dispose();
                }
            }
        });
                        
                */  
       
        JB_return.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (RTN.equals("select_email")){
                    select_email.main(new String[] {});
                    frame.dispose();
                }

                else {
                    user.main(new String[] {});
                    frame.dispose();
                }
                
            }
        });


                
        frame.setVisible(true);
    
    }


}