/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Models.PhoneUser;
import Models.PhoneUserFull;
import Services.Interfaces.IGetAsteriskUsers;
import Services.Interfaces.IGetPhoneUsersFull;
import Services.Interfaces.IGetPhoneUsersFullSynchronized;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author jafar.j
 */
public class GetPhoneUsersFullSynchronized implements IGetPhoneUsersFullSynchronized{
    IGetPhoneUsersFull iGetPhoneUsersFull;
    IGetAsteriskUsers iGetAsteriskUsers;

    public GetPhoneUsersFullSynchronized(IGetPhoneUsersFull iGetPhoneUsersFull,IGetAsteriskUsers iGetAsteriskUsers){
        this.iGetPhoneUsersFull = iGetPhoneUsersFull;
        this.iGetAsteriskUsers = iGetAsteriskUsers;
    }
    
    private HashMap<String, PhoneUserFull> getPhoneUsersFullMap(){
        HashMap<String, PhoneUserFull> hashMap = new HashMap<String, PhoneUserFull>();
        Iterable<PhoneUserFull> phoneUsersFull = iGetPhoneUsersFull.getAllPhoneUsersFull();
        for(PhoneUserFull phoneUserFull : phoneUsersFull)
            hashMap.put(phoneUserFull.getPhoneUserNumber()+ phoneUserFull.getPhoneUserName(), phoneUserFull);
        return hashMap;
    }   
    
    @Override
    public Iterable<PhoneUserFull> GetPhoneUsersFullSynchronized() {
        LinkedList<PhoneUserFull> linkedListPhoneUsersFull = new LinkedList<PhoneUserFull>();
        Iterable<PhoneUser> iterablesListPhoneUsersAsterisk = iGetAsteriskUsers.getAllElements();
        HashMap<String, PhoneUserFull> hashMapPhoneUsersFull = getPhoneUsersFullMap();
        for(PhoneUser phoneUser : iterablesListPhoneUsersAsterisk){
            PhoneUserFull phoneUserFull = hashMapPhoneUsersFull.get(phoneUser.getPhoneUserNumber()+phoneUser.getPhoneUserName());
            if(phoneUserFull == null){
                phoneUserFull = new PhoneUserFull();
                phoneUserFull.setPhoneUserNumber(phoneUser.getPhoneUserNumber());
                phoneUserFull.setPhoneUserName(phoneUser.getPhoneUserName());
            }
            linkedListPhoneUsersFull.add(phoneUserFull);
        }
        return linkedListPhoneUsersFull;
    }    
}
