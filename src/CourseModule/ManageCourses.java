package CourseModule;

import MainDriver.*;
import java.sql.*;
import javax.swing.*;


public class ManageCourses extends GlobalVars {

    
    private String courseID;
    private String courseName;
    private String parentCourse;
    private String branch;
    private int price;
    private int room;
    private int instID;
    private String startDate;
    private String endDate;
    private int startDay;
    private int startMonth;
    private int startYear;
    private int endDay;
    private int endMonth;
    private int endYear;
    private int daysOfCourse;
    private int d = 0; 
//no arg constructor

    public ManageCourses() {
    }
    
    //method to return start date in the form of string

    private String getStartDate(int startDay, int startMonth, int startYear) {
        String s;
         this.startDay = startDay;
            this.startMonth = startMonth;
            this.startYear = startYear;
        s = "" + this.startYear + "-" + this.startMonth + "-" + this.startDay;
        return s;
    }
    //method to return end date in the form of string

    private String getEndDate(int endDay, int endMonth, int endYear) {
        String x;
            this.endDay = endDay;
            this.endMonth = endMonth;
            this.endYear = endYear;
        x = "" + this.endYear + "-" +this.endMonth + "-" +this.endDay;
        return x;
    }

    // method to check if the entered course exist or not return false if it is existed and true if not 
    public boolean checkCourses(String courseID, String courseName) throws SQLException, ClassNotFoundException {
        c = c1.connect();
        ss = c.createStatement();
        this.courseID= courseID;
        this.courseName = courseName;
           
        try {
            query = "SELECT COUNT (courses.courseID) AS rowsCount FROM courses where courses.courseName LIKE '" + this.courseName + "'";
            rs = ss.executeQuery(query);
            rs.next();
            if (rs.getInt("rowsCount") == 1) {

                return false;
            } else {
                return true;
            }

        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
        }
        return true;
    }

    // method to check if the entered instructor id exist or not in the table of instructor return false if it is existed and true if not 
    public boolean checkInstructor(int instID) throws SQLException, ClassNotFoundException {
        c = c1.connect();
        ss = c.createStatement();
            this.instID = instID;
          
        try {
            query = "SELECT COUNT (instructor.instID) AS rowsCount FROM instructor where instructor.instID LIKE '" + this.instID + "'";
            rs = ss.executeQuery(query);
            rs.next();
            if (rs.getInt("rowsCount") == 1 || this.instID == 0) {

                return false;
            } else {
                return true;
            }

        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
        }
        return true;
    }
    public boolean isDone(int d) { 
        return d == 1 ? true : false;
    }

    
    // method to change the parent course with null in case of deleting the course
    private void checkParent(String parentCourse) throws SQLException, ClassNotFoundException {
        c = c1.connect();
        ss = c.createStatement();
            this.parentCourse = parentCourse;
            
        try {
            query = "update courses set parentCourse='null' where parentCourse='" + this.parentCourse + "'";
            ss.execute(query);
                JOptionPane.showMessageDialog(null, "Deleted successfully");
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } 
    }
    // method to add course

    public void addCourse(String courseID, String courseName, String parentCourse, int price,
            int room, String branch, int instID, int startDay,
            int startMonth, int startYear, int endDay, int endMonth, int endYear, int daysOfCourse) throws SQLException, ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
            this.courseID = courseID;
            this.courseName = courseName;
            this.parentCourse = parentCourse;
            this.price = price;
            this.room = room;
            this.branch = branch;
            this.instID = instID;
            this.startDay = startDay;
            this.startMonth = startMonth;
            this.startYear = startYear;
            this.endDay = endDay;
            this.endMonth = endMonth;
            this.endYear = endYear;
            this.daysOfCourse = daysOfCourse;
            this.startDate = getStartDate(startDay, startMonth, startYear);
            this.endDate = getEndDate(endDay, endMonth, endYear);
             
