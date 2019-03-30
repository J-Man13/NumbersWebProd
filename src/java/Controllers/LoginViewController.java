/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Services.SessionValidationService;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jafar.j
 */
public class LoginViewController {
    public static boolean IsLogged(HttpSession ses) throws NamingException {
        return SessionValidationService.IsLogged((HttpSession)ses);
    }
}
