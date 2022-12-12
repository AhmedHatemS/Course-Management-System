package CourseModule;

import AdminModule.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ManageCoursesHomePage extends JPanel {

    JButton createCourse = new JButton("Create course");
    JButton updateAll = new JButton("Update all");
    JButton updateParentCourse = new JButton("Update parent course");
    JButton updateRoomNumber = new JButton("Update room No");
    JButton updateBranch = new JButton("Update branch");
    JButton updatePriceOfCourse = new JButton("Update course's price");
    JButton updateNumberOfDaysOfCourse = new JButton("Update No of days");
    JButton updateStartDate = new JButton("Update start date");
    JButton updateEndDate = new JButton("Update end date");
    JButton deleteCourse = new JButton("Delete course");
    JButton back = new JButton("back");

    onButtonClick click = new onButtonClick();

    public ManageCoursesHomePage() {
        /////////////////////////////////////////////////////////////////////////ManageCoursesHomePage content
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.add(createCourse);
        this.add(updateAll);
        this.add(updateParentCourse);
        this.add(updateRoomNumber);
        this.add(updateBranch);
        this.add(updatePriceOfCourse);
        this.add(updateNumberOfDaysOfCourse);
        this.add(updateStartDate);
        this.add(updateEndDate);
        this.add(deleteCourse);
        this.add(back);

        createCourse.setFont(new Font("", Font.ITALIC, 18));
        updateAll.setFont(new Font("", Font.ITALIC, 18));
        updateParentCourse.setFont(new Font("", Font.ITALIC, 18));
        updateRoomNumber.setFont(new Font("", Font.ITALIC, 18));
        updateBranch.setFont(new Font("", Font.ITALIC, 18));
        updatePriceOfCourse.setFont(new Font("", Font.ITALIC, 18));
        updateNumberOfDaysOfCourse.setFont(new Font("", Font.ITALIC, 18));
        updateStartDate.setFont(new Font("", Font.ITALIC, 18));
        updateEndDate.setFont(new Font("", Font.ITALIC, 18));
        deleteCourse.setFont(new Font("", Font.ITALIC, 18));
        back.setFont(new Font("", Font.ITALIC, 18));

        createCourse.setBounds(25, 90, 220, 50);
        updateAll.setBounds(250, 90, 220, 50);
        updateParentCourse.setBounds(475, 90, 220, 50);
        updateRoomNumber.setBounds(25, 230, 220, 50);
        updateBranch.setBounds(250, 230, 220, 50);
        updatePriceOfCourse.setBounds(475, 230, 220, 50);
        updateNumberOfDaysOfCourse.setBounds(25, 370, 220, 50);
        updateStartDate.setBounds(250, 370, 220, 50);
        updateEndDate.setBounds(475, 370, 220, 50);
        deleteCourse.setBounds(250, 510, 220, 50);
        back.setBounds(0, 560, 150, 50);

        createCourse.setBackground(new Color(33, 33, 33));
        updateAll.setBackground(new Color(33, 33, 33));
        updateParentCourse.setBackground(new Color(33, 33, 33));
        updateRoomNumber.setBackground(new Color(33, 33, 33));
        updateBranch.setBackground(new Color(33, 33, 33));
        updatePriceOfCourse.setBackground(new Color(33, 33, 33));
        updateNumberOfDaysOfCourse.setBackground(new Color(33, 33, 33));
        updateStartDate.setBackground(new Color(33, 33, 33));
        updateEndDate.setBackground(new Color(33, 33, 33));
        deleteCourse.setBackground(new Color(33, 33, 33));
        back.setBackground(new Color(251, 172, 35));

        createCourse.setForeground(new Color(255, 255, 255));
        updateAll.setForeground(new Color(255, 255, 255));
        updateParentCourse.setForeground(new Color(255, 255, 255));
        updateRoomNumber.setForeground(new Color(255, 255, 255));
        updateBranch.setForeground(new Color(255, 255, 255));
        updatePriceOfCourse.setForeground(new Color(255, 255, 255));
        updateNumberOfDaysOfCourse.setForeground(new Color(255, 255, 255));
        updateStartDate.setForeground(new Color(255, 255, 255));
        updateEndDate.setForeground(new Color(255, 255, 255));
        deleteCourse.setForeground(new Color(255, 255, 255));
        back.setForeground(new Color(255, 255, 255));

        createCourse.addActionListener(click);
        updateAll.addActionListener(click);
        updateParentCourse.addActionListener(click);
        updateRoomNumber.addActionListener(click);
        updateBranch.addActionListener(click);
        updatePriceOfCourse.addActionListener(click);
        updateNumberOfDaysOfCourse.addActionListener(click);
        updateStartDate.addActionListener(click);
        updateEndDate.addActionListener(click);
        deleteCourse.addActionListener(click);
        back.addActionListener(click);

        ///border
        TitledBorder border = new TitledBorder("MANAGE COURSES HOME PAGE");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////ManageCoursesHomePage BUTTONS
            removeAll();
            revalidate();
            repaint();
            if (e.getSource() == createCourse) {
                CreateCourse cc = new CreateCourse();
                ManageCoursesHomePage.this.add(cc);
            }
            if (e.getSource() == updateAll) {
                  UpdateAll UA = new UpdateAll();
                  ManageCoursesHomePage.this.add(UA);
            }
            if (e.getSource() == updateParentCourse) {
                UpdateParentCourse UPC = new UpdateParentCourse();
                ManageCoursesHomePage.this.add(UPC);
            }
            if (e.getSource() == updateRoomNumber) {
                UpdateRoomNumber URN = new UpdateRoomNumber();
                ManageCoursesHomePage.this.add(URN);
            }
            if (e.getSource() == updateBranch) {
                UpdateBranch UB = new UpdateBranch();
                ManageCoursesHomePage.this.add(UB);
            }
            if (e.getSource() == updatePriceOfCourse) {
                UpdatePriceOfCourse UPOC = new UpdatePriceOfCourse();
                ManageCoursesHomePage.this.add(UPOC);
            }
            if (e.getSource() == updateNumberOfDaysOfCourse) {
                UpdateNumberOfDaysOfCourse UNODOC = new UpdateNumberOfDaysOfCourse();
                ManageCoursesHomePage.this.add(UNODOC);
            }
            if (e.getSource() == updateStartDate) {
                UpdateStartDate USD = new UpdateStartDate();
                ManageCoursesHomePage.this.add(USD);
            }
            if (e.getSource() == updateEndDate) {
                UpdateEndDate UED = new UpdateEndDate();
                ManageCoursesHomePage.this.add(UED);
            }
            if (e.getSource() == deleteCourse) {
                DeleteCourse DC = new DeleteCourse();
                ManageCoursesHomePage.this.add(DC);
            }
                if (e.getSource() == back) {
                    AdminHomePage AHP = new AdminHomePage();
                    ManageCoursesHomePage.this.add(AHP);
                }

            }

        }

    }
