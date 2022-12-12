package AdminModule;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateInstructorPhone extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateInstructorPhone needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel phoneLabel = new JLabel("New phone: ");
    JTextField ssnField = new JTextField();
    JTextField phoneField = new JTextField();
    JButton updatePhoneButton = new JButton("Update!");
    JButton backToUpdateInstructorHome = new JButton("Back");
    String SSN, phone;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    UpdateInstructorPhone() {
        {
            {
                {
                    /////////////////////////////////////////////////////////////////////////UpdateInstructorPhone panel content
                    this.setBounds(0, 0, 750, 650);
                    this.setLayout(null);
                    this.setBackground(Color.LIGHT_GRAY);
                    this.add(ssnLabel);
                    this.add(phoneLabel);
                    this.add(ssnField);
                    this.add(phoneField);
                    this.add(updatePhoneButton);
                    this.add(backToUpdateInstructorHome);

                    ssnLabel.setFont(new Font("", Font.ITALIC, 25));
                    phoneLabel.setFont(new Font("", Font.ITALIC, 25));
                    ssnField.setFont(new Font("", Font.PLAIN, 20));
                    phoneField.setFont(new Font("", Font.PLAIN, 20));
                    updatePhoneButton.setFont(new Font("", Font.ITALIC, 25));
                    backToUpdateInstructorHome.setFont(new Font("", Font.ITALIC, 25));

                    ssnLabel.setBounds(200, 200, 170, 30);
                    phoneLabel.setBounds(200, 300, 200, 30);
                    ssnField.setBounds(380, 200, 170, 30);
                    phoneField.setBounds(380, 300, 170, 30);
                    updatePhoneButton.setBounds(300, 400, 150, 50);
                    backToUpdateInstructorHome.setBounds(0, 560, 150, 50);

                    updatePhoneButton.setBackground(new Color(251, 172, 35));
                    updatePhoneButton.setForeground(new Color(255, 255, 255));
                    backToUpdateInstructorHome.setBackground(new Color(251, 172, 35));
                    backToUpdateInstructorHome.setForeground(new Color(255, 255, 255));

                    updatePhoneButton.addActionListener(click);
                    backToUpdateInstructorHome.addActionListener(click);

                    ///border
                    TitledBorder border = new TitledBorder("Update instructor phone");
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
            /////////////////////////////////////////////////////////////////////UpdateInstructorPhone PAGE BUTTONS
            if (e.getSource() == updatePhoneButton) {
                SSN = ssnField.getText().toString();
                phone = phoneField.getText().toString();
                try {
                    md.updateInstructorPhone(SSN, phone);
                    ssnField.setText("");
                    phoneField.setText("");
                    if (md.isDone()) {
                        UpdateInstructorPhone.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        UpdateInstructorPhone.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToUpdateInstructorHome) {
                UpdateInstructorPhone.this.removeAll();
                revalidate();
                repaint();
                UpdateInstructorDataHomePage usdhp = new UpdateInstructorDataHomePage();
                UpdateInstructorPhone.this.add(usdhp);
            }
        }
    }
}
