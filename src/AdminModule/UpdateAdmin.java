package AdminModule;

import InstructorModule.INstructor;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateAdmin extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateAdmin needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel passwordLabel = new JLabel("New password: ");
    JTextField ssnField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton updateAAdminButton = new JButton("Update!");
    JButton backToUpdateStudentHome = new JButton("Back");
    String SSN, password;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    UpdateAdmin() {
        /////////////////////////////////////////////////////////////////////////UpdateAdmin panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(ssnLabel);
        this.add(passwordLabel);
        this.add(ssnField);
        this.add(passwordField);
        this.add(updateAAdminButton);
        this.add(backToUpdateStudentHome);

        ssnLabel.setFont(new Font("", Font.ITALIC, 25));
        passwordLabel.setFont(new Font("", Font.ITALIC, 25));
        ssnField.setFont(new Font("", Font.PLAIN, 20));
        passwordField.setFont(new Font("", Font.PLAIN, 20));
        updateAAdminButton.setFont(new Font("", Font.ITALIC, 25));
        backToUpdateStudentHome.setFont(new Font("", Font.ITALIC, 25));

        ssnLabel.setBounds(200, 200, 170, 30);
        passwordLabel.setBounds(200, 300, 200, 30);
        ssnField.setBounds(380, 200, 170, 30);
        passwordField.setBounds(380, 300, 170, 30);
        updateAAdminButton.setBounds(300, 400, 150, 50);
        backToUpdateStudentHome.setBounds(0, 560, 150, 50);

        updateAAdminButton.setBackground(new Color(251, 172, 35));
        updateAAdminButton.setForeground(new Color(255, 255, 255));
        backToUpdateStudentHome.setBackground(new Color(251, 172, 35));
        backToUpdateStudentHome.setForeground(new Color(255, 255, 255));

        updateAAdminButton.addActionListener(click);
        backToUpdateStudentHome.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("Update admin");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////UpdateAdmin PAGE BUTTONS
            if (e.getSource() == updateAAdminButton) {
                SSN = ssnField.getText().toString();
                password = passwordField.getText().toString();
                try {
                    md.updatePassword(SSN, password);
                    ssnField.setText("");
                    passwordField.setText("");
                    if (md.isDone()) {
                        UpdateAdmin.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        UpdateAdmin.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToUpdateStudentHome) {
                UpdateAdmin.this.removeAll();
                revalidate();
                repaint();
                AdminHomePage ahp = new AdminHomePage();
                UpdateAdmin.this.add(ahp);
            }
        }
    }
}
