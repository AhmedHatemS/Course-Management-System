package AdminModule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AddInstructor extends JPanel {

    /////////////////////////////////////////////////////////////////////////////AddInstructor needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel userNameLabel = new JLabel("user name: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JLabel fNameLabel = new JLabel("First name: ");
    JLabel lNameLabel = new JLabel("last name: ");
    JLabel dobLabel = new JLabel("Date of birth: ");
    JLabel phoneLabel = new JLabel("Phone: ");
    JLabel emailLabel = new JLabel("email: ");
    JLabel addressLabel = new JLabel("Adsress: ");
    JLabel nationalityLabel = new JLabel("nationality: ");
    JLabel courseIDLabel = new JLabel("Course ID: ");
    JTextField ssnField = new JTextField();
    JTextField userNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField fNameField = new JTextField();
    JTextField lNameField = new JTextField();
    JTextField dobField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField nationalityField = new JTextField();
    JTextField courseIDField = new JTextField();
    JButton addInstructorButton = new JButton("Add instructor!");
    JButton backToAdminHome = new JButton("Back");
    String ssn, username, password, fName, lName, dob, phone, email, address, nationality, courseID;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    public AddInstructor() {
        /////////////////////////////////////////////////////////////////////////AddInstructor panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(ssnLabel);
        this.add(userNameLabel);
        this.add(passwordLabel);
        this.add(fNameLabel);
        this.add(lNameLabel);
        this.add(dobLabel);
        this.add(phoneLabel);
        this.add(emailLabel);
        this.add(addressLabel);
        this.add(nationalityLabel);
        this.add(courseIDLabel);
        this.add(ssnField);
        this.add(userNameField);
        this.add(passwordField);
        this.add(fNameField);
        this.add(lNameField);
        this.add(dobField);
        this.add(phoneField);
        this.add(emailField);
        this.add(addressField);
        this.add(nationalityField);
        this.add(courseIDField);
        this.add(addInstructorButton);
        this.add(backToAdminHome);

        ssnLabel.setFont(new Font("", Font.ITALIC, 25));
        userNameLabel.setFont(new Font("", Font.ITALIC, 25));
        passwordLabel.setFont(new Font("", Font.ITALIC, 25));
        fNameLabel.setFont(new Font("", Font.ITALIC, 25));
        lNameLabel.setFont(new Font("", Font.ITALIC, 25));
        dobLabel.setFont(new Font("", Font.ITALIC, 25));
        phoneLabel.setFont(new Font("", Font.ITALIC, 25));
        emailLabel.setFont(new Font("", Font.ITALIC, 25));
        addressLabel.setFont(new Font("", Font.ITALIC, 25));
        nationalityLabel.setFont(new Font("", Font.ITALIC, 25));
        courseIDLabel.setFont(new Font("", Font.ITALIC, 25));
        ssnField.setFont(new Font("", Font.PLAIN, 20));
        userNameField.setFont(new Font("", Font.PLAIN, 20));
        passwordField.setFont(new Font("", Font.PLAIN, 20));
        fNameField.setFont(new Font("", Font.PLAIN, 20));
        lNameField.setFont(new Font("", Font.PLAIN, 20));
        dobField.setFont(new Font("", Font.PLAIN, 20));
        phoneField.setFont(new Font("", Font.PLAIN, 20));
        emailField.setFont(new Font("", Font.PLAIN, 20));
        addressField.setFont(new Font("", Font.PLAIN, 20));
        nationalityField.setFont(new Font("", Font.PLAIN, 20));
        courseIDField.setFont(new Font("", Font.PLAIN, 20));
        addInstructorButton.setFont(new Font("", Font.ITALIC, 25));
        backToAdminHome.setFont(new Font("", Font.ITALIC, 25));

        ssnLabel.setBounds(185, 40, 150, 30);
        userNameLabel.setBounds(15, 100, 150, 30);
        passwordLabel.setBounds(360, 100, 150, 30);
        fNameLabel.setBounds(15, 180, 150, 30);
        lNameLabel.setBounds(360, 180, 150, 30);
        dobLabel.setBounds(185, 260, 150, 30);
        phoneLabel.setBounds(15, 340, 150, 30);
        emailLabel.setBounds(360, 340, 150, 30);
        addressLabel.setBounds(15, 420, 150, 30);
        nationalityLabel.setBounds(360, 420, 150, 30);
        courseIDLabel.setBounds(185, 500, 150, 30);

        ssnField.setBounds(345, 40, 170, 30);
        userNameField.setBounds(175, 100, 170, 30);
        passwordField.setBounds(515, 100, 170, 30);
        fNameField.setBounds(175, 180, 170, 30);
        lNameField.setBounds(515, 180, 170, 30);
        dobField.setBounds(345, 260, 170, 30);
        phoneField.setBounds(175, 340, 170, 30);
        emailField.setBounds(515, 340, 170, 30);
        addressField.setBounds(175, 420, 170, 30);
        nationalityField.setBounds(515, 420, 170, 30);
        courseIDField.setBounds(345, 500, 170, 30);
        addInstructorButton.setBounds(250, 560, 200, 50);
        backToAdminHome.setBounds(0, 560, 150, 50);

        addInstructorButton.setBackground(new Color(251, 172, 35));
        addInstructorButton.setForeground(new Color(255, 255, 255));
        backToAdminHome.setBackground(new Color(251, 172, 35));
        backToAdminHome.setForeground(new Color(255, 255, 255));

        addInstructorButton.addActionListener(click);
        backToAdminHome.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("add instructor");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////AddInstructorPAGE BUTTONS
            if (e.getSource() == addInstructorButton) {
                ssn = ssnField.getText().toString();
                username = userNameField.getText().toString();
                password = passwordField.getText().toString();
                fName = fNameField.getText().toString();
                lName = lNameField.getText().toString();
                dob = dobField.getText().toString();
                phone = phoneField.getText().toString();
                email = emailField.getText().toString();
                address = addressField.getText().toString();
                nationality = nationalityField.getText().toString();
                courseID = courseIDField.getText().toString();

                try {
                    ssnField.setText("");
                    userNameField.setText("");
                    passwordField.setText("");
                    fNameField.setText("");
                    lNameField.setText("");
                    dobField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                    addressField.setText("");
                    nationalityField.setText("");
                    courseIDField.setText("");
                    md.addInstructor(username, password, fName, lName, ssn, dob, phone, email, address, nationality, courseID);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (md.isDone()) {
                    AddInstructor.this.removeAll();
                    revalidate();
                    repaint();
                    AdminHomePage adminHomePanel = new AdminHomePage();
                    AddInstructor.this.add(adminHomePanel);
                }

            }
            if (e.getSource() == backToAdminHome) {
                AddInstructor.this.removeAll();
                revalidate();
                repaint();
                AdminHomePage ahp = new AdminHomePage();
                AddInstructor.this.add(ahp);
            }
        }
    }

}
