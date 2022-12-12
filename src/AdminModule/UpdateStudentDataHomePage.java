package AdminModule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateStudentDataHomePage extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateStudentDataHome needs
    JButton updatePassword = new JButton("update password");
    JButton updateAddress = new JButton("update address");
    JButton updateEmail = new JButton("update email");
    JButton updatePhone = new JButton("update phone");
    JButton updateAllStudentData = new JButton("update all student data");
    JButton backToAdminHome = new JButton("Back");

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    public UpdateStudentDataHomePage() {
        /////////////////////////////////////////////////////////////////////////UpdateStudentDataHome content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(updatePassword);
        this.add(updateAddress);
        this.add(updateEmail);
        this.add(updatePhone);
        this.add(updateAllStudentData);
        this.add(backToAdminHome);

        updatePassword.setFont(new Font("", Font.ITALIC, 25));
        updateAddress.setFont(new Font("", Font.ITALIC, 25));
        updateEmail.setFont(new Font("", Font.ITALIC, 25));
        updatePhone.setFont(new Font("", Font.ITALIC, 25));
        updateAllStudentData.setFont(new Font("", Font.ITALIC, 25));
        backToAdminHome.setFont(new Font("", Font.ITALIC, 25));

        updatePassword.setBounds(225, 90, 250, 50);
        updatePhone.setBounds(25, 230, 220, 50);
        updateEmail.setBounds(250, 230, 220, 50);
        updateAddress.setBounds(475, 230, 220, 50);
        updateAllStudentData.setBounds(200, 370, 300, 50);
        backToAdminHome.setBounds(0, 560, 150, 50);

        updatePassword.setBackground(new Color(33, 33, 33));
        updateAddress.setBackground(new Color(33, 33, 33));
        updateEmail.setBackground(new Color(33, 33, 33));
        updatePhone.setBackground(new Color(33, 33, 33));
        updateAllStudentData.setBackground(new Color(33, 33, 33));
        backToAdminHome.setBackground(new Color(251, 172, 35));

        updatePassword.setForeground(new Color(255, 255, 255));
        updateAddress.setForeground(new Color(255, 255, 255));
        updateEmail.setForeground(new Color(255, 255, 255));
        updatePhone.setForeground(new Color(255, 255, 255));
        updateAllStudentData.setForeground(new Color(255, 255, 255));
        backToAdminHome.setForeground(new Color(255, 255, 255));

        updatePassword.addActionListener(click);
        updateAddress.addActionListener(click);
        updateEmail.addActionListener(click);
        updatePhone.addActionListener(click);
        updateAllStudentData.addActionListener(click);
        backToAdminHome.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("update student home page");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////UpdateStudentDataHome PAGE BUTTONS
            removeAll();
            revalidate();
            repaint();
            if (e.getSource() == updatePassword) {
                UpdateStudentPassword up = new UpdateStudentPassword();
                UpdateStudentDataHomePage.this.add(up);
            }
            if (e.getSource() == updateAddress) {
                UpdateStudentAddress usa = new UpdateStudentAddress();
                UpdateStudentDataHomePage.this.add(usa);
            }
            if (e.getSource() == updateEmail) {
                UpdateStudentEmail use = new UpdateStudentEmail();
                UpdateStudentDataHomePage.this.add(use);
            }
            if (e.getSource() == updatePhone) {
                UpdateStudentPhone usp = new UpdateStudentPhone();
                UpdateStudentDataHomePage.this.add(usp);
            }
            if (e.getSource() == updateAllStudentData) {
                UpdateStudentAllData usad = new UpdateStudentAllData();
                UpdateStudentDataHomePage.this.add(usad);
            }
            if (e.getSource() == backToAdminHome) {
                AdminHomePage ahp = new AdminHomePage();
                UpdateStudentDataHomePage.this.add(ahp);
            }
        }

    }

}
