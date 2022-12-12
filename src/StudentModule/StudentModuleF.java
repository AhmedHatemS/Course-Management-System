package StudentModule;

import AdminModule.AdminHomePage;
import AdminModule.login;
import CourseModule.ShowCourseData;
import CourseModule.ShowCourseTime;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class StudentModuleF extends JPanel {

    private int StudentID, response1 = 1, response2 = 1, response3 = 1, response4 = 1, response5 = 1;
    private String CourseID;
    StudentShow ShowST = new StudentShow();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel homeP = new JPanel();
    JPanel profileP = new JPanel();
    JPanel gradesP = new JPanel();
    JPanel registeredP = new JPanel();
    JPanel registeredP1 = new JPanel();
    JPanel registeredP3 = new JPanel();
    JPanel coursesP = new JPanel();
    JPanel coursesP2 = new JPanel();
    JPanel startP = new JPanel();
    JPanel endP = new JPanel();
    JPanel surveyP = new JPanel();
    JPanel surveyP2 = new JPanel();
    JPanel surveyP3 = new JPanel();
    JPanel surveyP4 = new JPanel();
    JPanel instructorsP = new JPanel();
    JPanel UP = new JPanel();
    JPanel UDAD = new JPanel();
    JPanel UDA = new JPanel();
    JPanel UDP = new JPanel();
    JPanel UDE = new JPanel();

    JButton b1 = new JButton("  >>      HOME");
    JButton b2 = new JButton("  >>      UPDATE PROFILE");
    JButton b3 = new JButton("  >>      GRADES");
    JButton b4 = new JButton("  >>      REGISTERED COURSES");
    JButton b5 = new JButton("  >>      ALL COURSES");
    JButton b6 = new JButton("  >>      COURSES NEAR TO START");
    JButton b7 = new JButton("  >>      COURSES NEAR TO END");
    JButton b8 = new JButton("  >>      TAKE A SURVEY");
    JButton b9 = new JButton("  >>      INSTRUCTORS");

    JButton logOut = new JButton("L O G   O U T");

    ImageIcon icon1 = new ImageIcon(getClass().getResource("/StudentModule/moodleX.png"));
    ImageIcon icon2 = new ImageIcon(getClass().getResource("/StudentModule/logo5.png"));

    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();

    //Home Panel Variables Starts Here!
    JLabel l3 = new JLabel();
    ImageIcon icon3 = new ImageIcon(getClass().getResource("/StudentModule/homexx.png"));
    //Home Panel Variables Ends Here!

    //Profile Panel Variables Starts Here!
    StudentUpdate su = new StudentUpdate();
    private int id;
    private String cI;
    private String password;
    private String FName;
    private String LName;
    private String phone;
    private String Email;
    private String Address;
    private String Nationality;
    JButton UpdatePhone = new JButton("UpdatePhone");

    JButton UpdateEmail = new JButton("UpdateEmail");
    JButton UpdateAddress = new JButton("UpdateAddress");
    JButton UpdateAll = new JButton("UpdateAll");
    JButton UpdatePassword = new JButton("UpdatePassword");
    //Phone
    JLabel SI = new JLabel("Student ID");
    JLabel Phone = new JLabel("Phone");
    JTextField studentIDField = new JTextField("");
    JTextField PhoneField = new JTextField("");
    JButton Updatedp = new JButton("Updated");
    //------------------
    //Address
    JLabel SI2 = new JLabel("Student ID");
    JLabel Address2 = new JLabel("Address");
    JTextField studentIDField2 = new JTextField("");
    JTextField AddressField = new JTextField("");
    JButton Updated2 = new JButton("Updated");
    //__________
    //Password
    JLabel SI3 = new JLabel("Student ID");
    JLabel Password3 = new JLabel("Password");
    JTextField studentIDField3 = new JTextField("");
    JTextField passwordField = new JTextField("");
    JButton Updated3 = new JButton("Updated");
    ///==========
    //Email
    JLabel SI4 = new JLabel("Student ID");
    JLabel Email4 = new JLabel("Email");
    JTextField studentIDField4 = new JTextField("");
    JTextField EmailField = new JTextField("");
    JButton Updated4 = new JButton("Updated");
    ///==========
    JLabel SI5 = new JLabel("Student ID");
    JLabel FName5 = new JLabel("FirstName");
    JLabel LName5 = new JLabel("LastName");
    JLabel Email5 = new JLabel("Email");
    JLabel National5 = new JLabel("Nationality");
    JLabel Phone5 = new JLabel("Phone");
    JLabel Address5 = new JLabel("Address");
    JTextField studentIDField5 = new JTextField("");
    JTextField EmailField5 = new JTextField("");
    JTextField FNameField5 = new JTextField("");
    JTextField LNameField5 = new JTextField("");
    JTextField NationalField5 = new JTextField("");
    JTextField PhoneField5 = new JTextField("");
    JTextField AddressField5 = new JTextField("");
    JButton Updated5 = new JButton("Updated ALL");
    //Profile Panel Variables Ends Here!

    //GRADES Panel Variables Starts Here!
    JLabel gradesTitle = new JLabel("STUDENT GRADES");
    JLabel studentIDL = new JLabel("Student ID");
    JLabel courseIDL = new JLabel("Course ID");
    JLabel validationL = new JLabel("");
    JLabel scoreL = new JLabel("");

    JTextField SIDT = new JTextField();
    JTextField CIDT = new JTextField();

    JButton showGradeB = new JButton("SHOW GRADE");
    //GRADES Panel Variables Ends Here!

    //All Courses Panel Variables Starts Here!
    JLabel coursesTitleL = new JLabel("COURSES INFORMATION");
    JLabel coursesTitleL2 = new JLabel("MORE INFORMATION");
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

    JButton moreDetailsB = new JButton("MORE DETAILS >>");
    //All Courses Panel Variables Ends Here!

    //Registered Courses Panel Variables Starts Here!
   
    RegesterCourse R=new RegesterCourse();  
    JLabel coursesTitleL3 = new JLabel("REGISTERED COURSES");
    JLabel coursesTitleL4 = new JLabel("REGISTERED COURSES");
    JLabel courseL8 = new JLabel("COURSE ID");
    JLabel SI8 = new JLabel("Student ID");
    JLabel SI9 = new JLabel("Student ID");
    JTextField studentIDField8 = new JTextField("");
    JTextArea TA8 = new JTextArea();
  
    JButton Show = new JButton("Show");
    JButton New = new JButton("REGESTED NEW COURSE");
    JButton Sucess = new JButton("REGESTED");
    JLabel coursesR4 = new JLabel("REGISTERED COURSES");
    JLabel courseR8 = new JLabel("COURSE ID");
    
    JTextField c8 = new JTextField("");
    JTextField c9 = new JTextField("");
    //Registered Courses Panel Variables Ends Here!

    //Survey Panel Variables Starts Here!
    StudentShow x = new StudentShow();

    JLabel surveyTitle = new JLabel("SURVEY");
    JLabel studentIDL2 = new JLabel("Student ID");
    JLabel courseIDL2 = new JLabel("Course ID");
    JLabel surveyTitle2 = new JLabel("SURVEY STARTED!");
    JLabel q1 = new JLabel(x.getQuestion1());
    JLabel q2 = new JLabel(x.getQuestion2());
    JLabel q3 = new JLabel(x.getQuestion3());
    JLabel q4 = new JLabel(x.getQuestion4());
    JLabel q5 = new JLabel(x.getQuestion5());

    JTextField SIDT2 = new JTextField();
    JTextField CIDT2 = new JTextField();

    JButton startSurveyB = new JButton("START SURVEY");
    JButton nextB = new JButton("NEXT >>");
    JButton nextB2 = new JButton("NEXT >>");
    JButton backB = new JButton("<< BACK");
    JButton backB2 = new JButton("<< BACK");
    JButton submitB = new JButton("SUBMIT");

    JRadioButton Q1R1 = new JRadioButton(x.getChoice1());
    JRadioButton Q1R2 = new JRadioButton(x.getChoice2());
    JRadioButton Q1R3 = new JRadioButton(x.getChoice3());
    JRadioButton Q1R4 = new JRadioButton(x.getChoice4());
    JRadioButton Q1R5 = new JRadioButton(x.getChoice5());
    ButtonGroup Q1Group = new ButtonGroup();

    JRadioButton Q2R1 = new JRadioButton(x.getChoice1());
    JRadioButton Q2R2 = new JRadioButton(x.getChoice2());
    JRadioButton Q2R3 = new JRadioButton(x.getChoice3());
    JRadioButton Q2R4 = new JRadioButton(x.getChoice4());
    JRadioButton Q2R5 = new JRadioButton(x.getChoice5());
    ButtonGroup Q2Group = new ButtonGroup();

    JRadioButton Q3R1 = new JRadioButton(x.getChoice1());
    JRadioButton Q3R2 = new JRadioButton(x.getChoice2());
    JRadioButton Q3R3 = new JRadioButton(x.getChoice3());
    JRadioButton Q3R4 = new JRadioButton(x.getChoice4());
    JRadioButton Q3R5 = new JRadioButton(x.getChoice5());
    ButtonGroup Q3Group = new ButtonGroup();

    JRadioButton Q4R1 = new JRadioButton(x.getChoice1());
    JRadioButton Q4R2 = new JRadioButton(x.getChoice2());
    JRadioButton Q4R3 = new JRadioButton(x.getChoice3());
    JRadioButton Q4R4 = new JRadioButton(x.getChoice4());
    JRadioButton Q4R5 = new JRadioButton(x.getChoice5());
    ButtonGroup Q4Group = new ButtonGroup();

    JRadioButton Q5R1 = new JRadioButton(x.getChoice1());
    JRadioButton Q5R2 = new JRadioButton(x.getChoice2());
    JRadioButton Q5R3 = new JRadioButton(x.getChoice3());
    JRadioButton Q5R4 = new JRadioButton(x.getChoice4());
    JRadioButton Q5R5 = new JRadioButton(x.getChoice5());
    ButtonGroup Q5Group = new ButtonGroup();
    //Survey Panel Variables Ends Here! 
    //Start time 
    JLabel cL2 = new JLabel("Course NAME");
    JLabel studentTitleL6 = new JLabel("Courses near to start");
    JTextArea TAS1 = new JTextArea();
    ShowCourseTime a = new ShowCourseTime();
    //-----------
    //End time
    JLabel studentTitleL7 = new JLabel("Courses near to END");
    JLabel cL3 = new JLabel("Course NAME");
    JTextArea TAS2 = new JTextArea();
    //Show instructor
    JLabel CL = new JLabel("FIRST NAME");
    JLabel CL1 = new JLabel("LAST NAME");
    JLabel Instructortittle = new JLabel("INSTRUCTOR Name");
    JTextArea TIN = new JTextArea();
    JTextArea TIN2 = new JTextArea();

    ShowCourseData ST = new ShowCourseData();

    Action v = new Action();
    Mouse m = new Mouse();

    public StudentModuleF() {
       // this.setTitle("STUDENT MODULE");
//        this.setSize(750, 650);
//        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//      //  this.setResizable(false);
//        this.setLocation(300, 50);
//        
//        this.setBackground(Color.DARK_GRAY);
//        this.setLayout(null);
        this.setBounds(0, 0, 750, 650);
        this.setLayout(null);
        this.setVisible(true);

        p1.setLocation(0, 0);
        p2.setLocation(200, 0);
        homeP.setLocation(200, 60);
        instructorsP.setLocation(200, 60);
        profileP.setLocation(200, 60);
        gradesP.setLocation(200, 60);
        registeredP.setLocation(200, 60);
        coursesP.setLocation(200, 60);
        startP.setLocation(200, 60);
        endP.setLocation(200, 60);
        surveyP.setLocation(200, 60);
        surveyP2.setLocation(200, 60);
        surveyP3.setLocation(200, 60);
        surveyP4.setLocation(200, 60);

        p1.setSize(200, 650);
        p2.setSize(650, 60);
        homeP.setSize(550, 590);
        instructorsP.setSize(550, 590);
        profileP.setSize(550, 590);
        gradesP.setSize(550, 590);
        registeredP.setSize(550, 590);
        coursesP.setSize(550, 590);
        startP.setSize(550, 590);
        endP.setSize(550, 590);
        surveyP.setSize(550, 590);
        surveyP2.setSize(550, 590);
        surveyP3.setSize(550, 590);
        surveyP4.setSize(550, 590);

        p1.setLayout(null);
        p2.setLayout(null);
        homeP.setLayout(null);
        instructorsP.setLayout(null);
        profileP.setLayout(null);
        endP.setLayout(null);
        startP.setLayout(null);
        gradesP.setLayout(null);
        registeredP.setLayout(null);
        coursesP.setLayout(null);
        surveyP.setLayout(null);
        surveyP2.setLayout(null);
        surveyP3.setLayout(null);
        surveyP4.setLayout(null);

        p1.setBackground(new Color(238, 238, 228));
        p2.setBackground(new Color(238, 238, 228));
        homeP.setBackground(Color.LIGHT_GRAY);
        instructorsP.setBackground(Color.LIGHT_GRAY);
        gradesP.setBackground(Color.LIGHT_GRAY);
        registeredP.setBackground(Color.LIGHT_GRAY);
        endP.setBackground(Color.lightGray);
        coursesP.setBackground(Color.LIGHT_GRAY);
        surveyP.setBackground(Color.LIGHT_GRAY);
        surveyP2.setBackground(Color.LIGHT_GRAY);
        surveyP3.setBackground(Color.LIGHT_GRAY);
        surveyP4.setBackground(Color.LIGHT_GRAY);
        profileP.setBackground(Color.LIGHT_GRAY);
        startP.setBackground(Color.LIGHT_GRAY);

        b1.setBounds(-116, 180, 320, 40);
        b2.setBounds(-77, 220, 300, 40);
        b3.setBounds(-103, 260, 305, 40);
        b4.setBounds(-20, 300, 220, 40);
        b5.setBounds(-85, 340, 300, 40);
        b6.setBounds(-25, 420, 250, 40);
        b7.setBounds(-18, 460, 220, 40);
        b8.setBounds(-60, 500, 260, 40);
        b9.setBounds(-66, 380, 270, 40);

        b1.setBackground(Color.GRAY);
        b1.setForeground(new Color(251, 172, 35));
        b1.setBorder(null);
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.white);
        b2.setBorder(null);
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.white);
        b3.setBorder(null);
        b4.setBackground(Color.GRAY);
        b4.setForeground(Color.white);
        b4.setBorder(null);
        b5.setBackground(Color.GRAY);
        b5.setForeground(Color.white);
        b5.setBorder(null);
        b6.setBackground(Color.GRAY);
        b6.setForeground(Color.white);
        b6.setBorder(null);
        b7.setBackground(Color.GRAY);
        b7.setForeground(Color.white);
        b7.setBorder(null);
        b8.setBackground(Color.GRAY);
        b8.setForeground(Color.white);
        b8.setBorder(null);
        b9.setBackground(Color.GRAY);
        b9.setForeground(Color.white);
        b9.setBorder(null);

        b1.setFont(new Font("comic sans ms", Font.BOLD, 11));
        b2.setFont(new Font("comic sans ms", Font.PLAIN, 11));
        b3.setFont(new Font("comic sans ms", Font.PLAIN, 11));
        b4.setFont(new Font("comic sans ms", Font.PLAIN, 11));
        b5.setFont(new Font("comic sans ms", Font.PLAIN, 11));
        b6.setFont(new Font("comic sans ms", Font.PLAIN, 11));
        b7.setFont(new Font("comic sans ms", Font.PLAIN, 11));
        b8.setFont(new Font("comic sans ms", Font.PLAIN, 11));
        b9.setFont(new Font("comic sans ms", Font.PLAIN, 11));

        b1.setFocusPainted(false);
        b2.setFocusPainted(false);
        b3.setFocusPainted(false);
        b4.setFocusPainted(false);
        b5.setFocusPainted(false);
        b6.setFocusPainted(false);
        b7.setFocusPainted(false);
        b8.setFocusPainted(false);
        b9.setFocusPainted(false);
        logOut.setFocusPainted(false);

        logOut.setBounds(40, 560, 120, 30);
        logOut.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 10));
        logOut.setBackground(new Color(251, 172, 35));

        l1.setIcon(icon1);
        l2.setIcon(icon2);
        l1.setBounds(55, 5, 400, 50);
        l2.setBounds(50, 0, 130, 180);

        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
        p2.add(l1);
        p1.add(l2);
        p1.add(logOut);

        this.add(p1);
        this.add(p2);
        this.add(homeP);
         logOut.addActionListener(v);
        b1.addActionListener(v);
        b2.addActionListener(v);
        b1.addMouseListener(m);
        b2.addMouseListener(m);
        b3.addActionListener(v);
        b4.addActionListener(v);
        b3.addMouseListener(m);
        b4.addMouseListener(m);
        b5.addActionListener(v);
        b6.addActionListener(v);
        b5.addMouseListener(m);
        b6.addMouseListener(m);
        b7.addActionListener(v);
        b8.addActionListener(v);
        b7.addMouseListener(m);
        b8.addMouseListener(m);
        b9.addActionListener(v);
        b9.addMouseListener(m);
        logOut.addActionListener(v);
        logOut.addMouseListener(m);

        //Home Panel Code Stars Here!
        l3.setIcon(icon3);
        l3.setBounds(0, 0, 550, 590);
        homeP.add(l3);
        //Home Panel Code Ends Here!

        //Profile Panel Code Starts Here!
        //profile update panel
        UpdatePhone.setFont(new Font("", Font.ITALIC, 20));
        UpdateEmail.setFont(new Font("", Font.ITALIC, 20));
        UpdateAddress.setFont(new Font("", Font.ITALIC, 20));
        UpdatePassword.setFont(new Font("", Font.ITALIC, 20));
        UpdateAll.setFont(new Font("", Font.ITALIC, 20));
        UpdatePhone.setBounds(30, 100, 220, 50);
        UpdateEmail.setBounds(270, 170, 220, 50);
        UpdateAddress.setBounds(30, 240, 220, 50);
        UpdatePassword.setBounds(270, 330, 220, 50);
        UpdateAll.setBounds(30, 390, 220, 50);
        UpdatePhone.setBackground(new Color(33, 33, 33));
        UpdateEmail.setBackground(new Color(33, 33, 33));
        UpdateAddress.setBackground(new Color(33, 33, 33));
        UpdatePassword.setBackground(new Color(33, 33, 33));
        UpdateAll.setBackground(new Color(33, 33, 33));
        UpdatePhone.setForeground(new Color(255, 255, 255));
        UpdateEmail.setForeground(new Color(255, 255, 255));
        UpdateAddress.setForeground(new Color(255, 255, 255));
        UpdatePassword.setForeground(new Color(255, 255, 255));
        UpdateAll.setForeground(new Color(255, 255, 255));
        profileP.add(UpdatePhone);
        profileP.add(UpdateEmail);
        profileP.add(UpdateAddress);
        profileP.add(UpdatePassword);
        profileP.add(UpdateAll);
        //update phone panel
        UP.setLocation(200, 60);
        UP.setBackground(Color.LIGHT_GRAY);
        UP.setSize(550, 590);
        UP.setLayout(null);
        SI.setBounds(130, 140, 110, 30);
        SI.setFont(new Font("candara", Font.PLAIN, 23));
        studentIDField.setBounds(270, 130, 200, 40);
        studentIDField.setFont(new Font("candara", Font.ITALIC, 20));
        Phone.setBounds(130, 200, 110, 30);
        PhoneField.setBounds(270, 200, 200, 40);
        Phone.setFont(new Font("candara", Font.PLAIN, 23));
        PhoneField.setFont(new Font("candara", Font.ITALIC, 20));
        Updatedp.setBounds(250, 290, 140, 40);
        Updatedp.setFont(new Font("candara", Font.BOLD, 15));
        Updatedp.setBackground(new Color(251, 172, 35));
        Updatedp.setFocusPainted(false);
        Updatedp.addActionListener(v);
        Updatedp.addMouseListener(m);
        UP.add(SI);
        UP.add(Phone);
        UP.add(studentIDField);
        UP.add(PhoneField);
        UP.add(Updatedp);
        UpdatePhone.addActionListener(v);
        //---------
        //Update All panel 
        UDA.setLocation(200, 60);
        UDA.setBackground(Color.LIGHT_GRAY);
        UDA.setSize(550, 590);
        UDA.setLayout(null);
        SI5.setBounds(85, 60, 110, 30);
        SI5.setFont(new Font("candara", Font.PLAIN, 23));
        FName5.setBounds(85, 130, 110, 30);
        FName5.setFont(new Font("candara", Font.PLAIN, 23));
        LName5.setBounds(85, 200, 110, 30);
        LName5.setFont(new Font("candara", Font.PLAIN, 23));
        Phone5.setBounds(85, 270, 110, 30);
        Phone5.setFont(new Font("candara", Font.PLAIN, 23));
        Email5.setBounds(85, 330, 110, 30);
        Email5.setFont(new Font("candara", Font.PLAIN, 23));
        National5.setBounds(85, 400, 110, 30);
        National5.setFont(new Font("candara", Font.PLAIN, 23));
        studentIDField5.setBounds(270, 55, 230, 35);
        studentIDField5.setFont(new Font("candara", Font.ITALIC, 20));
        FNameField5.setBounds(270, 125, 230, 35);
        FNameField5.setFont(new Font("candara", Font.ITALIC, 20));
        LNameField5.setBounds(270, 195, 230, 35);
        LNameField5.setFont(new Font("candara", Font.ITALIC, 20));
        EmailField5.setBounds(270, 325, 230, 35);
        EmailField5.setFont(new Font("candara", Font.ITALIC, 20));
        PhoneField5.setBounds(270, 265, 230, 35);
        PhoneField5.setFont(new Font("candara", Font.ITALIC, 20));
        NationalField5.setBounds(270, 395, 230, 35);
        NationalField5.setFont(new Font("candara", Font.ITALIC, 20));
        UDA.add(SI5);
        UDA.add(Phone5);
        UDA.add(FName5);
        UDA.add(LName5);
        UDA.add(Email5);
        UDA.add(National5);
        UDA.add(studentIDField5);
        UDA.add(FNameField5);
        UDA.add(LNameField5);
        UDA.add(EmailField5);
        UDA.add(PhoneField5);
        UDA.add(NationalField5);
        UDA.add(Updated5);
        Updated5.setBounds(350, 470, 140, 40);
        Updated5.setFont(new Font("candara", Font.BOLD, 15));
        Updated5.setBackground(new Color(251, 172, 35));
        Updated5.setFocusPainted(false);
        Updated5.addActionListener(v);
        Updated5.addMouseListener(m);
        UpdateAll.addActionListener(v);
        //---------Address
        UDAD.setLocation(200, 60);
        UDAD.setBackground(Color.LIGHT_GRAY);
        UDAD.setSize(550, 590);
        UDAD.setLayout(null);
        SI2.setBounds(130, 140, 110, 30);
        SI2.setFont(new Font("candara", Font.PLAIN, 23));
        studentIDField2.setBounds(270, 130, 200, 40);
        studentIDField2.setFont(new Font("candara", Font.ITALIC, 20));
        Address2.setBounds(130, 200, 110, 30);
        AddressField.setBounds(270, 200, 200, 40);
        Address2.setFont(new Font("candara", Font.PLAIN, 23));
        AddressField.setFont(new Font("candara", Font.ITALIC, 20));
        Updated2.setBounds(250, 290, 140, 40);
        Updated2.setFont(new Font("candara", Font.BOLD, 15));
        Updated2.setBackground(new Color(251, 172, 35));
        Updated2.setFocusPainted(false);
        Updated2.addActionListener(v);
        Updated2.addMouseListener(m);
        UDAD.add(SI2);
        UDAD.add(Address2);
        UDAD.add(studentIDField2);
        UDAD.add(AddressField);
        UDAD.add(Updated2);
        UpdateAddress.addActionListener(v);
        //---------
        UDP.setLocation(200, 60);
        UDP.setBackground(Color.LIGHT_GRAY);
        UDP.setSize(550, 590);
        UDP.setLayout(null);
        SI3.setBounds(130, 140, 110, 30);
        SI3.setFont(new Font("candara", Font.PLAIN, 23));
        studentIDField3.setBounds(270, 130, 200, 40);
        studentIDField3.setFont(new Font("candara", Font.ITALIC, 20));
        Password3.setBounds(130, 200, 110, 30);
        Password3.setFont(new Font("candara", Font.PLAIN, 23));
        passwordField.setFont(new Font("candara", Font.ITALIC, 20));
        passwordField.setBounds(270, 200, 200, 40);
        Updated3.setBounds(250, 290, 140, 40);
        Updated3.setFont(new Font("candara", Font.BOLD, 15));
        Updated3.setBackground(new Color(251, 172, 35));
        Updated3.setFocusPainted(false);
        Updated3.addActionListener(v);
        Updated3.addMouseListener(m);
        UDP.add(SI3);
        UDP.add(Password3);
        UDP.add(studentIDField3);
        UDP.add(passwordField);
        UDP.add(Updated3);
        UpdatePassword.addActionListener(v);
        //---------
        UDE.setLocation(200, 60);
        UDE.setBackground(Color.LIGHT_GRAY);
        UDE.setSize(550, 590);
        UDE.setLayout(null);
        SI4.setBounds(130, 140, 110, 30);
        SI4.setFont(new Font("candara", Font.PLAIN, 23));
        studentIDField4.setBounds(270, 130, 200, 40);
        studentIDField4.setFont(new Font("candara", Font.ITALIC, 20));
        Email4.setBounds(130, 200, 110, 30);
        Email4.setFont(new Font("candara", Font.PLAIN, 23));
        EmailField.setFont(new Font("candara", Font.ITALIC, 20));
        EmailField.setBounds(270, 200, 200, 40);
        Updated4.setBounds(250, 290, 140, 40);
        Updated4.setFont(new Font("candara", Font.BOLD, 15));
        Updated4.setBackground(new Color(251, 172, 35));
        Updated4.setFocusPainted(false);
        Updated4.addActionListener(v);
        Updated4.addMouseListener(m);
        UDE.add(SI4);
        UDE.add(Email4);
        UDE.add(studentIDField4);
        UDE.add(EmailField);
        UDE.add(Updated4);
        UpdateEmail.addActionListener(v);
        //---------
        //Profile Panel Code Ends Here!

        //GRADES Panel Code Starts Here!
        gradesTitle.setBounds(100, 50, 400, 30);
        gradesTitle.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        studentIDL.setBounds(130, 140, 110, 30);
        SIDT.setBounds(270, 140, 130, 30);
        studentIDL.setFont(new Font("candara", Font.PLAIN, 23));
        SIDT.setFont(new Font("candara", Font.ITALIC, 20));
        courseIDL.setBounds(130, 200, 110, 30);
        CIDT.setBounds(270, 200, 130, 30);
        courseIDL.setFont(new Font("candara", Font.PLAIN, 23));
        CIDT.setFont(new Font("candara", Font.ITALIC, 20));
        showGradeB.setBounds(200, 290, 140, 40);
        showGradeB.setFont(new Font("candara", Font.BOLD, 15));
        showGradeB.setBackground(new Color(251, 172, 35));
        showGradeB.setFocusPainted(false);
        validationL.setBounds(130, 250, 280, 30);
        validationL.setFont(new Font("candara", Font.BOLD, 25));
        validationL.setForeground(Color.red);
        scoreL.setBounds(160, 380, 250, 30);
        scoreL.setFont(new Font("candara", Font.BOLD, 25));
        gradesP.add(gradesTitle);
        gradesP.add(showGradeB);
        gradesP.add(scoreL);
        gradesP.add(validationL);
        gradesP.add(studentIDL);
        gradesP.add(courseIDL);
        gradesP.add(SIDT);
        gradesP.add(CIDT);
        showGradeB.addActionListener(v);
        showGradeB.addMouseListener(m);
        //GRADES Panel Code Ends Here!

        //All Courses Panel Code Starts Here!
        try {
            ShowST.showAllCourse();
            TA1.setText(ShowST.s1);
            TA2.setText(ShowST.s2);
            TA3.setText(ShowST.s3);
            TA4.setText(ShowST.s4);
            TA5.setText(ShowST.s5);
            TA6.setText(ShowST.s6);
            TA7.setText(ShowST.s7);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
        }
        coursesP2.setLocation(200, 60);
        coursesP2.setBackground(Color.LIGHT_GRAY);
        coursesP2.setSize(550, 590);
        coursesP2.setLayout(null);
        coursesTitleL.setBounds(50, 30, 500, 50);
        coursesTitleL.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        coursesTitleL2.setBounds(80, 30, 500, 50);
        coursesTitleL2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        courseL1.setBounds(40, 110, 150, 30);
        courseL2.setBounds(150, 110, 150, 30);
        courseL3.setBounds(300, 110, 150, 30);
        courseL4.setBounds(50, 110, 150, 30);
        courseL5.setBounds(210, 110, 150, 30);
        courseL6.setBounds(350, 110, 150, 30);
        courseL7.setBounds(450, 110, 150, 30);
        courseL1.setFont(new Font("Candara", Font.BOLD, 18));
        courseL2.setFont(new Font("Candara", Font.BOLD, 18));
        courseL3.setFont(new Font("Candara", Font.BOLD, 18));
        courseL4.setFont(new Font("Candara", Font.BOLD, 18));
        courseL5.setFont(new Font("Candara", Font.BOLD, 18));
        courseL6.setFont(new Font("Candara", Font.BOLD, 18));
        courseL7.setFont(new Font("Candara", Font.BOLD, 18));
        TA1.setBounds(40, 150, 100, 400);
        TA2.setBounds(150, 150, 130, 400);
        TA3.setBounds(300, 150, 130, 400);
        TA4.setBounds(50, 150, 130, 400);
        TA5.setBounds(210, 150, 130, 400);
        TA6.setBounds(350, 150, 130, 400);
        TA7.setBounds(460, 150, 80, 400);
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
        TA1.setFont(new Font("Candara", Font.BOLD, 16));
        TA2.setFont(new Font("Candara", Font.BOLD, 16));
        TA3.setFont(new Font("Candara", Font.BOLD, 16));
        TA4.setFont(new Font("Candara", Font.BOLD, 18));
        TA5.setFont(new Font("Candara", Font.BOLD, 18));
        TA6.setFont(new Font("Candara", Font.BOLD, 18));
        TA7.setFont(new Font("Candara", Font.BOLD, 16));
        moreDetailsB.setBounds(350, 480, 180, 40);
        moreDetailsB.setFont(new Font("candara", Font.BOLD, 15));
        moreDetailsB.setBackground(new Color(251, 172, 35));
        moreDetailsB.setFocusPainted(false);
        moreDetailsB.addActionListener(v);
        moreDetailsB.addMouseListener(m);
        coursesP.add(moreDetailsB);
        coursesP2.add(coursesTitleL2);
        coursesP.add(coursesTitleL);
        coursesP.add(courseL1);
        coursesP.add(courseL2);
        coursesP.add(courseL7);
        coursesP.add(courseL3);
        coursesP2.add(courseL4);
        coursesP2.add(courseL5);
        coursesP2.add(courseL6);
        coursesP.add(TA1);
        coursesP.add(TA2);
        coursesP.add(TA3);
        coursesP2.add(TA4);
        coursesP2.add(TA5);
        coursesP2.add(TA6);
        coursesP.add(TA7);
        //All Courses Panel Code Ends Here!

        //Registered Courses Panel Code Starts Here!
        SI8.setBounds(100, 140, 150, 30);
        SI8.setFont(new Font("candara", Font.PLAIN, 23));
        studentIDField8.setBounds(270, 130, 200, 40);
        studentIDField8.setFont(new Font("candara", Font.ITALIC, 20));
        registeredP1.setLocation(200, 60);
        registeredP1.setBackground(Color.LIGHT_GRAY);
        registeredP1.setSize(550, 590);
        registeredP1.setLayout(null);
        coursesTitleL4.setBounds(60, 30, 500, 50);
        coursesTitleL4.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        coursesTitleL3.setBounds(60, 30, 500, 50);
        coursesTitleL3.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        courseL8.setBounds(220, 110, 150, 30);
        courseL8.setFont(new Font("Candara", Font.BOLD, 23));
        //new
        SI9.setBounds(100, 220, 150, 30);
        SI9.setFont(new Font("candara", Font.PLAIN, 23));
        courseR8.setBounds(100, 140, 150, 30);
        courseR8.setFont(new Font("Candara", Font.BOLD, 23));
        coursesR4.setBounds(60, 30, 500, 50);
        coursesR4.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        c8.setBounds(270, 130, 200, 40);
        c8.setFont(new Font("candara", Font.ITALIC, 20));
        c9.setBounds(270, 210, 200, 40);
        c9.setFont(new Font("candara", Font.ITALIC, 20));
        registeredP3.setLocation(200, 60);
        registeredP3.setBackground(Color.LIGHT_GRAY);
        registeredP3.setSize(550, 590);
        registeredP3.setLayout(null);
        Sucess.setBounds(200, 300, 130, 40);
        Sucess.setFont(new Font("candara", Font.BOLD, 15));
        Sucess.setBackground(new Color(251, 172, 35));
        Sucess.setFocusPainted(false);
        Sucess.addActionListener(v);
        Sucess.addMouseListener(m);
        registeredP3.add(Sucess);
        New.setBounds(300, 420, 200, 40);
        New.setFont(new Font("candara", Font.BOLD, 15));
        New.setBackground(new Color(251, 172, 35));
        New.setFocusPainted(false);
        New.addActionListener(v);
        New.addMouseListener(m);
        registeredP.add(New);
        registeredP3.add(courseR8);
        registeredP3.add(coursesR4);
        registeredP3.add(c8);
        registeredP3.add(SI9);
        registeredP3.add(c9);
        //new
        TA8.setBounds(250, 150, 150, 400);
        TA8.setBackground(Color.LIGHT_GRAY);
        TA8.setEditable(false); 
        TA8.setFont(new Font("Candara", Font.BOLD, 20));
        Show.setBounds(200, 200, 130, 40);
        Show.setFont(new Font("candara", Font.BOLD, 15));
        Show.setBackground(new Color(251, 172, 35));
        Show.setFocusPainted(false);
        Show.addActionListener(v);
        Show.addMouseListener(m);
        registeredP.add(Show);
        registeredP.add(coursesTitleL4);
        registeredP.add(SI8);
        registeredP.add(studentIDField8);
        registeredP1.add(coursesTitleL3);
        registeredP1.add(courseL8);
        registeredP1.add(TA8);
        //Registered Courses Panel Code Ends Here!

        //Survey Panel Code Starts Here!
        surveyTitle.setBounds(190, 50, 200, 30);
        surveyTitle.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        startSurveyB.setBounds(200, 290, 145, 40);
        startSurveyB.setFont(new Font("candara", Font.BOLD, 15));
        startSurveyB.setFocusPainted(false);
        startSurveyB.setBackground(new Color(251, 172, 35));
        studentIDL2.setBounds(130, 140, 110, 30);
        SIDT2.setBounds(270, 140, 130, 30);
        studentIDL2.setFont(new Font("candara", Font.PLAIN, 23));
        SIDT2.setFont(new Font("candara", Font.ITALIC, 20));
        courseIDL2.setBounds(130, 200, 110, 30);
        CIDT2.setBounds(270, 200, 130, 30);
        courseIDL2.setFont(new Font("candara", Font.PLAIN, 23));
        CIDT2.setFont(new Font("candara", Font.ITALIC, 20));
        surveyP.add(surveyTitle);
        surveyP.add(SIDT2);
        surveyP.add(CIDT2);
        surveyP.add(startSurveyB);
        surveyP.add(studentIDL2);
        surveyP.add(courseIDL2);
        surveyP.add(validationL);
        startSurveyB.addActionListener(v);
        nextB.addActionListener(v);
        nextB2.addActionListener(v);
        backB.addActionListener(v);
        backB2.addActionListener(v);
        submitB.addActionListener(v);
        startSurveyB.addMouseListener(m);
        nextB.addMouseListener(m);
        nextB2.addMouseListener(m);
        backB.addMouseListener(m);
        backB2.addMouseListener(m);
        submitB.addMouseListener(m);
        Q1R1.addActionListener(v);
        Q1R2.addActionListener(v);
        Q1R3.addActionListener(v);
        Q1R4.addActionListener(v);
        Q1R5.addActionListener(v);
        Q2R1.addActionListener(v);
        Q2R2.addActionListener(v);
        Q2R3.addActionListener(v);
        Q2R4.addActionListener(v);
        Q2R5.addActionListener(v);
        Q3R1.addActionListener(v);
        Q3R2.addActionListener(v);
        Q3R3.addActionListener(v);
        Q3R4.addActionListener(v);
        Q3R5.addActionListener(v);
        Q4R1.addActionListener(v);
        Q4R2.addActionListener(v);
        Q4R3.addActionListener(v);
        Q4R4.addActionListener(v);
        Q4R5.addActionListener(v);
        Q5R1.addActionListener(v);
        Q5R2.addActionListener(v);
        Q5R3.addActionListener(v);
        Q5R4.addActionListener(v);
        Q5R5.addActionListener(v);

        surveyTitle2.setBounds(100, 40, 400, 30);
        surveyTitle2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));

        q1.setBounds(10, 100, 550, 30);
        q1.setFont(new Font("papyrus", Font.BOLD, 20));
        Q1R1.setBounds(60, 140, 200, 25);
        Q1R1.setFont(new Font("papyrus", Font.BOLD, 16));
        Q1R1.setFocusPainted(false);
        Q1R2.setBounds(60, 170, 200, 25);
        Q1R2.setFont(new Font("papyrus", Font.BOLD, 16));
        Q1R2.setFocusPainted(false);
        Q1R3.setBounds(60, 200, 200, 25);
        Q1R3.setFont(new Font("papyrus", Font.BOLD, 16));
        Q1R3.setFocusPainted(false);
        Q1R4.setBounds(60, 230, 200, 25);
        Q1R4.setFont(new Font("papyrus", Font.BOLD, 16));
        Q1R4.setFocusPainted(false);
        Q1R5.setBounds(60, 260, 200, 25);
        Q1R5.setFont(new Font("papyrus", Font.BOLD, 16));
        Q1R5.setFocusPainted(false);

        q2.setBounds(10, 300, 550, 30);
        q2.setFont(new Font("papyrus", Font.BOLD, 20));
        Q2R1.setBounds(60, 340, 200, 25);
        Q2R1.setFont(new Font("papyrus", Font.BOLD, 16));
        Q2R1.setFocusPainted(false);
        Q2R2.setBounds(60, 370, 200, 25);
        Q2R2.setFont(new Font("papyrus", Font.BOLD, 16));
        Q2R2.setFocusPainted(false);
        Q2R3.setBounds(60, 400, 200, 25);
        Q2R3.setFont(new Font("papyrus", Font.BOLD, 16));
        Q2R3.setFocusPainted(false);
        Q2R4.setBounds(60, 430, 200, 25);
        Q2R4.setFont(new Font("papyrus", Font.BOLD, 16));
        Q2R4.setFocusPainted(false);
        Q2R5.setBounds(60, 460, 200, 25);
        Q2R5.setFont(new Font("papyrus", Font.BOLD, 16));
        Q2R5.setFocusPainted(false);

        nextB.setBounds(400, 490, 110, 40);
        nextB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
        nextB.setFocusPainted(false);
        nextB.setBackground(new Color(251, 179, 55));

        Q1Group.add(Q1R1);
        Q1Group.add(Q1R2);
        Q1Group.add(Q1R3);
        Q1Group.add(Q1R4);
        Q1Group.add(Q1R5);
        Q2Group.add(Q2R1);
        Q2Group.add(Q2R2);
        Q2Group.add(Q2R3);
        Q2Group.add(Q2R4);
        Q2Group.add(Q2R5);
        Q3Group.add(Q3R1);
        Q3Group.add(Q3R2);
        Q3Group.add(Q3R3);
        Q3Group.add(Q3R4);
        Q3Group.add(Q3R5);
        Q4Group.add(Q4R1);
        Q4Group.add(Q4R2);
        Q4Group.add(Q4R3);
        Q4Group.add(Q4R4);
        Q4Group.add(Q4R5);
        Q5Group.add(Q5R1);
        Q5Group.add(Q5R2);
        Q5Group.add(Q5R3);
        Q5Group.add(Q5R4);
        Q5Group.add(Q5R5);
        surveyP2.add(surveyTitle2);
        surveyP2.add(nextB);
        surveyP2.add(q1);
        surveyP2.add(q2);
        surveyP2.add(Q1R1);
        surveyP2.add(Q1R2);
        surveyP2.add(Q1R3);
        surveyP2.add(Q1R4);
        surveyP2.add(Q1R5);
        surveyP2.add(Q2R1);
        surveyP2.add(Q2R2);
        surveyP2.add(Q2R3);
        surveyP2.add(Q2R4);
        surveyP2.add(Q2R5);

        q3.setBounds(10, 20, 550, 30);
        q3.setFont(new Font("papyrus", Font.BOLD, 20));
        Q3R1.setBounds(60, 60, 200, 25);
        Q3R1.setFont(new Font("papyrus", Font.BOLD, 16));
        Q3R1.setFocusPainted(false);
        Q3R2.setBounds(60, 90, 200, 25);
        Q3R2.setFont(new Font("papyrus", Font.BOLD, 16));
        Q3R2.setFocusPainted(false);
        Q3R3.setBounds(60, 120, 200, 25);
        Q3R3.setFont(new Font("papyrus", Font.BOLD, 16));
        Q3R3.setFocusPainted(false);
        Q3R4.setBounds(60, 150, 200, 25);
        Q3R4.setFont(new Font("papyrus", Font.BOLD, 16));
        Q3R4.setFocusPainted(false);
        Q3R5.setBounds(60, 180, 200, 25);
        Q3R5.setFont(new Font("papyrus", Font.BOLD, 16));
        Q3R5.setFocusPainted(false);

        q4.setBounds(10, 240, 550, 30);
        q4.setFont(new Font("papyrus", Font.BOLD, 20));
        Q4R1.setBounds(60, 280, 200, 25);
        Q4R1.setFont(new Font("papyrus", Font.BOLD, 16));
        Q4R1.setFocusPainted(false);
        Q4R2.setBounds(60, 310, 200, 25);
        Q4R2.setFont(new Font("papyrus", Font.BOLD, 16));
        Q4R2.setFocusPainted(false);
        Q4R3.setBounds(60, 340, 200, 25);
        Q4R3.setFont(new Font("papyrus", Font.BOLD, 16));
        Q4R3.setFocusPainted(false);
        Q4R4.setBounds(60, 370, 200, 25);
        Q4R4.setFont(new Font("papyrus", Font.BOLD, 16));
        Q4R4.setFocusPainted(false);
        Q4R5.setBounds(60, 400, 200, 25);
        Q4R5.setFont(new Font("papyrus", Font.BOLD, 16));
        Q4R5.setFocusPainted(false);

        nextB2.setBounds(400, 490, 110, 40);
        nextB2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
        nextB2.setFocusPainted(false);
        nextB2.setBackground(new Color(251, 179, 55));
        backB.setBounds(30, 490, 115, 40);
        backB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
        backB.setFocusPainted(false);
        backB.setBackground(new Color(251, 179, 55));
        backB2.setBounds(30, 490, 115, 40);
        backB2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
        backB2.setFocusPainted(false);
        backB2.setBackground(new Color(251, 179, 55));
        submitB.setBounds(400, 490, 110, 40);
        submitB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
        submitB.setFocusPainted(false);
        submitB.setBackground(new Color(179, 83, 91));
        submitB.setForeground(Color.WHITE);

        q5.setBounds(10, 20, 550, 30);
        q5.setFont(new Font("papyrus", Font.BOLD, 19));
        Q5R1.setBounds(60, 60, 200, 25);
        Q5R1.setFont(new Font("papyrus", Font.BOLD, 16));
        Q5R1.setFocusPainted(false);
        Q5R2.setBounds(60, 90, 200, 25);
        Q5R2.setFont(new Font("papyrus", Font.BOLD, 16));
        Q5R2.setFocusPainted(false);
        Q5R3.setBounds(60, 120, 200, 25);
        Q5R3.setFont(new Font("papyrus", Font.BOLD, 16));
        Q5R3.setFocusPainted(false);
        Q5R4.setBounds(60, 150, 200, 25);
        Q5R4.setFont(new Font("papyrus", Font.BOLD, 16));
        Q5R4.setFocusPainted(false);
        Q5R5.setBounds(60, 180, 200, 25);
        Q5R5.setFont(new Font("papyrus", Font.BOLD, 16));
        Q5R5.setFocusPainted(false);

        surveyP3.add(nextB2);
        surveyP3.add(q3);
        surveyP3.add(q4);
        surveyP3.add(backB);
        surveyP3.add(Q3R1);
        surveyP3.add(Q3R2);
        surveyP3.add(Q3R3);
        surveyP3.add(Q3R4);
        surveyP3.add(Q3R5);
        surveyP3.add(Q4R1);
        surveyP3.add(Q4R2);
        surveyP3.add(Q4R3);
        surveyP3.add(Q4R4);
        surveyP3.add(Q4R5);
        surveyP4.add(q5);
        surveyP4.add(backB2);
        surveyP4.add(submitB);
        surveyP4.add(Q5R1);
        surveyP4.add(Q5R2);
        surveyP4.add(Q5R3);
        surveyP4.add(Q5R4);
        surveyP4.add(Q5R5);
        //Survey Panel Code Ends Here!
        //Start time

        try {
            a.ShowNearToStart();
            TAS1.setText(a.s7);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
        }
        studentTitleL6.setBounds(90, 30, 500, 50);
        studentTitleL6.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        studentTitleL6.setForeground(Color.black);
        cL2.setBounds(200, 90, 150, 30);
        cL2.setFont(new Font("Candara", Font.BOLD, 23));
        cL2.setForeground(Color.red);
        TAS1.setBounds(220, 130, 130, 400);
        TAS1.setBackground(Color.lightGray);
        TAS1.setForeground(Color.BLACK);
        TAS1.setFont(new Font("Candara", Font.BOLD, 18));
        TAS1.setEditable(false);
        TAS2.setEditable(false);
       
        startP.add(cL2);
        startP.add(TAS1);
        startP.add(studentTitleL6);
        //___________
        //End Time
        try {
            a.ShowNearToEnd();
            TAS2.setText(a.s8);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
        }
        studentTitleL7.setBounds(90, 30, 500, 50);
        studentTitleL7.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        studentTitleL7.setForeground(Color.black);
        cL3.setBounds(200, 90, 150, 30);
        cL3.setFont(new Font("Candara", Font.BOLD, 23));
        cL3.setForeground(Color.red);
        TAS2.setBounds(220, 130, 130, 400);
        TAS2.setForeground(Color.black);
        TAS2.setBackground(Color.LIGHT_GRAY);
        TAS2.setFont(new Font("Candara", Font.BOLD, 18));
        endP.add(cL3);
        endP.add(TAS2);
        endP.add(studentTitleL7);
        //Instructor show
        ST.ShowInstructors();
        TIN.setText(ST.s3);
        TIN2.setText(ST.s3);

        Instructortittle.setBounds(90, 50, 500, 50);
        Instructortittle.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 30));
        Instructortittle.setForeground(Color.black);
        CL.setBounds(150, 140, 150, 30);
        CL.setFont(new Font("Candara", Font.BOLD, 18));
        CL.setForeground(Color.red);
        CL1.setBounds(340, 140, 150, 30);
        CL1.setFont(new Font("Candara", Font.BOLD, 18));
        CL1.setForeground(Color.red);
        TIN.setBounds(150, 170, 130, 400);
        TIN2.setBounds(340, 170, 130, 400);
        TIN.setBackground(Color.LIGHT_GRAY);
        TIN2.setBackground(Color.LIGHT_GRAY);
        TIN2.setEditable(false);
        TIN.setEditable(false);
        
        TIN.setFont(new Font("Candara", Font.BOLD, 18));
        TIN2.setFont(new Font("Candara", Font.BOLD, 18));
        instructorsP.add(CL);
        instructorsP.add(CL1);
        instructorsP.add(TIN);
        instructorsP.add(TIN2);
        instructorsP.add(Instructortittle);

    }

    private class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                gradesP.hide();
                registeredP.hide();
                registeredP3.hide();
                coursesP.hide();
                surveyP.hide();
                endP.hide();
                profileP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                UDE.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                instructorsP.hide();
                homeP.show();
                add(homeP);
            }
            if (e.getSource() == b2) {
                homeP.hide();
                registeredP.hide();
                registeredP3.hide();
                coursesP.hide();
                surveyP.hide();
                endP.hide();
                gradesP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                instructorsP.hide();
                UDE.hide();
                profileP.show();
                add(profileP);
            }
            if (e.getSource() == b3) {
                homeP.hide();
                registeredP.hide();
                registeredP3.hide();
                coursesP.hide();
                surveyP.hide();
                endP.hide();
                profileP.hide();
                surveyP2.hide();
                scoreL.hide();
                validationL.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                instructorsP.hide();
                UDE.hide();
                gradesP.show();
                add(gradesP);
            }
            if (e.getSource() == b4) {
              
                homeP.hide();
                gradesP.hide();
                coursesP.hide();
                surveyP.hide();
                endP.hide();
                profileP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                instructorsP.hide();
                UDE.hide();
                registeredP1.hide();
                registeredP3.hide();
                registeredP.show();
                add(registeredP);
            }
            if (e.getSource() == b5) {
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                registeredP3.hide();
                surveyP.hide();
                endP.hide();
                profileP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                instructorsP.hide();
                UDE.hide();
                coursesP.show();
                add(coursesP);
            }
            if (e.getSource() == b6) {
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                surveyP.hide();
                endP.hide();
                coursesP.hide();
                profileP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                instructorsP.hide();
                UDE.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                startP.show();
                add(startP);
            }
            if (e.getSource() == b7) {
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                 registeredP1.hide();
                registeredP3.hide();
                surveyP.hide();
                coursesP.hide();
                instructorsP.hide();
                profileP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                UDE.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                endP.show();
                add(endP);
            }
            if (e.getSource() == b8) {
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                registeredP1.hide();
                registeredP3.hide();
                coursesP.hide();
                endP.hide();
                instructorsP.hide();
                profileP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                UDE.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                surveyP.show();
                add(surveyP);
            }
            if (e.getSource() == b9) {
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                 registeredP1.hide();
                  registeredP3.hide();
                coursesP.hide();
                endP.hide();
                surveyP.hide();
                profileP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                UDE.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                instructorsP.show();
                add(instructorsP);
            }

            if (e.getSource() == showGradeB) {
                scoreL.hide();
                validationL.hide();
                double grade;

                StudentID = Integer.parseInt(SIDT.getText());
                CourseID = CIDT.getText().toString();

                try {
                    if (x.checkStudentID(StudentID)) {
                        if (x.checkRegesteredCourses(StudentID, CourseID)) {
                            grade = x.showGrade(StudentID, CourseID);
                            scoreL.setText("YOUR SCORE IS:   " + grade);
                            scoreL.show();
                        } else {
                            validationL.setText("INVALID COURSE ID!");
                            validationL.show();
                        }
                    } else {
                        validationL.setText("STUDENT ID NOT FOUND!");
                        validationL.show();
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }

                SIDT.setText("");
                CIDT.setText("");
            }

            if (e.getSource() == startSurveyB) {
                validationL.hide();

                StudentID = Integer.parseInt(SIDT2.getText());
                CourseID = CIDT2.getText().toString();

                try {
                    if (x.checkStudentID(StudentID)) {
                        if (x.checkRegesteredCourses(StudentID, CourseID)) {
                            surveyP.hide();
                            surveyP2.show();
                            add(surveyP2);
                        } else {
                            validationL.setText("INVALID COURSE ID!");
                            validationL.show();
                        }
                    } else {
                        validationL.setText("STUDENT ID NOT FOUND!");
                        validationL.show();
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }

                SIDT2.setText("");
                CIDT2.setText("");
            }

            if (e.getSource() == moreDetailsB) {
                coursesP.hide();
                coursesP2.show();
                add(coursesP2);
            }
            if (e.getSource() == Show) {
                ShowST.s8="";
                registeredP.hide();
                registeredP3.hide();
                registeredP1.show();
                add(registeredP1);
                try {
                    StudentID = Integer.parseInt(studentIDField8.getText().toString());
                    ShowST.showRegesteredCourses(StudentID);
                    TA8.setText(ShowST.s8);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            if (e.getSource() == New) {
               
                registeredP.hide();
                 registeredP1.hide();
                registeredP3.show();
                add(registeredP3);
            }

            if (e.getSource() == nextB) {
                surveyP2.hide();
                surveyP3.show();
                add(surveyP3);
            }
            if (e.getSource() == nextB2) {
                surveyP3.hide();
                surveyP4.show();
                add(surveyP4);
            }
            if (e.getSource() == backB) {
                surveyP3.hide();
                surveyP2.show();
                add(surveyP2);
            }
            if (e.getSource() == backB2) {
                surveyP4.hide();
                surveyP3.show();
                add(surveyP3);
            }

            if (e.getSource() == Q1R1) {
                response1 = 1;
            }
            if (e.getSource() == Q1R2) {
                response1 = 2;
            }
            if (e.getSource() == Q1R3) {
                response1 = 3;
            }
            if (e.getSource() == Q1R4) {
                response1 = 4;
            }
            if (e.getSource() == Q1R5) {
                response1 = 5;
            }

            if (e.getSource() == Q2R1) {
                response2 = 1;
            }
            if (e.getSource() == Q2R2) {
                response2 = 2;
            }
            if (e.getSource() == Q2R3) {
                response2 = 3;
            }
            if (e.getSource() == Q2R4) {
                response2 = 4;
            }
            if (e.getSource() == Q2R5) {
                response2 = 5;
            }

            if (e.getSource() == Q3R1) {
                response3 = 1;
            }
            if (e.getSource() == Q3R2) {
                response3 = 2;
            }
            if (e.getSource() == Q3R3) {
                response3 = 3;
            }
            if (e.getSource() == Q3R4) {
                response3 = 4;
            }
            if (e.getSource() == Q3R5) {
                response3 = 5;
            }

            if (e.getSource() == Q4R1) {
                response4 = 1;
            }
            if (e.getSource() == Q4R2) {
                response4 = 2;
            }
            if (e.getSource() == Q4R3) {
                response4 = 3;
            }
            if (e.getSource() == Q4R4) {
                response4 = 4;
            }
            if (e.getSource() == Q4R5) {
                response4 = 5;
            }

            if (e.getSource() == Q5R1) {
                response5 = 1;
            }
            if (e.getSource() == Q5R2) {
                response5 = 2;
            }
            if (e.getSource() == Q5R3) {
                response5 = 3;
            }
            if (e.getSource() == Q5R4) {
                response5 = 4;
            }
            if (e.getSource() == Q5R5) {
                response5 = 5;
            }

            if (e.getSource() == submitB) {
                x.setResponse1(response1);
                x.setResponse2(response2);
                x.setResponse3(response3);
                x.setResponse4(response4);
                x.setResponse5(response5);
                try {
                    x.insertResponses(StudentID, CourseID);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "SURVEY ENDED!");
                JOptionPane.showMessageDialog(null, "YOUR SURVEY HAS BEEN SUBMITTED SUCCESSFULLY! \nTHANK YOU!  ^.^");
                surveyP4.hide();
                surveyP.show();
                add(surveyP);
            }

//            if (e.getSource() == logOut) {
//                homeP.hide();
//                gradesP.hide();
//                registeredP.hide();
//                coursesP.hide();
//                surveyP.hide();
//                endP.hide();
//                profileP.hide();
//                surveyP2.hide();
//                surveyP3.hide();
//                surveyP4.hide();
//                startP.hide();
//                p1.hide();
//                p2.hide();
//            }
            if (e.getSource() == UpdatePhone) {
                profileP.hide();
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                coursesP.hide();
                endP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                surveyP.hide();
                UDA.hide();
                UDP.hide();
                UDE.hide();
                UDAD.hide();
                UP.show();
                add(UP);
            }
            if (e.getSource() == UpdateAddress) {
                profileP.hide();
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                coursesP.hide();
                endP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                surveyP.hide();
                UP.hide();
                UDA.hide();
                UDP.hide();
                UDE.hide();
                UDAD.show();
                add(UDAD);
            }
            if (e.getSource() == UpdateAll) {
                profileP.hide();
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                coursesP.hide();
                endP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                surveyP.hide();
                UP.hide();
                UDP.hide();
                UDE.hide();
                UDAD.hide();
                UDA.show();
                add(UDA);
            }
            if (e.getSource() == UpdatePassword) {
                profileP.hide();
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                coursesP.hide();
                endP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                surveyP.hide();
                UP.hide();
                UDE.hide();
                UDAD.hide();
                UDA.hide();
                UDP.show();
                add(UDP);
            }
            if (e.getSource() == UpdateEmail) {
                profileP.hide();
                homeP.hide();
                gradesP.hide();
                registeredP.hide();
                coursesP.hide();
                endP.hide();
                surveyP2.hide();
                surveyP3.hide();
                surveyP4.hide();
                startP.hide();
                surveyP.hide();
                UP.hide();
                UDAD.hide();
                UDA.hide();
                UDP.hide();
                UDE.show();
                add(UDE);
            }

            if (e.getSource() == Updatedp) {
                //profileP.hide();
                //UP.show(); 
                id = Integer.parseInt(studentIDField.getText().toString());
                phone = PhoneField.getText().toString();
                try {
                    studentIDField.setText("");
                    PhoneField.setText("");
                    su.UpdatePhone(id, phone);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (e.getSource() == Updated3) {
                // profileP.hide();
                // UDP.show(); 
                id = Integer.parseInt(studentIDField3.getText().toString());
                password = passwordField.getText().toString();
                try {
                    studentIDField3.setText("");
                    passwordField.setText("");
                    su.updatePassword(id, password);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (e.getSource() == Updated2) {
                //profileP.hide();
                //UDAD.show(); 
                id = Integer.parseInt(studentIDField2.getText().toString());
                Address = AddressField.getText().toString();
                try {
                    studentIDField2.setText("");
                    AddressField.setText("");
                    su.UpdateAddress(id, Address);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (e.getSource() == Updated4) {
                //profileP.hide();
                //UDAD.show(); 
                id = Integer.parseInt(studentIDField4.getText().toString());
                Email = EmailField.getText().toString();
                try {
                    studentIDField4.setText("");
                    EmailField.setText("");
                    su.UpdateEmail(id, Email);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (e.getSource() == Updated5) {
                //profileP.hide();
                //UDAD.show(); 
                id = Integer.parseInt(studentIDField5.getText().toString());
                Email = EmailField5.getText().toString();
                phone = PhoneField5.getText().toString();
                FName = FNameField5.getText().toString();
                LName = LNameField5.getText().toString();
                Nationality = NationalField5.getText().toString();

                try {
                    studentIDField4.setText("");
                    EmailField5.setText("");
                    PhoneField5.setText("");
                    FNameField5.setText("");
                    LNameField5.setText("");
                    NationalField5.setText("");

                    su.UpdateAll(id, Email, phone, FName, LName, Nationality);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
               if (e.getSource() == Sucess) {
                //profileP.hide();
                //UDAD.show(); 
                id = Integer.parseInt(c9.getText().toString());
                cI = c8.getText().toString();
                try {
                    c9.setText("");
                    c8.setText("");
                   R.regesterCourse(id, cI);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModuleF.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
                    if (e.getSource() == logOut) {
                   removeAll();
                   revalidate();
                   repaint();
                   login l = new login();
                   StudentModuleF.this.add(l);
            }
          
          
        }
    }

    public class Mouse implements MouseListener, MouseWheelListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == b1) {
                b1.setForeground(new Color(251, 172, 35));
                b1.setFont(new Font("comic sans ms", Font.BOLD, 11));

                b2.setForeground(Color.white);
                b2.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b3.setForeground(Color.white);
                b3.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b4.setForeground(Color.white);
                b4.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b5.setForeground(Color.white);
                b5.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setForeground(Color.white);
                b6.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b7.setForeground(Color.white);
                b7.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b8.setForeground(Color.white);
                b8.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b9.setForeground(Color.white);
                b9.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setText("  >>      COURSES NEAR TO START");
            }
            if (e.getSource() == b2) {
                b2.setForeground(new Color(251, 172, 35));
                b2.setFont(new Font("comic sans ms", Font.BOLD, 11));

                b1.setForeground(Color.white);
                b1.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b3.setForeground(Color.white);
                b3.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b4.setForeground(Color.white);
                b4.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b5.setForeground(Color.white);
                b5.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setForeground(Color.white);
                b6.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b7.setForeground(Color.white);
                b7.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b8.setForeground(Color.white);
                b8.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b9.setForeground(Color.white);
                b9.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setText("  >>      COURSES NEAR TO START");
            }
            if (e.getSource() == b3) {
                b3.setForeground(new Color(251, 172, 35));
                b3.setFont(new Font("comic sans ms", Font.BOLD, 11));

                b1.setForeground(Color.white);
                b1.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b2.setForeground(Color.white);
                b2.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b4.setForeground(Color.white);
                b4.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b5.setForeground(Color.white);
                b5.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setForeground(Color.white);
                b6.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b7.setForeground(Color.white);
                b7.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b8.setForeground(Color.white);
                b8.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b9.setForeground(Color.white);
                b9.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setText("  >>      COURSES NEAR TO START");
            }
            if (e.getSource() == b4) {
                b4.setForeground(new Color(251, 172, 35));
                b4.setFont(new Font("comic sans ms", Font.BOLD, 11));

                b1.setForeground(Color.white);
                b1.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b2.setForeground(Color.white);
                b2.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b3.setForeground(Color.white);
                b3.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b5.setForeground(Color.white);
                b5.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setForeground(Color.white);
                b6.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b7.setForeground(Color.white);
                b7.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b8.setForeground(Color.white);
                b8.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b9.setForeground(Color.white);
                b9.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setText("  >>      COURSES NEAR TO START");
            }
            if (e.getSource() == b5) {
                b5.setForeground(new Color(251, 172, 35));
                b5.setFont(new Font("comic sans ms", Font.BOLD, 11));

                b1.setForeground(Color.white);
                b1.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b2.setForeground(Color.white);
                b2.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b3.setForeground(Color.white);
                b3.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b4.setForeground(Color.white);
                b4.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setForeground(Color.white);
                b6.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b7.setForeground(Color.white);
                b7.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b8.setForeground(Color.white);
                b8.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b9.setForeground(Color.white);
                b9.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setText("  >>      COURSES NEAR TO START");
            }
            if (e.getSource() == b6) {
                b6.setForeground(new Color(251, 172, 35));
                b6.setText("  >>    COURSES NEAR TO START");
                b6.setFont(new Font("comic sans ms", Font.BOLD, 11));

                b1.setForeground(Color.white);
                b1.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b2.setForeground(Color.white);
                b2.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b3.setForeground(Color.white);
                b3.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b4.setForeground(Color.white);
                b4.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b5.setForeground(Color.white);
                b5.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b7.setForeground(Color.white);
                b7.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b8.setForeground(Color.white);
                b8.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b9.setForeground(Color.white);
                b9.setFont(new Font("comic sans ms", Font.PLAIN, 11));
            }
            if (e.getSource() == b7) {
                b7.setForeground(new Color(251, 172, 35));
                b7.setFont(new Font("comic sans ms", Font.BOLD, 11));

                b1.setForeground(Color.white);
                b1.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b2.setForeground(Color.white);
                b2.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b3.setForeground(Color.white);
                b3.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b4.setForeground(Color.white);
                b4.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b5.setForeground(Color.white);
                b5.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setForeground(Color.white);
                b6.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b8.setForeground(Color.white);
                b8.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b9.setForeground(Color.white);
                b9.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setText("  >>      COURSES NEAR TO START");
            }
            if (e.getSource() == b8) {
                b8.setForeground(new Color(251, 172, 35));
                b8.setFont(new Font("comic sans ms", Font.BOLD, 11));

                b1.setForeground(Color.white);
                b1.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b2.setForeground(Color.white);
                b2.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b3.setForeground(Color.white);
                b3.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b4.setForeground(Color.white);
                b4.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b5.setForeground(Color.white);
                b5.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setForeground(Color.white);
                b6.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b7.setForeground(Color.white);
                b7.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b9.setForeground(Color.white);
                b9.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setText("  >>      COURSES NEAR TO START");
            }
            if (e.getSource() == b9) {
                b9.setForeground(new Color(251, 172, 35));
                b9.setFont(new Font("comic sans ms", Font.BOLD, 11));

                b1.setForeground(Color.white);
                b1.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b2.setForeground(Color.white);
                b2.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b3.setForeground(Color.white);
                b3.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b4.setForeground(Color.white);
                b4.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b5.setForeground(Color.white);
                b5.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setForeground(Color.white);
                b6.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b7.setForeground(Color.white);
                b7.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b8.setForeground(Color.white);
                b8.setFont(new Font("comic sans ms", Font.PLAIN, 11));
                b6.setText("  >>      COURSES NEAR TO START");
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
                b1.setBackground(new Color(255, 153, 0));
            }
            if (e.getSource() == b2) {
                b2.setBackground(new Color(255, 153, 0));
            }
            if (e.getSource() == b3) {
                b3.setBackground(new Color(255, 153, 0));
            }
            if (e.getSource() == b4) {
                b4.setBackground(new Color(255, 153, 0));
            }
            if (e.getSource() == b5) {
                b5.setBackground(new Color(255, 153, 0));
            }
            if (e.getSource() == b6) {
                b6.setBackground(new Color(255, 153, 0));
            }
            if (e.getSource() == b7) {
                b7.setBackground(new Color(255, 153, 0));
            }
            if (e.getSource() == b8) {
                b8.setBackground(new Color(255, 153, 0));
            }
            if (e.getSource() == b9) {
                b9.setBackground(new Color(255, 153, 0));
            }
            if (e.getSource() == logOut) {
                logOut.setBackground(new Color(250, 160, 5));
                logOut.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 11));
            }
            if (e.getSource() == showGradeB) {
                showGradeB.setBackground(new Color(250, 160, 5));
                showGradeB.setFont(new Font("candara", Font.BOLD, 16));
            }
            if (e.getSource() == startSurveyB) {
                startSurveyB.setBackground(new Color(250, 160, 5));
                startSurveyB.setFont(new Font("candara", Font.BOLD, 16));
            }
            if (e.getSource() == nextB) {
                nextB.setBackground(new Color(250, 160, 5));
                nextB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 16));
            }
            if (e.getSource() == nextB2) {
                nextB2.setBackground(new Color(250, 160, 5));
                nextB2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 16));
            }
            if (e.getSource() == backB) {
                backB.setBackground(new Color(250, 160, 5));
                backB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 16));
            }
            if (e.getSource() == backB2) {
                backB2.setBackground(new Color(250, 160, 5));
                backB2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 16));
            }
            if (e.getSource() == submitB) {
                submitB.setBackground(new Color(193, 113, 120));
                submitB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 16));
            }
            if (e.getSource() == Updatedp) {
                Updatedp.setBackground(new Color(250, 160, 5));
                Updatedp.setFont(new Font("candara", Font.BOLD, 16));
            }
            if (e.getSource() == Updated2) {
                Updated2.setBackground(new Color(250, 160, 5));
                Updated2.setFont(new Font("candara", Font.BOLD, 16));
            }
            if (e.getSource() == Updated3) {
                Updated3.setBackground(new Color(250, 160, 5));
                Updated3.setFont(new Font("candara", Font.BOLD, 16));
            }
            if (e.getSource() == Updated4) {
                Updated4.setBackground(new Color(250, 160, 5));
                Updated4.setFont(new Font("candara", Font.BOLD, 16));
            }
           

        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == b1) {
                b1.setBackground(Color.GRAY);
            }
            if (e.getSource() == b2) {
                b2.setBackground(Color.GRAY);
            }
            if (e.getSource() == b3) {
                b3.setBackground(Color.GRAY);
            }
            if (e.getSource() == b4) {
                b4.setBackground(Color.GRAY);
            }
            if (e.getSource() == b5) {
                b5.setBackground(Color.GRAY);
            }
            if (e.getSource() == b6) {
                b6.setBackground(Color.GRAY);
            }
            if (e.getSource() == b7) {
                b7.setBackground(Color.GRAY);
            }
            if (e.getSource() == b8) {
                b8.setBackground(Color.GRAY);
            }
            if (e.getSource() == b9) {
                b9.setBackground(Color.GRAY);
            }
            if (e.getSource() == logOut) {
                logOut.setBackground(new Color(251, 172, 35));
                logOut.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 10));
            }
            if (e.getSource() == showGradeB) {
                showGradeB.setBackground(new Color(251, 172, 35));
                showGradeB.setFont(new Font("candara", Font.BOLD, 15));
            }
            if (e.getSource() == startSurveyB) {
                startSurveyB.setBackground(new Color(251, 172, 35));
                startSurveyB.setFont(new Font("candara", Font.BOLD, 15));
            }
            if (e.getSource() == nextB) {
                nextB.setBackground(new Color(251, 179, 55));
                nextB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
            }
            if (e.getSource() == nextB2) {
                nextB2.setBackground(new Color(251, 179, 55));
                nextB2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
            }
            if (e.getSource() == backB) {
                backB.setBackground(new Color(251, 179, 55));
                backB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
            }
            if (e.getSource() == backB2) {
                backB2.setBackground(new Color(251, 179, 55));
                backB2.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
            }
            if (e.getSource() == submitB) {
                submitB.setBackground(new Color(179, 83, 91));
                submitB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
            }
            if (e.getSource() == Updatedp) {
                Updatedp.setBackground(new Color(251, 172, 35));
                Updatedp.setFont(new Font("candara", Font.BOLD, 15));
            }
            if (e.getSource() == Updated2) {
                Updated2.setBackground(new Color(251, 172, 35));
                Updated2.setFont(new Font("candara", Font.BOLD, 15));
            }
            if (e.getSource() == Updated3) {
                Updated3.setBackground(new Color(251, 172, 35));
                Updated3.setFont(new Font("candara", Font.BOLD, 15));
            }
            if (e.getSource() == Updated4) {
                Updated4.setBackground(new Color(251, 172, 35));
                Updated4.setFont(new Font("candara", Font.BOLD, 15));
            }
             if (e.getSource()==b4)
            {
              studentIDField8.setText("");
              TA8.setText("");
                
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
