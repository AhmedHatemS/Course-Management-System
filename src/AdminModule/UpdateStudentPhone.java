package AdminModule;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateStudentPhone extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateStudentPhone needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel phoneLabel = new JLabel("New phone: ");
    JTextField ssnField = new JTextField();
    JTextField phoneField = new JTextField();
    JButton updatePhoneButton = new JButton("Update!");
    JButton backToUpdateStudentHome = new JButton("Back");
    String SSN, phone;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    UpdateStudentPhone() {
        {
            {
                {
                    /////////////////////////////////////////////////////////////////////////UpdateStudentPhone panel content
                    this.setBounds(0, 0, 750, 650);
                    this.setLayout(null);
                    this.setBackground(Color.LIGHT_GRAY);
                    this.add(ssnLabel);
                    this.add(phoneLabel);
                    this.add(ssnField);
                    this.add(phoneField);
                    this.add(updatePhoneButton);
                    this.add(backToUpdateStudentHome);

                    ssnLabel.setFont(new Font("", Font.ITALIC, 25));
                    phoneLabel.setFont(new Font("", Font.ITALIC, 25));
                    ssnField.setFont(new Font("", Font.PLAIN, 20));
                    phoneField.setFont(new Font("", Font.PLAIN, 20));
                    updatePhoneButton.setFont(new Font("", Font.ITALIC, 25));
                    backToUpdateStudentHome.setFont(new Font("", Font.ITALIC, 25));

                    ssnLabel.setBounds(200, 200, 170, 30);
                    phoneLabel.setBounds(200, 300, 200, 30);
                    ssnField.setBounds(380, 200, 170, 30);
                    phoneField.setBounds(380, 300, 170, 30);
                    updatePhoneButton.setBounds(300, 400, 150, 50);
                    backToUpdateStudentHome.setBounds(0, 560, 150, 50);

                    updatePhoneButton.setBackground(new Color(251, 172, 35));
                    updatePhoneButton.setForeground(new Color(255, 255, 255));
                    backToUpdateStudentHome.setBackground(new Color(251, 172, 35));
                    backToUpdateStudentHome.setForeground(new Color(255, 255, 255));

                    updatePhoneButton.addActionListener(click);
                    backToUpdateStudentHome.addActionListener(click);

                    ///border
                    TitledBorder border = new TitledBorder("Update student phone");
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
            /////////////////////////////////////////////////////////////////////UpdateStudentPhone PAGE BUTTONS
            if (e.getSource() == updatePhoneButton) {
                SSN = ssnField.getText().toString();
                phone = phoneField.getText().toString();
                try {
                    md.updateStudentPhone(SSN, phone);
                    ssnField.setText("");
                    phoneField.setText("");
                    if (md.isDone()) {
                        UpdateStudentPhone.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        UpdateStudentPhone.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToUpdateStudentHome) {
                UpdateStudentPhone.this.removeAll();
                revalidate();
                repaint();
                UpdateStudentDataHomePage usdhp = new UpdateStudentDataHomePage();
                UpdateStudentPhone.this.add(usdhp);
            }
        }
    }
}
