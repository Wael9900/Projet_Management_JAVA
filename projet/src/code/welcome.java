package code;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import database.*;


public class welcome extends JFrame  {

        
    
    public static void main(String[] args) {
        //COMPONENTS
        JLabel lab = new JLabel ("Welcome to this management site");
        JButton JB_admin = new JButton ("Admin");
        JButton JB_user = new JButton ("User");

        //FRAME
        JFrame frame = new JFrame("WELCOME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 240);

        //LAYOUT
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(lab,BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(JB_admin);
        centerPanel.add(JB_user);
        panel.add(centerPanel,BorderLayout.CENTER);
        frame.setContentPane(panel);

        //EVENTS
        JB_admin.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                admin.main(new String[] {});
                frame.dispose();
                                                        }
                                                        }
                                  );

        JB_user.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                user.main(new String[] {});
                frame.dispose();
                                                        }
                                                        }                        
                                 );

        frame.setVisible(true);
    
}


}