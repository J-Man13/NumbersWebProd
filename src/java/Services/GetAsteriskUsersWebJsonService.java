/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.PhoneUser;
import Services.GetAsteriskUsersWebJsonService;
import Services.Interfaces.IGetAsteriskUsers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author jafar.j
 */
public class GetAsteriskUsersWebJsonService implements IGetAsteriskUsers {
    private ObjectMapper objectMapper;
    private final String PHONEUSERLISTJSONSTRING;
    private final String URL;
    
    
    public GetAsteriskUsersWebJsonService() throws NamingException, IOException{
        objectMapper = new ObjectMapper();
        Context ctx = new InitialContext();
        Context env = (Context) ctx.lookup("java:comp/env");       
        URL = (String) env.lookup("PhoneUsersJsonStringURL");
        PHONEUSERLISTJSONSTRING = readStringFromURL(URL);
    }
    
    @Override  
    public Iterable<PhoneUser> getAllElements() {
        try{
            return  objectMapper.readValue(PHONEUSERLISTJSONSTRING,new TypeReference<Iterable<PhoneUser>>(){});
        } catch (IOException ex) {
            Logger.getLogger(GetAsteriskUsersWebJsonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Iterable<PhoneUser> getElementByName(String name){
        try {
            Iterable<PhoneUser> iterables = objectMapper.readValue(PHONEUSERLISTJSONSTRING,new TypeReference<Iterable<PhoneUser>>(){});
            LinkedList<PhoneUser> returnLinkedList = new LinkedList<PhoneUser>();
            for(PhoneUser phoneUser : iterables)
                if(phoneUser.getPhoneUserName().contains(name))
                    returnLinkedList.add(phoneUser);
            return returnLinkedList;
        } catch (IOException ex) {
            Logger.getLogger(GetAsteriskUsersWebJsonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Iterable<PhoneUser> getElementByPhone(String number){
        try {
            Iterable<PhoneUser> iterables = objectMapper.readValue(PHONEUSERLISTJSONSTRING,new TypeReference<Iterable<PhoneUser>>(){});
            LinkedList<PhoneUser> returnLinkedList = new LinkedList<PhoneUser>();
            for(PhoneUser phoneUser : iterables)
                if(phoneUser.getPhoneUserNumber().contains(number))
                    returnLinkedList.add(phoneUser);
            return returnLinkedList;
        } catch (IOException ex) {
            Logger.getLogger(GetAsteriskUsersWebJsonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static String readStringFromURL(String requestURL) throws IOException
    {
        try (Scanner scanner = new Scanner(new URL(requestURL).openStream(),
        StandardCharsets.UTF_8.toString()))
        {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}
