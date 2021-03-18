package MainDriver;

import java.sql.Connection;
import java.sql.*;

public class GlobalVars {
    public DBconnect c1 = new DBconnect();
    public static Connection c;
    public static Statement ss;
    public ResultSet rs;
    public static String query;
}
