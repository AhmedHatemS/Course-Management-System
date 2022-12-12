package AdminModule;

import MainDriver.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class GetAccess extends GlobalVars {

    private String userName;
    private String password;
    private int ID;
    private String SSN;
    private String role;

    public boolean login() {
        return false;
    }

    public boolean login(String userName, String password) throws SQLException, ClassNotFoundException {
        this.userName = userName;
        this.password = password;
        //connection
        c = c1.connect();
        //code
        ss = c.createStatement();
        try {
            query = "SELECT COUNT (mainInfo.UserId) AS rowsCount FROM mainInfo where mainInfo.UserName LIKE '" + this.userName + "' and mainInfo.Password LIKE '" + this.password + "'";
            rs = ss.executeQuery(query);
            rs.next();
            if (rs.getInt("rowsCount") == 1) {//succeeded
                UserID();
                SSN();
                role();
                JOptionPane.showMessageDialog(null, "Your login succeeded as "+returnRole());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Your login failed.");
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
        return false;
    }

    private void UserID() throws ClassNotFoundException, SQLException {

        c = c1.connect();
        ss = c.createStatement();
        try {
            query = "SELECT mainInfo.UserId AS id FROM mainInfo WHERE mainInfo.UserName LIKE '" + this.userName + "' and mainInfo.Password LIKE '" + this.password + "'";
            rs = ss.executeQuery(query);
            rs.next();
            this.ID = rs.getInt("id");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void SSN() throws ClassNotFoundException, SQLException {
        //connection
        c = c1.connect();
        //code
        ss = c.createStatement();
        try {
            query = "SELECT mainInfo.SSN AS SSN FROM mainInfo where mainInfo.UserName LIKE '" + this.userName + "' and mainInfo.Password LIKE '" + this.password + "'";
            rs = ss.executeQuery(query);
            rs.next();
            this.SSN = rs.getString("SSN");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void role() throws ClassNotFoundException, SQLException {
        //connection
        c = c1.connect();
        //code
        ss = c.createStatement();
        try {
            query = "SELECT mainInfo.role AS role FROM mainInfo where mainInfo.UserName LIKE '" + this.userName + "' and mainInfo.Password LIKE '" + this.password + "'";
            rs = ss.executeQuery(query);
            rs.next();
            this.role = rs.getString("role");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int returnUserID() {
        return this.ID;
    }

    public String returnSSN() throws SQLException, ClassNotFoundException {
        return this.SSN;
    }

    public String returnRole() throws SQLException, ClassNotFoundException {
        return this.role;
    }

}
