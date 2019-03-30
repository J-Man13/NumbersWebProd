/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;


import Services.GetAsteriskUsersWebJsonService;
import Services.GetPhoneUsersFullSqliteDbService;
import Services.GetPhoneUsersFullSynchronized;
import Services.Interfaces.IGetPhoneUsersFullSynchronized;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jafar.j
 */
public class GetAllEmloyees extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();       
        try {            
            IGetPhoneUsersFullSynchronized iGetPhoneUsersFullSynchronized = new GetPhoneUsersFullSynchronized(new GetPhoneUsersFullSqliteDbService(), new GetAsteriskUsersWebJsonService());
            ObjectMapper mapper = new ObjectMapper();
            out.print(mapper.writeValueAsString(iGetPhoneUsersFullSynchronized.GetPhoneUsersFullSynchronized()));            
        } catch (Exception ex) {
            out.print(ex.getMessage());
        }
        
        out.close();
    }




}
