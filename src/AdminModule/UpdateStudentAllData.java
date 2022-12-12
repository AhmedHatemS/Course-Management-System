package AdminModule;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateStudentAllData extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateStudentAllData needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel phoneLabel = new JLabel("New phone: ");
    JLabel emailLabel = new JLabel("New email: ");
    JLabel addressLabel = new JLabel("New address: ");
    JTextField ssnField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField addressField = new JTextField();
    JButton updateStudentAllButton = new JButton("Update!");
    JButton backToUpdateStudentHome = new JButton("Back");
    String SSN, phone, email, address;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    UpdateStudentAllData() {
        {
            {
                {
                    /////////////////////////////////////////////////////////////////////////UpdateStudentAllData panel content
                    this.setBounds(0, 0, 750, 650);
                    this.setLayout(null);
                    this.setBackground(Color.LIGHT_GRAY);
                    this.add(ssnLabel);
                    this.add(phoneLabel);
                    this.add(emailLabel);
                    this.add(addressLabel);
                    this.add(ssnField);
                    this.add(phoneField);
                    this.add(emailField);
                    this.add(addressField);
                    this.add(updateStudentAllButton);
                    this.add(backToUpdateStudentHome);

                    ssnLabel.setFont(new Font("", Font.ITALIC, 25));
                    phoneLabel.setFont(new Font("", Font.ITALIC, 25));
                    emailLabel.setFont(new Font("", Font.ITALIC, 25));
                    addressLabel.setFont(new Font("", Font.ITALIC, 25));
                    ssnField.setFont(new Font("", Font.PLAIN, 20));
                    phoneField.setFont(new Font("", Font.PLAIN, 20));
                    emailField.setFont(new Font("", Font.PLAIN, 20));
                    addressField.setFont(new Font("", Font.PLAIN, 20));
                    updateStudentAllButton.setFont(new Font("", Font.ITALIC, 25));
                    backToUpdateStudentHome.setFont(new Font("", Font.ITALIC, 25));

                    ssnLabel.setBounds(200, 100, 170, 30);
                    phoneLabel.setBounds(200, 200, 200, 30);
                    emailLabel.setBounds(200, 300, 200, 30);
                    addressLabel.setBounds(200, 400, 200, 30);
                    ssnField.setBounds(380, 100, 170, 30);
                    phoneField.setBounds(380, 200, 170, 30);
                    emailField.setBounds(380, 300, 170, 30);
                    addressField.setBounds(380, 400, 170, 30);
                    updateStudentAllButton.setBounds(300, 500, 150, 50);
                    backToUpdateStudentHome.setBounds(0, 560, 150, 50);

                    updateStudentAllButton.setBackground(new Color(251, 172, 35));
                    updateStudentAllButton.setForeground(new Color(255, 255, 255));
                    backToUpdateStudentHome.setBackground(new Color(251, 172, 35));
                    backToUpdateStudentHome.setForeground(new Color(255, 255, 255));

                    updateStudentAllButton.addActionListener(click);
                    backToUpdateStudentHome.addActionListener(click);

                    ///border
                    TitledBorder border = new TitledBorder("Update student all data");
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
            /////////////////////////////////////////////////////////////////////UpdateStudentAllData PAGE BUTTONS
            if (e.getSource() == updateStudentAllButton) {
                SSN = ssnField.getText().toString();
                phone = phoneField.getText().toString();
                email = emailField.getText().toString();
                address = addressField.getText().toString();
                try {
                    md.updateStudent(SSN, phone, email, address);
                    ssnField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                    addressField.setText("");
                    if (md.isDone()) {
                        UpdateStudentAllData.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        UpdateStudentAllData.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToUpdateStudentHome) {
		UpdateStudentAllData.this.removeAll();
                revalidate();
                repaint();
                UpdateStudentDataHomePage usdhp = new UpdateStudentDataHomePage();
                UpdateStudentAllData.this.add(usdhp);
            }
        }
    }
}
