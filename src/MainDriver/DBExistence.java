package MainDriver;

import AdminModule.ManageData;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBExistence extends GlobalVars {

    public DBExistence() throws SQLException, ClassNotFoundException {
        check();
    }

    private boolean DBExists() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=admin;password=admin;");
            ss = c.createStatement();
            rs = c.getMetaData().getCatalogs();
            while (rs.next()) {
                if ("CourseManagementSystem".equals(rs.getString("TABLE_CAT"))){
                    return true;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
        return false;
    }

    private void createDB() throws SQLException, ClassNotFoundException {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=admin;password=admin;");
            ss = c.createStatement();
            if (c != null) {
                String[] queries = new String[10];//queries to create DB
                queries[0] = "create database CourseManagementSystem";
                queries[1] = "use CourseManagementSystem";
                queries[2] = "create table mainInfo\n"
                        + "(\n"
                        + "UserId int  IDENTITY(1,1),\n"
                        + "SSN varchar(14) NOT NULL UNIQUE,\n"
                        + "UserName varchar(100) NOT NULL UNIQUE,\n"
                        + "Password varchar(100) NOT NULL,\n"
                        + "role varchar(100) NOT NULL,\n"
                        + "constraint PK_ID PRIMARY KEY(UserId)\n"
                        + ");";
                queries[3] = "create table instructor\n"
                        + "(\n"
                        + "instID int UNIQUE,\n"
                        + "instFName varchar(100) NOT NULL,\n"
                        + "instLName varchar(100) NOT NULL,\n"
                        + "SSN varchar(14) NOT NULL UNIQUE,\n"
                        + "DOB Date NOT NULL,\n"
                        + "Phone varchar(15) UNIQUE NOT NULL,\n"
                        + "Email nvarchar(100) UNIQUE NOT NULL,\n"
                        + "Address nvarchar(100) NOT NULL,\n"
                        + "Nationality varchar(100) NOT NULL,\n"
                        + "CourseID varchar(100) NOT NULL,\n"
                        + "\n"
                        + ");";
                queries[4] = "create table student\n"
                        + "(\n"
                        + "studID int PRIMARY KEY,\n"
                        + "studFirstName varchar(100) NOT NULL,\n"
                        + "studLastName varchar(100) NOT NULL,\n"
                        + "SSN varchar(14) NOT NULL UNIQUE,\n"
                        + "DOB Date NOT NULL,\n"
                        + "Phone varchar(15) UNIQUE NOT NULL,\n"
                        + "Email nvarchar(100) UNIQUE  NOT NULL,\n"
                        + "Address nvarchar(100) NOT NULL,\n"
                        + "Nationality varchar(100) NOT NULL\n"
                        + ");";
                queries[5] = "create table courses\n"
                        + "(\n"
                        + "courseID varchar(100) NOT NULL,\n"
                        + "courseName varchar(100) NOT NULL UNIQUE,\n"
                        + "parentCourse varchar(100),\n"
                        + "startDate Date NOT NULL,\n"
                        + "endDate Date NOT NULL,\n"
                        + "daysOfCourse int NOT NULL,\n"
                        + "price int NOT NULL,\n"
                        + "room int NOT NULL,\n"
                        + "branch varchar(100) NOT NULL,\n"
                        + "instID int NOT NULL,\n"
                        + "constraint PK_idd PRIMARY KEY(courseID)\n"
                        + ");";
                queries[6] = "create table regesteredCourses\n"
                        + "(\n"
                        + "studID int FOREIGN KEY REFERENCES student(studID),\n"
                        + ");";
                queries[7] = "create table grades\n"
                        + "(\n"
                        + "studID int FOREIGN KEY REFERENCES student(studID),\n"
                        + ");";
                queries[8] = "create table surveyMainTable\n"
                        + "(\n"
                        + "surveyID int IDENTITY(1,1) PRIMARY KEY,\n"
                        + "studID int FOREIGN KEY REFERENCES student(studID),\n"
                        + "courseID varchar(100) FOREIGN KEY REFERENCES courses(courseID),\n"
                        + ");";
                queries[9] = "create table surveyResponses\n"
                        + "(\n"
                        + "surveyID int FOREIGN KEY REFERENCES surveyMainTable(surveyID),\n"
                        + "resp1 varchar(200) NOT NULL,\n"
                        + "resp2 varchar(200) NOT NULL,\n"
                        + "resp3 varchar(200) NOT NULL,\n"
                        + "resp4 varchar(200) NOT NULL,\n"
                        + "resp5 varchar(200) NOT NULL,\n"
                        + ");";
                for (int i = 0; i < 2; i++) {
                    query = queries[i];
                    ss.execute(query);
                }
                c = c1.connect();
                ss = c.createStatement();
                for (int i = 2; i < queries.length; i++) {
                    query = queries[i];
                    ss.execute(query);
                }
                String createDefaultAdmin = "";
                ManageData md = new ManageData();
                md.addUser("00000000000000", "admin", "default");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }

    private void check() throws SQLException, ClassNotFoundException {
        if (!DBExists()) {
            JOptionPane.showMessageDialog(null, "Creating database now ...");
            createDB();
        }
    }
}
