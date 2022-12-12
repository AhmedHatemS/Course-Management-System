package CourseModule;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteCourse extends JPanel{    
    /////////////////////////////////////////////////////////////////////////////DeleteCourse needs
    JLabel CourseID = new JLabel("Course ID: ");
    

    JTextField CourseIDField = new JTextField();
    
    JButton DeleteCourseButton = new JButton("Delete");
    JButton back =new JButton ("back");

    String courseID;
    int d=0;

    onButtonClick click = new onButtonClick();
    ManageCourses mc = new ManageCourses();

    public DeleteCourse() {
        ///////////////////////////////////////////////////////////////////////DeleteCourse panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(CourseID);
       
        this.add(CourseIDField);
        
        this.add(DeleteCourseButton);
        this.add(back);

        CourseID.setFont(new Font("", Font.ITALIC, 25));
        
        back.setFont(new Font("", Font.ITALIC, 25));

        CourseIDField.setFont(new Font("", Font.PLAIN, 25));
        

        DeleteCourseButton.setFont(new Font("", Font.ITALIC, 25));

        CourseID.setBounds(220, 200, 150, 30);
        
        CourseIDField.setBounds(500, 200, 150, 30);
        
        back.setBounds(0, 550, 150, 50);

        DeleteCourseButton.setBounds(300, 400, 150, 50);

        DeleteCourseButton.setBackground(new Color(251, 172, 35));
        back.setBackground(new Color(251, 172, 35));
        DeleteCourseButton.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        DeleteCourseButton.addActionListener(click);
        back.addActionListener(click);


        ///border
        TitledBorder border = new TitledBorder("Delete Course");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////DeleteCourse PAGE BUTTONS
            if (e.getSource() == DeleteCourseButton) {
                courseID = CourseIDField.getText().toString();
                try {
                    CourseIDField.setText("");
                    mc.deleteCourse(courseID);
                                       d=1;

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateParentCourse.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (mc.isDone(d)) {
                    DeleteCourse.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    DeleteCourse.this.add(MCHP);
                }

            }
             if (e.getSource() == back) {
                 DeleteCourse.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    DeleteCourse.this.add(MCHP);
                            }
        }
    }

}
