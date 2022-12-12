package CourseModule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateNumberOfDaysOfCourse extends JPanel {

    /////////////////////////////////////////////////////////////////////////////UpdateNumberOfDaysOfCourse needs
    JLabel CourseID = new JLabel("Course ID: ");
    JLabel DaysOfCourse = new JLabel("No of days: ");

    JTextField CourseIDField = new JTextField();
    JTextField DaysOfCourseField = new JTextField();

    JButton updateDaysOfCourseButton = new JButton("Update");
    JButton back = new JButton("back");

    String courseID;
    int daysOfCourse, d = 0;

    onButtonClick click = new onButtonClick();
    ManageCourses mc = new ManageCourses();

    public UpdateNumberOfDaysOfCourse() {
        ///////////////////////////////////////////////////////////////////////UpdateNumberOfDaysOfCourse panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(CourseID);
        this.add(DaysOfCourse);

        this.add(CourseIDField);
        this.add(DaysOfCourseField);

        this.add(updateDaysOfCourseButton);
        this.add(back);

        CourseID.setFont(new Font("", Font.ITALIC, 25));
        DaysOfCourse.setFont(new Font("", Font.ITALIC, 25));

        back.setFont(new Font("", Font.ITALIC, 25));

        CourseIDField.setFont(new Font("", Font.PLAIN, 25));
        DaysOfCourseField.setFont(new Font("", Font.PLAIN, 25));

        updateDaysOfCourseButton.setFont(new Font("", Font.ITALIC, 25));

        CourseID.setBounds(220, 200, 150, 30);
        DaysOfCourse.setBounds(220, 250, 300, 30);

        CourseIDField.setBounds(400, 200, 150, 30);
        DaysOfCourseField.setBounds(400, 250, 150, 30);

        back.setBounds(0, 550, 150, 50);

        updateDaysOfCourseButton.setBounds(300, 400, 150, 50);

        updateDaysOfCourseButton.setBackground(new Color(251, 172, 35));
        back.setBackground(new Color(251, 172, 35));
        updateDaysOfCourseButton.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        updateDaysOfCourseButton.addActionListener(click);
        back.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("Update Number Of Days Of Course");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////UpdateNumberOfDaysOfCourse PAGE BUTTONS
            if (e.getSource() == updateDaysOfCourseButton) {
                courseID = CourseIDField.getText().toString();
                daysOfCourse = Integer.parseInt(DaysOfCourseField.getText().toString());
                try {
                    CourseIDField.setText("");
                    DaysOfCourseField.setText("");
                    mc.updateDaysOfCourse(courseID, daysOfCourse);
                    d = 1;

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateNumberOfDaysOfCourse.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (mc.isDone(d)) {
                    UpdateNumberOfDaysOfCourse.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateNumberOfDaysOfCourse.this.add(MCHP);
                }

            }
            if (e.getSource() == back) {
                UpdateNumberOfDaysOfCourse.this.removeAll();
                revalidate();
                repaint();
                ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                UpdateNumberOfDaysOfCourse.this.add(MCHP);
            }
        }
    }

}
