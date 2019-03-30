/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

/**
 *
 * @author jafar.j
 */
import Models.PhoneUserFull;

public interface IGetPhoneUsersFull {
    public Iterable<PhoneUserFull> getAllPhoneUsersFull();    
}
