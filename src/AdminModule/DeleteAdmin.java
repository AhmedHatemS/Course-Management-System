package AdminModule;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteAdmin extends JPanel {

    /////////////////////////////////////////////////////////////////////////////DeleteAdmin needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JTextField ssnField = new JTextField();
    JButton DeleteAdminButton = new JButton("Delete Admin!");
    JButton backToAdminHome = new JButton("Back");
    String SSN;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    DeleteAdmin() {
        /////////////////////////////////////////////////////////////////////////DeleteAdmin panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(ssnLabel);
        this.add(ssnField);
        this.add(DeleteAdminButton);
        this.add(backToAdminHome);

        ssnLabel.setFont(new Font("", Font.ITALIC, 25));
        ssnField.setFont(new Font("", Font.PLAIN, 20));
        DeleteAdminButton.setFont(new Font("", Font.ITALIC, 25));
        backToAdminHome.setFont(new Font("", Font.ITALIC, 25));

        ssnLabel.setBounds(185, 235, 150, 30);
        ssnField.setBounds(345, 235, 170, 30);
        DeleteAdminButton.setBounds(250, 335, 200, 50);
        backToAdminHome.setBounds(0, 560, 150, 50);

        DeleteAdminButton.setBackground(new Color(251, 172, 35));
        DeleteAdminButton.setForeground(new Color(255, 255, 255));
        backToAdminHome.setBackground(new Color(251, 172, 35));
        backToAdminHome.setForeground(new Color(255, 255, 255));

        DeleteAdminButton.addActionListener(click);
        backToAdminHome.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("Delete admin");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////DeleteAdmin PAGE BUTTONS
            if (e.getSource() == DeleteAdminButton) {
                SSN = ssnField.getText().toString();
                try {
                    md.deleteUser(SSN);
                    ssnField.setText("");
                    if (md.isDone()) {
                        DeleteAdmin.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        DeleteAdmin.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToAdminHome) {
                DeleteAdmin.this.removeAll();
                revalidate();
                repaint();
                AdminHomePage ahp = new AdminHomePage();
                DeleteAdmin.this.add(ahp);
            }
        }
    }
}
