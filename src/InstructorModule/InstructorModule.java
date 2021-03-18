package InstructorModule;

import AdminModule.*;
import MainDriver.*;
import static MainDriver.GlobalVars.c;
import static MainDriver.GlobalVars.query;
import static MainDriver.GlobalVars.ss;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.*;
import java.sql.*;
import static java.util.Collections.list;
import javax.swing.JOptionPane;

public class InstructorModule extends GlobalVars{
    
    private int studentID;
    private int grade;
    private String courseID="cs111";
    private String instSSN;
    private String FName;
    private String LName;
    public String s1="";
    public String s2="";
  
    GetAccess ga = new GetAccess();

    //constructor I need it
    public  InstructorModule(int x, int n) {
        this.grade = x;
        this.studentID = n;
       
    }

    //Main constructor
    InstructorModule() {
    }

   // Return instructor Course Id
    private String returnInstCourseID() throws ClassNotFoundException, SQLException {
        c = c1.connect();
        ss = c.createStatement();
        try {
            query = "SELECT CourseID AS cid FROM instructor WHERE instructor.SSN LIKE '" + instSSN + "'";
            rs = ss.executeQuery(query);
            rs.next();
            return rs.getString("cid");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "..";
    }
//Functions add grades
    public void addGrade(int studID, int grade,String courseID) throws ClassNotFoundException, SQLException {
        this.studentID = studID;
        this.grade = grade;
        c = c1.connect();
        ss = c.createStatement();
        try {
            
//            courseID = returnInstCourseID();
//            System.out.println(courseID);
            query = "UPDATE grades SET  " + courseID + " = '" + grade + "' WHERE grades.studID LIKE '" + studID + "'";
            ss.execute(query);
             JOptionPane.showMessageDialog(null, "Updated");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                c.close();
                ss.close();
                rs.close();
            } catch (SQLException s) {
                
            }
        }
    }
    //Function Show Grades To instructor
    public void ShowAllGrade(String CourseID) throws ClassNotFoundException {
        try {
            ArrayList< InstructorModule> list = new ArrayList< InstructorModule>();

            c = c1.connect();
            ss = c.createStatement();
            query = "select studID, " + CourseID + " from grades";
            rs = ss.executeQuery(query);

            
            while (rs.next()) {
                 InstructorModule b = new  InstructorModule( rs.getInt("studID"),rs.getInt("" + CourseID + ""));
                list.add(b);
            }
            for (int i = 0; i <list.size() ; i++) {
               
                s1+=list.get(i).grade;s1+="\n";
             
               s2+=list.get(i).studentID;s2+="\n";
   }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException s) {
            }

        }

    }
}
