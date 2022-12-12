package CourseModule;

import MainDriver.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

public class ShowCourseTime extends GlobalVars{

    private String Date;
    private String CourseName;
    public String s7="";
     public String s8="";

    public ShowCourseTime(String Date, String CourseName) {
        this.Date = Date;
        this.CourseName = CourseName;
    }

    public ShowCourseTime() {
    }
    Calendar calendar = Calendar.getInstance();

    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void ShowNearToEnd() throws ClassNotFoundException {
        try {
            ArrayList<ShowCourseTime> List = new ArrayList();

            c = c1.connect();
            ss = c.createStatement();

            query = "select * from courses";
            rs = ss.executeQuery(query);
            //System.out.println("Courses near to end are:");
            while (rs.next()) {
                List.add(new ShowCourseTime(rs.getString("endDate"), rs.getString("courseName")));
            }
            int counter = 0;
            for (int i = 0; i < List.size(); i++) {

                LocalDate firstDate;
                firstDate = LocalDate.parse(List.get(i).Date, formatter);

                long days = ChronoUnit.DAYS.between(date, firstDate);
                if (date.compareTo(firstDate) < 0) {
                    if (days <= 7) {
                         s8+=List.get(i).CourseName;s8+="\n";
                       // System.out.println((++counter) + "- " + List.get(i).CourseName);
                        
                    }
                }

            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException se) {

            }
        }
    }

    public void ShowNearToStart() throws ClassNotFoundException {
        try {
            ArrayList<ShowCourseTime> List = new ArrayList();

            c = c1.connect();
            ss = c.createStatement();

            query = "select * from courses";
            rs = ss.executeQuery(query);
            //System.out.println("Courses near to start are:");
            while (rs.next()) {
                List.add(new ShowCourseTime(rs.getString("startDate"), rs.getString("courseName")));
            }
            int counter = 0;
            for (int i = 0; i < List.size(); i++) {

                LocalDate firstDate;
                firstDate = LocalDate.parse(List.get(i).Date, formatter);

                long days = ChronoUnit.DAYS.between(firstDate, date);
                if (date.compareTo(firstDate) < 0) {
                    if (days <= 7) {
                        
                         s7+=List.get(i).CourseName;s7+="\n";
//                   System.out.println((++counter) + "- " + List.get(i).CourseName);
                    }
                }

            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException se) {

            }
        }
    }

}
