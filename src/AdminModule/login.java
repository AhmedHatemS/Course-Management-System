package AdminModule;

import InstructorModule.INstructor;
import StudentModule.StudentModuleF;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class login extends JPanel {

    /////////////////////////////////////////////////////////////////////////////Login needs
    JLabel welcome = new JLabel("Welcome");
    JLabel userNameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField userNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login!");
    JButton asGuest = new JButton("Guest?");
    String username, password, role;
    
    ImageIcon icon2 = new ImageIcon(getClass().getResource("/AdminModule/logo5.png"));
  
    JLabel l2 = new JLabel();
    
    onButtonClick click = new onButtonClick();
    GetAccess gt = new GetAccess();

    public login() {
        /////////////////////////////////////////////////////////////////////////Login panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(welcome);
        this.add(userNameLabel);
        this.add(passwordLabel);
        this.add(userNameField);
        this.add(passwordField);
        this.add(loginButton);
        this.add(asGuest);
      
        this.add(l2);

     
        l2.setIcon(icon2);
      
        l2.setBounds(50, 0, 130, 180);

        welcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        userNameLabel.setFont(new Font("", Font.ITALIC, 25));
        passwordLabel.setFont(new Font("", Font.ITALIC, 25));
        userNameField.setFont(new Font("", Font.PLAIN, 20));
        passwordField.setFont(new Font("", Font.PLAIN, 20));
        loginButton.setFont(new Font("", Font.ITALIC, 25));
        asGuest.setFont(new Font("", Font.ITALIC, 25));

        welcome.setBounds(290, 50, 170, 50);
        userNameLabel.setBounds(220, 200, 150, 30);
        passwordLabel.setBounds(220, 300, 150, 30);
        userNameField.setBounds(380, 200, 150, 30);
        passwordField.setBounds(380, 300, 150, 30);
        loginButton.setBounds(300, 400, 150, 50);
        asGuest.setBounds(575, 500, 150, 50);

        loginButton.setBackground(new Color(251, 172, 35));
        loginButton.setForeground(new Color(255, 255, 255));
        asGuest.setBackground(new Color(251, 172, 35));
        asGuest.setForeground(new Color(255, 255, 255));

        loginButton.addActionListener(click);
        asGuest.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("login page");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.black);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////LOGIN PAGE BUTTONS
            if (e.getSource() == loginButton) {
                username = userNameField.getText().toString();
                password = passwordField.getText().toString();
                try {
                    gt.login(username, password);
                    role = gt.returnRole();
                    userNameField.setText("");
                    passwordField.setText("");
                    if (role.length() > 0) {
                        login.this.removeAll();
                        revalidate();
                        repaint();
                    }
                    if ("admin".equals(role)) {
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        login.this.add(adminHomePanel);
                    } else if ("instructor".equals(role)) {
                      INstructor   instructorHomePanel = new INstructor();
                      login.this.add(instructorHomePanel);
                    } else if ("student".equals(role)) {
                        StudentModuleF studentHomePanel = new StudentModuleF();
                        login.this.add(studentHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == asGuest) {
                login.this.removeAll();
                revalidate();
                repaint();
                Guest guestPanel = new Guest();
                login.this.add(guestPanel);
            }
        }
    }
}
