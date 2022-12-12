package AdminModule;

import InstructorModule.INstructor;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateStudentPassword extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdatePassword needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel passwordLabel = new JLabel("New password: ");
    JTextField ssnField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton updatePasswordButton = new JButton("Update!");
    JButton backToUpdateStudentHome = new JButton("Back");
    String SSN, password;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    UpdateStudentPassword() {
        /////////////////////////////////////////////////////////////////////////UpdatePassword panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(ssnLabel);
        this.add(passwordLabel);
        this.add(ssnField);
        this.add(passwordField);
        this.add(updatePasswordButton);
        this.add(backToUpdateStudentHome);

        ssnLabel.setFont(new Font("", Font.ITALIC, 25));
        passwordLabel.setFont(new Font("", Font.ITALIC, 25));
        ssnField.setFont(new Font("", Font.PLAIN, 20));
        passwordField.setFont(new Font("", Font.PLAIN, 20));
        updatePasswordButton.setFont(new Font("", Font.ITALIC, 25));
        backToUpdateStudentHome.setFont(new Font("", Font.ITALIC, 25));

        ssnLabel.setBounds(200, 200, 170, 30);
        passwordLabel.setBounds(200, 300, 200, 30);
        ssnField.setBounds(380, 200, 170, 30);
        passwordField.setBounds(380, 300, 170, 30);
        updatePasswordButton.setBounds(300, 400, 150, 50);
        backToUpdateStudentHome.setBounds(0, 560, 150, 50);

        updatePasswordButton.setBackground(new Color(251, 172, 35));
        updatePasswordButton.setForeground(new Color(255, 255, 255));
        backToUpdateStudentHome.setBackground(new Color(251, 172, 35));
        backToUpdateStudentHome.setForeground(new Color(255, 255, 255));

        updatePasswordButton.addActionListener(click);
        backToUpdateStudentHome.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("Update student password");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////UpdatePassword PAGE BUTTONS
            if (e.getSource() == updatePasswordButton) {
                SSN = ssnField.getText().toString();
                password = passwordField.getText().toString();
                try {
                    md.updatePassword(SSN, password);
                    ssnField.setText("");
                    passwordField.setText("");
                    if (md.isDone()) {
                        UpdateStudentPassword.this.removeAll();
                        revalidate();
                        repaint();
                        UpdateStudentDataHomePage updateStudentHomePanel = new UpdateStudentDataHomePage();
                        UpdateStudentPassword.this.add(updateStudentHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToUpdateStudentHome) {
                UpdateStudentPassword.this.removeAll();
                revalidate();
                repaint();
                UpdateStudentDataHomePage usdhp = new UpdateStudentDataHomePage();
                UpdateStudentPassword.this.add(usdhp);
            }
        }
    }
}
