<%-- 
    Document   : AdminPanelView
    Created on : Oct 15, 2018, 12:39:05 PM
    Author     : jafar.j
--%>


<%@page import="Models.PhoneUserFull"%>
<%@page import="Services.GetAsteriskUsersWebJsonService"%>
<%@page import="Services.GetPhoneUsersFullSqliteDbService"%>
<%@page import="Services.GetPhoneUsersFullSynchronized"%>
<%@page import="Controllers.AdminPanelViewController"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include  file="header.html" %>
    <link href="../CSS/AdminPanelView.css" rel="stylesheet">
    <script src="../JS/jquery-3.3.1.js"></script>
    <script src="../JS/AdminPanelInputer.js"></script>
    <script src="../JS/AdminPanelViewFind.js"></script>
    
    <%if(!AdminPanelViewController.IsLogged(request.getSession()))
                response.sendRedirect("/NumbersWeb");
    %>
    
        <div class="searchers">
            <div class="searchers-name">
                <spawn class="searchers-name-inscription">Search</spawn>
                <input id = "search-by-name-id1" type="text" class="searchbox-name" onkeydown="find(event)">
            </div>
        </div>
    
        <div class="contacts">   

            <div class="contacts-container">
            <% 
                try{
                    AdminPanelViewController adminPanelViewСontroller = new AdminPanelViewController(new GetPhoneUsersFullSynchronized(new GetPhoneUsersFullSqliteDbService(), new GetAsteriskUsersWebJsonService()));
                    Iterable<PhoneUserFull> iterables = adminPanelViewСontroller.getPhoneUsersFull();
                    int i = 0;
                    for(PhoneUserFull phoneUserFull : iterables){
            %>
                        <div id="contact<%=i%>" class="contacts-container-phone-user">       
                            <div class="contacts-container-phone-user-number">                               
                                <spawn id="contact-number<%=i%>" class="contacts-container-phone-user-number-spawn"> <%=phoneUserFull.getPhoneUserNumber()%></spawn>
                            </div>
                            <div class="contacts-container-phone-user-name">
                                <spawn id="contact-name<%=i%>" class="contacts-container-phone-user-name-spawn"><%=phoneUserFull.getPhoneUserName()%></spawn>
                            </div>
                            <div class="contacts-container-phone-user-name-aze">
                                <spawn id="fullname-desriptor">Full Name</spawn><br>
                                <input id="contact-name-aze<%=i%>" type="text" value="<%=phoneUserFull.getPhoneUserNameAZE()%>">
                            </div>
                            <div class="contacts-container-phone-user-department">
                                <spawn id="department-desriptor">Department</spawn><br>
                                <input id="contact-department<%=i%>" type="text" value="<%=phoneUserFull.getPhoneUserDepartment()%>">
                            </div>
                            <div class="contacts-container-phone-user-specialty">
                                <spawn id="specialty-desriptor">Specialty</spawn><br>
                                <input id="contact-specialty<%=i%>" type="text" value="<%=phoneUserFull.getPhoneUserSpecialty()%>">
                            </div>
                           <div class="contacts-container-phone-user-structure">
                               <spawn id="structure-desriptor">Structure</spawn><br>
                               <input id="contact-structure<%=i%>" type="text" value="<%=phoneUserFull.getPhoneUserStructure()%>">
                            </div>
                            <div class="contacts-container-phone-user-email">
                               <spawn id="email-desriptor">Email</spawn><br>
                               <input id="contact-email<%=i%>" type="text" value="<%=phoneUserFull.getPhoneUserEmail()%>">
                            </div>                            
                            <div class="contacts-container-phone-user-button">
                                <button id="contact-button<%=i%>" class="contacts-container-phone-user-button-submit" onclick="insertUpdatePhoneUserFull(this.id)">Submit</button>
                            </div>
                        </div>
                    <%i++;}%>
                <%}catch(Exception e){%>
                    <h1><%= e.toString()%></h1>
                <%}%>           
            </div>            
        </div>    
    
    
    
<%@include  file="footer.html"%>