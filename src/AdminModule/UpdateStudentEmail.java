package AdminModule;

import InstructorModule.INstructor;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateStudentEmail extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateStudentEmail needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel emailLabel = new JLabel("New email: ");
    JTextField ssnField = new JTextField();
    JTextField emailField = new JTextField();
    JButton updateEmailButton = new JButton("Update!");
    JButton backToUpdateStudentHome = new JButton("Back");
    String SSN, email;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    UpdateStudentEmail() {
        {
            {
                {
                    /////////////////////////////////////////////////////////////////////////UpdateStudentEmail panel content
                    this.setBounds(0, 0, 750, 650);
                    this.setLayout(null);
                    this.setBackground(Color.LIGHT_GRAY);
                    this.add(ssnLabel);
                    this.add(emailLabel);
                    this.add(ssnField);
                    this.add(emailField);
                    this.add(updateEmailButton);
                    this.add(backToUpdateStudentHome);

                    ssnLabel.setFont(new Font("", Font.ITALIC, 25));
                    emailLabel.setFont(new Font("", Font.ITALIC, 25));
                    ssnField.setFont(new Font("", Font.PLAIN, 20));
                    emailField.setFont(new Font("", Font.PLAIN, 20));
                    updateEmailButton.setFont(new Font("", Font.ITALIC, 25));
                    backToUpdateStudentHome.setFont(new Font("", Font.ITALIC, 25));

                    ssnLabel.setBounds(200, 200, 170, 30);
                    emailLabel.setBounds(200, 300, 200, 30);
                    ssnField.setBounds(380, 200, 170, 30);
                    emailField.setBounds(380, 300, 170, 30);
                    updateEmailButton.setBounds(300, 400, 150, 50);
                    backToUpdateStudentHome.setBounds(0, 560, 150, 50);

                    updateEmailButton.setBackground(new Color(251, 172, 35));
                    updateEmailButton.setForeground(new Color(255, 255, 255));
                    backToUpdateStudentHome.setBackground(new Color(251, 172, 35));
                    backToUpdateStudentHome.setForeground(new Color(255, 255, 255));

                    updateEmailButton.addActionListener(click);
                    backToUpdateStudentHome.addActionListener(click);

                    ///border
                    TitledBorder border = new TitledBorder("Update student email");
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
            /////////////////////////////////////////////////////////////////////UpdateStudentEmail PAGE BUTTONS
            if (e.getSource() == updateEmailButton) {
                SSN = ssnField.getText().toString();
                email = emailField.getText().toString();
                try {
                    md.updateStudentEmail(SSN, email);
                    ssnField.setText("");
                    emailField.setText("");
                    if (md.isDone()) {
                        UpdateStudentEmail.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        UpdateStudentEmail.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToUpdateStudentHome) {
		UpdateStudentEmail.this.removeAll();
                revalidate();
                repaint();
                UpdateStudentDataHomePage usdhp = new UpdateStudentDataHomePage();
                UpdateStudentEmail.this.add(usdhp);
            }
        }
    }
}
