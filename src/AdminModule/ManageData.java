package AdminModule;

import MainDriver.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import javax.swing.*;

public class ManageData extends GlobalVars {

    private int ID;
    private String SSN;
    private String userName;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private Date DoB;
    private String phone;
    private String email;
    private String address;
    private String nationality;
    private String courseID;

    private int d = 0; //for isDone() if d=0 failed if d=1 succeded

    private int assignUserID() throws ClassNotFoundException, SQLException {//to get user ID, used to insert in other tables

        c = c1.connect();
        ss = c.createStatement();
        try {
            query = "SELECT mainInfo.UserId AS id FROM mainInfo WHERE mainInfo.SSN LIKE '" + this.SSN + "'";
            rs = ss.executeQuery(query);
            rs.next();
            this.ID = rs.getInt("id");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return this.ID;
    }

    private boolean foundSSN() throws ClassNotFoundException, SQLException {
        c = c1.connect();
        ss = c.createStatement();
        try {
            query = "SELECT COUNT(SSN) AS countValSSN FROM mainInfo where mainInfo.SSN LIKE '" + this.SSN + "'";
            rs = ss.executeQuery(query);
            rs.next();
            if (rs.getInt("countValSSN") == 1) {
                return true;
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    private boolean foundUserName() throws ClassNotFoundException, SQLException {
        c = c1.connect();
        ss = c.createStatement();
        try {
            query = "SELECT COUNT(UserName) AS countValUN FROM mainInfo where mainInfo.UserName LIKE '" + this.userName + "'";
            rs = ss.executeQuery(query);
            rs.next();
            if (rs.getInt("countValUN") == 1) {
                return true;
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    private boolean foundPhone() throws ClassNotFoundException, SQLException {
        c = c1.connect();
        ss = c.createStatement();
        try {
            if ("student".equals(checkRole())) {
                query = "SELECT COUNT(Phone) AS countValPhone FROM student where student.Phone LIKE '" + this.phone + "'";
            } else if ("instructor".equals(checkRole())) {
                query = "SELECT COUNT(Phone) AS countValPhone FROM instructor where instructor.Phone LIKE '" + this.phone + "'";
            }
            rs = ss.executeQuery(query);
            rs.next();
            if (rs.getInt("countValPhone") == 1) {
                return true;
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    private boolean foundEmail() throws ClassNotFoundException, SQLException {
        c = c1.connect();
        ss = c.createStatement();
        try {
            if ("student".equals(checkRole())) {
                query = "SELECT COUNT(Email) AS countValEmail FROM student where student.Email LIKE '" + this.email + "'";
            } else if ("instructor".equals(checkRole())) {
                query = "SELECT COUNT(Email) AS countValEmail FROM instructor where instructor.Email LIKE '" + this.email + "'";
            }
            rs = ss.executeQuery(query);
            rs.next();
            if (rs.getInt("countValEmail") == 1) {
                return true;
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    private boolean foundCourseID() throws ClassNotFoundException, SQLException {
        c = c1.connect();
        ss = c.createStatement();
        try {
            if ("student".equals(checkRole())) {
                query = "SELECT COUNT(CourseID) AS countValCID FROM instructor where instructor.Courseid LIKE '" + this.courseID + "'";
            }
            rs = ss.executeQuery(query);
            rs.next();
            if (rs.getInt("countValCID") == 1) {
                return true;
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    private String checkRole() throws ClassNotFoundException, SQLException {
        c = c1.connect();
        ss = c.createStatement();
        try {
            query = "SELECT mainInfo.role AS countValRole FROM mainInfo where mainInfo.SSN LIKE '" + this.SSN + "'";
            rs = ss.executeQuery(query);
            rs.next();
            return rs.getString("countValRole");
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    public boolean isDone() { // can be accessed from other classes (made for gui)
        return d == 1 ? true : false;
    }

    public void addUser(String SSN, String userName, String password) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.userName = userName;
        this.password = password;
        this.role = "admin";

        if ((this.SSN).length() != 14 || foundSSN() || foundUserName()) {
            JOptionPane.showMessageDialog(null, "Check the SSN and userName, then try again.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "INSERT INTO mainInfo(SSN, UserName, Password, role) VALUES ('" + this.SSN + "' , '" + this.userName + "' , '" + this.password + "' , '" + this.role + "')";
                ss.execute(query);
                assignUserID();
                d = 1;
                JOptionPane.showMessageDialog(null, "Added successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void addStudent(String userName, String password, String firstName, String lastName, String SSN, String DoB, String phone, String email, String address, String nationality) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.userName = userName;
        this.password = password;
        this.role = "student";
        this.firstName = firstName;
        this.lastName = lastName;
        this.DoB = Date.valueOf(DoB);
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.nationality = nationality;

        if ((this.SSN).length() != 14 || foundSSN() || foundUserName()) {
            JOptionPane.showMessageDialog(null, "Check the SSN and userName, then try again.");
        } else if (foundPhone() || foundEmail()) {
            JOptionPane.showMessageDialog(null, "Phone number or Email is previously added, Enter another one or login.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "INSERT INTO mainInfo(SSN, UserName, Password, role) VALUES ('"
                        + this.SSN + "' , '" + this.userName + "' , '" + this.password + "' , '" + this.role + "') ";
                ss.execute(query);
                query = " INSERT INTO student(studID, studFirstName, studLastName, SSN, DOB, Phone, Email, Address, Nationality) "
                        + "VALUES ('" + assignUserID() + "' , '" + this.firstName + "' , '" + this.lastName + "' , '"
                        + this.SSN + "' , '" + this.DoB + "' , '" + this.phone + "' , '" + this.email
                        + "' , '" + this.address + "' , '" + this.nationality + "')";
                ss.execute(query);
                query = " INSERT INTO regesteredCourses(studID) VALUES ('" + assignUserID() + "')";
                ss.execute(query);
                query = " INSERT INTO grades(studID) VALUES ('" + assignUserID() + "')";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Added successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void addInstructor(String userName, String password, String firstName, String lastName, String SSN, String DoB, String phone, String email, String address, String nationality, String courseID) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.userName = userName;
        this.password = password;
        this.role = "instructor";
        this.firstName = firstName;
        this.lastName = lastName;
        this.DoB = Date.valueOf(DoB);
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.courseID = courseID;

        if ((this.SSN).length() != 14 || foundSSN() || foundUserName()) {
            JOptionPane.showMessageDialog(null, "Check the SSN and userName, then try again.");
        } else if (foundPhone() || foundEmail()) {
            JOptionPane.showMessageDialog(null, "Phone number or Email is previously added, Enter another one.");
        } else if (foundCourseID()) {
            JOptionPane.showMessageDialog(null, "Another instructor lecturing the same course, please enter another one.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "INSERT INTO mainInfo(SSN, UserName, Password, role) VALUES ('"
                        + this.SSN + "' , '" + this.userName + "' , '" + this.password + "' , '" + this.role + "') ";

                ss.execute(query);
                query = "INSERT INTO instructor(instID, instFName, instlName, SSN, DOB, Phone, Email, Address, Nationality, CourseID) "
                        + "VALUES ('" + assignUserID() + "' , '" + this.firstName + "' , '" + this.lastName
                        + "' , '" + this.SSN + "' , '" + this.DoB + "' , '" + this.phone + "' , '" + this.email
                        + "' , '" + this.address + "' , '" + this.nationality + "' , '" + this.courseID + "')";
                ss.execute(query);
                query = "UPDATE courses SET instID = '" + assignUserID() + "' WHERE courseID = '" + this.courseID + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Added successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updatePassword(String SSN, String password) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.password = password;
        if (!foundSSN()) {
            JOptionPane.showMessageDialog(null, "SSN not found, can't update password for non-valid SSN.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE mainInfo SET mainInfo.Password = '" + this.password + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updateStudentPhone(String SSN, String phone) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.phone = phone;
        if (!foundSSN() || !"student".equals(checkRole())) {
            JOptionPane.showMessageDialog(null, "SSN in wrong or isn't student.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE student SET student.Phone = '" + this.phone + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updateStudentEmail(String SSN, String email) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.email = email;
        if (!foundSSN() || !"student".equals(checkRole())) {
            JOptionPane.showMessageDialog(null, "SSN in wrong or isn't student.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE student SET student.Email = '" + this.email + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updateStudentAddress(String SSN, String address) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.address = address;
        if (!foundSSN() || !"student".equals(checkRole())) {
            JOptionPane.showMessageDialog(null, "SSN in wrong or isn't student.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE student SET student.Address = '" + this.address + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updateStudent(String SSN, String phone, String email, String address) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.phone = phone;
        this.email = email;
        this.address = address;
        if (!foundSSN() || !"student".equals(checkRole())) {
            JOptionPane.showMessageDialog(null, "SSN in wrong or isn't student.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE student SET student.Phone = '" + this.phone + "' , student.Email = '" + this.email + "' ,  student.Address = '" + this.address + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updateInstructorPhone(String SSN, String phone) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.phone = phone;
        if (!foundSSN() || !"instructor".equals(checkRole())) {
            JOptionPane.showMessageDialog(null, "SSN in wrong or isn't instructor.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE instructor SET instructor.Phone = '" + this.phone + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updateInstructorEmail(String SSN, String email) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.email = email;
        if (!foundSSN() || !"instructor".equals(checkRole())) {
            JOptionPane.showMessageDialog(null, "SSN in wrong or isn't instructor.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE instructor SET instructor.Email = '" + this.email + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updateInstructorAddress(String SSN, String address) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.address = address;
        if (!foundSSN() || !"instructor".equals(checkRole())) {
            JOptionPane.showMessageDialog(null, "SSN in wrong or isn't instructor.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE instructor SET instructor.Address = '" + this.address + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updateInstructorCourseID(String SSN, String courseID) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.courseID = courseID;
        if (!foundSSN() || !"instructor".equals(checkRole())) {
            JOptionPane.showMessageDialog(null, "SSN in wrong or isn't instructor.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE instructor SET instructor.CourseID = '" + this.courseID + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void updateInstructor(String SSN, String phone, String email, String address, String courseID) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.courseID = courseID;
        if (!foundSSN() || !"instructor".equals(checkRole())) {
            JOptionPane.showMessageDialog(null, "SSN in wrong or isn't instructor.");
        } else {
            c = c1.connect();
            ss = c.createStatement();
            try {
                query = "UPDATE instructor SET instructor.Phone = '" + this.phone + "' , instructor.Email = '" + this.email + "' ,  instructor.Address = '" + this.address + "' , instructor.CourseID = '" + this.courseID + "' WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    c.close();
                    ss.close();
                    rs.close();
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(null, s);
                }
            }
        }
    }

    public void deleteUser(String SSN) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        c = c1.connect();
        ss = c.createStatement();
        try {
            if (foundSSN() && !"student".equals(checkRole()) && !"instructor".equals(checkRole())) {
                query = "DELETE mainInfo WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Record with this SSN not found or can't be deleted.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                c.close();
                ss.close();
                rs.close();
            } catch (SQLException s) {
                JOptionPane.showMessageDialog(null, s);
            }
        }
    }

    public void deleteStudent(String SSN) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        c = c1.connect();
        ss = c.createStatement();
        try {
            if (foundSSN() && "student".equals(checkRole())) {
                query = "DELETE mainInfo WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                query = "delete student where SSN = '" + this.SSN + "'";
                ss.execute(query);
                query = "delete regesteredCourses where studID = '" + assignUserID() + "'";
                ss.execute(query);
                query = "delete grades where studID = '" + assignUserID() + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Record with this SSN not found or can't be deleted.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                c.close();
                ss.close();
                rs.close();
            } catch (SQLException s) {
                JOptionPane.showMessageDialog(null, s);
            }
        }
    }

    public void deleteInstructor(String SSN) throws ClassNotFoundException, SQLException {
        this.SSN = SSN;
        c = c1.connect();
        ss = c.createStatement();
        try {
            if (foundSSN() && "instructor".equals(checkRole())) {
                query = "DELETE mainInfo WHERE SSN = '" + this.SSN + "'";
                ss.execute(query);
                query = "delete instructor where SSN = '" + this.SSN + "'";
                ss.execute(query);
                d = 1;
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Record with this SSN not found or can't be deleted.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                c.close();
                ss.close();
                rs.close();
            } catch (SQLException s) {
                JOptionPane.showMessageDialog(null, s);
            }
        }
    }
}
