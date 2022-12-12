package AdminModule;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateInstructorAllData extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateInstructorAllData needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel phoneLabel = new JLabel("New phone: ");
    JLabel emailLabel = new JLabel("New email: ");
    JLabel addressLabel = new JLabel("New address: ");
    JLabel CourseIDLabel = new JLabel("New CourseID: ");
    JTextField ssnField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField CourseIDField = new JTextField();
    JButton updateInstructorAllButton = new JButton("Update!");
    JButton backToUpdateInstructorHome = new JButton("Back");
    String SSN, phone, email, address, CourseID;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    UpdateInstructorAllData() {
        {
            {
                {
                    /////////////////////////////////////////////////////////////////////////UpdateInstructorAllData panel content
                    this.setBounds(0, 0, 750, 650);
                    this.setLayout(null);
                    this.setBackground(Color.LIGHT_GRAY);
                    this.add(ssnLabel);
                    this.add(phoneLabel);
                    this.add(emailLabel);
                    this.add(addressLabel);
                    this.add(CourseIDLabel);
                    this.add(ssnField);
                    this.add(phoneField);
                    this.add(emailField);
                    this.add(addressField);
                    this.add(CourseIDField);
                    this.add(updateInstructorAllButton);
                    this.add(backToUpdateInstructorHome);

                    ssnLabel.setFont(new Font("", Font.ITALIC, 25));
                    phoneLabel.setFont(new Font("", Font.ITALIC, 25));
                    emailLabel.setFont(new Font("", Font.ITALIC, 25));
                    addressLabel.setFont(new Font("", Font.ITALIC, 25));
                    CourseIDLabel.setFont(new Font("", Font.ITALIC, 25));
                    ssnField.setFont(new Font("", Font.PLAIN, 20));
                    phoneField.setFont(new Font("", Font.PLAIN, 20));
                    emailField.setFont(new Font("", Font.PLAIN, 20));
                    addressField.setFont(new Font("", Font.PLAIN, 20));
                    CourseIDField.setFont(new Font("", Font.PLAIN, 20));
                    updateInstructorAllButton.setFont(new Font("", Font.ITALIC, 25));
                    backToUpdateInstructorHome.setFont(new Font("", Font.ITALIC, 25));

                    ssnLabel.setBounds(200, 50, 170, 30);
                    phoneLabel.setBounds(200, 150, 200, 30);
                    emailLabel.setBounds(200, 250, 200, 30);
                    addressLabel.setBounds(200, 350, 200, 30);
                    CourseIDLabel.setBounds(200, 450, 200, 30);
                    ssnField.setBounds(380, 50, 170, 30);
                    phoneField.setBounds(380, 150, 170, 30);
                    emailField.setBounds(380, 250, 170, 30);
                    addressField.setBounds(380, 350, 170, 30);
                    CourseIDField.setBounds(380, 450, 170, 30);
                    updateInstructorAllButton.setBounds(300, 550, 150, 50);
                    backToUpdateInstructorHome.setBounds(0, 560, 150, 50);

                    updateInstructorAllButton.setBackground(new Color(251, 172, 35));
                    updateInstructorAllButton.setForeground(new Color(255, 255, 255));
                    backToUpdateInstructorHome.setBackground(new Color(251, 172, 35));
                    backToUpdateInstructorHome.setForeground(new Color(255, 255, 255));

                    updateInstructorAllButton.addActionListener(click);
                    backToUpdateInstructorHome.addActionListener(click);

                    ///border
                    TitledBorder border = new TitledBorder("Update instructor all data");
                    border.setTitleJustification(TitledBorder.CENTER);
                    border.setTitlePosition(TitledBorder.TOP);
                    border.setTitleColor(Color.WHITE);
                    border.setTitleFont(new Font("", Font.BOLD, 15));
                    this.setBorder(border);
                }
            }
        }
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////UpdateInstructorAllData PAGE BUTTONS
            if (e.getSource() == updateInstructorAllButton) {
                SSN = ssnField.getText().toString();
                phone = phoneField.getText().toString();
                email = emailField.getText().toString();
                address = addressField.getText().toString();
                CourseID = CourseIDField.getText().toString();
                try {
                    md.updateInstructor(SSN, phone, email, address, CourseID);
                    ssnField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                    addressField.setText("");
                    CourseIDField.setText("");
                    if (md.isDone()) {
                        UpdateInstructorAllData.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        UpdateInstructorAllData.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToUpdateInstructorHome) {
		UpdateInstructorAllData.this.removeAll();
                revalidate();
                repaint();
                UpdateInstructorDataHomePage usdhp = new UpdateInstructorDataHomePage();
                UpdateInstructorAllData.this.add(usdhp);
            }
        }
    }
}
