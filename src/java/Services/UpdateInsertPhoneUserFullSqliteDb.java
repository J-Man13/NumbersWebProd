/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Services.Interfaces.IUpdateInsertPhoneUserFull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
/**
 *
 * @author jafar.j
 */
public class UpdateInsertPhoneUserFullSqliteDb implements IUpdateInsertPhoneUserFull{
    private Connection connection;
    private PreparedStatement preparedStatement;
        
    public UpdateInsertPhoneUserFullSqliteDb() throws NamingException, ClassNotFoundException, SQLException{        
        connection = SqliteHelper.getPhoneUsersFullConn();
    }
    
    @Override
    public String updateInsertPhoneUserFull(String contactNumberToAdd, String contactNameToAdd, String contactNameAzeToAdd, String contactDepartmentToAdd, String contactSpecialtyToAdd, String contactStructureToAdd, String contactRooomToAdd, String contactEmailToAdd){
        try {
            if(connection.isClosed())
                connection = SqliteHelper.getPhoneUsersFullConn();
        }catch (Exception ex) {
            return ex.getMessage();
        }        
        try {
            preparedStatement = connection.prepareStatement("select * from PhoneUsersFull where phoneUserNumber = '" + contactNumberToAdd + "' and phoneUserName = '" + contactNameToAdd+"'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                preparedStatement = connection.prepareStatement("update PhoneUsersFull set phoneUserNumber = '" + contactNumberToAdd + "' , " +
                                                                                      "phoneUserName = '" + contactNameToAdd + "' , " +
                                                                                      "phoneUserNameAZE = '" + contactNameAzeToAdd + "' , " +
                                                                                      "phoneUserDepartment = '" + contactDepartmentToAdd + "' , " +
                                                                                      "phoneUserSpecialty = '" + contactSpecialtyToAdd + "' , " +
                                                                                      "phoneUserStructure = '" + contactStructureToAdd + "' , " +
                                                                                      "phoneUserEmail = '" + contactEmailToAdd + "' " +
                                                                                      "  WHERE " + 
                                                                                      " phoneUserNumber = '" + contactNumberToAdd + "' and phoneUserName = '" + contactNameToAdd+"'");
                preparedStatement.executeUpdate();
            }
            else{
                preparedStatement = connection.prepareStatement("insert into PhoneUsersFull(phoneUserNumber , phoneUserName , phoneUserNameAZE , phoneUserDepartment , phoneUserSpecialty , phoneUserStructure, phoneUserEmail)"+
                                                                "values('"   + contactNumberToAdd+"' , '" + contactNameToAdd+"' , '" + contactNameAzeToAdd+"' , '" + contactDepartmentToAdd+"' , '" + contactSpecialtyToAdd+"' , '" + contactStructureToAdd + "' , '"+contactEmailToAdd+"')");
                preparedStatement.executeUpdate();                
            }
            connection.close();
            return "Updated or inserted properly";
        }catch (SQLException ex){
            Logger.getLogger(UpdateInsertPhoneUserFullSqliteDb.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }   

}
