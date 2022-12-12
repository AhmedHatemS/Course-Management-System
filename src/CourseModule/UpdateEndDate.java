package CourseModule;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateEndDate extends JPanel{    
    /////////////////////////////////////////////////////////////////////////////UpdateEndDate needs
    JLabel CourseID = new JLabel("Course ID: ");
    JLabel UpdateEndDate = new JLabel("New end date yyyy-mm-dd: ");
    

    JTextField CourseIDField = new JTextField();
    JTextField UpdateEndDateField = new JTextField();
    
    JButton UpdateEndDateButton = new JButton("Update");
    JButton back =new JButton ("back");

    String courseID,endDate;
    int  d=0;

    onButtonClick click = new onButtonClick();
    ManageCourses mc = new ManageCourses();

    public UpdateEndDate() {
        ///////////////////////////////////////////////////////////////////////UpdateEndDate panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(CourseID);
        this.add(UpdateEndDate);
        

        this.add(CourseIDField);
        this.add(UpdateEndDateField);
        

        this.add(UpdateEndDateButton);
        this.add(back);

        CourseID.setFont(new Font("", Font.ITALIC, 25));
        UpdateEndDate.setFont(new Font("", Font.ITALIC, 25));
        
        back.setFont(new Font("", Font.ITALIC, 25));

        CourseIDField.setFont(new Font("", Font.PLAIN, 25));
        UpdateEndDateField.setFont(new Font("", Font.PLAIN, 25));
        

        UpdateEndDateButton.setFont(new Font("", Font.ITALIC, 25));

        CourseID.setBounds(180, 200, 150, 30);
        UpdateEndDate.setBounds(180, 250, 400, 30);
        
        CourseIDField.setBounds(500, 200, 150, 30);
        UpdateEndDateField.setBounds(500, 250, 150, 30);
        
        back.setBounds(0, 550, 150, 50);

        UpdateEndDateButton.setBounds(300, 400, 150, 50);

        UpdateEndDateButton.setBackground(new Color(251, 172, 35));
        back.setBackground(new Color(251, 172, 35));
        UpdateEndDateButton.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        UpdateEndDateButton.addActionListener(click);
        back.addActionListener(click);


        ///border
        TitledBorder border = new TitledBorder("Update End Date");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////UpdateEndDate PAGE BUTTONS
            if (e.getSource() == UpdateEndDateButton) {
                courseID = CourseIDField.getText().toString();
                endDate = UpdateEndDateField.getText().toString();
                try {
                    CourseIDField.setText("");
                    UpdateEndDateField.setText("");
                    mc.updateEndDate(courseID, endDate);
                                       d=1;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateEndDate.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (mc.isDone(d)) {
                    UpdateEndDate.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateEndDate.this.add(MCHP);
                }

            }
             if (e.getSource() == back) {
                    UpdateEndDate.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateEndDate.this.add(MCHP);
                            }
        }
    }

}
