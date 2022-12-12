package AdminModule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AddAdmin extends JPanel {

    /////////////////////////////////////////////////////////////////////////////AddAdmin needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel userNameLabel = new JLabel("user name: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField ssnField = new JTextField();
    JTextField userNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton addAdminButton = new JButton("Add admin!");
    JButton backToAdminHome = new JButton("Back");
    String ssn, username, password;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    public AddAdmin() {
        /////////////////////////////////////////////////////////////////////////AddAdmin panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(ssnLabel);
        this.add(userNameLabel);
        this.add(passwordLabel);
        this.add(ssnField);
        this.add(userNameField);
        this.add(passwordField);
        this.add(addAdminButton);
        this.add(backToAdminHome);

        ssnLabel.setFont(new Font("", Font.ITALIC, 25));
        userNameLabel.setFont(new Font("", Font.ITALIC, 25));
        passwordLabel.setFont(new Font("", Font.ITALIC, 25));
        ssnField.setFont(new Font("", Font.PLAIN, 20));
        userNameField.setFont(new Font("", Font.PLAIN, 20));
        passwordField.setFont(new Font("", Font.PLAIN, 20));
        addAdminButton.setFont(new Font("", Font.ITALIC, 25));
        backToAdminHome.setFont(new Font("", Font.ITALIC, 25));

        ssnLabel.setBounds(185, 100, 150, 30);
        userNameLabel.setBounds(185, 200, 150, 30);
        passwordLabel.setBounds(185, 300, 150, 30);
        ssnField.setBounds(345, 100, 170, 30);
        userNameField.setBounds(345, 200, 170, 30);
        passwordField.setBounds(345, 300, 170, 30);
        addAdminButton.setBounds(250, 400, 200, 50);
        backToAdminHome.setBounds(0, 560, 150, 50);

        addAdminButton.setBackground(new Color(251, 172, 35));
        addAdminButton.setForeground(new Color(255, 255, 255));
        backToAdminHome.setBackground(new Color(251, 172, 35));
        backToAdminHome.setForeground(new Color(255, 255, 255));

        addAdminButton.addActionListener(click);
        backToAdminHome.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("add admin");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////AddAdmin PAGE BUTTONS
            if (e.getSource() == addAdminButton) {
                ssn = ssnField.getText().toString();
                username = userNameField.getText().toString();
                password = passwordField.getText().toString();

                try {
                    ssnField.setText("");
                    userNameField.setText("");
                    passwordField.setText("");
                    md.addUser(ssn, username, password);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (md.isDone()) {
                    AddAdmin.this.removeAll();
                    revalidate();
                    repaint();
                    AdminHomePage adminHomePanel = new AdminHomePage();
                    AddAdmin.this.add(adminHomePanel);
                }

            }
            if (e.getSource() == backToAdminHome) {
                AddAdmin.this.removeAll();
                revalidate();
                repaint();
                AdminHomePage ahp = new AdminHomePage();
                AddAdmin.this.add(ahp);
            }
        }
    }

}
