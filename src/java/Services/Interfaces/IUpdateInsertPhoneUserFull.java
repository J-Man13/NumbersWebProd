/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Models.PhoneUserFull;

/**
 *
 * @author jafar.j
 */
public interface IUpdateInsertPhoneUserFull {
    public String updateInsertPhoneUserFull(String contactNumberToAdd, String contactNameToAdd,String contactNameAzeToAdd,String contactDepartmentToAdd,String contactSpecialtyToAdd,String contactStructureToAdd, String contactRooomToAdd, String contactMobileNumberToAdd);
}
