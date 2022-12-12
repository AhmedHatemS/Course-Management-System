package CourseModule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;
public class UpdateParentCourse extends JPanel{
    
    /////////////////////////////////////////////////////////////////////////////UpdateParentCourse needs
    JLabel CourseID = new JLabel("Course ID: ");
    JLabel ParentCourseID = new JLabel("New parent Course ID: ");
    

    JTextField CourseIDField = new JTextField();
    JTextField ParentCourseIDField = new JTextField();
    
    JButton updateParentCourseButton = new JButton("Update");
    JButton back =new JButton ("back");

    String courseID, parentCourse;
    int d=0;

    onButtonClick click = new onButtonClick();
    ManageCourses mc = new ManageCourses();

    public UpdateParentCourse() {
        ///////////////////////////////////////////////////////////////////////UpdateParentCourse panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(CourseID);
        this.add(ParentCourseID);
        

        this.add(CourseIDField);
        this.add(ParentCourseIDField);
        

        this.add(updateParentCourseButton);
        this.add(back);

        CourseID.setFont(new Font("", Font.ITALIC, 25));
        ParentCourseID.setFont(new Font("", Font.ITALIC, 25));
        
        back.setFont(new Font("", Font.ITALIC, 25));

        CourseIDField.setFont(new Font("", Font.PLAIN, 25));
        ParentCourseIDField.setFont(new Font("", Font.PLAIN, 25));
        

        updateParentCourseButton.setFont(new Font("", Font.ITALIC, 25));

        CourseID.setBounds(220, 200, 150, 30);
        ParentCourseID.setBounds(220, 250, 300, 30);
        
        CourseIDField.setBounds(500, 200, 150, 30);
        ParentCourseIDField.setBounds(500, 250, 150, 30);
        
        back.setBounds(0, 550, 150, 50);

        updateParentCourseButton.setBounds(300, 400, 150, 50);

        updateParentCourseButton.setBackground(new Color(251, 172, 35));
        back.setBackground(new Color(251, 172, 35));
        updateParentCourseButton.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        updateParentCourseButton.addActionListener(click);
        back.addActionListener(click);


        ///border
        TitledBorder border = new TitledBorder("Update Parent Course");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////UpdateParentCourse PAGE BUTTONS
            if (e.getSource() == updateParentCourseButton) {
                courseID = CourseIDField.getText().toString();
                parentCourse = ParentCourseIDField.getText().toString();
                try {
                    CourseIDField.setText("");
                    ParentCourseIDField.setText("");
                    mc.updateParentCourse(courseID, parentCourse);
                                       d=1;

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateParentCourse.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (mc.isDone(d)) {
                    UpdateParentCourse.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateParentCourse.this.add(MCHP);
                }

            }
             if (e.getSource() == back) {
                 UpdateParentCourse.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateParentCourse.this.add(MCHP);
                            }
        }
    }

}
