package CourseModule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateRoomNumber extends JPanel{
    
    /////////////////////////////////////////////////////////////////////////////UpdateRoomNumber needs
    JLabel CourseID = new JLabel("Course ID: ");
    JLabel CourseRoom = new JLabel("New room No: ");
    

    JTextField CourseIDField = new JTextField();
    JTextField CourseRoomField = new JTextField();
    
    JButton updateRoomNoButton = new JButton("Update");
    JButton back =new JButton ("back");

    String courseID;
    int room, d=0;

    onButtonClick click = new onButtonClick();
    ManageCourses mc = new ManageCourses();

    public UpdateRoomNumber() {
        ///////////////////////////////////////////////////////////////////////UpdateRoomNumber panel content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(CourseID);
        this.add(CourseRoom);
        

        this.add(CourseIDField);
        this.add(CourseRoomField);
        

        this.add(updateRoomNoButton);
        this.add(back);

        CourseID.setFont(new Font("", Font.ITALIC, 25));
        CourseRoom.setFont(new Font("", Font.ITALIC, 25));
        
        back.setFont(new Font("", Font.ITALIC, 25));

        CourseIDField.setFont(new Font("", Font.PLAIN, 25));
        CourseRoomField.setFont(new Font("", Font.PLAIN, 25));
        

        updateRoomNoButton.setFont(new Font("", Font.ITALIC, 25));

        CourseID.setBounds(220, 200, 150, 30);
        CourseRoom.setBounds(220, 250, 300, 30);
        
        CourseIDField.setBounds(400, 200, 150, 30);
        CourseRoomField.setBounds(400, 250, 150, 30);
        
        back.setBounds(0, 550, 150, 50);

        updateRoomNoButton.setBounds(300, 400, 150, 50);

        updateRoomNoButton.setBackground(new Color(251, 172, 35));
        back.setBackground(new Color(251, 172, 35));
        updateRoomNoButton.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        updateRoomNoButton.addActionListener(click);
        back.addActionListener(click);


        ///border
        TitledBorder border = new TitledBorder("Update Room Number");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////UpdateRoomNumber PAGE BUTTONS
            if (e.getSource() == updateRoomNoButton) {
                courseID = CourseIDField.getText().toString();
                room = Integer.parseInt(CourseRoomField.getText().toString());
                try {
                    CourseIDField.setText("");
                    CourseRoomField.setText("");
                    mc.updateRoom(courseID, room);
                                       d=1;

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateRoomNumber.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (mc.isDone(d)) {
                    UpdateRoomNumber.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateRoomNumber.this.add(MCHP);
                }

            }
             if (e.getSource() == back) {
                    UpdateRoomNumber.this.removeAll();
                    revalidate();
                    repaint();
                    ManageCoursesHomePage MCHP = new ManageCoursesHomePage();
                    UpdateRoomNumber.this.add(MCHP);
                            }
        }
    }

}
