/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.PhoneUserFull;
import Services.Interfaces.IGetPhoneUsersFull;
import Services.SqliteHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author jafar.j
 */
public class GetPhoneUsersFullSqliteDbService implements IGetPhoneUsersFull{
    
    private Connection connection;
    private PreparedStatement preparedStatement;

    public GetPhoneUsersFullSqliteDbService() throws java.sql.SQLException, ClassNotFoundException , NamingException{
        connection = SqliteHelper.getPhoneUsersFullConn();
    }
    
    public Iterable<PhoneUserFull> getAllPhoneUsersFull(){
        LinkedList<PhoneUserFull> linkedList = new LinkedList<PhoneUserFull>();
        try {
            this.preparedStatement = this.connection.prepareStatement("select * from PhoneUsersFull");
            ResultSet resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()) {
                PhoneUserFull phoneUserFull = new PhoneUserFull();
                phoneUserFull.setPhoneUserNumber(resultSet.getString(2));
                phoneUserFull.setPhoneUserName(resultSet.getString(3));
                phoneUserFull.setPhoneUserNameAZE(resultSet.getString(4));
                phoneUserFull.setPhoneUserDepartment(resultSet.getString(5));
                phoneUserFull.setPhoneUserSpecialty(resultSet.getString(6));
                phoneUserFull.setPhoneUserStructure(resultSet.getString(7));
                phoneUserFull.setPhoneUserEmail(resultSet.getString(8));
                System.out.println(phoneUserFull.getPhoneUserNumber() + " " +
                                   phoneUserFull.getPhoneUserName()+ " " +
                                   phoneUserFull.getPhoneUserNameAZE()+ " " +
                                   phoneUserFull.getPhoneUserDepartment() + " " +
                                   phoneUserFull.getPhoneUserSpecialty() + " " +
                                   phoneUserFull.getPhoneUserStructure() + " " + 
                                   phoneUserFull.getPhoneUserEmail()
                                   );
                linkedList.add(phoneUserFull);
            }
            this.connection.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(GetPhoneUsersFullSqliteDbService.class.getName()).log(Level.SEVERE, null, ex);
            linkedList = null;
        }
        return linkedList;
    }
}
