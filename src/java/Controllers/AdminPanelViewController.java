/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.PhoneUserFull;
import Services.Interfaces.IGetPhoneUsersFullSynchronized;
import Services.SessionValidationService;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
/**
 *
 * @author jafar.j
 */
public class AdminPanelViewController {
    IGetPhoneUsersFullSynchronized iGetPhoneUsersFullSynchronized;

    public AdminPanelViewController(IGetPhoneUsersFullSynchronized iGetPhoneUsersFullSynchronized) {
        this.iGetPhoneUsersFullSynchronized = iGetPhoneUsersFullSynchronized;
    }

    public Iterable<PhoneUserFull> getPhoneUsersFull() {
        return this.iGetPhoneUsersFullSynchronized.GetPhoneUsersFullSynchronized();
    }

    public static boolean IsLogged(HttpSession ses) throws NamingException {
        return SessionValidationService.IsLogged((HttpSession)ses);
    }
}
