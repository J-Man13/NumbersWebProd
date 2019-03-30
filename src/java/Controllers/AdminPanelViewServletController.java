/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.Interfaces.IUpdateInsertPhoneUserFull;
import Services.UpdateInsertPhoneUserFullSqliteDb;
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
public class AdminPanelViewServletController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{ 
            
            String contactNumberToAdd = request.getParameter("contactNumberToAdd");
            String contactNameToAdd = request.getParameter("contactNameToAdd");
            String contactNameAzeToAdd = request.getParameter("contactNameAzeToAdd");
            String contactDepartmentToAdd = request.getParameter("contactDepartmentToAdd");
            String contactSpecialtyToAdd = request.getParameter("contactSpecialtyToAdd");
            String contactStructureToAdd = request.getParameter("contactStructureToAdd");                       
            String contactRooomToAdd = request.getParameter("contactRooomToAdd");
            String contactEmailToAdd = request.getParameter("contactEmailToAdd");

            IUpdateInsertPhoneUserFull update = new UpdateInsertPhoneUserFullSqliteDb();            
            out.println(update.updateInsertPhoneUserFull(contactNumberToAdd, contactNameToAdd, contactNameAzeToAdd, contactDepartmentToAdd, contactSpecialtyToAdd, contactStructureToAdd, contactRooomToAdd, contactEmailToAdd));
        
        } catch (Exception ex) {            
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            out.println(ex.getMessage());
        }
    }

}
