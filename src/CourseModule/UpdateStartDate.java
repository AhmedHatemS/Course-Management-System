package CourseModule;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateStartDate extends JPanel{    
    /////////////////////////////////////////////////////////////////////////////UpdateStartDate needs
    JLabel CourseID = new JLabel("Course ID: ");
    JLabel UpdateStartDate = new JLabel("New start date yyyy-mm-dd: ");
    

    JTextField CourseIDField = new JTextField();
    JTextField UpdateStartDateField = new JTextField();
    
    JButton UpdateStartDateButton = new JButton("Update");
    JButton back =new JButton ("back");

    String courseID,startDate;
    int  d=0;

    onButtonClick click = new onButtonClick();
    ManageCourses mc = new ManageCourses();

    public UpdateStartDate() {
        ///////////////////////////////////////////////////////////////////////UpdateStartDate panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(CourseID);
        this.add(UpdateStartDate);
        

        this.add(CourseIDField);
        this.add(UpdateStartDateField);
        

        this.add(UpdateStartDateButton);
        this.add(back);

        CourseID.setFont(new Font("", Font.ITALIC, 25));
        UpdateStartDate.setFont(new Font("", Font.ITALIC, 25));
        
        back.setFont(new Font("", Font.ITALIC, 25));

        CourseIDField.setFont(new Font("", Font.PLAIN, 25));
        UpdateStartDateField.setFont(new Font("", Font.PLAIN, 25));
        

        UpdateStartDateButton.setFont(new Font("", Font.ITALIC, 25));

        CourseID.setBounds(180, 200, 150, 30);
        UpdateStartDate.setBounds(180, 250, 400, 30);
        
        CourseIDField.setBounds(500, 200, 150, 30);
        UpdateStartDateField.setBounds(500, 250, 150, 30);
        
        back.setBounds(0, 550, 150, 50);

        UpdateStartDateButton.setBounds(300, 400, 150, 50);

        UpdateStartDateButton.setBackground(new Color(251, 172, 35));
        back.setBackground(new Color(251, 172, 35));
        UpdateStartDateButton.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        UpdateStartDateButton.addActionListener(click);
        back.addActionListener(click);


        ///border
        TitledBorder border = new TitledBorder("Update Start Date");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////UpdateStartDate PAGE BUTTONS
            if (e.getSource() == UpdateStartDateButton) {
                courseID = CourseIDField.getText().toString();
                startDate = UpdateStartDateField.getText().toString();
                try {
                    CourseIDField.setText("");
                    UpdateStartDateField.setText("");
                    mc.updateStartDate(courseID, startDate);
                                       d=1;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateStartDate.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (mc.isDone(d)) {
                    UpdateStartDate.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateStartDate.this.add(MCHP);
                }

            }
             if (e.getSource() == back) {
                    UpdateStartDate.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateStartDate.this.add(MCHP);
                            }
        }
    }

}
