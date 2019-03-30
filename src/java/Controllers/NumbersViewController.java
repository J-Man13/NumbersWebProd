/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Models.PhoneUserFull;
import Services.Interfaces.IGetPhoneUsersFullSynchronized;

/**
 *
 * @author jafar.j
 */

public class NumbersViewController {
    IGetPhoneUsersFullSynchronized iGetPhoneUsersFullSynchronized;

    public NumbersViewController(IGetPhoneUsersFullSynchronized iGetPhoneUsersFullSynchronized) {
        this.iGetPhoneUsersFullSynchronized = iGetPhoneUsersFullSynchronized;
    }

    public Iterable<PhoneUserFull> getAllPhoneUsers() {
        return this.iGetPhoneUsersFullSynchronized.GetPhoneUsersFullSynchronized();
    }
}
