package AdminModule;

import CourseModule.*;
import StudentModule.StudentShow;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Guest extends JPanel {

    /////////////////////////////////////////////////////////////////////////////Guest needs
    StudentShow Sh = new StudentShow();
    onButtonClick click =new onButtonClick();
    JLabel coursesTitleL = new JLabel("AVAILABLE COURSES");

    JLabel courseL1 = new JLabel("COURSE ID");
    JLabel courseL2 = new JLabel("COURSE NAME");
    JLabel courseL3 = new JLabel("PARENT NAME");
    JLabel courseL4 = new JLabel("START DATE");
    JLabel courseL5 = new JLabel("END DATE");
    JLabel courseL6 = new JLabel("DAYS OF COURSES");
    JLabel courseL7 = new JLabel("PRICE");

    JTextArea TA1 = new JTextArea();
    JTextArea TA2 = new JTextArea();
    JTextArea TA3 = new JTextArea();
    JTextArea TA4 = new JTextArea();
    JTextArea TA5 = new JTextArea();
    JTextArea TA6 = new JTextArea();
    JTextArea TA7 = new JTextArea();
    JButton Back = new JButton("<<Back");

    public Guest() {
        /////////////////////////////////////////////////////////////////////////guest content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);

        ///border
        TitledBorder border = new TitledBorder("guest page");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);

        try {
            Sh.showAllCourse();
            TA1.setText(Sh.s1);
            TA2.setText(Sh.s2);
            TA3.setText(Sh.s3);
            TA4.setText(Sh.s4);
            TA5.setText(Sh.s5);
            TA6.setText(Sh.s6);
            TA7.setText(Sh.s7);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        }

        coursesTitleL.setBounds(140, 30, 500, 50);
        coursesTitleL.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));

        courseL1.setBounds(20, 100, 130, 30);
        courseL2.setBounds(105, 100, 130, 30);
        courseL3.setBounds(215, 100, 130, 30);
        courseL4.setBounds(320, 100, 130, 30);
        courseL5.setBounds(415, 100, 100, 30);
        courseL6.setBounds(510, 100, 150, 30);
        courseL7.setBounds(650, 100, 100, 30);
        courseL1.setFont(new Font("Candara", Font.BOLD, 15));
        courseL2.setFont(new Font("Candara", Font.BOLD, 15));
        courseL3.setFont(new Font("Candara", Font.BOLD, 15));
        courseL4.setFont(new Font("Candara", Font.BOLD, 15));
        courseL5.setFont(new Font("Candara", Font.BOLD, 15));
        courseL6.setFont(new Font("Candara", Font.BOLD, 15));
        courseL7.setFont(new Font("Candara", Font.BOLD, 15));
        TA1.setBounds(30, 130, 70, 650);
        TA2.setBounds(105, 130, 100, 650);
        TA3.setBounds(215, 130, 100, 650);
        TA4.setBounds(320, 130, 90, 650);
        TA5.setBounds(415, 130, 90, 650);
        TA6.setBounds(540, 130, 90, 650);
        TA7.setBounds(660, 130, 80, 650);
        TA1.setEditable(false);
        TA2.setEditable(false);
        TA3.setEditable(false);
        TA4.setEditable(false);
        TA5.setEditable(false);
        TA6.setEditable(false);
        TA7.setEditable(false);
        TA1.setBackground(Color.LIGHT_GRAY);
        TA2.setBackground(Color.LIGHT_GRAY);
        TA3.setBackground(Color.LIGHT_GRAY);
        TA4.setBackground(Color.LIGHT_GRAY);
        TA5.setBackground(Color.LIGHT_GRAY);
        TA6.setBackground(Color.LIGHT_GRAY);
        TA7.setBackground(Color.LIGHT_GRAY);
        TA1.setFont(new Font("Candara", Font.BOLD, 17));
        TA2.setFont(new Font("Candara", Font.BOLD, 17));
        TA3.setFont(new Font("Candara", Font.BOLD, 17));
        TA4.setFont(new Font("Candara", Font.BOLD, 18));
        TA5.setFont(new Font("Candara", Font.BOLD, 18));
        TA6.setFont(new Font("Candara", Font.BOLD, 18));
        TA7.setFont(new Font("Candara", Font.BOLD, 17));
            Back.setFont(new Font("", Font.ITALIC, 25));
            //Back.setBounds(430, 540, 20, 50);
            Back.setBounds(590, 30, 130, 40);
            Back.setBackground(new Color(251, 172, 35));
            Back.setForeground(new Color(255, 255, 255));
            Back.addActionListener(click);
        this.add(coursesTitleL);
        this.add(TA1);
        this.add(courseL1);
        this.add(TA2);
        this.add(courseL2);
        this.add(TA3);
        this.add(courseL3);
        this.add(TA4);
        this.add(courseL4);
        this.add(TA5);
        this.add(courseL5);
        this.add(TA6);
        this.add(courseL6);
        this.add(TA7);
        this.add(courseL7);
        this.add(Back);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////guest PAGE BUTTONS
            removeAll();
            revalidate();
            repaint();
                if (e.getSource() == Back) {
		Guest.this.removeAll();
                revalidate();
                repaint();
                login l = new login();
                Guest.this.add(l);
            }
        }

    }

}
