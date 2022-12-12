package AdminModule;

import InstructorModule.INstructor;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateStudentAddress extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateStudentAddress needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel addressLabel = new JLabel("New address: ");
    JTextField ssnField = new JTextField();
    JTextField addressField = new JTextField();
    JButton updateAddressButton = new JButton("Update!");
    JButton backToUpdateStudentHome = new JButton("Back");
    String SSN, address;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    UpdateStudentAddress() {
        {
            {
                {
                    /////////////////////////////////////////////////////////////////////////UpdateStudentAddress panel content
                    this.setBounds(0, 0, 750, 650);
                    this.setLayout(null);
                    this.setBackground(Color.LIGHT_GRAY);
                    this.add(ssnLabel);
                    this.add(addressLabel);
                    this.add(ssnField);
                    this.add(addressField);
                    this.add(updateAddressButton);
                    this.add(backToUpdateStudentHome);

                    ssnLabel.setFont(new Font("", Font.ITALIC, 25));
                    addressLabel.setFont(new Font("", Font.ITALIC, 25));
                    ssnField.setFont(new Font("", Font.PLAIN, 20));
                    addressField.setFont(new Font("", Font.PLAIN, 20));
                    updateAddressButton.setFont(new Font("", Font.ITALIC, 25));
                    backToUpdateStudentHome.setFont(new Font("", Font.ITALIC, 25));

                    ssnLabel.setBounds(200, 200, 170, 30);
                    addressLabel.setBounds(200, 300, 200, 30);
                    ssnField.setBounds(380, 200, 170, 30);
                    addressField.setBounds(380, 300, 170, 30);
                    updateAddressButton.setBounds(300, 400, 150, 50);
                    backToUpdateStudentHome.setBounds(0, 560, 150, 50);

                    updateAddressButton.setBackground(new Color(251, 172, 35));
                    updateAddressButton.setForeground(new Color(255, 255, 255));
                    backToUpdateStudentHome.setBackground(new Color(251, 172, 35));
                    backToUpdateStudentHome.setForeground(new Color(255, 255, 255));

                    updateAddressButton.addActionListener(click);
                    backToUpdateStudentHome.addActionListener(click);

                    ///border
                    TitledBorder border = new TitledBorder("Update student address");
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
            /////////////////////////////////////////////////////////////////////UpdateStudentAddress PAGE BUTTONS
            if (e.getSource() == updateAddressButton) {
                SSN = ssnField.getText().toString();
                address = addressField.getText().toString();
                try {
                    md.updateStudentAddress(SSN, address);
                    ssnField.setText("");
                    addressField.setText("");
                    if (md.isDone()) {
                        UpdateStudentAddress.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        UpdateStudentAddress.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToUpdateStudentHome) {
		UpdateStudentAddress.this.removeAll();
                revalidate();
                repaint();
                UpdateStudentDataHomePage usdhp = new UpdateStudentDataHomePage();
                UpdateStudentAddress.this.add(usdhp);
            }
        }
    }
}
