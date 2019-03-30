/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author jafar.j
 */
public class SqliteHelper {
    private static Connection c = null;

    public static Connection getPhoneUsersFullConn() throws ClassNotFoundException, NamingException, SQLException {
        if (c == null || c.isClosed()) {
            Class.forName("org.sqlite.JDBC");
            InitialContext ctx = new InitialContext();
            Context env = (Context)ctx.lookup("java:comp/env");
            String URL2 = (String)env.lookup("PhoneUsersFullSqliteDBFilePath");
            c = DriverManager.getConnection(URL2);
        }
        return c;
    }
}
