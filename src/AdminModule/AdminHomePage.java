package AdminModule;

import CourseModule.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AdminHomePage extends JPanel {

    /////////////////////////////////////////////////////////////////////////////AdminHome needs
    JButton addAdmin = new JButton("add admin");
    JButton addInstructor = new JButton("add instructor");
    JButton addStudent = new JButton("add student");
    JButton updateAdmin = new JButton("update admin");
    JButton updateInstructor = new JButton("update instructor");
    JButton updateStudent = new JButton("update student");
    JButton deleteAdmin = new JButton("delete admin");
    JButton deleteInstructor = new JButton("delete instructor");
    JButton deleteStudent = new JButton("delete student");
    JButton manageCourse = new JButton("manage course");
    JButton logout = new JButton("log out");

    onButtonClick click = new onButtonClick();
    ManageData md = new ManageData();

    public AdminHomePage() {
        /////////////////////////////////////////////////////////////////////////admin home content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(addAdmin);
        this.add(addInstructor);
        this.add(addStudent);
        this.add(updateAdmin);
        this.add(updateInstructor);
        this.add(updateStudent);
        this.add(deleteAdmin);
        this.add(deleteInstructor);
        this.add(deleteStudent);
        this.add(manageCourse);
        this.add(logout);

        addAdmin.setFont(new Font("", Font.ITALIC, 25));
        addInstructor.setFont(new Font("", Font.ITALIC, 25));
        addStudent.setFont(new Font("", Font.ITALIC, 25));
        updateAdmin.setFont(new Font("", Font.ITALIC, 25));
        updateInstructor.setFont(new Font("", Font.ITALIC, 25));
        updateStudent.setFont(new Font("", Font.ITALIC, 25));
        deleteAdmin.setFont(new Font("", Font.ITALIC, 25));
        deleteInstructor.setFont(new Font("", Font.ITALIC, 25));
        deleteStudent.setFont(new Font("", Font.ITALIC, 25));
        manageCourse.setFont(new Font("", Font.ITALIC, 25));
        logout.setFont(new Font("", Font.ITALIC, 25));

        addAdmin.setBounds(25, 90, 220, 50);
        addInstructor.setBounds(250, 90, 220, 50);
        addStudent.setBounds(475, 90, 220, 50);
        updateAdmin.setBounds(25, 230, 220, 50);
        updateInstructor.setBounds(250, 230, 220, 50);
        updateStudent.setBounds(475, 230, 220, 50);
        deleteAdmin.setBounds(25, 370, 220, 50);
        deleteInstructor.setBounds(250, 370, 220, 50);
        deleteStudent.setBounds(475, 370, 220, 50);
        manageCourse.setBounds(250, 510, 220, 50);
        logout.setBounds(0, 560, 150, 50);

        addAdmin.setBackground(new Color(33, 33, 33));
        addInstructor.setBackground(new Color(33, 33, 33));
        addStudent.setBackground(new Color(33, 33, 33));
        updateAdmin.setBackground(new Color(33, 33, 33));
        updateInstructor.setBackground(new Color(33, 33, 33));
        updateStudent.setBackground(new Color(33, 33, 33));
        deleteAdmin.setBackground(new Color(33, 33, 33));
        deleteInstructor.setBackground(new Color(33, 33, 33));
        deleteStudent.setBackground(new Color(33, 33, 33));
        manageCourse.setBackground(new Color(33, 33, 33));
        logout.setBackground(new Color(251, 172, 35));

        addAdmin.setForeground(new Color(255, 255, 255));
        addInstructor.setForeground(new Color(255, 255, 255));
        addStudent.setForeground(new Color(255, 255, 255));
        updateAdmin.setForeground(new Color(255, 255, 255));
        updateInstructor.setForeground(new Color(255, 255, 255));
        updateStudent.setForeground(new Color(255, 255, 255));
        deleteAdmin.setForeground(new Color(255, 255, 255));
        deleteInstructor.setForeground(new Color(255, 255, 255));
        deleteStudent.setForeground(new Color(255, 255, 255));
        manageCourse.setForeground(new Color(255, 255, 255));
        logout.setForeground(new Color(255, 255, 255));

        addAdmin.addActionListener(click);
        addInstructor.addActionListener(click);
        addStudent.addActionListener(click);
        updateAdmin.addActionListener(click);
        updateInstructor.addActionListener(click);
        updateStudent.addActionListener(click);
        deleteAdmin.addActionListener(click);
        deleteInstructor.addActionListener(click);
        deleteStudent.addActionListener(click);
        manageCourse.addActionListener(click);
        logout.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("admin home page");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////ADMIN HOME PAGE BUTTONS
            removeAll();
            revalidate();
            repaint();
            if (e.getSource() == addAdmin) {
                AddAdmin ada = new AddAdmin();
                AdminHomePage.this.add(ada);
            }
            if (e.getSource() == addInstructor) {
                AddInstructor adi = new AddInstructor();
                AdminHomePage.this.add(adi);
            }
            if (e.getSource() == addStudent) {
                AddStudent ads = new AddStudent();
                AdminHomePage.this.add(ads);
            }
            if (e.getSource() == updateAdmin) {
                UpdateAdmin upa = new UpdateAdmin();
                AdminHomePage.this.add(upa);
            }
            if (e.getSource() == updateInstructor) {
                UpdateInstructorDataHomePage upsdhp = new UpdateInstructorDataHomePage();
                AdminHomePage.this.add(upsdhp);
            }
            if (e.getSource() == updateStudent) {
                UpdateStudentDataHomePage upsdhp = new UpdateStudentDataHomePage();
                AdminHomePage.this.add(upsdhp);
            }
            if (e.getSource() == deleteAdmin) {
                DeleteAdmin dela = new DeleteAdmin();
                AdminHomePage.this.add(dela);
            }
            if (e.getSource() == deleteInstructor) {
                DeleteInstructor deli = new DeleteInstructor();
                AdminHomePage.this.add(deli);
            }
            if (e.getSource() == deleteStudent) {
                DeleteStudent dels = new DeleteStudent();
                AdminHomePage.this.add(dels);
            }
            if (e.getSource() == manageCourse) {
                ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                AdminHomePage.this.add(MCHP);
            }
            if (e.getSource() == logout) {
                login l = new login();
                AdminHomePage.this.add(l);
            }
        }

    }

}
