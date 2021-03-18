package InstructorModule;

import AdminModule.MainFrame;
import AdminModule.login;
import CourseModule.ShowCourseData;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class INstructor extends JPanel implements ActionListener {

    vn Click = new vn();
    String CID;
    Mouse l = new Mouse();
    JPanel p1 = new JPanel();
//    JPanel p2 = new JPanel();
  //  JPanel p3=new JPanel();
    
    JPanel home = new JPanel();
    JPanel g1 = new JPanel();
    JPanel pshow = new JPanel();
    JPanel pgrade = new JPanel();
    JPanel pgrade1 = new JPanel();
    JLabel WelcomeL = new JLabel("Welcome Instructor");
    JLabel l4 = new JLabel("You can put grades");
    JLabel l5 = new JLabel("You can publish Grades");
    JLabel StudentID = new JLabel("StudentID:");
    JLabel Grade = new JLabel("Grade: ");
    JLabel l2 = new JLabel("Welcome Instructor");
    JLabel l3 = new JLabel(" you can put grades ");
    JLabel L1 = new JLabel("StudentID");
    JLabel L2 = new JLabel("GRADE");
    JLabel L3 = new JLabel("Course ID");
    JTextField cs = new JTextField();
    JTextArea TA1 = new JTextArea();
    JTextArea TA2 = new JTextArea();
    JTextArea TA3 = new JTextArea();
    JTextArea TA4 = new JTextArea();
    JLabel coursesTitleL = new JLabel("ALL GRADES");
    JLabel coursesTitleL1 = new JLabel("ALL GRADES");

    JTextField SDID = new JTextField();
    JTextField GD = new JTextField();
    JButton b1 = new JButton("HOME");
    JButton b2 = new JButton("     Add Grades");
    JButton b3 = new JButton("     Publish grades");
    JButton b5 = new JButton("    Show Student");
    JButton b4 = new JButton("ADD grade");
    JButton Show = new JButton("Show Grades");
    JButton logOut = new JButton("L O G   O U T");
    JLabel SI8 = new JLabel("Course ID");
    JTextField CourseName = new JTextField("");
    //panal student
    JLabel cL2 = new JLabel("FIRST NAME");
    JLabel cL3 = new JLabel("LAST NAME");
    JLabel studentTitleL6 = new JLabel("Student Name");
    JTextArea TAS1 = new JTextArea();
    JTextArea TAS2 = new JTextArea();

    InstructorModule i = new InstructorModule();
    ShowCourseData ST = new ShowCourseData();

    int studentID;
    int grade;

    public INstructor() {
        //the container
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setVisible(true);
        //end of properties of contenier
        p1.setLocation(0, 0);
        p1.setSize(240, 650);
        p1.setLayout(null);
        p1.setBackground(Color.BLACK);
        b1.setBounds(20, 120, 200, 30);
        b2.setBounds(20, 160, 200, 30);
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.white);
        b1.setBorder(null);
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.white);
        b2.setBorder(null);
        b3.setBounds(20, 200, 200, 30);
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.white);
        b3.setBorder(null);
        b5.setBounds(20, 240, 200, 30);
        b5.setBackground(Color.GRAY);
        b5.setForeground(Color.white);
        b5.setBorder(null);
        logOut.setBounds(60, 290, 120, 30);
        logOut.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 10));
        add(p1);
        //this.add(p2);
        p1.add(logOut);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b5);
        home.setLocation(200, 0);
        home.setSize(550, 650);
        home.setLayout(null);
        home.setBackground(Color.BLACK);
        pshow.setLocation(200, 0);
        pshow.setSize(550, 650);
        pshow.setLayout(null);
        pshow.setBackground(Color.lightGray);
        this.add(home);
        this.add(pshow);
        g1.setLocation(200, 0);
        g1.setSize(550, 650);
        g1.setLayout(null);
        g1.setBackground(Color.GRAY);

       // g1.add(p2);
        pgrade.setLocation(200, 0);
        pgrade.setSize(550, 650);
        pgrade.setLayout(null);
        pgrade.setBackground(Color.LIGHT_GRAY);
        this.add(pgrade);
        b1.addActionListener(Click);
        b2.addActionListener(Click);
        b3.addActionListener(Click);
        b5.addActionListener(Click);
        logOut.addActionListener(Click);
        b1.addMouseListener(l);
        b2.addMouseListener(l);
        b3.addMouseListener(l);
        b5.addMouseListener(l);
        //Home panel
        WelcomeL.setBounds(100, 2, 500, 300);
        WelcomeL.setForeground(Color.red);
        WelcomeL.setFont(new Font("candara", Font.ROMAN_BASELINE, 45));
        l4.setBounds(150, 80, 500, 300);
        l4.setForeground(Color.red);
        l4.setFont(new Font("candara", Font.ROMAN_BASELINE, 40));
        l5.setBounds(175, 150, 500, 300);
        l5.setForeground(Color.red);
        l5.setFont(new Font("candara", Font.ROMAN_BASELINE, 25));
        home.add(WelcomeL);
        home.add(l4);
        home.add(l5);
        //end home panel
        //add grade panel
        L3.setBounds(100, 330, 200, 60);
        L3.setForeground(Color.black);
        L3.setFont(new Font("candara", Font.ROMAN_BASELINE, 25));
        cs.setBounds(230, 330, 240, 40);
        StudentID.setBounds(100, 200, 200, 60);
        Grade.setBounds(120, 220, 200, 135);
        l2.setBounds(140, 50, 500, 60);
        l2.setFont(new Font("candara", Font.ROMAN_BASELINE, 40));
        l3.setBounds(170, 100, 500, 60);
        l3.setFont(new Font("candara", Font.ROMAN_BASELINE, 30));
        StudentID.setForeground(Color.black);
        Grade.setForeground(Color.black);
        StudentID.setFont(new Font("candara", Font.ROMAN_BASELINE, 25));
        Grade.setFont(new Font("candara", Font.ROMAN_BASELINE, 25));
        SDID.setBounds(230, 210, 240, 40);
        GD.setBounds(230, 270, 240, 40);
        g1.add(StudentID);
        g1.add(Grade);
        g1.add(GD);
        g1.add(SDID);
        g1.add(b4);
        b4.setBounds(260, 400, 130, 35);
        b4.setFont(new Font("candara", Font.BOLD, 15));
        g1.add(l3);
        g1.add(l2);
        g1.add(L3);
        g1.add(cs);
        b4.addActionListener(Click);
        //end add grade
        //publish
        coursesTitleL.setBounds(180, 30, 500, 50);
        coursesTitleL.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        coursesTitleL1.setBounds(180, 30, 500, 50);
        coursesTitleL1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        L1.setBounds(170, 110, 150, 30);
        L2.setBounds(340, 110, 150, 30);

        L1.setFont(new Font("Candara", Font.BOLD, 20));
        L2.setFont(new Font("Candara", Font.BOLD, 20));

        TA1.setBounds(175, 150, 90, 400);
        TA2.setBounds(340, 150, 120, 400);

        TA1.setBackground(Color.LIGHT_GRAY);
        TA2.setBackground(Color.LIGHT_GRAY);

        TA1.setFont(new Font("Candara", Font.BOLD, 20));
        TA2.setFont(new Font("Candara", Font.BOLD, 20));

        pgrade1.setLocation(200, 0);
        pgrade1.setSize(550, 650);
        pgrade1.setLayout(null);
        pgrade1.setBackground(Color.LIGHT_GRAY);
        SI8.setBounds(100, 140, 150, 30);
        SI8.setFont(new Font("candara", Font.PLAIN, 23));
        CourseName.setBounds(270, 130, 200, 40);
        CourseName.setFont(new Font("candara", Font.ITALIC, 20));
        Show.setBounds(280, 230, 180, 40);
        Show.setFont(new Font("candara", Font.BOLD, 15));
        Show.setBackground(new Color(251, 172, 35));
        Show.setFocusPainted(false);
        Show.addActionListener(Click);
        pgrade1.add(SI8);
        pgrade1.add(CourseName);
        pgrade1.add(coursesTitleL1);
        pgrade1.add(Show);
        pgrade.add(L1);
        pgrade.add(L2);
        pgrade.add(TA1);
        pgrade.add(TA2);
        pgrade.add(coursesTitleL);
        //============Panel show instructor
        ST.ShowStudents();
        TAS1.setText(ST.s1);
        TAS2.setText(ST.s2);

        studentTitleL6.setBounds(150, 50, 500, 50);
        studentTitleL6.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        studentTitleL6.setForeground(Color.black);
        cL2.setBounds(150, 140, 150, 30);
        cL2.setFont(new Font("Candara", Font.BOLD, 18));
        cL2.setForeground(Color.red);
        cL3.setBounds(340, 140, 150, 30);
        cL3.setFont(new Font("Candara", Font.BOLD, 18));
        cL3.setForeground(Color.red);
        TAS1.setBounds(150, 170, 130, 400);
        TAS2.setBounds(340, 170, 130, 400);
        TAS1.setBackground(Color.LIGHT_GRAY);
        TAS2.setBackground(Color.LIGHT_GRAY);
        TAS1.setFont(new Font("Candara", Font.BOLD, 18));
        TAS2.setFont(new Font("Candara", Font.BOLD, 18));
        TAS1.setEditable(false);
        TAS2.setEditable(false);
        pshow.hide();
        pshow.add(cL3);
        pshow.add(cL2);
        pshow.add(TAS1);
        pshow.add(TAS2);
        pshow.add(studentTitleL6);
        //Back button
          
           
       

    }

    

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class vn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == b1) {

                p1.setBackground(Color.BLACK);
                g1.hide();
                pgrade.hide();
                pgrade1.hide();
                pshow.hide();
                home.show();
                add(home);
            }
            if (e.getSource() == b2) {

                p1.setBackground(Color.black);
                home.hide();
                pgrade.hide();
                g1.show();
                pgrade.hide();
                pgrade1.hide();
                pshow.hide();
                add(g1);
            }
            if (e.getSource() == b3) {

                p1.setBackground(Color.DARK_GRAY);
                home.hide();
                g1.hide();
                pgrade.hide();
                pgrade1.show();
                pgrade.hide();
                pshow.hide();
                TA1.setText("");
                TA2.setText("");
                add(pgrade1);
            }
            if (e.getSource() == b5) {

                p1.setBackground(Color.DARK_GRAY);
                home.hide();
                g1.hide();
                pgrade.hide();
                pgrade1.hide();
                pgrade.hide();
                pshow.show();
                add(pshow);
            }
            if (e.getSource() == Show) {

                i.s1 = "";
                i.s2 = "";
                CID = CourseName.getText();
                p1.setBackground(Color.DARK_GRAY);
                home.hide();
                g1.hide();
                pshow.hide();
                pgrade1.hide();
                pgrade.show();
                add(pgrade);
                TA1.setText("");
                TA2.setText("");
                try {
                    CourseName.setText("");

                    i.ShowAllGrade(CID);
                    TA1.setText(i.s1);
                    TA2.setText(i.s2);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(INstructor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == b4) {

                studentID = Integer.parseInt(SDID.getText());
                grade = Integer.parseInt(GD.getText());
                CID = cs.getText().toString();
                try {
                    SDID.setText("");
                    GD.setText("");
                    cs.setText("");
                    i.addGrade(studentID, grade, CID);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(INstructor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(INstructor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (e.getSource() == logOut) {
                   removeAll();
                   revalidate();
                   repaint();
                   login l = new login();
                   INstructor.this.add(l);
            }
        
        }
    }

    public class Mouse implements MouseListener, MouseWheelListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == b1) {
                b1.setForeground(Color.red);

                b2.setForeground(Color.white);
                b3.setForeground(Color.white);
                b5.setForeground(Color.white);
            }
            if (e.getSource() == b2) {
                b1.setForeground(Color.white);

                b2.setForeground(Color.red);
                b3.setForeground(Color.white);
                b5.setForeground(Color.white);
            }
            if (e.getSource() == b3) {
                b1.setForeground(Color.white);

                b2.setForeground(Color.white);
                b3.setForeground(Color.red);
                b5.setForeground(Color.white);

            }
            if (e.getSource() == b5) {
                b1.setForeground(Color.white);
                b2.setForeground(Color.white);
                b3.setForeground(Color.white);
                b5.setForeground(Color.red);

            }
          
   
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == b1) {
                b1.setBackground(Color.DARK_GRAY);
            }
            if (e.getSource() == b2) {
                b2.setBackground(Color.darkGray);
            }
            if (e.getSource() == b3) {
                b3.setBackground(Color.darkGray);
            }
            if (e.getSource() == b5) {
                b5.setBackground(Color.darkGray);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == b1) {
                b1.setBackground(Color.gray);
            }
            if (e.getSource() == b2) {
                b2.setBackground(Color.gray);
            }
            if (e.getSource() == b3) {
                b3.setBackground(Color.gray);
            }
            if (e.getSource() == b5) {
                b5.setBackground(Color.gray);
            }
            if (e.getSource() == b4) {
                TA1.setText("");
                TA2.setText("");
            }
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }
}
