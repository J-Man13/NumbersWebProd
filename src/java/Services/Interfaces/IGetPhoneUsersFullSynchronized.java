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
public interface IGetPhoneUsersFullSynchronized {
    public Iterable<PhoneUserFull> GetPhoneUsersFullSynchronized();
}
