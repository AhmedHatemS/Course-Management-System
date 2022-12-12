package AdminModule;

import InstructorModule.INstructor;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateInstructorCourseID extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateInstructorCourseID needs
    JLabel ssnLabel = new JLabel("SSN: ");
    JLabel CourseIDLabel = new JLabel("New CourseID: ");
    JTextField ssnField = new JTextField();
    JTextField CourseIDField = new JTextField();
    JButton updateCourseIDButton = new JButton("Update!");
    JButton backToUpdateInstructorHome = new JButton("Back");
    String SSN, CourseID;

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    UpdateInstructorCourseID() {
        {
            {
                {
                    /////////////////////////////////////////////////////////////////////////UpdateInstructorCourseID panel content
                    this.setBounds(0, 0, 750, 650);
                    this.setLayout(null);
                    this.setBackground(Color.LIGHT_GRAY);
                    this.add(ssnLabel);
                    this.add(CourseIDLabel);
                    this.add(ssnField);
                    this.add(CourseIDField);
                    this.add(updateCourseIDButton);
                    this.add(backToUpdateInstructorHome);

                    ssnLabel.setFont(new Font("", Font.ITALIC, 25));
                    CourseIDLabel.setFont(new Font("", Font.ITALIC, 25));
                    ssnField.setFont(new Font("", Font.PLAIN, 20));
                    CourseIDField.setFont(new Font("", Font.PLAIN, 20));
                    updateCourseIDButton.setFont(new Font("", Font.ITALIC, 25));
                    backToUpdateInstructorHome.setFont(new Font("", Font.ITALIC, 25));

                    ssnLabel.setBounds(200, 200, 170, 30);
                    CourseIDLabel.setBounds(200, 300, 200, 30);
                    ssnField.setBounds(380, 200, 170, 30);
                    CourseIDField.setBounds(380, 300, 170, 30);
                    updateCourseIDButton.setBounds(300, 400, 150, 50);
                    backToUpdateInstructorHome.setBounds(0, 560, 150, 50);

                    updateCourseIDButton.setBackground(new Color(251, 172, 35));
                    updateCourseIDButton.setForeground(new Color(255, 255, 255));
                    backToUpdateInstructorHome.setBackground(new Color(251, 172, 35));
                    backToUpdateInstructorHome.setForeground(new Color(255, 255, 255));

                    updateCourseIDButton.addActionListener(click);
                    backToUpdateInstructorHome.addActionListener(click);

                    ///border
                    TitledBorder border = new TitledBorder("Update instructor CourseID");
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
            /////////////////////////////////////////////////////////////////////UpdateInstructorCourseID PAGE BUTTONS
            if (e.getSource() == updateCourseIDButton) {
                SSN = ssnField.getText().toString();
                CourseID = CourseIDField.getText().toString();
                try {
                    md.updateInstructorCourseID(SSN, CourseID);
                    ssnField.setText("");
                    CourseIDField.setText("");
                    if (md.isDone()) {
                        UpdateInstructorCourseID.this.removeAll();
                        revalidate();
                        repaint();
                        AdminHomePage adminHomePanel = new AdminHomePage();
                        UpdateInstructorCourseID.this.add(adminHomePanel);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == backToUpdateInstructorHome) {
		UpdateInstructorCourseID.this.removeAll();
                revalidate();
                repaint();
                UpdateInstructorDataHomePage usdhp = new UpdateInstructorDataHomePage();
                UpdateInstructorCourseID.this.add(usdhp);
            }
        }
    }
}
