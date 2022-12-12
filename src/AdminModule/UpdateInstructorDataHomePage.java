package AdminModule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateInstructorDataHomePage extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateInstructorDataHome needs
    JButton updatePassword = new JButton("update password");
    JButton updateAddress = new JButton("update address");
    JButton updateEmail = new JButton("update email");
    JButton updatePhone = new JButton("update phone");
    JButton updateCourseID = new JButton("update courseID");
    JButton updateAllInstructorData = new JButton("update all Instructor data");
    JButton backToAdminHome = new JButton("Back");

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    public UpdateInstructorDataHomePage() {
        /////////////////////////////////////////////////////////////////////////UpdateInstructorDataHome content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(updatePassword);
        this.add(updateAddress);
        this.add(updateEmail);
        this.add(updatePhone);
        this.add(updateCourseID);
        this.add(updateAllInstructorData);
        this.add(backToAdminHome);

        updatePassword.setFont(new Font("", Font.ITALIC, 25));
        updateAddress.setFont(new Font("", Font.ITALIC, 25));
        updateEmail.setFont(new Font("", Font.ITALIC, 25));
        updatePhone.setFont(new Font("", Font.ITALIC, 25));
        updateCourseID.setFont(new Font("", Font.ITALIC, 25));
        updateAllInstructorData.setFont(new Font("", Font.ITALIC, 25));
        backToAdminHome.setFont(new Font("", Font.ITALIC, 25));

        updatePassword.setBounds(225, 90, 250, 50);
        updatePhone.setBounds(25, 230, 220, 50);
        updateEmail.setBounds(250, 230, 220, 50);
        updateAddress.setBounds(475, 230, 220, 50);
        updateCourseID.setBounds(225, 370, 250, 50);
        updateAllInstructorData.setBounds(175, 510, 350, 50);
        backToAdminHome.setBounds(0, 560, 150, 50);

        updatePassword.setBackground(new Color(33, 33, 33));
        updateAddress.setBackground(new Color(33, 33, 33));
        updateEmail.setBackground(new Color(33, 33, 33));
        updatePhone.setBackground(new Color(33, 33, 33));
        updateCourseID.setBackground(new Color(33, 33, 33));
        updateAllInstructorData.setBackground(new Color(33, 33, 33));
        backToAdminHome.setBackground(new Color(251, 172, 35));

        updatePassword.setForeground(new Color(255, 255, 255));
        updateAddress.setForeground(new Color(255, 255, 255));
        updateEmail.setForeground(new Color(255, 255, 255));
        updatePhone.setForeground(new Color(255, 255, 255));
        updateCourseID.setForeground(new Color(255, 255, 255));
        updateAllInstructorData.setForeground(new Color(255, 255, 255));
        backToAdminHome.setForeground(new Color(255, 255, 255));

        updatePassword.addActionListener(click);
        updateAddress.addActionListener(click);
        updateEmail.addActionListener(click);
        updatePhone.addActionListener(click);
        updateCourseID.addActionListener(click);
        updateAllInstructorData.addActionListener(click);
        backToAdminHome.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("update Instructor home page");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////UpdateInstructorDataHome PAGE BUTTONS
            removeAll();
            revalidate();
            repaint();
            if (e.getSource() == updatePassword) {
                UpdateInstructorPassword up = new UpdateInstructorPassword();
                UpdateInstructorDataHomePage.this.add(up);
            }
            if (e.getSource() == updateAddress) {
                UpdateInstructorAddress usa = new UpdateInstructorAddress();
                UpdateInstructorDataHomePage.this.add(usa);
            }
            if (e.getSource() == updateEmail) {
                UpdateInstructorEmail use = new UpdateInstructorEmail();
                UpdateInstructorDataHomePage.this.add(use);
            }
            if (e.getSource() == updatePhone) {
                UpdateInstructorPhone usp = new UpdateInstructorPhone();
                UpdateInstructorDataHomePage.this.add(usp);
            }
            if (e.getSource() == updateCourseID) {
                UpdateInstructorCourseID usp = new UpdateInstructorCourseID();
                UpdateInstructorDataHomePage.this.add(usp);
            }
            if (e.getSource() == updateAllInstructorData) {
                UpdateInstructorAllData usad = new UpdateInstructorAllData();
                UpdateInstructorDataHomePage.this.add(usad);
            }
            if (e.getSource() == backToAdminHome) {
                AdminHomePage ahp = new AdminHomePage();
                UpdateInstructorDataHomePage.this.add(ahp);
            }
        }

    }

}