            query = "insert into courses values('" + this.courseID + "', '" + this.courseName + "','" + this.parentCourse + "','" + this.startDate + "','" + this.endDate + "','" + this.daysOfCourse + "','" + this.price + "','" + this.room + "','" + this.branch + "','" + this.instID + "')";
            ss.execute(query);
            query = "alter table grades add " + this.courseID + " int";
            ss.execute(query);
            query = "alter table regesteredCourses add " + this.courseID + " int";
            ss.execute(query);
            this.d = 1;
                JOptionPane.showMessageDialog(null, "Added successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
        }

    }
    // method to update all course's info

    public void updateAll(String courseID,String courseName, String parentCourse, int price,
            int room, String branch, int startDay,
            int startMonth, int startYear, int endDay, int endMonth, int endYear, int daysOfCourse) throws ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
             this.courseID = courseID;
            this.parentCourse = parentCourse;
            this.price = price;
            this.room = room;
            this.branch = branch;
            this.startDay = startDay;
            this.startMonth = startMonth;
            this.startYear = startYear;
            this.endDay = endDay;
            this.endMonth = endMonth;
            this.endYear = endYear;
            this.daysOfCourse = daysOfCourse;
            this.startDate = getStartDate(startDay, startMonth, startYear);
            this.endDate = getEndDate(endDay, endMonth, endYear);
            query = "update courses set parentCourse='"+this.parentCourse+"',price='"+this.price +"',startDate='" + this.startDate + "',endDate='" + this.endDate + "',daysOfCourse='" + this.daysOfCourse + "',room='" + this.room + "',branch='" + this.branch + "'where courseID='" + this.courseID + "'";
            ss.execute(query);
                JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    // method to update  parent course

    public void updateParentCourse(String courseID, String parentCourse) throws ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
             this.courseID = courseID;
            this.parentCourse = parentCourse;
            
            query = "update courses set parentCourse='" + this.parentCourse + "' where courseID='" + this.courseID + "'";
            ss.execute(query);
                JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
        
    // method to update price of course

    public void updatePriceOfCourse(String courseID, int price) throws ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
             this.courseID = courseID;
            this.price = price;
       
            query = "update courses set price='" + this.price + "' where courseID='" + this.courseID + "'";
            ss.execute(query);
                JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    // method to update room 

    public void updateRoom(String courseID, int room) throws ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
             this.courseID = courseID;
            this.room = room;
           
            query = "update courses set room='" + this.room + "' where courseID='" + this.courseID + "'";
            ss.execute(query);
                JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    // method to update branch

    public void updateBranch(String courseID, String branch) throws ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
             this.courseID = courseID;
            this.branch = branch;
            
            query = "update courses set branch='" + this.branch + "' where courseID='" + this.courseID + "'";
            ss.execute(query);
                JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    // method to update no of days of the course

    public void updateDaysOfCourse(String courseID, int daysOfCourse) throws ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
             this.courseID = courseID;
            this.daysOfCourse = daysOfCourse;
            query = "update courses set daysOfcourse='" + this.daysOfCourse + "' where courseID='" + this.courseID + "'";
            ss.execute(query);
                JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    // method to update start date of course

    public void updateStartDate(String courseID, String startDate) throws ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
             this.courseID = courseID;
            query = "update courses set startDate='" + startDate + "' where courseID='" + this.courseID + "'";
            ss.execute(query);
                JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
// method to update end date of course

    public void updateEndDate(String courseID, String endDate) throws ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
            this.courseID = courseID;
            query = "update courses set endDate='" + endDate + "' where courseID='" + this.courseID + "'";
            ss.execute(query);
                JOptionPane.showMessageDialog(null, "Updated successfully");
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } 
        
        finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
// method to delete course

    public void deleteCourse(String courseID) throws ClassNotFoundException {
        try {
            c = c1.connect();
            ss = c.createStatement();
            this.courseID = courseID;
            query = "delete from courses where courseID='" + this.courseID + "'";
            ss.execute(query);
            query = "alter table regesteredCourses drop column " + this.courseID + " ";
            ss.execute(query);
            query = "alter table grades drop column " + this.courseID + " ";
            ss.execute(query);
            checkParent(courseID);
        } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se);
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

}
