package code;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import database.*;


public class controle extends JFrame  {

        
    
    public static void main(String[] args) {
        //COMPONENTS
        JButton JB_show = new JButton ("show DATA");
        JButton JB_modifier = new JButton ("modify user");
        JButton JB_add = new JButton ("add user");
        JButton JB_return = new JButton ("return");

        //FRAME
        JFrame frame = new JFrame("CONTROL PANEL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 240);

        //LAYOUT
        JPanel panel = new JPanel(new GridLayout (0 , 1));

        panel.add(JB_show);
        panel.add(JB_modifier);
        panel.add(JB_add);
        panel.add(JB_return);


        frame.setContentPane(panel);

        //EVENTS
        
        JB_show.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                    show.main(new String[] {});
                    frame.dispose();
                                                            }
                                                            }                  
                                     );

        JB_modifier.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                select_email.main(new String[] {"controle"});
                frame.dispose();
                                                        }
                                                        }                        
                                 );
                     
        JB_add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                inscription.main(new String[] {"controle"});
                frame.dispose();
                                                    }
                                                    }                        
                            );

        JB_return.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                admin.main(new String[] {});
                frame.dispose();
                                                        }
                                                        }                        
                                );


                        
        frame.setVisible(true);
    
}


}