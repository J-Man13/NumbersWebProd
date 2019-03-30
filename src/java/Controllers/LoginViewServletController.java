/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jafar.j
 */
public class LoginViewServletController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            Context ctx = new InitialContext();
            Context env = (Context) ctx.lookup("java:comp/env");       
            String adminPass = (String) env.lookup("AdminSecret");                  
            String toValidate = request.getParameter("adminpass");
            Thread.sleep(5000);
            if(toValidate.equals(adminPass)){               
                HttpSession session = request.getSession();
                session = request.getSession();
                session.setAttribute("adminPass", adminPass);                
            }
            else{         
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
        }catch (NamingException ex) {
             Logger.getLogger(LoginViewServletController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginViewServletController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
