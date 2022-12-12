package CourseModule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CreateCourse extends JPanel {

    /////////////////////////////////////////////////////////////////////////////CreateCourse needs
    JLabel CourseID = new JLabel("Course ID: ");
    JLabel CourseName = new JLabel("Course Name: ");
    JLabel ParentCourseID = new JLabel("parent Course ID: ");
    JLabel Branch = new JLabel("Branch: ");
    JLabel Courseprice = new JLabel("Course Price: ");
    JLabel Courseroom = new JLabel("Course room: ");
    JLabel CourseStartDay = new JLabel("Course Start day: ");
    JLabel CourseStartMonth = new JLabel("Course Start month: ");
    JLabel CourseStartYear = new JLabel("Course Start year: ");
    JLabel CourseEndDay = new JLabel("Course End day: ");
    JLabel CourseEndMonth = new JLabel("Course End month: ");
    JLabel CourseEndYear = new JLabel("Course End year: ");
    JLabel DaysOfCourse = new JLabel("Days of course: ");
    JLabel InstructorID = new JLabel("Instructor ID: ");

    JTextField CourseIDField = new JTextField();
    JTextField CourseNameField = new JTextField();
    JTextField ParentCourseIDField = new JTextField();
    JTextField BranchField = new JTextField();
    JTextField CoursepriceField = new JTextField();
    JTextField CourseroomField = new JTextField();
    JTextField CourseStartDayField = new JTextField();
    JTextField CourseStartMonthField = new JTextField();
    JTextField CourseStartYearField = new JTextField();
    JTextField CourseEndDayField = new JTextField();
    JTextField CourseEndMonthField = new JTextField();
    JTextField CourseEndYearField = new JTextField();
    JTextField DaysOfCourseField = new JTextField();
    JTextField InstructorIDField = new JTextField();

    JButton addcourseButton = new JButton("Add course");
    JButton back = new JButton("back");

    String courseID, courseName, parentCourse, branch, startDate, endDate;
    int price, room, instID, startDay, startMonth, startYear, endDay, endMonth, endYear, daysOfCourse, d = 0;

    onButtonClick click = new onButtonClick();
    ManageCourses mc = new ManageCourses();

    public CreateCourse() {
        ///////////////////////////////////////////////////////////////////////CreateCourse panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(CourseID);
        this.add(CourseName);
        this.add(ParentCourseID);
        this.add(Branch);
        this.add(Courseprice);
        this.add(Courseroom);
        this.add(CourseStartDay);
        this.add(CourseStartMonth);
        this.add(CourseStartYear);
        this.add(CourseEndDay);
        this.add(CourseEndMonth);
        this.add(CourseEndYear);
        this.add(DaysOfCourse);
        this.add(InstructorID);

        this.add(CourseIDField);
        this.add(CourseNameField);
        this.add(ParentCourseIDField);
        this.add(BranchField);
        this.add(CoursepriceField);
        this.add(CourseroomField);
        this.add(CourseStartDayField);
        this.add(CourseStartMonthField);
        this.add(CourseStartYearField);
        this.add(CourseEndDayField);
        this.add(CourseEndMonthField);
        this.add(CourseEndYearField);
        this.add(DaysOfCourseField);
        this.add(InstructorIDField);

        this.add(addcourseButton);
        this.add(back);

        CourseID.setFont(new Font("", Font.ITALIC, 18));
        CourseName.setFont(new Font("", Font.ITALIC, 18));
        ParentCourseID.setFont(new Font("", Font.ITALIC, 18));
        Branch.setFont(new Font("", Font.ITALIC, 18));
        Courseprice.setFont(new Font("", Font.ITALIC, 18));
        Courseroom.setFont(new Font("", Font.ITALIC, 18));
        CourseStartDay.setFont(new Font("", Font.ITALIC, 18));
        CourseStartMonth.setFont(new Font("", Font.ITALIC, 18));
        CourseStartYear.setFont(new Font("", Font.ITALIC, 18));
        CourseEndDay.setFont(new Font("", Font.ITALIC, 18));
        CourseEndMonth.setFont(new Font("", Font.ITALIC, 18));
        CourseEndYear.setFont(new Font("", Font.ITALIC, 18));
        DaysOfCourse.setFont(new Font("", Font.ITALIC, 18));
        InstructorID.setFont(new Font("", Font.ITALIC, 18));
        back.setFont(new Font("", Font.ITALIC, 18));

        CourseIDField.setFont(new Font("", Font.PLAIN, 18));
        CourseNameField.setFont(new Font("", Font.PLAIN, 18));
        ParentCourseIDField.setFont(new Font("", Font.PLAIN, 18));
        BranchField.setFont(new Font("", Font.PLAIN, 18));
        CoursepriceField.setFont(new Font("", Font.PLAIN, 18));
        CourseroomField.setFont(new Font("", Font.PLAIN, 18));
        CourseStartDayField.setFont(new Font("", Font.PLAIN, 18));
        CourseStartMonthField.setFont(new Font("", Font.PLAIN, 18));
        CourseStartYearField.setFont(new Font("", Font.PLAIN, 18));
        CourseEndDayField.setFont(new Font("", Font.PLAIN, 18));
        CourseEndMonthField.setFont(new Font("", Font.PLAIN, 18));
        CourseEndYearField.setFont(new Font("", Font.PLAIN, 18));
        DaysOfCourseField.setFont(new Font("", Font.PLAIN, 18));
        InstructorIDField.setFont(new Font("", Font.PLAIN, 18));

        addcourseButton.setFont(new Font("", Font.ITALIC, 25));

        CourseID.setBounds(50, 55, 200, 20);
        CourseName.setBounds(50, 90, 200, 20);
        ParentCourseID.setBounds(50, 125, 200, 20);
        Branch.setBounds(50, 160, 200, 20);
        Courseprice.setBounds(50, 195, 200, 20);
        Courseroom.setBounds(50, 230, 200, 20);
        CourseStartDay.setBounds(50, 265, 200, 20);
        CourseStartMonth.setBounds(50, 300, 200, 20);
        CourseStartYear.setBounds(50, 335, 200, 20);
        CourseEndDay.setBounds(50, 370, 200, 20);
        CourseEndMonth.setBounds(50, 405, 200, 20);
        CourseEndYear.setBounds(50, 440, 200, 20);
        DaysOfCourse.setBounds(50, 475, 200, 20);
        InstructorID.setBounds(50, 510, 200, 20);

        CourseIDField.setBounds(300, 55, 300, 25);
        CourseNameField.setBounds(300, 90, 300, 25);
        ParentCourseIDField.setBounds(300, 125, 300, 25);
        BranchField.setBounds(300, 160, 300, 25);
        CoursepriceField.setBounds(300, 195, 300, 25);
        CourseroomField.setBounds(300, 230, 300, 25);
        CourseStartDayField.setBounds(300, 265, 300, 25);
        CourseStartMonthField.setBounds(300, 300, 300, 25);
        CourseStartYearField.setBounds(300, 335, 300, 25);
        CourseEndDayField.setBounds(300, 370, 300, 25);
        CourseEndMonthField.setBounds(300, 405, 300, 25);
        CourseEndYearField.setBounds(300, 440, 300, 25);
        DaysOfCourseField.setBounds(300, 475, 300, 25);
        InstructorIDField.setBounds(300, 510, 300, 25);
        back.setBounds(0, 560, 150, 50);

        addcourseButton.setBounds(250, 550, 200, 50);

        addcourseButton.setBackground(new Color(251, 172, 35));
        back.setBackground(new Color(251, 172, 35));
        addcourseButton.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        addcourseButton.addActionListener(click);
        back.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("CREATE COURSE");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////CreateCourse PAGE BUTTONS
            if (e.getSource() == addcourseButton) {
                courseID = CourseIDField.getText().toString();
                courseName = CourseNameField.getText().toString();
                parentCourse = ParentCourseIDField.getText().toString();
                branch = BranchField.getText().toString();
                price = Integer.parseInt(CoursepriceField.getText().toString());
                room = Integer.parseInt(CourseroomField.getText().toString());
                startDay = Integer.parseInt(CourseStartDayField.getText().toString());
                startMonth = Integer.parseInt(CourseStartMonthField.getText().toString());
                startYear = Integer.parseInt(CourseStartYearField.getText().toString());
                endDay = Integer.parseInt(CourseEndDayField.getText().toString());
                endMonth = Integer.parseInt(CourseEndMonthField.getText().toString());
                endYear = Integer.parseInt(CourseEndYearField.getText().toString());
                daysOfCourse = Integer.parseInt(DaysOfCourseField.getText().toString());
                instID = Integer.parseInt(InstructorIDField.getText().toString());

                try {
                    if (mc.checkCourses(courseID, courseName) == false) {
                        JOptionPane.showMessageDialog(null, "This course already exists enter another one");
                        CourseIDField.setText("");
                        CourseNameField.setText("");
                        ParentCourseIDField.setText("");
                        BranchField.setText("");
                        CoursepriceField.setText("");
                        CourseroomField.setText("");
                        CourseStartDayField.setText("");
                        CourseStartMonthField.setText("");
                        CourseStartYearField.setText("");
                        CourseEndDayField.setText("");
                        CourseEndMonthField.setText("");
                        CourseEndYearField.setText("");
                        DaysOfCourseField.setText("");
                        InstructorIDField.setText("");
                    } else if (mc.checkInstructor(instID) == true) {
                        JOptionPane.showMessageDialog(null, "Invalid instructor id enter another one or enter (0)");
                        InstructorIDField.setText("");
                    } else {
                        CourseIDField.setText("");
                        CourseNameField.setText("");
                        ParentCourseIDField.setText("");
                        BranchField.setText("");
                        CoursepriceField.setText("");
                        CourseroomField.setText("");
                        CourseStartDayField.setText("");
                        CourseStartMonthField.setText("");
                        CourseStartYearField.setText("");
                        CourseEndDayField.setText("");
                        CourseEndMonthField.setText("");
                        CourseEndYearField.setText("");
                        DaysOfCourseField.setText("");
                        InstructorIDField.setText("");
                        mc.addCourse(courseID, courseName, parentCourse, price,
                                room, branch, instID, startDay,
                                startMonth, startYear, endDay, endMonth, endYear, daysOfCourse);
                        d = 1;
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(CreateCourse.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (mc.isDone(d)) {
                    CreateCourse.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    CreateCourse.this.add(MCHP);
                }

            }
            if (e.getSource() == back) {
                CreateCourse.this.removeAll();
                revalidate();
                repaint();
                ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                CreateCourse.this.add(MCHP);
            }
        }
    }

}
