package CourseModule;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdatePriceOfCourse extends JPanel{
    
    /////////////////////////////////////////////////////////////////////////////UpdateParentCourse needs
    JLabel CourseID = new JLabel("Course ID: ");
    JLabel Courseprice = new JLabel("New price: ");
    

    JTextField CourseIDField = new JTextField();
    JTextField CoursepriceField = new JTextField();
    
    JButton updateCoursepriceButton = new JButton("Update");
    JButton back =new JButton ("back");

    String courseID;
    int price, d=0;

    onButtonClick click = new onButtonClick();
    ManageCourses mc = new ManageCourses();

    public UpdatePriceOfCourse() {
        ///////////////////////////////////////////////////////////////////////UpdateParentCourse panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(CourseID);
        this.add(Courseprice);
        

        this.add(CourseIDField);
        this.add(CoursepriceField);
        

        this.add(updateCoursepriceButton);
        this.add(back);

        CourseID.setFont(new Font("", Font.ITALIC, 25));
        Courseprice.setFont(new Font("", Font.ITALIC, 25));
        
        back.setFont(new Font("", Font.ITALIC, 25));

        CourseIDField.setFont(new Font("", Font.PLAIN, 25));
        CoursepriceField.setFont(new Font("", Font.PLAIN, 25));
        

        updateCoursepriceButton.setFont(new Font("", Font.ITALIC, 25));

        CourseID.setBounds(220, 200, 150, 30);
        Courseprice.setBounds(220, 250, 300, 30);
        
        CourseIDField.setBounds(400, 200, 150, 30);
        CoursepriceField.setBounds(400, 250, 150, 30);
        
        back.setBounds(0, 550, 150, 50);

        updateCoursepriceButton.setBounds(300, 400, 150, 50);

        updateCoursepriceButton.setBackground(new Color(251, 172, 35));
        back.setBackground(new Color(251, 172, 35));
        updateCoursepriceButton.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        updateCoursepriceButton.addActionListener(click);
        back.addActionListener(click);


        ///border
        TitledBorder border = new TitledBorder("Update Price Of Course");
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
            if (e.getSource() == updateCoursepriceButton) {
                courseID = CourseIDField.getText().toString();
                price = Integer.parseInt(CoursepriceField.getText().toString());
                try {
                    CourseIDField.setText("");
                    CoursepriceField.setText("");
                    mc.updatePriceOfCourse(courseID, price);
                                       d=1;

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdatePriceOfCourse.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (mc.isDone(d)) {
                    UpdatePriceOfCourse.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdatePriceOfCourse.this.add(MCHP);
                }

            }
             if (e.getSource() == back) {
                 UpdatePriceOfCourse.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdatePriceOfCourse.this.add(MCHP);
                            }
        }
    }

}
