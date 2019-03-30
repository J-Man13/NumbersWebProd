/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
/**
 *
 * @author jafar.j
 */
public class SessionValidationService {
    public static boolean IsLogged(HttpSession ses) throws NamingException {
        InitialContext ctx = new InitialContext();
        Context env = (Context)ctx.lookup("java:comp/env");
        String adminPass = (String)env.lookup("AdminSecret");
        if (ses == null) {
            return false;
        }
        if (ses.getAttribute("adminPass") == null) {
            return false;
        }
        if (!((String)ses.getAttribute("adminPass")).equals(adminPass)) {
            return false;
        }
        return true;
    }
}
