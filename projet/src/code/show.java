package code;

import javax.swing.*;

import database.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class show extends JFrame {

    private static void show(String sh, JPanel panel1) {
        try {
            Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tab WHERE club = ? OR special = ?");
            statement.setString(1, sh);
            statement.setString(2, sh);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String info = 
                "<html>" +
                    "Nom: " + resultSet.getString("nom")         + "<br>" +
                    "Prenom: " + resultSet.getString("prenom")   + "<br>" +
                    "Club: " + resultSet.getString("club")       + "<br>" +
                    "Special: " + resultSet.getString("special") +
                "</html>";
                JLabel JL_info = new JLabel(info);
                panel1.add(JL_info);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new show());
    }

    public show() {
        // COMPONENTS
        String[] club_box = {" Select a club ", "imc", "sas", "lib"};
        JComboBox JCB_club = new JComboBox(club_box);

        String[] special_box = {" Select a speciality ", "math", "info", "science", "lettre", "eco"};
        JComboBox JCB_special = new JComboBox(special_box);

        JButton JB_club = new JButton("club : search");
        JButton JB_special = new JButton("specialite : search");
        JButton JB_return = new JButton("return");

        // FRAME
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 240);
        setResizable(false);

        // LAYOUT
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(JCB_club);
        panel.add(JB_club);
        panel.add(JCB_special);
        panel.add(JB_special);
        panel.add(JB_return);

        setContentPane(panel);

        // EVENTS
        JPanel panel1 = new JPanel();
        panel.add(panel1);

        JB_club.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                String sh = (String) JCB_club.getSelectedItem();
                show(sh, panel1);
                panel1.revalidate();
                panel1.repaint();
            }
        });

        JB_special.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                String sh = (String) JCB_special.getSelectedItem();
                show(sh, panel1);
                panel1.revalidate();
                panel1.repaint();
            }
        });

        JB_return.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controle.main(new String[] {});
                dispose();
            }
        });

        setVisible(true);
    }
}
