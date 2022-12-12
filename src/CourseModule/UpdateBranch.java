package CourseModule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateBranch extends JPanel{
    
    /////////////////////////////////////////////////////////////////////////////UpdateBranch needs
    JLabel CourseID = new JLabel("Course ID: ");
    JLabel Branch = new JLabel("New Branch: ");
    

    JTextField CourseIDField = new JTextField();
    JTextField BranchField = new JTextField();
    
    JButton UpdateBranchButton = new JButton("Update");
    JButton back =new JButton ("back");

    String courseID, branch;
    int d=0;

    onButtonClick click = new onButtonClick();
    ManageCourses mc = new ManageCourses();

    public UpdateBranch() {
        ///////////////////////////////////////////////////////////////////////UpdateBranch panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(CourseID);
        this.add(Branch);
        

        this.add(CourseIDField);
        this.add(BranchField);
        

        this.add(UpdateBranchButton);
        this.add(back);

        CourseID.setFont(new Font("", Font.ITALIC, 25));
        Branch.setFont(new Font("", Font.ITALIC, 25));
        
        back.setFont(new Font("", Font.ITALIC, 25));

        CourseIDField.setFont(new Font("", Font.PLAIN, 25));
        BranchField.setFont(new Font("", Font.PLAIN, 25));
        

        UpdateBranchButton.setFont(new Font("", Font.ITALIC, 25));

        CourseID.setBounds(220, 200, 150, 30);
        Branch.setBounds(220, 250, 300, 30);
        
        CourseIDField.setBounds(400, 200, 150, 30);
        BranchField.setBounds(400, 250, 150, 30);
        
        back.setBounds(0, 550, 150, 50);

        UpdateBranchButton.setBounds(300, 400, 150, 50);

        UpdateBranchButton.setBackground(new Color(251, 172, 35));
        back.setBackground(new Color(251, 172, 35));
        UpdateBranchButton.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        UpdateBranchButton.addActionListener(click);
        back.addActionListener(click);


        ///border
        TitledBorder border = new TitledBorder("Update Branch");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////UpdateBranch PAGE BUTTONS
            if (e.getSource() == UpdateBranchButton) {
                courseID = CourseIDField.getText().toString();
                branch = BranchField.getText().toString();
                try {
                    CourseIDField.setText("");
                    BranchField.setText("");
                    mc.updateBranch(courseID, branch);
                                       d=1;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateBranch.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (mc.isDone(d)) {
                    UpdateBranch.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateBranch.this.add(MCHP);
                }

            }
             if (e.getSource() == back) {
                 UpdateBranch.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateBranch.this.add(MCHP);
                            }
        }
    }

}

