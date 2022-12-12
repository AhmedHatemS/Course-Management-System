package AdminModule;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteInstructor extends JPanel {

    /////////////////////////////////////////////////////////////////////////////DeleteInstructor needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JTextField ssnField = new JTextField();
    JButton DeleteInstructorButton = new JButton("Delete Instructor!");
    JButton backToAdminHome = new JButton("Back");
    String SSN;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    DeleteInstructor() {
        /////////////////////////////////////////////////////////////////////////DeleteInstructor panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(ssnLabel);
        this.add(ssnField);
        this.add(DeleteInstructorButton);
        this.add(backToAdminHome);

        ssnLabel.setFont(new Font("", Font.ITALIC, 25));
        ssnField.setFont(new Font("", Font.PLAIN, 20));
        DeleteInstructorButton.setFont(new Font("", Font.ITALIC, 25));
        backToAdminHome.setFont(new Font("", Font.ITALIC, 25));

        ssnLabel.setBounds(185, 235, 150, 30);
        ssnField.setBounds(345, 235, 170, 30);
        DeleteInstructorButton.setBounds(225, 335, 250, 50);
        backToAdminHome.setBounds(0, 560, 150, 50);

        DeleteInstructorButton.setBackground(new Color(251, 172, 35));
        DeleteInstructorButton.setForeground(new Color(255, 255, 255));
        backToAdminHome.setBackground(new Color(251, 172, 35));
        backToAdminHome.setForeground(new Color(255, 255, 255));

        DeleteInstructorButton.addActionListener(click);
        backToAdminHome.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("Delete instructor");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////DeleteInstructor PAGE BUTTONS
            if (e.getSource() == DeleteInstructorButton) {
                SSN = ssnField.getText().toString();
                try {
                    md.deleteInstructor(SSN);
                    ssnField.setText("");
                    if (md.isDone()) {
                        DeleteInstructor.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        DeleteInstructor.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToAdminHome) {
                DeleteInstructor.this.removeAll();
                revalidate();
                repaint();
                AdminHomePage ahp = new AdminHomePage();
                DeleteInstructor.this.add(ahp);
            }
        }
    }
}
